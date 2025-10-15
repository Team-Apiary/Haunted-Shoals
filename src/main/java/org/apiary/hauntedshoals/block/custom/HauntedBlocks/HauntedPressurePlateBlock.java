package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.apiary.hauntedshoals.effect.ModEffects;

//TODO Make it so that only haunted entities can activate the pressure plate

public class HauntedPressurePlateBlock extends PressurePlateBlock {
    public HauntedPressurePlateBlock(BlockSetType type, Settings settings) {
        super(type, settings);
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
