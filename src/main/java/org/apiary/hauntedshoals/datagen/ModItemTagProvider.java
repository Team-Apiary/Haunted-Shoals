package org.apiary.hauntedshoals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import org.apiary.hauntedshoals.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //LOGS
        //LOG TAGS

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.HAUNTED_PLANKS.asItem())
                .add(ModBlocks.DARK_HAUNTED_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.HAUNTED_STAIRS.asItem())
                .add(ModBlocks.DARK_HAUNTED_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.HAUNTED_SLAB.asItem())
                .add(ModBlocks.DARK_HAUNTED_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.HAUNTED_FENCE.asItem())
                .add(ModBlocks.DARK_HAUNTED_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.HAUNTED_FENCE_GATE.asItem())
                .add(ModBlocks.DARK_HAUNTED_FENCE_GATE.asItem());
        /*
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.HAUNTED_DOOR.asItem()
                .add(ModBlocks.DARK_HAUNTED_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.HAUNTED_TRAPDOOR.asItem()
                .add(ModBlocks.DARK_HAUNTED_TRAPDOOR.asItem());
        */
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.HAUNTED_PRESSURE_PLATE.asItem())
                .add(ModBlocks.DARK_HAUNTED_PRESSURE_PLATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.HAUNTED_BUTTON.asItem())
                .add(ModBlocks.DARK_HAUNTED_BUTTON.asItem());
        /*
        getOrCreateTagBuilder(ItemTags.SIGNS)
                .add(ModItems.HAUNTED_SIGN)
                .add(ModItems.DARK_HAUNTED_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS)
                .add(ModItems.HAUNTED_HANGING_SIGN)
                .add(ModItems.DARK_HAUNTED_HANGING_SIGN);
         */
    }
}
