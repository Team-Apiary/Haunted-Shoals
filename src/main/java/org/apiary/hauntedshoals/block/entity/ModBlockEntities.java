package org.apiary.hauntedshoals.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.init.ModCommonInit;

public class ModBlockEntities {

    public static void registerModBlockEntities(){

        BlockEntityType.BARREL.addSupportedBlock(ModBlocks.HAUNTED_BARREL);

    }

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, BlockEntityType.BlockEntityFactory<? extends T> factory, Block... validBlocks) {
        Identifier id = Identifier.of(ModCommonInit.MOD_ID, name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, BlockEntityType.Builder.<T>create(factory, validBlocks).build());
    }
}
