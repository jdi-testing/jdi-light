package com.epam.jdi.light.settings;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.DriverData;
import com.epam.jdi.light.logger.ILogger;
import com.epam.jdi.light.logger.JDILogger;
import com.epam.jdi.tools.PropertyReader;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static com.epam.jdi.light.driver.ScreenshotMaker.SCREEN_PATH;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.elements.composite.WebPage.CHECK_AFTER_OPEN;
import static com.epam.jdi.tools.PropertyReader.fillAction;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static org.openqa.selenium.PageLoadStrategy.*;

public class WebSettings {
    public static ILogger logger = JDILogger.instance("JDI");
    public static String DOMAIN;
    public static String KILL_BROWSER = "afterAndBefore";
    public static JFunc1<WebElement, Boolean> SEARCH_CONDITION = Objects::nonNull;
    public static boolean STRICT_SEARCH = true;
    public static boolean hasDomain() {
        return DOMAIN != null && DOMAIN.contains("://");
    }
    public static boolean initialized = false;
    public static int TIMEOUT = 10;
    public static String TEST_GROUP = "";
    public static String TEST_PROPERTIES_PATH = "test.properties";

    public static synchronized void init() {
        if (!initialized) {
            getProperties(TEST_PROPERTIES_PATH);
            fillAction(p -> TIMEOUT = parseInt(p), "timeout.wait.element");
            fillAction(p -> DOMAIN = p, "domain");
            fillAction(p -> DriverData.DRIVER_NAME = p, "driver");
            fillAction(p -> DRIVER_VERSION = p, "drivers.version");
            fillAction(p -> DRIVERS_FOLDER = p, "drivers.folder");
            fillAction(p -> SCREEN_PATH = p, "screens.folder");
            fillAction(p -> DRIVER_VERSION =
                    p.toLowerCase().equals("true") || p.toLowerCase().equals("1")
                            ? "LATEST" : "", "drivers.getLatest");
            // TODO fillAction(p -> asserter.doScreenshot(p), "screenshot.strategy");
            fillAction(p -> KILL_BROWSER = p, "browser.kill");
            fillAction(p -> setSearchStrategy(p), "element.search.strategy");
            fillAction(p -> BROWSER_SIZE = p, "browser.size");
            fillAction(p -> PAGE_LOAD_STRATEGY = getPageLoadStrategy(p), "page.load.strategy");
            fillAction(p -> CHECK_AFTER_OPEN = parseBoolean(p), "page.check.after.open");
            WebDriverFactory.INIT_THREAD_ID = Thread.currentThread().getId();
            initialized = true;
        }
    }
    private static void setSearchStrategy(String p) {
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
    }

    private static PageLoadStrategy getPageLoadStrategy(String strategy) {
        switch (strategy.toLowerCase()) {
            case "normal": return NORMAL;
            case "none": return NONE;
            case "eager": return EAGER;
        }
        return NORMAL;
    }
    public static Properties getProperties(String path) {
        Properties p = PropertyReader.getProperties("/../../target/classes/" + path);
        return p.size() > 0 ? p : PropertyReader.getProperties(path);
    }
}
