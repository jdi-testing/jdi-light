package com.epam.jdi.light.settings;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.Timeout;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.logger.ILogger;
import com.epam.jdi.tools.PropertyReader;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.StringUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.PageChecks.parse;
import static com.epam.jdi.light.driver.ScreenshotMaker.SCREEN_PATH;
import static com.epam.jdi.light.driver.WebDriverFactory.INIT_THREAD_ID;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.RemoteDriver.DRIVER_REMOTE_URL;
import static com.epam.jdi.light.elements.base.DriverBase.DEFAULT_DRIVER;
import static com.epam.jdi.light.elements.composite.WebPage.CHECK_AFTER_OPEN;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.JDILogger.instance;
import static com.epam.jdi.light.settings.TimeoutSettings.PAGE_TIMEOUT;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.PropertyReader.fillAction;
import static com.epam.jdi.tools.PropertyReader.getProperty;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.openqa.selenium.PageLoadStrategy.*;

public class WebSettings {
    public static ILogger logger = instance("JDI");
    public static String DOMAIN;
    public static String KILL_BROWSER = "afterAndBefore";
    public static JFunc1<WebElement, Boolean> ANY_ELEMENT = Objects::nonNull;
    public static JFunc1<WebElement, Boolean> VISIBLE_ELEMENT = WebElement::isDisplayed;
    public static JFunc1<WebElement, Boolean> ENABLED_ELEMENT = el ->
        el != null && el.isDisplayed() && el.isEnabled();
    public static JFunc1<WebElement, Boolean> SEARCH_CONDITION = VISIBLE_ELEMENT;
    public static void setSearchRule(JFunc1<WebElement, Boolean> rule) {
        SEARCH_CONDITION = rule;
    }
    public static void noValidation() {
        SEARCH_CONDITION = ANY_ELEMENT;
    }
    public static void onlyVisible() {
        SEARCH_CONDITION = VISIBLE_ELEMENT;
    }
    public static void enabledElement() {
        SEARCH_CONDITION = ENABLED_ELEMENT;
    }
    public static boolean STRICT_SEARCH = true;
    public static boolean hasDomain() {
        return DOMAIN != null && DOMAIN.contains("://");
    }
    public static boolean initialized = false;
    public static String TEST_GROUP = "";
    // TODO multi properties example
    public static String TEST_PROPERTIES_PATH = "test.properties";
    public static Safe<String> TEST_NAME = new Safe<>((String) null);
    public static String useDriver(JFunc<WebDriver> driver) {
        return WebDriverFactory.useDriver(driver);
    }
    public static String useDriver(String driverName) {
        return WebDriverFactory.useDriver(driverName);
    }
    public static String useDriver(DriverTypes driverType) {
        return WebDriverFactory.useDriver(driverType);
    }

    public static List<String> SMART_SEARCH_LOCATORS = new ArrayList<>();
    public static JFunc1<String, String> SMART_SEARCH_NAME = StringUtils::splitHyphen;
    public static JFunc1<JDIBase, WebElement> SMART_SEARCH = el -> {
        String locatorName = SMART_SEARCH_NAME.execute(el.name);
        for (String template : SMART_SEARCH_LOCATORS) {
            UIElement ui = template.equals("#%s")
                ? $(String.format(template, locatorName)).setName(el.name)
                : $(String.format(template, locatorName), el.parent).setName(el.name);
            try {
                return ui.get();
            } catch (Exception ignore) { }
        }
        throw exception("Element '%s' has no locator and Smart Search failed. Please add locator to element or be sure that element can be found using Smart Search", el.name);
    };

    public static synchronized void init() {
        if (!initialized) {
            getProperties(TEST_PROPERTIES_PATH);
            fillAction(p -> TIMEOUT = new Timeout(parseInt(p)), "timeout.wait.element");
            fillAction(p -> PAGE_TIMEOUT = new Timeout(parseInt(p)), "timeout.wait.page");
            fillAction(p -> DOMAIN = p, "domain");
            if (DRIVER_NAME.equals(DEFAULT_DRIVER))
                fillAction(p -> DRIVER_NAME = p, "driver");
            fillAction(p -> DRIVER_VERSION = p.equalsIgnoreCase(LATEST_VERSION)
                    ? LATEST_VERSION : (p.equalsIgnoreCase(PRELATEST_VERSION))
                        ? PRELATEST_VERSION : p, "driver.version");
            fillAction(p -> DRIVERS_FOLDER = p, "drivers.folder");
            fillAction(p -> SCREEN_PATH = p, "screens.folder");
            // TODO fillAction(p -> asserter.doScreenshot(p), "screenshot.strategy");
            fillAction(p -> KILL_BROWSER = p, "browser.kill");
            fillAction(WebSettings::setSearchStrategy, "element.search.strategy");
            fillAction(p -> BROWSER_SIZE = p, "browser.size");
            fillAction(p -> PAGE_LOAD_STRATEGY = getPageLoadStrategy(p), "page.load.strategy");
            fillAction(p -> CHECK_AFTER_OPEN = parse(p), "page.check.after.open");
            fillAction(SoftAssert::setAssertType, "assert.type");

            // RemoteWebDriver properties
            fillAction(p -> DRIVER_REMOTE_URL = p, "driver.remote.url");

            loadCapabilities("chrome.capabilities.path",
                p -> p.forEach((key,value) -> CAPABILITIES_FOR_CHROME.put(key.toString(),value.toString())));
            loadCapabilities("ff.capabilities.path",
                p -> p.forEach((key,value) -> CAPABILITIES_FOR_FF.put(key.toString(),value.toString())));
            loadCapabilities("ie.capabilities.path",
                p -> p.forEach((key,value) -> CAPABILITIES_FOR_IE.put(key.toString(),value.toString())));

            INIT_THREAD_ID = Thread.currentThread().getId();
            SMART_SEARCH_LOCATORS.add("#%s"/*, "[ui=%s]", "[qa=%s]", "[name=%s]"*/);
            initialized = true;
        }
    }

    private static void loadCapabilities(String property, JAction1<Properties> setCapabilities) {
        String path = "";
        try { path = getProperty(property);
        } catch (Exception ignore) { }
        if(isNotEmpty(path)) {
            setCapabilities.execute(getProperties(path));
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
                onlyVisible();
            if (params.contains("any") || params.contains("all"))
                noValidation();
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
        // TODO use mergePath macos and windows
        Properties p = PropertyReader.getProperties("/../../target/classes/" + path);
        return p.size() > 0 ? p : PropertyReader.getProperties(path);
    }
}
