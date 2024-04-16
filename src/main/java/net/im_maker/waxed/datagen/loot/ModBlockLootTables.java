package net.im_maker.waxed.datagen.loot;

import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {


        this.dropSelf(WaxedModBlocks.EMPTY_HONEYCOMB.get());
        this.dropSelf(WaxedModBlocks.WICK.get());

        this.dropSelf(WaxedModBlocks.WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WHITE_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.LIGHT_GRAY_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.GRAY_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.BLACK_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.BROWN_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.MAROON_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.ROSE_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.RED_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.CORAL_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.GINGER_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.ORANGE_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.TAN_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.BEIGE_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.YELLOW_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.AMBER_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.OLIVE_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.LIME_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.FOREST_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.GREEN_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.VERDANT_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.TEAL_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.CYAN_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.MINT_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.AQUA_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.LIGHT_BLUE_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.BLUE_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.SLATE_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.NAVY_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.INDIGO_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.PURPLE_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.MAGENTA_WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.PINK_WAX_BLOCK.get());

        this.dropSelf(WaxedModBlocks.WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.WHITE_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.LIGHT_GRAY_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.GRAY_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.BLACK_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.BROWN_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.MAROON_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.ROSE_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.RED_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.CORAL_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.GINGER_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.ORANGE_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.TAN_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.BEIGE_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.YELLOW_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.AMBER_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.OLIVE_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.LIME_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.FOREST_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.GREEN_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.VERDANT_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.TEAL_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.CYAN_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.MINT_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.AQUA_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.LIGHT_BLUE_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.BLUE_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.SLATE_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.NAVY_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.INDIGO_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.PURPLE_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.MAGENTA_WAX_PILLAR.get());
        this.dropSelf(WaxedModBlocks.PINK_WAX_PILLAR.get());

        this.dropSelf(WaxedModBlocks.WAXED_WHITE_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_LIGHT_GRAY_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_GRAY_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_BLACK_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_BROWN_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_MAROON_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_ROSE_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_RED_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_CORAL_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_GINGER_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_ORANGE_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_TAN_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_BEIGE_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_YELLOW_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_AMBER_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_OLIVE_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_LIME_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_FOREST_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_GREEN_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_VERDANT_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_TEAL_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_CYAN_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_MINT_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_AQUA_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_LIGHT_BLUE_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_BLUE_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_SLATE_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_NAVY_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_INDIGO_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_PURPLE_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_MAGENTA_CONCRETE_POWDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_PINK_CONCRETE_POWDER.get());

        this.dropSelf(WaxedModBlocks.WAXED_SAND.get());
        this.dropSelf(WaxedModBlocks.WAXED_RED_SAND.get());
        this.dropSelf(WaxedModBlocks.WAXED_GRAVEL.get());
        this.dropSelf(WaxedModBlocks.WAXED_POWDER_SNOW.get());
        this.dropSelf(WaxedModBlocks.WAXED_PRISMARINE.get());
        this.dropSelf(WaxedModBlocks.WAXED_REDSTONE_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_MAGMA_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_SOUL_SAND.get());
        this.dropSelf(WaxedModBlocks.WAXED_SPONGE.get());
        this.add(WaxedModBlocks.WAXED_COBWEB.get(),
                block -> createItemDropsFromShears(WaxedModBlocks.WAXED_COBWEB.get(), Items.STRING));
        this.dropSelf(WaxedModBlocks.WAXED_TUBE_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_BRAIN_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_BUBBLE_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_FIRE_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_HORN_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_TUBE_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_BRAIN_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_BUBBLE_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_FIRE_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_HORN_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_TUBE_CORAL_FAN.get());
        this.dropSelf(WaxedModBlocks.WAXED_BRAIN_CORAL_FAN.get());
        this.dropSelf(WaxedModBlocks.WAXED_BUBBLE_CORAL_FAN.get());
        this.dropSelf(WaxedModBlocks.WAXED_FIRE_CORAL_FAN.get());
        this.dropSelf(WaxedModBlocks.WAXED_HORN_CORAL_FAN.get());





    }

    protected LootTable.Builder createItemDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)));
    }

    protected LootTable.Builder createItemDropsFromShears(Block pBlock, Item item) {
        return createSilkTouchOrShearsDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return WaxedModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}