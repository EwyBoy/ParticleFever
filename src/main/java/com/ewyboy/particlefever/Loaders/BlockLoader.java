package com.ewyboy.particlefever.Loaders;

import com.ewyboy.particlefever.Blocks.BlockEmitter;
import com.ewyboy.particlefever.Utillity.Logger;
import com.ewyboy.particlefever.Utillity.StringMap;
import com.google.common.base.Stopwatch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

import java.util.concurrent.TimeUnit;

@GameRegistry.ObjectHolder(StringMap.ID)
public class BlockLoader {

    public static Block Emitter;
    public static void log(Block block) {Logger.info(block + " successfully loaded");}

    public static void loadBlocks() {
        Stopwatch watch = Stopwatch.createStarted();
            Logger.info("Loading blocks started");
                Emitter = new BlockEmitter().setBlockName(StringMap.Emitter);
                    GameRegistry.registerBlock(Emitter,StringMap.Emitter);
                        log(Emitter);
            Logger.info("Loading blocks finished after " + watch.elapsed(TimeUnit.MILLISECONDS) + "ms )");
    }
}
