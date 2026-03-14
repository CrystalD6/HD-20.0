package com.hardend.diamond.block;

import com.hardend.diamond.HardendDiamondMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block HARDEND_DIAMOND_ORE = new ExperienceDroppingBlock(
            UniformIntProvider.create(3, 7),
            AbstractBlock.Settings.create()
                    .strength(5.0f, 1200.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
    );

    public static void register() {
        Registry.register(Registries.BLOCK,
                Identifier.of(HardendDiamondMod.MOD_ID, "hardend_diamond_ore"),
                HARDEND_DIAMOND_ORE);
    }
}
