package org.apiary.hauntedshoals.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

//TODO Implement side hop and dash functions
//TODO Implement better blocking feature (3 blocks -> cooldown)

public class CutlassItem extends SwordItem{
    public CutlassItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    /*
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }
     */
}
