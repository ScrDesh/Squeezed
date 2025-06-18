package straight.squeezin.it.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;

public class BlightedVineBlock extends VineBlock {

    public BlightedVineBlock(Settings settings) {
        super(settings);
    }

    private BlockState getGrownState(BlockState above, BlockState state, Random random) {
        for (Direction direction : Direction.Type.HORIZONTAL) {
            if (random.nextBoolean()) {
                BooleanProperty booleanProperty = getFacingProperty(direction);
                if ((Boolean)above.get(booleanProperty)) {
                    state = state.with(booleanProperty, true);
                }
            }
        }

        return state;
    }

    private boolean canGrowAt(BlockView world, BlockPos pos) {
        int i = 4;
        Iterable<BlockPos> iterable = BlockPos.iterate(pos.getX() - 4, pos.getY() - 1, pos.getZ() - 4, pos.getX() + 4, pos.getY() + 1, pos.getZ() + 4);
        int j = 5;

        for (BlockPos blockPos : iterable) {
            if (world.getBlockState(blockPos).isOf(this)) {
                if (++j <= 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
