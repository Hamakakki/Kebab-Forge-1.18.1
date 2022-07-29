package net.hamakakki13.forgekebab.block.entity;

import net.hamakakki13.forgekebab.ForgeKebab;
import net.hamakakki13.forgekebab.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ForgeKebab.MOD_ID);

    public static final RegistryObject<BlockEntityType<Kebab_PaistinBlockEntity>> KEBAB_PAISTIN =
        BLOCK_ENTITIES.register("kebab_paistin", () ->
            BlockEntityType.Builder.of(Kebab_PaistinBlockEntity::new,
                    ModBlocks.KEBAB_PAISTIN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }


}
