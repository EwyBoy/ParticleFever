package com.ewyboy.particlefever.Particles;

import com.ewyboy.particlefever.Utillity.StringMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import static org.lwjgl.opengl.GL11.*;

public class BaseParticle extends EntityFX {

    public BaseParticle(
        World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        setVelocityX(velocityX);
        setVelocityY(velocityY);
        setVelocityZ(velocityZ);
    }

    public BaseParticle setAge(int age) {
        particleAge = age;
        return this;
    }
    public BaseParticle setMaxAge(int maxAge) {
        particleMaxAge = maxAge;
        return this;
    }
    public BaseParticle setGravity(float gravity) {
        particleGravity = gravity;
        return this;
    }
    public BaseParticle setScale(float scale) {
        particleScale = scale;
        return this;
    }
    public BaseParticle setVelocityX(double velocityX) {
        interpPosX = velocityX;
        return this;
    }
    public BaseParticle setVelocityY(double velocityY) {
        interpPosY = velocityY;
        return this;
    }
    public BaseParticle setVelocityZ(double velocityZ) {
        interpPosZ = velocityZ;
        return this;
    }
    public BaseParticle setRed(float red) {
        particleRed = red;
        return this;
    }
    public BaseParticle setGreen(float green) {
        particleGreen = green;
        return this;
    }
    public BaseParticle setBlue(float blue) {
        particleBlue = blue;
        return this;
    }
    public BaseParticle setAlpha(float alpha) {
        particleAlpha = alpha;
        return this;
    }

    public static String texture;
    public static String setTexture(String textureName) {
        texture = textureName;
        return textureName;
    }

    public static final ResourceLocation resourceLocation = new ResourceLocation(StringMap.ID + ":" + "textures/particles/" + setTexture(texture) + ".png");

    @Override
    public void renderParticle(Tessellator tessellator, float partialTick, float velX, float velY, float velZ, float f1, float f2) {
        Minecraft.getMinecraft().renderEngine.bindTexture(resourceLocation);

        glDepthMask(false);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glAlphaFunc(GL_GREATER, 0.003921569f);

        tessellator.startDrawingQuads();
            tessellator.setBrightness(getBrightnessForRender(partialTick));

            float scale = 0.1f * particleScale;

            float x = (float)(prevPosX + (posX - prevPosX) * partialTick - interpPosX);
            float y = (float)(prevPosY + (posY - prevPosY) * partialTick - interpPosY);
            float z = (float)(prevPosZ + (posZ - prevPosZ) * partialTick - interpPosZ);

            tessellator.addVertexWithUV(x - velX * scale - f1 * scale, y - velY * scale, z - velZ * scale - f2 * scale,0,0);
            tessellator.addVertexWithUV(x - velX * scale + f1 * scale, y + velY * scale, z - velZ * scale + f2 * scale,1,0);
            tessellator.addVertexWithUV(x + velX * scale + f1 * scale, y + velY * scale, z + velZ * scale + f2 * scale,1,1);
            tessellator.addVertexWithUV(x + velX * scale - f1 * scale, y - velY * scale, z + velZ * scale - f2 * scale,0,1);
        tessellator.draw();

        glDisable(GL_BLEND);
        glDepthMask(true);
        glAlphaFunc(GL_GREATER, 0.1f);
    }

    @Override
    public int getFXLayer() {
        return 3;
    }
}
