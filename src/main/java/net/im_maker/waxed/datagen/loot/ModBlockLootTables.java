package net.im_maker.waxed.datagen.loot;

import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(WaxedModBlocks.EMPTY_HONEYCOMB.get());
        this.dropSelf(WaxedModBlocks.WICK.get());
        this.add(WaxedModBlocks.SOUL_WICK.get(), createItemDrops(WaxedModBlocks.SOUL_WICK.get(), WaxedModBlocks.WICK.get().asItem()));
        this.add(WaxedModBlocks.SOUL_CANDLE.get(), (block) -> {
            return this.createCandleDrops(block);
        });
        this.add(WaxedModBlocks.SOUL_CANDLE_HOLDER.get(), (block) -> {
            return this.createCandleDrops(block);
        });
        this.add(WaxedModBlocks.GOLD_SOUL_CANDLE_HOLDER.get(), (block) -> {
            return this.createCandleDrops(block);
        });
        this.add(WaxedModBlocks.SOUL_CANDLE_CAKE.get(), createCandleCakeDrops(WaxedModBlocks.SOUL_CANDLE.get()));

        this.dropSelf(WaxedModBlocks.WAX_BLOCK.get());
        this.dropSelf(WaxedModBlocks.SOUL_WAX_BLOCK.get());
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
        this.dropSelf(WaxedModBlocks.SOUL_WAX_PILLAR.get());
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
        this.dropSelf(WaxedModBlocks.WAXED_PRISMARINE_STAIRS.get());
        this.dropSelf(WaxedModBlocks.WAXED_PRISMARINE_SLAB.get());
        this.dropSelf(WaxedModBlocks.WAXED_PRISMARINE_WALL.get());
        this.dropSelf(WaxedModBlocks.WAXED_REDSTONE_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_MAGMA_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_SOUL_SAND.get());
        this.dropSelf(WaxedModBlocks.WAXED_SPONGE.get());
        this.add(WaxedModBlocks.WAXED_COBWEB.get(), block -> createItemDropsFromShears(WaxedModBlocks.WAXED_COBWEB.get(), Items.STRING));
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

        this.dropSelf(WaxedModBlocks.WAXED_ACAN_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_ACAN_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_ACAN_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_FINGER_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_FINGER_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_FINGER_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_STAR_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_STAR_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_STAR_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_MOSS_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_MOSS_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_MOSS_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_PETAL_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_PETAL_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_PETAL_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_BRANCH_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_BRANCH_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_BRANCH_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_ROCK_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_ROCK_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_ROCK_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_PILLOW_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_PILLOW_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_PILLOW_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_SILK_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_SILK_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_SILK_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_CHROME_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_CHROME_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_CHROME_CORAL_FAN.get());

        this.dropSelf(WaxedModBlocks.WAXED_PRISMARINE_CORAL_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_PRISMARINE_CORAL.get());
        this.dropSelf(WaxedModBlocks.WAXED_PRISMARINE_CORAL_FAN.get());
        this.dropSelf(WaxedModBlocks.WAXED_PRISMARINE_CORAL_SHOWER.get());

        this.dropSelf(WaxedModBlocks.WAXED_FODDER.get());
        this.dropSelf(WaxedModBlocks.WAXED_SUGAR_CUBE.get());
        this.dropSelf(WaxedModBlocks.WAXED_SOAP_BLOCK.get());
        this.dropSelf(WaxedModBlocks.WAXED_FEATHER_BLOCK.get());

    }

    protected LootTable.Builder createCandleDrops(Block pCandleBlock) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(this.applyExplosionDecay(pCandleBlock, LootItem.lootTableItem(pCandleBlock).apply(List.of(2, 3, 4), (integer) -> {
            return SetItemCountFunction.setCount(ConstantValue.exactly((float)integer.intValue())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pCandleBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CandleBlock.CANDLES, integer)));
        }))));
    }

    protected LootTable.Builder createItemDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)));
    }

    protected static LootTable.Builder createCandleCakeDrops(Block pCandleCakeBlock) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pCandleCakeBlock)));
    }

    protected LootTable.Builder createItemDropsFromShears(Block pBlock, Item item) {
        return createSilkTouchOrShearsDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        Stream<Block> blockStream = Stream.concat(
                WaxedModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get),
                WaxedModBlocks.BLOCKSS.getEntries().stream().map(RegistryObject::get)
        );
        return blockStream::iterator;
    }
}