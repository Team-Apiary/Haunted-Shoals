package org.apiary.hauntedshoals.init;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.particle.ModParticleTypes;
import org.apiary.hauntedshoals.particle.custom.HauntedSoulParticle;

public class ModClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_SAILS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_BARREL, RenderLayer.getTranslucent());
        //HAUNTED WOODSET
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_LOG, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_WOOD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRIPPED_HAUNTED_LOG, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRIPPED_HAUNTED_WOOD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_PLANKS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_SLAB, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_FENCE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_FENCE_GATE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_DOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_TRAPDOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_PRESSURE_PLATE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HAUNTED_BUTTON, RenderLayer.getTranslucent());
        //DARK HAUNTED WOODSET
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_LOG, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_WOOD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRIPPED_DARK_HAUNTED_LOG, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRIPPED_DARK_HAUNTED_WOOD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_PLANKS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_SLAB, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_FENCE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_FENCE_GATE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_DOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_TRAPDOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_PRESSURE_PLATE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_HAUNTED_BUTTON, RenderLayer.getTranslucent());
        //GHOST CORALS
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GHOST_CORAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GHOST_CORAL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GHOST_CORAL_WALL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_GHOST_CORAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_GHOST_CORAL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_GHOST_CORAL_WALL_FAN, RenderLayer.getCutout());

        //PARTICLES
        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.HAUNTED_SOUL,((spriteProvider) -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ)
                -> new HauntedSoulParticle(world, x, y, z, velocityX, velocityY, velocityZ, spriteProvider)));

    }
}
