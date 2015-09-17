package com.ewyboy.particlefever.Blocks;

import com.ewyboy.particlefever.Files.Config;
import com.ewyboy.particlefever.Loaders.CreativeTabLoader;
import com.ewyboy.particlefever.Utillity.Logger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class BaseBlock extends Block {

    public BaseBlock() {
        this(Material.rock);
    }

    public BaseBlock(Material material) {
        super(material);
        setCreativeTab(CreativeTabLoader.ParticleFeverTab);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        this.dropInventory(world, x, y, z);
        super.breakBlock(world, x, y, z, block, meta);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
        if (Config.debugMode) {
            if (world.getTileEntity(x,y,z) instanceof TileEntity || world.getBlock(x,y,z) instanceof Block) {
                int direction;
                int facing = MathHelper.floor_double((double) (entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
                if(facing == 0) {
                    direction = ForgeDirection.NORTH.ordinal();
                    Logger.info(ForgeDirection.NORTH.name());
                } else if (facing == 1) {
                    direction = ForgeDirection.EAST.ordinal();
                    Logger.info(ForgeDirection.EAST.name());
                } else if (facing == 2) {
                    direction = ForgeDirection.SOUTH.ordinal();
                    Logger.info(ForgeDirection.SOUTH.name());
                } else if (facing == 3) {
                    direction = ForgeDirection.WEST.ordinal();
                    Logger.info(ForgeDirection.WEST.name());
                }
            }
        }
    }

    protected void dropInventory(World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x,y,z);
        if(tileEntity instanceof IInventory) {
            IInventory inventory = (IInventory) tileEntity;
            for(int i = 0; i < inventory.getSizeInventory();i++) {
                ItemStack itemStack = inventory.getStackInSlot(i);
                if (itemStack != null && itemStack.stackSize > 0) {
                    Random random = new Random();
                    float dX = random.nextFloat() * 0.8F + 0.1F;
                    float dY = random.nextFloat() * 0.8F + 0.1F;
                    float dZ = random.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityItem = new EntityItem(world, (double)((float)x + dX), (double)((float)y + dY), (double)((float)z + dZ), itemStack.copy());
                    if (itemStack.hasTagCompound()) {
                        entityItem.getEntityItem().setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
                    }
                    float factor = 0.05F;
                    entityItem.motionX = random.nextGaussian() * (double)factor;
                    entityItem.motionX = random.nextGaussian() * (double)factor + 0.20000000298023224D;
                    entityItem.motionX = random.nextGaussian() * (double)factor;
                    world.spawnEntityInWorld(entityItem);
                    itemStack.stackSize = 0;
                }

            }
        }
    }
}
