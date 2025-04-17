package net.foxtrot.cataclysmawaits.datagen;

import net.foxtrot.cataclysmawaits.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.GIL_STACK.get());
        dropSelf(ModBlocks.SIL_STACK.get());

        dropSelf(ModBlocks.GLOG.get());
        dropSelf(ModBlocks.FROX.get());
        dropSelf(ModBlocks.PROG.get());
        dropSelf(ModBlocks.DROG.get());
        dropSelf(ModBlocks.SOG.get());
        dropSelf(ModBlocks.MOG.get());
        dropSelf(ModBlocks.XROG.get());
        dropSelf(ModBlocks.SKROG.get());

//        add(ModBlocks.INSERT_BLOCK.get(),
//                block -> createOreDrop(ModBlocks.INSERT_ORE.get(), ModItems.RAW_ORE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
