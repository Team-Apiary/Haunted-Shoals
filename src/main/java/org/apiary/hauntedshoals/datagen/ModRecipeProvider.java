package org.apiary.hauntedshoals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.item.ModItems;
import org.apiary.hauntedshoals.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //HAUNTED WOODSET
        offerBarkBlockRecipe(exporter, ModBlocks.HAUNTED_WOOD.asItem(), ModBlocks.HAUNTED_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_HAUNTED_WOOD.asItem(), ModBlocks.STRIPPED_HAUNTED_LOG);
        offerPlanksRecipe(exporter, ModBlocks.HAUNTED_PLANKS.asItem(), ModTags.Items.HAUNTED_LOGS, 4);
        offerStairsRecipe(exporter, ModBlocks.HAUNTED_STAIRS, ModBlocks.HAUNTED_PLANKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.HAUNTED_SLAB, ModBlocks.HAUNTED_PLANKS);
        offerFenceRecipe(exporter, ModBlocks.HAUNTED_FENCE, ModBlocks.HAUNTED_PLANKS);
        offerFenceGateRecipe(exporter, ModBlocks.HAUNTED_FENCE_GATE, ModBlocks.HAUNTED_PLANKS);
        offerDoorRecipe(exporter, ModBlocks.HAUNTED_DOOR, ModBlocks.HAUNTED_PLANKS);
        offerTrapdoorRecipe(exporter, ModBlocks.HAUNTED_TRAPDOOR, ModBlocks.HAUNTED_PLANKS);
        offerPressurePlateRecipe(exporter, ModBlocks.HAUNTED_PRESSURE_PLATE, ModBlocks.HAUNTED_PLANKS);
        offerShapelessRecipe(exporter, ModBlocks.HAUNTED_BUTTON, ModBlocks.HAUNTED_PLANKS, "haunted_button", 1);
        //offerSignRecipe(exporter, ModItems.HAUNTED_SIGN, ModBlocks.HAUNTED_PLANKS);
        //offerHangingSignRecipe(exporter, ModItems.HAUNTED_HANGING_SIGN, ModBlocks.STRIPPED_HAUNTED_LOG);
        //DARK HAUNTED WOODSET
        offerBarkBlockRecipe(exporter, ModBlocks.DARK_HAUNTED_WOOD.asItem(), ModBlocks.DARK_HAUNTED_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_DARK_HAUNTED_WOOD.asItem(), ModBlocks.STRIPPED_DARK_HAUNTED_LOG);
        offerPlanksRecipe(exporter, ModBlocks.DARK_HAUNTED_PLANKS.asItem(), ModTags.Items.DARK_HAUNTED_LOGS, 4);
        offerStairsRecipe(exporter, ModBlocks.DARK_HAUNTED_STAIRS, ModBlocks.DARK_HAUNTED_PLANKS);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_HAUNTED_SLAB, ModBlocks.DARK_HAUNTED_PLANKS);
        offerFenceRecipe(exporter, ModBlocks.DARK_HAUNTED_FENCE, ModBlocks.DARK_HAUNTED_PLANKS);
        offerFenceGateRecipe(exporter, ModBlocks.DARK_HAUNTED_FENCE_GATE, ModBlocks.DARK_HAUNTED_PLANKS);
        offerDoorRecipe(exporter, ModBlocks.DARK_HAUNTED_DOOR, ModBlocks.DARK_HAUNTED_PLANKS);
        offerTrapdoorRecipe(exporter, ModBlocks.DARK_HAUNTED_TRAPDOOR, ModBlocks.DARK_HAUNTED_PLANKS);
        offerPressurePlateRecipe(exporter, ModBlocks.DARK_HAUNTED_PRESSURE_PLATE, ModBlocks.DARK_HAUNTED_PLANKS);
        offerShapelessRecipe(exporter, ModBlocks.DARK_HAUNTED_BUTTON, ModBlocks.DARK_HAUNTED_PLANKS, "dark_haunted_button", 1);
        //offerSignRecipe(exporter, ModItems.DARK_HAUNTED_SIGN, ModBlocks.DARK_HAUNTED_PLANKS);
        //offerHangingSignRecipe(exporter, ModItems.DARK_HAUNTED_HANGING_SIGN, ModBlocks.STRIPPED_DARK_HAUNTED_LOG);
        //CUTLASSES
        offerCutlassRecipe(exporter, ModItems.IRON_CUTLASS, Items.IRON_INGOT, "iron");
        offerCutlassRecipe(exporter, ModItems.GOLD_CUTLASS, Items.GOLD_INGOT, "gold");
        offerCutlassRecipe(exporter, ModItems.DIAMOND_CUTLASS, Items.DIAMOND, "diamond");
        offerNetheriteUpgradeRecipe(exporter, ModItems.DIAMOND_CUTLASS, RecipeCategory.COMBAT, ModItems.NETHERITE_CUTLASS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WOOD_CUTLASS, 1)
                .input('T', Items.STICK)
                .input('#', ItemTags.PLANKS)
                .pattern("  #")
                .pattern(" # ")
                .pattern("T  ")
                .criterion("oak_planks", conditionsFromItem(Items.OAK_PLANKS))
                .group("cutlasses")
                .offerTo(exporter, "wood_cutlass");
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STONE_CUTLASS, 1)
                .input('T', Items.STICK)
                .input('#', ItemTags.STONE_CRAFTING_MATERIALS)
                .pattern("  #")
                .pattern(" # ")
                .pattern("T  ")
                .criterion("cobblestone", conditionsFromItem(Items.COBBLESTONE))
                .group("cutlasses")
                .offerTo(exporter, "stone_cutlass");
        //CURSED SEAGLASS STAFF
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CURSED_SEAGLASS_STAFF, 1)
                .input('B', Items.STICK)
                .input('S', ModItems.CURSED_SEAGLASS)
                .input('C', Blocks.CHAIN)
                .input('F', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .pattern("CSC")
                .pattern("FBF")
                .pattern(" B ")
                .criterion("cursed_seaglass", conditionsFromItem(ModItems.CURSED_SEAGLASS))
                .offerTo(exporter, "cursed_seaglass_staff");
    }

    public static void offerCutlassRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input, String material) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1)
                .input('T', Items.STICK)
                .input('#', input)
                .pattern("  #")
                .pattern(" # ")
                .pattern("T  ")
                .criterion(material, conditionsFromItem(input))
                .group("cutlasses")
                .offerTo(exporter, material + "_cutlass");
    }

    public static void offerStairsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerFenceRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createFenceRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerFenceGateRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createFenceGateRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    public static void offerDoorRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createDoorRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerTrapdoorRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createTrapdoorRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
    public static void offerSignRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createSignRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }
}
