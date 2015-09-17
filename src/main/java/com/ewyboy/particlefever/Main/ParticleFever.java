package com.ewyboy.particlefever.Main;

import com.ewyboy.particlefever.Files.Config;
import com.ewyboy.particlefever.Loaders.BlockLoader;
import com.ewyboy.particlefever.Networking.CommonProxy;
import com.ewyboy.particlefever.Utillity.Logger;
import com.ewyboy.particlefever.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.util.concurrent.TimeUnit;

@Mod(modid = StringMap.ID, name = StringMap.Name, version = StringMap.VersionBuildName, acceptedMinecraftVersions = "["+StringMap.MinecraftVersion+"]")
public class ParticleFever {
    @Mod.Instance(StringMap.ID)
    public static ParticleFever instance;

    @SidedProxy(modId = StringMap.ID, clientSide = StringMap.clientProxyPath, serverSide = StringMap.commonProxyPath)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("PreInitialization started");
                Config.init(event.getSuggestedConfigurationFile());
                //ItemLoader.loadItems();
                BlockLoader.loadBlocks();
                //TileEntityLoader.loadTileEntities();
                //ClientProxy.init();
                //CommonProxy.init();
            Logger.info("PreInitialization finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
            Logger.info("PreInitialization process successfully done");
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event) {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Initialization started");
            Logger.info("Initialization finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
            Logger.info("Initialization process successfully done");
    }

    @Mod.EventHandler
    public void postInit (FMLPreInitializationEvent event){
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("PostInitialization started");
            //RecipeLoader.loadRecipes();
            Logger.info("PostInitialization finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
            Logger.info("PostInitialization process successfully done");
    }
}
