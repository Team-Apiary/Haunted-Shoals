package org.apiary.hauntedshoals.init;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.apiary.hauntedshoals.block.ModBlocks;

public class ModClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //HAUNTED WOODSET
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_PLANKS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_SLAB, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_FENCE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_FENCE_GATE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_PRESSURE_PLATE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_BUTTON, RenderLayer.getTranslucent());
        //DARK HAUNTED WOODSET
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_PLANKS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_SLAB, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_FENCE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_FENCE_GATE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_PRESSURE_PLATE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_BUTTON, RenderLayer.getTranslucent());
    }
}
