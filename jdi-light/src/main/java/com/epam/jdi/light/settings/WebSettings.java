package com.epam.jdi.light.settings;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.common.Timeout;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
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

import static com.epam.jdi.light.common.ElementArea.CENTER;
import static com.epam.jdi.light.common.ElementArea.SMART_CLICK;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.PageChecks.parse;
import static com.epam.jdi.light.common.Property.CHROME_CAPABILITIES_PATH;
import static com.epam.jdi.light.common.Property.DRIVER;
import static com.epam.jdi.light.common.Property.DRIVERS_FOLDER_PATH;
import static com.epam.jdi.light.common.Property.DRIVERS_VERSION;
import static com.epam.jdi.light.common.Property.FF_CAPABILITIES_PATH;
import static com.epam.jdi.light.common.Property.IE_CAPABILITIES_PATH;
import static com.epam.jdi.light.common.Property.SMART_LOCATORS;
import static com.epam.jdi.light.common.Property.TIMEOUT_WAIT_ELEMENT;
import static com.epam.jdi.light.common.PropertyValidationUtils.validateProperties;
import static com.epam.jdi.light.common.TextTypes.SMART_TEXT;
import static com.epam.jdi.light.driver.ScreenshotMaker.SCREEN_PATH;
import static com.epam.jdi.light.driver.WebDriverFactory.INIT_THREAD_ID;
import static com.epam.jdi.light.driver.get.DriverData.BROWSER_SIZE;
import static com.epam.jdi.light.driver.get.DriverData.CAPABILITIES_FOR_CHROME;
import static com.epam.jdi.light.driver.get.DriverData.CAPABILITIES_FOR_FF;
import static com.epam.jdi.light.driver.get.DriverData.CAPABILITIES_FOR_IE;
import static com.epam.jdi.light.driver.get.DriverData.DEFAULT_DRIVER;
import static com.epam.jdi.light.driver.get.DriverData.DRIVERS_FOLDER;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_VERSION;
import static com.epam.jdi.light.driver.get.DriverData.LATEST_VERSION;
import static com.epam.jdi.light.driver.get.DriverData.PAGE_LOAD_STRATEGY;
import static com.epam.jdi.light.driver.get.DriverData.PRELATEST_VERSION;
import static com.epam.jdi.light.driver.get.RemoteDriverUtils.DRIVER_REMOTE_URL;
import static com.epam.jdi.light.elements.composite.WebPage.CHECK_AFTER_OPEN;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.JDILogger.instance;
import static com.epam.jdi.light.logger.LogLevels.parseLogLevel;
import static com.epam.jdi.light.settings.TimeoutSettingsUtils.PAGE_TIMEOUT;
import static com.epam.jdi.light.settings.TimeoutSettingsUtils.TIMEOUT;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.PropertyReader.fillAction;
import static com.epam.jdi.tools.PropertyReader.getProperty;
import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.openqa.selenium.PageLoadStrategy.EAGER;
import static org.openqa.selenium.PageLoadStrategy.NONE;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;

