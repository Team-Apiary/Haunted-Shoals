package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.effect.ModEffects;

public class HauntedPressurePlateBlock extends PressurePlateBlock {
    public static Entity globalEntity;

    public HauntedPressurePlateBlock(BlockSetType type, Settings settings) {
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
                return this.getRedstoneOutput(state) > 0 ? PRESSED_SHAPE : DEFAULT_SHAPE;
            }
        }
        return VoxelShapes.empty();
    }
}
