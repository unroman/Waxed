package net.im_maker.waxed.common.item;

import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> WAX = ITEMS.register("wax", () -> new HoneycombItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}