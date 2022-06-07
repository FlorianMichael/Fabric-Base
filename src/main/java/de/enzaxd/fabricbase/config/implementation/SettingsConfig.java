package de.enzaxd.fabricbase.config.implementation;

import com.google.gson.JsonObject;
import de.enzaxd.fabricbase.FabricBase;
import de.enzaxd.fabricbase.config.AbstractConfig;
import de.enzaxd.fabricbase.module.Module;
import de.enzaxd.fabricbase.module.setting.AbstractSetting;

public class SettingsConfig extends AbstractConfig {

    public SettingsConfig() {
        super("settings.json");
    }

    @Override
    public void loadAndSetDefaults(JsonObject main) {
        for (Module module : FabricBase.instance().moduleContainer().modules()) {
            try {
                final JsonObject value = main.get(module.getName()).getAsJsonObject();

                for (AbstractSetting<?> abstractSetting : FabricBase.instance().moduleContainer().settingContainer().byParent(module.getName(), false)) {
                    final JsonObject internValue = value.get(abstractSetting.getName()).getAsJsonObject();

                    abstractSetting.read(internValue);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(JsonObject main) {
        for (Module module : FabricBase.instance().moduleContainer().modules()) {
            final JsonObject value = new JsonObject();

            for (AbstractSetting<?> abstractSetting : FabricBase.instance().moduleContainer().settingContainer().byParent(module.getName(), false)) {
                final JsonObject internValue = new JsonObject();

                abstractSetting.write(internValue);

                value.add(abstractSetting.getName(), internValue);
            }

            main.add(module.getName(), value);
        }
    }
}
