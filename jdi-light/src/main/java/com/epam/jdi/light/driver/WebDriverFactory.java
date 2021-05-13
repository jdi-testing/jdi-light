package com.epam.jdi.light.driver;

import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.*;
import static com.epam.jdi.light.driver.get.DriverTypes.CHROME;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.safeException;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.Thread.currentThread;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebDriverFactory {
    public static boolean MULTI_THREAD = false;
    public static MapArray<String, JFunc<WebDriver>> DRIVERS = new MapArray<>();
    public static final MapArray<String, WebDriver> RUN_DRIVERS = new MapArray<>();
    private static final Safe<MapArray<String, WebDriver>> THREAD_RUN_DRIVERS = new Safe<>(MapArray::new);
    public static boolean GETTING_DRIVER = false;

    private WebDriverFactory() { }

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
    private static WebDriver registerNewDriver(String driverName, WebDriver driver, MapArray<String, WebDriver> drivers) {
        logger.trace("registerNewDriver >> " + driver);
        drivers.update(driverName, driver);
        return driver;
    }
    private static WebDriver registerNewDriver(String driverName, MapArray<String, WebDriver> drivers) {
        Lock locker = new ReentrantLock();
        locker.lock();
        try {
            if (!DRIVERS.has(driverName) && DRIVER.types.has(driverName))
                useDriver(driverName, () -> DRIVER.types.get(driverName).getDriver());
            if (!DRIVERS.has(driverName))
                throw exception("Can't get driver '%s'. Please use drivers from JDISettings.DRIVER.types list. " +
                    "Or add your own driver with WebDriverFactory.useDriver(name,() -> WebDriver) method.");
            WebDriver driver = getValidDriver(driverName);
            driver = DRIVER.setup.execute(driver);
            registerNewDriver(driverName, driver, drivers);
            return driver;
        } catch (Exception ex) {
            throw exception(ex, "Can't run and register new driver '%s'", driverName);
        } finally {
            locker.unlock();
        }
    }
    private static WebDriver getValidDriver(String driverName) {
        boolean goodDriver = false;
        WebDriver driver = null;
        Timer timer = new Timer(10);
        while (!goodDriver && timer.isRunning()) {
            try {
                if (driver != null) {
                    driver.quit();
                }
                logger.trace("getValidDriver: Getting driver...");
                driver = DRIVERS.get(driverName).execute();
                goodDriver = isNotBlank(driver.getCurrentUrl());
                logger.trace("getValidDriver: Get driver success");
            } catch (Throwable ignore) {
                logger.trace("getValidDriver: Get driver failed");
            }
        }
        return driver;
    }
    public static WebDriver getDriverByName(String driverName) {
        if (GETTING_DRIVER) {
            waitMultiThread();
            return DRIVER.getFunc.execute(driverName);
        }
        GETTING_DRIVER = true;
        try {
            return getDriverFromName(driverName, RUN_DRIVERS);
        } catch (Exception ex) {
            throw getDriverException(driverName,ex);
        } finally {
            if (MULTI_THREAD) {
                switchToMultiThread(driverName);
            }
            GETTING_DRIVER = false;
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
    public static void waitMultiThread() {
        MULTI_THREAD = true;
        Timer timer = new Timer(TIMEOUTS.page.get() * 1000L);
        while (GETTING_DRIVER && timer.isRunning()) { }
    }

    public static WebDriver getDriverFromName(String driverName, MapArray<String, WebDriver> drivers) {
        WebDriver driver = isNotEmpty(drivers) && drivers.has(driverName)
            ? drivers.get(driverName)
            : registerNewDriver(driverName, drivers);
        logger.trace("DRIVER >> " + (driver == null ? "NULL" : driver.toString()));
        return driver;
    }
    public static WebDriver getMultiThreadDriver(String driverName) {
        logger.trace("getMultiThreadDriver");
        MapArray<String, WebDriver> drivers = THREAD_RUN_DRIVERS.get();
        WebDriver driver = null;
        if (isNotEmpty(drivers) && drivers.has(driverName)) {
            driver = drivers.get(driverName);
        } else {
            try {
                driver = registerNewDriver(driverName, drivers);
                THREAD_RUN_DRIVERS.set(drivers);
            } catch (Exception ex) {
                logger.trace("!!!!" + currentThread().getId() + ": " + safeException(ex));
            }
        }
        logger.trace("DRIVER >> " + (driver == null ? "NULL" : driver.toString()));
        return driver;
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
        return (T) getJSExecutor().executeScript(script, args);
    }

    public static WebDriver getDriver() {
        String driverName = isNotBlank(DRIVER.name) ? DRIVER.name : CHROME.name;
        try {
            return getDriver(driverName);
        } catch (Exception ex) {
            throw exception(ex, "Can't get WebDriver: " + driverName);
        }
    }

    public static WebDriver getDriver(String driverName) {
        try {
            return DRIVER.getFunc.execute(driverName);
        } catch (Exception ex) {
            throw exception(ex, "Can't get WebDriver: " + driverName);
        }
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
            driver.quit();
        } catch (Exception ignore) { }
    }

    public static void quit() {
        close();
    }
}