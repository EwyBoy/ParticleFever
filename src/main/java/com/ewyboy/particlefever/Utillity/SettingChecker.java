package com.ewyboy.particlefever.Utillity;

import net.minecraft.client.Minecraft;

/** FUN FACT: This class was developed in my head while looking for food in my refrigerator */
public class SettingChecker {

    /** PEACEFUL(0),EASY(1),NORMAL(2),HARD(3) */
    public static int getDifficultity() {
        int difficultySettings = Minecraft.getMinecraft().gameSettings.difficulty.getDifficultyId();

        if (difficultySettings == 0) {
            return 0;
        } else if (difficultySettings == 1) {
            return 1;
        } else if (difficultySettings == 2) {
            return 2;
        } else if (difficultySettings == 3) {
            return 3;
        } else {
            return difficultySettings;
        }
    }

    /** Determines amount of particles. 0 = All, 1 = Decreased, 2 = Minimal */
    public static int getParticleSettings() {
        int particleSetting = Minecraft.getMinecraft().gameSettings.particleSetting;

        if (particleSetting == 0) {
            return 0;
        } else if (particleSetting == 1) {
            return 1;
        } else if (particleSetting == 2) {
            return 2;
        } else {
            return particleSetting;
        }
    }
}
