package org.apiary.hauntedshoals.effect.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModPotions {
    public static final RegistryEntry<Potion> HAUNTED_POTION = registerPotion("haunted_potion",
            new Potion(new StatusEffectInstance(org.apiary.hauntedshoals.effect.ModEffects.HAUNTED, 3600, 0)));
    public static final RegistryEntry<Potion> LONG_HAUNTED_POTION = registerPotion("long_haunted_potion",
            new Potion(new StatusEffectInstance(org.apiary.hauntedshoals.effect.ModEffects.HAUNTED, 9600, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(ModCommonInit.MOD_ID, name), potion);
    }

    public static void registerModPotions() {
        //ModCommonInit.LOGGER.info("Registering Mod Potions for " + ModCommonInit.MOD_ID);
    }
}
