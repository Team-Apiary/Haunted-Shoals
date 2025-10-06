package org.apiary.hauntedshoals.init;

import net.fabricmc.api.ModInitializer;
import org.apiary.hauntedshoals.effect.ModEffects;
import org.apiary.hauntedshoals.effect.potion.ModPotions;
import org.apiary.hauntedshoals.item.ModItemGroups;
import org.apiary.hauntedshoals.item.ModItems;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/*
TODO
Render Haunted Effect
Cutlass sidestep and lunge
Haunted Block Interaction

Biome Generation
 */

public class ModCommonInit implements ModInitializer {

    public static final String MOD_ID = "haunted_shoals";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Haunted Shoals");

        ModItemGroups.registerModItemGroups();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModEffects.registerModEffects();
        ModPotions.registerModPotions();
    }
}
