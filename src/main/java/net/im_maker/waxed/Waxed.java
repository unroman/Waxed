package net.im_maker.waxed;

import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.im_maker.waxed.common.particles.WaxedModParticles;
import net.im_maker.waxed.common.item.WaxedModItems;
import net.im_maker.waxed.common.sounds.WaxedModSounds;
import net.mehvahdjukaar.amendments.Amendments;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.mehvahdjukaar.suppsquared.SuppSquared;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.MutableHashedLinkedMap;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Function;

@Mod(Waxed.MOD_ID)
public class Waxed {
    public static final String MOD_ID = "waxed";
    private static final Function<ItemLike, ItemStack> FUNCTION = ItemStack::new;

    public Waxed() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        WaxedModItems.register(modEventBus);
        WaxedModBlocks.register(modEventBus);
        WaxedModSounds.register(modEventBus);
        WaxedModParticles.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        RenderType cutoutRenderType = RenderType.cutout();
        ItemBlockRenderTypes.setRenderLayer(WaxedModBlocks.SOUL_CANDLE_HOLDER.get(), cutoutRenderType);
        ItemBlockRenderTypes.setRenderLayer(WaxedModBlocks.GOLD_SOUL_CANDLE_HOLDER.get(), cutoutRenderType);
    }

    private static void addAfter(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike after, ItemLike... blocks) {
        for (int i = blocks.length - 1; i >= 0; i--) {
            ItemLike block = blocks[i];
            map.putAfter(FUNCTION.apply(after), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private static void addBefore(MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> map, ItemLike before, ItemLike... blocks) {
        for (ItemLike block : blocks) {
            map.putBefore(FUNCTION.apply(before), FUNCTION.apply(block), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        MutableHashedLinkedMap<ItemStack, CreativeModeTab.TabVisibility> entries = event.getEntries();
        if (ModList.get().isLoaded("supplementaries")) {
            if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
                addBefore(entries, ModRegistry.CANDLE_HOLDERS.get(DyeColor.WHITE).get(), WaxedModBlocks.SOUL_CANDLE_HOLDER.get());
            }
            if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
                addBefore(entries, ModRegistry.CANDLE_HOLDERS.get(DyeColor.WHITE).get(), WaxedModBlocks.SOUL_CANDLE_HOLDER.get());
            }
        }
        if (ModList.get().isLoaded("suppsquared")) {
            if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
                addBefore(entries, SuppSquared.GOLDEN_CANDLE_HOLDERS.get(DyeColor.WHITE).get(), WaxedModBlocks.GOLD_SOUL_CANDLE_HOLDER.get());
            }
            if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
                addBefore(entries, SuppSquared.GOLDEN_CANDLE_HOLDERS.get(DyeColor.WHITE).get(), WaxedModBlocks.GOLD_SOUL_CANDLE_HOLDER.get());
            }
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            addAfter(entries, Items.CANDLE, WaxedModBlocks.SOUL_CANDLE.get());
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            addAfter(entries, Items.STRING, WaxedModBlocks.WICK.get());
            addAfter(entries, Items.HONEYCOMB, WaxedModItems.WAX.get());
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            addAfter(entries, Items.WAXED_OXIDIZED_CUT_COPPER_SLAB,
                    //WaxedModBlocks.WAXED_PRISMARINE.get(),
                    //WaxedModBlocks.WAXED_PRISMARINE_STAIRS.get(),
                    //WaxedModBlocks.WAXED_PRISMARINE_SLAB.get(),
                    //WaxedModBlocks.WAXED_PRISMARINE_WALL.get(),
                    WaxedModBlocks.WAXED_SAND.get(),
                    WaxedModBlocks.WAXED_RED_SAND.get(),
                    WaxedModBlocks.WAXED_GRAVEL.get(),
                    WaxedModBlocks.WAXED_POWDER_SNOW.get(),
                    WaxedModBlocks.WAXED_SOUL_SAND.get(),
                    WaxedModBlocks.WAXED_MAGMA_BLOCK.get(),
                    WaxedModBlocks.WAXED_SPONGE.get(),
                    WaxedModBlocks.WAXED_REDSTONE_BLOCK.get());
            if (ModList.get().isLoaded("supplementaries")){
                addAfter(entries, WaxedModBlocks.WAXED_REDSTONE_BLOCK.get(),
                        WaxedModBlocks.WAXED_SOAP_BLOCK.get(),
                        //WaxedModBlocks.WAXED_FEATHER_BLOCK.get(),
                        WaxedModBlocks.WAXED_SUGAR_CUBE.get(),
                        WaxedModBlocks.WAXED_FODDER.get());
            }
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            addAfter(entries, Items.HONEYCOMB_BLOCK, WaxedModBlocks.EMPTY_HONEYCOMB.get());
            //addAfter(entries, Items.COBWEB, WaxedBlocks.WAXED_COBWEB.get());
            if (ModList.get().isLoaded("upgrade_aquatic")) {
                addAfter(entries, UABlocks.PRISMARINE_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_TUBE_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_BRAIN_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_BUBBLE_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_FIRE_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_HORN_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_ACAN_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_FINGER_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_STAR_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_MOSS_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_PETAL_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_BRANCH_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_ROCK_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_PILLOW_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_SILK_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_CHROME_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_PRISMARINE_CORAL_BLOCK.get());
                addAfter(entries, UABlocks.PRISMARINE_CORAL.get(),
                        WaxedModBlocks.WAXED_TUBE_CORAL.get(),
                        WaxedModBlocks.WAXED_BRAIN_CORAL.get(),
                        WaxedModBlocks.WAXED_BUBBLE_CORAL.get(),
                        WaxedModBlocks.WAXED_FIRE_CORAL.get(),
                        WaxedModBlocks.WAXED_HORN_CORAL.get(),
                        WaxedModBlocks.WAXED_ACAN_CORAL.get(),
                        WaxedModBlocks.WAXED_FINGER_CORAL.get(),
                        WaxedModBlocks.WAXED_STAR_CORAL.get(),
                        WaxedModBlocks.WAXED_MOSS_CORAL.get(),
                        WaxedModBlocks.WAXED_PETAL_CORAL.get(),
                        WaxedModBlocks.WAXED_BRANCH_CORAL.get(),
                        WaxedModBlocks.WAXED_ROCK_CORAL.get(),
                        WaxedModBlocks.WAXED_PILLOW_CORAL.get(),
                        WaxedModBlocks.WAXED_SILK_CORAL.get(),
                        WaxedModBlocks.WAXED_CHROME_CORAL.get(),
                        WaxedModBlocks.WAXED_PRISMARINE_CORAL.get());
                addAfter(entries, UABlocks.PRISMARINE_CORAL_FAN.get(),
                        WaxedModItems.WAXED_TUBE_CORAL_FAN.get(),
                        WaxedModItems.WAXED_BRAIN_CORAL_FAN.get(),
                        WaxedModItems.WAXED_BUBBLE_CORAL_FAN.get(),
                        WaxedModItems.WAXED_FIRE_CORAL_FAN.get(),
                        WaxedModItems.WAXED_HORN_CORAL_FAN.get(),
                        WaxedModItems.WAXED_ACAN_CORAL_FAN.get(),
                        WaxedModItems.WAXED_FINGER_CORAL_FAN.get(),
                        WaxedModItems.WAXED_STAR_CORAL_FAN.get(),
                        WaxedModItems.WAXED_MOSS_CORAL_FAN.get(),
                        WaxedModItems.WAXED_PETAL_CORAL_FAN.get(),
                        WaxedModItems.WAXED_BRANCH_CORAL_FAN.get(),
                        WaxedModItems.WAXED_ROCK_CORAL_FAN.get(),
                        WaxedModItems.WAXED_PILLOW_CORAL_FAN.get(),
                        WaxedModItems.WAXED_SILK_CORAL_FAN.get(),
                        WaxedModItems.WAXED_CHROME_CORAL_FAN.get(),
                        WaxedModItems.WAXED_PRISMARINE_CORAL_FAN.get());
                addAfter(entries, UABlocks.PRISMARINE_CORAL_SHOWER.get(), WaxedModBlocks.WAXED_PRISMARINE_CORAL_SHOWER.get());
            } else {
                addAfter(entries, Items.HORN_CORAL_BLOCK,
                        WaxedModBlocks.WAXED_TUBE_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_BRAIN_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_BUBBLE_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_FIRE_CORAL_BLOCK.get(),
                        WaxedModBlocks.WAXED_HORN_CORAL_BLOCK.get());
                addAfter(entries, Items.HORN_CORAL,
                        WaxedModBlocks.WAXED_TUBE_CORAL.get(),
                        WaxedModBlocks.WAXED_BRAIN_CORAL.get(),
                        WaxedModBlocks.WAXED_BUBBLE_CORAL.get(),
                        WaxedModBlocks.WAXED_FIRE_CORAL.get(),
                        WaxedModBlocks.WAXED_HORN_CORAL.get());
                addAfter(entries, Items.HORN_CORAL_FAN,
                        WaxedModBlocks.WAXED_TUBE_CORAL_FAN.get(),
                        WaxedModBlocks.WAXED_BRAIN_CORAL_FAN.get(),
                        WaxedModBlocks.WAXED_BUBBLE_CORAL_FAN.get(),
                        WaxedModBlocks.WAXED_FIRE_CORAL_FAN.get(),
                        WaxedModBlocks.WAXED_HORN_CORAL_FAN.get());
            }
        }
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            addAfter(entries, Items.CANDLE, WaxedModBlocks.SOUL_CANDLE.get());
            if (ModList.get().isLoaded("dye_depot")) {
                event.accept(WaxedModBlocks.WAX_BLOCK);
                addBefore(entries, Items.CANDLE,
                        WaxedModBlocks.WAX_BLOCK.get(),
                        WaxedModBlocks.SOUL_WAX_BLOCK.get(),
                        WaxedModBlocks.WHITE_WAX_BLOCK.get(),
                        WaxedModBlocks.LIGHT_GRAY_WAX_BLOCK.get(),
                        WaxedModBlocks.GRAY_WAX_BLOCK.get(),
                        WaxedModBlocks.BLACK_WAX_BLOCK.get(),
                        WaxedModBlocks.BROWN_WAX_BLOCK.get(),
                        WaxedModBlocks.ROSE_WAX_BLOCK.get(),
                        WaxedModBlocks.MAROON_WAX_BLOCK.get(),
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
                        WaxedModBlocks.SOUL_WAX_PILLAR.get(),
                        WaxedModBlocks.WHITE_WAX_PILLAR.get(),
                        WaxedModBlocks.LIGHT_GRAY_WAX_PILLAR.get(),
                        WaxedModBlocks.GRAY_WAX_PILLAR.get(),
                        WaxedModBlocks.BLACK_WAX_PILLAR.get(),
                        WaxedModBlocks.BROWN_WAX_PILLAR.get(),
                        WaxedModBlocks.ROSE_WAX_PILLAR.get(),
                        WaxedModBlocks.MAROON_WAX_PILLAR.get(),
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
                        WaxedModBlocks.PINK_WAX_PILLAR.get());
                addAfter(entries, Items.PINK_CONCRETE_POWDER,
                        WaxedModBlocks.WAXED_WHITE_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_LIGHT_GRAY_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_GRAY_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_BLACK_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_BROWN_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_ROSE_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_MAROON_CONCRETE_POWDER.get(),
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
                        WaxedModBlocks.WAXED_PINK_CONCRETE_POWDER.get());
            } else {
                addBefore(entries, Items.CANDLE,
                        WaxedModBlocks.WAX_BLOCK.get(),
                        WaxedModBlocks.SOUL_WAX_BLOCK.get(),
                        WaxedModBlocks.WHITE_WAX_BLOCK.get(),
                        WaxedModBlocks.LIGHT_GRAY_WAX_BLOCK.get(),
                        WaxedModBlocks.GRAY_WAX_BLOCK.get(),
                        WaxedModBlocks.BLACK_WAX_BLOCK.get(),
                        WaxedModBlocks.BROWN_WAX_BLOCK.get(),
                        WaxedModBlocks.RED_WAX_BLOCK.get(),
                        WaxedModBlocks.ORANGE_WAX_BLOCK.get(),
                        WaxedModBlocks.YELLOW_WAX_BLOCK.get(),
                        WaxedModBlocks.LIME_WAX_BLOCK.get(),
                        WaxedModBlocks.GREEN_WAX_BLOCK.get(),
                        WaxedModBlocks.CYAN_WAX_BLOCK.get(),
                        WaxedModBlocks.LIGHT_BLUE_WAX_BLOCK.get(),
                        WaxedModBlocks.BLUE_WAX_BLOCK.get(),
                        WaxedModBlocks.PURPLE_WAX_BLOCK.get(),
                        WaxedModBlocks.MAGENTA_WAX_BLOCK.get(),
                        WaxedModBlocks.PINK_WAX_BLOCK.get(),
                        WaxedModBlocks.WAX_PILLAR.get(),
                        WaxedModBlocks.SOUL_WAX_PILLAR.get(),
                        WaxedModBlocks.WHITE_WAX_PILLAR.get(),
                        WaxedModBlocks.LIGHT_GRAY_WAX_PILLAR.get(),
                        WaxedModBlocks.GRAY_WAX_PILLAR.get(),
                        WaxedModBlocks.BLACK_WAX_PILLAR.get(),
                        WaxedModBlocks.BROWN_WAX_PILLAR.get(),
                        WaxedModBlocks.RED_WAX_PILLAR.get(),
                        WaxedModBlocks.ORANGE_WAX_PILLAR.get(),
                        WaxedModBlocks.YELLOW_WAX_PILLAR.get(),
                        WaxedModBlocks.LIME_WAX_PILLAR.get(),
                        WaxedModBlocks.GREEN_WAX_PILLAR.get(),
                        WaxedModBlocks.CYAN_WAX_PILLAR.get(),
                        WaxedModBlocks.LIGHT_BLUE_WAX_PILLAR.get(),
                        WaxedModBlocks.BLUE_WAX_PILLAR.get(),
                        WaxedModBlocks.PURPLE_WAX_PILLAR.get(),
                        WaxedModBlocks.MAGENTA_WAX_PILLAR.get(),
                        WaxedModBlocks.PINK_WAX_PILLAR.get());
                addAfter(entries, Items.PINK_CONCRETE_POWDER,
                        WaxedModBlocks.WAXED_WHITE_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_LIGHT_GRAY_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_GRAY_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_BLACK_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_BROWN_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_RED_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_ORANGE_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_YELLOW_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_LIME_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_GREEN_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_CYAN_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_LIGHT_BLUE_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_BLUE_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_PURPLE_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_MAGENTA_CONCRETE_POWDER.get(),
                        WaxedModBlocks.WAXED_PINK_CONCRETE_POWDER.get());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
