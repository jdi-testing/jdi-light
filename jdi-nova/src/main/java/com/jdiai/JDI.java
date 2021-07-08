package com.jdiai;

import com.epam.jdi.tools.ILogger;
import com.epam.jdi.tools.Safe;
import com.jdiai.asserts.Condition;
import com.jdiai.asserts.ConditionTypes;
import com.jdiai.jsbuilder.ConsoleLogger;
import com.jdiai.jsbuilder.QueryLogger;
import com.jdiai.jsbuilder.Slf4JLogger;
import com.jdiai.jswraper.JSSmart;
import com.jdiai.jswraper.driver.DriverManager;
import com.jdiai.jswraper.driver.DriverTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.function.BiFunction;

import static com.epam.jdi.tools.JsonUtils.getDouble;
import static com.jdiai.LoggerTypes.CONSOLE;
import static com.jdiai.LoggerTypes.SLF4J;
import static com.jdiai.jsbuilder.QueryLogger.LOGGER_NAME;
import static com.jdiai.jsbuilder.QueryLogger.LOG_QUERY;
import static com.jdiai.jsdriver.JDINovaException.assertContains;
import static com.jdiai.jswraper.JSWrappersUtils.NAME_TO_LOCATOR;
import static com.jdiai.jswraper.JSWrappersUtils.locatorsToBy;
import static com.jdiai.jswraper.driver.DriverManager.useDriver;
import static com.jdiai.jswraper.driver.JDIDriver.DRIVER_OPTIONS;
import static com.jdiai.page.objects.PageFactory.initSite;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class JDI {
    public static Safe<WebDriver> DRIVER = new Safe<>(DriverManager::getDriver);

    public static String domain;
    public static ILogger logger;

    public static int timeout = 10;

    public static ConditionTypes conditions = new ConditionTypes();

    public static void logJSRequests(int logQueriesLevel) {
        LOG_QUERY = logQueriesLevel;
    }

    public static WebDriver driver() {
        return DRIVER.get();
    }

    public static BiFunction<Object, Exception, Boolean> IGNORE_FAILURE = (js, e) -> true;

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

    public static String getUrl() {
        return (String) jsEvaluate("document.URL;");
    }

    public static void urlShouldBe(String url) {
        assertContains("Url", getUrl(), url);
    }

    public static String getTitle() {
        return (String) jsEvaluate("document.title;");
    }

    public static void titleShouldContains(String title) {
        assertContains("Title", getTitle(), title);
    }

    public static String getDomain() { return (String) jsEvaluate("document.domain;"); }

    public static double zoomLevel() {
        return getDouble(jsEvaluate("window.devicePixelRatio;"));
    }

    public static File makeScreenshot(String name) {
        return new WebPage().setName(name).makeScreenshot();
    }

    public static File makeScreenshot() {
        return new WebPage().setName(getTitle()).makeScreenshot();
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
                logger = new Slf4JLogger(LOGGER_NAME);
                break;
            default:
                logger = new ConsoleLogger(getLoggerName(CONSOLE));
                break;
        }
        QueryLogger.logger = logger;
        initialized = true;
    }
    private static String getLoggerName(String name) {
        return format("%s(%s)", LOGGER_NAME, name);
    }

    public static void openIn(DriverTypes driver) {
        useDriver(driver);
        openSite();
    }
    public static void openIn(DriverTypes driver, String url) {
        useDriver(driver);
        openSite(url);
    }

    public static void openSite(String url) {
        domain = url;
        openSite();
    }

    public static void openSite() {
        init();
        openPage(domain);
    }
    public static void openSite(int width, int height) {
        openSite();
        driver().manage().window().setSize(new Dimension(width, height));
    }

    public static void openSiteHeadless() {
        DRIVER_OPTIONS.chrome = cap -> cap.addArguments("--headless");
        openSite();
    }
    public static void openSiteHeadless(int width, int height) {
        openSiteHeadless();
        driver().manage().window().setSize(new Dimension(width, height));
    }

    public static void reopenSite() {
        init();
        if (DRIVER.hasValue()) {
            driver().quit();
        }
        DRIVER.reset();
        openPage(domain);
    }

    public static void reopenSite(int width, int height) {
        reopenSite();
        driver().manage().window().setSize(new Dimension(width, height));
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

    public static JS $(Object parent, By locator) {
        return new JS(JDI::driver, locator, parent);
    }

    public static JS $(By... locators) {
        return new JS(JDI::driver, locators);
    }

    public static JS $(String locator) {
        return new JS(JDI::driver, NAME_TO_LOCATOR.apply(locator));
    }

    public static JS $(Object parent, String locator) {
        return new JS(JDI::driver, NAME_TO_LOCATOR.apply(locator), parent);
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
