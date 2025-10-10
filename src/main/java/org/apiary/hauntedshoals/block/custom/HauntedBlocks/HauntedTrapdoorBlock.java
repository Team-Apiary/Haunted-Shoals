package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedTrapdoorBlock extends TrapdoorBlock {
    public HauntedTrapdoorBlock(BlockSetType type, Settings settings) {
        super(type, settings);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        EntityShapeContext entityShapeContext;
        Entity entity;

        if(context instanceof EntityShapeContext && (entity = (entityShapeContext = (EntityShapeContext)context).getEntity()) != null){
            if(((LivingEntity) entity).hasStatusEffect(ModEffects.HAUNTED)){
                if (!state.get(OPEN)) {
                    return state.get(HALF) == BlockHalf.TOP ? OPEN_TOP_SHAPE : OPEN_BOTTOM_SHAPE;
                }
                switch (state.get(FACING)) {
                    case NORTH: {
                        return NORTH_SHAPE;
                    }
                    case SOUTH: {
                        return SOUTH_SHAPE;
                    }
                    case WEST: {
                        return WEST_SHAPE;
                    }
                    case EAST:
                }
                return EAST_SHAPE;
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
                if (!state.get(OPEN)) {
                    return state.get(HALF) == BlockHalf.TOP ? OPEN_TOP_SHAPE : OPEN_BOTTOM_SHAPE;
                }
                switch (state.get(FACING)) {
                    case NORTH: {
                        return NORTH_SHAPE;
                    }
                    case SOUTH: {
                        return SOUTH_SHAPE;
                    }
                    case WEST: {
                        return WEST_SHAPE;
                    }
                    case EAST:
                }
                return EAST_SHAPE;
            }
        }
        return VoxelShapes.empty();
    }

    /*
    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(this)) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }
     */
}
