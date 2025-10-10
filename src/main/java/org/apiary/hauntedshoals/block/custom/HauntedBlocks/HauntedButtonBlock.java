package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedButtonBlock extends ButtonBlock {
    public HauntedButtonBlock(BlockSetType blockSetType, int pressTicks, Settings settings) {
        super(blockSetType, pressTicks, settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        EntityShapeContext entityShapeContext;
        Entity entity;

        if (context instanceof EntityShapeContext && (entity = (entityShapeContext = (EntityShapeContext) context).getEntity()) != null) {
            if (((LivingEntity) entity).hasStatusEffect(ModEffects.HAUNTED)) {

                Direction direction = state.get(FACING);
                boolean bl = state.get(POWERED);
                switch ((BlockFace) state.get(FACE)) {
                    case FLOOR: {
                        if (direction.getAxis() == Direction.Axis.X) {
                            return bl ? FLOOR_X_PRESSED_SHAPE : FLOOR_X_SHAPE;
                        }
                        return bl ? FLOOR_Z_PRESSED_SHAPE : FLOOR_Z_SHAPE;
                    }
                    case WALL: {
                        return switch (direction) {
                            case Direction.EAST -> {
                                if (bl) {
                                    yield EAST_PRESSED_SHAPE;
                                }
                                yield EAST_SHAPE;
                            }
                            case Direction.WEST -> {
                                if (bl) {
                                    yield WEST_PRESSED_SHAPE;
                                }
                                yield WEST_SHAPE;
                            }
                            case Direction.SOUTH -> {
                                if (bl) {
                                    yield SOUTH_PRESSED_SHAPE;
                                }
                                yield SOUTH_SHAPE;
                            }
                            case Direction.NORTH, Direction.UP, Direction.DOWN ->
                                    bl ? NORTH_PRESSED_SHAPE : NORTH_SHAPE;
                            default -> throw new MatchException(null, null);
                        };
                    }
                }
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
