package org.apiary.hauntedshoals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(ModTags.Blocks.HAUNTED_LOGS)
                .addTag(ModTags.Blocks.DARK_HAUNTED_LOGS);
        getOrCreateTagBuilder(ModTags.Blocks.HAUNTED_LOGS)
                .add(ModBlocks.HAUNTED_LOG)
                .add(ModBlocks.HAUNTED_WOOD)
                .add(ModBlocks.STRIPPED_HAUNTED_LOG)
                .add(ModBlocks.STRIPPED_HAUNTED_WOOD);
        getOrCreateTagBuilder(ModTags.Blocks.DARK_HAUNTED_LOGS)
                .add(ModBlocks.DARK_HAUNTED_LOG)
                .add(ModBlocks.DARK_HAUNTED_WOOD)
                .add(ModBlocks.STRIPPED_DARK_HAUNTED_LOG)
                .add(ModBlocks.STRIPPED_DARK_HAUNTED_WOOD);
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.HAUNTED_PLANKS)
                .add(ModBlocks.DARK_HAUNTED_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.HAUNTED_STAIRS)
                .add(ModBlocks.DARK_HAUNTED_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.HAUNTED_SLAB)
                .add(ModBlocks.DARK_HAUNTED_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.HAUNTED_FENCE)
                .add(ModBlocks.DARK_HAUNTED_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.HAUNTED_FENCE_GATE)
                .add(ModBlocks.DARK_HAUNTED_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.HAUNTED_DOOR)
                .add(ModBlocks.DARK_HAUNTED_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.HAUNTED_TRAPDOOR)
                .add(ModBlocks.DARK_HAUNTED_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.HAUNTED_PRESSURE_PLATE)
                .add(ModBlocks.DARK_HAUNTED_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.HAUNTED_BUTTON)
                .add(ModBlocks.DARK_HAUNTED_BUTTON);
        /*
        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                .add(ModItems.HAUNTED_SIGN)
                .add(ModItems.DARK_HAUNTED_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                .add(ModItems.HAUNTED_SIGN)
                .add(ModItems.DARK_HAUNTED_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModItems.HAUNTED_HANGING_SIGN)
                .add(ModItems.DARK_HAUNTED_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                .add(ModItems.HAUNTED_HANGING_SIGN)
                .add(ModItems.DARK_HAUNTED_HANGING_SIGN);
        */
        getOrCreateTagBuilder(ModTags.Blocks.GHOST_CORAL_BLOCKS)
                .add(ModBlocks.GHOST_CORAL_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.GHOST_CORAL_PLANTS)
                .add(ModBlocks.GHOST_CORAL);

        getOrCreateTagBuilder(ModTags.Blocks.GHOST_CORALS)
                .add(ModBlocks.GHOST_CORAL_FAN);

        getOrCreateTagBuilder(ModTags.Blocks.GHOST_WALL_CORALS)
                .add(ModBlocks.GHOST_CORAL_WALL_FAN);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GHOST_CORAL_BLOCK)
                .add(ModBlocks.GHOST_CORAL)
                .add(ModBlocks.GHOST_CORAL_FAN)
                .add(ModBlocks.GHOST_CORAL_WALL_FAN)
                .add(ModBlocks.DEAD_GHOST_CORAL_BLOCK)
                .add(ModBlocks.DEAD_GHOST_CORAL)
                .add(ModBlocks.DEAD_GHOST_CORAL_FAN)
                .add(ModBlocks.DEAD_GHOST_CORAL_WALL_FAN);
    }
}
