package net.hamakakki13.forgekebab.entity;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.hamakakki13.forgekebab.entity.custom.Kebab_ElainEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, ForgeKebab.MOD_ID);

    public static final RegistryObject<EntityType<Kebab_ElainEntity>> KEBAB_ELAIN = ENTITY_TYPES.register("kebab_elain",
            () -> EntityType.Builder.of(Kebab_ElainEntity::new, MobCategory.CREATURE)
                    .sized(2f, 1.5f)
                    .build(new ResourceLocation(ForgeKebab.MOD_ID, "kebab_elain").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
