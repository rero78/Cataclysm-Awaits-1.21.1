package net.foxtrot.cataclysmawaits.event;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.entity.ModEntities;
import net.foxtrot.cataclysmawaits.entity.client.MushboomModel;
import net.foxtrot.cataclysmawaits.entity.client.MushletModel;
import net.foxtrot.cataclysmawaits.entity.custom.MushboomEntity;
import net.foxtrot.cataclysmawaits.entity.custom.MushletEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = CataclysmAwaits.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MushletModel.LAYER_LOCATION, MushletModel::createBodyLayer);
        event.registerLayerDefinition(MushboomModel.LAYER_LOCATION, MushboomModel::createBodyLayer);

    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MUSHLET.get(), MushletEntity.createAttributes().build());
        event.put(ModEntities.MUSHBOOM.get(), MushboomEntity.createAttributes().build());
    }
    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(
                ModEntities.MUSHLET.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (SpawnPlacements.SpawnPredicate<MushletEntity>) MushletEntity::canSpawnOnMycelium,
                RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
        event.register(
                ModEntities.MUSHBOOM.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (SpawnPlacements.SpawnPredicate<MushboomEntity>) MushboomEntity::canSpawnOnMycelium,
                RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }

}
