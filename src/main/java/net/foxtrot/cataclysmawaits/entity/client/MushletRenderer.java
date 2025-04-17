package net.foxtrot.cataclysmawaits.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.entity.MushletVariant;
import net.foxtrot.cataclysmawaits.entity.custom.MushletEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class MushletRenderer extends MobRenderer<MushletEntity, MushletModel<MushletEntity>> {
    public static final Map<MushletVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(MushletVariant.class), map -> {
                map.put(MushletVariant.BROWN,
                        ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "textures/entity/mushlet/mushlet_brown.png"));
                map.put(MushletVariant.RED,
                        ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "textures/entity/mushlet/mushlet_red.png"));
                map.put(MushletVariant.RED2,
                        ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "textures/entity/mushlet/mushlet_red2.png"));
                map.put(MushletVariant.CRIMSON,
                        ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "textures/entity/mushlet/mushlet_crimson.png"));
                map.put(MushletVariant.WARPED,
                        ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "textures/entity/mushlet/mushlet_warped.png"));
            });

    public MushletRenderer(EntityRendererProvider.Context context) {
        super(context, new MushletModel<>(context.bakeLayer(MushletModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(MushletEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(MushletEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}