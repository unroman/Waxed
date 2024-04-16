package net.im_maker.waxed.common.tags;


import net.im_maker.waxed.Waxed;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class WaxedModBlockTags {
    public static final TagKey<Block> WAX_PILLARS = tag("wax_pillars");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(Waxed.MOD_ID, name));
    }

}