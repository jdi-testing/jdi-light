package com.jdiai;

import com.epam.jdi.tools.Safe;
import com.jdiai.asserts.Condition;
import com.jdiai.asserts.ConditionTypes;
import com.jdiai.jsbuilder.ConsoleLogger;
import com.jdiai.jsbuilder.Slf4JLogger;
import com.jdiai.jswraper.DriverManager;
import com.jdiai.jswraper.JSSmart;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.tools.JsonUtils.getDouble;
import static com.jdiai.LoggerTypes.CONSOLE;
import static com.jdiai.LoggerTypes.SLF4J;
import static com.jdiai.jsbuilder.QueryLogger.LOGGER_NAME;
import static com.jdiai.jsbuilder.QueryLogger.logger;
import static com.jdiai.jswraper.JSWrappersUtils.NAME_TO_LOCATOR;
import static com.jdiai.jswraper.JSWrappersUtils.locatorsToBy;
import static com.jdiai.page.objects.PageFactory.initSite;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class JDI {
    public static Safe<WebDriver> DRIVER = new Safe<>(DriverManager::chromeDriver);
    public static String domain;
    public static int timeout = 10;
    public static ConditionTypes conditions = new ConditionTypes();

    public static WebDriver driver() {
        return DRIVER.get();
    }

    public static Object jsExecute(String script, Object... params) {
        return ((JavascriptExecutor) driver()).executeScript(script, params);
    }

    public static Object jsEvaluate(String script, Object... params) {
        return jsExecute("return " + script, params);
    }
    public static void refreshPage() {
        driver().navigate().refresh();
    }

    public static void navigateBack() {
        driver().navigate().back();
    }

    public static void navigateForward() {
        driver().navigate().forward();
    }

    public static String getTitle() { return (String) jsEvaluate("document.title;"); }

    public static String getUrl() { return (String) jsEvaluate("document.URL;"); }

    public static String getDomain() { return (String) jsEvaluate("document.domain;"); }

    public static double zoomLevel() {
        return getDouble(jsEvaluate("window.devicePixelRatio;"));
    }

    public static void makeScreenshot() {
        new WebPage()
            .setName(getTitle())
            .makeScreenshot();
    }

    private static boolean initialized = false;

    private static void init() {
        if (initialized) {
            return;
        }
        switch (LOGGER_TYPE) {
            case CONSOLE:
                logger = new ConsoleLogger(getLoggerName(CONSOLE));
                break;
            case SLF4J:
                logger = new Slf4JLogger(getLoggerName(SLF4J));
                break;
            default:
                logger = new ConsoleLogger(getLoggerName(CONSOLE));
                break;
        }
        initialized = true;
    }
    private static String getLoggerName(String name) {
        return format("%s(%s)", LOGGER_NAME, name);
    }

    public static void openSite(String url) {
        domain = url;
        openSite();
    }

    public static void openSite() {
        init();
        if (driver().getCurrentUrl().equals("data:,")) {
            openPage(domain);
        }
    }

    public static String LOGGER_TYPE = "console";

    public static void openSite(Class<?> cl) {
        init();
        initSite(cl);
        if (domain != null) {
            JDI.openSite();
        }
    }

    public static void openPage(String url) {
        init();
        String fullUrl = isNotEmpty(domain) && !url.contains("//")
            ? domain + url
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

    public static void waitFor(JS element, Condition... conditions) {
        element.waitFor(conditions);
    }

    public static JSSmart jsDriver() { return new JSSmart(JDI::driver); }
}
