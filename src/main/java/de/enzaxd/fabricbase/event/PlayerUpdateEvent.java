package de.enzaxd.fabricbase.event;

import net.lenni0451.asmevents.event.IEvent;

public record PlayerUpdateEvent(Type type) implements IEvent {

    public enum Type {
        PRE, POST
    }
}
