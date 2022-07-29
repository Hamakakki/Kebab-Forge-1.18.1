package net.hamakakki13.forgekebab;

import net.hamakakki13.forgekebab.block.ModBlocks;
import net.hamakakki13.forgekebab.block.entity.ModBlockEntities;
import net.hamakakki13.forgekebab.enchantment.ModEnchantment;
import net.hamakakki13.forgekebab.entity.ModEntityTypes;
import net.hamakakki13.forgekebab.entity.client.Kebab_ElainRenderer;
import net.hamakakki13.forgekebab.item.ModItems;
import net.hamakakki13.forgekebab.recipe.ModRecipes;
import net.hamakakki13.forgekebab.screen.ModMenuTypes;
import net.hamakakki13.forgekebab.util.ModItemProperties;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ForgeKebab.MOD_ID)
public class ForgeKebab
{
    public static final String MOD_ID = "forgekebab";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();


    public ForgeKebab() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModEnchantment.register(eventBus);

        ModEntityTypes.register(eventBus);

        GeckoLib.initialize();

        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);

        ModRecipes.register(eventBus);

        eventBus.addListener(this::setup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }



    private void setup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.KEBAB_KUKKA.getId(), ModBlocks.POTTED_KEBAB_KUKKA);
            ComposterBlock.COMPOSTABLES.put(ModItems.DENSE_KEBAB.get(), 5f);
            ComposterBlock.COMPOSTABLES.put(ModItems.RANSKALAIS_KEBAB.get(), 1f);
            ComposterBlock.COMPOSTABLES.put(ModItems.RISTIKKO_KEBAB.get(), 1f);
            ComposterBlock.COMPOSTABLES.put(ModItems.RISTIKKOPERUNAT.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItems.RANSKALAISET.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItems.RULLA_KEBAB.get(), 1f);
            ComposterBlock.COMPOSTABLES.put(ModItems.KEBAB_POTKILO.get(), 1f);
            ComposterBlock.COMPOSTABLES.put(ModItems.KEBAB_SUIKALEET.get(), 0.5f);
        });

    }


}
