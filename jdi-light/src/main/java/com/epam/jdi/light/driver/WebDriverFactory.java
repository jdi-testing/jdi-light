package com.epam.jdi.light.driver;

import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.get.DriverData.DEFAULT_DRIVER;
import static com.epam.jdi.light.driver.get.DriverTypes.CHROME;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebDriverFactory {
    private WebDriverFactory() { }

    public static MapArray<String, JFunc<WebDriver>> DRIVERS
        = new MapArray<>(DEFAULT_DRIVER, () -> initDriver(CHROME));
    public static boolean SINGLE_THREAD = false;
    private static MapArray<String, WebDriver> RUN_DRIVERS = new MapArray<>();
    private static Safe<MapArray<String, WebDriver>> THREAD_RUN_DRIVERS
        = new Safe<>(MapArray::new);

    public static boolean noRunDrivers() {
        return !getRunDrivers().any();
    }
    private static MapArray<String, WebDriver> getRunDrivers() {
        logger.debug("SINGLE_THREAD=" + SINGLE_THREAD);
        return SINGLE_THREAD
            ? RUN_DRIVERS
            : THREAD_RUN_DRIVERS.get();
    }
    private static void setRunDrivers(MapArray<String, WebDriver> map) {
        if (SINGLE_THREAD) {
            RUN_DRIVERS = map;
        } else {
            THREAD_RUN_DRIVERS.set(map);
        }
    }
    public static WebDriver getDriverByName(String driverName) {
        logger.debug("getDriverByName(%s)", driverName);
        Lock lock = new ReentrantLock();
        if (!SWITCH_THREAD && INIT_DRIVER != null && INIT_THREAD_ID != currentThread().getId()) {
            logger.debug("SWITCH_THREAD = true");
            setRunDrivers(map($(driverName, INIT_DRIVER)));
            SWITCH_THREAD = true;
            return INIT_DRIVER;
        }
        if (!DRIVERS.has(driverName)) {
            logger.debug("Has no driver");
            useDriver(driverName);
        }
        try {
            lock.lock();
            logger.debug("Lock");
            MapArray<String, WebDriver> rDrivers = getRunDrivers();
            if (rDrivers == null) {
                logger.debug("rDrivers == null");
                rDrivers = new MapArray<>();
            }
            if (!rDrivers.has(driverName)) {
                logger.debug("rDrivers has no " + driverName);
                WebDriver resultDriver = DRIVERS.get(driverName).invoke();
                rDrivers.add(driverName, resultDriver);
                setRunDrivers(rDrivers);
                logger.debug("setRunDrivers");
            }
            logger.debug("Get '%s' driver", driverName);
            WebDriver driver = rDrivers.get(driverName);
            logger.debug("Successs: " + driver);
            if (driver.toString().contains("(null)")) {
                logger.debug("driver contains (null)");
                driver = DRIVERS.get(driverName).invoke();
                rDrivers.update(driverName, driver);
                logger.debug("update rDrivers");
            }
            if (!SWITCH_THREAD && INIT_THREAD_ID == currentThread().getId()) {
                logger.debug("INIT_DRIVER = driver");
                INIT_DRIVER = driver;
            }
            logger.debug("driver.manage().timeouts()");
            driver.manage().timeouts().implicitlyWait(0, SECONDS);
            return driver;
        } catch (Throwable ex) {
            throw exception(ex, "Can't get driver; Thread: " + currentThread().getId() + LINE_BREAK +
                    format("Drivers: %s; Run: %s", DRIVERS, getRunDrivers()));
        } finally {
            lock.unlock();
        }
    }

    // REGISTER DRIVER
    public static String useDriver(JFunc<WebDriver> driver) {
        return useDriver("Driver" + (DRIVERS.size() + 1), driver);
    }

    public static String useDriver(String driverName) {
        return useDriver(driverName, () -> DRIVER.types.get(driverName).getDriver());
    }

    public static String useDriver(DriverTypes driverType) {
        return useDriver(driverType.name);
    }

    private static WebDriver initDriver(DriverTypes type) {
        if (!DRIVER.types.has(type.name)) {
            throw exception("Unknown driver: " + type);
        }
        WebDriver driver = DRIVER.types.get(type.name).getDriver();
        return DRIVER.setup.execute(driver);
    }

    // GET DRIVER
    public static String useDriver(DriverTypes driverType, JFunc<WebDriver> driver) {
        return useDriver(driverType.name, driver);
    }

    public static String useDriver(String driverName, JFunc<WebDriver> driver) {
        if (!DRIVERS.has(driverName))
            DRIVERS.add(driverName, driver);
        else
            throw exception("Can't register WebDriver '%s'. Driver with same name already registered", driverName);
        DRIVER.name = driverName;
        return driverName;
    }

    public static <T> T jsExecute(String script, Object... args) {
        return (T)((JavascriptExecutor) getDriver()).executeScript(script, args);
    }

    public static WebDriver getDriver() {
        try {
            if (isNotBlank(DRIVER.name))
                return getDriver(DRIVER.name);
            useDriver(CHROME);
            return getDriver(CHROME.name);
        } catch (Exception ex) {
            throw exception(ex, "Can't get WebDriver");
        }
    }

    public static long INIT_THREAD_ID = -1;
    public static boolean SWITCH_THREAD = false;
    public static WebDriver INIT_DRIVER;
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