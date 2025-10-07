package org.apiary.hauntedshoals.worldgen.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.apiary.hauntedshoals.init.ModCommonInit;
import org.apiary.hauntedshoals.worldgen.feature.custom.GhostCoralClawFeature;
import org.apiary.hauntedshoals.worldgen.feature.custom.GhostCoralMushroomFeature;
import org.apiary.hauntedshoals.worldgen.feature.custom.GhostCoralTreeFeature;

import static net.minecraft.network.packet.CustomPayload.id;

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
