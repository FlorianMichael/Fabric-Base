package de.enzaxd.fabricbase.module;

import de.enzaxd.fabricbase.module.implementation.FastPlaceModule;
import de.enzaxd.fabricbase.module.setting.SettingContainer;
import de.enzaxd.fabricbase.util.java.Logger;

import java.util.ArrayList;
import java.util.List;

public class ModuleContainer {

    private final SettingContainer settingContainer = new SettingContainer();
    private final List<Module> modules = new ArrayList<>();

    public void init() {
        this.a(new FastPlaceModule());
    }

    private void a(final Module module) {
        this.modules.add(module);
        Logger.info("Loaded module: " + module.getName());
    }

    public List<Module> modules() {
        return modules;
    }

    public SettingContainer settingContainer() {
        return settingContainer;
    }
}
