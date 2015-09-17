package com.ewyboy.particlefever.Engines;

import com.ewyboy.particlefever.Files.Config;
import com.ewyboy.particlefever.Utillity.SettingChecker;
import net.minecraft.world.World;

public class ParticleEngine {

    public static String effectPortal = "portal";
    public static String effectEnder = "magicCrit";

    public static void spawnParticle(World world, double x, double y, double z, String particleName, double vX, double vY, double vZ) {
        world.spawnParticle(particleName, x+0.5,y+0.5,z+0.5, vX, vY, vZ);
    }

    public static void spawnHelixEffect(World world, int x, int y, int z, String particleName, double duration) {
        if (SettingChecker.getParticleSettings() == 0) {
            for(double i = 0; i <= Math.PI; i += duration / Config.masterParticlePercentage) {
                double adjustedX = i * Math.cos(i) / 2, adjustedZ = i * Math.sin(i) / 2;
                helixPattern(world,particleName,x,y,z,i,adjustedX,adjustedZ);
            }
        } else if (SettingChecker.getParticleSettings() == 1) {
            for(double i = 0; i <= Math.PI; i += duration / (Config.masterParticlePercentage / 2)) {
                double adjustedX = i * Math.cos(i) / 2, adjustedZ = i * Math.sin(i) / 2;
                helixPattern(world, particleName, x, y, z, i, adjustedX, adjustedZ);
            }
        }
    }

    private static void helixPattern(World world, String particleName, double x, double y, double z, double i, double adjustedX, double adjustedZ) {
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedX,      i, adjustedZ);
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedX*(-1), i, adjustedZ*(-1));
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedX*(-1), i, adjustedZ);
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedX,      i, adjustedZ*(-1));
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedZ,      i, adjustedX);
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedZ*(-1), i, adjustedX*(-1));
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedZ*(-1), i, adjustedX);
        world.spawnParticle(particleName,x+0.5,y,z+0.5, adjustedZ,      i, adjustedX*(-1));
    }
}
