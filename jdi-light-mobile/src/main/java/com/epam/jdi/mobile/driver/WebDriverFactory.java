package com.epam.jdi.mobile.driver;

import com.epam.jdi.mobile.driver.get.DriverTypes;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.common.Exceptions.safeException;
import static com.epam.jdi.mobile.driver.get.DriverData.DEFAULT_DRIVER;
import static com.epam.jdi.mobile.driver.get.DriverData.DRIVER_NAME;
import static com.epam.jdi.mobile.driver.get.DriverInfos.MOBILE_INFO;
import static com.epam.jdi.mobile.driver.get.DriverTypes.APPIUM;
import static com.epam.jdi.mobile.driver.get.DriverTypes.CHROME;
import static com.epam.jdi.mobile.driver.get.DriverTypes.getByName;
import static com.epam.jdi.mobile.driver.get.MobileDriver.DRIVER_MOBILE_URL;
import static com.epam.jdi.mobile.driver.get.RemoteDriver.DRIVER_REMOTE_URL;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.epam.jdi.tools.switcher.SwitchActions.Switch;
import static com.epam.jdi.tools.switcher.SwitchActions.Value;
import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class WebDriverFactory {
    public static MapArray<String, JFunc<AppiumDriver>> DRIVERS
            = new MapArray<>(DEFAULT_DRIVER, () -> initDriver(APPIUM));
    private static Safe<MapArray<String, AppiumDriver>> RUN_DRIVERS
            = new Safe<>(MapArray::new);

    private WebDriverFactory() {
    }

    public static boolean hasRunDrivers() {
        return RUN_DRIVERS.get().any();
    }

    // REGISTER DRIVER
    public static String useDriver(JFunc<AppiumDriver> driver) {
        return useDriver("Driver" + (DRIVERS.size() + 1), driver);
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

    public static boolean isMobile() {
        return isNotEmpty(DRIVER_MOBILE_URL);
    }

    private static AppiumDriver initDriver(DriverTypes type) {
        return Switch(type).get(
                Value(APPIUM, t -> MOBILE_INFO.getDriver())
        );
    }

    // GET DRIVER
    public static String useDriver(DriverTypes driverType, JFunc<AppiumDriver> driver) {
        String driverName = driverType.name;
        if (DRIVERS.has(driverName))
            driverName = driverName + System.currentTimeMillis();
        DRIVERS.add(driverName, driver);
        DRIVER_NAME = driverName;
        return driverName;
    }

    public static String useDriver(String driverName, JFunc<AppiumDriver> driver) {
        if (!DRIVERS.has(driverName))
            DRIVERS.add(driverName, driver);
        else
            throw exception("Can't register WebDriver '%s'. Driver with same name already registered", driverName);
        DRIVER_NAME = driverName;
        return driverName;
    }

    public static <T> T jsExecute(String script, Object... args) {
        return (T) ((JavascriptExecutor) getDriver()).executeScript(script, args);
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
    public static AppiumDriver INIT_DRIVER;

    @SuppressWarnings("PMD.NPathComplexity")
    public static AppiumDriver getDriver(String driverName) {
        if (!SWITCH_THREAD && INIT_DRIVER != null && INIT_THREAD_ID != currentThread().getId()) {
            RUN_DRIVERS.set(map($(driverName, INIT_DRIVER)));
            SWITCH_THREAD = true;
            return INIT_DRIVER;
        }
        if (!DRIVERS.has(driverName))
            useDriver(driverName);
        try {
            Lock lock = new ReentrantLock();
            lock.lock();

            MapArray<String, AppiumDriver> rDrivers = RUN_DRIVERS.get();
            if (rDrivers == null) {
                rDrivers = new MapArray<>();
            }
            if (!rDrivers.has(driverName)) {
                AppiumDriver resultDriver = DRIVERS.get(driverName).invoke();
                if (resultDriver == null) {
                    throw exception("Can't get WebDriver '%s'. This Driver name not registered", driverName);
                }
                rDrivers.add(driverName, resultDriver);
            }
            RUN_DRIVERS.set(rDrivers);

            AppiumDriver result = RUN_DRIVERS.get().get(driverName);
            if (result.toString().contains("(null)")) {
                result = DRIVERS.get(driverName).invoke();
                RUN_DRIVERS.get().update(driverName, result);
            }
            if (!SWITCH_THREAD && INIT_THREAD_ID == currentThread().getId())
                INIT_DRIVER = result;
            lock.unlock();
            return result;
        } catch (Exception ex) {
            throw exception(ex, "Can't get driver; Thread: " + currentThread().getId() + LINE_BREAK +
                    format("Drivers: %s; Run: %s", DRIVERS, RUN_DRIVERS.get()) +
                    "Exception: " + safeException(ex));
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
        MapArray<String, AppiumDriver> rDriver = RUN_DRIVERS.get();
        if (rDriver.has(driverName)) {
            rDriver.get(driverName).close();
            rDriver.removeByKey(driverName);
            RUN_DRIVERS.set(rDriver);
        }
        if (DRIVERS.has(driverName))
            getDriver();
    }

    public static void switchToDriver(String driverName) {
        if (DRIVERS.has(driverName))
            DRIVER_NAME = driverName;
        else
            throw exception("Can't switch to Webdriver '%s'. This Driver name not registered", driverName);
    }

    public static void close() {
        for (Pair<String, AppiumDriver> pair : RUN_DRIVERS.get())
            try {
                pair.value.quit();
            } catch (Exception ignore) {
            }
        RUN_DRIVERS.get().clear();
    }

    public static void quit() {
        close();
    }
}