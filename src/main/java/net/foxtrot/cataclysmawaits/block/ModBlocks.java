package net.foxtrot.cataclysmawaits.block;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.block.custom.Special_Frog;
import net.foxtrot.cataclysmawaits.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CataclysmAwaits.MOD_ID);

    public static final DeferredBlock<Block> GIL_STACK = registerBlock("gil_stack",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> SIL_STACK = registerBlock("sil_stack",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Special_Frog> GLOG = BLOCKS.register("glog", Special_Frog::new);
    public static final DeferredBlock<Special_Frog> FROX = BLOCKS.register("frox", Special_Frog::new);
    public static final DeferredBlock<Special_Frog> PROG = BLOCKS.register("prog", Special_Frog::new);
    public static final DeferredBlock<Special_Frog> DROG = BLOCKS.register("drog", Special_Frog::new);
    public static final DeferredBlock<Special_Frog> SOG = BLOCKS.register("sog", Special_Frog::new);
    public static final DeferredBlock<Special_Frog> MOG = BLOCKS.register("mog", Special_Frog::new);
    public static final DeferredBlock<Special_Frog> XROG = BLOCKS.register("xrog", Special_Frog::new);
    public static final DeferredBlock<Special_Frog> SKROG = BLOCKS.register("skrog", Special_Frog::new);


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
