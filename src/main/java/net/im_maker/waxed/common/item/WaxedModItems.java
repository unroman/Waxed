package net.im_maker.waxed.common.item;

import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.BaseCoralFanBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WaxedModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Waxed.MOD_ID);
    //Waxed Coral Fans
    public static final RegistryObject<Item> WAXED_TUBE_CORAL_FAN = ITEMS.register("waxed_tube_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_TUBE_CORAL_FAN.get(), WaxedModBlocks.WAXED_TUBE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_BRAIN_CORAL_FAN = ITEMS.register("waxed_brain_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_BRAIN_CORAL_FAN.get(), WaxedModBlocks.WAXED_BRAIN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_BUBBLE_CORAL_FAN = ITEMS.register("waxed_bubble_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_BUBBLE_CORAL_FAN.get(), WaxedModBlocks.WAXED_BUBBLE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_FIRE_CORAL_FAN = ITEMS.register("waxed_fire_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_FIRE_CORAL_FAN.get(), WaxedModBlocks.WAXED_FIRE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_HORN_CORAL_FAN = ITEMS.register("waxed_horn_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_HORN_CORAL_FAN.get(), WaxedModBlocks.WAXED_HORN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    //Upgrade Aquatic Waxed Coral Fans
    public static final RegistryObject<Item> WAXED_ACAN_CORAL_FAN = ITEMS.register("waxed_acan_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_ACAN_CORAL_FAN.get(), WaxedModBlocks.WAXED_ACAN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_FINGER_CORAL_FAN = ITEMS.register("waxed_finger_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_FINGER_CORAL_FAN.get(), WaxedModBlocks.WAXED_FINGER_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_STAR_CORAL_FAN = ITEMS.register("waxed_star_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_STAR_CORAL_FAN.get(), WaxedModBlocks.WAXED_STAR_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_MOSS_CORAL_FAN = ITEMS.register("waxed_moss_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_MOSS_CORAL_FAN.get(), WaxedModBlocks.WAXED_MOSS_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_PETAL_CORAL_FAN = ITEMS.register("waxed_petal_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_PETAL_CORAL_FAN.get(), WaxedModBlocks.WAXED_PETAL_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_BRANCH_CORAL_FAN = ITEMS.register("waxed_branch_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_BRANCH_CORAL_FAN.get(), WaxedModBlocks.WAXED_BRANCH_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_ROCK_CORAL_FAN = ITEMS.register("waxed_rock_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_ROCK_CORAL_FAN.get(), WaxedModBlocks.WAXED_ROCK_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_PILLOW_CORAL_FAN = ITEMS.register("waxed_pillow_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_PILLOW_CORAL_FAN.get(), WaxedModBlocks.WAXED_PILLOW_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_SILK_CORAL_FAN = ITEMS.register("waxed_silk_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_SILK_CORAL_FAN.get(), WaxedModBlocks.WAXED_SILK_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_CHROME_CORAL_FAN = ITEMS.register("waxed_chrome_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_CHROME_CORAL_FAN.get(), WaxedModBlocks.WAXED_CHROME_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WAXED_PRISMARINE_CORAL_FAN = ITEMS.register("waxed_prismarine_coral_fan", () -> new StandingAndWallBlockItem(WaxedModBlocks.WAXED_PRISMARINE_CORAL_FAN.get(), WaxedModBlocks.WAXED_PRISMARINE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    //Wax =]
    public static final RegistryObject<Item> WAX = ITEMS.register("wax", () -> new HoneycombItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}