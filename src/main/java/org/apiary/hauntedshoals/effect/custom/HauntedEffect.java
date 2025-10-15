package org.apiary.hauntedshoals.effect.custom;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

//TODO Implement method for changing entities colour and opacity while under this effect, may need to be done with a mixin in MobEntityRenderer or LivingEntityRenderer

public class HauntedEffect extends StatusEffect {
    public HauntedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
}
