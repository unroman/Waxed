package net.im_maker.waxed.common.block.custom;

import net.im_maker.waxed.common.tags.WaxedModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.ToIntFunction;

public class CandleStringBlock extends Block {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final ToIntFunction<BlockState> LIGHT_EMISSION = (blockState) -> {
        return blockState.getValue(LIT) ? 15 : 0;
    };
    private static final VoxelShape Shape = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 12.0D, 11.0D);
    private final int fireDamage;
    public CandleStringBlock(int pFireDamage, Properties properties) {
        super(properties);
        this.fireDamage = pFireDamage;
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)));
    }

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pState.getValue(LIT) && pEntity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)pEntity)) {
            pEntity.hurt(pLevel.damageSources().inFire(), (float)this.fireDamage);
            pEntity.setSecondsOnFire(2);
        }
        super.entityInside(pState, pLevel, pPos, pEntity);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockPos blockBelowPos = pPos.below();
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if ((itemStack.is(Items.FLINT_AND_STEEL) || itemStack.is(Items.FIRE_CHARGE)) && pState.getValue(LIT) == false) {
            Item item = itemStack.getItem();
            if (item.equals(Items.FLINT_AND_STEEL)) {
                itemStack.hurtAndBreak(1, pPlayer, (player) -> {
                    player.broadcastBreakEvent(pHand);
                });
                pLevel.playSound(pPlayer, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, pLevel.getRandom().nextFloat() * 0.4F + 0.8F);
            } else if (item.equals(Items.FIRE_CHARGE)) {
                if (!pPlayer.isCreative()) {
                    itemStack.shrink(1);
                }
                RandomSource randomsource = pLevel.getRandom();
                pLevel.playSound((Player) null, pPos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0F, (randomsource.nextFloat() - randomsource.nextFloat()) * 0.2F + 1.0F);
            }


           pLevel.setBlockAndUpdate(pPos, pState.setValue(LIT, true));
           pLevel.playSound((Player)null, pPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
           pLevel.updateNeighborsAt(blockBelowPos, pLevel.getBlockState(blockBelowPos).getBlock());
           return InteractionResult.sidedSuccess(pLevel.isClientSide);
       }
       if (pPlayer.getAbilities().mayBuild && pPlayer.getItemInHand(pHand).isEmpty() && pState.getValue(LIT)) {
           pLevel.setBlockAndUpdate(pPos, pState.setValue(LIT, false));
           pLevel.playSound((Player)null, pPos, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 1.0F, 1.0F);
           return InteractionResult.sidedSuccess(pLevel.isClientSide);
       }
        return InteractionResult.PASS;
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            Vec3 vec3 = new Vec3(pPos.getX() + 0.5D, pPos.getY() + 0.9D, pPos.getZ() + 0.5D);
            addParticlesAndSound(pLevel, vec3, pRandom);
        }
    }

    private static void addParticlesAndSound(Level pLevel, Vec3 pOffset, RandomSource pRandom) {
        float f = pRandom.nextFloat();
        if (f < 0.7F) {
            pLevel.addParticle(ParticleTypes.LARGE_SMOKE, pOffset.x, pOffset.y, pOffset.z, 0.0D, 0.0D, 0.0D);
            if (f < 0.4F) {
                pLevel.playLocalSound(pOffset.x + 0.5D, pOffset.y + 0.5D, pOffset.z + 0.5D, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + pRandom.nextFloat(), pRandom.nextFloat() * 0.7F + 0.3F, false);
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shape;
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos1) {
        return direction == Direction.DOWN && !this.canSurvive(blockState, levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockState1, levelAccessor, blockPos, blockPos1);
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockPosBelow = blockPos.below();
        BlockState blockStateBelow = levelReader.getBlockState(blockPosBelow);
        return (blockStateBelow.is(WaxedModBlockTags.WAX_PILLARS) && (blockStateBelow.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y) && canSupportCenter(levelReader, blockPosBelow, Direction.UP));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }
}