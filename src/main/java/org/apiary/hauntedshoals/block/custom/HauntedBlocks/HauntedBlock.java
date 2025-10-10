package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedBlock extends Block {
    public HauntedBlock(Settings settings) {
        super(settings);
    }

    /*
    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        EntityShapeContext entityShapeContext;
        Entity entity;

        if(context instanceof EntityShapeContext && (entity = (entityShapeContext = (EntityShapeContext)context).getEntity()) != null){
            if(((LivingEntity) entity).hasStatusEffect(ModEffects.HAUNTED)){
                return false;
            }
        }
        return true;
    }
     */

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        EntityShapeContext entityShapeContext;
        Entity entity;

        if(context instanceof EntityShapeContext && (entity = (entityShapeContext = (EntityShapeContext)context).getEntity()) != null){
            if(((LivingEntity) entity).hasStatusEffect(ModEffects.HAUNTED)){
                return VoxelShapes.fullCube();
            }
        }
        return VoxelShapes.empty();
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        EntityShapeContext entityShapeContext;
        Entity entity;

        if(context instanceof EntityShapeContext && (entity = (entityShapeContext = (EntityShapeContext)context).getEntity()) != null){
            if(((LivingEntity) entity).hasStatusEffect(ModEffects.HAUNTED)){
                return VoxelShapes.fullCube();
            }
        }
        return VoxelShapes.empty();
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(this)) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }
}
