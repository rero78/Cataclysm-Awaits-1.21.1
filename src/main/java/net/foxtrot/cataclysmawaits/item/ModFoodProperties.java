package net.foxtrot.cataclysmawaits.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties GLAPPLE = new FoodProperties.Builder().nutrition(3).saturationModifier(1f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000), 1f)
            .build();
    public static final FoodProperties FRIEDMUSHLETCAPCAP = new FoodProperties.Builder().nutrition(10).saturationModifier(1f).alwaysEdible().fast()
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 600), 0.05f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600), 0.10f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600), 0.10f)
            .build();
}
