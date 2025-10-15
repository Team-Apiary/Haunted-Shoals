package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.effect.ModEffects;

import java.util.Objects;

public class HauntedButtonBlock extends ButtonBlock {
    public HauntedButtonBlock(BlockSetType blockSetType, int pressTicks, Settings settings) {
        super(blockSetType, pressTicks, settings);
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

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof ArrowEntity arrow) {
            ItemStack arrowStack = arrow.getItemStack();
            if (arrowStack.getItem() == Items.TIPPED_ARROW) {
                String arrowName = arrowStack.getTranslationKey();
                if(Objects.equals(arrowName, "item.minecraft.tipped_arrow.effect.haunted") || Objects.equals(arrowName, "item.minecraft.tipped_arrow.effect.long_haunted")){
                    this.tryPowerWithProjectiles(state, world, pos);
                }
            }
        }
    }

}
