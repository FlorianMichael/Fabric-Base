package de.enzaxd.fabricbase.event;

import net.lenni0451.asmevents.event.IEvent;

public class WindowTitleEvent implements IEvent {

    private String windowTitle;

    public WindowTitleEvent(final String windowTitle) {
        this.setWindowTitle(windowTitle);
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
    }
}
