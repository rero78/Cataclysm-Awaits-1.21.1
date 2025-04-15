package net.foxtrot.cataclysmawaits.item.client;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.item.custom.MushletCapCap;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MushletCapCapModel extends GeoModel<MushletCapCap> {
    @Override
    public ResourceLocation getModelResource(MushletCapCap animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "geo/mushletcapcap.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MushletCapCap animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "textures/armor/mushletcapcap.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MushletCapCap animatable) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "animations/mushletcapcap.animation.json");
    }
}