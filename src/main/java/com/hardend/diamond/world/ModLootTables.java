package com.hardend.diamond.world;

import com.hardend.diamond.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTables {
    private static final Identifier END_CITY_CHEST =
            Identifier.ofVanilla("chests/end_city_treasure");

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.getValue().equals(END_CITY_CHEST)) {
                tableBuilder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.HARDEND_DIAMOND).weight(1))
                        .with(EmptyEntry.builder().weight(15))
                );
                tableBuilder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.HARDEND_NETHERITE_INGOT).weight(1))
                        .with(EmptyEntry.builder().weight(49))
                );
            }
        });
    }
}
