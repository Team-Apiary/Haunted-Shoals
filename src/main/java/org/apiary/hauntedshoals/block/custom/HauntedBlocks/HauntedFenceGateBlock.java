package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.WoodType;
import net.minecraft.util.math.Direction;

public class HauntedFenceGateBlock extends FenceGateBlock {
    public HauntedFenceGateBlock(WoodType type, Settings settings) {
        super(type, settings);
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(this)) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }
}
