package com.hardend.diamond.block;

import com.hardend.diamond.HardendDiamondMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Identifier ORE_ID = Identifier.of(HardendDiamondMod.MOD_ID, "hardend_diamond_ore");

    public static final Block HARDEND_DIAMOND_ORE = new ExperienceDroppingBlock(
            UniformIntProvider.create(3, 7),
            AbstractBlock.Settings.create()
                    .strength(5.0f, 1200.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, ORE_ID))
    );

    public static void register() {
        Registry.register(Registries.BLOCK, ORE_ID, HARDEND_DIAMOND_ORE);
    }
}
