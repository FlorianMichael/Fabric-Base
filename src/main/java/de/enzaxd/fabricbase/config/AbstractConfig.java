package de.enzaxd.fabricbase.config;

import com.google.gson.JsonObject;
import de.enzaxd.fabricbase.util.java.FileSystem;

import java.io.File;

public abstract class AbstractConfig {

    private final String name;
    private final File file;

    public AbstractConfig(final String name) {
        this.name = name;

        this.file = new File(FileSystem.instance().getConfig(), this.getName());
    }

    public abstract void loadAndSetDefaults(final JsonObject main);
    public abstract void save(final JsonObject main);

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }
}
