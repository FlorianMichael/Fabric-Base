package de.enzaxd.fabricbase;

import de.enzaxd.fabricbase.config.ConfigContainer;
import de.enzaxd.fabricbase.event.RunGameEvent;
import de.enzaxd.fabricbase.event.WindowTitleEvent;
import de.enzaxd.fabricbase.module.ModuleContainer;
import de.enzaxd.fabricbase.util.java.FileSystem;
import de.enzaxd.fabricbase.util.java.Logger;
import net.lenni0451.asmevents.event.EventTarget;
import net.minecraft.SharedConstants;

public class FabricBase {

    public final static String CLIENT_NAME = "Fabric Base";
    public static String CLIENT_VERSION = null;

    private final static FabricBase instance = new FabricBase();

    private final ModuleContainer moduleContainer = new ModuleContainer();
    private final ConfigContainer configContainer = new ConfigContainer();

    @EventTarget
    public void onStart(final RunGameEvent e) {
        switch (e.type()) {
            case START -> {
                long startTime = System.currentTimeMillis();

                FileSystem.instance().init();

                this.moduleContainer().init();
                this.configContainer().init();

                Logger.info("Loaded in " + ((System.currentTimeMillis() - startTime) / 1000) + "s");
            }
            case STOP -> {
                this.configContainer().save();

                Logger.info("Thank you and good bye!");
            }
        }
    }

    @EventTarget
    public void onWindowTitle(final WindowTitleEvent e) {
        e.setWindowTitle(CLIENT_NAME + " " + CLIENT_VERSION + " | Minecraft " + SharedConstants.getGameVersion().getName());
    }

    public static FabricBase instance() {
        return instance;
    }

    public ModuleContainer moduleContainer() {
        return moduleContainer;
    }

    public ConfigContainer configContainer() {
        return configContainer;
    }
}
