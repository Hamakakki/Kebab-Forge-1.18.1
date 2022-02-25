package net.hamakakki13.forgekebab.item;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForgeKebab.MOD_ID);

    public static final RegistryObject<Item> KEBAB_SUIKALEET = ITEMS.register("kebab_suikaleet",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<Item> KEBAB_POTKILO = ITEMS.register("kebab_potkilo",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<Item> RULLA_KEBAB = ITEMS.register("rulla_kebab",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<Item> RISTIKKI_KEBAB = ITEMS.register("ristikko_kebab",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<Item> RANSKALAIS_KEBAB = ITEMS.register("ranskalais_kebab",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<Item> PITA = ITEMS.register("pita",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<Item> RANSKALAIS_CUTTER = ITEMS.register("ranskalais_cutter",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<Item> RISTIKKO_CUTTER = ITEMS.register("ristikko_cutter",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<Item> RANSKALAISET = ITEMS.register("ranskalaiset",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<Item> RISTIKKOPERUNAT = ITEMS.register("ristikkoperunat",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
