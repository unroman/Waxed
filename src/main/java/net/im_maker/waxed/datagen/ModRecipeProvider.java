package net.im_maker.waxed.datagen;

import com.ninni.dye_depot.registry.DDItems;
import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.im_maker.waxed.common.item.WaxedModItems;
import net.im_maker.waxed.common.tags.WaxedModItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> EMPTY_HONEYCOMB = List.of(WaxedModBlocks.EMPTY_HONEYCOMB.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    private void coloredWaxBlock(Block waxBlock, Item dye, Consumer consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, waxBlock, 8)
                .pattern("WWW")
                .pattern("WDW")
                .pattern("WWW")
                .define('W', WaxedModBlocks.WAX_BLOCK.get())
                .define('D', dye)
                .unlockedBy(getHasName(WaxedModBlocks.WAX_BLOCK.get()), has(WaxedModBlocks.WAX_BLOCK.get()))
                .save(consumer);
    }

    private void coloredWaxPillar(Block waxBlock, Block waxPillar, Consumer consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, waxPillar, 2)
                .pattern("W")
                .pattern("W")
                .define('W', waxBlock)
                .unlockedBy(getHasName(waxBlock), has(waxBlock))
                .save(consumer);
    }

    private void waxedBlock(Block waxedBlock, Item unWaxedBlock, Consumer consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, waxedBlock)
                .requires(unWaxedBlock)
                .requires(WaxedModItemTags.CAN_WAX)
                .unlockedBy(getHasName(unWaxedBlock), has(unWaxedBlock))
                .save(consumer);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, EMPTY_HONEYCOMB, RecipeCategory.MISC, WaxedModBlocks.WAX_BLOCK.get(), 0.25f, 200, "wax_block");


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, WaxedModBlocks.SOUL_WAX_BLOCK.get(), 8)
                .pattern("SSS")
                .pattern("STS")
                .pattern("SSS")
                .define('S', WaxedModBlocks.WAX_BLOCK.get())
                .define('T', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .unlockedBy(getHasName(WaxedModBlocks.WAX_BLOCK.get()), has(WaxedModBlocks.WAX_BLOCK.get()))
                .save(pWriter);


        coloredWaxBlock(WaxedModBlocks.RED_WAX_BLOCK.get(), Items.RED_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.ORANGE_WAX_BLOCK.get(), Items.ORANGE_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.YELLOW_WAX_BLOCK.get(), Items.YELLOW_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.LIME_WAX_BLOCK.get(), Items.LIME_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.GREEN_WAX_BLOCK.get(), Items.GREEN_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.CYAN_WAX_BLOCK.get(), Items.CYAN_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.LIGHT_BLUE_WAX_BLOCK.get(), Items.LIGHT_BLUE_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.BLUE_WAX_BLOCK.get(), Items.BLUE_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.PURPLE_WAX_BLOCK.get(), Items.PURPLE_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.MAGENTA_WAX_BLOCK.get(), Items.MAGENTA_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.PINK_WAX_BLOCK.get(), Items.PINK_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.BROWN_WAX_BLOCK.get(), Items.BROWN_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.BLACK_WAX_BLOCK.get(), Items.BLACK_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.GRAY_WAX_BLOCK.get(), Items.GRAY_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.LIGHT_GRAY_WAX_BLOCK.get(), Items.LIGHT_GRAY_DYE, pWriter);
        coloredWaxBlock(WaxedModBlocks.WHITE_WAX_BLOCK.get(), Items.WHITE_DYE, pWriter);

        coloredWaxBlock(WaxedModBlocks.MAROON_WAX_BLOCK.get(), DDItems.MAROON_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.ROSE_WAX_BLOCK.get(), DDItems.ROSE_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.CORAL_WAX_BLOCK.get(), DDItems.CORAL_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.INDIGO_WAX_BLOCK.get(), DDItems.INDIGO_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.NAVY_WAX_BLOCK.get(), DDItems.NAVY_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.SLATE_WAX_BLOCK.get(), DDItems.SLATE_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.OLIVE_WAX_BLOCK.get(), DDItems.OLIVE_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.AMBER_WAX_BLOCK.get(), DDItems.AMBER_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.BEIGE_WAX_BLOCK.get(), DDItems.BEIGE_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.TEAL_WAX_BLOCK.get(), DDItems.TEAL_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.MINT_WAX_BLOCK.get(), DDItems.MINT_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.AQUA_WAX_BLOCK.get(), DDItems.AQUA_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.VERDANT_WAX_BLOCK.get(), DDItems.VERDANT_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.FOREST_WAX_BLOCK.get(), DDItems.FOREST_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.GINGER_WAX_BLOCK.get(), DDItems.GINGER_DYE.get(), pWriter);
        coloredWaxBlock(WaxedModBlocks.TAN_WAX_BLOCK.get(), DDItems.TAN_DYE.get(), pWriter);

        coloredWaxPillar(WaxedModBlocks.WAX_BLOCK.get(), WaxedModBlocks.WAX_PILLAR.get(), pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, WaxedModBlocks.SOUL_WAX_PILLAR.get(), 2)
                .pattern("W")
                .pattern("W")
                .define('W', WaxedModBlocks.SOUL_WAX_BLOCK.get())
                .unlockedBy(getHasName(WaxedModBlocks.SOUL_WAX_BLOCK.get()), has(WaxedModBlocks.SOUL_WAX_BLOCK.get()))
                .save(pWriter);

        coloredWaxPillar(WaxedModBlocks.RED_WAX_BLOCK.get(), WaxedModBlocks.RED_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.ORANGE_WAX_BLOCK.get(), WaxedModBlocks.ORANGE_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.YELLOW_WAX_BLOCK.get(), WaxedModBlocks.YELLOW_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.LIME_WAX_BLOCK.get(), WaxedModBlocks.LIME_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.GREEN_WAX_BLOCK.get(), WaxedModBlocks.GREEN_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.CYAN_WAX_BLOCK.get(), WaxedModBlocks.CYAN_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.LIGHT_BLUE_WAX_BLOCK.get(), WaxedModBlocks.LIGHT_BLUE_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.BLUE_WAX_BLOCK.get(), WaxedModBlocks.BLUE_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.PURPLE_WAX_BLOCK.get(), WaxedModBlocks.PURPLE_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.MAGENTA_WAX_BLOCK.get(), WaxedModBlocks.MAGENTA_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.PINK_WAX_BLOCK.get(), WaxedModBlocks.PINK_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.BROWN_WAX_BLOCK.get(), WaxedModBlocks.BROWN_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.BLACK_WAX_BLOCK.get(), WaxedModBlocks.BLACK_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.GRAY_WAX_BLOCK.get(), WaxedModBlocks.GRAY_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.LIGHT_GRAY_WAX_BLOCK.get(), WaxedModBlocks.LIGHT_GRAY_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.WHITE_WAX_BLOCK.get(), WaxedModBlocks.WHITE_WAX_PILLAR.get(), pWriter);

        coloredWaxPillar(WaxedModBlocks.MAROON_WAX_BLOCK.get(), WaxedModBlocks.MAROON_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.ROSE_WAX_BLOCK.get(), WaxedModBlocks.ROSE_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.CORAL_WAX_BLOCK.get(), WaxedModBlocks.CORAL_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.INDIGO_WAX_BLOCK.get(), WaxedModBlocks.INDIGO_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.NAVY_WAX_BLOCK.get(), WaxedModBlocks.NAVY_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.SLATE_WAX_BLOCK.get(), WaxedModBlocks.SLATE_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.OLIVE_WAX_BLOCK.get(), WaxedModBlocks.OLIVE_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.AMBER_WAX_BLOCK.get(), WaxedModBlocks.AMBER_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.BEIGE_WAX_BLOCK.get(), WaxedModBlocks.BEIGE_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.TEAL_WAX_BLOCK.get(), WaxedModBlocks.TEAL_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.MINT_WAX_BLOCK.get(), WaxedModBlocks.MINT_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.AQUA_WAX_BLOCK.get(), WaxedModBlocks.AQUA_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.VERDANT_WAX_BLOCK.get(), WaxedModBlocks.VERDANT_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.FOREST_WAX_BLOCK.get(), WaxedModBlocks.FOREST_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.GINGER_WAX_BLOCK.get(), WaxedModBlocks.GINGER_WAX_PILLAR.get(), pWriter);
        coloredWaxPillar(WaxedModBlocks.TAN_WAX_BLOCK.get(), WaxedModBlocks.TAN_WAX_PILLAR.get(), pWriter);

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

        twoByTwoPackerMod(pWriter, Waxed.MOD_ID + ":sandstone_from_waxed_sand", RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE, WaxedModBlocks.WAXED_SAND.get());
        twoByTwoPackerMod(pWriter, Waxed.MOD_ID + ":red_sandstone_from_waxed_red_sand", RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE, WaxedModBlocks.WAXED_RED_SAND.get());
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