package com.hardend.diamond.item;

import com.hardend.diamond.screen.GrimoireScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class GrimoireItem extends Item {
    public GrimoireItem(Settings settings) { super(settings); }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) openGrimoire();
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Environment(EnvType.CLIENT)
    private void openGrimoire() {
        MinecraftClient.getInstance().setScreen(new GrimoireScreen());
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Rechtsklik om te openen").formatted(Formatting.AQUA));
        tooltip.add(Text.literal("Zoek alle powers van het Hardend Diamond Set").formatted(Formatting.DARK_GRAY, Formatting.ITALIC));
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.literal("✦ Grimoire of Powers ✦");
    }
}
