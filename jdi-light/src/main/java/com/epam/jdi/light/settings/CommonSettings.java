package com.epam.jdi.light.settings;

import static com.epam.jdi.light.settings.Strategies.JDI;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PathUtils.path;

public class CommonSettings {
    private static CommonSettings commonSettings;

    public Strategies strategy;
    public String testPropertiesPath;
    public String logsPath;
    public String killBrowser;
    public String applicationName;
    public String projectPath;
    public String testPath;

    private CommonSettings() {
        strategy = JDI;
        testPropertiesPath = "test.properties";
        logsPath = mergePath("target", ".logs");
        killBrowser = "afterAndBefore";
        projectPath = path("");
        testPath = mergePath(projectPath, "src", "test");
    }

    public static CommonSettings getCommonSettings() {
        if (commonSettings == null) {
            commonSettings = new CommonSettings();
        }
        return commonSettings;
    }
}
