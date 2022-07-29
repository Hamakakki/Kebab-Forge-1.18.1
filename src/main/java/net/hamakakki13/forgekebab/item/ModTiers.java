package net.hamakakki13.forgekebab.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier KEBAB = new ForgeTier(5, 2500, 11f, 5f, 30,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.KEBAB_SUIKALEET.get()));

}
