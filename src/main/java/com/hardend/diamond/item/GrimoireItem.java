package com.hardend.diamond.item;

import com.hardend.diamond.screen.GrimoireScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class GrimoireItem extends Item {

    public GrimoireItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide()) {
            openGrimoire();
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Environment(EnvType.CLIENT)
    private void openGrimoire() {
        Minecraft.getInstance().setScreen(new GrimoireScreen());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext ctx, List<Component> tooltip, TooltipFlag type) {
        tooltip.add(Component.literal("Rechtsklik om te openen").withStyle(ChatFormatting.AQUA));
        tooltip.add(Component.literal("Zoek alle powers van het Hardend Diamond Set").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.literal("✦ Grimoire of Powers ✦");
    }
}
