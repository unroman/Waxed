package net.im_maker.waxed.datagen;

import com.github.alexthe668.iwannaskate.server.item.IWSItemRegistry;
import com.ninni.dye_depot.registry.DDItems;
import com.teamabnormals.buzzier_bees.core.registry.BBBlocks;
import com.teamabnormals.buzzier_bees.core.registry.BBItems;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.im_maker.waxed.common.item.WaxedModItems;
import net.im_maker.waxed.common.tags.WaxedModItemTags;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.violetmoon.quark.base.Quark;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> EMPTY_HONEYCOMB = List.of(WaxedModBlocks.EMPTY_HONEYCOMB.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    protected static void waxRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        HoneycombItem.WAXABLES.get().forEach((block1, shapeless) -> {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, shapeless)
                    .requires(block1).requires(WaxedModItems.WAX.get())
                    .group(getItemName(shapeless)).
                    unlockedBy(getHasName(block1), has(block1))
                    .save(pFinishedRecipeConsumer, getConversionRecipeName(shapeless, WaxedModItems.WAX.get()));
        });
    }

    private void waxBlock(ItemLike waxBlock, ItemLike dye, Consumer consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, waxBlock, 8)
                .pattern("WWW")
                .pattern("WDW")
                .pattern("WWW")
                .define('W', WaxedModBlocks.WAX_BLOCK.get())
                .define('D', dye)
                .unlockedBy(getHasName(WaxedModBlocks.WAX_BLOCK.get()), has(WaxedModBlocks.WAX_BLOCK.get()))
                .group("wax_blocks")
                .save(consumer);
    }

    private void waxBlock(ItemLike waxBlock, TagKey<Item> dye, Consumer consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, waxBlock, 8)
                .pattern("WWW")
                .pattern("WDW")
                .pattern("WWW")
                .define('W', WaxedModBlocks.WAX_BLOCK.get())
                .define('D', dye)
                .unlockedBy(getHasName(WaxedModBlocks.WAX_BLOCK.get()), has(WaxedModBlocks.WAX_BLOCK.get()))
                .group("wax_blocks")
                .save(consumer);
    }

    private void waxPillar(ItemLike waxBlock, ItemLike waxPillar, Consumer consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, waxPillar, 2)
                .pattern("W")
                .pattern("W")
                .define('W', waxBlock)
                .unlockedBy(getHasName(waxBlock), has(waxBlock))
                .group("wax_pillars")
                .save(consumer);
    }

    private void waxedBlock(ItemLike waxedBlock, ItemLike unWaxedBlock, Consumer consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, waxedBlock)
                .requires(unWaxedBlock)
                .requires(WaxedModItemTags.CAN_WAX)
                .unlockedBy(getHasName(unWaxedBlock), has(unWaxedBlock))
                .save(consumer);
    }

    private void waxedBlock(ItemLike waxedBlock, ItemLike unWaxedBlock, Consumer consumer, String s) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, waxedBlock)
                .requires(unWaxedBlock)
                .requires(WaxedModItemTags.CAN_WAX)
                .unlockedBy(getHasName(unWaxedBlock), has(unWaxedBlock))
                .save(consumer, s);
    }

    private void waxedBlock(ItemLike waxedBlock, ItemLike unWaxedBlock, Consumer consumer, ResourceLocation s) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, waxedBlock)
                .requires(unWaxedBlock)
                .requires(WaxedModItemTags.CAN_WAX)
                .unlockedBy(getHasName(unWaxedBlock), has(unWaxedBlock))
                .save(consumer, s);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, EMPTY_HONEYCOMB, RecipeCategory.MISC, WaxedModBlocks.WAX_BLOCK.get(), 0.25f, 200, "wax_block");
        waxRecipes(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.HONEYCOMB, 4)
                .requires(Items.HONEYCOMB_BLOCK)
                .unlockedBy(getHasName(Items.HONEYCOMB_BLOCK), has(Items.HONEYCOMB_BLOCK))
                .save(pWriter, Items.HONEYCOMB + "_from_" + Items.HONEYCOMB_BLOCK);

        waxBlock(WaxedModBlocks.SOUL_WAX_BLOCK.get(), ItemTags.SOUL_FIRE_BASE_BLOCKS, pWriter);
        waxBlock(WaxedModBlocks.RED_WAX_BLOCK.get(), Items.RED_DYE, pWriter);
        waxBlock(WaxedModBlocks.ORANGE_WAX_BLOCK.get(), Items.ORANGE_DYE, pWriter);
        waxBlock(WaxedModBlocks.YELLOW_WAX_BLOCK.get(), Items.YELLOW_DYE, pWriter);
        waxBlock(WaxedModBlocks.LIME_WAX_BLOCK.get(), Items.LIME_DYE, pWriter);
        waxBlock(WaxedModBlocks.GREEN_WAX_BLOCK.get(), Items.GREEN_DYE, pWriter);
        waxBlock(WaxedModBlocks.CYAN_WAX_BLOCK.get(), Items.CYAN_DYE, pWriter);
        waxBlock(WaxedModBlocks.LIGHT_BLUE_WAX_BLOCK.get(), Items.LIGHT_BLUE_DYE, pWriter);
        waxBlock(WaxedModBlocks.BLUE_WAX_BLOCK.get(), Items.BLUE_DYE, pWriter);
        waxBlock(WaxedModBlocks.PURPLE_WAX_BLOCK.get(), Items.PURPLE_DYE, pWriter);
        waxBlock(WaxedModBlocks.MAGENTA_WAX_BLOCK.get(), Items.MAGENTA_DYE, pWriter);
        waxBlock(WaxedModBlocks.PINK_WAX_BLOCK.get(), Items.PINK_DYE, pWriter);
        waxBlock(WaxedModBlocks.BROWN_WAX_BLOCK.get(), Items.BROWN_DYE, pWriter);
        waxBlock(WaxedModBlocks.BLACK_WAX_BLOCK.get(), Items.BLACK_DYE, pWriter);
        waxBlock(WaxedModBlocks.GRAY_WAX_BLOCK.get(), Items.GRAY_DYE, pWriter);
        waxBlock(WaxedModBlocks.LIGHT_GRAY_WAX_BLOCK.get(), Items.LIGHT_GRAY_DYE, pWriter);
        waxBlock(WaxedModBlocks.WHITE_WAX_BLOCK.get(), Items.WHITE_DYE, pWriter);

        waxBlock(WaxedModBlocks.MAROON_WAX_BLOCK.get(), DDItems.MAROON_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.ROSE_WAX_BLOCK.get(), DDItems.ROSE_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.CORAL_WAX_BLOCK.get(), DDItems.CORAL_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.INDIGO_WAX_BLOCK.get(), DDItems.INDIGO_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.NAVY_WAX_BLOCK.get(), DDItems.NAVY_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.SLATE_WAX_BLOCK.get(), DDItems.SLATE_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.OLIVE_WAX_BLOCK.get(), DDItems.OLIVE_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.AMBER_WAX_BLOCK.get(), DDItems.AMBER_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.BEIGE_WAX_BLOCK.get(), DDItems.BEIGE_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.TEAL_WAX_BLOCK.get(), DDItems.TEAL_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.MINT_WAX_BLOCK.get(), DDItems.MINT_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.AQUA_WAX_BLOCK.get(), DDItems.AQUA_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.VERDANT_WAX_BLOCK.get(), DDItems.VERDANT_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.FOREST_WAX_BLOCK.get(), DDItems.FOREST_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.GINGER_WAX_BLOCK.get(), DDItems.GINGER_DYE.get(), pWriter);
        waxBlock(WaxedModBlocks.TAN_WAX_BLOCK.get(), DDItems.TAN_DYE.get(), pWriter);

        waxPillar(WaxedModBlocks.WAX_BLOCK.get(), WaxedModBlocks.WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.SOUL_WAX_BLOCK.get(), WaxedModBlocks.SOUL_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.RED_WAX_BLOCK.get(), WaxedModBlocks.RED_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.ORANGE_WAX_BLOCK.get(), WaxedModBlocks.ORANGE_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.YELLOW_WAX_BLOCK.get(), WaxedModBlocks.YELLOW_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.LIME_WAX_BLOCK.get(), WaxedModBlocks.LIME_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.GREEN_WAX_BLOCK.get(), WaxedModBlocks.GREEN_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.CYAN_WAX_BLOCK.get(), WaxedModBlocks.CYAN_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.LIGHT_BLUE_WAX_BLOCK.get(), WaxedModBlocks.LIGHT_BLUE_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.BLUE_WAX_BLOCK.get(), WaxedModBlocks.BLUE_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.PURPLE_WAX_BLOCK.get(), WaxedModBlocks.PURPLE_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.MAGENTA_WAX_BLOCK.get(), WaxedModBlocks.MAGENTA_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.PINK_WAX_BLOCK.get(), WaxedModBlocks.PINK_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.BROWN_WAX_BLOCK.get(), WaxedModBlocks.BROWN_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.BLACK_WAX_BLOCK.get(), WaxedModBlocks.BLACK_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.GRAY_WAX_BLOCK.get(), WaxedModBlocks.GRAY_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.LIGHT_GRAY_WAX_BLOCK.get(), WaxedModBlocks.LIGHT_GRAY_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.WHITE_WAX_BLOCK.get(), WaxedModBlocks.WHITE_WAX_PILLAR.get(), pWriter);

        waxPillar(WaxedModBlocks.MAROON_WAX_BLOCK.get(), WaxedModBlocks.MAROON_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.ROSE_WAX_BLOCK.get(), WaxedModBlocks.ROSE_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.CORAL_WAX_BLOCK.get(), WaxedModBlocks.CORAL_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.INDIGO_WAX_BLOCK.get(), WaxedModBlocks.INDIGO_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.NAVY_WAX_BLOCK.get(), WaxedModBlocks.NAVY_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.SLATE_WAX_BLOCK.get(), WaxedModBlocks.SLATE_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.OLIVE_WAX_BLOCK.get(), WaxedModBlocks.OLIVE_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.AMBER_WAX_BLOCK.get(), WaxedModBlocks.AMBER_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.BEIGE_WAX_BLOCK.get(), WaxedModBlocks.BEIGE_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.TEAL_WAX_BLOCK.get(), WaxedModBlocks.TEAL_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.MINT_WAX_BLOCK.get(), WaxedModBlocks.MINT_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.AQUA_WAX_BLOCK.get(), WaxedModBlocks.AQUA_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.VERDANT_WAX_BLOCK.get(), WaxedModBlocks.VERDANT_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.FOREST_WAX_BLOCK.get(), WaxedModBlocks.FOREST_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.GINGER_WAX_BLOCK.get(), WaxedModBlocks.GINGER_WAX_PILLAR.get(), pWriter);
        waxPillar(WaxedModBlocks.TAN_WAX_BLOCK.get(), WaxedModBlocks.TAN_WAX_PILLAR.get(), pWriter);

        waxedBlock(WaxedModBlocks.WAXED_SAND.get(), Items.SAND, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_RED_SAND.get(), Items.RED_SAND, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_GRAVEL.get(), Items.GRAVEL, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_POWDER_SNOW.get(), Items.POWDER_SNOW_BUCKET, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_SOUL_SAND.get(), Items.SOUL_SAND, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_REDSTONE_BLOCK.get(), Items.REDSTONE_BLOCK, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_PRISMARINE.get(), Items.PRISMARINE, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_MAGMA_BLOCK.get(), Items.MAGMA_BLOCK, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_SPONGE.get(), Items.SPONGE, pWriter);
        //waxedBlock(WaxedBlocks.WAXED_COBWEB.get(), Items.COBWEB, pWriter);
