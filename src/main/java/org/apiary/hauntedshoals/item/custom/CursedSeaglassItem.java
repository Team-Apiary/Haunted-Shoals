package org.apiary.hauntedshoals.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.effect.ModEffects;

public class CursedSeaglassItem extends Item {
    public CursedSeaglassItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (entity instanceof LivingEntity livingEntity && !(livingEntity = (LivingEntity)entity).isInvulnerableTo(world.getDamageSources().wither())) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 40));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 40));
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.HAUNTED, 40));
        }
    }
}
