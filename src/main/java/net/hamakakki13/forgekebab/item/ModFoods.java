package net.hamakakki13.forgekebab.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RANSKALAISET = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();

    public static final FoodProperties RISTIKKOPERUNAT = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();

    public static final FoodProperties RULLA_KEBAB = (new FoodProperties.Builder()).nutrition(15).saturationMod(2F).effect(new MobEffectInstance(MobEffects.SATURATION, 1000, 2), 0.5F).meat().build();

    public static final FoodProperties RANSKALAIS_KEBAB = (new FoodProperties.Builder()).nutrition(15).saturationMod(2F).effect(new MobEffectInstance(MobEffects.SATURATION, 1000, 2), 0.5F).meat().build();

    public static final FoodProperties RISTIKKO_KEBAB = (new FoodProperties.Builder()).nutrition(15).saturationMod(2F).effect(new MobEffectInstance(MobEffects.SATURATION, 1000, 2), 0.5F).meat().build();

    public static final FoodProperties KEBAB_SUIKALEET = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).alwaysEat().build();

    public static final FoodProperties KEBAB_POTKILO = (new FoodProperties.Builder()).nutrition(20).saturationMod(5F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1440, 3), 0.9F).meat().build();

    public static final FoodProperties PITA = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).fast().alwaysEat().build();

    public static final FoodProperties ASEISTETTU_KEBAB = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.5F).fast().alwaysEat().build();

    public static final FoodProperties HAKATTAVA_KEBAB = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.5F).fast().alwaysEat().build();
}
