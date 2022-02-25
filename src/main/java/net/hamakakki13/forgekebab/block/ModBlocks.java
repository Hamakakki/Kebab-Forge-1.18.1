package net.hamakakki13.forgekebab.block;

import net.hamakakki13.forgekebab.ForgeKebab;

import net.hamakakki13.forgekebab.item.ModCreativeModTab;
import net.hamakakki13.forgekebab.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ForgeKebab.MOD_ID);


    public static final RegistryObject<Block> KEBAB_KUUTIO = registerBlock("kebab_kuutio", () -> new Block(BlockBehaviour.Properties.of(Material.CACTUS).strength(2f).explosionResistance(9f).jumpFactor(25f)), ModCreativeModTab.KEBAB_TAB);

    public static final RegistryObject<Block> KEBAB_PAISTIN = registerBlock("kebab_paistin", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).explosionResistance(9f).requiresCorrectToolForDrops()), ModCreativeModTab.KEBAB_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