/*
        waxedBlock(WaxedModBlocks.WAXED_TUBE_CORAL_BLOCK.get(), Items.TUBE_CORAL_BLOCK, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BRAIN_CORAL_BLOCK.get(), Items.BRAIN_CORAL_BLOCK, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BUBBLE_CORAL_BLOCK.get(), Items.BUBBLE_CORAL_BLOCK, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_FIRE_CORAL_BLOCK.get(), Items.FIRE_CORAL_BLOCK, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_HORN_CORAL_BLOCK.get(), Items.HORN_CORAL_BLOCK, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_TUBE_CORAL.get(), Items.TUBE_CORAL, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BRAIN_CORAL.get(), Items.BRAIN_CORAL, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BUBBLE_CORAL.get(), Items.BUBBLE_CORAL, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_FIRE_CORAL.get(), Items.FIRE_CORAL, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_HORN_CORAL.get(), Items.HORN_CORAL, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_TUBE_CORAL_FAN.get(), Items.TUBE_CORAL_FAN, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BRAIN_CORAL_FAN.get(), Items.BRAIN_CORAL_FAN, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BUBBLE_CORAL_FAN.get(), Items.BUBBLE_CORAL_FAN, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_FIRE_CORAL_FAN.get(), Items.FIRE_CORAL_FAN, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_HORN_CORAL_FAN.get(), Items.HORN_CORAL_FAN, pWriter);
        */
        String[] corals = {"tube", "brain", "bubble", "fire", "horn"};
        for (String coralType : corals) {
            ResourceLocation waxedCoralBlockLocation = new ResourceLocation("waxed:waxed_" + coralType + "_coral_block");
            ResourceLocation coralBlockLocation = new ResourceLocation("minecraft:" + coralType + "_coral_block");
            Block waxedCoralBlock = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedCoralBlockLocation));
            Block coralBlock = Block.byItem(ForgeRegistries.ITEMS.getValue(coralBlockLocation));
            waxedBlock(waxedCoralBlock, coralBlock, pWriter, new ResourceLocation("waxed", "waxed_" + coralType + "_coral_block"));
            ResourceLocation waxedCoralLocation = new ResourceLocation("waxed:waxed_" + coralType  + "_coral");
            ResourceLocation coralLocation = new ResourceLocation("minecraft:" + coralType  + "_coral");
            Block waxedCoral = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedCoralLocation));
            Block coral = Block.byItem(ForgeRegistries.ITEMS.getValue(coralLocation));
            waxedBlock(waxedCoral, coral, pWriter, new ResourceLocation("waxed", "waxed_" + coralType  + "_coral"));
            ResourceLocation waxedCoralFanLocation = new ResourceLocation("waxed:waxed_" + coralType + "_coral_fan");
            ResourceLocation coralFanLocation = new ResourceLocation("minecraft:" + coralType + "_coral_fan");
            Block waxedCoralFan = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedCoralFanLocation));
            Block coralFan = Block.byItem(ForgeRegistries.ITEMS.getValue(coralFanLocation));
            waxedBlock(waxedCoralFan, coralFan, pWriter, new ResourceLocation("waxed", "waxed_" + coralType + "_coral_fan"));
        }

        if (ModList.get().isLoaded("upgrade_aquatic")) {
            String[] coralsUQ = {"acan", "finger", "star", "moss", "petal", "branch", "rock", "pillow", "silk", "chrome", "prismarine"};
            for (String coralType : coralsUQ) {
                ResourceLocation waxedCoralBlockLocation = new ResourceLocation("waxed:waxed_" + coralType + "_coral_block");
                ResourceLocation coralBlockLocation = new ResourceLocation("upgrade_aquatic:" + coralType + "_coral_block");
                Block waxedCoralBlock = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedCoralBlockLocation));
                Block coralBlock = Block.byItem(ForgeRegistries.ITEMS.getValue(coralBlockLocation));
                waxedBlock(waxedCoralBlock, coralBlock, pWriter, new ResourceLocation("waxed", "waxed_" + coralType + "_coral_block"));
                ResourceLocation waxedCoralLocation = new ResourceLocation("waxed:waxed_" + coralType + "_coral");
                ResourceLocation coralLocation = new ResourceLocation("upgrade_aquatic:" + coralType + "_coral");
                Block waxedCoral = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedCoralLocation));
                Block coral = Block.byItem(ForgeRegistries.ITEMS.getValue(coralLocation));
                waxedBlock(waxedCoral, coral, pWriter, new ResourceLocation("waxed", "waxed_" + coralType  + "_coral"));
                ResourceLocation waxedCoralFanLocation = new ResourceLocation("waxed:waxed_" + coralType + "_coral_fan");
                ResourceLocation coralFanLocation = new ResourceLocation("upgrade_aquatic:" + coralType + "_coral_fan");
                Block waxedCoralFan = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedCoralFanLocation));
                Block coralFan = Block.byItem(ForgeRegistries.ITEMS.getValue(coralFanLocation));
                waxedBlock(waxedCoralFan, coralFan, pWriter, new ResourceLocation("waxed", "waxed_" + coralType + "_coral_fan"));
            }
            waxedBlock(WaxedModBlocks.WAXED_PRISMARINE_CORAL_SHOWER.get(), UABlocks.PRISMARINE_CORAL_SHOWER.get(), pWriter, new ResourceLocation("waxed", "waxed_prismarine_coral_shower"));
        }

        waxedBlock(WaxedModBlocks.WAXED_RED_CONCRETE_POWDER.get(), Items.RED_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_ORANGE_CONCRETE_POWDER.get(), Items.ORANGE_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_YELLOW_CONCRETE_POWDER.get(), Items.YELLOW_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_LIME_CONCRETE_POWDER.get(), Items.LIME_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_GREEN_CONCRETE_POWDER.get(), Items.GREEN_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_CYAN_CONCRETE_POWDER.get(), Items.CYAN_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_LIGHT_BLUE_CONCRETE_POWDER.get(), Items.LIGHT_BLUE_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BLUE_CONCRETE_POWDER.get(), Items.BLUE_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_PURPLE_CONCRETE_POWDER.get(), Items.PURPLE_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_MAGENTA_CONCRETE_POWDER.get(), Items.MAGENTA_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_PINK_CONCRETE_POWDER.get(), Items.PINK_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BROWN_CONCRETE_POWDER.get(), Items.BROWN_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BLACK_CONCRETE_POWDER.get(), Items.BLACK_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_GRAY_CONCRETE_POWDER.get(), Items.GRAY_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_LIGHT_GRAY_CONCRETE_POWDER.get(), Items.LIGHT_GRAY_CONCRETE_POWDER, pWriter);
        waxedBlock(WaxedModBlocks.WAXED_WHITE_CONCRETE_POWDER.get(), Items.WHITE_CONCRETE_POWDER, pWriter);

        waxedBlock(WaxedModBlocks.WAXED_MAROON_CONCRETE_POWDER.get(), DDItems.MAROON_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_ROSE_CONCRETE_POWDER.get(), DDItems.ROSE_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_CORAL_CONCRETE_POWDER.get(), DDItems.CORAL_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_INDIGO_CONCRETE_POWDER.get(), DDItems.INDIGO_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_NAVY_CONCRETE_POWDER.get(), DDItems.NAVY_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_SLATE_CONCRETE_POWDER.get(), DDItems.SLATE_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_OLIVE_CONCRETE_POWDER.get(), DDItems.OLIVE_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_AMBER_CONCRETE_POWDER.get(), DDItems.AMBER_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_BEIGE_CONCRETE_POWDER.get(), DDItems.BEIGE_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_TEAL_CONCRETE_POWDER.get(), DDItems.TEAL_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_MINT_CONCRETE_POWDER.get(), DDItems.MINT_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_AQUA_CONCRETE_POWDER.get(), DDItems.AQUA_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_VERDANT_CONCRETE_POWDER.get(), DDItems.VERDANT_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_FOREST_CONCRETE_POWDER.get(), DDItems.FOREST_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_GINGER_CONCRETE_POWDER.get(), DDItems.GINGER_CONCRETE_POWDER.get(), pWriter);
        waxedBlock(WaxedModBlocks.WAXED_TAN_CONCRETE_POWDER.get(), DDItems.TAN_CONCRETE_POWDER.get(), pWriter);

        //waxedBlock(WaxedModBlocks.WAXED_TAN_CONCRETE_POWDER.get(), DDItems.TAN_CONCRETE_POWDER.get(), pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WaxedModBlocks.WICK.get(), 16)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .define('S', Items.STRING)
                .define('C', ItemTags.COALS)
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CANDLE, 4)
                .pattern("S")
                .pattern("W")
                .define('S', WaxedModBlocks.WICK.get())
                .define('W', WaxedModItemTags.CAN_WAX)
                .unlockedBy(getHasName(WaxedModBlocks.WICK.get()), has(WaxedModBlocks.WICK.get()))
                .unlockedBy(getHasName(WaxedModItems.WAX.get()), has(WaxedModItems.WAX.get()))
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WaxedModBlocks.SOUL_CANDLE.get(), 4)
                .pattern("S")
                .pattern("W")
                .pattern("T")
                .define('S', WaxedModBlocks.WICK.get())
                .define('W', WaxedModItemTags.CAN_WAX)
                .define('T', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .unlockedBy(getHasName(WaxedModBlocks.WICK.get()), has(WaxedModBlocks.WICK.get()))
                .unlockedBy(getHasName(WaxedModItems.WAX.get()), has(WaxedModItems.WAX.get()))
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WaxedModItems.WAX.get(), 9)
                .requires(WaxedModBlocks.WAX_BLOCK.get())
                .unlockedBy(getHasName(WaxedModBlocks.WAX_BLOCK.get()), has(WaxedModBlocks.WAX_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WaxedModBlocks.WAX_BLOCK.get(), 1)
                .requires(WaxedModItems.WAX.get(), 9)
                .unlockedBy(getHasName(WaxedModItems.WAX.get()), has(WaxedModItems.WAX.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, Items.REDSTONE, 9)
                .requires(WaxedModBlocks.WAXED_REDSTONE_BLOCK.get(), 1)
                .unlockedBy(getHasName(WaxedModBlocks.WAXED_REDSTONE_BLOCK.get()), has(WaxedModBlocks.WAXED_REDSTONE_BLOCK.get()))
                .save(pWriter, "redstone_from_waxed_redstone_block");

        //twoByTwoPackerMod(pWriter, Waxed.MOD_ID + ":sandstone_from_waxed_sand", RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE, WaxedModBlocks.WAXED_SAND.get());
        //twoByTwoPackerMod(pWriter, Waxed.MOD_ID + ":red_sandstone_from_waxed_red_sand", RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE, WaxedModBlocks.WAXED_RED_SAND.get());

        if (ModList.get().isLoaded("iwannaskate")) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IWSItemRegistry.SHIMMERING_WAX.get())
                    .requires(WaxedModItemTags.CAN_WAX)
                    .requires(Items.LAPIS_LAZULI)
                    .requires(Items.GLOW_INK_SAC)
                    .unlockedBy(getHasName(WaxedModItems.WAX.get()), has(WaxedModItems.WAX.get()))
                    .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB))
                    .save(pWriter, new ResourceLocation("iwannaskate", "shimmering_wax"));
        }

        if (ModList.get().isLoaded("quark")) {
            String[] quarkCorundumColors = {"red", "orange", "yellow", "green", "blue", "indigo", "violet", "white", "black"};
            for (String color : quarkCorundumColors) {
                ResourceLocation waxedCorundumLocation = new ResourceLocation("quark:waxed_" + color + "_corundum");
                ResourceLocation corundumLocation = new ResourceLocation("quark:" + color + "_corundum");
                Block waxedCorundum = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedCorundumLocation));
                Block corundum = Block.byItem(ForgeRegistries.ITEMS.getValue(corundumLocation));
                waxedBlock(waxedCorundum, corundum, pWriter, new ResourceLocation("quark", "world/crafting/waxed_" + color + "_corundum"));
            }

            String[] quarkVerticalCopperSlabs = {"", "exposed_", "weathered_", "oxidized_"};
            for (String type : quarkVerticalCopperSlabs) {
                ResourceLocation waxedVerticalCopperSlabLocation = new ResourceLocation("quark", "waxed_" + type + "cut_copper_vertical_slab");
                ResourceLocation VerticalCopperSlabLocation = new ResourceLocation("quark", type + "cut_copper_vertical_slab");
                Block waxedVerticalCopperSlab = Block.byItem(ForgeRegistries.ITEMS.getValue(waxedVerticalCopperSlabLocation));
                Block VerticalCopperSlab = Block.byItem(ForgeRegistries.ITEMS.getValue(VerticalCopperSlabLocation));

                waxedBlock(waxedVerticalCopperSlab, VerticalCopperSlab, pWriter, new ResourceLocation("quark", "building/crafting/vertslabs/wax/waxed_" + type + "cut_copper_vertical_slab"));
            }
        }

        if (ModList.get().isLoaded("suppsquared")) {
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, WaxedModBlocks.GOLD_SOUL_CANDLE_HOLDER.get())
                    .pattern("C")
                    .pattern("N")
                    .define('C', WaxedModBlocks.SOUL_CANDLE.get())
                    .define('N', Items.GOLD_INGOT)
                    .unlockedBy(getHasName(WaxedModBlocks.SOUL_CANDLE.get()), has(WaxedModBlocks.SOUL_CANDLE.get()))
                    .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                    .save(pWriter);
        }

        if (ModList.get().isLoaded("supplementaries")) {
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, WaxedModBlocks.SOUL_CANDLE_HOLDER.get())
                    .pattern("NCN")
                    .pattern(" N ")
                    .define('C', WaxedModBlocks.SOUL_CANDLE.get())
                    .define('N', Items.IRON_INGOT)
                    .unlockedBy(getHasName(WaxedModBlocks.SOUL_CANDLE.get()), has(WaxedModBlocks.SOUL_CANDLE.get()))
                    .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                    .save(pWriter);

            waxedBlock(WaxedModBlocks.WAXED_FODDER.get(), ModRegistry.FODDER.get().asItem(), pWriter);
            waxedBlock(WaxedModBlocks.WAXED_SUGAR_CUBE.get(), ModRegistry.SUGAR_CUBE.get().asItem(), pWriter);
            waxedBlock(WaxedModBlocks.WAXED_SOAP_BLOCK.get(), ModRegistry.SOAP_BLOCK.get().asItem(), pWriter);
            waxedBlock(WaxedModBlocks.WAXED_FEATHER_BLOCK.get(), ModRegistry.FEATHER_BLOCK.get().asItem(), pWriter);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.SUGAR, 9)
                    .requires(WaxedModBlocks.WAXED_SUGAR_CUBE.get(), 1)
                    .unlockedBy(getHasName(WaxedModBlocks.WAXED_SUGAR_CUBE.get()), has(WaxedModBlocks.WAXED_SUGAR_CUBE.get()))
                    .save(pWriter, "sugar_from_waxed_sugar_block");

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModRegistry.SOAP.get(), 9)
                    .requires(WaxedModBlocks.WAXED_SOAP_BLOCK.get(), 1)
                    .unlockedBy(getHasName(WaxedModBlocks.WAXED_SOAP_BLOCK.get()), has(WaxedModBlocks.WAXED_SOAP_BLOCK.get()))
                    .save(pWriter, "soap_from_waxed_soap_block");
        }

        if (ModList.get().isLoaded("buzzier_bees")) {
            //ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BBBlocks.SOUL_CANDLE.get())
            //        .save(pWriter, new ResourceLocation("buzzier_bees", "candles/soul_candle"));

            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BBBlocks.SOUL_CANDLE.get(), 2)
                    .pattern("##")
                    .define('#', Ingredient.EMPTY)
                    .unlockedBy(getHasName(BBBlocks.SOUL_CANDLE.get()), has(BBBlocks.SOUL_CANDLE.get()))
                    .save(pWriter, new ResourceLocation("buzzier_bees", "candles/soul_candle"));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WaxedModBlocks.SOUL_CANDLE.get())
                    .requires(BBBlocks.SOUL_CANDLE.get())
                    .unlockedBy(getHasName(BBBlocks.SOUL_CANDLE.get()), has(BBBlocks.SOUL_CANDLE.get()))
                    .save(pWriter, new ResourceLocation("waxed", "soul_candle_from_buzzier_bees_soul_candle"));
        }
    }

    protected static void twoByTwoPackerMod(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String pId, RecipeCategory pCategory, ItemLike pPacked, ItemLike pUnpacked) {
        ShapedRecipeBuilder.shaped(pCategory, pPacked, 1).define('#', pUnpacked).pattern("##").pattern("##").unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pFinishedRecipeConsumer, pId);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Waxed.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}