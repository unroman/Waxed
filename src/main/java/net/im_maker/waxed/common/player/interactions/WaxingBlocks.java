package net.im_maker.waxed.common.player.interactions;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.twigs.registry.TwigsBlocks;
import com.soytutta.mynethersdelight.MyNethersDelight;
import com.soytutta.mynethersdelight.common.registry.MNDBlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.im_maker.waxed.common.item.WaxedModItems;
import net.im_maker.waxed.common.sounds.WaxedModSounds;
import net.im_maker.waxed.common.tags.WaxedModItemTags;
import net.mcreator.aromatic.init.AromaticModBlocks;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Optional;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Waxed.MOD_ID)

public class WaxingBlocks {
    public static final Supplier<BiMap<Block, Block>> WAXABLES_SHOVEL = Suppliers.memoize(() -> {
        BiMap<Block, Block> waxedBlocks = HashBiMap.create();
        waxedBlocks.put(Blocks.SAND, WaxedModBlocks.WAXED_SAND.get());
        waxedBlocks.put(Blocks.RED_SAND, WaxedModBlocks.WAXED_RED_SAND.get());
        waxedBlocks.put(Blocks.GRAVEL, WaxedModBlocks.WAXED_GRAVEL.get());
        waxedBlocks.put(Blocks.POWDER_SNOW, WaxedModBlocks.WAXED_POWDER_SNOW.get());
        waxedBlocks.put(Blocks.SOUL_SAND, WaxedModBlocks.WAXED_SOUL_SAND.get());
        waxedBlocks.put(Blocks.RED_CONCRETE_POWDER, WaxedModBlocks.WAXED_RED_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.ORANGE_CONCRETE_POWDER, WaxedModBlocks.WAXED_ORANGE_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.YELLOW_CONCRETE_POWDER, WaxedModBlocks.WAXED_YELLOW_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.LIME_CONCRETE_POWDER, WaxedModBlocks.WAXED_LIME_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.GREEN_CONCRETE_POWDER, WaxedModBlocks.WAXED_GREEN_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.CYAN_CONCRETE_POWDER, WaxedModBlocks.WAXED_CYAN_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.LIGHT_BLUE_CONCRETE_POWDER, WaxedModBlocks.WAXED_LIGHT_BLUE_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.BLUE_CONCRETE_POWDER, WaxedModBlocks.WAXED_BLUE_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.PURPLE_CONCRETE_POWDER, WaxedModBlocks.WAXED_PURPLE_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.MAGENTA_CONCRETE_POWDER, WaxedModBlocks.WAXED_MAGENTA_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.PINK_CONCRETE_POWDER, WaxedModBlocks.WAXED_PINK_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.BROWN_CONCRETE_POWDER, WaxedModBlocks.WAXED_BROWN_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.BLACK_CONCRETE_POWDER, WaxedModBlocks.WAXED_BLACK_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.GRAY_CONCRETE_POWDER, WaxedModBlocks.WAXED_GRAY_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.LIGHT_GRAY_CONCRETE_POWDER, WaxedModBlocks.WAXED_LIGHT_GRAY_CONCRETE_POWDER.get());
        waxedBlocks.put(Blocks.WHITE_CONCRETE_POWDER, WaxedModBlocks.WAXED_WHITE_CONCRETE_POWDER.get());

        if (ModList.get().isLoaded("dye_depot")) {
            waxedBlocks.put(DDBlocks.MAROON_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_MAROON_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.ROSE_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_ROSE_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.CORAL_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_CORAL_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.INDIGO_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_INDIGO_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.NAVY_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_NAVY_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.SLATE_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_SLATE_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.OLIVE_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_OLIVE_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.AMBER_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_AMBER_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.BEIGE_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_BEIGE_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.TEAL_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_TEAL_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.MINT_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_MINT_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.AQUA_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_AQUA_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.VERDANT_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_VERDANT_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.FOREST_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_FOREST_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.GINGER_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_GINGER_CONCRETE_POWDER.get());
            waxedBlocks.put(DDBlocks.TAN_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_TAN_CONCRETE_POWDER.get());
        }
        if (ModList.get().isLoaded("supplementaries")) {
            //waxedBlocks.put(ModRegistry.FODDER.get(), WaxedModBlocks.WAXED_FODDER.get());
            waxedBlocks.put(ModRegistry.SUGAR_CUBE.get(), WaxedModBlocks.WAXED_SUGAR_CUBE.get());
        }
        waxedBlocks.putAll(waxedBlocks);
        return waxedBlocks;
    });

