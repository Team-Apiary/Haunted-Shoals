package org.apiary.hauntedshoals.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import org.apiary.hauntedshoals.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //HAUNTED WOODSET
        //addDrop(ModBlocks.HAUNTED_LOG);
        //addDrop(ModBlocks.HAUNTED_WOOD);
        //addDrop(ModBlocks.STRIPPED_HAUNTED_LOG);
        //addDrop(ModBlocks.STRIPPED_HAUNTED_WOOD);
        addDrop(ModBlocks.HAUNTED_PLANKS);
        addDrop(ModBlocks.HAUNTED_STAIRS);
        addDrop(ModBlocks.HAUNTED_SLAB);
        addDrop(ModBlocks.HAUNTED_FENCE);
        addDrop(ModBlocks.HAUNTED_FENCE_GATE);
        //addDrop(ModBlocks.HAUNTED_DOOR, doorDrops(ModBlocks.HAUNTED_DOOR));
        //addDrop(ModBlocks.HAUNTED_TRAPDOOR);
        addDrop(ModBlocks.HAUNTED_PRESSURE_PLATE);
        addDrop(ModBlocks.HAUNTED_BUTTON);
        //addDrop(ModBlocks.HAUNTED_SIGN, ModItems.HAUNTED_SIGN);
        //addDrop(ModBlocks.HAUNTED_WALL_SIGN, ModItems.HAUNTED_SIGN);
        //addDrop(ModBlocks.HAUNTED_HANGING_SIGN, ModItems.HAUNTED_HANGING_SIGN);
        //addDrop(ModBlocks.HAUNTED_WALL_HANGING_SIGN, ModItems.HAUNTED_HANGING_SIGN);

        //DARK HAUNTED WOODSET
        //addDrop(ModBlocks.DARK_HAUNTED_LOG);
        //addDrop(ModBlocks.DARK_HAUNTED_WOOD);
        //addDrop(ModBlocks.DARK_STRIPPED_HAUNTED_LOG);
        //addDrop(ModBlocks.DARK_STRIPPED_HAUNTED_WOOD);
        addDrop(ModBlocks.DARK_HAUNTED_PLANKS);
        addDrop(ModBlocks.DARK_HAUNTED_STAIRS);
        addDrop(ModBlocks.DARK_HAUNTED_SLAB);
        addDrop(ModBlocks.DARK_HAUNTED_FENCE);
        addDrop(ModBlocks.DARK_HAUNTED_FENCE_GATE);
        //addDrop(ModBlocks.DARK_HAUNTED_DOOR, doorDrops(ModBlocks.HAUNTED_DOOR));
        //addDrop(ModBlocks.DARK_HAUNTED_TRAPDOOR);
        addDrop(ModBlocks.DARK_HAUNTED_PRESSURE_PLATE);
        addDrop(ModBlocks.DARK_HAUNTED_BUTTON);
        //addDrop(ModBlocks.DARK_HAUNTED_SIGN, ModItems.HAUNTED_SIGN);
        //addDrop(ModBlocks.DARK_HAUNTED_WALL_SIGN, ModItems.HAUNTED_SIGN);
        //addDrop(ModBlocks.DARK_HAUNTED_HANGING_SIGN, ModItems.HAUNTED_HANGING_SIGN);
        //addDrop(ModBlocks.DARK_HAUNTED_WALL_HANGING_SIGN, ModItems.HAUNTED_HANGING_SIGN);
    }
}
