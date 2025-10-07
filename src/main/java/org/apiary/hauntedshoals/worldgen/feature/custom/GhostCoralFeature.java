package org.apiary.hauntedshoals.worldgen.feature.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.apiary.hauntedshoals.util.ModTags;

import java.util.Optional;

public class GhostCoralFeature
        extends Feature<DefaultFeatureConfig> {
    public GhostCoralFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Optional<Block> optional = Registries.BLOCK.getRandomEntry(ModTags.Blocks.GHOST_CORAL_BLOCKS, random).map(RegistryEntry::value);
        return optional.filter(block -> this.generateCoral(structureWorldAccess, random, blockPos, block.getDefaultState())).isPresent();
    }

    protected boolean generateCoral(WorldAccess var1, Random var2, BlockPos var3, BlockState var4) {
        return false;
    }

    protected boolean generateCoralPiece(WorldAccess world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(pos);
        if (!blockState.isOf(Blocks.WATER) && !blockState.isIn(ModTags.Blocks.GHOST_CORALS) || !world.getBlockState(blockPos).isOf(Blocks.WATER)) {
            return false;
        }
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
        if (random.nextFloat() < 0.25f) {
            Registries.BLOCK.getRandomEntry(ModTags.Blocks.GHOST_CORALS, random).map(RegistryEntry::value).ifPresent(block -> world.setBlockState(blockPos, block.getDefaultState(), Block.NOTIFY_LISTENERS));
        } else if (random.nextFloat() < 0.0f) {
            world.setBlockState(blockPos, (BlockState)Blocks.SEA_PICKLE.getDefaultState().with(SeaPickleBlock.PICKLES, random.nextInt(4) + 1), Block.NOTIFY_LISTENERS);
        }
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockPos blockPos2;
            if (!(random.nextFloat() < 0.2f) || !world.getBlockState(blockPos2 = pos.offset(direction)).isOf(Blocks.WATER)) continue;
            Registries.BLOCK.getRandomEntry(ModTags.Blocks.GHOST_WALL_CORALS, random).map(RegistryEntry::value).ifPresent(block -> {
                BlockState blockState2 = block.getDefaultState();
                if (blockState2.contains(DeadCoralWallFanBlock.FACING)) {
                    blockState2 = (BlockState)blockState2.with(DeadCoralWallFanBlock.FACING, direction);
                }
                world.setBlockState(blockPos2, blockState2, Block.NOTIFY_LISTENERS);
            });
        }
        return true;
    }
}
