package org.apiary.hauntedshoals.init;

import net.fabricmc.api.ModInitializer;
import org.apiary.hauntedshoals.block.ModBlockProperties;
import org.apiary.hauntedshoals.effect.ModEffects;
import org.apiary.hauntedshoals.effect.potion.ModPotionRecipes;
import org.apiary.hauntedshoals.effect.potion.ModPotions;
import org.apiary.hauntedshoals.item.ModItemGroups;
import org.apiary.hauntedshoals.item.ModItems;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.worldgen.feature.ModFeatures;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/*
TODO Below needs completing
Biome generation is broken outside of dev
Wraith Entity
Render Haunted Effect - E.g Glowing but with green
Haunted Block Interaction - Functional but buggy, breaking/placing haunted blocks causes a crash sometimes (Something with block particles, Buttons broke for similar reason), Path Finding is buggy
Cursed Seaglass Funtion - Currently only works on PillarBlocks
Cutlass - 3 Blocks then push back, lunge, sidestep
Haunted Chest/Barrel???

Complete Woodsets - Door textures needed
Ghost Fleet Structure - Main flagship, random ships beside it

Haunted Lantern

 */

public class ModCommonInit implements ModInitializer{
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
        ModFeatures.registerModFeatures();

        ModPotionRecipes.recipeRegister();
        ModBlockProperties.propertiesRegister();
    }
}
