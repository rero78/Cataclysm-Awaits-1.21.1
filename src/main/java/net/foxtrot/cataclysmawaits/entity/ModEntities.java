package net.foxtrot.cataclysmawaits.entity;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.entity.custom.MushboomEntity;
import net.foxtrot.cataclysmawaits.entity.custom.MushletEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CataclysmAwaits.MOD_ID);

    public static final Supplier<EntityType<MushletEntity>> MUSHLET =
            ENTITY_TYPES.register("mushlet", () -> EntityType.Builder.of(MushletEntity::new, MobCategory.CREATURE)
                    .sized(0.8125f, 1.15f).build("mushlet"));
    public static final Supplier<EntityType<MushboomEntity>> MUSHBOOM =
            ENTITY_TYPES.register("mushboom", () -> EntityType.Builder.of(MushboomEntity::new, MobCategory.MONSTER)
                    .sized(1.875f, 2.625f).build("mushboom"));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}