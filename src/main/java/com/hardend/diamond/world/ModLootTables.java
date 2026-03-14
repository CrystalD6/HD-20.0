package com.hardend.diamond.world;

import com.hardend.diamond.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModLootTables {
    private static final Identifier END_CITY_CHEST = Identifier.ofVanilla("chests/end_city_treasure");

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.location().equals(END_CITY_CHEST)) {
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.HARDEND_DIAMOND).setWeight(1))
                        .add(EmptyLootItem.emptyItem().setWeight(15))
                );
                tableBuilder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.HARDEND_NETHERITE_INGOT).setWeight(1))
                        .add(EmptyLootItem.emptyItem().setWeight(49))
                );
            }
        });
    }
}
