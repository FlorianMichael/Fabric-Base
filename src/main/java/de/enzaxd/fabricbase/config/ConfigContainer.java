package de.enzaxd.fabricbase.config;

import de.enzaxd.fabricbase.config.implementation.ModuleConfig;
import de.enzaxd.fabricbase.config.implementation.SettingsConfig;
import de.enzaxd.fabricbase.util.java.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConfigContainer {

    private final List<AbstractConfig> configs = new ArrayList<>();

    private final CustomWriter customWriter = new CustomWriter(this);

    public void init() {
        this.a(new ModuleConfig());
        this.a(new SettingsConfig());

        this.customWriter.load();
    }

    private void a(final AbstractConfig config) {
        this.configs.add(config);
        Logger.info("Loaded config: " + config.getName());
    }

    public void save() {
        this.customWriter.save();
    }

    public List<AbstractConfig> configs() {
        return configs;
    }
}
