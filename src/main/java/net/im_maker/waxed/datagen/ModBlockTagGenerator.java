package net.im_maker.waxed.datagen;

import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Waxed.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                WaxedModBlocks.WAX_BLOCK.get(),
                WaxedModBlocks.WHITE_WAX_BLOCK.get(),
                WaxedModBlocks.LIGHT_GRAY_WAX_BLOCK.get(),
                WaxedModBlocks.GRAY_WAX_BLOCK.get(),
                WaxedModBlocks.BLACK_WAX_BLOCK.get(),
                WaxedModBlocks.BROWN_WAX_BLOCK.get(),
                WaxedModBlocks.MAROON_WAX_BLOCK.get(),
                WaxedModBlocks.ROSE_WAX_BLOCK.get(),
                WaxedModBlocks.RED_WAX_BLOCK.get(),
                WaxedModBlocks.CORAL_WAX_BLOCK.get(),
                WaxedModBlocks.GINGER_WAX_BLOCK.get(),
                WaxedModBlocks.ORANGE_WAX_BLOCK.get(),
                WaxedModBlocks.TAN_WAX_BLOCK.get(),
                WaxedModBlocks.BEIGE_WAX_BLOCK.get(),
                WaxedModBlocks.YELLOW_WAX_BLOCK.get(),
                WaxedModBlocks.AMBER_WAX_BLOCK.get(),
                WaxedModBlocks.OLIVE_WAX_BLOCK.get(),
                WaxedModBlocks.LIME_WAX_BLOCK.get(),
                WaxedModBlocks.FOREST_WAX_BLOCK.get(),
                WaxedModBlocks.GREEN_WAX_BLOCK.get(),
                WaxedModBlocks.VERDANT_WAX_BLOCK.get(),
                WaxedModBlocks.TEAL_WAX_BLOCK.get(),
                WaxedModBlocks.CYAN_WAX_BLOCK.get(),
                WaxedModBlocks.MINT_WAX_BLOCK.get(),
                WaxedModBlocks.AQUA_WAX_BLOCK.get(),
                WaxedModBlocks.LIGHT_BLUE_WAX_BLOCK.get(),
                WaxedModBlocks.BLUE_WAX_BLOCK.get(),
                WaxedModBlocks.SLATE_WAX_BLOCK.get(),
                WaxedModBlocks.NAVY_WAX_BLOCK.get(),
                WaxedModBlocks.INDIGO_WAX_BLOCK.get(),
                WaxedModBlocks.PURPLE_WAX_BLOCK.get(),
                WaxedModBlocks.MAGENTA_WAX_BLOCK.get(),
                WaxedModBlocks.PINK_WAX_BLOCK.get(),
                WaxedModBlocks.WAX_PILLAR.get(),
                WaxedModBlocks.WHITE_WAX_PILLAR.get(),
                WaxedModBlocks.LIGHT_GRAY_WAX_PILLAR.get(),
                WaxedModBlocks.GRAY_WAX_PILLAR.get(),
                WaxedModBlocks.BLACK_WAX_PILLAR.get(),
                WaxedModBlocks.BROWN_WAX_PILLAR.get(),
                WaxedModBlocks.MAROON_WAX_PILLAR.get(),
                WaxedModBlocks.ROSE_WAX_PILLAR.get(),
                WaxedModBlocks.RED_WAX_PILLAR.get(),
                WaxedModBlocks.CORAL_WAX_PILLAR.get(),
                WaxedModBlocks.GINGER_WAX_PILLAR.get(),
                WaxedModBlocks.ORANGE_WAX_PILLAR.get(),
                WaxedModBlocks.TAN_WAX_PILLAR.get(),
                WaxedModBlocks.BEIGE_WAX_PILLAR.get(),
                WaxedModBlocks.YELLOW_WAX_PILLAR.get(),
                WaxedModBlocks.AMBER_WAX_PILLAR.get(),
                WaxedModBlocks.OLIVE_WAX_PILLAR.get(),
                WaxedModBlocks.LIME_WAX_PILLAR.get(),
                WaxedModBlocks.FOREST_WAX_PILLAR.get(),
                WaxedModBlocks.GREEN_WAX_PILLAR.get(),
                WaxedModBlocks.VERDANT_WAX_PILLAR.get(),
                WaxedModBlocks.TEAL_WAX_PILLAR.get(),
                WaxedModBlocks.CYAN_WAX_PILLAR.get(),
                WaxedModBlocks.MINT_WAX_PILLAR.get(),
                WaxedModBlocks.AQUA_WAX_PILLAR.get(),
                WaxedModBlocks.LIGHT_BLUE_WAX_PILLAR.get(),
                WaxedModBlocks.BLUE_WAX_PILLAR.get(),
                WaxedModBlocks.SLATE_WAX_PILLAR.get(),
                WaxedModBlocks.NAVY_WAX_PILLAR.get(),
                WaxedModBlocks.INDIGO_WAX_PILLAR.get(),
                WaxedModBlocks.PURPLE_WAX_PILLAR.get(),
                WaxedModBlocks.MAGENTA_WAX_PILLAR.get(),
                WaxedModBlocks.PINK_WAX_PILLAR.get(),
                WaxedModBlocks.WAXED_REDSTONE_BLOCK.get(),
                WaxedModBlocks.WAXED_PRISMARINE.get(),
                WaxedModBlocks.WAXED_MAGMA_BLOCK.get(),
                WaxedModBlocks.WAXED_TUBE_CORAL_BLOCK.get(),
                WaxedModBlocks.WAXED_BRAIN_CORAL_BLOCK.get(),
                WaxedModBlocks.WAXED_BUBBLE_CORAL_BLOCK.get(),
                WaxedModBlocks.WAXED_FIRE_CORAL_BLOCK.get(),
                WaxedModBlocks.WAXED_HORN_CORAL_BLOCK.get()
        );

        //this.tag(Blocks.SAND.defaultBlockState().getTags().).add(ModBlocks.WAXED_SAND.get());


        for (int i = 0; i < Blocks.SAND.defaultBlockState().getTags().toList().size(); i++) {
            this.tag( WaxedModBlocks.WAX_PILLAR.get().defaultBlockState().getTags().toList().get(i)).add(WaxedModBlocks.WAXED_SAND.get());
        }

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                WaxedModBlocks.WAX_BLOCK.get(),
                WaxedModBlocks.WHITE_WAX_BLOCK.get(),
                WaxedModBlocks.LIGHT_GRAY_WAX_BLOCK.get(),
                WaxedModBlocks.GRAY_WAX_BLOCK.get(),
                WaxedModBlocks.BLACK_WAX_BLOCK.get(),
                WaxedModBlocks.BROWN_WAX_BLOCK.get(),
                WaxedModBlocks.MAROON_WAX_BLOCK.get(),
                WaxedModBlocks.ROSE_WAX_BLOCK.get(),
                WaxedModBlocks.RED_WAX_BLOCK.get(),
                WaxedModBlocks.CORAL_WAX_BLOCK.get(),
                WaxedModBlocks.GINGER_WAX_BLOCK.get(),
                WaxedModBlocks.ORANGE_WAX_BLOCK.get(),
                WaxedModBlocks.TAN_WAX_BLOCK.get(),
                WaxedModBlocks.BEIGE_WAX_BLOCK.get(),
                WaxedModBlocks.YELLOW_WAX_BLOCK.get(),
                WaxedModBlocks.AMBER_WAX_BLOCK.get(),
                WaxedModBlocks.OLIVE_WAX_BLOCK.get(),
                WaxedModBlocks.LIME_WAX_BLOCK.get(),
                WaxedModBlocks.FOREST_WAX_BLOCK.get(),
                WaxedModBlocks.GREEN_WAX_BLOCK.get(),
                WaxedModBlocks.VERDANT_WAX_BLOCK.get(),
                WaxedModBlocks.TEAL_WAX_BLOCK.get(),
                WaxedModBlocks.CYAN_WAX_BLOCK.get(),
                WaxedModBlocks.MINT_WAX_BLOCK.get(),
                WaxedModBlocks.AQUA_WAX_BLOCK.get(),
                WaxedModBlocks.LIGHT_BLUE_WAX_BLOCK.get(),
                WaxedModBlocks.BLUE_WAX_BLOCK.get(),
                WaxedModBlocks.SLATE_WAX_BLOCK.get(),
                WaxedModBlocks.NAVY_WAX_BLOCK.get(),
                WaxedModBlocks.INDIGO_WAX_BLOCK.get(),
                WaxedModBlocks.PURPLE_WAX_BLOCK.get(),
                WaxedModBlocks.MAGENTA_WAX_BLOCK.get(),
                WaxedModBlocks.PINK_WAX_BLOCK.get(),
                WaxedModBlocks.WAX_PILLAR.get(),
                WaxedModBlocks.WHITE_WAX_PILLAR.get(),
                WaxedModBlocks.LIGHT_GRAY_WAX_PILLAR.get(),
                WaxedModBlocks.GRAY_WAX_PILLAR.get(),
                WaxedModBlocks.BLACK_WAX_PILLAR.get(),
                WaxedModBlocks.BROWN_WAX_PILLAR.get(),
                WaxedModBlocks.MAROON_WAX_PILLAR.get(),
                WaxedModBlocks.ROSE_WAX_PILLAR.get(),
                WaxedModBlocks.RED_WAX_PILLAR.get(),
                WaxedModBlocks.CORAL_WAX_PILLAR.get(),
                WaxedModBlocks.GINGER_WAX_PILLAR.get(),
                WaxedModBlocks.ORANGE_WAX_PILLAR.get(),
                WaxedModBlocks.TAN_WAX_PILLAR.get(),
                WaxedModBlocks.BEIGE_WAX_PILLAR.get(),
                WaxedModBlocks.YELLOW_WAX_PILLAR.get(),
                WaxedModBlocks.AMBER_WAX_PILLAR.get(),
                WaxedModBlocks.OLIVE_WAX_PILLAR.get(),
                WaxedModBlocks.LIME_WAX_PILLAR.get(),
                WaxedModBlocks.FOREST_WAX_PILLAR.get(),
                WaxedModBlocks.GREEN_WAX_PILLAR.get(),
                WaxedModBlocks.VERDANT_WAX_PILLAR.get(),
                WaxedModBlocks.TEAL_WAX_PILLAR.get(),
                WaxedModBlocks.CYAN_WAX_PILLAR.get(),
                WaxedModBlocks.MINT_WAX_PILLAR.get(),
                WaxedModBlocks.AQUA_WAX_PILLAR.get(),
                WaxedModBlocks.LIGHT_BLUE_WAX_PILLAR.get(),
                WaxedModBlocks.BLUE_WAX_PILLAR.get(),
                WaxedModBlocks.SLATE_WAX_PILLAR.get(),
                WaxedModBlocks.NAVY_WAX_PILLAR.get(),
                WaxedModBlocks.INDIGO_WAX_PILLAR.get(),
                WaxedModBlocks.PURPLE_WAX_PILLAR.get(),
                WaxedModBlocks.MAGENTA_WAX_PILLAR.get(),
                WaxedModBlocks.PINK_WAX_PILLAR.get(),
                WaxedModBlocks.WAXED_WHITE_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_LIGHT_GRAY_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_GRAY_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_BLACK_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_BROWN_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_MAROON_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_ROSE_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_RED_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_CORAL_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_GINGER_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_ORANGE_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_TAN_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_BEIGE_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_YELLOW_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_AMBER_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_OLIVE_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_LIME_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_FOREST_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_GREEN_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_VERDANT_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_TEAL_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_CYAN_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_MINT_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_AQUA_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_LIGHT_BLUE_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_BLUE_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_SLATE_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_NAVY_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_INDIGO_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_PURPLE_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_MAGENTA_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_PINK_CONCRETE_POWDER.get(),
                WaxedModBlocks.WAXED_SAND.get(),
                WaxedModBlocks.WAXED_RED_SAND.get(),
                WaxedModBlocks.WAXED_GRAVEL.get(),
                WaxedModBlocks.WAXED_POWDER_SNOW.get(),
                WaxedModBlocks.WAXED_SOUL_SAND.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(
                WaxedModBlocks.WAXED_SPONGE.get()
        );

        this.tag(BlockTags.BAMBOO_PLANTABLE_ON).add(
                WaxedModBlocks.WAXED_SAND.get(),
                WaxedModBlocks.WAXED_RED_SAND.get(),
                WaxedModBlocks.WAXED_GRAVEL.get()
        );

        this.tag(BlockTags.SAND).add(
                WaxedModBlocks.WAXED_SAND.get(),
                WaxedModBlocks.WAXED_RED_SAND.get()
        );

        this.tag(BlockTags.SMELTS_TO_GLASS).add(
                WaxedModBlocks.WAXED_SAND.get(),
                WaxedModBlocks.WAXED_RED_SAND.get()
        );

        this.tag(Tags.Blocks.SAND).add(
                WaxedModBlocks.WAXED_SAND.get(),
                WaxedModBlocks.WAXED_RED_SAND.get()
        );

        this.tag(Tags.Blocks.SAND_COLORLESS).add(
                WaxedModBlocks.WAXED_SAND.get()
        );

        this.tag(Tags.Blocks.SAND_RED).add(
                WaxedModBlocks.WAXED_RED_SAND.get()
        );

        this.tag(BlockTags.SNOW).add(
                WaxedModBlocks.WAXED_POWDER_SNOW.get()
        );

        this.tag(BlockTags.INFINIBURN_OVERWORLD).add(
                WaxedModBlocks.WAXED_MAGMA_BLOCK.get()
        );

        this.tag(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON).add(
                WaxedModBlocks.WAXED_SOUL_SAND.get()
        );

        this.tag(BlockTags.SOUL_SPEED_BLOCKS).add(
                WaxedModBlocks.WAXED_SOUL_SAND.get()
        );

        this.tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(
                WaxedModBlocks.WAXED_SOUL_SAND.get()
        );

        this.tag(BlockTags.WITHER_SUMMON_BASE_BLOCKS).add(
                WaxedModBlocks.WAXED_SOUL_SAND.get()
        );

        this.tag(Tags.Blocks.STORAGE_BLOCKS).add(
                WaxedModBlocks.WAXED_REDSTONE_BLOCK.get()
        );

        this.tag(Tags.Blocks.STORAGE_BLOCKS_REDSTONE).add(
                WaxedModBlocks.WAXED_REDSTONE_BLOCK.get()
        );

    }
}