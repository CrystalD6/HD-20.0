package com.hardend.diamond;

import com.hardend.diamond.block.ModBlocks;
import com.hardend.diamond.item.ModItems;
import com.hardend.diamond.world.ModLootTables;
import com.hardend.diamond.world.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HardendDiamondMod implements ModInitializer {
    public static final String MOD_ID = "hardend_diamond";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ResourceKey<CreativeModeTab> GROUP_KEY = ResourceKey.create(
            net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB,
            Identifier.of(MOD_ID, "main")
    );

    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModItems.register();
        ModWorldGen.register();
        ModLootTables.register();

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, GROUP_KEY,
                FabricItemGroup.builder()
                        .title(Component.literal("Hardend Diamond Set"))
                        .icon(() -> new ItemStack(ModItems.GRIMOIRE))
                        .displayItems((params, output) -> {
                            output.accept(ModItems.GRIMOIRE);
                            output.accept(ModItems.HARDEND_DIAMOND);
                            output.accept(ModItems.HARDEND_DIAMOND_ORE);
                            output.accept(ModItems.HARDEND_NETHERITE_INGOT);
                            output.accept(ModItems.HARDEND_UPGRADE_TEMPLATE);
                        })
                        .build()
        );

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) ->
                giveGrimoireIfMissing(handler.player));
        ServerPlayerEvents.AFTER_RESPAWN.register((old, neo, alive) ->
                giveGrimoireIfMissing(neo));

        LOGGER.info("Hardend Diamond Set loaded!");
    }

    private void giveGrimoireIfMissing(ServerPlayer player) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            if (player.getInventory().getItem(i).is(ModItems.GRIMOIRE)) return;
        }
        player.getInventory().add(new ItemStack(ModItems.GRIMOIRE));
    }
}
