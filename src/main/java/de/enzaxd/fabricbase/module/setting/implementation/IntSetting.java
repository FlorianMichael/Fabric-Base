package de.enzaxd.fabricbase.module.setting.implementation;

import com.google.gson.JsonObject;
import de.enzaxd.fabricbase.module.Module;
import de.enzaxd.fabricbase.module.setting.AbstractSetting;

public class IntSetting extends AbstractSetting<Integer> {

    private final Integer min;
    private final Integer max;

    public IntSetting(Module parent, String name, Integer defaultValue, final Integer min, final Integer max) {
        super(parent, name, defaultValue);

        this.min = min;
        this.max = max;
    }

    @Override
    public void write(JsonObject object) {
        object.addProperty("value", this.getValue());
    }

    @Override
    public void read(JsonObject object) {
        this.setValue(object.get("value").getAsInt());
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }
}
