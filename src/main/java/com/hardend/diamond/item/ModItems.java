package com.hardend.diamond.item;

import com.hardend.diamond.HardendDiamondMod;
import com.hardend.diamond.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    // ── Grimoire ────────────────────────────────────────────────────────
    public static final GrimoireItem GRIMOIRE = new GrimoireItem(
            new Item.Settings().maxCount(1)
    );

    // ── Hardend Diamond (gem) ────────────────────────────────────────────
    // Drops from Hardend Diamond Ore in The End; rare chest loot
    public static final Item HARDEND_DIAMOND = new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext ctx, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.literal("Gevonden als erts in The End").formatted(Formatting.AQUA, Formatting.ITALIC));
            tooltip.add(Text.literal("Craft: omring met 8x Netherite Scrap").formatted(Formatting.DARK_GRAY));
        }
    };

    // ── Hardend Netherite Ingot ──────────────────────────────────────────
    // Crafting: Hardend Diamond (center) + 8x Netherite Scrap
    // Used: smithing table upgrade with Hardend Upgrade Template
    public static final Item HARDEND_NETHERITE_INGOT = new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext ctx, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.literal("Werkt zoals een Netherite Ingot").formatted(Formatting.LIGHT_PURPLE, Formatting.ITALIC));
            tooltip.add(Text.literal("Gebruik in smithing table + Hardend Upgrade Template").formatted(Formatting.DARK_GRAY));
        }
    };

    // ── Hardend Upgrade Template ─────────────────────────────────────────
    // Crafting: any Smithing Template (center) + 8x Hardend Diamond
    // Dupe:     dirt (top row) + netherrack (sides middle) + template (center) + end stone (bottom row)
    public static final Item HARDEND_UPGRADE_TEMPLATE = new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext ctx, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.literal("Smithing Table: diamond gear → netherite").formatted(Formatting.GOLD, Formatting.ITALIC));
            tooltip.add(Text.literal("Dupen: dirt (boven) + netherrack (zijkanten) +").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.literal("  endstone (onder) + template (midden)").formatted(Formatting.DARK_GRAY));
        }
    };

    // ── Ore block item ───────────────────────────────────────────────────
    public static final BlockItem HARDEND_DIAMOND_ORE = new BlockItem(
            ModBlocks.HARDEND_DIAMOND_ORE, new Item.Settings()
    );

    public static void register() {
        reg("grimoire",                  GRIMOIRE);
        reg("hardend_diamond",           HARDEND_DIAMOND);
        reg("hardend_netherite_ingot",   HARDEND_NETHERITE_INGOT);
        reg("hardend_upgrade_template",  HARDEND_UPGRADE_TEMPLATE);
        reg("hardend_diamond_ore",       HARDEND_DIAMOND_ORE);
    }

    private static void reg(String name, Item item) {
        Registry.register(Registries.ITEM, Identifier.of(HardendDiamondMod.MOD_ID, name), item);
    }
}
