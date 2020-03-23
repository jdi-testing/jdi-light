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

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.DriverInfos.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;
import static com.epam.jdi.tools.StringUtils.*;
import static com.epam.jdi.tools.map.MapArray.*;
import static com.epam.jdi.tools.pairs.Pair.*;
import static java.lang.String.format;
import static java.lang.Thread.*;
import static java.util.concurrent.TimeUnit.*;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebDriverFactory {
    private WebDriverFactory() { }

    public static MapArray<String, JFunc<WebDriver>> DRIVERS
        = new MapArray<>(DEFAULT_DRIVER, () -> initDriver(CHROME));
    private static MapArray<String, WebDriver> getRunDrivers() {
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
    public static boolean SINGLE_THREAD = false;
    private static MapArray<String, WebDriver> RUN_DRIVERS = new MapArray<>();
    private static Safe<MapArray<String, WebDriver>> THREAD_RUN_DRIVERS
        = new Safe<>(MapArray::new);

    public static boolean noRunDrivers() {
        return !getRunDrivers().any();
    }

    // REGISTER DRIVER
    public static String useDriver(JFunc<WebDriver> driver) {
        return useDriver("Driver" + (DRIVERS.size() + 1), driver);
    }

    public static String useDriver(String driverName) {
        return useDriver(getByName(driverName));
    }

    public static String useDriver(DriverTypes driverType) {
        return useDriver(driverType, () -> initDriver(driverType));
    }

    private static WebDriver initDriver(DriverTypes type) {
        if (!DRIVER_TYPES.has(type.name)) {
            throw exception("Unknown driver: " + type);
        }
        WebDriver driver = DRIVER_TYPES.get(type.name).getDriver();
        return DRIVER_SETTINGS.execute(driver);
    }

    // GET DRIVER
    public static String useDriver(DriverTypes driverType, JFunc<WebDriver> driver) {
        String driverName = driverType.name;
        if (DRIVERS.has(driverName))
            driverName = driverName + System.currentTimeMillis();
        DRIVERS.add(driverName, driver);
        DRIVER_NAME = driverName;
        return driverName;
    }

    public static String useDriver(String driverName, JFunc<WebDriver> driver) {
        if (!DRIVERS.has(driverName))
            DRIVERS.add(driverName, driver);
        else
            throw exception("Can't register WebDriver '%s'. Driver with same name already registered", driverName);
        DRIVER_NAME = driverName;
        return driverName;
    }

    public static <T> T jsExecute(String script, Object... args) {
        return (T)((JavascriptExecutor) getDriver()).executeScript(script, args);
    }

    public static WebDriver getDriver() {
        try {
            if (isNotBlank(DRIVER_NAME))
                return getDriver(DRIVER_NAME);
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
        if (!SWITCH_THREAD && INIT_DRIVER != null && INIT_THREAD_ID != currentThread().getId()) {
            setRunDrivers(map($(driverName, INIT_DRIVER)));
            SWITCH_THREAD = true;
            return INIT_DRIVER;
        }
        if (!DRIVERS.has(driverName))
            useDriver(driverName);
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            MapArray<String, WebDriver> rDrivers = getRunDrivers();
            if (rDrivers == null) {
                rDrivers = new MapArray<>();
            }
            if (!rDrivers.has(driverName)) {
                WebDriver resultDriver = DRIVERS.get(driverName).invoke();
                rDrivers.add(driverName, resultDriver);
                setRunDrivers(rDrivers);
            }
            WebDriver driver = rDrivers.get(driverName);
            if (driver.toString().contains("(null)")) {
                driver = DRIVERS.get(driverName).invoke();
                rDrivers.update(driverName, driver);
            }
            if (!SWITCH_THREAD && INIT_THREAD_ID == currentThread().getId())
                INIT_DRIVER = driver;
            driver.manage().timeouts().implicitlyWait(0, SECONDS);
            return driver;
        } catch (Throwable ex) {
            throw exception(ex, "Can't get driver; Thread: " + currentThread().getId() + LINE_BREAK +
                format("Drivers: %s; Run: %s", DRIVERS, getRunDrivers()));
        } finally {
            lock.unlock();
        }
    }

    public static JavascriptExecutor getJSExecutor() {
        if (getDriver() instanceof JavascriptExecutor)
            return (JavascriptExecutor) getDriver();
        else
            throw new ClassCastException("JavaScript Executor doesn't support");
    }

    public static void reopenDriver() {
        reopenDriver(DRIVER_NAME);
    }

    public static void reopenDriver(String driverName) {
        MapArray<String, WebDriver> rDriver = getRunDrivers();
        if (rDriver.has(driverName)) {
            rDriver.get(driverName).close();
            rDriver.removeByKey(driverName);
            setRunDrivers(rDriver);
        }
        if (DRIVERS.has(driverName))
            getDriver();
    }

    public static void switchToDriver(String driverName) {
        if (DRIVERS.has(driverName))
            DRIVER_NAME = driverName;
        else
            throw exception("Can't switch to WebDriver '%s'. This Driver name not registered", driverName);
    }

    public static void close() {
        for (Pair<String, WebDriver> pair : getRunDrivers())
            try {
                pair.value.quit();
            } catch (Exception ignore) { }
        getRunDrivers().clear();
    }

    public static void quit() {
        close();
    }
}