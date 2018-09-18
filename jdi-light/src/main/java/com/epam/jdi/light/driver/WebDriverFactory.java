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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllRunWebBrowsers;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.downloadDriver;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;
import static com.epam.jdi.light.elements.base.DriverBase.DEFAULT_DRIVER;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.String.format;
import static java.lang.System.setProperty;
import static java.lang.Thread.currentThread;
import static java.util.Objects.nonNull;

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

    private static WebDriver initDriver(DriverTypes type) {
        WebDriver driver;
        switch (type) {
            case CHROME:
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.chrome.driver", chromeDriverPath());
                else
                    downloadDriver(CHROME, PLATFORM, DRIVER_VERSION);
                driver = new ChromeDriver(CHROME_OPTIONS.execute());
                break;
            case FIREFOX:
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.gecko.driver", firefoxDriverPath());
                else
                    downloadDriver(FIREFOX, PLATFORM, DRIVER_VERSION);
                driver = new FirefoxDriver(FIREFOX_OPTIONS.execute());
                break;
            case IE:
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.ie.driver", ieDriverPath());
                else
                    downloadDriver(IE, PLATFORM, DRIVER_VERSION);
                driver = new InternetExplorerDriver(IE_OPTIONS.execute());
                break;
            case EDGE:
                // TODO
                driver = new ChromeDriver(CHROME_OPTIONS.execute());
                break;
            case PHANTOMJS:
                // TODO
                driver = new ChromeDriver(CHROME_OPTIONS.execute());
                break;
            case OPERA:
                // TODO
                driver = new ChromeDriver(CHROME_OPTIONS.execute());
                break;
            default:
                throw exception("Unknown driver: " + type);
        }
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
            if (!DRIVER_NAME.equals(""))
                return getDriver(DRIVER_NAME);
            useDriver(CHROME);
            return getDriver(CHROME.name);
        } catch (Exception ex) {
            throw exception("Can't get WebDriver. " + LINE_BREAK + ex.getMessage());
        }
    }

    public static long INIT_THREAD_ID = -1;
    public static boolean SWITCH_THREAD = false;

    public static WebDriver getDriver(String driverName) {
        /* TODO
        if (SWITCH_THREAD && INIT_THREAD_ID != Thread.currentThread().getId())
            runDrivers.get().ge
        if (INIT_THREAD_ID == Thread.currentThread().getId())
            SWITCH_THREAD = true; */
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
                pair.value.quit();
            runDrivers.get().clear();
        } else {
            throw exception("None Driver has been found for current thread. Probably Fixture configuration is wrong.");
        }
        killAllRunWebBrowsers();
    }

    public static void quit() {
        close();
    }
}