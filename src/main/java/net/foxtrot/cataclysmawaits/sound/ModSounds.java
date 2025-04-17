package net.foxtrot.cataclysmawaits.sound;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, CataclysmAwaits.MOD_ID);

    public static final Supplier<SoundEvent> MUSHLET_DEATH = registerSoundEvent("mush_die");
    public static final Supplier<SoundEvent> MUSHLET_HURT1 = registerSoundEvent("mush_hurt1");
    public static final Supplier<SoundEvent> MUSHLET_HURT2 = registerSoundEvent("mush_hurt2");
    public static final Supplier<SoundEvent> MUSHLET_AMBIENT1 = registerSoundEvent("mush_ambient1");
    public static final Supplier<SoundEvent> MUSHLET_AMBIENT2 = registerSoundEvent("mush_ambient2");

    public static final Supplier<SoundEvent> MUSHBOOM_DEATH = registerSoundEvent("mbomb_die");
    public static final Supplier<SoundEvent> MUSHBOOM_HURT1 = registerSoundEvent("mbomb_hurt1");
    public static final Supplier<SoundEvent> MUSHBOOM_HURT2 = registerSoundEvent("mbomb_hurt2");
    public static final Supplier<SoundEvent> MUSHBOOM_AMBIENT1 = registerSoundEvent("mbomb_ambient1");
    public static final Supplier<SoundEvent> MUSHBOOM_AMBIENT2 = registerSoundEvent("mbomb_ambient2");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register (IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
