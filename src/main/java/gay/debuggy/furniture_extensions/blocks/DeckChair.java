package gay.debuggy.furniture_extensions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class DeckChair extends HorizontalFacingBlock {
	protected static final VoxelShape SLAB = Block.createCuboidShape(0, 0, 0, 16, 8, 16);
	public DeckChair(Settings settings) {
		super(settings);
		setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
		return VoxelShapes.empty();
	}
	
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		return SLAB;
	}
	
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getPlayerFacing().getOpposite());
	}
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(Properties.HORIZONTAL_FACING);
	}
}
