package org.apiary.hauntedshoals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import org.apiary.hauntedshoals.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //LOGS
        //LOG TAGS

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
         /*
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.HAUNTED_DOOR.asItem()
                .add(ModBlocks.DARK_HAUNTED_DOOR.asItem());
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.HAUNTED_TRAPDOOR.asItem()
                .add(ModBlocks.DARK_HAUNTED_TRAPDOOR.asItem());
        */
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
    }
}
