package net.hamakakki13.forgekebab.event.loot;

import com.google.common.eventbus.Subscribe;
import net.hamakakki13.forgekebab.ForgeKebab;
import net.hamakakki13.forgekebab.entity.ModEntityTypes;
import net.hamakakki13.forgekebab.entity.custom.Kebab_ElainEntity;
import net.hamakakki13.forgekebab.recipe.Kebab_PaistinRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.checkerframework.checker.nullness.qual.NonNull;

@Mod.EventBusSubscriber(modid = ForgeKebab.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.KEBAB_ELAIN.get(), Kebab_ElainEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, Kebab_PaistinRecipe.Type.ID, Kebab_PaistinRecipe.Type.INSTANCE);
    }
}
