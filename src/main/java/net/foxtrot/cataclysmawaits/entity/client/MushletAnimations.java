package net.foxtrot.cataclysmawaits.entity.client;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class MushletAnimations {

    public static final AnimationDefinition ANIM_MUSHLET_WALK = AnimationDefinition.Builder.withLength(1.2f).looping()
            .addAnimation("lleg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.1f, KeyframeAnimations.degreeVec(10.02f, -0.44f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3f, KeyframeAnimations.degreeVec(-4.96f, -0.87f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6f, KeyframeAnimations.degreeVec(-57.5f, -22f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7f, KeyframeAnimations.degreeVec(-61.26f, -43.9f, -20.14f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9f, KeyframeAnimations.degreeVec(-57.5f, -22f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("rleg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-75f, 50f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3f, KeyframeAnimations.degreeVec(-51.68f, 36.82f, 11.64f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7f, KeyframeAnimations.degreeVec(15.24f, -4.18f, 6.28f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9f, KeyframeAnimations.degreeVec(-7.23f, -7.76f, -1.52f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2f, KeyframeAnimations.degreeVec(-75f, 50f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("main",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, -12.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.1f, KeyframeAnimations.degreeVec(-10.86f, -18.83f, -0.78f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3f, KeyframeAnimations.degreeVec(8.28f, -25.16f, -1.56f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6f, KeyframeAnimations.degreeVec(-5f, 12.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7f, KeyframeAnimations.degreeVec(-16.47f, 10.46f, -7.37f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9f, KeyframeAnimations.degreeVec(8.45f, 29.83f, 2.59f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2f, KeyframeAnimations.degreeVec(-5f, -12.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("stem",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("cap",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, 0f, 15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3f, KeyframeAnimations.degreeVec(-7.5f, 0f, 15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4f, KeyframeAnimations.degreeVec(7.32f, 1.62f, -12.4f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6f, KeyframeAnimations.degreeVec(-7.11f, -2.57f, -9.93f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9f, KeyframeAnimations.degreeVec(-7.11f, -2.57f, -9.93f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(7.32f, 1.62f, -12.4f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2f, KeyframeAnimations.degreeVec(-7.5f, 0f, 15f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition ANIM_MUSHLET_IDLE = AnimationDefinition.Builder.withLength(1f).looping()
            .addAnimation("lleg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2f, KeyframeAnimations.posVec(0f, 0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("rleg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2f, KeyframeAnimations.posVec(0f, 0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("main",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2f, KeyframeAnimations.posVec(0f, -0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("stem",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -15f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("cap",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.2f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 20f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 0f, -5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -20f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}
