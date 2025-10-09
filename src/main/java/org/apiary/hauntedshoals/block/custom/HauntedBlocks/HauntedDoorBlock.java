package org.apiary.hauntedshoals.block.custom.HauntedBlocks;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.util.math.Direction;

public class HauntedDoorBlock extends DoorBlock {
    public HauntedDoorBlock(BlockSetType type, Settings settings) {
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
