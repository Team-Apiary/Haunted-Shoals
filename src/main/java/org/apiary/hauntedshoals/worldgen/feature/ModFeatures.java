package org.apiary.hauntedshoals.worldgen.feature;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import org.apiary.hauntedshoals.init.ModCommonInit;
import org.apiary.hauntedshoals.worldgen.feature.custom.GhostCoralClawFeature;
import org.apiary.hauntedshoals.worldgen.feature.custom.GhostCoralMushroomFeature;
import org.apiary.hauntedshoals.worldgen.feature.custom.GhostCoralTreeFeature;

//TODO Fix custom coral features

public class ModFeatures {
    public static Feature<DefaultFeatureConfig> GHOST_CORAL_CLAW;
    public static Feature<DefaultFeatureConfig> GHOST_CORAL_TREE;
    public static Feature<DefaultFeatureConfig> GHOST_CORAL_MUSHROOM;

    public static void registerModFeatures() {
        GHOST_CORAL_CLAW = Registry.register(Registries.FEATURE, Identifier.of(ModCommonInit.MOD_ID, "ghost_coral_claw"), new GhostCoralClawFeature<>());
        GHOST_CORAL_TREE = Registry.register(Registries.FEATURE, Identifier.of(ModCommonInit.MOD_ID, "ghost_coral_tree"), new GhostCoralTreeFeature<>());
        GHOST_CORAL_MUSHROOM = Registry.register(Registries.FEATURE, Identifier.of(ModCommonInit.MOD_ID, "ghost_coral_mushroom"), new GhostCoralMushroomFeature<>());
    }
}
