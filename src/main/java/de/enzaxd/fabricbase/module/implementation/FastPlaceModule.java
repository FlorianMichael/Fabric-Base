package de.enzaxd.fabricbase.module.implementation;

import de.enzaxd.fabricbase.event.PlayerUpdateEvent;
import de.enzaxd.fabricbase.module.Module;
import de.enzaxd.fabricbase.module.setting.implementation.IntSetting;
import de.enzaxd.fabricbase.util.MinecraftWrapper;
import net.lenni0451.asmevents.event.EventTarget;

public class FastPlaceModule extends Module {

    private final IntSetting delay = new IntSetting(this, "Delay", 0, 0, 10);

    public FastPlaceModule() {
        super("Fast Place");

        this.setUsingEvents(true);
    }

    @EventTarget
    public void onPlayerUpdate(final PlayerUpdateEvent e) {
        if (e.type() != PlayerUpdateEvent.Type.POST) return;

        MinecraftWrapper.game().itemUseCooldown = this.delay.getValue();
    }
}
