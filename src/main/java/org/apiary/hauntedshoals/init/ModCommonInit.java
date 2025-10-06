package org.apiary.hauntedshoals.init;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.effect.ModEffects;
import org.apiary.hauntedshoals.effect.potion.ModPotionRecipes;
import org.apiary.hauntedshoals.effect.potion.ModPotions;
import org.apiary.hauntedshoals.item.ModItemGroups;
import org.apiary.hauntedshoals.item.ModItems;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.terrablender.ModOverworldRegion;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

/*
TODO
Render Haunted Effect
Cutlass sidestep and lunge
Haunted Block Interaction

Biome Generation

Complete Woodsets
 */

public class ModCommonInit implements ModInitializer, TerraBlenderApi{

    public static final String MOD_ID = "haunted_shoals";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing the ghost fleet");

        ModItemGroups.registerModItemGroups();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModEffects.registerModEffects();
        ModPotions.registerModPotions();
        ModPotionRecipes.recipeRegister();

    }

    @Override
    public void onTerraBlenderInitialized()
    {
        // Weights are kept intentionally low as we add minimal biomes
        Regions.register(new ModOverworldRegion(Identifier.of(MOD_ID, "overworld"), 2));
    }
}
