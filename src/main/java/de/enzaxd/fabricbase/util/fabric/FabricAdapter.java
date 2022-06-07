package de.enzaxd.fabricbase.util.fabric;

import de.enzaxd.fabricbase.FabricBase;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

public class FabricAdapter implements ModInitializer {

    public static ModContainer mod;

    @Override
    public void onInitialize() {
        mod = FabricLoader.getInstance().getModContainer("fabricbase").get();

        FabricBase.CLIENT_VERSION = mod.getMetadata().getVersion().getFriendlyString();
    }
}
