package net.hamakakki13.forgekebab.event;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.hamakakki13.forgekebab.block.ModBlocks;
import net.hamakakki13.forgekebab.entity.ModEntityTypes;
import net.hamakakki13.forgekebab.entity.client.Kebab_ElainRenderer;
import net.hamakakki13.forgekebab.screen.Kebab_PaistinScreen;
import net.hamakakki13.forgekebab.screen.ModMenuTypes;
import net.hamakakki13.forgekebab.util.ModItemProperties;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ForgeKebab.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {






    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.KEBAB_KUKKA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_KEBAB_KUKKA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.KEBAB_PAISTIN.get(), RenderType.cutout());

        ModItemProperties.addCustomItemProperties();

        EntityRenderers.register(ModEntityTypes.KEBAB_ELAIN.get(), Kebab_ElainRenderer::new);

        MenuScreens.register(ModMenuTypes.KEBAB_PAISTIN_MENU.get(), Kebab_PaistinScreen::new);
    }
}
