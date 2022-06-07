package de.enzaxd.fabricbase.module.setting.implementation;

import com.google.gson.JsonObject;
import de.enzaxd.fabricbase.module.Module;
import de.enzaxd.fabricbase.module.setting.AbstractSetting;

public class BooleanSetting extends AbstractSetting<Boolean> {

    public BooleanSetting(Module parent, String name, Boolean defaultValue) {
        super(parent, name, defaultValue);
    }

    @Override
    public void write(JsonObject object) {
        object.addProperty("value", this.getValue());
    }

    @Override
    public void read(JsonObject object) {
        this.setValue(object.get("value").getAsBoolean());
    }
}
