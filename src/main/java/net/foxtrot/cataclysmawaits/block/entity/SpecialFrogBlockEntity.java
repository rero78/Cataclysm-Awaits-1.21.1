package net.foxtrot.cataclysmawaits.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SpecialFrogBlockEntity extends BlockEntity implements GeoAnimatable {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SpecialFrogBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SPECIAL_FROG_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // No animations, so leave this empty
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object object) {
        return this.getLevel() != null ? this.getLevel().getGameTime() : 0;
    }
}
