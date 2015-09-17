package com.ewyboy.particlefever.Loaders;

import com.ewyboy.particlefever.Utillity.StringMap;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@GameRegistry.ObjectHolder(StringMap.ID)
public class CreativeTabLoader {
    public static CreativeTabs ParticleFeverTab = new CreativeTabs (StringMap.CreativeTabPartilceFever) {
        public ItemStack getIconItemStack() {return new ItemStack(BlockLoader.Emitter);}
        @Override
        public Item getTabIconItem() {return null;}
    };
}