@SuppressWarnings("PMD.ClassNamingConventions")
public class WebSettings {
    public static ILogger logger = instance("JDI");
    public static String DOMAIN;
    public static String KILL_BROWSER = "afterAndBefore";
    public static JFunc1<WebElement, Boolean> ANY_ELEMENT = Objects::nonNull;
    public static JFunc1<WebElement, Boolean> VISIBLE_ELEMENT = WebElement::isDisplayed;
    public static JFunc1<WebElement, Boolean> ENABLED_ELEMENT = el ->
        el != null && el.isDisplayed() && el.isEnabled();
    public static JFunc1<WebElement, Boolean> ELEMENT_IN_VIEW = el ->
        el != null && !el.isDisplayed() && $(el).isClickable();
    public static JFunc1<WebElement, Boolean> SEARCH_RULES = VISIBLE_ELEMENT;
    public static JAction1<UIElement> BEFORE_SEARCH = b -> {};
    public static List<String> SMART_SEARCH_LOCATORS = new ArrayList<>();
    public static JFunc1<String, String> SMART_SEARCH_NAME = StringUtils::splitHyphen;
    public static ElementArea CLICK_TYPE = SMART_CLICK;
    public static TextTypes TEXT_TYPE = SMART_TEXT;
    public static boolean STRICT_SEARCH = true;
    public static JFunc1<IBaseElement, WebElement> SMART_SEARCH = el -> {
        String locatorName = SMART_SEARCH_NAME.execute(el.getName());
        return el.base().timer().getResult(() -> {
            for (String template : SMART_SEARCH_LOCATORS) {
                UIElement ui = (("#%s").equals(template)
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
    public static String TEST_GROUP = "";
    // TODO multi properties example
    public static String TEST_PROPERTIES_PATH = "test.properties";
    public static Safe<String> TEST_NAME = new Safe<>((String) null);
    public static boolean hasDomain() {
        return DOMAIN != null && DOMAIN.contains("://");
    }
    public static String useDriver(JFunc<WebDriver> driver) {
        return WebDriverFactory.useDriver(driver);
    }
    public static String useDriver(String driverName) {
        return WebDriverFactory.useDriver(driverName);
    }
    public static String useDriver(DriverTypes driverType) {
        return WebDriverFactory.useDriver(driverType);
    }

    public static synchronized void init() {
        validateProperties(getProperties(TEST_PROPERTIES_PATH));
        fillAction(p -> TIMEOUT = new Timeout(parseInt(p)), TIMEOUT_WAIT_ELEMENT.getName());
        fillAction(p -> PAGE_TIMEOUT = new Timeout(parseInt(p)), "timeout.wait.page");
        fillAction(p -> DOMAIN = p, "domain");
        if (DRIVER_NAME.equals(DEFAULT_DRIVER))
            fillAction(p -> DRIVER_NAME = p, DRIVER.getName());
        fillAction(p -> DRIVER_VERSION = p.equalsIgnoreCase(LATEST_VERSION)
                ? LATEST_VERSION : (p.equalsIgnoreCase(PRELATEST_VERSION))
                ? PRELATEST_VERSION : p, DRIVERS_VERSION.getName());
        fillAction(p -> DRIVERS_FOLDER = p, DRIVERS_FOLDER_PATH.getName());
        fillAction(p -> SCREEN_PATH = p, "screens.folder");
        // TODO fillAction(p -> asserter.doScreenshot(p), "screenshot.strategy");
        fillAction(p -> logger.setScreenshotStrategy(p), "screenshot.strategy");
        fillAction(p -> KILL_BROWSER = p, "browser.kill");
        fillAction(WebSettings::setSearchStrategy, "element.search.strategy");
        fillAction(p -> BROWSER_SIZE = p, "browser.size");
        fillAction(p -> PAGE_LOAD_STRATEGY = getPageLoadStrategy(p), "page.load.strategy");
        fillAction(p -> CHECK_AFTER_OPEN = parse(p), "page.check.after.open");
        fillAction(SoftAssert::setAssertType, "assert.type");

        // RemoteWebDriver properties
        fillAction(p -> DRIVER_REMOTE_URL = p, "driver.remote.url");
        fillAction(p -> logger.setLogLevel(parseLogLevel(p)), "log.level");
        fillAction(p -> SMART_SEARCH_LOCATORS =
                filter(p.split(";"), l -> isNotBlank(l)), SMART_LOCATORS.getName());

        loadCapabilities(CHROME_CAPABILITIES_PATH.getName(),
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_CHROME.put(key.toString(),value.toString())));
        loadCapabilities(FF_CAPABILITIES_PATH.getName(),
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_FF.put(key.toString(),value.toString())));
        loadCapabilities(IE_CAPABILITIES_PATH.getName(),
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_IE.put(key.toString(),value.toString())));

        INIT_THREAD_ID = Thread.currentThread().getId();
        SMART_SEARCH_LOCATORS.add("#%s"/*, "[ui=%s]", "[qa=%s]", "[name=%s]"*/);
    }
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

    private static void loadCapabilities(String property, JAction1<Properties> setCapabilities) {
        String path = "";
        try { path = getProperty(property);
        } catch (Exception ignore) { }
        if(isNotEmpty(path)) {
            setCapabilities.execute(getProperties(path));
        }
    }

    private static void setSearchStrategy(String p) {
        String paramString = p.toLowerCase();
        if (("soft").equals(paramString)) {
            paramString = "any, multiple";
        } else if (("strict").equals(paramString)) {
            paramString = "visible, single";
        }

        String[] params = paramString.split(",");

        if (params.length != 2) {
            exception("You must specify exact two parameters, " +
                    "or use 'soft' or 'strict' as shortcats for 'any, multiple' and 'visible, single'");
        }

        String visibilityParam = params[0].trim();
        String searchTypeParam = params[1].trim();

        handleVisibilityParam(visibilityParam);
        handleSearchTypeParam(searchTypeParam);
    }

    private static void handleVisibilityParam(String param) {
        if ("visible".equals(param) || "displayed".equals(param)) {
            onlyVisible();
        } else if ("any".equals(param) || "all".equals(param)) {
            noValidation();
        } else if ("enabled".equals(param)) {
            visibleEnabled();
        } else if ("inview".equals(param)) {
            inView();
        } else {
            exception("%s is not correct visibility parameter", param);
        }
    }

    private static void handleSearchTypeParam(String param) {
        if ("single".equals(param)) {
            STRICT_SEARCH = true;
        } else if ("multiple".equals(param)) {
            STRICT_SEARCH = false;
        } else {
            exception("%s is not correct search type parameter", param);
        }
    }

    private static PageLoadStrategy getPageLoadStrategy(String strategy) {
        switch (strategy.toLowerCase()) {
            case "normal": return NORMAL;
            case "none": return NONE;
            case "eager": return EAGER;
            default: return NORMAL;
        }
    }
    public static Properties getProperties(String path) {
        // TODO use mergePath macos and windows
        Properties p = PropertyReader.getProperties("/../../target/classes/" + path);
        return p.size() > 0 ? p : PropertyReader.getProperties(path);
    }
}
