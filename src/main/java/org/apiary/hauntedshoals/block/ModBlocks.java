package org.apiary.hauntedshoals.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModBlocks {
    //HAUNTED WOODSET
    public static final Block HAUNTED_PLANKS = registerBlock("haunted_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.LIME).nonOpaque().luminance(state -> 1)));
    public static final Block HAUNTED_STAIRS = registerBlock("haunted_stairs", new StairsBlock(ModBlocks.HAUNTED_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.LIME).nonOpaque().luminance(state -> 1)));
    public static final Block HAUNTED_SLAB = registerBlock("haunted_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(MapColor.LIME).nonOpaque().luminance(state -> 1)));
    public static final Block HAUNTED_FENCE = registerBlock("haunted_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.LIME).nonOpaque().luminance(state -> 1)));
    public static final Block HAUNTED_FENCE_GATE = registerBlock("haunted_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.LIME).nonOpaque().luminance(state -> 1)));
    public static final Block HAUNTED_PRESSURE_PLATE = registerBlock("haunted_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.LIME).nonOpaque().luminance(state -> 1)));
    public static final Block HAUNTED_BUTTON = registerBlock("haunted_button", new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.LIME).nonOpaque().luminance(state -> 1)));
    //DARK HAUNTED WOODSET
    public static final Block DARK_HAUNTED_PLANKS = registerBlock("dark_haunted_planks", new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GREEN).nonOpaque().luminance(state -> 1)));
    public static final Block DARK_HAUNTED_STAIRS = registerBlock("dark_haunted_stairs", new StairsBlock(ModBlocks.DARK_HAUNTED_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GREEN).nonOpaque().luminance(state -> 1)));
    public static final Block DARK_HAUNTED_SLAB = registerBlock("dark_haunted_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GREEN).nonOpaque().luminance(state -> 1)));
    public static final Block DARK_HAUNTED_FENCE = registerBlock("dark_haunted_fence", new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GREEN).nonOpaque().luminance(state -> 1)));
    public static final Block DARK_HAUNTED_FENCE_GATE = registerBlock("dark_haunted_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GREEN).nonOpaque().luminance(state -> 1)));
    public static final Block DARK_HAUNTED_PRESSURE_PLATE = registerBlock("dark_haunted_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GREEN).nonOpaque().luminance(state -> 1)));
    public static final Block DARK_HAUNTED_BUTTON = registerBlock("dark_haunted_button", new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GREEN).nonOpaque().luminance(state -> 1)));

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