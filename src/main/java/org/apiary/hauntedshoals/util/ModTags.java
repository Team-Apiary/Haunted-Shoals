package org.apiary.hauntedshoals.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> HAUNTED_BLOCKS = createTag("haunted_blocks");
        //HAUNTED WOODSETS
        public static final TagKey<Block> HAUNTED_LOGS = createTag("haunted_logs");
        public static final TagKey<Block> DARK_HAUNTED_LOGS = createTag("dark_haunted_logs");
        //GHOST CORAL
        public static final TagKey<Block> GHOST_CORAL_BLOCKS = createTag("ghost_coral");
        public static final TagKey<Block> GHOST_CORAL_PLANTS = createTag("ghost_coral");
        public static final TagKey<Block> GHOST_CORALS = createTag("ghost_coral");
        public static final TagKey<Block> GHOST_WALL_CORALS = createTag("ghost_wall_coral");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ModCommonInit.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HAUNTED_BLOCKS = createTag("haunted_blocks");
        //HAUNTED WOODSETS
        public static final TagKey<Item> HAUNTED_LOGS = createTag("haunted_logs");
        public static final TagKey<Item> DARK_HAUNTED_LOGS = createTag("dark_haunted_logs");
        //CUTLASSES
        public static final TagKey<Item> CUTLASSES = createTag("cutlasses");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ModCommonInit.MOD_ID, name));
        }
    }
}
