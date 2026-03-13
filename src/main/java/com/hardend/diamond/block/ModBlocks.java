package com.hardend.diamond.block;

import com.hardend.diamond.HardendDiamondMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {

    public static final Block HARDEND_DIAMOND_ORE = new DropExperienceBlock(
            UniformInt.of(3, 7),
            BlockBehaviour.Properties.of()
                    .strength(5.0f, 1200.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
    );

    public static void register() {
        Registry.register(BuiltInRegistries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(HardendDiamondMod.MOD_ID, "hardend_diamond_ore"),
                HARDEND_DIAMOND_ORE);
    }
}
