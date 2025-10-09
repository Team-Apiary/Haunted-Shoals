package org.apiary.hauntedshoals.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModBlockProperties {
    public static void propertiesRegister() {
        //Strippable Blocks
        StrippableBlockRegistry.register(ModBlocks.HAUNTED_LOG, ModBlocks.STRIPPED_HAUNTED_LOG);
        StrippableBlockRegistry.register(ModBlocks.HAUNTED_WOOD, ModBlocks.STRIPPED_HAUNTED_WOOD);
        StrippableBlockRegistry.register(ModBlocks.DARK_HAUNTED_LOG, ModBlocks.STRIPPED_DARK_HAUNTED_LOG);
        StrippableBlockRegistry.register(ModBlocks.DARK_HAUNTED_WOOD, ModBlocks.STRIPPED_DARK_HAUNTED_WOOD);
    }
}
