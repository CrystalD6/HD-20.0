package com.hardend.diamond.item;

import com.hardend.diamond.HardendDiamondMod;
import com.hardend.diamond.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ModItems {
    public static final GrimoireItem GRIMOIRE = new GrimoireItem(new Item.Properties().stacksTo(1));

    public static final Item HARDEND_DIAMOND = new Item(new Item.Properties()) {
        @Override
        public void appendHoverText(ItemStack stack, TooltipContext ctx, List<Component> tooltip, TooltipFlag type) {
            tooltip.add(Component.literal("Gevonden als erts in The End").withStyle(ChatFormatting.AQUA, ChatFormatting.ITALIC));
            tooltip.add(Component.literal("Craft: omring met 8x Netherite Scrap").withStyle(ChatFormatting.DARK_GRAY));
        }
    };

    public static final Item HARDEND_NETHERITE_INGOT = new Item(new Item.Properties()) {
        @Override
        public void appendHoverText(ItemStack stack, TooltipContext ctx, List<Component> tooltip, TooltipFlag type) {
            tooltip.add(Component.literal("Werkt zoals een Netherite Ingot").withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC));
            tooltip.add(Component.literal("Gebruik in smithing table + Hardend Upgrade Template").withStyle(ChatFormatting.DARK_GRAY));
        }
    };

    public static final Item HARDEND_UPGRADE_TEMPLATE = new Item(new Item.Properties()) {
        @Override
        public void appendHoverText(ItemStack stack, TooltipContext ctx, List<Component> tooltip, TooltipFlag type) {
            tooltip.add(Component.literal("Smithing Table: diamond gear → netherite").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
            tooltip.add(Component.literal("Dupen: dirt (boven) + netherrack (zijkanten) +").withStyle(ChatFormatting.DARK_GRAY));
            tooltip.add(Component.literal("  endstone (onder) + template (midden)").withStyle(ChatFormatting.DARK_GRAY));
        }
    };

    public static final BlockItem HARDEND_DIAMOND_ORE = new BlockItem(ModBlocks.HARDEND_DIAMOND_ORE, new Item.Properties());

    public static void register() {
        reg("grimoire",                 GRIMOIRE);
        reg("hardend_diamond",          HARDEND_DIAMOND);
        reg("hardend_netherite_ingot",  HARDEND_NETHERITE_INGOT);
        reg("hardend_upgrade_template", HARDEND_UPGRADE_TEMPLATE);
        reg("hardend_diamond_ore",      HARDEND_DIAMOND_ORE);
    }

    private static void reg(String name, Item item) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(HardendDiamondMod.MOD_ID, name), item);
    }
}
