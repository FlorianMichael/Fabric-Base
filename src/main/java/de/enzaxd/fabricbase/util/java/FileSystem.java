package de.enzaxd.fabricbase.util.java;

import de.enzaxd.fabricbase.FabricBase;
import de.enzaxd.fabricbase.util.MinecraftWrapper;

import java.io.File;

public class FileSystem {

    private final static FileSystem instance = new FileSystem();

    public final File main = new File(MinecraftWrapper.game().runDirectory, "." + FabricBase.CLIENT_NAME);

    public final File config = new File(main, "config");

    public void init() {
        if (!this.getMain().exists())
            Logger.info("Created Main Folder: " + this.getMain().mkdir());

        if (!this.getConfig().exists())
            Logger.info("Created Config Folder: " + this.getConfig().mkdir());
    }

    public File getMain() {
        return main;
    }

    public File getConfig() {
        return config;
    }

    public static FileSystem instance() {
        return instance;
    }
}
