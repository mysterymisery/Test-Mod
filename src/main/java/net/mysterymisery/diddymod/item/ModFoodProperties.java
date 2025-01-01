package net.mysterymisery.diddymod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CRAB_RANGOON = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(.25f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 400), 0.20f)
            .build();

    public static final FoodProperties DIDDY_DAIQUIRI = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1f)
            .alwaysEdible()
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 400), 1f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400), 1f)
            .build();

}
