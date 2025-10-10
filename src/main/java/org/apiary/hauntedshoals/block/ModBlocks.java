package org.apiary.hauntedshoals.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.block.custom.HauntedBlocks.*;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModBlocks {
    public static final Block HAUNTED_SAILS = registerBlock("haunted_sails", new HauntedBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    //HAUNTED WOODSET
    public static final Block HAUNTED_LOG  = registerBlock("haunted_log", new HauntedPillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_WOOD  = registerBlock("haunted_wood", new HauntedPillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block STRIPPED_HAUNTED_LOG  = registerBlock("stripped_haunted_log", new HauntedPillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block STRIPPED_HAUNTED_WOOD  = registerBlock("stripped_haunted_wood", new HauntedPillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_PLANKS = registerBlock("haunted_planks", new HauntedBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_STAIRS = registerBlock("haunted_stairs", new HauntedStairsBlock(ModBlocks.HAUNTED_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_SLAB = registerBlock("haunted_slab", new HauntedSlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_FENCE = registerBlock("haunted_fence", new HauntedFenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_FENCE_GATE = registerBlock("haunted_fence_gate", new HauntedFenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_DOOR  = registerBlock("haunted_door", new HauntedDoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_TRAPDOOR = registerBlock("haunted_trapdoor", new HauntedTrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_PRESSURE_PLATE = registerBlock("haunted_pressure_plate", new HauntedPressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block HAUNTED_BUTTON = registerBlock("haunted_button", new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    //DARK HAUNTED WOODSET
    public static final Block DARK_HAUNTED_LOG  = registerBlock("dark_haunted_log", new HauntedPillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_WOOD  = registerBlock("dark_haunted_wood", new HauntedPillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block STRIPPED_DARK_HAUNTED_LOG  = registerBlock("stripped_dark_haunted_log", new HauntedPillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block STRIPPED_DARK_HAUNTED_WOOD  = registerBlock("stripped_dark_haunted_wood", new HauntedPillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_PLANKS = registerBlock("dark_haunted_planks", new HauntedBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_STAIRS = registerBlock("dark_haunted_stairs", new HauntedStairsBlock(ModBlocks.DARK_HAUNTED_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_SLAB = registerBlock("dark_haunted_slab", new HauntedSlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_FENCE = registerBlock("dark_haunted_fence", new HauntedFenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_FENCE_GATE = registerBlock("dark_haunted_fence_gate", new HauntedFenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_DOOR  = registerBlock("dark_haunted_door", new HauntedDoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_TRAPDOOR  = registerBlock("dark_haunted_trapdoor", new HauntedTrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.LIME).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_PRESSURE_PLATE = registerBlock("dark_haunted_pressure_plate", new HauntedPressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    public static final Block DARK_HAUNTED_BUTTON = registerBlock("dark_haunted_button", new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.GREEN).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never)));
    //GHOST CORAL
    public static final Block DEAD_GHOST_CORAL_BLOCK = registerBlock("dead_ghost_coral_block", new Block(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK).mapColor(MapColor.WHITE)));
    public static final Block GHOST_CORAL_BLOCK = registerBlock("ghost_coral_block", new CoralBlockBlock(ModBlocks.DEAD_GHOST_CORAL_BLOCK, AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL_BLOCK).mapColor(MapColor.WHITE)));
    public static final Block DEAD_GHOST_CORAL = registerBlock("dead_ghost_coral", new DeadCoralBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL).mapColor(MapColor.WHITE)));
    public static final Block GHOST_CORAL = registerBlock("ghost_coral", new CoralBlock(ModBlocks.DEAD_GHOST_CORAL, AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL).mapColor(MapColor.WHITE)));
    public static final Block DEAD_GHOST_CORAL_FAN = registerBlockWithoutItem("dead_ghost_coral_fan", new DeadCoralFanBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL_FAN).mapColor(MapColor.WHITE)));
    public static final Block GHOST_CORAL_FAN = registerBlockWithoutItem("ghost_coral_fan", new CoralFanBlock(ModBlocks.DEAD_GHOST_CORAL_FAN, AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL_FAN).mapColor(MapColor.WHITE)));
    public static final Block DEAD_GHOST_CORAL_WALL_FAN = registerBlockWithoutItem("dead_ghost_coral_wall_fan", new DeadCoralWallFanBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL_FAN).mapColor(MapColor.WHITE)));
    public static final Block GHOST_CORAL_WALL_FAN = registerBlockWithoutItem("ghost_coral_wall_fan", new CoralWallFanBlock(ModBlocks.DEAD_GHOST_CORAL_WALL_FAN, AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL_FAN).mapColor(MapColor.WHITE)));

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