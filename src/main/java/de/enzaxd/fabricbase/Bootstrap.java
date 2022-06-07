package de.enzaxd.fabricbase;

import de.enzaxd.fabricbase.event.RunGameEvent;
import net.lenni0451.asmevents.EventManager;

public class Bootstrap {

    public static void boot() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> EventManager.call(new RunGameEvent(RunGameEvent.Type.STOP))));
        EventManager.register(FabricBase.instance());
        EventManager.call(new RunGameEvent(RunGameEvent.Type.START));
    }
}
