package com.hardend.diamond;

import com.hardend.diamond.block.ModBlocks;
import com.hardend.diamond.item.ModItems;
import com.hardend.diamond.world.ModLootTables;
import com.hardend.diamond.world.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HardendDiamondMod implements ModInitializer {

    public static final String MOD_ID = "hardend_diamond";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final RegistryKey<ItemGroup> GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            Identifier.of(MOD_ID, "main")
    );

    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItems.register();
        ModWorldGen.register();
        ModLootTables.register();

        Registry.register(Registries.ITEM_GROUP, GROUP_KEY,
                FabricItemGroup.builder()
                        .displayName(Text.literal("Hardend Diamond Set"))
                        .icon(() -> new ItemStack(ModItems.GRIMOIRE))
                        .entries((ctx, e) -> {
                            e.add(ModItems.GRIMOIRE);
                            e.add(ModItems.HARDEND_DIAMOND);
                            e.add(ModItems.HARDEND_DIAMOND_ORE);
                            e.add(ModItems.HARDEND_NETHERITE_INGOT);
                            e.add(ModItems.HARDEND_UPGRADE_TEMPLATE);
                        })
                        .build()
        );

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) ->
                giveGrimoireIfMissing(handler.player));
        ServerPlayerEvents.AFTER_RESPAWN.register((old, neo, alive) ->
                giveGrimoireIfMissing(neo));

        LOGGER.info("Hardend Diamond Set loaded!");
    }

    private void giveGrimoireIfMissing(ServerPlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getInventory().getStack(i).isOf(ModItems.GRIMOIRE)) return;
        }
        player.getInventory().insertStack(new ItemStack(ModItems.GRIMOIRE));
    }
}
