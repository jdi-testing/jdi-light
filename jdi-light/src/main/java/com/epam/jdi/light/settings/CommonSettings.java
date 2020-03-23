package com.epam.jdi.light.settings;

import static com.epam.jdi.light.settings.Strategies.*;
import static com.epam.jdi.tools.PathUtils.*;

public class CommonSettings {
    public Strategies strategy = JDI;
    public String testPropertiesPath = "test.properties";
    public String logsPath = mergePath("target", ".logs");
    public String killBrowser = "afterAndBefore";
    public String applicationName;
}
