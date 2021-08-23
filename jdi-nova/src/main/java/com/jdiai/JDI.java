package com.jdiai;

import com.epam.jdi.tools.ILogger;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.StringUtils;
import com.jdiai.annotations.UI;
import com.jdiai.asserts.Condition;
import com.jdiai.asserts.ConditionTypes;
import com.jdiai.jsbuilder.ConsoleLogger;
import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsbuilder.JSBuilder;
import com.jdiai.jsbuilder.Slf4JLogger;
import com.jdiai.jsbuilder.jsfunctions.*;
import com.jdiai.jswraper.JSBaseEngine;
import com.jdiai.jswraper.JSEngine;
import com.jdiai.jswraper.driver.DriverManager;
import com.jdiai.jswraper.driver.DriverTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.epam.jdi.tools.JsonUtils.getDouble;
import static com.epam.jdi.tools.LinqUtils.newList;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.getFieldsDeep;
import static com.epam.jdi.tools.StringUtils.format;
import static com.jdiai.LoggerTypes.CONSOLE;
import static com.jdiai.LoggerTypes.SLF4J;
import static com.jdiai.jsbuilder.GetTypes.dataType;
import static com.jdiai.jsbuilder.QueryLogger.*;
import static com.jdiai.jsdriver.JDINovaException.assertContains;
import static com.jdiai.jsdriver.JSDriverUtils.getByLocator;
import static com.jdiai.jswraper.JSWrappersUtils.*;
import static com.jdiai.jswraper.driver.DriverManager.useDriver;
import static com.jdiai.jswraper.driver.JDIDriver.DRIVER_OPTIONS;
import static com.jdiai.page.objects.PageFactory.initSite;
import static com.jdiai.page.objects.PageFactoryUtils.getLocatorFromField;
import static com.jdiai.tools.WindowsManager.getWindows;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class JDI {
    public static Safe<WebDriver> DRIVER = new Safe<>(DriverManager::getDriver);

    public static String JDI_STORAGE = "src/test/resources/jdi";

    public static String domain;

    public static ILogger logger() {
        return logger;
    }
    public static void setLogger(ILogger newLogger) {
        logger = newLogger;
    }

    public static int timeout = 10;

    public static ConditionTypes findFilters = new ConditionTypes();

    public static String SELECT_FIND_TEXT_LOCATOR = ".//*[text()='%s']";

    public static Function<List<By>, JS> initJSFunc = locators -> new JSStable(JDI::driver, locators);

    public static Function<List<By>, JS> initCoreFunc = initJSFunc;

    public static Function<Supplier<WebDriver>, IJSBuilder> initBuilder = driver -> {
        BuilderFunctions bf = new BuilderFunctions().set(f -> {
            f.oneToOne = JSOneToOne.ONE_TO_ONE;
            f.oneToOneFilter = JSOneToOne.STRICT_ONE_TO_ONE;

            f.oneToList = JSOneToList.ONE_TO_LIST;
            f.oneToListFilter = JSOneToList.FILTER_ONE_TO_LIST;

            f.listToOne = JSListToOne.LIST_TO_ONE;
            f.listToOneFilter = JSListToOne.FILTER_LIST_TO_ONE;

            f.listToList = JSListToList.ONE_LIST_TO_LIST;
            f.listToListFilter = JSListToList.FILTER_ONE_LIST_TO_LIST;

            f.result = JSResults.ONE_TO_RESULT;
            f.listResult = JSResults.LIST_TO_RESULT;
            f.action = JSResults.ONE_TO_ACTION;
            f.listAction = JSResults.LIST_TO_ACTION;
        });
        return new JSBuilder(driver, bf);
    };

    public static BiFunction<Supplier<WebDriver>, List<By>, JSEngine> initEngine =
        (driver, locators) -> new JSBaseEngine(driver, locators, initBuilder.apply(driver));

    public static BiFunction<Object, Exception, Boolean> IGNORE_FAILURE = (js, e) -> true;

    public static String LOGGER_TYPE = "console";

    public static boolean LOG_ACTIONS = true;

    private static boolean initialized = false;

    public static Function<Field, String> GET_COMPLEX_VALUE = field -> {
        if (!field.isAnnotationPresent(FindBy.class) && !field.isAnnotationPresent(UI.class)) {
            return null;
        }
        By locator = getLocatorFromField(field);
        if (locator != null) {
            String element = MessageFormat.format(dataType(locator).get, "element", getByLocator(locator));
            return StringUtils.format("'%s': %s", field.getName(), getValueType(field, element));
        }
        return null;
    };

    public static BiFunction<Field, Object, String> SET_COMPLEX_VALUE = (field, value)-> {
        if (!field.isAnnotationPresent(FindBy.class) && !field.isAnnotationPresent(UI.class))
            return null;
        By locator = getLocatorFromField(field);
        if (locator == null) {
            return null;
        }
        String element = MessageFormat.format(dataType(locator).get, "element", getByLocator(locator));
        return setValueType(field, element, value);
    };

    public static Function<Class<?>, String> GET_OBJECT_MAP = cl -> {
        List<Field> allFields = getFieldsDeep(cl);
        List<String> mapList = new ArrayList<>();
        for (Field field : allFields) {
            String value = GET_COMPLEX_VALUE.apply(field);
            if (value != null) {
                mapList.add(value);
            }
        }
        return "{ " + print(mapList, ", ") + " }";
    };
    public static String SUBMIT_LOCATOR = "[type=submit]";

    private static Safe<Integer> savedLogLevel = new Safe<>(() -> null);

    public static void loggerOff() {
        if (savedLogLevel.get() == null) {
            savedLogLevel.set(LOG_QUERY.get());
            logJSRequests(OFF);
        }
    }

    public static void logJSRequests(int logQueriesLevel) {
        LOG_QUERY.set(logQueriesLevel);
    }

    public static void loggerOn() {
        Integer logLevel = savedLogLevel.get();
        if (logLevel != null) {
            logJSRequests(logLevel);
            savedLogLevel.set(null);
        }
    }

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

    private static void init() {
        if (initialized) {
            return;
        }
        switch (LOGGER_TYPE) {
            case CONSOLE:
                setLogger(new ConsoleLogger(getLoggerName(CONSOLE)));
                break;
            case SLF4J:
                setLogger(new Slf4JLogger(LOGGER_NAME));
                break;
            default:
                setLogger(new ConsoleLogger(getLoggerName(CONSOLE)));
                break;
        }
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

    public static void reopenSite(Class<?> cl) {
        initSite(cl);
        reopenSite();
    }

    public static void reopenSite(int width, int height) {
        reopenSite();
        driver().manage().window().setSize(new Dimension(width, height));
    }

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
        logger().info("Open page '" + fullUrl + "'");
        driver().get(fullUrl);
        getWindows();
    }

    public static JS $(By locator) {
        return initJSFunc.apply(newList(locator));
    }

    public static JS $(By... locators) {
        return initJSFunc.apply(newList(locators));
    }

    public static JS $(String locator) {
        return $(NAME_TO_LOCATOR.apply(locator));
    }

    public static JS $(String... locators) {
        return $(locatorsToBy(locators));
    }

    public static void loginAs(String formLocator, Object user) {
        $(formLocator).loginAs(user);
    }

    public static void loginAs(Object user) {
        initJSFunc.apply(null).loginAs(user);
    }

    public static void submitForm(String formLocator, Object user) {
        $(formLocator).submit(user);
    }

    public static void submitForm(Object user) {
        initJSFunc.apply(null).submit(user);
    }

    public static void fillFormWith(String formLocator, Object user) {
        $(formLocator).fill(user);
    }

    public static void fillFormWith(Object user) {
        initJSFunc.apply(null).fill(user);
    }

    public static DragAndDrop drag(JS dragElement) { return new DragAndDrop(dragElement);}

    public static void waitFor(JS element, Condition... conditions) {
        element.waitFor(conditions);
    }

    public static JSEngine jsDriver() { return initEngine.apply(JDI::driver, new ArrayList<>()); }
}
