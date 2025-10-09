package org.apiary.hauntedshoals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HAUNTED_SAILS);
        //HAUNTED WOODSET
        blockStateModelGenerator.registerLog(ModBlocks.HAUNTED_LOG).log(ModBlocks.HAUNTED_LOG).wood(ModBlocks.HAUNTED_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_HAUNTED_LOG).log(ModBlocks.STRIPPED_HAUNTED_LOG).wood(ModBlocks.STRIPPED_HAUNTED_WOOD);
        BlockStateModelGenerator.BlockTexturePool haunted_planks_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.HAUNTED_PLANKS);
        haunted_planks_pool.stairs(ModBlocks.HAUNTED_STAIRS);
        haunted_planks_pool.slab(ModBlocks.HAUNTED_SLAB);
        haunted_planks_pool.fence(ModBlocks.HAUNTED_FENCE);
        haunted_planks_pool.fenceGate(ModBlocks.HAUNTED_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.HAUNTED_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.HAUNTED_TRAPDOOR);
        haunted_planks_pool.pressurePlate(ModBlocks.HAUNTED_PRESSURE_PLATE);
        haunted_planks_pool.button(ModBlocks.HAUNTED_BUTTON);
        //DARK HAUNTED WOODSET
        blockStateModelGenerator.registerLog(ModBlocks.DARK_HAUNTED_LOG).log(ModBlocks.DARK_HAUNTED_LOG).wood(ModBlocks.DARK_HAUNTED_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DARK_HAUNTED_LOG).log(ModBlocks.STRIPPED_DARK_HAUNTED_LOG).wood(ModBlocks.STRIPPED_DARK_HAUNTED_WOOD);
        BlockStateModelGenerator.BlockTexturePool dark_haunted_planks_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DARK_HAUNTED_PLANKS);
        dark_haunted_planks_pool.stairs(ModBlocks.DARK_HAUNTED_STAIRS);
        dark_haunted_planks_pool.slab(ModBlocks.DARK_HAUNTED_SLAB);
        dark_haunted_planks_pool.fence(ModBlocks.DARK_HAUNTED_FENCE);
        dark_haunted_planks_pool.fenceGate(ModBlocks.DARK_HAUNTED_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.DARK_HAUNTED_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.DARK_HAUNTED_TRAPDOOR);
        dark_haunted_planks_pool.pressurePlate(ModBlocks.DARK_HAUNTED_PRESSURE_PLATE);
        dark_haunted_planks_pool.button(ModBlocks.DARK_HAUNTED_BUTTON);
        //GHOST CORAL
        blockStateModelGenerator.registerCoral(
                ModBlocks.GHOST_CORAL, ModBlocks.DEAD_GHOST_CORAL,
                ModBlocks.GHOST_CORAL_BLOCK, ModBlocks.DEAD_GHOST_CORAL_BLOCK,
                ModBlocks.GHOST_CORAL_FAN, ModBlocks.DEAD_GHOST_CORAL_FAN,
                ModBlocks.GHOST_CORAL_WALL_FAN, ModBlocks.DEAD_GHOST_CORAL_WALL_FAN
                );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //CURSED SEAGLASS
        itemModelGenerator.register(ModItems.CURSED_SEAGLASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURSED_SEAGLASS_STAFF, Models.HANDHELD);
        //CUTLASSES
        itemModelGenerator.register(ModItems.WOOD_CUTLASS, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_CUTLASS, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_CUTLASS, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_CUTLASS, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_CUTLASS, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_CUTLASS, Models.HANDHELD);
    }
}
