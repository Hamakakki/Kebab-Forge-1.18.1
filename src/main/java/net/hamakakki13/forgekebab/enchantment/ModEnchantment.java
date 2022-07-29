package net.hamakakki13.forgekebab.enchantment;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantment {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS
            = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ForgeKebab.MOD_ID);

    public static RegistryObject<Enchantment> Pako = ENCHANTMENTS.register("pako",
            () -> new PakoEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static RegistryObject<Enchantment> Sat = ENCHANTMENTS.register("safkaa",
            () -> new SatEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR, EquipmentSlot.CHEST, EquipmentSlot.FEET, EquipmentSlot.HEAD, EquipmentSlot.LEGS));


    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
