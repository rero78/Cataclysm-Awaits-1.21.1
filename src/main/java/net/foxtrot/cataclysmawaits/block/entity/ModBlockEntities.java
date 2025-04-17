package net.foxtrot.cataclysmawaits.block.entity;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, CataclysmAwaits.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SpecialFrogBlockEntity>> SPECIAL_FROG_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("special_frog", () ->
                    BlockEntityType.Builder.of(
                            SpecialFrogBlockEntity::new,
                            ModBlocks.GLOG.get(),
                            ModBlocks.FROX.get(),
                            ModBlocks.PROG.get(),
                            ModBlocks.DROG.get(),
                            ModBlocks.SOG.get(),
                            ModBlocks.MOG.get(),
                            ModBlocks.XROG.get(),
                            ModBlocks.SKROG.get()
                    ).build(null)
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
