package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.util.math.Direction;

public class HauntedFenceBlock extends FenceBlock {
    public HauntedFenceBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(this)) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }
}
