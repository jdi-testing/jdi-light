package com.epam.jdi.light.settings;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.*;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.logger.ILogger;
import com.epam.jdi.tools.*;
import com.epam.jdi.tools.func.*;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.*;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

import static com.epam.jdi.light.common.ElementArea.*;
import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.common.NameToLocator.*;
import static com.epam.jdi.light.common.PageChecks.*;
import static com.epam.jdi.light.common.SearchStrategies.*;
import static com.epam.jdi.light.common.SetTextTypes.*;
import static com.epam.jdi.light.common.TextTypes.*;
import static com.epam.jdi.light.driver.ScreenshotMaker.*;
import static com.epam.jdi.light.driver.WebDriverFactory.*;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.RemoteDriver.*;
import static com.epam.jdi.light.driver.sauce.SauceSettings.*;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static com.epam.jdi.light.logger.JDILogger.*;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.logger.Strategy.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.Strategies.*;
import static com.epam.jdi.tools.EnumUtils.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PathUtils.*;
import static com.epam.jdi.tools.PrintUtils.*;
import static com.epam.jdi.tools.PropertyReader.*;
import static java.lang.Boolean.*;
import static java.lang.Integer.*;
import static java.lang.String.*;
import static java.util.Arrays.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.openqa.selenium.PageLoadStrategy.NONE;
import static org.openqa.selenium.PageLoadStrategy.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebSettings {
    public static ILogger logger = instance("JDI");
    public static String getDomain() {
        if (DRIVER.domain != null)
            return DRIVER.domain;
        init();
        return "No Domain Found. Use test.properties or JDISettings.DRIVER.domain";
    }
    public static void setDomain(String domain) {
        DRIVER.domain = domain;
    }
    public static VisualCheckAction VISUAL_ACTION_STRATEGY = VisualCheckAction.NONE;
    public static VisualCheckPage VISUAL_PAGE_STRATEGY = VisualCheckPage.NONE;
    public static boolean STRICT_SEARCH = true;
    public static boolean hasDomain() {
        init();
        return DRIVER.domain != null && DRIVER.domain.contains("://");
    }
    public static String TEST_GROUP = "";
    // TODO multi properties example
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
    public static String printSmartLocators(IBaseElement el) {
        try {
            return "smart: " + format(ELEMENT.smartTemplate, ELEMENT.smartName.value.execute(el.getName()));
        } catch (Exception ex) {
            return format("Can't define smart locator(%s, %s)", ELEMENT.smartTemplate, ELEMENT.smartName.key);
        }
    }
    public static JFunc1<IBaseElement, WebElement> SMART_SEARCH = el -> {
        if (!ELEMENT.useSmartSearch)
            return null;
        String locatorName = ELEMENT.smartName.value.execute(el.getName());
        return el.base().timer().getResult(() -> {
            String locator = format(ELEMENT.smartTemplate, locatorName);
            UIElement ui = (ELEMENT.smartTemplate.equals("#%s")
                ? $(locator)
                : $(locator, el.base().parent))
                    .setup(e -> e.setName(el.getName()).noWait());
            try {
                return ui.getWebElement();
            } catch (Exception ignore) {
                throw exception("Element '%s' has no locator and Smart Search failed (%s). Please add locator to element or be sure that element can be found using Smart Search", el.getName(), printSmartLocators(el));
            }
        });
    };
    public static boolean initialized = false;
    public static synchronized void init() {
        if (initialized) return;
        getProperties(COMMON.testPropertiesPath);
        fillAction(p -> COMMON.strategy = getStrategy(p), "strategy");
        COMMON.strategy.action.execute();
        fillAction(p -> TIMEOUTS.element = new Timeout(parseInt(p)), "timeout.wait.element");
        fillAction(p -> TIMEOUTS.page = new Timeout(parseInt(p)), "timeout.wait.page");
        fillAction(WebSettings::setDomain, "domain");
        if (DRIVER.name.equals(DEFAULT_DRIVER))
            fillAction(p -> DRIVER.name = p, "driver");
        fillAction(p -> DRIVER.version = p, "driver.version");
        fillAction(p -> DRIVER.path = p, "drivers.folder");
        fillAction(p -> SCREEN_PATH = p, "screens.folder");
        addStrategy(FAIL, LOGS.screenStrategy);
        fillAction(p -> LOGS.screenStrategy = getLoggerStrategy(p), "screenshot.strategy");
        fillAction(p -> LOGS.htmlCodeStrategy = getLoggerStrategy(p), "html.code.strategy");
        fillAction(p -> LOGS.requestsStrategy = getLoggerStrategy(p), "requests.strategy");
        fillAction(p -> COMMON.killBrowser = p, "browser.kill");
        fillAction(WebSettings::setSearchStrategy, "element.search.strategy");
        fillAction(p -> DRIVER.screenSize.read(p), "browser.size");
        fillAction(p -> DRIVER.pageLoadStrategy = getPageLoadStrategy(p), "page.load.strategy");
        fillAction(p -> PAGE.checkPageOpen = parse(p), "page.check.after.open");
        fillAction(SoftAssert::setAssertType, "assert.type");
        fillAction(p -> ELEMENT.clickType = getClickType(p), "click.type");
        fillAction(p -> ELEMENT.getTextType = getTextType(p), "text.type");
        fillAction(p -> ELEMENT.setTextType = getSetTextType(p), "set.text.type");

        // RemoteWebDriver properties
        fillAction(p -> DRIVER.remoteUrl = getRemoteUrl(p), "remote.type");
        fillAction(p -> DRIVER.remoteUrl = p, "driver.remote.url");
        fillAction(p -> LOGS.logLevel = parseLogLevel(p), "log.level");
        logger.setLogLevel(LOGS.logLevel);
        fillAction(p -> LOGS.writeToAllure = parseBoolean(p), "allure.steps");
        fillAction(p -> ELEMENT.smartTemplate = p.split(";")[0], "smart.locators");
        fillAction(p -> ELEMENT.smartName = getSmartSearchFunc(p), "smart.locators.toName");
        fillAction(p -> ELEMENT.useSmartSearch = getBoolean(p), "smart.search");
        fillAction(p -> COMMON_CAPABILITIES.put("headless", p), "headless");

        loadCapabilities("chrome.capabilities.path", "chrome.properties",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_CHROME.put(key.toString(), value.toString())));
        loadCapabilities("ff.capabilities.path","ff.properties",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_FF.put(key.toString(), value.toString())));
        loadCapabilities("ie.capabilities.path","ie.properties",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_IE.put(key.toString(), value.toString())));
        loadCapabilities("edge.capabilities.path","edge.properties",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_EDGE.put(key.toString(), value.toString())));
        loadCapabilities("opera.capabilities.path","opera.properties",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_OPERA.put(key.toString(), value.toString())));
        loadCapabilities("safari.capabilities.path","safari.properties",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_SAFARI.put(key.toString(), value.toString())));
        loadCapabilities("common.capabilities.path","common.properties",
            p -> p.forEach((key,value) -> COMMON_CAPABILITIES.put(key.toString(), value.toString())));

        INIT_THREAD_ID = Thread.currentThread().getId();
        initialized = true;
    }

    private static ElementArea getClickType(String type) {
        ElementArea clickType = first(getAllEnumValues(ElementArea.class),
                t -> t.toString().equals(type));
        return clickType != null
                ? clickType : CENTER;
    }
    private static boolean getBoolean(String param) {
        String lowerParams = param.toLowerCase();
        return !lowerParams.equals("off") && !lowerParams.equals("false");
    }
    private static TextTypes getTextType(String type) {
        TextTypes textType = first(getAllEnumValues(TextTypes.class),
                t -> t.toString().equals(type));
        return textType != null
                ? textType : SMART_TEXT;
    }
    private static SetTextTypes getSetTextType(String type) {
        SetTextTypes textType = first(getAllEnumValues(SetTextTypes.class),
                t -> t.toString().equals(type));
        return textType != null
                ? textType : SET_TEXT;
    }
    private static String getRemoteUrl(String prop) {
        switch (prop.toLowerCase().replaceAll(" ", "")) {
            case "sauce":
            case "saucelabs":
                COMMON_CAPABILITIES = sauceCapabilities();
                return sauceLabs();
            case "browserstack": return browserstack();
            default: return seleniumLocalhost();
        }
    }
    private static Pair<String, JFunc1<String, String>> getSmartSearchFunc(String name) {
        if (!SMART_MAP_NAME_TO_LOCATOR.keys().contains(name)) {
            throw exception("Unknown JDISettings.ELEMENT.smartName: '%s'. Please correct value 'smart.locators.toName' in test.properties." +
                "Available names: [%s]", name, print(SMART_MAP_NAME_TO_LOCATOR.keys()));
        }
        return Pair.$(name, SMART_MAP_NAME_TO_LOCATOR.get(name));
    }

    public static void loadCapabilities(String property, String defaultPath, JAction1<Properties> setCapabilities) {
        String path = "";
        try {
            path = System.getProperty(property, getProperty(property));
        } catch (Exception ignore) { }
        if (isEmpty(path))
            path = defaultPath;
        Properties properties = new PropReader(path).getProperties();
        if (properties.isEmpty())
            return;
        try {
            setCapabilities.execute(properties);
        } catch (Exception ignore) { }
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
            if (params.contains("enabled"))
                visibleEnabled();
            if (params.contains("inview"))
                inView();
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

    private static Properties getProperties(String path) {
        File propertyFile = new File(path);
        Properties properties;
        if (propertyFile.exists()) {
            properties = getCiProperties(path, propertyFile);
        } else {
            Properties pTest = PropertyReader.getProperties(mergePath(path));
            Properties pTarget = PropertyReader.getProperties(mergePath("/../../target/classes/" + path));
            if (pTarget.size() > 0)
                return pTarget;
            String propertiesPath = pTest.size() > 0
                    ? path
                    : mergePath("/../../target/classes/" + path);
            properties = PropertyReader.getProperties(propertiesPath);
        }
        return properties;
    }

    private static Properties getCiProperties(String path, File propertyFile){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertyFile));
            System.out.println("Property file found: " + propertyFile.getAbsolutePath());
        } catch (IOException ex) {
            throw exception("Couldn't load properties for CI Server" + path);
        }
        return properties;
    }
    private static List<com.epam.jdi.light.logger.Strategy> getLoggerStrategy(String strategy) {
        if (isBlank(strategy))
            return new ArrayList<>();
        List<com.epam.jdi.light.logger.Strategy> strategies = new ArrayList<>();
        try {
            String[] split = strategy.split(";");
            strategies = map(split, s -> parseStrategy(s.trim()));
        } catch (Exception ignore) { }
        return strategies;
    }
    private static Strategies getStrategy(String prop) {
        String strategy = prop.trim().toLowerCase();
        switch (strategy) {
            case "jdi": return JDI;
            case "selenium": return SELENIUM;
            default: return JDI;
        }
    }
}
