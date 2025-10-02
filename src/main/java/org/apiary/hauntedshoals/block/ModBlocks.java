package org.apiary.hauntedshoals.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModBlocks {

    public static final Block HAUNTED_PLANKS = registerBlock("haunted_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.LIME)));

    //Register Methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ModCommonInit.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ModCommonInit.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(ModCommonInit.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        //ModCommonInit.LOGGER.info("Registering Mod Blocks for " + ModCommonInit.MOD_ID);
    }
}