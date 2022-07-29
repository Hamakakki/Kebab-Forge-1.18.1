package net.hamakakki13.forgekebab.block.custom;

import net.hamakakki13.forgekebab.block.entity.Kebab_PaistinBlockEntity;
import net.hamakakki13.forgekebab.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class Kebab_Paistin extends BaseEntityBlock {

    public  static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public Kebab_Paistin(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));

    }


    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(2, 28, 13, 3, 30, 14),
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(0, 4, 0, 16, 6, 16),
            Block.box(7, 6, 3, 9, 30, 5),
            Block.box(0, 30, 0, 16, 32, 15),
            Block.box(7, 2, 3, 9, 4, 5),
            Block.box(0, 6, 15, 16, 32, 16),
            Block.box(0, 6, 10, 1, 30, 15),
            Block.box(15, 6, 10, 16, 30, 15),
            Block.box(0, 2, 15, 16, 4, 16),
            Block.box(0, 2, 7, 16, 4, 8),
            Block.box(0, 2, 8, 1, 4, 15),
            Block.box(15, 2, 8, 16, 4, 15),
            Block.box(3, 7, 13, 13, 8, 14),
            Block.box(3, 12, 13, 13, 13, 14),
            Block.box(3, 17, 13, 13, 18, 14),
            Block.box(3, 22, 13, 13, 23, 14),
            Block.box(3, 27, 13, 13, 28, 14),
            Block.box(2, 8, 13, 3, 12, 14),
            Block.box(2, 18, 13, 3, 22, 14),
            Block.box(13, 13, 13, 14, 17, 14),
            Block.box(13, 23, 13, 14, 27, 14),
            Block.box(13, 6, 13, 14, 7, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(13, 28, 13, 14, 30, 14),
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(0, 4, 0, 16, 6, 16),
            Block.box(3, 6, 7, 5, 30, 9),
            Block.box(0, 30, 0, 15, 32, 16),
            Block.box(3, 2, 7, 5, 4, 9),
            Block.box(15, 6, 0, 16, 32, 16),
            Block.box(10, 6, 15, 15, 30, 16),
            Block.box(10, 6, 0, 15, 30, 1),
            Block.box(15, 2, 0, 16, 4, 16),
            Block.box(7, 2, 0, 8, 4, 16),
            Block.box(8, 2, 15, 15, 4, 16),
            Block.box(8, 2, 0, 15, 4, 1),
            Block.box(13, 7, 3, 14, 8, 13),
            Block.box(13, 12, 3, 14, 13, 13),
            Block.box(13, 17, 3, 14, 18, 13),
            Block.box(13, 22, 3, 14, 23, 13),
            Block.box(13, 27, 3, 14, 28, 13),
            Block.box(13, 8, 13, 14, 12, 14),
            Block.box(13, 18, 13, 14, 22, 14),
            Block.box(13, 13, 2, 14, 17, 3),
            Block.box(13, 23, 2, 14, 27, 3),
            Block.box(13, 6, 2, 14, 7, 3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(13, 28, 2, 14, 30, 3),
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(0, 4, 0, 16, 6, 16),
            Block.box(7, 6, 11, 9, 30, 13),
            Block.box(0, 30, 1, 16, 32, 16),
            Block.box(7, 2, 11, 9, 4, 13),
            Block.box(0, 6, 0, 16, 32, 1),
            Block.box(15, 6, 1, 16, 30, 6),
            Block.box(0, 6, 1, 1, 30, 6),
            Block.box(0, 2, 0, 16, 4, 1),
            Block.box(0, 2, 8, 16, 4, 9),
            Block.box(15, 2, 1, 16, 4, 8),
            Block.box(0, 2, 1, 1, 4, 8),
            Block.box(3, 7, 2, 13, 8, 3),
            Block.box(3, 12, 2, 13, 13, 3),
            Block.box(3, 17, 2, 13, 18, 3),
            Block.box(3, 22, 2, 13, 23, 3),
            Block.box(3, 27, 2, 13, 28, 3),
            Block.box(13, 8, 2, 14, 12, 3),
            Block.box(13, 18, 2, 14, 22, 3),
            Block.box(2, 13, 2, 3, 17, 3),
            Block.box(2, 23, 2, 3, 27, 3),
            Block.box(2, 6, 2, 3, 7, 3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(2, 28, 2, 3, 30, 3),
            Block.box(0, 0, 0, 16, 2, 16),
            Block.box(0, 4, 0, 16, 6, 16),
            Block.box(11, 6, 7, 13, 30, 9),
            Block.box(1, 30, 0, 16, 32, 16),
            Block.box(11, 2, 7, 13, 4, 9),
            Block.box(0, 6, 0, 1, 32, 16),
            Block.box(1, 6, 0, 6, 30, 1),
            Block.box(1, 6, 15, 6, 30, 16),
            Block.box(0, 2, 0, 1, 4, 16),
            Block.box(8, 2, 0, 9, 4, 16),
            Block.box(1, 2, 0, 8, 4, 1),
            Block.box(1, 2, 15, 8, 4, 16),
            Block.box(2, 7, 3, 3, 8, 13),
            Block.box(2, 12, 3, 3, 13, 13),
            Block.box(2, 17, 3, 3, 18, 13),
            Block.box(2, 22, 3, 3, 23, 13),
            Block.box(2, 27, 3, 3, 28, 13),
            Block.box(2, 8, 2, 3, 12, 3),
            Block.box(2, 18, 2, 3, 22, 3),
            Block.box(2, 13, 13, 3, 17, 14),
            Block.box(2, 23, 13, 3, 27, 14),
            Block.box(2, 6, 13, 3, 7, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof Kebab_PaistinBlockEntity) {
                ((Kebab_PaistinBlockEntity) blockEntity).drops();
            }
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity((pPos));
            if (entity instanceof Kebab_PaistinBlockEntity) {
                NetworkHooks.openGui(((ServerPlayer)pPlayer), (Kebab_PaistinBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new Kebab_PaistinBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.KEBAB_PAISTIN.get(), Kebab_PaistinBlockEntity::tick);
    }
}
   // public static final BooleanProperty ONKEBAB = BooleanProperty.create("onkebab");
/*





    //@Override
    //public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
       // if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
          //  boolean currentState = pState.getValue(ONKEBAB);
          //  pLevel.setBlock(pPos, pState.setValue(ONKEBAB, !currentState), 3);
       // }

      //  return InteractionResult.SUCCESS;

   // }


    @Nullable








    @Override
    public BlockState rotate(BlockState state, LevelAccessor world, BlockPos pos, Rotation direction) {
        return super.rotate(state, world, pos, direction);
    }
}*/
