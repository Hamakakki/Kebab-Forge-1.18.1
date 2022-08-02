package net.hamakakki13.forgekebab.recipe;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ForgeKebab.MOD_ID);

    public static final RegistryObject<RecipeSerializer<Kebab_PaistinRecipe>> KEBAB_PAISTIN_SERIALIZER =
            SERIALIZERS.register("kebab_paistoa", () -> Kebab_PaistinRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
     //   Registry.register(Registry.RECIPE_TYPE, Kebab_PaistinRecipe.Type.ID, Kebab_PaistinRecipe.Type.INSTANCE);
    }
}