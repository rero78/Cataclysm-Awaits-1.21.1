package net.foxtrot.cataclysmawaits.item;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CataclysmAwaits.MOD_ID);

    public static final Supplier<CreativeModeTab> CATACLYSM_AWAITS = CREATIVE_MODE_TAB.register("cataclysm_awaits_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GIL.get()))
                    .title(Component.translatable("creativetab.cataclysmawaits.cataclysm_awaits"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GIL);
                        output.accept(ModItems.SIL);
                        output.accept(ModBlocks.GIL_STACK);
                        output.accept(ModBlocks.SIL_STACK);
                        output.accept(ModItems.TOTEMOFRETURN);
                        output.accept(ModItems.GLAPPLE);
                        output.accept(ModItems.FRIEDMUSHLETCAPCAP);
                        output.accept(ModItems.MUSHLETCAPCAP);
                        output.accept(ModItems.CATACLYSTFUEL);
                        output.accept(ModItems.THEHORROR);
                        output.accept(ModItems.THE_SPOON);
                        output.accept(ModItems.MUSHLET_SPAWN_EGG);
                        output.accept(ModItems.MUSHBOOM_SPAWN_EGG);
                        output.accept(ModItems.MUSHROGLYCERIN);


                        output.accept(ModBlocks.GLOG);
                        output.accept(ModBlocks.FROX);
                        output.accept(ModBlocks.PROG);
                        output.accept(ModBlocks.DROG);
                        output.accept(ModBlocks.SOG);
                        output.accept(ModBlocks.MOG);
                        output.accept(ModBlocks.XROG);
                        output.accept(ModBlocks.SKROG);

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
