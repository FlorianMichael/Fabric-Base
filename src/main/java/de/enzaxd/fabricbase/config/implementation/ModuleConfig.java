package de.enzaxd.fabricbase.config.implementation;

import com.google.gson.JsonObject;
import de.enzaxd.fabricbase.FabricBase;
import de.enzaxd.fabricbase.config.AbstractConfig;
import de.enzaxd.fabricbase.module.Module;

public class ModuleConfig extends AbstractConfig {

    public ModuleConfig() {
        super("module.json");
    }

    @Override
    public void loadAndSetDefaults(JsonObject main) {
        try {
            for (Module module : FabricBase.instance().moduleContainer().modules())
                if (main.get(module.getName()).getAsBoolean())
                    module.toggle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(JsonObject main) {
        for (Module module : FabricBase.instance().moduleContainer().modules()) {
            main.addProperty(module.getName(), module.isToggled());
        }
    }
}
