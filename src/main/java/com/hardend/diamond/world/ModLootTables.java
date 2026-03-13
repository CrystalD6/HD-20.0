package com.hardend.diamond.world;

import com.hardend.diamond.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTables {

    // Vanilla end city chest loot table id
    private static final Identifier END_CITY_CHEST =
            Identifier.ofVanilla("chests/end_city_treasure");

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.getValue().equals(END_CITY_CHEST)) {

                // ~6% chance for hardend diamond
                tableBuilder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.HARDEND_DIAMOND).weight(1))
                        .with(net.minecraft.loot.entry.EmptyEntry.builder().weight(15))
                );

                // ~2% chance for hardend netherite ingot
                tableBuilder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.HARDEND_NETHERITE_INGOT).weight(1))
                        .with(net.minecraft.loot.entry.EmptyEntry.builder().weight(49))
                );
            }
        });
    }
}
