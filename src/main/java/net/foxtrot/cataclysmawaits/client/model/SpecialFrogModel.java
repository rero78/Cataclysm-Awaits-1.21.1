package net.foxtrot.cataclysmawaits.client.model;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.block.entity.SpecialFrogBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.model.GeoModel;

public class SpecialFrogModel extends GeoModel<SpecialFrogBlockEntity> {

    @Override
    public ResourceLocation getTextureResource(SpecialFrogBlockEntity animatable) {
        Block block = animatable.getBlockState().getBlock();
        ResourceLocation id = BuiltInRegistries.BLOCK.getKey(block);
        return ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "textures/block/" + id.getPath() + ".png");
    }

    @Override
    public ResourceLocation getModelResource(SpecialFrogBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "geo/specialfrogs.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(SpecialFrogBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "animations/blank.animation.json");
    }

}
