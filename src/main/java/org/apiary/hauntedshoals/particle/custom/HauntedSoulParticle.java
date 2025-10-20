package org.apiary.hauntedshoals.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;

@Environment(EnvType.CLIENT)
public class HauntedSoulParticle extends AbstractSlowingParticle {
    private final SpriteProvider spriteProvider;

    public HauntedSoulParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.spriteProvider = spriteProvider;
        this.scale(1.5f);
        this.setSpriteForAge(spriteProvider);
    }

    @Override
    public int getBrightness(float tint) {
        return super.getBrightness(tint);
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteForAge(this.spriteProvider);
    }
}