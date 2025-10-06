package org.apiary.hauntedshoals.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.effect.custom.HauntedEffect;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> HAUNTED = registerStatusEffect("haunted",
            new HauntedEffect(StatusEffectCategory.NEUTRAL, 0x36ebab));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(ModCommonInit.MOD_ID, name), statusEffect);
    }

    public static void registerModEffects() {
        //ModCommonInit.LOGGER.info("Registering Mod Effects for " + ModCommonInit.MOD_ID);
    }
}
