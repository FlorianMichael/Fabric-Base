package de.enzaxd.fabricbase.module;

import net.lenni0451.asmevents.EventManager;

public class Module {

    private final String name;

    private boolean toggled;
    private boolean usingEvents;

    public Module(final String name) {
        this.name = name;
    }

    public void setUsingEvents(boolean usingEvents) {
        this.usingEvents = usingEvents;
    }

    protected void onEnable() {
        if (this.usingEvents)
            EventManager.register(this);
    }

    protected void onDisable() {
        if (this.usingEvents)
            EventManager.unregister(this);
    }

    public String getName() {
        return name;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void toggle() {
        this.toggled = !this.isToggled();

        if (this.isToggled())
            this.onEnable();
        else
            this.onDisable();
    }
}
