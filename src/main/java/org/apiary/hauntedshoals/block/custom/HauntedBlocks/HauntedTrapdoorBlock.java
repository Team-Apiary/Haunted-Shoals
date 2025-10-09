package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedTrapdoorBlock extends TrapdoorBlock {
    public static Entity globalEntity;

    public HauntedTrapdoorBlock(BlockSetType type, Settings settings) {
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
}
