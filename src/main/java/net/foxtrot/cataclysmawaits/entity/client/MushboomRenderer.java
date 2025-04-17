package net.foxtrot.cataclysmawaits.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.entity.custom.MushboomEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MushboomRenderer extends MobRenderer<MushboomEntity, MushboomModel<MushboomEntity>> {

    public MushboomRenderer(EntityRendererProvider.Context context) {
        super(context, new MushboomModel<>(context.bakeLayer(MushboomModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(MushboomEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "textures/entity/mushboom/mushboom.png");
    }

    @Override
    public void render(MushboomEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.scale(1f, 1f, 1f);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}