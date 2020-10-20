package com.epam.jdi.light.driver;

import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.*;
import static com.epam.jdi.light.driver.get.DriverTypes.CHROME;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.Thread.*;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebDriverFactory {
    private WebDriverFactory() { }

    public static boolean MULTI_THREAD = false;
    public static MapArray<String, JFunc<WebDriver>> DRIVERS = new MapArray<>();
    public static final MapArray<String, WebDriver> RUN_DRIVERS = new MapArray<>();
    private static final Safe<MapArray<String, WebDriver>> THREAD_RUN_DRIVERS = new Safe<>(MapArray::new);

    public static boolean noRunDrivers() {
        return !hasRunDrivers();
    }
    public static boolean hasRunDrivers() {
        return getRunDrivers().any();
    }
    private static MapArray<String, WebDriver> getRunDrivers() {
        MapArray<String, WebDriver> list = MULTI_THREAD
            ? THREAD_RUN_DRIVERS.get()
            : RUN_DRIVERS;
        logger.trace("List size: " + list.size());
        if (list.isNotEmpty())
            logger.trace("Driver:" + list.keys());
        return list;
    }
    private static void setRunDrivers(MapArray<String, WebDriver> map) {
        if (MULTI_THREAD) {
            THREAD_RUN_DRIVERS.set(map);
        } else {
            RUN_DRIVERS.clear();
            RUN_DRIVERS.addAll(map);
        }
    }
    private static WebDriver getFromDriverInfo(String driverName) {
        WebDriver driver = DRIVER.types.get(driverName).getDriver();
        DRIVERS.add(driverName, () -> driver);
        return driver;
    }
    private static WebDriver registerNewDriver(String driverName, WebDriver driver, MapArray<String, WebDriver> drivers) {
        drivers.add(driverName, driver);
        return driver;
    }
    private static WebDriver registerNewDriver(String driverName, MapArray<String, WebDriver> drivers) {
        WebDriver driver = null;
        if (DRIVERS.has(driverName)) {
            driver = DRIVERS.get(driverName).execute();
        }
        else {
            if (DRIVER.types.has(driverName)) {
                driver = getFromDriverInfo(driverName);
            }
        }
        if (driver == null) {
            throw exception("Can't get driver '%s'. Please use drivers from JDISettings.DRIVER.types list. " +
                "Or add your own driver with WebDriverFactory.useDriver(name,() -> WebDriver) method.");
        }
        return registerNewDriver(driverName, driver, drivers);
    }
    private static boolean gettingDriver = false;
    public static WebDriver getDriverByName(String driverName) {
        if (gettingDriver) {
            waitMultiThread();
            return DRIVER.getFunc.execute(driverName);
        }
        gettingDriver = true;
        try {
            return getDriverFromName(driverName, RUN_DRIVERS);
        } catch (Exception ex) {
            throw getDriverException(driverName,ex);
        } finally {
            if (MULTI_THREAD)
                switchToMultiThread(driverName);
            gettingDriver = false;
        }
    }
    private static void switchToMultiThread(String driverName) {
        logger.trace("[MultiThread] " + driverName);
        DRIVER.getFunc = WebDriverFactory::getMultiThreadDriver;
        THREAD_RUN_DRIVERS.set(RUN_DRIVERS);
    }
    private static RuntimeException getDriverException(String driverName, Exception ex) {
        String threadInfo = MULTI_THREAD ? " [" + currentThread().getId()+ "]" : "";
        return driverDownloaded
            ? exception(ex, "Failed to run downloaded driver %s%s. " +
                "Please check that your browser and driver are compatible or use local driver with 'drivers.folder' property in test.properties'."
                + LINE_BREAK + "DriverPath: " + driverPath,
                downloadedDriverInfo, threadInfo)
            : exception(ex, "Failed to Run driver '%s'%s from driverPath = %s", driverName, threadInfo, DRIVER.path);
    }
    private static void waitMultiThread() {
        MULTI_THREAD = true;
        Timer timer = new Timer(TIMEOUTS.page.get() * 1000);
        while (gettingDriver && !timer.timeoutPassed()) { }
    }

    public static WebDriver getDriverFromName(String driverName, MapArray<String, WebDriver> drivers) {
        return drivers.size() > 0 && drivers.has(driverName)
            ? drivers.get(driverName)
            : registerNewDriver(driverName, drivers);
    }
    public static WebDriver getMultiThreadDriver(String driverName) {
        MapArray<String, WebDriver> drivers = THREAD_RUN_DRIVERS.get();
        if (drivers.size() == 0 || !drivers.has(driverName)) {
            registerNewDriver(driverName, drivers);
            THREAD_RUN_DRIVERS.set(drivers);
        }
        return drivers.get(driverName);
    }

    // REGISTER DRIVER
    public static String useDriver(JFunc<WebDriver> driver) {
        return useDriver("Driver" + (DRIVERS.size() + 1), driver);
    }

    public static String useDriver(String driverName) {
        DRIVER.name = driverName;
        return driverName;
    }

    public static String useDriver(DriverTypes driverType) {
        return useDriver(driverType.name);
    }

    private static WebDriver initDriver(DriverTypes type) {
        if (!DRIVER.types.has(type.name)) {
            throw exception("Unknown driver: " + type);
        }
        WebDriver driver = getFromDriverInfo(type.name);
        return DRIVER.setup.execute(driver);
    }

    // GET DRIVER
    public static String useDriver(DriverTypes driverType, JFunc<WebDriver> driver) {
        return useDriver(driverType.name, driver);
    }

    public static String useDriver(String driverName, JFunc<WebDriver> driver) {
        DRIVERS.update(driverName, driver);
        DRIVER.name = driverName;
        return driverName;
    }

    public static <T> T jsExecute(String script, Object... args) {
        return (T)getJSExecutor().executeScript(script, args);
    }

    public static WebDriver getDriver() {
        try {
            String driverName = isNotBlank(DRIVER.name) ? DRIVER.name : CHROME.name;
            return getDriver(driverName);
        } catch (Exception ex) {
            throw exception(ex, "Can't get WebDriver");
        }
    }

    public static WebDriver getDriver(String driverName) {
        return DRIVER.getFunc.execute(driverName);
    }

    public static JavascriptExecutor getJSExecutor() {
        if (getDriver() instanceof JavascriptExecutor)
            return (JavascriptExecutor) getDriver();
        else
            throw new ClassCastException("JavaScript Executor doesn't support");
    }

    public static void reopenDriver() {
        reopenDriver(DRIVER.name);
    }

    public static void reopenDriver(String driverName) {
        MapArray<String, WebDriver> rDriver = getRunDrivers();
        if (rDriver.has(driverName)) {
            closeDriver(rDriver.get(driverName));
            rDriver.removeByKey(driverName);
            setRunDrivers(rDriver);
        }
        if (DRIVERS.has(driverName))
            getDriver();
    }

    public static void switchToDriver(String driverName) {
        if (DRIVERS.has(driverName))
            DRIVER.name = driverName;
        else
            throw exception("Can't switch to WebDriver '%s'. This Driver name not registered", driverName);
    }

    public static void close() {
        for (Pair<String, WebDriver> pair : getRunDrivers()) {
            closeDriver(pair.value);
        }
        getRunDrivers().clear();
    }

    private static void closeDriver(WebDriver driver) {
        try {
            driver.close();
            driver.quit();
        } catch (Exception ignore) { }
    }

    public static void quit() {
        close();
    }
}