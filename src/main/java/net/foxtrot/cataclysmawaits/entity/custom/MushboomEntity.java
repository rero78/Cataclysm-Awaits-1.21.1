package net.foxtrot.cataclysmawaits.entity.custom;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

public class MushboomEntity extends Monster {

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState explodeAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(MushboomEntity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Boolean> CHARGING =
            SynchedEntityData.defineId(MushboomEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> SWELL =
            SynchedEntityData.defineId(MushboomEntity.class, EntityDataSerializers.INT);

    public MushboomEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 6.0F));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50d)
                .add(Attributes.MOVEMENT_SPEED, 0D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 9D);
    }
    @Override
     public boolean isPushable() {
         return false;
     }

     @Override
     public boolean canBeCollidedWith() {
         return true;
     }

     @Override
     public net.minecraft.world.level.material.PushReaction getPistonPushReaction() {
         return net.minecraft.world.level.material.PushReaction.IGNORE;
     }

     @Override
     public void aiStep() {
         super.aiStep();
         this.setDeltaMovement(0, 0, 0);
         this.hasImpulse = false;
     }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 60;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        if (!this.level().isClientSide && isCharging) {
            if (++currentSwell >= CHARGE_DURATION) {
                explode();
                this.entityData.set(CHARGING, false);
            } else {
                this.entityData.set(SWELL, currentSwell);
            }
        }

        if (this.level().isClientSide && this.entityData.get(CHARGING)) {
            int syncedSwell = this.entityData.get(SWELL);
            swellingScale = 1.0F + (float) syncedSwell / (float) CHARGE_DURATION * 0.5F;
        } else if (!this.entityData.get(CHARGING)) {
            swellingScale = 1.0F;
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
        builder.define(CHARGING, false);
        builder.define(SWELL, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    public static boolean canSpawnOnMycelium(EntityType<MushboomEntity> type, ServerLevelAccessor level, MobSpawnType reason, BlockPos pos, RandomSource random) {
        BlockState below = level.getBlockState(pos.below());
        boolean validBlock = below.is(Blocks.MYCELIUM) || below.is(BlockTags.ANIMALS_SPAWNABLE_ON);
        boolean lightCheck = level.getBrightness(LightLayer.SKY, pos) > 8;
        return validBlock && lightCheck;
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource damageSource, boolean recentlyHit) {
        super.dropCustomDeathLoot(level, damageSource, recentlyHit);
    }

    private float swellingScale = 1.0F;
    private boolean isCharging = false;
    private int currentSwell = 0;
    private static final int CHARGE_DURATION = 200;

    public boolean isCharging() {
        return this.entityData.get(CHARGING);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);
        if (!this.level().isClientSide && !this.isCharging()) {
            isCharging            = true;
            currentSwell          = 0;
            this.entityData.set(CHARGING, true);
            this.level().broadcastEntityEvent(this, (byte)10);
        }
        return result;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 10) {
            // flip the synced flag (redundant but ensures Model sees it immediately)
            this.entityData.set(CHARGING, true);
            // kick off your explode animation state right now
            this.explodeAnimationState.start(this.tickCount);
        }
    }



    public float getSwellingScale() {
        return swellingScale;
    }

    private void explode() {
        this.level().explode(this, this.getX(), this.getY(), this.getZ(), 6.0F, Level.ExplosionInteraction.MOB);
        this.discard();
    }

    @Override
    protected ResourceKey<LootTable> getDefaultLootTable() {
        return ResourceKey.create(
                Registries.LOOT_TABLE,
                ResourceLocation.fromNamespaceAndPath("cataclysmawaits", "entities/mushboom")
        );
    }
}