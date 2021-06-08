package com.jdiai.jswraper.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.function.Consumer;

public class DriverOptions {
    public Consumer<MutableCapabilities> common = cap -> { };

    public Consumer<ChromeOptions> chrome = co -> { };

    public Consumer<FirefoxOptions> firefox = co -> { };

    public Consumer<InternetExplorerOptions> ie = co -> { };

    public Consumer<EdgeOptions> ieEdge = co -> { };

    public Consumer<OperaOptions> opera = co -> { };

    public Consumer<SafariOptions> safari = co -> { };
}
