package net.hamakakki13.forgekebab.block;

import net.hamakakki13.forgekebab.ForgeKebab;

import net.hamakakki13.forgekebab.block.custom.Kebab_Paistin;
import net.hamakakki13.forgekebab.item.ModCreativeModTab;
import net.hamakakki13.forgekebab.item.ModItems;
import net.hamakakki13.forgekebab.block.custom.Kebab_Kuutio;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
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


    public static final RegistryObject<Block> KEBAB_KUUTIO = registerBlock("kebab_kuutio", () -> new Kebab_Kuutio(BlockBehaviour.Properties.of(Material.CACTUS).instabreak().explosionResistance(9f).jumpFactor(3f)), ModCreativeModTab.KEBAB_TAB);

    public static final RegistryObject<Block> HARHAMUTA = registerBlock("harhamuta", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).explosionResistance(2f).jumpFactor(1f).noCollission()), ModCreativeModTab.KEBAB_TAB);


    public static final RegistryObject<Block> KEBAB_PAISTIN = registerBlock("kebab_paistin",
            () -> new Kebab_Paistin(BlockBehaviour.Properties.of(Material.METAL).strength(1f).explosionResistance(9f)
                    .requiresCorrectToolForDrops().noOcclusion()), ModCreativeModTab.KEBAB_TAB);
    //

    public static final RegistryObject<Block> KEBAB_KUKKA = registerBlock("kebab_kukka",
            () -> new FlowerBlock(MobEffects.SATURATION, 8,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModTab.KEBAB_TAB);

    public static final RegistryObject<Block> POTTED_KEBAB_KUKKA = registerBlockWithoutBlockItem("potted_kebab_kukka",
            () -> new FlowerPotBlock(null, ModBlocks.KEBAB_KUKKA,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
