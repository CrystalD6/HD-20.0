package com.hardend.diamond.world;

import com.hardend.diamond.HardendDiamondMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModWorldGen {
    public static final RegistryKey<PlacedFeature> HARDEND_DIAMOND_ORE_PLACED_KEY =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE,
                    Identifier.of(HardendDiamondMod.MOD_ID, "hardend_diamond_ore_placed"));

    public static void register() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                HARDEND_DIAMOND_ORE_PLACED_KEY
        );
    }
}
