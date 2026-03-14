package com.hardend.diamond.item;

import com.hardend.diamond.HardendDiamondMod;
import com.hardend.diamond.block.ModBlocks;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.equipment.EquipmentType;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ModItems {

    private static Item.Settings settings(String name) {
        return new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM,
                Identifier.of(HardendDiamondMod.MOD_ID, name)));
    }

    public static final GrimoireItem GRIMOIRE = new GrimoireItem(settings("grimoire").maxCount(1));

    public static final Item HARDEND_DIAMOND = new Item(settings("hardend_diamond")) {
        public void appendTooltip(ItemStack s, TooltipContext c, List<Text> t, TooltipType tt) {
            t.add(Text.literal("Gevonden in The End").formatted(Formatting.AQUA, Formatting.ITALIC));
        }
    };

    public static final Item HARDEND_NETHERITE_INGOT = new Item(settings("hardend_netherite_ingot")) {
        public void appendTooltip(ItemStack s, TooltipContext c, List<Text> t, TooltipType tt) {
            t.add(Text.literal("Gebruik in Smithing Table").formatted(Formatting.LIGHT_PURPLE, Formatting.ITALIC));
        }
    };

    public static final Item HARDEND_UPGRADE_TEMPLATE = new Item(settings("hardend_upgrade_template")) {
        public void appendTooltip(ItemStack s, TooltipContext c, List<Text> t, TooltipType tt) {
            t.add(Text.literal("Smithing Table upgrade").formatted(Formatting.GOLD, Formatting.ITALIC));
        }
    };

    public static final BlockItem HARDEND_DIAMOND_ORE = new BlockItem(ModBlocks.HARDEND_DIAMOND_ORE, settings("hardend_diamond_ore"));

    // Tools
    public static final SwordItem HARDEND_SWORD = new SwordItem(ToolMaterials.NETHERITE, settings("hardend_sword").attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 4, -2.4f)));
    public static final PickaxeItem HARDEND_PICKAXE = new PickaxeItem(ToolMaterials.NETHERITE, settings("hardend_pickaxe").attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.8f)));
    public static final AxeItem HARDEND_AXE = new AxeItem(ToolMaterials.NETHERITE, settings("hardend_axe").attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 6, -3.1f)));
    public static final ShovelItem HARDEND_SHOVEL = new ShovelItem(ToolMaterials.NETHERITE, settings("hardend_shovel").attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -3.0f)));
    public static final HoeItem HARDEND_HOE = new HoeItem(ToolMaterials.NETHERITE, settings("hardend_hoe").attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 0, -3.0f)));

    // Armor
    public static final ArmorItem HARDEND_HELMET     = new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET,     settings("hardend_helmet"));
    public static final ArmorItem HARDEND_CHESTPLATE = new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, settings("hardend_chestplate"));
    public static final ArmorItem HARDEND_LEGGINGS   = new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS,   settings("hardend_leggings"));
    public static final ArmorItem HARDEND_BOOTS      = new ArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS,      settings("hardend_boots"));

    public static void register() {
        reg("grimoire",                  GRIMOIRE);
        reg("hardend_diamond",           HARDEND_DIAMOND);
        reg("hardend_netherite_ingot",   HARDEND_NETHERITE_INGOT);
        reg("hardend_upgrade_template",  HARDEND_UPGRADE_TEMPLATE);
        reg("hardend_diamond_ore",       HARDEND_DIAMOND_ORE);
        reg("hardend_sword",             HARDEND_SWORD);
        reg("hardend_pickaxe",           HARDEND_PICKAXE);
        reg("hardend_axe",               HARDEND_AXE);
        reg("hardend_shovel",            HARDEND_SHOVEL);
        reg("hardend_hoe",               HARDEND_HOE);
        reg("hardend_helmet",            HARDEND_HELMET);
        reg("hardend_chestplate",        HARDEND_CHESTPLATE);
        reg("hardend_leggings",          HARDEND_LEGGINGS);
        reg("hardend_boots",             HARDEND_BOOTS);
    }

    private static void reg(String name, Item item) {
        Registry.register(Registries.ITEM, Identifier.of(HardendDiamondMod.MOD_ID, name), item);
    }
}
