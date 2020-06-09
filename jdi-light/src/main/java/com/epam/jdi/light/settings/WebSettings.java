package com.epam.jdi.light.settings;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.*;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.logger.ILogger;
import com.epam.jdi.tools.PropReader;
import com.epam.jdi.tools.PropertyReader;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.epam.jdi.light.common.ElementArea.CENTER;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.NameToLocator.SMART_MAP_NAME_TO_LOCATOR;
import static com.epam.jdi.light.common.PageChecks.parse;
import static com.epam.jdi.light.common.SearchStrategies.*;
import static com.epam.jdi.light.common.SetTextTypes.CLEAR_SEND_KEYS;
import static com.epam.jdi.light.common.TextTypes.SMART_TEXT;
import static com.epam.jdi.light.common.UseSmartSearch.*;
import static com.epam.jdi.light.driver.WebDriverFactory.INIT_THREAD_ID;
import static com.epam.jdi.light.driver.get.DriverData.DEFAULT_DRIVER;
import static com.epam.jdi.light.driver.get.RemoteDriver.*;
import static com.epam.jdi.light.driver.sauce.SauceSettings.sauceCapabilities;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.JDILogger.instance;
import static com.epam.jdi.light.logger.LogLevels.parseLogLevel;
import static com.epam.jdi.light.logger.Strategy.parseStrategy;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.Strategies.*;
import static com.epam.jdi.tools.EnumUtils.getAllEnumValues;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.PropertyReader.getProperty;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.openqa.selenium.PageLoadStrategy.EAGER;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;

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
        logger.debug("DRIVER.domain = " + domain);
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
        switch (ELEMENT.useSmartSearch) {
            case FALSE:
                return null;
            case ONLY_UI:
                if (el.base().locator.isNull())
                    return null;
                break;
            case UI_AND_ELEMENTS:
                if (el.base().locator.isNull() && isInterface(el.getClass(), PageObject.class))
                    return null;
                break;
        }
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
    private static void fillAction(JAction1<String> action, String name) {
        String prop = null;
        try {
            prop = getProperty(name);
        } catch (Exception ignore) {}
        logger.debug("fillAction(%s=%s)", name, prop == null ? "null" : prop);
        if (isBlank(prop)) return;
        action.execute(prop);
    }
    
    public static boolean initialized = false;

    public static synchronized void init() {
        if (initialized) return;
        logger.debug("init()");
        try {
            getProperties(COMMON.testPropertiesPath);
            fillAction(p -> COMMON.strategy = getStrategy(p), "strategy");
            COMMON.strategy.action.execute();
            if (DRIVER.name.equals(DEFAULT_DRIVER))
                fillAction(p -> DRIVER.name = p, "driver");
            fillAction(p -> DRIVER.version = p, "driver.version");
            fillAction(p -> DRIVER.path = p, "drivers.folder");
            fillAction(p -> TIMEOUTS.element = new Timeout(parseInt(p)), "timeout.wait.element");
            fillAction(p -> TIMEOUTS.page = new Timeout(parseInt(p)), "timeout.wait.page");
            fillAction(WebSettings::setDomain, "domain");
            fillAction(p -> SCREEN.path = p, "screens.folder");
            fillAction(p -> ELEMENT.startIndex = parseInt(p), "list.start.index");
            fillAction(p -> LOGS.logInfoDetails = getInfoDetailsLevel(p), "log.info.details");
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
            fillAction(p -> ELEMENT.smartTemplate = p.split(";")[0], "smart.locator");
            fillAction(p -> ELEMENT.smartName = getSmartSearchFunc(p), "smart.locator.to.name");
            fillAction(p -> ELEMENT.useSmartSearch = getSmartSearchUse(p), "smart.search");
            fillAction(p -> DRIVER.capabilities.common.put("headless", p), "headless");

            loadCapabilities("chrome.capabilities.path", "chrome.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.chrome.put(key.toString(), value.toString())));
            loadCapabilities("ff.capabilities.path","ff.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.firefox.put(key.toString(), value.toString())));
            loadCapabilities("ie.capabilities.path","ie.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.ie.put(key.toString(), value.toString())));
            loadCapabilities("edge.capabilities.path","edge.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.ieEdge.put(key.toString(), value.toString())));
            loadCapabilities("opera.capabilities.path","opera.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.opera.put(key.toString(), value.toString())));
            loadCapabilities("safari.capabilities.path","safari.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.safari.put(key.toString(), value.toString())));
            loadCapabilities("common.capabilities.path","common.properties",
                p -> p.forEach((key,value) -> DRIVER.capabilities.common.put(key.toString(), value.toString())));

            INIT_THREAD_ID = Thread.currentThread().getId();
            initialized = true;
        } catch (Throwable ex) {
            throw exception(ex, "Failed to init test.properties");
        }
    }

    private static ElementArea getClickType(String type) {
        ElementArea clickType = first(getAllEnumValues(ElementArea.class),
            t -> t.toString().trim().replaceAll("[^a-z]", "")
                .equalsIgnoreCase(type.trim().replaceAll("[^a-z]", "")));
        return clickType != null
                ? clickType : CENTER;
    }
    private static boolean getBoolean(String param) {
        String lowerParams = param.toLowerCase();
        return !lowerParams.equals("off") && !lowerParams.equals("false");
    }
    private static TextTypes getTextType(String type) {
        TextTypes textType = first(getAllEnumValues(TextTypes.class),
            t -> t.toString().trim().replaceAll("[^a-z]", "")
                .equalsIgnoreCase(type.trim().replaceAll("[^a-z]", "")));
        return textType != null
                ? textType : SMART_TEXT;
    }
    private static SetTextTypes getSetTextType(String type) {
        SetTextTypes setTextType = first(getAllEnumValues(SetTextTypes.class),
            t -> t.toString().trim().replaceAll("[^a-z]", "")
                .equalsIgnoreCase(type.trim().replaceAll("[^a-z]", "")));
        return setTextType != null
                ? setTextType : CLEAR_SEND_KEYS;
    }
    private static String getRemoteUrl(String prop) {
        String value = prop.toLowerCase().trim().replaceAll("[^a-z]", "");
        switch (value) {
            case "sauce":
            case "saucelabs":
                DRIVER.capabilities.common = sauceCapabilities();
                return sauceLabs();
            case "browserstack": return browserstack();
            default: return seleniumLocalhost();
        }
    }
    private static Pair<String, JFunc1<String, String>> getSmartSearchFunc(String name) {
        if (!SMART_MAP_NAME_TO_LOCATOR.keys().contains(name)) {
            throw exception("Unknown JDISettings.ELEMENT.smartName: '%s'. Please correct value 'smart.locator.to.name' in test.properties." +
                "Available names: [%s]", name, print(SMART_MAP_NAME_TO_LOCATOR.keys()));
        }
        return Pair.$(name, SMART_MAP_NAME_TO_LOCATOR.get(name));
    }
    private static UseSmartSearch getSmartSearchUse(String prop) {
        String value = prop.toLowerCase().trim().replaceAll("[^a-z]", "");
        switch (value) {
            case "false":
            case "off":
                return FALSE;
            case "onlyui":
                return ONLY_UI;
            case "uiandelements":
                return UI_AND_ELEMENTS;
            case "always":
                return ALWAYS;
            default:
                return UI_AND_ELEMENTS;
        }
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
            case "none": return PageLoadStrategy.NONE;
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
    private static LogInfoDetails getInfoDetailsLevel(String option) {
        switch (option.toLowerCase()) {
            case "none": return LogInfoDetails.NONE;
            case "name": return LogInfoDetails.NAME;
            case "locator": return LogInfoDetails.LOCATOR;
            case "context": return LogInfoDetails.CONTEXT;
            case "element": return LogInfoDetails.ELEMENT;
            default: return LogInfoDetails.ELEMENT;
        }
    }
    private static List<com.epam.jdi.light.logger.Strategy> getLoggerStrategy(String strategy) {
        if (isBlank(strategy) || strategy.trim().equalsIgnoreCase("off"))
            return new ArrayList<>();
        List<com.epam.jdi.light.logger.Strategy> strategies = new ArrayList<>();
        try {
            String[] split = strategy.split(";");
            strategies = map(split, s -> parseStrategy(s.trim()));
        } catch (Exception ignore) { }
        return strategies;
    }
    private static Strategies getStrategy(String prop) {
        String strategy = prop.trim().toLowerCase().replaceAll("[^a-z]", "");
        switch (strategy) {
            case "jdi": return JDI;
            case "jdismart": return JDI_SMART;
            case "selenium": return SELENIUM;
            default: return JDI;
        }
    }
}
