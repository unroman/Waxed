package net.im_maker.waxed.common.block;

import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.custom.*;
import net.im_maker.waxed.common.item.WaxedModItems;
import net.im_maker.waxed.common.particles.WaxedModParticles;
import net.mehvahdjukaar.amendments.Amendments;
import net.mehvahdjukaar.amendments.common.block.FloorCandleSkullBlock;
import net.mehvahdjukaar.amendments.common.block.WallCandleSkullBlock;
import net.mehvahdjukaar.amendments.integration.CompatHandler;
import net.mehvahdjukaar.amendments.integration.CompatObjects;
import net.mehvahdjukaar.amendments.reg.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class WaxedModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Waxed.MOD_ID);
    public static final DeferredRegister<Block> BLOCKSS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, "supplementaries");
    //Stuff
    public static final RegistryObject<Block> EMPTY_HONEYCOMB = registerBlock("empty_honeycomb", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.6f).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WICK = registerBlock("wick", () -> new WickBlock(1, BlockBehaviour.Properties.of().noCollission().lightLevel(WickBlock.LIGHT_EMISSION).strength(0.1f).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SOUL_WICK = BLOCKS.register("soul_wick", () -> new WickBlock(2, BlockBehaviour.Properties.of().noCollission().lightLevel(WickBlock.SOUL_LIGHT_EMISSION).strength(0.1f).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SOUL_CANDLE = registerBlock("soul_candle", () -> new SoulCandleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noOcclusion().strength(0.1F).sound(SoundType.CANDLE).lightLevel(SoulCandleBlock.LIGHT_EMISSION).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SOUL_CANDLE_CAKE = BLOCKS.register("soul_candle_cake", () -> new SoulCandleCakeBlock(SOUL_CANDLE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE).lightLevel(litBlockEmission(2))));
    //Supplementaries
    public static final RegistryObject<Block> SOUL_CANDLE_HOLDER = registerBlockS("soul_candle_holder", () -> ModList.get().isLoaded("supplementaries") ? CandleHolders.SOUL_CANDLE_HOLDER.get() : new SoulCandleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noOcclusion().strength(0.1F).sound(SoundType.CANDLE).lightLevel(SoulCandleBlock.LIGHT_EMISSION).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GOLD_SOUL_CANDLE_HOLDER = registerBlock("gold_soul_candle_holder", () -> ModList.get().isLoaded("suppsquared") ? CandleHolders.GOLD_SOUL_CANDLE_HOLDER.get() : new SoulCandleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noOcclusion().strength(0.1F).sound(SoundType.CANDLE).lightLevel(SoulCandleBlock.LIGHT_EMISSION).pushReaction(PushReaction.DESTROY)));
    //public static final RegistryObject<Block> SKULL_CANDLE_SOUL = registerBlock("skull_candle_soul", () -> new FloorCandleSkullBlock(BlockBehaviour.Properties.copy(ModRegistry.SKULL_CANDLE.get()), WaxedModParticles.SMALL_SOUL_FLAME::get));
    //public static final RegistryObject<Block> SKULL_CANDLE_SOUL_WALL = registerBlock("skull_candle_soul_wall", () -> new WallCandleSkullBlock(BlockBehaviour.Properties.copy(ModRegistry.SKULL_CANDLE.get()), WaxedModParticles.SMALL_SOUL_FLAME::get));
    //Wax Blocks
    public static final RegistryObject<Block> WAX_BLOCK = registerBlock("wax_block", () -> wax_block(MapColor.SAND));
    public static final RegistryObject<Block> SOUL_WAX_BLOCK = registerBlock("soul_wax_block", () -> wax_block(MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> RED_WAX_BLOCK = registerBlock("red_wax_block", () -> wax_block(MapColor.COLOR_RED));
    public static final RegistryObject<Block> ORANGE_WAX_BLOCK = registerBlock("orange_wax_block", () -> wax_block(MapColor.COLOR_ORANGE));
    public static final RegistryObject<Block> YELLOW_WAX_BLOCK = registerBlock("yellow_wax_block", () -> wax_block(MapColor.COLOR_YELLOW));
    public static final RegistryObject<Block> LIME_WAX_BLOCK = registerBlock("lime_wax_block", () -> wax_block(MapColor.COLOR_LIGHT_GREEN));
    public static final RegistryObject<Block> GREEN_WAX_BLOCK = registerBlock("green_wax_block", () -> wax_block(MapColor.COLOR_GREEN));
    public static final RegistryObject<Block> CYAN_WAX_BLOCK = registerBlock("cyan_wax_block", () -> wax_block(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> LIGHT_BLUE_WAX_BLOCK = registerBlock("light_blue_wax_block", () -> wax_block(MapColor.COLOR_LIGHT_BLUE));
    public static final RegistryObject<Block> BLUE_WAX_BLOCK = registerBlock("blue_wax_block", () -> wax_block(MapColor.COLOR_BLUE));
    public static final RegistryObject<Block> PURPLE_WAX_BLOCK = registerBlock("purple_wax_block", () -> wax_block(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> MAGENTA_WAX_BLOCK = registerBlock("magenta_wax_block", () -> wax_block(MapColor.COLOR_MAGENTA));
    public static final RegistryObject<Block> PINK_WAX_BLOCK = registerBlock("pink_wax_block", () -> wax_block(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> BROWN_WAX_BLOCK = registerBlock("brown_wax_block", () -> wax_block(MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> BLACK_WAX_BLOCK = registerBlock("black_wax_block", () -> wax_block(MapColor.COLOR_BLACK));
    public static final RegistryObject<Block> GRAY_WAX_BLOCK = registerBlock("gray_wax_block", () -> wax_block(MapColor.COLOR_GRAY));
    public static final RegistryObject<Block> LIGHT_GRAY_WAX_BLOCK = registerBlock("light_gray_wax_block", () -> wax_block(MapColor.COLOR_LIGHT_GRAY));
    public static final RegistryObject<Block> WHITE_WAX_BLOCK = registerBlock("white_wax_block", () -> wax_block(MapColor.SNOW));
    //Dye Depot Wax Blocks
    public static final RegistryObject<Block> MAROON_WAX_BLOCK = registerBlock("maroon_wax_block", () -> wax_block(MapColor.CRIMSON_HYPHAE));
    public static final RegistryObject<Block> ROSE_WAX_BLOCK = registerBlock("rose_wax_block", () -> wax_block(MapColor.TERRACOTTA_MAGENTA));
    public static final RegistryObject<Block> CORAL_WAX_BLOCK = registerBlock("coral_wax_block", () -> wax_block(MapColor.RAW_IRON));
    public static final RegistryObject<Block> INDIGO_WAX_BLOCK = registerBlock("indigo_wax_block", () -> wax_block(MapColor.TERRACOTTA_BLUE));
    public static final RegistryObject<Block> NAVY_WAX_BLOCK = registerBlock("navy_wax_block", () -> wax_block(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> SLATE_WAX_BLOCK = registerBlock("slate_wax_block", () -> wax_block(MapColor.WARPED_NYLIUM));
    public static final RegistryObject<Block> OLIVE_WAX_BLOCK = registerBlock("olive_wax_block", () -> wax_block(MapColor.TERRACOTTA_LIGHT_GREEN));
    public static final RegistryObject<Block> AMBER_WAX_BLOCK = registerBlock("amber_wax_block", () -> wax_block(MapColor.WOOD));
    public static final RegistryObject<Block> BEIGE_WAX_BLOCK = registerBlock("beige_wax_block", () -> wax_block(MapColor.SAND));
    public static final RegistryObject<Block> TEAL_WAX_BLOCK = registerBlock("teal_wax_block", () -> wax_block(MapColor.TERRACOTTA_CYAN));
    public static final RegistryObject<Block> MINT_WAX_BLOCK = registerBlock("mint_wax_block", () -> wax_block(MapColor.WARPED_WART_BLOCK));
    public static final RegistryObject<Block> AQUA_WAX_BLOCK = registerBlock("aqua_wax_block", () -> wax_block(MapColor.DIAMOND));
    public static final RegistryObject<Block> VERDANT_WAX_BLOCK = registerBlock("verdant_wax_block", () -> wax_block(MapColor.TERRACOTTA_GREEN));
    public static final RegistryObject<Block> FOREST_WAX_BLOCK = registerBlock("forest_wax_block", () -> wax_block(MapColor.EMERALD));
    public static final RegistryObject<Block> GINGER_WAX_BLOCK = registerBlock("ginger_wax_block", () -> wax_block(MapColor.TERRACOTTA_ORANGE));
    public static final RegistryObject<Block> TAN_WAX_BLOCK = registerBlock("tan_wax_block", () -> wax_block(MapColor.DIRT));
    //Wax Pillars
    public static final RegistryObject<Block> WAX_PILLAR = registerBlock("wax_pillar", () -> wax_pillar(MapColor.SAND));
    public static final RegistryObject<Block> SOUL_WAX_PILLAR = registerBlock("soul_wax_pillar", () -> wax_pillar(MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> RED_WAX_PILLAR = registerBlock("red_wax_pillar", () -> wax_pillar(MapColor.COLOR_RED));
    public static final RegistryObject<Block> ORANGE_WAX_PILLAR = registerBlock("orange_wax_pillar", () -> wax_pillar(MapColor.COLOR_ORANGE));
    public static final RegistryObject<Block> YELLOW_WAX_PILLAR = registerBlock("yellow_wax_pillar", () -> wax_pillar(MapColor.COLOR_YELLOW));
    public static final RegistryObject<Block> LIME_WAX_PILLAR = registerBlock("lime_wax_pillar", () -> wax_pillar(MapColor.COLOR_LIGHT_GREEN));
    public static final RegistryObject<Block> GREEN_WAX_PILLAR = registerBlock("green_wax_pillar", () -> wax_pillar(MapColor.COLOR_GREEN));
    public static final RegistryObject<Block> CYAN_WAX_PILLAR = registerBlock("cyan_wax_pillar", () -> wax_pillar(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> LIGHT_BLUE_WAX_PILLAR = registerBlock("light_blue_wax_pillar", () -> wax_pillar(MapColor.COLOR_LIGHT_BLUE));
    public static final RegistryObject<Block> BLUE_WAX_PILLAR = registerBlock("blue_wax_pillar", () -> wax_pillar(MapColor.COLOR_BLUE));
    public static final RegistryObject<Block> PURPLE_WAX_PILLAR = registerBlock("purple_wax_pillar", () -> wax_pillar(MapColor.COLOR_PURPLE));
    public static final RegistryObject<Block> MAGENTA_WAX_PILLAR = registerBlock("magenta_wax_pillar", () -> wax_pillar(MapColor.COLOR_MAGENTA));
    public static final RegistryObject<Block> PINK_WAX_PILLAR = registerBlock("pink_wax_pillar", () -> wax_pillar(MapColor.COLOR_PINK));
    public static final RegistryObject<Block> BROWN_WAX_PILLAR = registerBlock("brown_wax_pillar", () -> wax_pillar(MapColor.COLOR_BROWN));
    public static final RegistryObject<Block> BLACK_WAX_PILLAR = registerBlock("black_wax_pillar", () -> wax_pillar(MapColor.COLOR_BLACK));
    public static final RegistryObject<Block> GRAY_WAX_PILLAR = registerBlock("gray_wax_pillar", () -> wax_pillar(MapColor.COLOR_GRAY));
    public static final RegistryObject<Block> LIGHT_GRAY_WAX_PILLAR = registerBlock("light_gray_wax_pillar", () -> wax_pillar(MapColor.COLOR_LIGHT_GRAY));
    public static final RegistryObject<Block> WHITE_WAX_PILLAR = registerBlock("white_wax_pillar", () -> wax_pillar(MapColor.SNOW));
    //Dye Depot Wax Pillars
    public static final RegistryObject<Block> MAROON_WAX_PILLAR = registerBlock("maroon_wax_pillar", () -> wax_pillar(MapColor.CRIMSON_HYPHAE));
    public static final RegistryObject<Block> ROSE_WAX_PILLAR = registerBlock("rose_wax_pillar", () -> wax_pillar(MapColor.TERRACOTTA_MAGENTA));
    public static final RegistryObject<Block> CORAL_WAX_PILLAR = registerBlock("coral_wax_pillar", () -> wax_pillar(MapColor.RAW_IRON));
    public static final RegistryObject<Block> INDIGO_WAX_PILLAR = registerBlock("indigo_wax_pillar", () -> wax_pillar(MapColor.TERRACOTTA_BLUE));
    public static final RegistryObject<Block> NAVY_WAX_PILLAR = registerBlock("navy_wax_pillar", () -> wax_pillar(MapColor.COLOR_CYAN));
    public static final RegistryObject<Block> SLATE_WAX_PILLAR = registerBlock("slate_wax_pillar", () -> wax_pillar(MapColor.WARPED_NYLIUM));
    public static final RegistryObject<Block> OLIVE_WAX_PILLAR = registerBlock("olive_wax_pillar", () -> wax_pillar(MapColor.TERRACOTTA_LIGHT_GREEN));
    public static final RegistryObject<Block> AMBER_WAX_PILLAR = registerBlock("amber_wax_pillar", () -> wax_pillar(MapColor.WOOD));
    public static final RegistryObject<Block> BEIGE_WAX_PILLAR = registerBlock("beige_wax_pillar", () -> wax_pillar(MapColor.SAND));
    public static final RegistryObject<Block> TEAL_WAX_PILLAR = registerBlock("teal_wax_pillar", () -> wax_pillar(MapColor.TERRACOTTA_CYAN));
    public static final RegistryObject<Block> MINT_WAX_PILLAR = registerBlock("mint_wax_pillar", () -> wax_pillar(MapColor.WARPED_WART_BLOCK));
    public static final RegistryObject<Block> AQUA_WAX_PILLAR = registerBlock("aqua_wax_pillar", () -> wax_pillar(MapColor.DIAMOND));
    public static final RegistryObject<Block> VERDANT_WAX_PILLAR = registerBlock("verdant_wax_pillar", () -> wax_pillar(MapColor.TERRACOTTA_GREEN));
    public static final RegistryObject<Block> FOREST_WAX_PILLAR = registerBlock("forest_wax_pillar", () -> wax_pillar(MapColor.EMERALD));
    public static final RegistryObject<Block> GINGER_WAX_PILLAR = registerBlock("ginger_wax_pillar", () -> wax_pillar(MapColor.TERRACOTTA_ORANGE));
    public static final RegistryObject<Block> TAN_WAX_PILLAR = registerBlock("tan_wax_pillar", () -> wax_pillar(MapColor.DIRT));
    //Waxed Blocks
    public static final RegistryObject<Block> WAXED_SAND = registerBlock("waxed_sand", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_RED_SAND = registerBlock("waxed_red_sand", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_GRAVEL = registerBlock("waxed_gravel", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.SNARE).strength(0.6f).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> WAXED_POWDER_SNOW = registerBlock("waxed_powder_snow", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.25F).sound(SoundType.SNOW)));
    public static final RegistryObject<Block> WAXED_MAGMA_BLOCK = registerBlock("waxed_magma_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().lightLevel((BlockState) -> {return 3;}).strength(0.5F).emissiveRendering(WaxedModBlocks::always)));
    public static final RegistryObject<Block> WAXED_SOUL_SAND = registerBlock("waxed_soul_sand", () -> new SoulSandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.COW_BELL).strength(0.5f).sound(SoundType.SOUL_SAND).isRedstoneConductor(WaxedModBlocks::always).isViewBlocking(WaxedModBlocks::always).isSuffocating(WaxedModBlocks::always)));
    public static final RegistryObject<Block> WAXED_PRISMARINE = registerBlock("waxed_prismarine", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> WAXED_PRISMARINE_STAIRS = registerBlock("waxed_prismarine_stairs", () -> new StairBlock(WAXED_PRISMARINE.get().defaultBlockState(), BlockBehaviour.Properties.copy(WAXED_PRISMARINE.get())));
    public static final RegistryObject<Block> WAXED_PRISMARINE_SLAB = registerBlock("waxed_prismarine_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> WAXED_PRISMARINE_WALL = registerBlock("waxed_prismarine_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(WAXED_PRISMARINE.get()).forceSolidOn()));
    public static final RegistryObject<Block> WAXED_SPONGE = registerBlock("waxed_sponge", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> WAXED_REDSTONE_BLOCK = registerBlock("waxed_redstone_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> WAXED_COBWEB = registerBlock("waxed_cobweb", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).forceSolidOn().noCollission().requiresCorrectToolForDrops().strength(4.0F).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_RED_CONCRETE_POWDER = registerBlock("waxed_red_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_ORANGE_CONCRETE_POWDER = registerBlock("waxed_orange_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_YELLOW_CONCRETE_POWDER = registerBlock("waxed_yellow_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_LIME_CONCRETE_POWDER = registerBlock("waxed_lime_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_GREEN_CONCRETE_POWDER = registerBlock("waxed_green_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_CYAN_CONCRETE_POWDER = registerBlock("waxed_cyan_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_LIGHT_BLUE_CONCRETE_POWDER = registerBlock("waxed_light_blue_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_BLUE_CONCRETE_POWDER = registerBlock("waxed_blue_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_PURPLE_CONCRETE_POWDER = registerBlock("waxed_purple_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_MAGENTA_CONCRETE_POWDER = registerBlock("waxed_magenta_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_PINK_CONCRETE_POWDER = registerBlock("waxed_pink_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_BROWN_CONCRETE_POWDER = registerBlock("waxed_brown_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_BLACK_CONCRETE_POWDER = registerBlock("waxed_black_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_GRAY_CONCRETE_POWDER = registerBlock("waxed_gray_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_LIGHT_GRAY_CONCRETE_POWDER = registerBlock("waxed_light_gray_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_WHITE_CONCRETE_POWDER = registerBlock("waxed_white_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));

    public static final RegistryObject<Block> WAXED_TUBE_CORAL_BLOCK = registerBlock("waxed_tube_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_BRAIN_CORAL_BLOCK = registerBlock("waxed_brain_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_BUBBLE_CORAL_BLOCK = registerBlock("waxed_bubble_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_FIRE_CORAL_BLOCK = registerBlock("waxed_fire_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_HORN_CORAL_BLOCK = registerBlock("waxed_horn_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_TUBE_CORAL = registerBlock("waxed_tube_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_BRAIN_CORAL = registerBlock("waxed_brain_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_BUBBLE_CORAL = registerBlock("waxed_bubble_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_FIRE_CORAL = registerBlock("waxed_fire_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_HORN_CORAL = registerBlock("waxed_horn_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_TUBE_CORAL_FAN = BLOCKS.register("waxed_tube_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_BRAIN_CORAL_FAN = BLOCKS.register("waxed_brain_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_BUBBLE_CORAL_FAN = BLOCKS.register("waxed_bubble_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_FIRE_CORAL_FAN = BLOCKS.register("waxed_fire_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_HORN_CORAL_FAN = BLOCKS.register("waxed_horn_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_TUBE_CORAL_WALL_FAN = BLOCKS.register("waxed_tube_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_TUBE_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_BRAIN_CORAL_WALL_FAN = BLOCKS.register("waxed_brain_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_BRAIN_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_BUBBLE_CORAL_WALL_FAN = BLOCKS.register("waxed_bubble_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_BUBBLE_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_FIRE_CORAL_WALL_FAN = BLOCKS.register("waxed_fire_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_FIRE_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_HORN_CORAL_WALL_FAN = BLOCKS.register("waxed_horn_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_HORN_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    //Upgrade Aquatic Waxed Blocks
    public static final RegistryObject<Block> WAXED_ACAN_CORAL_BLOCK = registerBlock("waxed_acan_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_FINGER_CORAL_BLOCK = registerBlock("waxed_finger_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_STAR_CORAL_BLOCK = registerBlock("waxed_star_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_MOSS_CORAL_BLOCK = registerBlock("waxed_moss_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_PETAL_CORAL_BLOCK = registerBlock("waxed_petal_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_BRANCH_CORAL_BLOCK = registerBlock("waxed_branch_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_ROCK_CORAL_BLOCK = registerBlock("waxed_rock_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_PILLOW_CORAL_BLOCK = registerBlock("waxed_pillow_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_SILK_CORAL_BLOCK = registerBlock("waxed_silk_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_CHROME_CORAL_BLOCK = registerBlock("waxed_chrome_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));
    public static final RegistryObject<Block> WAXED_PRISMARINE_CORAL_BLOCK = registerBlock("waxed_prismarine_coral_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK)));

    public static final RegistryObject<Block> WAXED_ACAN_CORAL = registerBlock("waxed_acan_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_FINGER_CORAL = registerBlock("waxed_finger_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_STAR_CORAL = registerBlock("waxed_star_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_MOSS_CORAL = registerBlock("waxed_moss_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_PETAL_CORAL = registerBlock("waxed_petal_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_BRANCH_CORAL = registerBlock("waxed_branch_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_ROCK_CORAL = registerBlock("waxed_rock_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_PILLOW_CORAL = registerBlock("waxed_pillow_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_SILK_CORAL = registerBlock("waxed_silk_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_CHROME_CORAL = registerBlock("waxed_chrome_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_PRISMARINE_CORAL = registerBlock("waxed_prismarine_coral", () -> new BaseCoralPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> WAXED_ACAN_CORAL_FAN = BLOCKS.register("waxed_acan_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_FINGER_CORAL_FAN = BLOCKS.register("waxed_finger_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_STAR_CORAL_FAN = BLOCKS.register("waxed_star_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_MOSS_CORAL_FAN = BLOCKS.register("waxed_moss_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_PETAL_CORAL_FAN = BLOCKS.register("waxed_petal_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_BRANCH_CORAL_FAN = BLOCKS.register("waxed_branch_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_ROCK_CORAL_FAN = BLOCKS.register("waxed_rock_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_PILLOW_CORAL_FAN = BLOCKS.register("waxed_pillow_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_SILK_CORAL_FAN = BLOCKS.register("waxed_silk_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_CHROME_CORAL_FAN = BLOCKS.register("waxed_chrome_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_PRISMARINE_CORAL_FAN = BLOCKS.register("waxed_prismarine_coral_fan", () -> new BaseCoralFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> WAXED_ACAN_CORAL_WALL_FAN = BLOCKS.register("waxed_acan_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_ACAN_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_FINGER_CORAL_WALL_FAN = BLOCKS.register("waxed_finger_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_FINGER_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_STAR_CORAL_WALL_FAN = BLOCKS.register("waxed_star_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_STAR_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_MOSS_CORAL_WALL_FAN = BLOCKS.register("waxed_moss_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_MOSS_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_PETAL_CORAL_WALL_FAN = BLOCKS.register("waxed_petal_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_PETAL_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_BRANCH_CORAL_WALL_FAN = BLOCKS.register("waxed_branch_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_BRANCH_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_ROCK_CORAL_WALL_FAN = BLOCKS.register("waxed_rock_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_ROCK_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_PILLOW_CORAL_WALL_FAN = BLOCKS.register("waxed_pillow_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_PILLOW_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_SILK_CORAL_WALL_FAN = BLOCKS.register("waxed_silk_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_SILK_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_CHROME_CORAL_WALL_FAN = BLOCKS.register("waxed_chrome_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_CHROME_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_PRISMARINE_CORAL_WALL_FAN = BLOCKS.register("waxed_prismarine_coral_wall_fan", () -> new BaseCoralWallFanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).noCollission().instabreak().sound(SoundType.WET_GRASS).dropsLike(WAXED_PRISMARINE_CORAL_FAN.get()).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> WAXED_PRISMARINE_CORAL_SHOWER = registerBlock("waxed_prismarine_coral_shower", () -> new WaxedCoralShowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)));
    //Dye Depot Waxed Blocks
    public static final RegistryObject<Block> WAXED_MAROON_CONCRETE_POWDER = registerBlock("waxed_maroon_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_ROSE_CONCRETE_POWDER = registerBlock("waxed_rose_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_MAGENTA).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_CORAL_CONCRETE_POWDER = registerBlock("waxed_coral_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.RAW_IRON).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_INDIGO_CONCRETE_POWDER = registerBlock("waxed_indigo_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_NAVY_CONCRETE_POWDER = registerBlock("waxed_navy_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_SLATE_CONCRETE_POWDER = registerBlock("waxed_slate_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_NYLIUM).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_OLIVE_CONCRETE_POWDER = registerBlock("waxed_olive_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_AMBER_CONCRETE_POWDER = registerBlock("waxed_amber_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_BEIGE_CONCRETE_POWDER = registerBlock("waxed_beige_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_TEAL_CONCRETE_POWDER = registerBlock("waxed_teal_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_MINT_CONCRETE_POWDER = registerBlock("waxed_mint_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_WART_BLOCK).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_AQUA_CONCRETE_POWDER = registerBlock("waxed_aqua_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_VERDANT_CONCRETE_POWDER = registerBlock("waxed_verdant_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_FOREST_CONCRETE_POWDER = registerBlock("waxed_forest_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_GINGER_CONCRETE_POWDER = registerBlock("waxed_ginger_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_TAN_CONCRETE_POWDER = registerBlock("waxed_tan_concrete_powder", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.SNARE).strength(0.5f).sound(SoundType.SAND)));
    //Supplementaries Waxed Blocks
    public static final RegistryObject<Block> WAXED_FODDER = registerBlock("waxed_fodder", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).pushReaction(PushReaction.NORMAL)));
    public static final RegistryObject<Block> WAXED_SUGAR_CUBE = registerBlock("waxed_sugar_cube", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.5F).sound(SoundType.SAND)));
    public static final RegistryObject<Block> WAXED_SOAP_BLOCK = registerBlock("waxed_soap_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.25F, 4.0F).sound(SoundType.CORAL_BLOCK)));
    //public static final RegistryObject<Block> WAXED_FEATHER_BLOCK = registerBlock("waxed_feather_block", () -> ModList.get().isLoaded("supplementaries") ? new WaxedFeatherBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(0.5F).dynamicShape().noCollission()) : new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(0.5F).dynamicShape().noCollission()));


    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    private static Block wax_block(MapColor pMapColor) {
        return new Block(BlockBehaviour.Properties.of().mapColor(pMapColor).strength(0.6f).sound(SoundType.CORAL_BLOCK).pushReaction(PushReaction.PUSH_ONLY));
    }

    private static Block wax_pillar(MapColor pMapColor) {
        return new WaxPillarBlock(BlockBehaviour.Properties.of().mapColor(pMapColor).strength(0.6f).sound(SoundType.CORAL_BLOCK).pushReaction(PushReaction.PUSH_ONLY));
    }
    
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockS(String name, Supplier<T> block) {
        if (ModList.get().isLoaded("supplementaries")) {
            RegistryObject<T> toReturn = BLOCKSS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
        } else {
            RegistryObject<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
        }
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return WaxedModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (blockState) -> {
            return blockState.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
        };
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCKSS.register(eventBus);
    }
}
