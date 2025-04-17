package net.foxtrot.cataclysmawaits.entity.custom;

import net.foxtrot.cataclysmawaits.entity.ModEntities;
import net.foxtrot.cataclysmawaits.entity.MushletVariant;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.Nullable;

public class MushletEntity extends Animal {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(MushletEntity.class, EntityDataSerializers.INT);

    public MushletEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(Items.CARROT), true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(5, new AvoidEntityGoal<>(
                this,
                Player.class,
                8.0F,
                1.2D,
                1.5D
        ));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 0.125D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.KNOCKBACK_RESISTANCE, -2D);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.CARROT);
    }



    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        MushletEntity baby = ModEntities.MUSHLET.get().create(level);
        if (baby != null) {
            baby.setVariant(this.getVariant());
        }
        return baby;
    }


    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }



    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public MushletVariant getVariant() {
        return MushletVariant.byID(this.getTypeVariant() & 255);
    }

    private void setVariant(MushletVariant variant) {
        this.entityData.set(VARIANT, variant.getID() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
    }

    public static MushletVariant[] getNeutralVariants() {
        return new MushletVariant[] {
                MushletVariant.BROWN,
                MushletVariant.RED2,
                MushletVariant.RED
                // Whatever your non-biome-locked variants are
        };
    }


    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        Holder<Biome> biomeHolder = level.getBiome(this.blockPosition());
        assignVariantByBiome(biomeHolder);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }


    public static boolean canSpawnOnMycelium(EntityType<MushletEntity> type, ServerLevelAccessor level, MobSpawnType reason, BlockPos pos, RandomSource random) {
        BlockState below = level.getBlockState(pos.below());
        boolean validBlock = below.is(Blocks.MYCELIUM) || below.is(BlockTags.ANIMALS_SPAWNABLE_ON);
        boolean lightCheck = level.getBrightness(LightLayer.SKY, pos) > 8; // or level.getRawBrightness(pos, 0)
        return validBlock && lightCheck;
    }



    private void assignVariantByBiome(Holder<Biome> biomeHolder) {
        ResourceKey<Biome> biomeKey = biomeHolder.unwrapKey().orElse(null);

        if (biomeKey != null) {
            if (biomeKey.equals(Biomes.MUSHROOM_FIELDS)) {
                this.setVariant(Util.getRandom(new MushletVariant[] {
                        MushletVariant.values()[0],
                        MushletVariant.values()[1],
                        MushletVariant.values()[2]
                }, this.random));
            } else if (biomeKey.equals(Biomes.WARPED_FOREST)) {
                this.setVariant(MushletVariant.WARPED);
            } else if (biomeKey.equals(Biomes.CRIMSON_FOREST)) {
                this.setVariant(MushletVariant.CRIMSON);
            }
            else {
                this.setVariant(Util.getRandom(new MushletVariant[]{
                        MushletVariant.values()[0],
                        MushletVariant.values()[1],
                        MushletVariant.values()[2]
                }, this.random));
            }
        }

        System.out.println("Biome: " + biomeKey);
        System.out.println("Assigned: " + this.getVariant());

    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);

    }

    @Override
    protected ResourceKey<LootTable> getDefaultLootTable() {
        return ResourceKey.create(
                Registries.LOOT_TABLE,
                ResourceLocation.fromNamespaceAndPath("cataclysmawaits", "entities/mushlet")
        );
    }

}

