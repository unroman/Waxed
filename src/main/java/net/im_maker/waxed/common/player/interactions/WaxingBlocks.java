package net.im_maker.waxed.common.player.interactions;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.ninni.dye_depot.registry.DDBlocks;
import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.im_maker.waxed.common.sounds.WaxedModSounds;
import net.im_maker.waxed.common.tags.WaxedModItemTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Waxed.MOD_ID)
public class WaxingBlocks {
    public static final Supplier<BiMap<Block, Block>> WAXABLES_SHOVEL = Suppliers.memoize(() -> {
        return ModList.get().isLoaded("dye_depot") ? ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.SAND, WaxedModBlocks.WAXED_SAND.get())
                .put(Blocks.RED_SAND, WaxedModBlocks.WAXED_RED_SAND.get())
                .put(Blocks.GRAVEL, WaxedModBlocks.WAXED_GRAVEL.get())
                .put(Blocks.POWDER_SNOW, WaxedModBlocks.WAXED_POWDER_SNOW.get())
                .put(Blocks.SOUL_SAND, WaxedModBlocks.WAXED_SOUL_SAND.get())
                .put(Blocks.RED_CONCRETE_POWDER, WaxedModBlocks.WAXED_RED_CONCRETE_POWDER.get())
                .put(Blocks.ORANGE_CONCRETE_POWDER, WaxedModBlocks.WAXED_ORANGE_CONCRETE_POWDER.get())
                .put(Blocks.YELLOW_CONCRETE_POWDER, WaxedModBlocks.WAXED_YELLOW_CONCRETE_POWDER.get())
                .put(Blocks.LIME_CONCRETE_POWDER, WaxedModBlocks.WAXED_LIME_CONCRETE_POWDER.get())
                .put(Blocks.GREEN_CONCRETE_POWDER, WaxedModBlocks.WAXED_GREEN_CONCRETE_POWDER.get())
                .put(Blocks.CYAN_CONCRETE_POWDER, WaxedModBlocks.WAXED_CYAN_CONCRETE_POWDER.get())
                .put(Blocks.LIGHT_BLUE_CONCRETE_POWDER, WaxedModBlocks.WAXED_LIGHT_BLUE_CONCRETE_POWDER.get())
                .put(Blocks.BLUE_CONCRETE_POWDER, WaxedModBlocks.WAXED_BLUE_CONCRETE_POWDER.get())
                .put(Blocks.PURPLE_CONCRETE_POWDER, WaxedModBlocks.WAXED_PURPLE_CONCRETE_POWDER.get())
                .put(Blocks.MAGENTA_CONCRETE_POWDER, WaxedModBlocks.WAXED_MAGENTA_CONCRETE_POWDER.get())
                .put(Blocks.PINK_CONCRETE_POWDER, WaxedModBlocks.WAXED_PINK_CONCRETE_POWDER.get())
                .put(Blocks.BROWN_CONCRETE_POWDER, WaxedModBlocks.WAXED_BROWN_CONCRETE_POWDER.get())
                .put(Blocks.BLACK_CONCRETE_POWDER, WaxedModBlocks.WAXED_BLACK_CONCRETE_POWDER.get())
                .put(Blocks.GRAY_CONCRETE_POWDER, WaxedModBlocks.WAXED_GRAY_CONCRETE_POWDER.get())
                .put(Blocks.LIGHT_GRAY_CONCRETE_POWDER, WaxedModBlocks.WAXED_LIGHT_GRAY_CONCRETE_POWDER.get())
                .put(Blocks.WHITE_CONCRETE_POWDER, WaxedModBlocks.WAXED_WHITE_CONCRETE_POWDER.get())
                .put(DDBlocks.MAROON_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_MAROON_CONCRETE_POWDER.get())
                .put(DDBlocks.ROSE_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_ROSE_CONCRETE_POWDER.get())
                .put(DDBlocks.CORAL_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_CORAL_CONCRETE_POWDER.get())
                .put(DDBlocks.INDIGO_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_INDIGO_CONCRETE_POWDER.get())
                .put(DDBlocks.NAVY_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_NAVY_CONCRETE_POWDER.get())
                .put(DDBlocks.SLATE_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_SLATE_CONCRETE_POWDER.get())
                .put(DDBlocks.OLIVE_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_OLIVE_CONCRETE_POWDER.get())
                .put(DDBlocks.AMBER_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_AMBER_CONCRETE_POWDER.get())
                .put(DDBlocks.BEIGE_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_BEIGE_CONCRETE_POWDER.get())
                .put(DDBlocks.TEAL_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_TEAL_CONCRETE_POWDER.get())
                .put(DDBlocks.MINT_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_MINT_CONCRETE_POWDER.get())
                .put(DDBlocks.AQUA_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_AQUA_CONCRETE_POWDER.get())
                .put(DDBlocks.VERDANT_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_VERDANT_CONCRETE_POWDER.get())
                .put(DDBlocks.FOREST_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_FOREST_CONCRETE_POWDER.get())
                .put(DDBlocks.GINGER_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_GINGER_CONCRETE_POWDER.get())
                .put(DDBlocks.TAN_CONCRETE_POWDER.get(), WaxedModBlocks.WAXED_TAN_CONCRETE_POWDER.get())
                .build() : ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.SAND, WaxedModBlocks.WAXED_SAND.get())
                .put(Blocks.RED_SAND, WaxedModBlocks.WAXED_RED_SAND.get())
                .put(Blocks.GRAVEL, WaxedModBlocks.WAXED_GRAVEL.get())
                .put(Blocks.POWDER_SNOW, WaxedModBlocks.WAXED_POWDER_SNOW.get())
                .put(Blocks.SOUL_SAND, WaxedModBlocks.WAXED_SOUL_SAND.get())
                .put(Blocks.RED_CONCRETE_POWDER, WaxedModBlocks.WAXED_RED_CONCRETE_POWDER.get())
                .put(Blocks.ORANGE_CONCRETE_POWDER, WaxedModBlocks.WAXED_ORANGE_CONCRETE_POWDER.get())
                .put(Blocks.YELLOW_CONCRETE_POWDER, WaxedModBlocks.WAXED_YELLOW_CONCRETE_POWDER.get())
                .put(Blocks.LIME_CONCRETE_POWDER, WaxedModBlocks.WAXED_LIME_CONCRETE_POWDER.get())
                .put(Blocks.GREEN_CONCRETE_POWDER, WaxedModBlocks.WAXED_GREEN_CONCRETE_POWDER.get())
                .put(Blocks.CYAN_CONCRETE_POWDER, WaxedModBlocks.WAXED_CYAN_CONCRETE_POWDER.get())
                .put(Blocks.LIGHT_BLUE_CONCRETE_POWDER, WaxedModBlocks.WAXED_LIGHT_BLUE_CONCRETE_POWDER.get())
                .put(Blocks.BLUE_CONCRETE_POWDER, WaxedModBlocks.WAXED_BLUE_CONCRETE_POWDER.get())
                .put(Blocks.PURPLE_CONCRETE_POWDER, WaxedModBlocks.WAXED_PURPLE_CONCRETE_POWDER.get())
                .put(Blocks.MAGENTA_CONCRETE_POWDER, WaxedModBlocks.WAXED_MAGENTA_CONCRETE_POWDER.get())
                .put(Blocks.PINK_CONCRETE_POWDER, WaxedModBlocks.WAXED_PINK_CONCRETE_POWDER.get())
                .put(Blocks.BROWN_CONCRETE_POWDER, WaxedModBlocks.WAXED_BROWN_CONCRETE_POWDER.get())
                .put(Blocks.BLACK_CONCRETE_POWDER, WaxedModBlocks.WAXED_BLACK_CONCRETE_POWDER.get())
                .put(Blocks.GRAY_CONCRETE_POWDER, WaxedModBlocks.WAXED_GRAY_CONCRETE_POWDER.get())
                .put(Blocks.LIGHT_GRAY_CONCRETE_POWDER, WaxedModBlocks.WAXED_LIGHT_GRAY_CONCRETE_POWDER.get())
                .put(Blocks.WHITE_CONCRETE_POWDER, WaxedModBlocks.WAXED_WHITE_CONCRETE_POWDER.get())
                .build();
    });
    public static final Supplier<BiMap<Block, Block>> WAXABLES_AXE = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.MAGMA_BLOCK, WaxedModBlocks.WAXED_MAGMA_BLOCK.get())
                .put(Blocks.REDSTONE_BLOCK, WaxedModBlocks.WAXED_REDSTONE_BLOCK.get())
                .put(Blocks.PRISMARINE, WaxedModBlocks.WAXED_PRISMARINE.get())
                .build();
    });
    public static final Supplier<BiMap<Block, Block>> WAXABLES_HOE = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(Blocks.SPONGE, WaxedModBlocks.WAXED_SPONGE.get())
                //.put(Blocks.COBWEB, WaxedBlocks.WAXED_COBWEB.get())
                .put(Blocks.TUBE_CORAL_BLOCK, WaxedModBlocks.WAXED_TUBE_CORAL_BLOCK.get())
                .put(Blocks.BRAIN_CORAL_BLOCK, WaxedModBlocks.WAXED_BRAIN_CORAL_BLOCK.get())
                .put(Blocks.BUBBLE_CORAL_BLOCK, WaxedModBlocks.WAXED_BUBBLE_CORAL_BLOCK.get())
                .put(Blocks.FIRE_CORAL_BLOCK, WaxedModBlocks.WAXED_FIRE_CORAL_BLOCK.get())
                .put(Blocks.HORN_CORAL_BLOCK, WaxedModBlocks.WAXED_HORN_CORAL_BLOCK.get())
                .put(Blocks.TUBE_CORAL, WaxedModBlocks.WAXED_TUBE_CORAL.get())
                .put(Blocks.BRAIN_CORAL, WaxedModBlocks.WAXED_BRAIN_CORAL.get())
                .put(Blocks.BUBBLE_CORAL, WaxedModBlocks.WAXED_BUBBLE_CORAL.get())
                .put(Blocks.FIRE_CORAL, WaxedModBlocks.WAXED_FIRE_CORAL.get())
                .put(Blocks.HORN_CORAL, WaxedModBlocks.WAXED_HORN_CORAL.get())
                .put(Blocks.TUBE_CORAL_FAN, WaxedModBlocks.WAXED_TUBE_CORAL_FAN.get())
                .put(Blocks.BRAIN_CORAL_FAN, WaxedModBlocks.WAXED_BRAIN_CORAL_FAN.get())
                .put(Blocks.BUBBLE_CORAL_FAN, WaxedModBlocks.WAXED_BUBBLE_CORAL_FAN.get())
                .put(Blocks.FIRE_CORAL_FAN, WaxedModBlocks.WAXED_FIRE_CORAL_FAN.get())
                .put(Blocks.HORN_CORAL_FAN, WaxedModBlocks.WAXED_HORN_CORAL_FAN.get())
                .put(Blocks.TUBE_CORAL_WALL_FAN, WaxedModBlocks.WAXED_TUBE_CORAL_WALL_FAN.get())
                .put(Blocks.BRAIN_CORAL_WALL_FAN, WaxedModBlocks.WAXED_BRAIN_CORAL_WALL_FAN.get())
                .put(Blocks.BUBBLE_CORAL_WALL_FAN, WaxedModBlocks.WAXED_BUBBLE_CORAL_WALL_FAN.get())
                .put(Blocks.FIRE_CORAL_WALL_FAN, WaxedModBlocks.WAXED_FIRE_CORAL_WALL_FAN.get())
                .put(Blocks.HORN_CORAL_WALL_FAN, WaxedModBlocks.WAXED_HORN_CORAL_WALL_FAN.get())
                .build();
    });

    //public static final Supplier<BiMap<Block, Block>> WAXABLES = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder().put(Blocks.SAND, WaxItBlocks.WAXED_SAND.get()).build());
    //public static final Supplier<BiMap<Block, Block>> WAXABLES = Suppliers.memoize(() -> ImmutableBiMap.<Block, Block>builder().put(Blocks.COPPER_BLOCK, Blocks.WAXED_COPPER_BLOCK).build());

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

    public static Optional<Block> getUnwaxedHoes(Block block) {
        return Optional.ofNullable(WAXABLES_HOE.get().inverse().get(block));
    }

    @SubscribeEvent
    public static InteractionResult waxOnPlayerInteract(final PlayerInteractEvent.RightClickBlock interactEvent) {
        Level level = interactEvent.getLevel();
        BlockPos blockPos = interactEvent.getPos();
        BlockState blockState = level.getBlockState(blockPos);
        ItemStack itemStack = interactEvent.getItemStack();
        ItemStack key = interactEvent.getItemStack();
        var waxedBlock1 = getWaxedShovels(blockState.getBlock());
        var waxedBlock2 = getWaxedAxe(blockState.getBlock());
        var waxedBlock3 = getWaxedHoes(blockState.getBlock());
        if (itemStack.is(WaxedModItemTags.CAN_WAX) && (waxedBlock1.isPresent() || waxedBlock2.isPresent() || waxedBlock3.isPresent())) {
            Player player = interactEvent.getEntity();
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
            }
            interactEvent.getEntity().swing(interactEvent.getHand());
            if (!interactEvent.getEntity().isCreative()) interactEvent.getItemStack().shrink(1);
            if (!level.isClientSide() && waxedBlock1.isPresent()) level.setBlock(blockPos, waxedBlock1.get().withPropertiesOf(blockState), 11);
            if (!level.isClientSide() && waxedBlock2.isPresent()) level.setBlock(blockPos, waxedBlock2.get().withPropertiesOf(blockState), 11);
            if (!level.isClientSide() && waxedBlock3.isPresent()) level.setBlock(blockPos, waxedBlock3.get().withPropertiesOf(blockState), 11);
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
        if (itemStack.is(ItemTags.SHOVELS) && unwaxedBlock1.isPresent()) {
            unwaxing(interactEvent ,blockPos ,itemStack ,level ,unwaxedBlock1.isPresent(), unwaxedBlock1.get().withPropertiesOf(blockState), WaxedModSounds.SHOVEL_WAX_OFF.get());
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (itemStack.is(ItemTags.AXES) && unwaxedBlock2.isPresent()) {
            unwaxing(interactEvent ,blockPos ,itemStack ,level ,unwaxedBlock2.isPresent(), unwaxedBlock2.get().withPropertiesOf(blockState), SoundEvents.AXE_WAX_OFF);
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
        if (!level.isClientSide() || present) level.setBlock(blockPos, unwaxedBlock, 11);
        level.levelEvent(player, 3004, blockPos, 0);
        level.playLocalSound(blockPos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F, false);
        return Optional.ofNullable(null);
    }
}
