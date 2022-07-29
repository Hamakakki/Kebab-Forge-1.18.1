package net.hamakakki13.forgekebab.util;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> KEBAB_PALIKAT = tag("kebab_palikat");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ForgeKebab.MOD_ID, name));

        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }


    public static class Items {
        public static final TagKey<Item> KEBAB_FOODS = forgeTag("foods/kebab");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ForgeKebab.MOD_ID, name));

        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

    }

}

