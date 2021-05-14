package com.jdiai;

import com.epam.jdi.tools.Safe;
import com.jdiai.jsbuilder.ConsoleLogger;
import com.jdiai.jsbuilder.Slf4JLogger;
import com.jdiai.jswraper.DriverManager;
import com.jdiai.jswraper.JSSmart;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.tools.JsonUtils.getDouble;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static com.jdiai.LoggerTypes.CONSOLE;
import static com.jdiai.LoggerTypes.SLF4J;
import static com.jdiai.jsbuilder.QueryLogger.LOGGER_NAME;
import static com.jdiai.jsbuilder.QueryLogger.logger;
import static com.jdiai.jswraper.JSWrappersUtils.NAME_TO_LOCATOR;
import static com.jdiai.jswraper.JSWrappersUtils.locatorsToBy;
import static com.jdiai.page.objects.PageFactory.initSite;

public class JDI {
    public static Safe<WebDriver> DRIVER = new Safe<>(DriverManager::chromeDriver);
    public static String DOMAIN;

    public static WebDriver driver() {
        return DRIVER.get();
    }
    public static Object jsExecute(String script, Object... params) {
        return ((JavascriptExecutor) driver()).executeScript(script, params);
    }
    public static String getTitle() { return (String) jsExecute("document.title"); }
    public static String getUrl() { return (String) jsExecute("document.URL"); }
    public static String getDomain() { return (String) jsExecute("document.domain"); }
    public static double zoomLevel() {
        return getDouble(jsExecute("return window.devicePixelRatio;"));
    }
    private static boolean initialized = false;
    private static void init() {
        if (initialized) {
            return;
        }
        switch (LOGGER_TYPE) {
            case CONSOLE:
                logger = new ConsoleLogger(LOGGER_NAME + ": " + CONSOLE);
                break;
            case SLF4J:
                logger = new Slf4JLogger(LOGGER_NAME + ": " + SLF4J);
                break;
            default:
                logger = new ConsoleLogger(LOGGER_NAME + ": " + CONSOLE);
                break;
        }
        initialized = true;
    }
    public static void openSite(String url) {
        DOMAIN = url;
        openSite();
    }
    public static void openSite() {
        init();
        if (driver().getCurrentUrl().equals("data:,")) {
            openPage(DOMAIN);
        }
    }
    public static String LOGGER_TYPE = "console";
    public static void openSite(Class<?> cl) {
        init();
        initSite(cl);
        if (DOMAIN != null) {
            JDI.openSite();
        }
    }
    public static void openPage(String url) {
        init();
        String fullUrl = isNotEmpty(DOMAIN) && !url.contains("//")
            ? DOMAIN + url
            : url;
        logger.info("Open page '" + fullUrl + "'");
        driver().get(fullUrl);
    }
    public static JS $(By locator) {
        return new JS(JDI::driver, locator);
    }
    public static JS $(By... locators) {
        return new JS(JDI::driver, locators);
    }
    public static JS $(String locator) {
        return new JS(JDI::driver, NAME_TO_LOCATOR.execute(locator));
    }
    public static JS $(String... locators) {
        return new JS(JDI::driver, locatorsToBy(locators));
    }
    public static void loginAs(String formLocator, Object user) {
        $(formLocator).loginAs(user);
    }
    public static void loginAs(Object user) {
        new JS(JDI::driver).loginAs(user);
    }
    public static void submitForm(String formLocator, Object user) {
        $(formLocator).submit(user);
    }
    public static void submitForm(Object user) {
        new JS(JDI::driver).submit(user);
    }
    public static void fillFormWith(String formLocator, Object user) {
        $(formLocator).fill(user);
    }
    public static void fillFormWith(Object user) {
        new JS(JDI::driver).fill(user);
    }
    public static DragAndDrop drag(JS dragElement) { return new DragAndDrop(dragElement);}

    public static JSSmart jsDriver() { return new JSSmart(JDI::driver); }
}
