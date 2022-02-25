package net.hamakakki13.forgekebab.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab KEBAB_TAB = new CreativeModeTab("kebabtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.KEBAB_POTKILO.get());
        }
    };

}
