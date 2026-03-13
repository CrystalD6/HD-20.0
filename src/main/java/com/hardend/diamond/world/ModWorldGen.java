package com.hardend.diamond.world;

import com.hardend.diamond.HardendDiamondMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static net.minecraft.core.registries.Registries.PLACED_FEATURE;

public class ModWorldGen {

    public static final ResourceKey<PlacedFeature> HARDEND_DIAMOND_ORE_PLACED_KEY =
            ResourceKey.create(PLACED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(HardendDiamondMod.MOD_ID, "hardend_diamond_ore_placed"));

    public static void register() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                HARDEND_DIAMOND_ORE_PLACED_KEY
        );
    }
}
