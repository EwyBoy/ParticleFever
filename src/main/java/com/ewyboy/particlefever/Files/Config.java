package com.ewyboy.particlefever.Files;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static boolean debugMode;
    public static int masterParticlePercentage;
    public static float masterSoundVolume;

    public static void init(File file) {
        Configuration config = new Configuration(file);

        config.load();
            debugMode = config.getBoolean("Debug Mode", "Particle Fever Configs", false, "Set true to turn on developer debug mode for debugging info in console");
            masterParticlePercentage = config.getInt("Master Particle Reducer", "Blink Configs", 100, 1, 100, "Sets the amount of particles spawned [Default: 100 = 100% particles spawn]");
            masterSoundVolume = config.getFloat("Master Sound Volume", "Blink Configs", 0.75f, 0.0f, 1.0f, "Controls the master sound volume for all blink sound effects [Use a decimal between 0-1 [1 = 100% | 0 = 0%]]");
        config.save();
    }
}