    public static final Supplier<BiMap<Block, Block>> WAXABLE_FODDER_BLOCK = Suppliers.memoize(() -> {
        BiMap<Block, Block> waxedBlocks = HashBiMap.create();
        if (ModList.get().isLoaded("supplementaries")) {
            waxedBlocks.put(ModRegistry.FODDER.get(), WaxedModBlocks.WAXED_FODDER.get());
        }
        waxedBlocks.putAll(waxedBlocks);
        return waxedBlocks;
    });

    public static final Supplier<BiMap<Block, Block>> WAXABLES_MODDED_BLOCKS = Suppliers.memoize(() -> {
        BiMap<Block, Block> waxedBlocks = HashBiMap.create();
        if (ModList.get().isLoaded("quark")) {
            String[] colors = {"red", "orange", "yellow", "green", "blue", "indigo", "violet", "white", "black"};

            for (String color : colors) {
                ResourceLocation waxedCorundumLocation = new ResourceLocation("quark:waxed_" + color + "_corundum");
                ResourceLocation corundumLocation = new ResourceLocation("quark:" + color + "_corundum");

                Block waxedCorundum = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedCorundumLocation));
                Block corundum = Block.byItem(ForgeRegistries.ITEMS.getValue(corundumLocation));

                waxedBlocks.put(corundum, waxedCorundum);
            }

            String[] quarkVerticalCopperSlabs = {"", "exposed_", "weathered_", "oxidized_"};
            for (String type : quarkVerticalCopperSlabs) {
                ResourceLocation waxedVerticalCopperSlabLocation = new ResourceLocation("quark:waxed_" + type + "cut_copper_vertical_slab");
                ResourceLocation VerticalCopperSlabLocation = new ResourceLocation("quark:" + type + "cut_copper_vertical_slab");
                Block waxedVerticalCopperSlab = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedVerticalCopperSlabLocation));
                Block VerticalCopperSlab = Block.byItem(ForgeRegistries.ITEMS.getValue(VerticalCopperSlabLocation));

