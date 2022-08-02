package net.hamakakki13.forgekebab.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class CraftingItem extends Item {

    public CraftingItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
       // itemStack.hurt(1, new Random(), null);
        return itemStack;
    }


    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TextComponent("This item is used in crafting"));
        } else {
            pTooltipComponents.add(new TextComponent("Press shift."));
        }
    }
}

