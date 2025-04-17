package net.foxtrot.cataclysmawaits.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.entity.custom.MushboomEntity;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;

public class MushboomModel<T extends MushboomEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, "mushboom"), "main");
    private final ModelPart main;
    private final ModelPart head;
    private float cachedScale = 1.0f;

    public MushboomModel(ModelPart root) {
        this.main = root.getChild("main");
        this.head = this.main.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 64).addBox(-6.0F, -17.0F, -6.0F, 12.0F, 17.0F, 12.0F, new CubeDeformation(0.02F))
                .texOffs(36, 66).addBox(-15.0F, -4.0F, -3.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.05F))
                .texOffs(36, 66).mirror().addBox(5.0F, -4.0F, -3.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition fanl_r1 = main.addOrReplaceChild("fanl_r1", CubeListBuilder.create().texOffs(0, 104).mirror().addBox(-20.0F, -9.0F, 0.0F, 20.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.0F, 6.0F, -0.1712F, 0.1758F, 2.2843F));

        PartDefinition fanr_r1 = main.addOrReplaceChild("fanr_r1", CubeListBuilder.create().texOffs(0, 104).addBox(0.0F, -9.0F, 0.0F, 20.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 6.0F, -0.1712F, -0.1758F, -2.2843F));

        PartDefinition loosebarkr1_r1 = main.addOrReplaceChild("loosebarkr1_r1", CubeListBuilder.create().texOffs(32, 82).mirror().addBox(-8.0F, 0.0F, -8.0F, 9.0F, 4.0F, 16.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -13.5F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition loosebarkr2_r1 = main.addOrReplaceChild("loosebarkr2_r1", CubeListBuilder.create().texOffs(76, 79).mirror().addBox(-8.0F, 0.0F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.5F, 0.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition root_r1 = main.addOrReplaceChild("root_r1", CubeListBuilder.create().texOffs(36, 66).mirror().addBox(0.0F, -4.0F, -3.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 0.0F, -4.0F, 0.0F, 1.0472F, 0.0F));

        PartDefinition root_r2 = main.addOrReplaceChild("root_r2", CubeListBuilder.create().texOffs(36, 66).mirror().addBox(0.0F, -4.0F, -3.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 0.0F, 4.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition root_r3 = main.addOrReplaceChild("root_r3", CubeListBuilder.create().texOffs(36, 66).addBox(-10.0F, -4.0F, -3.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 4.0F, 0.0F, 1.0472F, 0.0F));

        PartDefinition root_r4 = main.addOrReplaceChild("root_r4", CubeListBuilder.create().texOffs(36, 66).addBox(-10.0F, -4.0F, -3.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -4.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition loosebarkl2_r1 = main.addOrReplaceChild("loosebarkl2_r1", CubeListBuilder.create().texOffs(76, 79).addBox(-2.0F, 0.0F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.5F, 0.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition loosebarkl1_r1 = main.addOrReplaceChild("loosebarkl1_r1", CubeListBuilder.create().texOffs(32, 82).addBox(-1.0F, 0.0F, -8.0F, 9.0F, 4.0F, 16.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(3.0F, -13.5F, 0.0F, 0.0F, 0.0F, 0.48F));

        PartDefinition ltusk = main.addOrReplaceChild("ltusk", CubeListBuilder.create().texOffs(0, 26).addBox(-1.5F, -9.0F, -2.5F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 37).addBox(0.0F, -9.0F, 2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -18.0F, -6.5F));

        PartDefinition rtusk = main.addOrReplaceChild("rtusk", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-1.5F, -9.0F, -2.5F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 37).mirror().addBox(0.0F, -9.0F, 2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, -18.0F, -6.5F));

        PartDefinition cystc = main.addOrReplaceChild("cystc", CubeListBuilder.create(), PartPose.offset(4.0F, -8.5F, -7.5F));

        PartDefinition cyst1_r1 = cystc.addOrReplaceChild("cyst1_r1", CubeListBuilder.create().texOffs(68, 64).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

        PartDefinition cysta = main.addOrReplaceChild("cysta", CubeListBuilder.create(), PartPose.offset(-5.5F, -11.5F, -6.5F));

        PartDefinition cyst2_r1 = cysta.addOrReplaceChild("cyst2_r1", CubeListBuilder.create().texOffs(68, 64).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cystb = main.addOrReplaceChild("cystb", CubeListBuilder.create(), PartPose.offset(0.0F, -12.5F, 7.5F));

        PartDefinition cyst5_r1 = cystb.addOrReplaceChild("cyst5_r1", CubeListBuilder.create().texOffs(68, 64).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition head = main.addOrReplaceChild("head", CubeListBuilder.create().texOffs(72, 5).addBox(-5.0F, -10.0F, -10.0F, 10.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 5.0F));

        PartDefinition cap = head.addOrReplaceChild("cap", CubeListBuilder.create().texOffs(0, 26).addBox(-15.0F, -8.0F, -15.0F, 30.0F, 8.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-9.0F, -16.0F, -9.0F, 18.0F, 8.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -5.0F));

        PartDefinition cystd = head.addOrReplaceChild("cystd", CubeListBuilder.create(), PartPose.offset(5.0F, -5.5F, -0.5F));

        PartDefinition cyst4_r1 = cystd.addOrReplaceChild("cyst4_r1", CubeListBuilder.create().texOffs(68, 64).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.8727F, 0.0F));

        PartDefinition cyste = head.addOrReplaceChild("cyste", CubeListBuilder.create(), PartPose.offset(-7.0F, -6.5F, -5.5F));

        PartDefinition cyst3_r1 = cyste.addOrReplaceChild("cyst3_r1", CubeListBuilder.create().texOffs(68, 64).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45f);

        this.head.yRot = headYaw * ((float) Math.PI / 180f);
        this.head.xRot = headPitch * ((float) Math.PI / 180f);
    }

    @Override
    public void setupAnim(
            MushboomEntity entity,
            float limbSwing,
            float limbSwingAmount,
            float ageInTicks,
            float netHeadYaw,
            float headPitch
    ) {
        // Reset every part and rotate head
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        // Compute a global animation time (tick + partial tick)
        float animTime = entity.tickCount + ageInTicks;

        // Decide which animation to play
        AnimationState state;
        AnimationDefinition def;
        if (entity.isCharging()) {
            state = entity.explodeAnimationState;
            def   = MushboomAnimations.ANIM_MUSHBOOM_EXPLODE;
        } else {
            state = entity.idleAnimationState;
            def   = MushboomAnimations.ANIM_MUSHBOOM_IDLE;
        }

        // Drive the one animation
        this.animate(state, def, animTime, 0.4f);

        // Scale as before
        this.cachedScale = entity.isBaby() ? 0.5F : entity.getSwellingScale();
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        poseStack.pushPose();

        float scale = cachedScale;
        float yOffset = (scale - 1.0F) * 12F; // Adjust if needed
        poseStack.translate(0.0F, -yOffset / 16.0F, 0.0F); // Compensate vertical sinking
        poseStack.scale(scale, scale, scale);

        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);

        poseStack.popPose();
    }

    @Override
    public ModelPart root() {
        return main;
    }
}
