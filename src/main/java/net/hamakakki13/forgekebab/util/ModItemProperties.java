package net.hamakakki13.forgekebab.util;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.hamakakki13.forgekebab.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.AK.get(), new ResourceLocation(ForgeKebab.MOD_ID, "on"),
                (((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f)));
    }
}
