package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedDoorBlock extends DoorBlock {
    public HauntedDoorBlock(BlockSetType type, Settings settings) {
        super(type, settings);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        EntityShapeContext entityShapeContext;
        Entity entity;

        if(context instanceof EntityShapeContext && (entity = (entityShapeContext = (EntityShapeContext)context).getEntity()) != null){
            if(((LivingEntity) entity).hasStatusEffect(ModEffects.HAUNTED)){
                Direction direction = state.get(FACING);
                boolean bl = state.get(OPEN) == false;
                boolean bl2 = state.get(HINGE) == DoorHinge.RIGHT;
                return switch (direction) {
                    case Direction.SOUTH -> {
                        if (bl) {
                            yield NORTH_SHAPE;
                        }
                        if (bl2) {
                            yield WEST_SHAPE;
                        }
                        yield EAST_SHAPE;
                    }
                    case Direction.WEST -> {
                        if (bl) {
                            yield EAST_SHAPE;
                        }
                        if (bl2) {
                            yield NORTH_SHAPE;
                        }
                        yield SOUTH_SHAPE;
                    }
                    case Direction.NORTH -> bl ? SOUTH_SHAPE : (bl2 ? EAST_SHAPE : WEST_SHAPE);
                    default -> {
                        if (bl) {
                            yield WEST_SHAPE;
                        }
                        if (bl2) {
                            yield SOUTH_SHAPE;
                        }
                        yield NORTH_SHAPE;
                    }
                };
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
                Direction direction = state.get(FACING);
                boolean bl = state.get(OPEN) == false;
                boolean bl2 = state.get(HINGE) == DoorHinge.RIGHT;
                return switch (direction) {
                    case Direction.SOUTH -> {
                        if (bl) {
                            yield NORTH_SHAPE;
                        }
                        if (bl2) {
                            yield WEST_SHAPE;
                        }
                        yield EAST_SHAPE;
                    }
                    case Direction.WEST -> {
                        if (bl) {
                            yield EAST_SHAPE;
                        }
                        if (bl2) {
                            yield NORTH_SHAPE;
                        }
                        yield SOUTH_SHAPE;
                    }
                    case Direction.NORTH -> bl ? SOUTH_SHAPE : (bl2 ? EAST_SHAPE : WEST_SHAPE);
                    default -> {
                        if (bl) {
                            yield WEST_SHAPE;
                        }
                        if (bl2) {
                            yield SOUTH_SHAPE;
                        }
                        yield NORTH_SHAPE;
                    }
                };
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
