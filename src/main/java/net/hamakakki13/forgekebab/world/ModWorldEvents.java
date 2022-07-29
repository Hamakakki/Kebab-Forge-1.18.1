package net.hamakakki13.forgekebab.world;


import net.hamakakki13.forgekebab.ForgeKebab;
import net.hamakakki13.forgekebab.world.gen.ModEntityGeneration;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForgeKebab.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModEntityGeneration.onEntitySpawn(event);
    }
}
