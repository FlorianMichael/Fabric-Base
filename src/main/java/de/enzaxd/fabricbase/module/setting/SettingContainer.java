package de.enzaxd.fabricbase.module.setting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SettingContainer {

    private final List<AbstractSetting<?>> settings = new ArrayList<>();

    public List<AbstractSetting<?>> byParent(final String name, final boolean ignoreCase) {
        return this.settings().stream().filter(o -> (ignoreCase && o.getParent().getName().equalsIgnoreCase(name) || o.getParent().getName().equals(name))).collect(Collectors.toList());
    }

    public List<AbstractSetting<?>> settings() {
        return settings;
    }
}
