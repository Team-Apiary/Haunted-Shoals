package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedSlabBlock extends SlabBlock {
    public static Entity globalEntity;

    public HauntedSlabBlock(Settings settings) {
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
                SlabType slabType = state.get(TYPE);
                return switch (slabType) {
                    case DOUBLE -> VoxelShapes.fullCube();
                    case TOP -> TOP_SHAPE;
                    default -> BOTTOM_SHAPE;
                };
            }
        }
        return VoxelShapes.empty();
    }
}