                waxedBlocks.put(VerticalCopperSlab, waxedVerticalCopperSlab);
            }
        }
        if (ModList.get().isLoaded("mynethersdelight")) {
            waxedBlocks.put(MNDBlocks.HOGLIN_TROPHY.get(), MNDBlocks.WAXED_HOGLIN_TROPHY.get());
        }
        if (ModList.get().isLoaded("aromatic")) {
            waxedBlocks.put(AromaticModBlocks.CINNAMON_LOG_THIN.get(), AromaticModBlocks.WAXED_CINNAMON_LOG_THIN.get());
            waxedBlocks.put(AromaticModBlocks.STRIPPED_CINNAMON_LOG_THIN.get(), AromaticModBlocks.WAXED_STRIPPED_CINNAMON_LOG_THIN.get());
        }
        if (ModList.get().isLoaded("twigs")) {
            waxedBlocks.put(TwigsBlocks.COPPER_PILLAR.get(), TwigsBlocks.WAXED_COPPER_PILLAR.get());
            waxedBlocks.put(TwigsBlocks.EXPOSED_COPPER_PILLAR.get(), TwigsBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
            waxedBlocks.put(TwigsBlocks.WEATHERED_COPPER_PILLAR.get(), TwigsBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
            waxedBlocks.put(TwigsBlocks.OXIDIZED_COPPER_PILLAR.get(), TwigsBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
        }
            waxedBlocks.putAll(waxedBlocks);
        return waxedBlocks;
    });

    public static final Supplier<BiMap<Block, Block>> WAXABLES_AXE = Suppliers.memoize(() -> {
        BiMap<Block, Block> waxedBlocks = HashBiMap.create();
        waxedBlocks.put(Blocks.MAGMA_BLOCK, WaxedModBlocks.WAXED_MAGMA_BLOCK.get());
        waxedBlocks.put(Blocks.REDSTONE_BLOCK, WaxedModBlocks.WAXED_REDSTONE_BLOCK.get());
        //waxedBlocks.put(Blocks.PRISMARINE, WaxedModBlocks.WAXED_PRISMARINE.get());
        //waxedBlocks.put(Blocks.PRISMARINE_STAIRS, WaxedModBlocks.WAXED_PRISMARINE_STAIRS.get());
        //waxedBlocks.put(Blocks.PRISMARINE_SLAB, WaxedModBlocks.WAXED_PRISMARINE_SLAB.get());
        //waxedBlocks.put(Blocks.PRISMARINE_WALL, WaxedModBlocks.WAXED_PRISMARINE_WALL.get());
        if (ModList.get().isLoaded("supplementaries")) {
            waxedBlocks.put(ModRegistry.SOAP_BLOCK.get(), WaxedModBlocks.WAXED_SOAP_BLOCK.get());
        }
        waxedBlocks.putAll(waxedBlocks);
        return waxedBlocks;
    });

    public static final Supplier<BiMap<Block, Block>> WAXABLES_PRISMARINE_AXE = Suppliers.memoize(() -> {
        BiMap<Block, Block> waxedBlocks = HashBiMap.create();
        waxedBlocks.put(Blocks.PRISMARINE, WaxedModBlocks.WAXED_PRISMARINE.get());
        waxedBlocks.put(Blocks.PRISMARINE_STAIRS, WaxedModBlocks.WAXED_PRISMARINE_STAIRS.get());
        waxedBlocks.put(Blocks.PRISMARINE_SLAB, WaxedModBlocks.WAXED_PRISMARINE_SLAB.get());
        waxedBlocks.put(Blocks.PRISMARINE_WALL, WaxedModBlocks.WAXED_PRISMARINE_WALL.get());
        waxedBlocks.putAll(waxedBlocks);
        return waxedBlocks;
    });

    public static final Supplier<BiMap<Block, Block>> WAXABLES_HOE = Suppliers.memoize(() -> {
        BiMap<Block, Block> waxedBlocks = HashBiMap.create();
        waxedBlocks.put(Blocks.SPONGE, WaxedModBlocks.WAXED_SPONGE.get());
        //waxedBlocks.put(Blocks.COBWEB, WaxedModBlocks.WAXED_COBWEB.get());
        waxedBlocks.put(Blocks.TUBE_CORAL_BLOCK, WaxedModBlocks.WAXED_TUBE_CORAL_BLOCK.get());
        waxedBlocks.put(Blocks.BRAIN_CORAL_BLOCK, WaxedModBlocks.WAXED_BRAIN_CORAL_BLOCK.get());
        waxedBlocks.put(Blocks.BUBBLE_CORAL_BLOCK, WaxedModBlocks.WAXED_BUBBLE_CORAL_BLOCK.get());
        waxedBlocks.put(Blocks.FIRE_CORAL_BLOCK, WaxedModBlocks.WAXED_FIRE_CORAL_BLOCK.get());
        waxedBlocks.put(Blocks.HORN_CORAL_BLOCK, WaxedModBlocks.WAXED_HORN_CORAL_BLOCK.get());
        waxedBlocks.put(Blocks.TUBE_CORAL, WaxedModBlocks.WAXED_TUBE_CORAL.get());
        waxedBlocks.put(Blocks.BRAIN_CORAL, WaxedModBlocks.WAXED_BRAIN_CORAL.get());
        waxedBlocks.put(Blocks.BUBBLE_CORAL, WaxedModBlocks.WAXED_BUBBLE_CORAL.get());
        waxedBlocks.put(Blocks.FIRE_CORAL, WaxedModBlocks.WAXED_FIRE_CORAL.get());
        waxedBlocks.put(Blocks.HORN_CORAL, WaxedModBlocks.WAXED_HORN_CORAL.get());
        waxedBlocks.put(Blocks.TUBE_CORAL_FAN, WaxedModBlocks.WAXED_TUBE_CORAL_FAN.get());
        waxedBlocks.put(Blocks.BRAIN_CORAL_FAN, WaxedModBlocks.WAXED_BRAIN_CORAL_FAN.get());
        waxedBlocks.put(Blocks.BUBBLE_CORAL_FAN, WaxedModBlocks.WAXED_BUBBLE_CORAL_FAN.get());
        waxedBlocks.put(Blocks.FIRE_CORAL_FAN, WaxedModBlocks.WAXED_FIRE_CORAL_FAN.get());
        waxedBlocks.put(Blocks.HORN_CORAL_FAN, WaxedModBlocks.WAXED_HORN_CORAL_FAN.get());
        waxedBlocks.put(Blocks.TUBE_CORAL_WALL_FAN, WaxedModBlocks.WAXED_TUBE_CORAL_WALL_FAN.get());
        waxedBlocks.put(Blocks.BRAIN_CORAL_WALL_FAN, WaxedModBlocks.WAXED_BRAIN_CORAL_WALL_FAN.get());
        waxedBlocks.put(Blocks.BUBBLE_CORAL_WALL_FAN, WaxedModBlocks.WAXED_BUBBLE_CORAL_WALL_FAN.get());
        waxedBlocks.put(Blocks.FIRE_CORAL_WALL_FAN, WaxedModBlocks.WAXED_FIRE_CORAL_WALL_FAN.get());
        waxedBlocks.put(Blocks.HORN_CORAL_WALL_FAN, WaxedModBlocks.WAXED_HORN_CORAL_WALL_FAN.get());
        if (ModList.get().isLoaded("upgrade_aquatic")) {
            waxedBlocks.put(UABlocks.ACAN_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_ACAN_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.FINGER_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_FINGER_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.STAR_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_STAR_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.MOSS_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_MOSS_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.PETAL_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_PETAL_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.BRANCH_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_BRANCH_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.ROCK_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_ROCK_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.PILLOW_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_PILLOW_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.SILK_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_SILK_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.CHROME_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_CHROME_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.PRISMARINE_CORAL_BLOCK.get(), WaxedModBlocks.WAXED_PRISMARINE_CORAL_BLOCK.get());
            waxedBlocks.put(UABlocks.ACAN_CORAL.get(), WaxedModBlocks.WAXED_ACAN_CORAL.get());
            waxedBlocks.put(UABlocks.FINGER_CORAL.get(), WaxedModBlocks.WAXED_FINGER_CORAL.get());
            waxedBlocks.put(UABlocks.STAR_CORAL.get(), WaxedModBlocks.WAXED_STAR_CORAL.get());
            waxedBlocks.put(UABlocks.MOSS_CORAL.get(), WaxedModBlocks.WAXED_MOSS_CORAL.get());
            waxedBlocks.put(UABlocks.PETAL_CORAL.get(), WaxedModBlocks.WAXED_PETAL_CORAL.get());
            waxedBlocks.put(UABlocks.BRANCH_CORAL.get(), WaxedModBlocks.WAXED_BRANCH_CORAL.get());
            waxedBlocks.put(UABlocks.ROCK_CORAL.get(), WaxedModBlocks.WAXED_ROCK_CORAL.get());
            waxedBlocks.put(UABlocks.PILLOW_CORAL.get(), WaxedModBlocks.WAXED_PILLOW_CORAL.get());
            waxedBlocks.put(UABlocks.SILK_CORAL.get(), WaxedModBlocks.WAXED_SILK_CORAL.get());
            waxedBlocks.put(UABlocks.CHROME_CORAL.get(), WaxedModBlocks.WAXED_CHROME_CORAL.get());
            waxedBlocks.put(UABlocks.PRISMARINE_CORAL.get(), WaxedModBlocks.WAXED_PRISMARINE_CORAL.get());
            waxedBlocks.put(UABlocks.ACAN_CORAL_FAN.get(), WaxedModBlocks.WAXED_ACAN_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.FINGER_CORAL_FAN.get(), WaxedModBlocks.WAXED_FINGER_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.STAR_CORAL_FAN.get(), WaxedModBlocks.WAXED_STAR_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.MOSS_CORAL_FAN.get(), WaxedModBlocks.WAXED_MOSS_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.PETAL_CORAL_FAN.get(), WaxedModBlocks.WAXED_PETAL_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.BRANCH_CORAL_FAN.get(), WaxedModBlocks.WAXED_BRANCH_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.ROCK_CORAL_FAN.get(), WaxedModBlocks.WAXED_ROCK_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.PILLOW_CORAL_FAN.get(), WaxedModBlocks.WAXED_PILLOW_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.SILK_CORAL_FAN.get(), WaxedModBlocks.WAXED_SILK_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.CHROME_CORAL_FAN.get(), WaxedModBlocks.WAXED_CHROME_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.PRISMARINE_CORAL_FAN.get(), WaxedModBlocks.WAXED_PRISMARINE_CORAL_FAN.get());
            waxedBlocks.put(UABlocks.ACAN_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_ACAN_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.FINGER_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_FINGER_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.STAR_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_STAR_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.MOSS_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_MOSS_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.PETAL_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_PETAL_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.BRANCH_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_BRANCH_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.ROCK_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_ROCK_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.PILLOW_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_PILLOW_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.SILK_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_SILK_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.CHROME_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_CHROME_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.PRISMARINE_CORAL_WALL_FAN.get(), WaxedModBlocks.WAXED_PRISMARINE_CORAL_WALL_FAN.get());
            waxedBlocks.put(UABlocks.PRISMARINE_CORAL_SHOWER.get(), WaxedModBlocks.WAXED_PRISMARINE_CORAL_SHOWER.get());
        }
        if (ModList.get().isLoaded("supplementaries")) {
            //waxedBlocks.put(ModRegistry.FEATHER_BLOCK.get(), WaxedModBlocks.WAXED_FEATHER_BLOCK.get());
        }
        waxedBlocks.putAll(waxedBlocks);
        return waxedBlocks;
    });

    public static Optional<Block> getWaxedFodderBlock(Block block) {
        return Optional.ofNullable(WAXABLE_FODDER_BLOCK.get().get(block));
    }

    public static Optional<Block> getUnwaxedFodderBlock(Block block) {
        return Optional.ofNullable(WAXABLE_FODDER_BLOCK.get().inverse().get(block));
    }

    public static Optional<Block> getWaxedModdedBlocks(Block block) {
        return Optional.ofNullable(WAXABLES_MODDED_BLOCKS.get().get(block));
    }

    public static Optional<Block> getVanillaWaxedCopperBlocks(Block block) {
        return Optional.ofNullable(HoneycombItem.WAXABLES.get().get(block));
    }

    public static Optional<Block> getWaxedShovels(Block block) {
        return Optional.ofNullable(WAXABLES_SHOVEL.get().get(block));
    }

    public static Optional<Block> getWaxedAxe(Block block) {
        return Optional.ofNullable(WAXABLES_AXE.get().get(block));
    }

    public static Optional<Block> getWaxedHoes(Block block) {
        return Optional.ofNullable(WAXABLES_HOE.get().get(block));
    }

    public static Optional<Block> getUnwaxedShovels(Block block) {
        return Optional.ofNullable(WAXABLES_SHOVEL.get().inverse().get(block));
    }

    public static Optional<Block> getUnwaxedAxe(Block block) {
        return Optional.ofNullable(WAXABLES_AXE.get().inverse().get(block));
    }

    public static Optional<Block> getUnwaxedPrismarineAxe(Block block) {
        return Optional.ofNullable(WAXABLES_PRISMARINE_AXE.get().inverse().get(block));
    }

    public static Optional<Block> getUnwaxedHoes(Block block) {
        return Optional.ofNullable(WAXABLES_HOE.get().inverse().get(block));
    }

    @SubscribeEvent
    public static InteractionResult waxOnPlayerInteract(final PlayerInteractEvent.RightClickBlock interactEvent) {
        Level level = interactEvent.getLevel();
        BlockPos blockPos = interactEvent.getPos();
        BlockState blockState = level.getBlockState(blockPos);
        ItemStack itemStack = interactEvent.getItemStack();
        var waxedBlock1 = getWaxedShovels(blockState.getBlock());
        var waxedBlock2 = getWaxedAxe(blockState.getBlock());
        var waxedBlock3 = getWaxedHoes(blockState.getBlock());
        var waxedBlock4 = getWaxedFodderBlock(blockState.getBlock());
        if (itemStack.is(WaxedModItemTags.CAN_WAX) && (waxedBlock1.isPresent() || waxedBlock2.isPresent() || waxedBlock3.isPresent() || (waxedBlock4.isPresent() && (blockState.getValue(BlockStateProperties.LAYERS) == 8)))) {
            Player player = interactEvent.getEntity();
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
            }
            interactEvent.getEntity().swing(interactEvent.getHand());
            if (!interactEvent.getEntity().isCreative()) interactEvent.getItemStack().shrink(1);
            if (!level.isClientSide() && waxedBlock1.isPresent()) level.setBlock(blockPos, waxedBlock1.get().withPropertiesOf(blockState), 11);
            if (!level.isClientSide() && waxedBlock2.isPresent()) level.setBlock(blockPos, waxedBlock2.get().withPropertiesOf(blockState), 11);
            if (!level.isClientSide() && waxedBlock3.isPresent()) level.setBlock(blockPos, waxedBlock3.get().withPropertiesOf(blockState), 11);
            if (!level.isClientSide() && waxedBlock4.isPresent()) level.setBlock(blockPos, waxedBlock4.get().withPropertiesOf(blockState), 11);
            if (player instanceof ServerPlayer serverPlayer) {
                Advancement advWaxOn = serverPlayer.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/wax_on"));
                AdvancementProgress advWaxOnProgress = serverPlayer.getAdvancements().getOrStartProgress(advWaxOn);
                if (!advWaxOnProgress.isDone()) {
                    for (String criteria : advWaxOnProgress.getRemainingCriteria()) {
                        serverPlayer.getAdvancements().award(advWaxOn, criteria);
                    }
                }
            }
            level.levelEvent(player, 3003, blockPos, 0);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return (InteractionResult.PASS);
        }
    }

    @SubscribeEvent
    public static InteractionResult waxOffPlayerInteract(final PlayerInteractEvent.RightClickBlock interactEvent) {
        Level level = interactEvent.getLevel();
        BlockPos blockPos = interactEvent.getPos();
        BlockState blockState = level.getBlockState(blockPos);
        ItemStack itemStack = interactEvent.getItemStack();
        var unwaxedBlock1 = getUnwaxedShovels(blockState.getBlock());
        var unwaxedBlock2 = getUnwaxedAxe(blockState.getBlock());
        var unwaxedBlock3 = getUnwaxedHoes(blockState.getBlock());
        var unwaxedBlock4 = getUnwaxedFodderBlock(blockState.getBlock());
        var unwaxedBlock5 = getUnwaxedPrismarineAxe(blockState.getBlock());
        if (itemStack.is(ItemTags.SHOVELS) && (unwaxedBlock1.isPresent() || unwaxedBlock4.isPresent())) {
            if (unwaxedBlock1.isPresent()) unwaxing(interactEvent ,blockPos ,itemStack ,level ,unwaxedBlock1.isPresent(), unwaxedBlock1.get().withPropertiesOf(blockState), WaxedModSounds.SHOVEL_WAX_OFF.get());
            if (unwaxedBlock4.isPresent()) unwaxing(interactEvent ,blockPos ,itemStack ,level ,unwaxedBlock4.isPresent(), unwaxedBlock4.get().withPropertiesOf(blockState), WaxedModSounds.SHOVEL_WAX_OFF.get());
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (itemStack.is(ItemTags.AXES) && (unwaxedBlock2.isPresent() || unwaxedBlock5.isPresent())) {
            if (unwaxedBlock2.isPresent()) unwaxing(interactEvent ,blockPos ,itemStack ,level ,unwaxedBlock2.isPresent(), unwaxedBlock2.get().withPropertiesOf(blockState), SoundEvents.AXE_WAX_OFF);
            if (unwaxedBlock5.isPresent()) unwaxing(interactEvent ,blockPos ,itemStack ,level ,unwaxedBlock5.isPresent(), unwaxedBlock5.get().withPropertiesOf(blockState), SoundEvents.AXE_WAX_OFF);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (itemStack.is(ItemTags.HOES) && unwaxedBlock3.isPresent()) {
            unwaxing(interactEvent ,blockPos ,itemStack ,level ,unwaxedBlock3.isPresent(), unwaxedBlock3.get().withPropertiesOf(blockState), WaxedModSounds.SHOVEL_WAX_OFF.get());
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return (InteractionResult.PASS);
        }
    }

    private static Optional unwaxing (PlayerInteractEvent interactEvent, BlockPos blockPos, ItemStack itemStack, Level level, Boolean present, BlockState unwaxedBlock, SoundEvent soundEvent){
        Player player = interactEvent.getEntity();
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockPos, itemStack);
        }
        interactEvent.getEntity().swing(interactEvent.getHand());
        if (!interactEvent.getEntity().isCreative()) {
            interactEvent.getItemStack().hurtAndBreak(1, player, (player1) -> {
                player1.broadcastBreakEvent(interactEvent.getHand());
            });
        }
        if (player instanceof ServerPlayer serverPlayer) {
            Advancement advWaxOff = serverPlayer.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/wax_off"));
            AdvancementProgress advWaxOffProgress = serverPlayer.getAdvancements().getOrStartProgress(advWaxOff);
            if (!advWaxOffProgress.isDone()) {
                for (String criteria : advWaxOffProgress.getRemainingCriteria()) {
                    serverPlayer.getAdvancements().award(advWaxOff, criteria);
                }
            }
        }
        if (!level.isClientSide() || present) level.setBlock(blockPos, unwaxedBlock, 11);
        level.levelEvent(player, 3004, blockPos, 0);
        level.playLocalSound(blockPos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F, false);
        return Optional.ofNullable(null);
    }

    @SubscribeEvent
    public static InteractionResult waxOnUsingWaxOnlyPlayerInteract(final PlayerInteractEvent.RightClickBlock interactEvent) {
        Level level = interactEvent.getLevel();
        BlockPos blockPos = interactEvent.getPos();
        BlockState blockState = level.getBlockState(blockPos);
        ItemStack itemStack = interactEvent.getItemStack();
        var waxedQuarkBlock = getWaxedModdedBlocks(blockState.getBlock());
        var waxedVanillaBlock = getVanillaWaxedCopperBlocks(blockState.getBlock());
        if (itemStack.is(WaxedModItems.WAX.get()) && (waxedQuarkBlock.isPresent() || waxedVanillaBlock.isPresent())) {
            Player player = interactEvent.getEntity();
            if (player instanceof ServerPlayer && waxedQuarkBlock.isPresent()) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
            }
            if (waxedQuarkBlock.isPresent()) interactEvent.getEntity().swing(interactEvent.getHand());
            if (!interactEvent.getEntity().isCreative() && waxedQuarkBlock.isPresent()) interactEvent.getItemStack().shrink(1);
            if (!level.isClientSide() && waxedQuarkBlock.isPresent()) level.setBlock(blockPos, waxedQuarkBlock.get().withPropertiesOf(blockState), 11);
            if (player instanceof ServerPlayer serverPlayer) {
                Advancement advWaxOn = serverPlayer.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/wax_on"));
                AdvancementProgress advWaxOnProgress = serverPlayer.getAdvancements().getOrStartProgress(advWaxOn);
                if (!advWaxOnProgress.isDone()) {
                    for (String criteria : advWaxOnProgress.getRemainingCriteria()) {
                        serverPlayer.getAdvancements().award(advWaxOn, criteria);
                    }
                }
            }
            if (waxedQuarkBlock.isPresent()) level.levelEvent(player, 3003, blockPos, 0);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return (InteractionResult.PASS);
        }
    }
}
