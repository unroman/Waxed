package net.im_maker.waxed.common.particles;

import net.im_maker.waxed.Waxed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.FlameParticle;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Waxed.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WaxedModBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(WaxedModParticles.SMALL_SOUL_FLAME.get(), FlameParticle.SmallFlameProvider::new);
    }
}
