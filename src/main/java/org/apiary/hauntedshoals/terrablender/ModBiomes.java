package org.apiary.hauntedshoals.terrablender;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModBiomes {
    public static final RegistryKey<Biome> HAUNTED_SHOALS = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(ModCommonInit.MOD_ID, "haunted_shoals"));
}
