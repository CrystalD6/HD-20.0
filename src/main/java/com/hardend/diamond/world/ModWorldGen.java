package com.hardend.diamond.world;

import com.hardend.diamond.HardendDiamondMod;
import com.hardend.diamond.block.ModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public class ModWorldGen {

    public static final RegistryKey<ConfiguredFeature<?, ?>> HARDEND_DIAMOND_ORE_KEY =
            RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,
                    Identifier.of(HardendDiamondMod.MOD_ID, "hardend_diamond_ore"));

    public static final RegistryKey<PlacedFeature> HARDEND_DIAMOND_ORE_PLACED_KEY =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE,
                    Identifier.of(HardendDiamondMod.MOD_ID, "hardend_diamond_ore_placed"));

    public static void register() {
        // Ore generation is handled via JSON datapacks (see resources/data/)
        // We just add the biome modification here to inject it into The End biomes
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                HARDEND_DIAMOND_ORE_PLACED_KEY
        );
    }
}
