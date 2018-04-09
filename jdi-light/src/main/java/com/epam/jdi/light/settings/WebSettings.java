package com.epam.jdi.light.settings;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.logger.ILogger;
import com.epam.jdi.tools.logger.JDILogger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static com.epam.jdi.light.driver.ScreenshotMaker.SCREEN_PATH;
import static com.epam.jdi.light.driver.WebDriverFactory.*;
import static com.epam.jdi.light.driver.get.DriverData.DRIVERS_FOLDER;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_VERSION;
import static com.epam.jdi.tools.PropertyReader.fillAction;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

public class WebSettings {
    public static ILogger logger = JDILogger.instance("JDI");
    public static String DOMAIN;
    public static String killBrowser = "afterAndBefore";
    public static JFunc1<WebElement, Boolean> SEARCH_CONDITION = Objects::nonNull;
    public static boolean STRICT_SEARCH = true;
    public static boolean hasDomain() {
        return DOMAIN != null && DOMAIN.contains("://");
    }
    public static boolean initialized = false;
    public static int TIMEOUT = 10;
    public static String jdiSettingsPath = "test.properties";
    public static boolean USE_CACHE = false;
    public static String TEST_GROUP = "";

    public static synchronized void init() {
        fillAction(p -> USE_CACHE =
                p.toLowerCase().equals("true") || p.toLowerCase().equals("1"), "cache");
        fillAction(p -> TIMEOUT = parseInt(p), "timeout.wait.element");
        fillAction(p -> DOMAIN = p, "domain");
        fillAction(p -> DRIVER_VERSION = p, "drivers.version");
        fillAction(p -> DRIVERS_FOLDER = p, "drivers.folder");
        fillAction(p -> DRIVER_PATH = p, "driver.path");
        fillAction(p -> SCREEN_PATH = p, "screens.folder");
        fillAction(p -> DRIVER_VERSION =
            p.toLowerCase().equals("true") || p.toLowerCase().equals("1")
                ? "LATEST" : "", "driver.getLatest");
        // TODO fillAction(p -> asserter.doScreenshot(p), "screenshot.strategy");
        fillAction(p -> killBrowser = p, "browser.kill");
        fillAction(p -> {
            p = p.toLowerCase();
            if (p.equals("soft"))
                p = "any, multiple";
            if (p.equals("strict"))
                p = "visible, single";
            if (p.split(",").length == 2) {
                List<String> params = asList(p.split(","));
                if (params.contains("visible") || params.contains("displayed"))
                    SEARCH_CONDITION = WebElement::isDisplayed;
                if (params.contains("any") || params.contains("all"))
                    SEARCH_CONDITION = Objects::nonNull;
                if (params.contains("single"))
                    STRICT_SEARCH = true;
                if (params.contains("multiple"))
                    STRICT_SEARCH = false;
            }
        }, "search.element.strategy" );
        fillAction(p -> {
            String[] split = null;
            if (p.split(",").length == 2)
                split = p.split(",");
            if (p.toLowerCase().split("x").length == 2)
                split = p.toLowerCase().split("x");
            if (split != null)
                BROWSER_SIZES = new Dimension(parseInt(split[0].trim()), parseInt(split[1].trim()));
        }, "browser.size");
        fillAction(p -> PAGELOAD_STRATEGY = p, "page.load.strategy");
        initialized = true;
    }
    public static void initDriver() {
        if (!initialized)
            try {
                init();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
    }
}
