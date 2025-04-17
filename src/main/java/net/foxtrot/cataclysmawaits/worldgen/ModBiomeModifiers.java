package net.foxtrot.cataclysmawaits.worldgen;

import net.foxtrot.cataclysmawaits.CataclysmAwaits;
import net.foxtrot.cataclysmawaits.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> SPAWN_MUSHLET = registerKey("spawn_mushlet");
    public static final ResourceKey<BiomeModifier> SPAWN_MUSHBOOM = registerKey("spawn_mushboom");
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_MUSHLET, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.MUSHROOM_FIELDS), biomes.getOrThrow(Biomes.DARK_FOREST), biomes.getOrThrow(Biomes.SWAMP), biomes.getOrThrow(Biomes.CRIMSON_FOREST), biomes.getOrThrow(Biomes.WARPED_FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MUSHLET.get(), 20, 2, 4))));
        context.register(SPAWN_MUSHBOOM, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.MUSHROOM_FIELDS), biomes.getOrThrow(Biomes.DARK_FOREST), biomes.getOrThrow(Biomes.SWAMP)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.MUSHLET.get(), 20, 1, 1))));

    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(CataclysmAwaits.MOD_ID, name));
    }


}
