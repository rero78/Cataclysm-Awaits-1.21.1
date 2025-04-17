package net.foxtrot.cataclysmawaits.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.entity.custom.MushletEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MushletModel<T extends MushletEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "mushlet"), "main");
    private final ModelPart main;
    private final ModelPart lleg;
    private final ModelPart rleg;
    private final ModelPart stem;
    private final ModelPart cap;

    public MushletModel(ModelPart root) {
        this.main = root.getChild("main");
        this.lleg = this.main.getChild("lleg");
        this.rleg = this.main.getChild("rleg");
        this.stem = this.main.getChild("stem");
        this.cap = this.stem.getChild("cap");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 33).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition lleg = main.addOrReplaceChild("lleg", CubeListBuilder.create().texOffs(16, 49).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 6.0F, 0.0F));

        PartDefinition rleg = main.addOrReplaceChild("rleg", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 6.0F, 0.0F));

        PartDefinition stem = main.addOrReplaceChild("stem", CubeListBuilder.create().texOffs(40, 33).addBox(-3.5F, -6.0F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cap = stem.addOrReplaceChild("cap", CubeListBuilder.create().texOffs(0, 18).addBox(-6.5F, 0.5F, -6.5F, 13.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(40, 47).addBox(-3.5F, -7.5F, -3.5F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.5F, -4.5F, -6.5F, 13.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(MushletEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(MushletAnimations.ANIM_MUSHLET_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, MushletAnimations.ANIM_MUSHLET_IDLE, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.main.yRot = headYaw * ((float)Math.PI / 180f);
        this.main.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public ModelPart root() {
        return main;
    }
}
