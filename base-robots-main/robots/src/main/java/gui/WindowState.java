package gui;

import java.awt.*;

public class WindowState implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Rectangle size;
    private int extendedState;
    private boolean minimized;

    public WindowState(Rectangle size, int extendedState, boolean minimized) {
        this.size = size;
        this.extendedState = extendedState;
        this.minimized = minimized;
    }

    public Rectangle getSize() {
        return size;
    }
    public int getExtendedState() { return extendedState; }
    public boolean isMinimized() { return minimized; }
}
