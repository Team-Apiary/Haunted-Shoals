package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.ShapeContext;
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
    private final BlockSetType blockSetType;
    public static Entity globalEntity;

    public HauntedButtonBlock(BlockSetType blockSetType, int pressTicks, Settings settings) {
        super(blockSetType, pressTicks, settings);
        this.blockSetType = blockSetType;
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        globalEntity = entity;
        if(globalEntity instanceof LivingEntity){
            if(((LivingEntity) globalEntity).hasStatusEffect(ModEffects.HAUNTED)){
                if (world.isClient || !this.blockSetType.canButtonBeActivatedByArrows() || state.get(POWERED)) {
                    return;
                }
                this.tryPowerWithProjectiles(state, world, pos);
            }
        }
        //super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(globalEntity instanceof LivingEntity){
            if(((LivingEntity) globalEntity).hasStatusEffect(ModEffects.HAUNTED)){
                Direction direction = state.get(FACING);
                boolean bl = state.get(POWERED);
                switch (state.get(FACE)) {
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
                            case Direction.NORTH, Direction.UP, Direction.DOWN -> bl ? NORTH_PRESSED_SHAPE : NORTH_SHAPE;
                        };
                    }
                }
                if (direction.getAxis() == Direction.Axis.X) {
                    return bl ? CEILING_X_PRESSED_SHAPE : CEILING_X_SHAPE;
                }
                return bl ? CEILING_Z_PRESSED_SHAPE : CEILING_Z_SHAPE;
            }
        }
        return VoxelShapes.empty();
    }
}
