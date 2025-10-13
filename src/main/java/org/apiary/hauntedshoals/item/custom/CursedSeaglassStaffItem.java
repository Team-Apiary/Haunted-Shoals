package org.apiary.hauntedshoals.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.effect.ModEffects;

import java.util.Map;
import java.util.Optional;

public class CursedSeaglassStaffItem extends Item {
    protected static final Map<Block, Block> HAUNTED_BLOCKS = new ImmutableMap.Builder<Block, Block>()
            .put(Blocks.OAK_PLANKS, ModBlocks.HAUNTED_PLANKS)

            .put(Blocks.OAK_LOG, ModBlocks.HAUNTED_LOG)
            .put(Blocks.OAK_WOOD, ModBlocks.HAUNTED_WOOD)
            .put(Blocks.STRIPPED_OAK_LOG, ModBlocks.STRIPPED_HAUNTED_LOG)
            .put(Blocks.STRIPPED_OAK_WOOD, ModBlocks.STRIPPED_HAUNTED_WOOD)

            .put(Blocks.DARK_OAK_LOG, ModBlocks.DARK_HAUNTED_LOG)
            .put(Blocks.DARK_OAK_WOOD, ModBlocks.DARK_HAUNTED_WOOD)
            .put(Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.STRIPPED_DARK_HAUNTED_LOG)
            .put(Blocks.STRIPPED_DARK_OAK_WOOD, ModBlocks.STRIPPED_DARK_HAUNTED_WOOD)

            .put(Blocks.OAK_SLAB, ModBlocks.HAUNTED_SLAB)
            .put(Blocks.DARK_OAK_SLAB, ModBlocks.DARK_HAUNTED_SLAB)
            .build();

    public CursedSeaglassStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (entity instanceof LivingEntity livingEntity && !(livingEntity = (LivingEntity)entity).isInvulnerableTo(world.getDamageSources().wither())) {
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.HAUNTED, 40));
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);

        Optional<BlockState> optional = this.getHauntedState(blockState);
        if (optional.isPresent()) {
            world.playSound(null, blockPos, SoundEvents.BLOCK_SOUL_SAND_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(blockPos, optional.get(), Block.NOTIFY_ALL_AND_REDRAW);
            return ActionResult.PASS;
        }
        return ActionResult.success(world.isClient);
    }

    private Optional<BlockState> getHauntedState(BlockState state) {
        if (Optional.ofNullable(HAUNTED_BLOCKS.get(state.getBlock())).map(block1 -> (BlockState)block1.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS))).isPresent()){
            return Optional.ofNullable(HAUNTED_BLOCKS.get(state.getBlock())).map(block1 -> (BlockState)block1.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));

        }else if (Optional.ofNullable(HAUNTED_BLOCKS.get(state.getBlock())).map(block1 -> (BlockState)block1.getDefaultState().with(SlabBlock.TYPE, state.get(SlabBlock.TYPE)).with(SlabBlock.WATERLOGGED, state.get(SlabBlock.WATERLOGGED))).isPresent()){
            return Optional.ofNullable(HAUNTED_BLOCKS.get(state.getBlock())).map(block1 -> (BlockState)block1.getDefaultState().with(SlabBlock.TYPE, state.get(SlabBlock.TYPE)).with(SlabBlock.WATERLOGGED, state.get(SlabBlock.WATERLOGGED)));
        }
        return Optional.empty();
    }
}
