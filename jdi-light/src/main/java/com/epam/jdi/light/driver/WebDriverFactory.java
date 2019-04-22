package com.epam.jdi.light.driver;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.light.driver.get.DriverData.DRIVER_SETTINGS;
import static com.epam.jdi.light.driver.get.DriverInfos.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;
import static com.epam.jdi.light.elements.base.DriverBase.DEFAULT_DRIVER;
import static com.epam.jdi.light.settings.WebSettings.DRIVER_REMOTE_URL;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.epam.jdi.tools.switcher.SwitchActions.Switch;
import static com.epam.jdi.tools.switcher.SwitchActions.Value;
import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class WebDriverFactory {
    public static MapArray<String, JFunc<WebDriver>> drivers = new MapArray<>(DEFAULT_DRIVER, () -> initDriver(CHROME));
    private static ThreadLocal<MapArray<String, WebDriver>> runDrivers = new ThreadLocal<>();

    private WebDriverFactory() {
    }

    public static boolean hasRunDrivers() {

        return runDrivers.get() != null && runDrivers.get().any();
    }

    // REGISTER DRIVER
    public static String useDriver(JFunc<WebDriver> driver) {
        return useDriver("Driver" + (drivers.size() + 1), driver);
    }

    public static String useDriver(String driverName) {
        return useDriver(getByName(driverName));
    }

    public static String useDriver(DriverTypes driverType) {
        return useDriver(driverType, () -> initDriver(driverType));
    }
    public static boolean isRemote() {
        return isNotEmpty(DRIVER_REMOTE_URL);
    }

    private static WebDriver initDriver(DriverTypes type) {
        WebDriver driver = Switch(type).get(
            Value(CHROME, t -> CHROME_INFO.getDriver()),
            Value(FIREFOX, t -> FF_INFO.getDriver()),
            Value(IE, t -> IE_INFO.getDriver()),
            Value(PHANTOMJS, t -> CHROME_INFO.getDriver()),
            Value(OPERA, t -> CHROME_INFO.getDriver()),
            Value(EDGE, t -> CHROME_INFO.getDriver())
        );
        if (driver == null)
            throw exception("Unknown driver: " + type);
        return DRIVER_SETTINGS.execute(driver);
    }

    // GET DRIVER
    public static String useDriver(DriverTypes driverType, JFunc<WebDriver> driver) {
        String driverName = driverType.name;
        if (drivers.has(driverName))
            driverName = driverName + System.currentTimeMillis();
        drivers.add(driverName, driver);
        DRIVER_NAME = driverName;
        return driverName;
    }

    public static String useDriver(String driverName, JFunc<WebDriver> driver) {
        if (!drivers.has(driverName))
            drivers.add(driverName, driver);
        else
            throw exception("Can't register WebDriver '%s'. Driver with same name already registered", driverName);
        DRIVER_NAME = driverName;
        return driverName;
    }

    public static void jsExecute(String script, Object... args) {
        ((JavascriptExecutor) getDriver()).executeScript(script, args);
    }

    public static WebDriver getDriver() {
        try {
            if (isNotBlank(DRIVER_NAME))
                return getDriver(DRIVER_NAME);
            useDriver(CHROME);
            return getDriver(CHROME.name);
        } catch (Exception ex) {
            throw exception("Can't get WebDriver. " + LINE_BREAK + ex.getMessage());
        }
    }

    public static long INIT_THREAD_ID = -1;
    public static boolean SWITCH_THREAD = false;
    public static WebDriver INIT_DRIVER;

    public static WebDriver getDriver(String driverName) {
        if (!SWITCH_THREAD && INIT_DRIVER != null && INIT_THREAD_ID != currentThread().getId()) {
            runDrivers.set(map($(driverName, INIT_DRIVER)));
            SWITCH_THREAD = true;
            return INIT_DRIVER;
        }
        if (!drivers.has(driverName))
            useDriver(driverName);
        try {
            Lock lock = new ReentrantLock();
            lock.lock();
            if (runDrivers.get() == null || !runDrivers.get().has(driverName)) {
                MapArray<String, WebDriver> rDrivers = runDrivers.get();
                if (rDrivers == null)
                    rDrivers = new MapArray<>();
                WebDriver resultDriver = drivers.get(driverName).invoke();
                if (resultDriver == null)
                    throw exception("Can't get WebDriver '%s'. This Driver name not registered", driverName);
                rDrivers.add(driverName, resultDriver);
                runDrivers.set(rDrivers);
            }
            WebDriver result = runDrivers.get().get(driverName);
            if (result.toString().contains("(null)")) {
                result = drivers.get(driverName).invoke();
                runDrivers.get().update(driverName, result);
            }
            if (!SWITCH_THREAD && INIT_THREAD_ID == currentThread().getId())
                INIT_DRIVER = result;
            lock.unlock();
            return result;
        } catch (Exception ex) {
            throw exception("Can't get driver; Thread: " + currentThread().getId() + LINE_BREAK +
                    format("Drivers: %s; Run: %s", drivers, runDrivers) +
                    "Exception: " + ex.getMessage());
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
        MapArray<String, WebDriver> rDriver = runDrivers.get();
        if (rDriver.has(driverName)) {
            rDriver.get(driverName).close();
            rDriver.removeByKey(driverName);
            runDrivers.set(rDriver);
        }
        if (drivers.has(driverName))
            getDriver();
    }

    public static void switchToDriver(String driverName) {
        if (drivers.has(driverName))
            DRIVER_NAME = driverName;
        else
            throw exception("Can't switch to Webdriver '%s'. This Driver name not registered", driverName);
    }

    public static void close() {
        if (nonNull(runDrivers.get())) {
            for (Pair<String, WebDriver> pair : runDrivers.get())
                try {
                    pair.value.quit();
                } catch (Exception ignore) {}
            runDrivers.get().clear();
        }
    }

    public static void quit() {
        close();
    }
}