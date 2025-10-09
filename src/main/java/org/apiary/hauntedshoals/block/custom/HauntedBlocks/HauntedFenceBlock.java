package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedFenceBlock extends FenceBlock {
    public static Entity globalEntity;

    public HauntedFenceBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        globalEntity = entity;
        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(globalEntity instanceof LivingEntity){
            if(((LivingEntity) globalEntity).hasStatusEffect(ModEffects.HAUNTED)){
                return this.boundingShapes[this.getShapeIndex(state)];
            }
        }
        return VoxelShapes.empty();
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(globalEntity instanceof LivingEntity){
            if(((LivingEntity) globalEntity).hasStatusEffect(ModEffects.HAUNTED)){
                return this.collisionShapes[this.getShapeIndex(state)];
            }
        }
        return VoxelShapes.empty();
    }
}
