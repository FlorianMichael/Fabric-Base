package de.enzaxd.fabricbase.module.setting;

import com.google.gson.JsonObject;
import de.enzaxd.fabricbase.module.Module;

public abstract class AbstractSetting<T> {

    private final Module parent;
    private final String name;
    private final T defaultValue;

    private T value;

    public AbstractSetting(final Module parent, final String name, final T defaultValue) {
        this.parent = parent;
        this.name = name;
        this.defaultValue = defaultValue;

        this.value = this.getDefaultValue();
    }

    public abstract void write(final JsonObject object);
    public abstract void read(final JsonObject object);

    public Module getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
