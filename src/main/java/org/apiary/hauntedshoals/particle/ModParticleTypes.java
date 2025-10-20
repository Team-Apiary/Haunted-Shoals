package org.apiary.hauntedshoals.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModParticleTypes {

    public static final SimpleParticleType HAUNTED_SOUL = FabricParticleTypes.simple();

    static {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(ModCommonInit.MOD_ID,"haunted_soul"), HAUNTED_SOUL);
    }

    public static void registerModParticles() {
        //Impillagers.LOGGER.info("Registering Mod Particles for " + Impillagers.MOD_ID);
    }
}
