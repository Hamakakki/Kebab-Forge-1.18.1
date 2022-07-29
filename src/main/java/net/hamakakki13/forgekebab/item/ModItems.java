package net.hamakakki13.forgekebab.item;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.hamakakki13.forgekebab.entity.ModEntityTypes;
import net.hamakakki13.forgekebab.item.custom.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForgeKebab.MOD_ID);

    public static final RegistryObject<Item> KEBAB_SUIKALEET = ITEMS.register("kebab_suikaleet",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.KEBAB_SUIKALEET)));

    public static final RegistryObject<Item> KEBAB_POTKILO = ITEMS.register("kebab_potkilo",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.KEBAB_POTKILO)));

    public static final RegistryObject<Item> RULLA_KEBAB = ITEMS.register("rulla_kebab",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.RULLA_KEBAB)));

    public static final RegistryObject<Item> RISTIKKO_KEBAB = ITEMS.register("ristikko_kebab",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.RISTIKKO_KEBAB)));

    public static final RegistryObject<Item> RANSKALAIS_KEBAB = ITEMS.register("ranskalais_kebab",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.RANSKALAIS_KEBAB)));

    public static final RegistryObject<Item> PITA = ITEMS.register("pita",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.PITA)));

    public static final RegistryObject<Item> RANSKALAIS_CUTTER = ITEMS.register("ranskalais_cutter",
            () -> new CraftingItem(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).durability(12)));

    public static final RegistryObject<Item> RISTIKKO_CUTTER = ITEMS.register("ristikko_cutter",
            () -> new CraftingItem(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).durability(12)));

    public static final RegistryObject<Item> RANSKALAISET = ITEMS.register("ranskalaiset",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.RANSKALAISET)));

    public static final RegistryObject<Item> RISTIKKOPERUNAT = ITEMS.register("ristikkoperunat",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.RISTIKKOPERUNAT)));

    public static final RegistryObject<Item> ASEISTETTU_KEBAB = ITEMS.register("aseistettu_kebab",
            () -> new AseistettuKebab(ModTiers.KEBAB, 5, 2,
                    new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.ASEISTETTU_KEBAB)));

    public static final RegistryObject<Item> HAKKAUS_KEBAB = ITEMS.register("hakkaus_kebab",
            () -> new HakkausKebab(ModTiers.KEBAB, 0, 1f,
                    new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.HAKATTAVA_KEBAB)));

    public static final RegistryObject<Item> KEBABNITE_LAKKI = ITEMS.register("kebabnite_lakki",
            () -> new ModArmorItem(ModArmorMaterials.KEBABNITE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.ASEISTETTU_KEBAB)));

    public static final RegistryObject<Item> KEBABNITE_RINNAT = ITEMS.register("kebabnite_rinnat",
            () -> new ArmorItem(ModArmorMaterials.KEBABNITE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.ASEISTETTU_KEBAB)));

    public static final RegistryObject<Item> KEBABNITE_HOUSUT = ITEMS.register("kebabnite_housut",
            () -> new ArmorItem(ModArmorMaterials.KEBABNITE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.ASEISTETTU_KEBAB)));

    public static final RegistryObject<Item> KEBABNITE_KENGAT = ITEMS.register("kebabnite_kengat",
            () -> new ArmorItem(ModArmorMaterials.KEBABNITE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.ASEISTETTU_KEBAB)));

    public static final RegistryObject<Item> DENSE_KEBAB = ITEMS.register("dense_kebab",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB).food(ModFoods.RULLA_KEBAB)));

    public static final RegistryObject<Item> AK = ITEMS.register("ak",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> KEBAB_ELAIN_SPAWN_EGG = ITEMS.register("kebab_elain_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KEBAB_ELAIN, 0x948e8d, 0x3b3635,
                    new Item.Properties().tab(ModCreativeModTab.KEBAB_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
