package com.epam.jdi.light.driver;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.driver.get.DriverTypes;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.get.DownloadDriverManager.downloadDriver;
import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;
import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.lang.String.format;
import static java.lang.System.setProperty;
import static java.lang.Thread.currentThread;
import static java.util.Arrays.asList;
import static org.openqa.selenium.ie.InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS;
import static org.openqa.selenium.remote.CapabilityType.PAGE_LOAD_STRATEGY;

public class WebDriverFactory {
    public static String DRIVER_NAME = "chrome";
    public static String PAGELOAD_STRATEGY = "normal";
    public static String DRIVER_PATH;

    public static MapArray<String, JFunc<WebDriver>> drivers = new MapArray<>();
    private static ThreadLocal<MapArray<String, WebDriver>> runDrivers = new ThreadLocal<>();

    private WebDriverFactory() { }
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
        switch (type) {
            case CHROME:
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.chrome.driver", chromeDriverPath());
                else
                    downloadDriver(CHROME);
                return new ChromeDriver(defaultChromeOptions());
            case FIREFOX:
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.gecko.driver", firefoxDriverPath());
                else
                    downloadDriver(FIREFOX);
                return new FirefoxDriver(defaultFirefoxOptions());
            case IE:
                if (DRIVER_VERSION.equals(""))
                    setProperty("webdriver.ie.driver", ieDriverPath());
                else
                    downloadDriver(IE);
                return new InternetExplorerDriver(defaultIEOptions());
            case EDGE:
                // TODO
            case PHANTOMJS:
                // TODO
            case OPERA:
                // TODO
        }
        throw exception("Unknown driver: " + type);
    }
    // GET DRIVER

    public static Dimension BROWSER_SIZES;
    public static Function<WebDriver, WebDriver> driverSettings = driver -> {
        if (BROWSER_SIZES == null) {
            if (any(asList("chrome", "internetexplorer"),
                    el -> driver.toString().toLowerCase().contains(el)))
                driver.manage().window().maximize();
        }
        else
            driver.manage().window().setSize(BROWSER_SIZES);
        return driver;
    };
    private static ChromeOptions defaultChromeOptions() {
        ChromeOptions cap = new ChromeOptions();
        cap.setCapability(PAGE_LOAD_STRATEGY, PAGELOAD_STRATEGY);
        return cap;
    }
    private static FirefoxOptions defaultFirefoxOptions() {
        FirefoxOptions cap = new FirefoxOptions();
        cap.setCapability(PAGE_LOAD_STRATEGY, PAGELOAD_STRATEGY);
        return cap;
    }
    private static InternetExplorerOptions defaultIEOptions() {
        InternetExplorerOptions cap = new InternetExplorerOptions();
        cap.setCapability(INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        cap.setCapability("ignoreZoomSetting", true);
        //cap.setCapability("requireWindowFocus", true);
        cap.setCapability(PAGE_LOAD_STRATEGY, PAGELOAD_STRATEGY);
        return cap;
    }
    public static String useDriver(DriverTypes driverType, JFunc<WebDriver> driver) {
        String driverName = driverType.name;
        if (drivers.keys().contains(driverName))
            driverName = driverName + System.currentTimeMillis();
        drivers.add(driverName, driver);
        DRIVER_NAME = driverName;
        return driverName;
    }

    public static String useDriver(String driverName, JFunc<WebDriver> driver) {
        if (drivers.keys().contains(driverName))
            drivers.add(driverName, driver);
        else
            throw exception("Can't register WebDriver '%s'. Driver with same name already registered", driverName);
        DRIVER_NAME = driverName;
        return driverName;
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

    public static WebDriver getDriver(String driverName) {
        if (!drivers.keys().contains(driverName))
            if (drivers.count() == 0)
                useDriver(driverName);
            else throw exception("Can't find driver with name '%s'", driverName);
        try {
            Lock lock = new ReentrantLock();
            lock.lock();
            if (runDrivers.get() == null || !runDrivers.get().keys().contains(driverName)) {
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
        if (rDriver.keys().contains(driverName)) {
            rDriver.get(driverName).close();
            rDriver.removeByKey(driverName);
            runDrivers.set(rDriver);
        }
        if (drivers.keys().contains(driverName))
            getDriver();
    }

    public static void switchToDriver(String driverName) {
        if (drivers.keys().contains(driverName))
            DRIVER_NAME = driverName;
        else
            throw exception("Can't switch to Webdriver '%s'. This Driver name not registered", driverName);
    }
    public static void close() {
        for (Pair<String, WebDriver> driver : runDrivers.get())
            driver.value.quit();
        runDrivers.get().clear();
    }

    public static void quit() {
        close();
    }
}