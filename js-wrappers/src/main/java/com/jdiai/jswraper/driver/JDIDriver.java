package com.jdiai.jswraper.driver;

import com.jdiai.tools.map.MapArray;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;

import static com.jdiai.jswraper.driver.DriverTypes.*;
import static com.jdiai.jswraper.driver.RunModes.LOCAL_DOWNLOAD;
import static com.jdiai.tools.pairs.Pair.$;
import static java.awt.Toolkit.getDefaultToolkit;

public class JDIDriver {
    public static RunModes RUN_MODE = LOCAL_DOWNLOAD;

    public static Consumer<WebDriver> DRIVER_SETUP = JDIDriver::maximizeBrowser;

    public static void maximizeBrowser(WebDriver driver) {
        java.awt.Dimension screenSize = getDefaultToolkit().getScreenSize();
        int width = screenSize.getWidth() > 0 ? (int) screenSize.getWidth() : 1024;
        int height = screenSize.getHeight() > 0 ? (int) screenSize.getHeight() : 768;
        setBrowserSize(driver, width, height);
    }

    public static void setBrowserSize(WebDriver driver, int width, int height) {
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public static DriverOptions DRIVER_OPTIONS = new DriverOptions();

    public static MapArray<DriverTypes, String> REMOTE_DRIVER_VERSIONS = new MapArray<>(
            $(CHROME, "latest"),
            $(FIREFOX, "latest"),
            $(IE, "latest"),
            $(IE_EDGE, "latest"),
            $(SAFARI, "latest"),
            $(OPERA, "latest")
    );
}
