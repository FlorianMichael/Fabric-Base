package de.enzaxd.fabricbase.event;

import net.lenni0451.asmevents.event.IEvent;

public record RunGameEvent(de.enzaxd.fabricbase.event.RunGameEvent.Type type) implements IEvent {

    public enum Type {
        START, STOP
    }
}
