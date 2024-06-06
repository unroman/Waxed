package net.im_maker.waxed.common.block.custom;

import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.im_maker.waxed.common.particles.WaxedModParticles;
import net.mehvahdjukaar.supplementaries.common.block.blocks.CandleHolderBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CandleHolders {

   public static final Supplier<Block> SOUL_CANDLE_HOLDER = () -> new CandleHolderBlock(DyeColor.BROWN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noOcclusion().noCollission().instabreak().sound(SoundType.LANTERN).pushReaction(PushReaction.DESTROY), WaxedModParticles.SMALL_SOUL_FLAME::get);
   public static final Supplier<Block> GOLD_SOUL_CANDLE_HOLDER = () -> new CandleHolderBlock(DyeColor.BROWN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noOcclusion().noCollission().instabreak().sound(SoundType.LANTERN).pushReaction(PushReaction.DESTROY), WaxedModParticles.SMALL_SOUL_FLAME::get);

    private static <T extends Block> RegistryObject<T> registerBlockS(String name, Supplier<T> block) {
        if (ModList.get().isLoaded("supplementaries")) {
            RegistryObject<T> toReturn = WaxedModBlocks.BLOCKSS.register(name, block);
            WaxedModBlocks.registerBlockItem(name, toReturn);
            return toReturn;
        } else {
            RegistryObject<T> toReturn = WaxedModBlocks.BLOCKS.register(name, block);
            WaxedModBlocks.registerBlockItem(name, toReturn);
            return toReturn;
        }
    }
}