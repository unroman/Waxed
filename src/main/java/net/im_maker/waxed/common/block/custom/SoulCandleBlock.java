package net.im_maker.waxed.common.block.custom;

import net.im_maker.waxed.common.particles.WaxedModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.function.ToIntFunction;

public class SoulCandleBlock extends CandleBlock {
    public static final ToIntFunction<BlockState> LIGHT_EMISSION = (blockState) -> {
        return blockState.getValue(LIT) ? 2 * blockState.getValue(CANDLES) : 0;
    };
    public SoulCandleBlock(Properties pProperties) {
        super(pProperties);
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(LIT)) {
            this.getParticleOffsets(pState).forEach((p_220695_) -> {
                addParticlesAndSound(pLevel, p_220695_.add((double)pPos.getX(), (double)pPos.getY(), (double)pPos.getZ()), pRandom);
            });
        }
    }

    private static void addParticlesAndSound(Level pLevel, Vec3 pOffset, RandomSource pRandom) {
        float f = pRandom.nextFloat();
        if (f < 0.3F) {
            pLevel.addParticle(ParticleTypes.SMOKE, pOffset.x, pOffset.y, pOffset.z, 0.0D, 0.0D, 0.0D);
            if (f < 0.17F) {
                pLevel.playLocalSound(pOffset.x + 0.5D, pOffset.y + 0.5D, pOffset.z + 0.5D, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + pRandom.nextFloat(), pRandom.nextFloat() * 0.7F + 0.3F, false);
            }
        }

        pLevel.addParticle(WaxedModParticles.SMALL_SOUL_FLAME.get(), pOffset.x, pOffset.y, pOffset.z, 0.0D, 0.0D, 0.0D);
    }

}