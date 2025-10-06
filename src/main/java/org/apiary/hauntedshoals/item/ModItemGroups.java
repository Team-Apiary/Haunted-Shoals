package org.apiary.hauntedshoals.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModItemGroups {
    public static final ItemGroup HAUNTED_SHOALS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ModCommonInit.MOD_ID, "haunted_shoals_item_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CURSED_SEAGLASS))
                    .displayName(Text.translatable("itemgroup.haunted_shoals"))
                    .entries((displayContext, entries) -> {
                        //CURSED SEAGLASS
                        entries.add(ModItems.CURSED_SEAGLASS);
                        entries.add(ModItems.CURSED_SEAGLASS_STAFF);
                        //CUTLASSES
                        entries.add(ModItems.WOOD_CUTLASS);
                        entries.add(ModItems.STONE_CUTLASS);
                        entries.add(ModItems.IRON_CUTLASS);
                        entries.add(ModItems.GOLD_CUTLASS);
                        entries.add(ModItems.DIAMOND_CUTLASS);
                        entries.add(ModItems.NETHERITE_CUTLASS);
                        //HAUNTED WOODSET
                        entries.add(ModBlocks.HAUNTED_LOG);
                        entries.add(ModBlocks.HAUNTED_WOOD);
                        entries.add(ModBlocks.STRIPPED_HAUNTED_LOG);
                        entries.add(ModBlocks.STRIPPED_HAUNTED_WOOD);
                        entries.add(ModBlocks.HAUNTED_PLANKS);
                        entries.add(ModBlocks.HAUNTED_STAIRS);
                        entries.add(ModBlocks.HAUNTED_SLAB);
                        entries.add(ModBlocks.HAUNTED_FENCE);
                        entries.add(ModBlocks.HAUNTED_FENCE_GATE);
                        entries.add(ModBlocks.HAUNTED_DOOR);
                        entries.add(ModBlocks.HAUNTED_TRAPDOOR);
                        entries.add(ModBlocks.HAUNTED_PRESSURE_PLATE);
                        entries.add(ModBlocks.HAUNTED_BUTTON);
                        //DARK HAUNTED WOODSET
                        entries.add(ModBlocks.DARK_HAUNTED_LOG);
                        entries.add(ModBlocks.DARK_HAUNTED_WOOD);
                        entries.add(ModBlocks.STRIPPED_DARK_HAUNTED_LOG);
                        entries.add(ModBlocks.STRIPPED_DARK_HAUNTED_WOOD);
                        entries.add(ModBlocks.DARK_HAUNTED_PLANKS);
                        entries.add(ModBlocks.DARK_HAUNTED_STAIRS);
                        entries.add(ModBlocks.DARK_HAUNTED_SLAB);
                        entries.add(ModBlocks.DARK_HAUNTED_FENCE);
                        entries.add(ModBlocks.DARK_HAUNTED_FENCE_GATE);
                        entries.add(ModBlocks.DARK_HAUNTED_DOOR);
                        entries.add(ModBlocks.DARK_HAUNTED_TRAPDOOR);
                        entries.add(ModBlocks.DARK_HAUNTED_PRESSURE_PLATE);
                        entries.add(ModBlocks.DARK_HAUNTED_BUTTON);
                    }).build());

    public static void registerModItemGroups() {
        //Impillagers.LOGGER.info("Registering Item Groups for " + Impillagers.MOD_ID);
    }
}