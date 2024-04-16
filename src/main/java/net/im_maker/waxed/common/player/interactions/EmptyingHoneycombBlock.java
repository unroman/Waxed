package net.im_maker.waxed.common.player.interactions;

import net.im_maker.waxed.Waxed;
import net.im_maker.waxed.common.block.WaxedModBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Waxed.MOD_ID)
public class EmptyingHoneycombBlock {

    @SubscribeEvent
    public static InteractionResult emptyingHoneycombBlock(final PlayerInteractEvent.RightClickBlock interactEvent) {
        Level level = interactEvent.getLevel();
        BlockPos blockPos = interactEvent.getPos();
        BlockState blockState = level.getBlockState(blockPos);
        ItemStack itemStack = interactEvent.getItemStack();
        if (itemStack.is(Items.GLASS_BOTTLE) && blockState.is(Blocks.HONEYCOMB_BLOCK)) {
            Player player = interactEvent.getEntity();
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockPos, itemStack);
            }
            interactEvent.getEntity().swing(interactEvent.getHand());
            //if (!interactEvent.getEntity().isCreative()) interactEvent.getItemStack().shrink(1);
            //if (!interactEvent.getEntity().isCreative() && interactEvent.getEntity().getInventory().items.contains(Items.HONEY_BOTTLE)) interactEvent.getItemStack().shrink(1);

            itemStack.shrink(1);
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (itemStack.isEmpty()) {
                player.setItemInHand(player.getUsedItemHand(), new ItemStack(Items.HONEY_BOTTLE));
            } else if (!player.getInventory().add(new ItemStack(Items.HONEY_BOTTLE))) {
                player.drop(new ItemStack(Items.HONEY_BOTTLE), false);
            }
            if (!level.isClientSide()) level.setBlock(blockPos, WaxedModBlocks.EMPTY_HONEYCOMB.get().defaultBlockState(), 11);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return (InteractionResult.PASS);
        }
    }
}
