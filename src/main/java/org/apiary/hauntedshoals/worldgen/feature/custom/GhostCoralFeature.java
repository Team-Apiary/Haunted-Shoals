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
import org.apiary.hauntedshoals.block.ModBlocks;
import org.apiary.hauntedshoals.util.ModTags;

import java.util.Optional;

/**
 * A custom Minecraft worldgen Feature for generating "ghost coral" blocks and structures.
 * This class extends Minecraft's Feature system, allowing custom placement logic for blocks in the world.
 */
public class GhostCoralFeature extends Feature<DefaultFeatureConfig> {

    /**
     * Constructor: Passes the config codec to the superclass.
     */
    public GhostCoralFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    /**
     * Main method called by Minecraft to generate this feature.
     * @param context The context for feature generation, providing access to the world, random, and position.
     * @return true if generation was successful, false otherwise.
     */
    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();

        // Get a random block from the GHOST_CORAL_BLOCKS tag to use as the "base" coral block
        Optional<Block> optional = Registries.BLOCK
                .getRandomEntry(ModTags.Blocks.GHOST_CORAL_BLOCKS, random)
                .map(RegistryEntry::value);

        // Try to generate the coral at the given position with the chosen coral block state
        return optional
                .filter(block -> this.generateCoral(structureWorldAccess, random, blockPos, block.getDefaultState()))
                .isPresent();
    }

    /**
     * Override this method to implement the actual coral structure shape/placement logic.
     * @param var1 The world
     * @param var2 The random generator
     * @param var3 The position to generate at
     * @param var4 The block state to use for the coral
     * @return true if generation was successful
     */
    protected boolean generateCoral(WorldAccess var1, Random var2, BlockPos var3, BlockState var4) {
        // As implemented, this does nothing (to be overridden in subclasses)
        return false;
    }

    /**
     * Attempts to place a single "coral piece" (block) and its surroundings.
     * Handles checks for water, random coral additions, and wall coral fans.
     * @param world The world
     * @param random The random number generator
     * @param pos The position to place the coral
     * @param state The block state of the coral to place
     * @return true if the coral piece was successfully placed, false otherwise
     */
    protected boolean generateCoralPiece(WorldAccess world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(pos);

        // Only place coral if the current block is water or a coral, and the block above is water
        if (!blockState.isOf(Blocks.WATER) && !blockState.isOf(ModBlocks.GHOST_CORAL_BLOCK)
                || !world.getBlockState(blockPos).isOf(Blocks.WATER)) {
            return false;
        }

        // Set the base coral block
        world.setBlockState(pos, state, Block.NOTIFY_ALL);

        // 25% chance to place a random "ghost coral" on top
        if (random.nextFloat() < 0.25f) {
            Registries.BLOCK.getRandomEntry(ModTags.Blocks.GHOST_CORALS, random)
                    .map(RegistryEntry::value)
                    .ifPresent(block -> world.setBlockState(blockPos, block.getDefaultState(), Block.NOTIFY_LISTENERS));
        }
        // 0% chance (effectively never runs) to place a sea pickle (This is a bug or placeholder, as < 0.0f is never true)
        else if (random.nextFloat() < 0.0f) {
            world.setBlockState(
                    blockPos,
                    Blocks.SEA_PICKLE.getDefaultState().with(SeaPickleBlock.PICKLES, random.nextInt(4) + 1),
                    Block.NOTIFY_LISTENERS
            );
        }

        // For each horizontal direction, 20% chance to place a wall coral fan on the side (if adjacent block is water)
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockPos blockPos2 = pos.offset(direction);
            if (random.nextFloat() < 0.2f && world.getBlockState(blockPos2).isOf(Blocks.WATER)) {
                Registries.BLOCK.getRandomEntry(ModTags.Blocks.GHOST_WALL_CORALS, random)
                        .map(RegistryEntry::value)
                        .ifPresent(block -> {
                            BlockState blockState2 = block.getDefaultState();
                            if (blockState2.contains(DeadCoralWallFanBlock.FACING)) {
                                blockState2 = blockState2.with(DeadCoralWallFanBlock.FACING, direction);
                            }
                            world.setBlockState(blockPos2, blockState2, Block.NOTIFY_LISTENERS);
                        });
            }
        }
        return true;
    }
}
