package com.epam.jdi.light.settings;

public class JDISettings {
    private JDISettings() {
        LOGS = new LogSettings();
        TIMEOUTS = new Timeouts();
        ELEMENT = new ElementSettings();
        PAGE = new PageSettings();
        SCREEN = new ScreenSettings();
        DRIVER = new DriverSettings();
    }

    private static JDISettings jdiSettings;

    public static JDISettings getJDISettings() {
        if (jdiSettings == null) {
            jdiSettings = new JDISettings();
        }
        return jdiSettings;
    }

    public LogSettings LOGS;
    public Timeouts TIMEOUTS;
    public DriverSettings DRIVER;
    public ElementSettings ELEMENT;
    public PageSettings PAGE;
    public ScreenSettings SCREEN;
}
