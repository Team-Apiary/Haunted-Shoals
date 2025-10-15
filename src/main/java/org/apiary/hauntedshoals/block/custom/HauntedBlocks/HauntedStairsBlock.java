package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.EntityShapeContext;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedStairsBlock extends StairsBlock {
    public HauntedStairsBlock(BlockState baseBlockState, Settings settings) {
        super(baseBlockState, settings);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Entity entity;

        if(context instanceof EntityShapeContext && (entity = ((EntityShapeContext)context).getEntity()) != null && entity instanceof LivingEntity){
            if(((LivingEntity) entity).hasStatusEffect(ModEffects.HAUNTED)){
                return super.getCollisionShape(state, world, pos, context);
            }
        }
        return VoxelShapes.empty();
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Entity entity;

        if (context instanceof EntityShapeContext && (entity = ((EntityShapeContext) context).getEntity()) != null && entity instanceof LivingEntity) {
            if (((LivingEntity) entity).hasStatusEffect(ModEffects.HAUNTED)) {
                return super.getOutlineShape(state, world, pos, context);
            }
            return VoxelShapes.empty();
        }else {
            return super.getOutlineShape(state, world, pos, context);
        }
    }
}
