package gui;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Paths;

public class WindowConfig {
    private static final String CONFIG_FILE = "app_window_config.dat";
    private Map<String, WindowState> windowStates = new HashMap<>();

    public void saveWindowState(String windowId, Rectangle bounds, int extendedState) {
        WindowState state = new WindowState(bounds, extendedState, false);
        windowStates.put(windowId, state);
        saveToFile();
    }

    public void saveWindowState(String windowId, Rectangle bounds, boolean minimized) {
        WindowState state = new WindowState(bounds, 0, minimized);
        windowStates.put(windowId, state);
        saveToFile();
    }


    public WindowState getWindowState(String windowId) {
        return windowStates.get(windowId);
    }

    private void saveToFile() {
        try {
            String userHome = System.getProperty("user.home");
            File configFile = Paths.get(userHome, CONFIG_FILE).toFile();

            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(configFile)))) {
                oos.writeObject(windowStates);
            }
        } catch (Exception e) {
            System.err.println("Ошибка сохранения конфигурации окон: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try {
            String userHome = System.getProperty("user.home");
            File configFile = Paths.get(userHome, CONFIG_FILE).toFile();

            if (configFile.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(
                        new BufferedInputStream(new FileInputStream(configFile)))) {
                    windowStates = (Map<String, WindowState>) ois.readObject();
                }
            } else {
                windowStates = new HashMap<>();
            }
        } catch (Exception e) {
            System.err.println("Ошибка загрузки конфигурации окон: " + e.getMessage());
            windowStates = new HashMap<>();
        }
    }
}
