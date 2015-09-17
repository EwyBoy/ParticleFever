package com.ewyboy.particlefever.Blocks;

import com.ewyboy.particlefever.Particles.SmokeParticle;
import com.ewyboy.particlefever.Utillity.StringMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockEmitter extends BaseBlock {

    public BlockEmitter() {
        super(Material.anvil);
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        for (int i=0; i < 100; i++) {
            Minecraft.getMinecraft().effectRenderer.addEffect(new SmokeParticle(world,x+0.5,y+1,z+0.5, 0.0, 0.0, 0.0));
        }
    }

    @SideOnly(Side.CLIENT)
    private IIcon TextureDefault;
    private IIcon TextureEmitter;

    @Override
    public void registerBlockIcons(IIconRegister register) {
        TextureDefault = register.registerIcon(StringMap.ID + ":" + "Emitter0");
        TextureEmitter = register.registerIcon(StringMap.ID + ":" + "Emitter1");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0 || side == 1) {
            return TextureEmitter;
        } else {
            return TextureDefault;
        }
    }
}