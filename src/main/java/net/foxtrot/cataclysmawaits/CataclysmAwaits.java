package net.foxtrot.cataclysmawaits;

import com.mojang.logging.LogUtils;
import net.foxtrot.cataclysmawaits.block.ModBlocks;
import net.foxtrot.cataclysmawaits.block.entity.ModBlockEntities;
import net.foxtrot.cataclysmawaits.entity.ModEntities;
import net.foxtrot.cataclysmawaits.entity.client.MushboomRenderer;
import net.foxtrot.cataclysmawaits.entity.client.MushletRenderer;
import net.foxtrot.cataclysmawaits.sound.ModSounds;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.foxtrot.cataclysmawaits.block.entity.ModBlockEntities;
import net.foxtrot.cataclysmawaits.block.entity.SpecialFrogBlockEntity;
import net.foxtrot.cataclysmawaits.client.renderer.SpecialFrogRenderer;
import net.foxtrot.cataclysmawaits.item.ModCreativeModeTabs;
import net.foxtrot.cataclysmawaits.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/neoforge.mods.toml file x
@Mod(CataclysmAwaits.MOD_ID)
public class CataclysmAwaits
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "cataclysmawaits";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CataclysmAwaits(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (CataclysmAwaits) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModSounds.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        ModEntities.register(modEventBus);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }



    private void clientSetup(final FMLClientSetupEvent event) {
    }
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.MUSHLET.get(), MushletRenderer::new);
            EntityRenderers.register(ModEntities.MUSHBOOM.get(), MushboomRenderer::new);

            // Register block entity renderer for SpecialFrog
            BlockEntityRenderers.register(
                    ModBlockEntities.SPECIAL_FROG_BLOCK_ENTITY.get(),
                    ignoredContext -> new SpecialFrogRenderer()
            );


        }

    }


}
