package net.im_maker.waxed.common.block.custom;

import com.google.common.base.Suppliers;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import net.mehvahdjukaar.moonlight.api.block.IColored;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.mehvahdjukaar.moonlight.api.util.math.MthUtils;
import net.mehvahdjukaar.supplementaries.common.block.blocks.CandleHolderBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;

public class SoulCandleHolderBlock extends CandleHolderBlock {
    public static final DirectionProperty FACING;
    public static final EnumProperty<AttachFace> FACE;
    public static final IntegerProperty CANDLES;
    private final @Nullable DyeColor color;
    private static final EnumMap<Direction, EnumMap<AttachFace, Int2ObjectMap<List<Vec3>>>> PARTICLE_OFFSETS;
    private static final List<Vec3> S2_FLOOR_1;
    private static final List<Vec3> S2_FLOOR_3;
    private static final List<Vec3> S2_FLOOR_3f;
    private final Supplier<ParticleType<? extends ParticleOptions>> particle;
    public SoulCandleHolderBlock(DyeColor color, BlockBehaviour.Properties properties, Supplier<ParticleType<? extends ParticleOptions>> particle) {
        super(color, properties.lightLevel(SoulCandleHolderBlock::lightLevel));
        this.color = color;
        this.particle = particle;
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(WATERLOGGED, false)).setValue(LIT, false)).setValue(FACE, AttachFace.FLOOR)).setValue(FACING, Direction.NORTH)).setValue(CANDLES, 1));
    }

    private static int lightLevel(BlockState state) {
        if ((Boolean)state.getValue(LIT)) {
            int candles = (Integer)state.getValue(CANDLES);
            return 3 + candles * 2;
        } else {
            return 0;
        }
    }

    private void addParticlesAndSound(Level level, Vec3 offset, RandomSource random) {
        float f = random.nextFloat();
        if (f < 0.3F) {
            level.addParticle(ParticleTypes.SMOKE, offset.x, offset.y, offset.z, 0.0, 0.0, 0.0);
            if (f < 0.17F) {
                level.playLocalSound(offset.x + 0.5, offset.y + 0.5, offset.z + 0.5, SoundEvents.CANDLE_AMBIENT, SoundSource.BLOCKS, 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
            }
        }

        level.addParticle((ParticleOptions)this.particle.get(), offset.x, offset.y, offset.z, 0.0, 0.0, 0.0);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
        if ((Boolean)state.getValue(LIT)) {
            this.getParticleOffset(state).forEach((v) -> {
                this.addParticlesAndSound(level, v.add((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()), rand);
            });
        }

    }

    private List<Vec3> getParticleOffset(BlockState state) {
        Direction direction = (Direction)state.getValue(FACING);
        AttachFace face = (AttachFace)state.getValue(FACE);
        int candles = (Integer)state.getValue(CANDLES);
        List<Vec3> v = (List)((Int2ObjectMap)((EnumMap)PARTICLE_OFFSETS.get(direction)).get(face)).get(candles);
        if (face == AttachFace.FLOOR) {
            if (candles == 1) {
                return S2_FLOOR_1;
            }

            if (candles == 3) {
                return direction.getAxis() == Direction.Axis.Z ? S2_FLOOR_3 : S2_FLOOR_3f;
            }
        }

        return v;
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        FACE = BlockStateProperties.ATTACH_FACE;
        CANDLES = BlockStateProperties.CANDLES;
        S2_FLOOR_1 = List.of(new Vec3(0.5, 0.875, 0.5));
        S2_FLOOR_3 = List.of(new Vec3(0.1875, 0.875, 0.5), new Vec3(0.5, 0.9375, 0.5), new Vec3(0.8125, 0.875, 0.5));
        S2_FLOOR_3f = List.of(new Vec3(0.5, 0.875, 0.1875), new Vec3(0.5, 0.9375, 0.5), new Vec3(0.5, 0.875, 0.8125));
        PARTICLE_OFFSETS = new EnumMap(Direction.class);
        EnumMap<AttachFace, Int2ObjectMap<List<Vec3>>> temp = new EnumMap(AttachFace.class);
        Int2ObjectMap<List<Vec3>> int2ObjectMap = new Int2ObjectArrayMap();
        int2ObjectMap.put(1, List.of(new Vec3(0.5, 0.6875, 0.5)));
        int2ObjectMap.put(2, List.of(new Vec3(0.3125, 0.875, 0.5), new Vec3(0.6875, 0.875, 0.5)));
        int2ObjectMap.put(3, List.of(new Vec3(0.1875, 0.9375, 0.5), new Vec3(0.5, 0.9375, 0.5), new Vec3(0.8125, 0.9375, 0.5)));
        int2ObjectMap.put(4, List.of(new Vec3(0.1875, 1.0, 0.5), new Vec3(0.8125, 1.0, 0.5), new Vec3(0.5, 0.9375, 0.25), new Vec3(0.5, 0.9375, 0.75)));
        temp.put(AttachFace.FLOOR, Int2ObjectMaps.unmodifiable(int2ObjectMap));
        int2ObjectMap = new Int2ObjectArrayMap();
        int2ObjectMap.put(1, List.of(new Vec3(0.5, 0.9375, 0.1875)));
        int2ObjectMap.put(2, List.of(new Vec3(0.3125, 0.9375, 0.1875), new Vec3(0.6875, 0.9375, 0.1875)));
        int2ObjectMap.put(3, List.of(new Vec3(0.8125, 0.9375, 0.1875), new Vec3(0.1875, 0.9375, 0.1875), new Vec3(0.5, 0.9375, 0.25)));
        int2ObjectMap.put(4, List.of(new Vec3(0.1875, 1.0, 0.1875), new Vec3(0.8125, 1.0, 0.1875), new Vec3(0.3125, 0.875, 0.3125), new Vec3(0.6875, 0.875, 0.3125)));
        temp.put(AttachFace.WALL, Int2ObjectMaps.unmodifiable(int2ObjectMap));
        int2ObjectMap = new Int2ObjectArrayMap();
        int2ObjectMap.put(1, List.of(new Vec3(0.5, 0.5625, 0.5)));
        int2ObjectMap.put(2, List.of(new Vec3(0.25, 0.875, 0.5), new Vec3(0.75, 0.875, 0.5)));
        int2ObjectMap.put(3, List.of(new Vec3(0.5, 0.875, 0.75), new Vec3(0.75, 0.875, 0.375), new Vec3(0.25, 0.875, 0.375)));
        int2ObjectMap.put(4, List.of(new Vec3(0.1875, 0.8125, 0.1875), new Vec3(0.8125, 0.8125, 0.1875), new Vec3(0.8125, 0.8125, 0.8125), new Vec3(0.1875, 0.8125, 0.8125)));
        temp.put(AttachFace.CEILING, Int2ObjectMaps.unmodifiable(int2ObjectMap));
        Direction[] var15 = Direction.values();
        int var2 = var15.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Direction direction = var15[var3];
            EnumMap<AttachFace, Int2ObjectMap<List<Vec3>>> newFaceMap = new EnumMap(AttachFace.class);
            Iterator var6 = temp.entrySet().iterator();

            while(var6.hasNext()) {
                Map.Entry<AttachFace, Int2ObjectMap<List<Vec3>>> faceList = (Map.Entry)var6.next();
                Int2ObjectMap<List<Vec3>> newCandleList = new Int2ObjectArrayMap();
                newCandleList.defaultReturnValue(List.of());
                int c = 1;
                Int2ObjectMap<List<Vec3>> oldVec = (Int2ObjectMap)faceList.getValue();

                for(int i = 1; i < 5; ++i) {
                    ArrayList<Vec3> vectorsList = new ArrayList();
                    Iterator var13 = ((List)oldVec.get(i)).iterator();

                    while(var13.hasNext()) {
                        Vec3 vec = (Vec3)var13.next();
                        vectorsList.add(MthUtils.rotateVec3(vec.subtract(0.5, 0.5, 0.5), direction.getOpposite()).add(0.5, 0.5, 0.5));
                    }

                    newCandleList.put(c++, ImmutableList.copyOf(vectorsList));
                }

                newFaceMap.put((AttachFace)faceList.getKey(), Int2ObjectMaps.unmodifiable(newCandleList));
            }

            PARTICLE_OFFSETS.put(direction, newFaceMap);
        }
    }
}