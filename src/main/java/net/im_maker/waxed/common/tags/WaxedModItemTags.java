package net.im_maker.waxed.common.tags;


import net.im_maker.waxed.Waxed;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class WaxedModItemTags {
    public static final TagKey<Item> WAX_PILLARS = tag("wax_pillars");
    public static final TagKey<Item> CAN_WAX = tag("can_wax");

    private static TagKey<Item> tag(String name) {
        return ItemTags.create(new ResourceLocation(Waxed.MOD_ID, name));
    }

}
