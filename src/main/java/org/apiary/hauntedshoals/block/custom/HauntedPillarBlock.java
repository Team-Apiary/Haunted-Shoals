package org.apiary.hauntedshoals.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.EntityShapeContext;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedPillarBlock extends PillarBlock {
    public HauntedPillarBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Entity entity;

        if(context instanceof EntityShapeContext && (entity = ((EntityShapeContext)context).getEntity()) != null && entity instanceof LivingEntity){
            if(((LivingEntity) entity).hasStatusEffect(ModEffects.HAUNTED)){
                return super.getCollisionShape(state, world, pos, context);
            }
        }
        if(context instanceof EntityShapeContext && (entity = ((EntityShapeContext)context).getEntity()) != null && entity instanceof ItemEntity){
            return super.getCollisionShape(state, world, pos, context);
        }
        if(context instanceof EntityShapeContext && (entity = ((EntityShapeContext)context).getEntity()) != null && entity instanceof ExperienceOrbEntity){
            return super.getCollisionShape(state, world, pos, context);
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

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(this)) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }
}
