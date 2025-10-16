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
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.effect.ModEffects;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CursedSeaglassStaffItem extends Item {
    protected static final Map<Block, Block> HAUNTED_BLOCKS = new ImmutableMap.Builder<Block, Block>()
            .put(Blocks.WHITE_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.BLACK_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.BLUE_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.CYAN_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.BROWN_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.GRAY_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.GREEN_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.LIGHT_BLUE_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.LIGHT_GRAY_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.LIME_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.MAGENTA_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.ORANGE_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.PINK_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.PURPLE_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.RED_WOOL, ModBlocks.HAUNTED_SAILS)
            .put(Blocks.YELLOW_WOOL, ModBlocks.HAUNTED_SAILS)

            .put(Blocks.BARREL, ModBlocks.HAUNTED_BARREL)

            .put(Blocks.OAK_PLANKS, ModBlocks.HAUNTED_PLANKS)
            .put(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_HAUNTED_PLANKS)

            .put(Blocks.OAK_BUTTON, ModBlocks.HAUNTED_BUTTON)
            .put(Blocks.DARK_OAK_BUTTON, ModBlocks.DARK_HAUNTED_BUTTON)

            .put(Blocks.OAK_DOOR, ModBlocks.HAUNTED_DOOR)
            .put(Blocks.DARK_OAK_DOOR, ModBlocks.DARK_HAUNTED_DOOR)

            .put(Blocks.OAK_FENCE, ModBlocks.HAUNTED_FENCE)
            .put(Blocks.DARK_OAK_FENCE, ModBlocks.DARK_HAUNTED_FENCE)

            .put(Blocks.OAK_FENCE_GATE, ModBlocks.HAUNTED_FENCE_GATE)
            .put(Blocks.DARK_OAK_FENCE_GATE, ModBlocks.DARK_HAUNTED_FENCE_GATE)

            .put(Blocks.OAK_LOG, ModBlocks.HAUNTED_LOG)
            .put(Blocks.OAK_WOOD, ModBlocks.HAUNTED_WOOD)
            .put(Blocks.STRIPPED_OAK_LOG, ModBlocks.STRIPPED_HAUNTED_LOG)
            .put(Blocks.STRIPPED_OAK_WOOD, ModBlocks.STRIPPED_HAUNTED_WOOD)

            .put(Blocks.DARK_OAK_LOG, ModBlocks.DARK_HAUNTED_LOG)
            .put(Blocks.DARK_OAK_WOOD, ModBlocks.DARK_HAUNTED_WOOD)
            .put(Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.STRIPPED_DARK_HAUNTED_LOG)
            .put(Blocks.STRIPPED_DARK_OAK_WOOD, ModBlocks.STRIPPED_DARK_HAUNTED_WOOD)

            .put(Blocks.OAK_PRESSURE_PLATE, ModBlocks.HAUNTED_PRESSURE_PLATE)
            .put(Blocks.DARK_OAK_PRESSURE_PLATE, ModBlocks.DARK_HAUNTED_PRESSURE_PLATE)

            .put(Blocks.OAK_SLAB, ModBlocks.HAUNTED_SLAB)
            .put(Blocks.DARK_OAK_SLAB, ModBlocks.DARK_HAUNTED_SLAB)

            .put(Blocks.OAK_STAIRS, ModBlocks.HAUNTED_STAIRS)
            .put(Blocks.DARK_OAK_STAIRS, ModBlocks.DARK_HAUNTED_STAIRS)

            .put(Blocks.OAK_TRAPDOOR, ModBlocks.HAUNTED_TRAPDOOR)
            .put(Blocks.DARK_OAK_TRAPDOOR, ModBlocks.DARK_HAUNTED_TRAPDOOR)
            .build();

    public CursedSeaglassStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.haunted_shoals.cursed_seaglass_staff"));
        super.appendTooltip(stack, context, tooltip, type);
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
            for (int i = 0; i < 5; i++) {
                Random random = world.getRandom();
                Direction direction = Direction.random(random);
                double d = direction.getOffsetX() == 0 ? random.nextDouble() : 0.5 + (double)direction.getOffsetX() * 0.6;
                double e = direction.getOffsetY() == 0 ? random.nextDouble() : 0.5 + (double)direction.getOffsetY() * 0.6;
                double f = direction.getOffsetZ() == 0 ? random.nextDouble() : 0.5 + (double)direction.getOffsetZ() * 0.6;
                world.addParticle(ParticleTypes.SOUL, (double)blockPos.getX() + d, (double)blockPos.getY() + e, (double)blockPos.getZ() + f, 0.0, 0.0, 0.0);
            }
            world.setBlockState(blockPos, optional.get(), Block.NOTIFY_ALL_AND_REDRAW);
            return ActionResult.success(world.isClient);
        }
        return ActionResult.FAIL;
    }

    private Optional<BlockState> getHauntedState(BlockState state) {
        Block block = state.getBlock();
        Block haunted = HAUNTED_BLOCKS.get(block);

        if (haunted == null) {
            return Optional.empty();
        }

        if (block instanceof BarrelBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(BarrelBlock.FACING, state.get(BarrelBlock.FACING)));
        }

        if (block instanceof ButtonBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(ButtonBlock.FACE, state.get(ButtonBlock.FACE))
                    .with(ButtonBlock.FACING, state.get(ButtonBlock.FACING)));
        }

        if (block instanceof DoorBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(DoorBlock.FACING, state.get(DoorBlock.FACING))
                    .with(DoorBlock.OPEN, state.get(DoorBlock.OPEN))
                    .with(DoorBlock.HINGE, state.get(DoorBlock.HINGE))
                    .with(DoorBlock.HALF, state.get(DoorBlock.HALF)));
        }

        if (block instanceof FenceBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(FenceBlock.NORTH, state.get(FenceBlock.NORTH))
                    .with(FenceBlock.EAST, state.get(FenceBlock.EAST))
                    .with(FenceBlock.WEST, state.get(FenceBlock.WEST))
                    .with(FenceBlock.SOUTH, state.get(FenceBlock.SOUTH))
                    .with(FenceBlock.WATERLOGGED, state.get(FenceBlock.WATERLOGGED)));
        }

        if (block instanceof FenceGateBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(FenceGateBlock.FACING, state.get(FenceGateBlock.FACING))
                    .with(FenceGateBlock.OPEN, state.get(FenceGateBlock.OPEN))
                    .with(FenceGateBlock.IN_WALL, state.get(FenceGateBlock.IN_WALL)));
        }

        if (block instanceof PillarBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
        }

        if (block instanceof PressurePlateBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(PressurePlateBlock.POWERED, state.get(PressurePlateBlock.POWERED)));
        }

        if (block instanceof SlabBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(SlabBlock.TYPE, state.get(SlabBlock.TYPE))
                    .with(SlabBlock.WATERLOGGED, state.get(SlabBlock.WATERLOGGED)));
        }

        if (block instanceof StairsBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(StairsBlock.FACING, state.get(StairsBlock.FACING))
                    .with(StairsBlock.HALF, state.get(StairsBlock.HALF))
                    .with(StairsBlock.SHAPE, state.get(StairsBlock.SHAPE))
                    .with(StairsBlock.WATERLOGGED, state.get(StairsBlock.WATERLOGGED)));
        }

        if (block instanceof TrapdoorBlock) {
            return Optional.of(haunted.getDefaultState()
                    .with(TrapdoorBlock.FACING, state.get(TrapdoorBlock.FACING))
                    .with(TrapdoorBlock.HALF, state.get(TrapdoorBlock.HALF))
                    .with(TrapdoorBlock.OPEN, state.get(TrapdoorBlock.OPEN))
                    .with(TrapdoorBlock.WATERLOGGED, state.get(TrapdoorBlock.WATERLOGGED)));
        }

        return Optional.of(haunted.getDefaultState());
    }
}
