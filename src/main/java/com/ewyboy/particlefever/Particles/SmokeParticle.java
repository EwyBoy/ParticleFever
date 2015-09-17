package com.ewyboy.particlefever.Particles;

import net.minecraft.world.World;

public class SmokeParticle extends BaseParticle {

    public SmokeParticle(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        setTexture("SmokeParticle");
        setGravity(-0.5f);
        setScale(5f);
        setMaxAge(75);
        setVelocityX(300.0f);
    }
}
