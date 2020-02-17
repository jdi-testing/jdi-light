package com.epam.jdi.mobile.settings;

import com.epam.jdi.mobile.asserts.core.SoftAssert;
import com.epam.jdi.mobile.common.*;
import com.epam.jdi.mobile.driver.WebDriverFactory;
import com.epam.jdi.mobile.driver.get.DriverTypes;
import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.interfaces.base.IBaseElement;
import com.epam.jdi.mobile.logger.AllureLoggerHelper;
import com.epam.jdi.mobile.logger.ILogger;
import com.epam.jdi.tools.PropertyReader;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.StringUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static com.epam.jdi.mobile.common.ElementArea.CENTER;
import static com.epam.jdi.mobile.common.ElementArea.SMART_CLICK;
import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.common.PageChecks.parse;
import static com.epam.jdi.mobile.common.SetTextTypes.SET_TEXT;
import static com.epam.jdi.mobile.common.TextTypes.SMART_TEXT;
import static com.epam.jdi.mobile.driver.ScreenshotMaker.SCREENSHOT_STRATEGY;
import static com.epam.jdi.mobile.driver.ScreenshotMaker.SCREEN_PATH;
import static com.epam.jdi.mobile.driver.WebDriverFactory.INIT_THREAD_ID;
import static com.epam.jdi.mobile.driver.appium.AppiumSettings.appiumCapabilities;
import static com.epam.jdi.mobile.driver.get.DriverData.*;
import static com.epam.jdi.mobile.driver.get.RemoteDriver.*;
import static com.epam.jdi.mobile.driver.sauce.SauceSettings.sauceCapabilities;
import static com.epam.jdi.mobile.elements.composite.WebPage.CHECK_AFTER_OPEN;
import static com.epam.jdi.mobile.elements.init.PageFactory.preInit;
import static com.epam.jdi.mobile.elements.init.UIFactory.$;
import static com.epam.jdi.mobile.logger.AllureLoggerHelper.*;
import static com.epam.jdi.mobile.logger.JDILogger.instance;
import static com.epam.jdi.mobile.logger.LogLevels.parseLogLevel;
import static com.epam.jdi.mobile.settings.TimeoutSettings.PAGE_TIMEOUT;
import static com.epam.jdi.mobile.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.EnumUtils.getAllEnumValues;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PropertyReader.fillAction;
import static com.epam.jdi.tools.PropertyReader.getProperty;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.openqa.selenium.PageLoadStrategy.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebSettings {
    public static ILogger logger = instance("JDI");
    public static String DOMAIN;
    public static String getDomain() {
        if (DOMAIN != null)
            return DOMAIN;
        preInit();
        return "No Domain Found. Use test.properties or WebSettings.DOMAIN";
    }
    public static void setDomain(String domain) {
        DOMAIN = domain;
    }
    public static String KILL_BROWSER = "afterAndBefore";
    public static JFunc1<WebElement, Boolean> ANY_ELEMENT = Objects::nonNull;
    public static JFunc1<WebElement, Boolean> VISIBLE_ELEMENT = WebElement::isDisplayed;
    public static JFunc1<WebElement, Boolean> ENABLED_ELEMENT = el ->
        el != null && el.isDisplayed() && el.isEnabled();
    public static JFunc1<WebElement, Boolean> ELEMENT_IN_VIEW = el ->
        el != null && !el.isDisplayed() && $(el).isClickable();
    public static JFunc1<WebElement, Boolean> SEARCH_RULES = VISIBLE_ELEMENT;
    public static JAction1<UIElement> BEFORE_SEARCH = b -> {};
    public static void setSearchRule(JFunc1<WebElement, Boolean> rule) {
        SEARCH_RULES = rule;
    }
    public static void noValidation() {
        SEARCH_RULES = ANY_ELEMENT;
        CLICK_TYPE = CENTER;
    }
    public static void onlyVisible() {
        SEARCH_RULES = VISIBLE_ELEMENT;
    }
    public static void visibleEnabled() {
        SEARCH_RULES = ENABLED_ELEMENT;
    }
    public static void inView() {
        SEARCH_RULES = ELEMENT_IN_VIEW;
        BEFORE_SEARCH = UIElement::show;
    }

    public static ElementArea CLICK_TYPE = SMART_CLICK;
    public static TextTypes TEXT_TYPE = SMART_TEXT;
    public static SetTextTypes SET_TEXT_TYPE = SET_TEXT;
    public static VisualCheckAction VISUAL_ACTION_STRATEGY = VisualCheckAction.NONE;
    public static VisualCheckPage VISUAL_PAGE_STRATEGY = VisualCheckPage.NONE;
    public static boolean STRICT_SEARCH = true;
    public static boolean hasDomain() {
        preInit();
        return DOMAIN != null && DOMAIN.contains("://");
    }
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
    public static JFunc1<IBaseElement, WebElement> SMART_SEARCH = el -> {
        String locatorName = SMART_SEARCH_NAME.execute(el.getName());
        return el.base().timer().getResult(() -> {
            for (String template : SMART_SEARCH_LOCATORS) {
                UIElement ui = (template.equals("#%s")
                    ? $(String.format(template, locatorName))
                    : $(String.format(template, locatorName), el.base().parent))
                        .setup(e -> e.setName(el.getName()).noWait());
                try {
                    return ui.getWebElement();
                } catch (Exception ignore) { }
            }
            throw exception("Element '%s' has no locator and Smart Search failed. Please add locator to element or be sure that element can be found using Smart Search", el.getName());
        });
    };

    public static synchronized void init() {
        getProperties(TEST_PROPERTIES_PATH);
        fillAction(p -> TIMEOUT = new Timeout(parseInt(p)), "timeout.wait.element");
        fillAction(p -> PAGE_TIMEOUT = new Timeout(parseInt(p)), "timeout.wait.page");
        fillAction(p -> setDomain(p), "domain");
        if (DRIVER_NAME.equals(DEFAULT_DRIVER))
            fillAction(p -> DRIVER_NAME = p, "driver");
        fillAction(p -> DRIVER_VERSION = p.equalsIgnoreCase(LATEST_VERSION)
                ? LATEST_VERSION : (p.equalsIgnoreCase(PRELATEST_VERSION))
                    ? PRELATEST_VERSION : p, "driver.version");
        fillAction(p -> DRIVERS_FOLDER = p, "drivers.folder");
        fillAction(p -> SCREEN_PATH = p, "screens.folder");
        fillAction(p -> SCREENSHOT_STRATEGY = getAttachmentStrategy(p), "screenshot.strategy");
        fillAction(p -> HTML_CODE_LOGGING = getAttachmentStrategy(p), "html.code.logging");
        fillAction(p -> KILL_BROWSER = p, "browser.kill");
        fillAction(WebSettings::setSearchStrategy, "element.search.strategy");
        fillAction(p -> BROWSER_SIZE = p, "browser.size");
        fillAction(p -> PAGE_LOAD_STRATEGY = getPageLoadStrategy(p), "page.load.strategy");
        fillAction(p -> CHECK_AFTER_OPEN = parse(p), "page.check.after.open");
        fillAction(SoftAssert::setAssertType, "assert.type");
        fillAction(p -> TEXT_TYPE = getTextType(p), "text.type");
        fillAction(p -> SET_TEXT_TYPE = getSetTextType(p), "set.text.type");

        // RemoteWebDriver properties
        fillAction(p -> DRIVER_REMOTE_URL = getRemoteUrl(p), "remote.type");
        fillAction(p -> DRIVER_REMOTE_URL = p, "driver.remote.url");
        fillAction(p -> logger.setLogLevel(parseLogLevel(p)), "log.level");
        fillAction(p -> SMART_SEARCH_LOCATORS =
            filter(p.split(";"), l -> isNotBlank(l)), "smart.locators");
        fillAction(p -> SMART_SEARCH_NAME = getSmartSearchFunc(p), "smart.locators.toName");
        fillAction(p -> COMMON_CAPABILITIES.put("headless", p), "headless");

        loadCapabilities("chrome.capabilities.path",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_CHROME.put(key.toString(),value.toString())));
        loadCapabilities("ff.capabilities.path",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_FF.put(key.toString(),value.toString())));
        loadCapabilities("ie.capabilities.path",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_IE.put(key.toString(),value.toString())));
        loadCapabilities("edge.capabilities.path",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_EDGE.put(key.toString(),value.toString())));
        loadCapabilities("opera.capabilities.path",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_OPERA.put(key.toString(),value.toString())));

        INIT_THREAD_ID = Thread.currentThread().getId();
        if (SMART_SEARCH_LOCATORS.size() == 0)
            SMART_SEARCH_LOCATORS.add("#%s"/*, "[ui=%s]", "[qa=%s]", "[name=%s]"*/);
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
            case "appium":
                COMMON_CAPABILITIES = appiumCapabilities();
                return appium();
            default: return seleniumLocalhost();
        }
    }
    private static JFunc1<String, String> getSmartSearchFunc(String name) {
        switch (name) {
            case "camelCase":
                return StringUtils::toCamelCase;
            case "snake_case":
                return StringUtils::toSnakeCase;
            case "kebab-case":
                return StringUtils::toKebabCase;
            case "PascalCase":
                return StringUtils::toPascalCase;
            case "UPPER_SNAKE_CASE":
                return StringUtils::toUpperSnakeCase;
            default: return StringUtils::toKebabCase;
        }
    }


    private static void loadCapabilities(String property, JAction1<Properties> setCapabilities) {
        String path = "";
        try {
            path = System.getProperty(property, getProperty(property));
        } catch (Exception ignore) {
        }
        if (isNotEmpty(path)) {
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
            System.out.println("Property file found: " + propertyFile.getAbsolutePath());
            properties.load(new FileInputStream(propertyFile));
        } catch (IOException ex) {
            throw exception("Couldn't load properties for CI Server" + path);
        }
        return properties;
    }
    private static AttachmentStrategy getAttachmentStrategy(String strategy) {
        return strategy.toLowerCase().equals("off")
            ? AttachmentStrategy.OFF
            : AttachmentStrategy.ON_FAIL;
    }
}
