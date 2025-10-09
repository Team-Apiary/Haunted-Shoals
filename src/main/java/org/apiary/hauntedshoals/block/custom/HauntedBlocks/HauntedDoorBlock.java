package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedDoorBlock extends DoorBlock {
    public static Entity globalEntity;

    public HauntedDoorBlock(BlockSetType type, Settings settings) {
        super(type, settings);
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
}
