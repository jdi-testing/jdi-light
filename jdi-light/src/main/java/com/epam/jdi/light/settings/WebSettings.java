package com.epam.jdi.light.settings;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.*;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.logger.HighlightStrategy;
import com.epam.jdi.light.logger.ILogger;
import com.jdiai.tools.PropReader;
import com.jdiai.tools.PropertyReader;
import com.jdiai.tools.Safe;
import com.jdiai.tools.func.JAction;
import com.jdiai.tools.func.JAction1;
import com.jdiai.tools.func.JFunc;
import com.jdiai.tools.func.JFunc1;
import com.jdiai.tools.pairs.Pair;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.epam.jdi.light.actions.ActionHelper.CHECK_MULTI_THREAD;
import static com.epam.jdi.light.common.ElementArea.CENTER;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.NameToLocator.SMART_MAP_NAME_TO_LOCATOR;
import static com.epam.jdi.light.common.PageChecks.parse;
import static com.epam.jdi.light.common.SearchStrategies.*;
import static com.epam.jdi.light.common.SearchTypes.*;
import static com.epam.jdi.light.common.SetTextTypes.CLEAR_SEND_KEYS;
import static com.epam.jdi.light.common.TextTypes.SMART_TEXT;
import static com.epam.jdi.light.common.UseSmartSearch.*;
import static com.epam.jdi.light.driver.WebDriverByUtils.getByLocator;
import static com.epam.jdi.light.driver.WebDriverFactory.RUN_DRIVERS;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriverFromName;
import static com.epam.jdi.light.driver.get.DriverData.DEFAULT_DRIVER;
import static com.epam.jdi.light.driver.get.RemoteDriverInfo.*;
import static com.epam.jdi.light.driver.sauce.SauceSettings.sauceCapabilities;
import static com.epam.jdi.light.elements.base.JdiSettings.DEFAULT_CONTEXT;
import static com.epam.jdi.light.elements.base.JdiSettings.getWebElementsFromContext;
import static com.epam.jdi.light.logger.JDILogger.instance;
import static com.epam.jdi.light.logger.LogLevels.parseLogLevel;
import static com.epam.jdi.light.logger.Strategy.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.Strategies.*;
import static com.jdiai.tools.EnumUtils.getEnumValueByName;
import static com.jdiai.tools.LinqUtils.list;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.PathUtils.mergePath;
import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.PropertyReader.getProperty;
import static com.jdiai.tools.PropertyReader.hasProperty;
import static com.jdiai.tools.ReflectionUtils.isInterface;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static com.jdiai.tools.StringUtils.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.*;
import static org.openqa.selenium.PageLoadStrategy.EAGER;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebSettings {
    public static ILogger logger = instance("JDI");

    public static VisualCheckAction VISUAL_ACTION_STRATEGY = VisualCheckAction.NONE;
    public static VisualCheckPage VISUAL_PAGE_STRATEGY = VisualCheckPage.NONE;

    public static String getDomain() {
        if (isBlank(DRIVER.domain)) {
            init();
        }
        return isNotBlank(DRIVER.domain) ? DRIVER.domain : "";
    }
    public static void setDomain(String domain) {
        DRIVER.domain = domain;
    }
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
            return "smart: " + getByLocator(ELEMENT.smartLocator.execute(el, ELEMENT.smartLocatorName.execute(el)));
        } catch (Exception ex) {
            return format("Can't define smart locator(%s, %s)", ELEMENT.smartTemplate, ELEMENT.smartName.key);
        }
    }

    public static List<WebElement> defaultSmartSearch(IBaseElement el) {
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
        String locatorName = ELEMENT.smartLocatorName.execute(el);
        By locator = ELEMENT.smartLocator.execute(el, locatorName);
        SearchContext ctx = DEFAULT_CONTEXT.execute(el.base().driver());
        try {
            return ELEMENT.smartTemplate.equals("#%s")
                    ? ctx.findElements(locator)
                    : getWebElementsFromContext(el.base(), locator);
        } catch (Exception ignore) {
            throw exception("Element '%s' has no locator and Smart Search failed (%s). Please add locator to element or be sure that element can be found using Smart Search", el.getName(), printSmartLocators(el));
        }
    }
    public static JFunc1<IBaseElement, List<WebElement>> SMART_SEARCH = WebSettings::defaultSmartSearch;
    private static void fillAction(JAction1<String> action, String name) {
        String prop = null;
        try {
            prop = getProperty(name);
        } catch (Exception ignore) {}
        logger.trace("fillAction(%s=%s)", name, prop == null ? "null" : prop);
        if (isBlank(prop)) return;
        action.execute(prop);
    }

    public static boolean initialized = false;
    public static JAction INIT_FUNC = WebSettings::jdiSetup;
    public static void jdiSetup() {
        Properties properties = getProperties(COMMON.testPropertiesPath);
        if (properties.isEmpty()) {
            LOGS.writeToAllure = !getProperties("allure.properties").isEmpty();
            COMMON.strategy.action.execute();
            return;
        }
        fillAction(p -> COMMON.strategy = getStrategy(p), "strategy");
        COMMON.strategy.action.execute();
        if (DRIVER.name.equalsIgnoreCase(DEFAULT_DRIVER)) {
            fillAction(p -> DRIVER.name = p,
                    isNotBlank(getProperty("driver")) ? "driver" : "browser");
        }
        fillAction(p -> DRIVER.version = p, "driver.version");
        fillAction(p -> DRIVER.path = p, "drivers.folder");
        fillAction(p -> DRIVER.path = p, "drivers.path");
        fillAction(p -> {
            if (parseBoolean(p))
                DRIVER.getFunc = name -> getDriverFromName(name, RUN_DRIVERS);
        }, "single.thread");
        fillAction(p -> TIMEOUTS.element = new Timeout(parseInt(p)), "timeout.wait.element");
        fillAction(p -> TIMEOUTS.page = new Timeout(parseInt(p)), "timeout.wait.page");
        fillAction(WebSettings::setDomain,
                isNotBlank(getProperty("site.url")) ? "site.url" : "domain");
        fillAction(p -> SCREEN.path = p, "screens.folder");
        fillAction(p -> SCREEN.tool = p, "screenshot.tool");
        if (SCREEN.tool.equals("robot")) {
            SCREEN.allowRobot = true;
        }
        fillAction(p -> SCREEN.allowRobot = parseBoolean(p), "allow.robot");
        fillAction(p -> ELEMENT.startIndex = parseInt(p), "list.start.index");
        fillAction(p -> LOGS.logInfoDetails = getInfoDetailsLevel(p), "log.info.details");
        fillAction(p -> LOGS.screenStrategy = getActionStrategy(p), "screenshot.strategy");
        fillAction(p -> LOGS.htmlCodeStrategy = getActionStrategy(p), "html.code.strategy");
        fillAction(p -> LOGS.requestsStrategy = getActionStrategy(p), "requests.strategy");
        fillAction(p -> COMMON.killBrowser = p, "browser.kill");
        fillAction(WebSettings::setSearchStrategy, "element.search.strategy");
        fillAction(p -> DRIVER.screenSize.read(p), "browser.size");
        fillAction(p -> DRIVER.pageLoadStrategy = getPageLoadStrategy(p), "page.load.strategy");
        fillAction(p -> DRIVER.gitHubTokenName = p, "gitHubTokenName");
        fillAction(p -> DRIVER.gitHubTokenSecret = p, "gitHubTokenSecret");
        fillAction(p -> PAGE.checkPageOpen = parse(p), "page.check.after.open");
        fillAction(SoftAssert::setAssertType, "assert.type");
        fillAction(p -> ELEMENT.clickType = getEnumValueByName(ElementArea.class, p, CENTER), "click.type");
        fillAction(p -> ELEMENT.getTextType = getEnumValueByName(TextTypes.class, p, SMART_TEXT), "text.type");
        fillAction(p -> ELEMENT.setTextType = getEnumValueByName(SetTextTypes.class, p, CLEAR_SEND_KEYS), "set.text.type");
        // RemoteWebDriver properties
        fillAction(p -> DRIVER.remoteUrl = getRemoteUrl(p), "remote.type");
        fillAction(p -> DRIVER.remoteUrl = p, "driver.remote.url");
        if (hasProperty("driver.remote.run")) {
            fillAction(p -> DRIVER.remoteRun = parseBoolean(p), "driver.remote.run");
        } else {
            DRIVER.remoteRun = hasProperty("driver.remote.url") && DRIVER.remoteRun == null;
        }
        fillAction(p -> LOGS.logLevel = parseLogLevel(p), "log.level");
        logger.setLogLevel(LOGS.logLevel);
        fillAction(p -> LOGS.writeToAllure = onOff(p),
            hasProperty("allure") ? "allure" : "allure.steps");
        fillAction(p -> ELEMENT.smartTemplate = p.split(";")[0], "smart.locator");
        fillAction(p -> ELEMENT.smartName = getSmartSearchFunc(p), "smart.locator.to.name");
        fillAction(p -> ELEMENT.useSmartSearch = getSmartSearchUse(p), "smart.search");
        fillAction(p -> ELEMENT.highlight = getHighlightStrategy(p), "element.highlight");
        fillAction(p -> {
            if (parseBoolean(p)) {
                DRIVER.capabilities.common.put("arguments", "--headless");
            }
        }, "headless");

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
        initialized = true;
    }

    public static synchronized void init() {
        CHECK_MULTI_THREAD.execute();
        if (initialized) return;
        Lock locker = new ReentrantLock();
        locker.lock();
        logger.trace("init()");
        try {
            INIT_FUNC.execute();
        } catch (Throwable ex) {
            throw exception(ex, "Failed to init test.properties");
        } finally {
            logger.trace("init() DONE");
            locker.unlock();
        }
    }

    private static boolean onOff(String onOff) {
        return onOff.equals("true") || onOff.equals("on");
    }
    private static String getRemoteUrl(String prop) {
        String value = prop.toLowerCase().trim().replaceAll("[^a-z]", "");
        switch (value) {
            case "sauce":
            case "saucelabs":
                DRIVER.capabilities.common = sauceCapabilities();
                return SAUCE_LABS;
            case "browserstack": return browserstack();
            case "selenoid": return SELENOID_LOCAL;
            default: return SELENIUM_LOCAL_HOST;
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
        } catch (Exception ignore) {
            logger.trace("Error on read property %s. %s", property, ignore);
        }
        if (isEmpty(path))
            path = defaultPath;
        Properties properties = new PropReader(path).getProperties();
        if (properties.isEmpty()) {
            logger.trace("There is no properties in %s", property);
            File p = new File("."+path);
            logger.trace("Abs prop path %s, Properties file exists? = %s", p.getAbsolutePath(), p.exists());
            return;
        }
        try {
            setCapabilities.execute(properties);
        } catch (Exception ignore) {
            logger.trace("Error set properties %s. %s", property, ignore);
        }
    }

    private static void setSearchStrategy(String p) {
        p = p.toLowerCase();
        if (p.equals("soft"))
            p = "any, multiple";
        if (p.equals("strict"))
            p = "visible, smart";
        if (p.split(",").length != 2) return;
        List<String> params = map(asList(p.split(",")), a -> ELEMENT.simplifyString.execute(a));
        if (params.contains("visible") || params.contains("displayed")) {
            onlyVisible();
        }
        if (params.contains("any") || params.contains("all")) {
            noValidation();
        }
        if (params.contains("enabled")) {
            visibleEnabled();
        }
        if (params.contains("inview")) {
            inView();
        }
        if (params.contains("single")) {
            ELEMENT.searchType = Single;
        } else if (params.contains("first") || params.contains("multiple")) {
            ELEMENT.searchType = First;
        } else if (params.contains("smart")) {
            ELEMENT.searchType = Smart;
        }
    }

    private static PageLoadStrategy getPageLoadStrategy(String strategy) {
        switch (strategy.toLowerCase()) {
            case "none":
                return PageLoadStrategy.NONE;
            case "eager":
                return EAGER;
            case "normal":
            default:
                return NORMAL;
        }
    }

    public static Properties getProperties(String path) {
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

    private static Properties getCiProperties(String path, File propertyFile) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertyFile));
            logger.info("Property file found: %s", propertyFile.getAbsolutePath());
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
    private static List<com.epam.jdi.light.logger.Strategy> getActionStrategy(String strategy) {
        if (isBlank(strategy))
            return asList(FAIL);
        if (strategy.trim().equalsIgnoreCase("off"))
            return new ArrayList<>();
        if (strategy.trim().equalsIgnoreCase("flow"))
            return list(NEW_PAGE, FAIL, ASSERT);
        List<com.epam.jdi.light.logger.Strategy> strategies = new ArrayList<>();
        try {
            String[] split = strategy.split("\\|");
            strategies = map(split, s -> parseStrategy(s.trim()));
        } catch (Exception ignore) { }
        return strategies;
    }
    private static List<HighlightStrategy> getHighlightStrategy(String strategy) {
        if (isBlank(strategy) || strategy.trim().equalsIgnoreCase("off"))
            return new ArrayList<>();
        if (strategy.trim().equalsIgnoreCase("flow"))
            return list(HighlightStrategy.FAIL, HighlightStrategy.ACTION, HighlightStrategy.ASSERT);
        List<HighlightStrategy> strategies = new ArrayList<>();
        try {
            String[] split = strategy.split("\\|");
            strategies = map(split, s -> HighlightStrategy.parseStrategy(s.trim()));
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
    public static void waitAction(int timeout, JAction action) {
        int oldTimeout = TIMEOUTS.element.get();
        TIMEOUTS.element.set(timeout);
        try {
            action.execute();
        } finally {
            TIMEOUTS.element.set(oldTimeout);
        }
    }
}
