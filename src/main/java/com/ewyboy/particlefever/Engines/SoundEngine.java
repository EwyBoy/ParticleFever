package com.ewyboy.particlefever.Engines;

import com.ewyboy.particlefever.Files.Config;
import com.ewyboy.particlefever.Utillity.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundEngine {

    private static float volume = Config.masterSoundVolume;
    public static final String teleportSound = "mob.endermen.portal";
    public static final String dingSound = "random.orb";

    public static void playSoundAtEntity(String soundPath, World world, Entity entity, float pitchMin, float pitchMax) {
        float pitch = (float)Math.random()*(pitchMax-pitchMin)+pitchMin;
        world.playSoundAtEntity(entity, soundPath, volume, pitch);
        debug(soundPath,pitchMin,pitchMax,pitch);
    }

    public static void playSound(World world, double x, double y, double z, String soundPath, float pitchMin, float pitchMax) {
        float pitch = (float)Math.random()*(pitchMax-pitchMin)+pitchMin;
        world.playSound(x + 0.5, y + 0.5, z + 0.5, soundPath, volume, pitch, true);
        debug(soundPath,pitchMin,pitchMax,pitch);
    }

    public static void debug(String soundPath, float pitchMin, float pitchMax, float pitch) {
        if (Config.debugMode) {
            Logger.info("[" + soundPath + "]" + " Volume: " + volume + " pitchMin: " + pitchMin + " pitchMax: " + pitchMax + " Pitch: " + pitch);
        }
    }
}
