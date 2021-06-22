package com.jdiai.jswraper.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.function.Consumer;
import java.util.logging.Level;

public class DriverOptions {
    public Consumer<MutableCapabilities> common = cap -> {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability("goog:loggingPrefs", logPrefs);
    };

    public Consumer<ChromeOptions> chrome = co -> { };

    public Consumer<FirefoxOptions> firefox = fo -> { };

    public Consumer<InternetExplorerOptions> ie = io -> { };

    public Consumer<EdgeOptions> ieEdge = eo -> { };

    public Consumer<OperaOptions> opera = oo -> { };

    public Consumer<SafariOptions> safari = so -> { };
}
