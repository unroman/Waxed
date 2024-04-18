package net.im_maker.waxed.datagen;

import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.im_maker.waxed.common.block.block_values.WaxedModBlockStateProperties;
import net.im_maker.waxed.common.item.WaxedModItems;
import net.im_maker.waxed.common.tags.WaxedModBlockTags;
import net.im_maker.waxed.common.tags.WaxedModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import javax.swing.text.html.HTML;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Waxed.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.copy(WaxedModBlockTags.WAX_PILLARS, WaxedModItemTags.WAX_PILLARS);

        this.tag(WaxedModItemTags.CAN_WAX).add(
                WaxedModItems.WAX.get(),
                Items.HONEYCOMB
        );

        this.tag(ItemTags.CANDLES).add(
                WaxedModBlocks.SOUL_CANDLE.get().asItem()
        );

        this.tag(Tags.Items.GRAVEL).add(
                WaxedModBlocks.WAXED_GRAVEL.get().asItem()
        );

        this.tag(Tags.Items.SAND).add(
                WaxedModBlocks.WAXED_SAND.get().asItem(),
                WaxedModBlocks.WAXED_RED_SAND.get().asItem()
        );

        this.tag(Tags.Items.SAND_COLORLESS).add(
                WaxedModBlocks.WAXED_SAND.get().asItem()
        );

        this.tag(Tags.Items.SAND_RED).add(
                WaxedModBlocks.WAXED_RED_SAND.get().asItem()
        );

        this.tag(ItemTags.SAND).add(
                WaxedModBlocks.WAXED_SAND.get().asItem(),
                WaxedModBlocks.WAXED_RED_SAND.get().asItem()
        );

        this.tag(ItemTags.SMELTS_TO_GLASS).add(
                WaxedModBlocks.WAXED_SAND.get().asItem(),
                WaxedModBlocks.WAXED_RED_SAND.get().asItem()
        );

        this.tag(ItemTags.SOUL_FIRE_BASE_BLOCKS).add(
                WaxedModBlocks.WAXED_SOUL_SAND.get().asItem()
        );

    }
}