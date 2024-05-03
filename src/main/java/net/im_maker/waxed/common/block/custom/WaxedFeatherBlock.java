package net.im_maker.waxed.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

import java.util.TreeMap;

public class WaxedFeatherBlock extends Block {

    protected static final VoxelShape COLLISION_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0);
    private static final TreeMap<Float, VoxelShape> COLLISIONS = new TreeMap();

    public WaxedFeatherBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, float height) {
        if (!world.isClientSide) {
            if (height > 2.0F) {
                world.playSound((Player)null, pos, SoundEvents.WOOL_FALL, SoundSource.BLOCKS, 1.0F, 0.9F);
            }
        }

    }

    public void updateEntityAfterFallOn(BlockGetter reader, Entity entity) {
        entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0, 0.4, 1.0));
    }

    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (collisionContext instanceof EntityCollisionContext entityCollisionContext) {
            Entity e = entityCollisionContext.getEntity();
            if (e instanceof LivingEntity entity) {
                float dy = (float)(entity.getY() - (double)blockPos.getY());
                if (dy > 0.0F) {
                    Float key = (Float)COLLISIONS.lowerKey(dy);
                    if (key != null) {
                        return (VoxelShape)COLLISIONS.getOrDefault(key, COLLISION_SHAPE);
                    }
                }
            }
        }

        return Shapes.block();
    }

    static {
        float y = (float)COLLISION_SHAPE.max(Direction.Axis.Y);
        float i = 0.0015F;
        COLLISIONS.put(y - i, Shapes.box(0.0, 0.0, 0.0, 1.0, (double)y, 1.0));

        while(y < 1.0F) {
            COLLISIONS.put(y, Shapes.box(0.0, 0.0, 0.0, 1.0, (double)y, 1.0));
            i = (float)((double)i * 1.131);
            y += i;
        }

        COLLISIONS.put(1.0F, Shapes.block());
        COLLISIONS.put(0.0F, Shapes.block());
    }

}
