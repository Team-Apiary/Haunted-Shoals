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
        //HAUNTED WOODSET
        BlockStateModelGenerator.BlockTexturePool haunted_planks_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.HAUNTED_PLANKS);
        haunted_planks_pool.stairs(ModBlocks.HAUNTED_STAIRS);
        haunted_planks_pool.slab(ModBlocks.HAUNTED_SLAB);
        haunted_planks_pool.fence(ModBlocks.HAUNTED_FENCE);
        haunted_planks_pool.fenceGate(ModBlocks.HAUNTED_FENCE_GATE);
        haunted_planks_pool.pressurePlate(ModBlocks.HAUNTED_PRESSURE_PLATE);
        haunted_planks_pool.button(ModBlocks.HAUNTED_BUTTON);
        //DARK HAUNTED WOODSET
        BlockStateModelGenerator.BlockTexturePool dark_haunted_planks_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DARK_HAUNTED_PLANKS);
        dark_haunted_planks_pool.stairs(ModBlocks.DARK_HAUNTED_STAIRS);
        dark_haunted_planks_pool.slab(ModBlocks.DARK_HAUNTED_SLAB);
        dark_haunted_planks_pool.fence(ModBlocks.DARK_HAUNTED_FENCE);
        dark_haunted_planks_pool.fenceGate(ModBlocks.DARK_HAUNTED_FENCE_GATE);
        dark_haunted_planks_pool.pressurePlate(ModBlocks.DARK_HAUNTED_PRESSURE_PLATE);
        dark_haunted_planks_pool.button(ModBlocks.DARK_HAUNTED_BUTTON);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CURSED_SEAGLASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURSED_SEAGLASS_STAFF, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_CUTLASS, Models.HANDHELD);
    }
}
