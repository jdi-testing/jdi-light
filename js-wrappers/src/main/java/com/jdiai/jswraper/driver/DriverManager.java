package com.jdiai.jswraper.driver;

import com.epam.jdi.tools.map.MapArray;
import com.jdiai.jsdriver.JSException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.function.Consumer;

import static com.epam.jdi.tools.pairs.Pair.$;
import static com.jdiai.jswraper.driver.DriverTypes.*;
import static com.jdiai.jswraper.driver.GetDriverUtilities.*;
import static com.jdiai.jswraper.driver.RunModes.*;
import static java.lang.Runtime.getRuntime;

public class DriverManager {
    static DriverTypes BROWSER = CHROME;

    public static RunModes RUN_MODE = LOCAL_DOWNLOAD;

    public static RemoteRunSettings REMOTE_RUN_SETTINGS = new RemoteRunSettings();

    public static SelenoidSettings SELENOID_SETTINGS = new SelenoidSettings();

    public static MapArray<DriverTypes, String> REMOTE_DRIVER_VERSIONS = new MapArray<>(
        $(CHROME, "latest"),
        $(FIREFOX, "latest"),
        $(IE, "latest"),
        $(IE_EDGE, "latest"),
        $(SAFARI, "latest"),
        $(OPERA, "latest")
    );

    public static String DRIVER_PATH = "C:/Selenium";

    public static Consumer<WebDriver> DRIVER_SETUP = driver -> driver.manage().window().maximize();

    public static DriverOptions DRIVER_OPTIONS = new DriverOptions();

    public static DownloadDriverSettings DOWNLOAD_SETTINGS = new DownloadDriverSettings();

    public static void useDriver(DriverTypes driver) {
        BROWSER = driver;
    }

    public static WebDriver getDriver() {
        return getDriver(BROWSER);
    }

    public static WebDriver getDriver(DriverTypes driverType) {
        if(driverType == null) {
            throw new JSException("Driver type can't be null");
        }
        switch (driverType) {
            case CHROME:
                return chromeDriver();
            case FIREFOX:
                return firefoxDriver();
            case IE:
                return ieDriver();
            case IE_EDGE:
                return ieEdgeDriver();
            case SAFARI:
                return safariDriver();
            case OPERA:
                return operaDriver();
            default:
                throw new JSException("Unknown driver type %s", driverType);
        }
    }

    public static WebDriver getDriver(DriverTypes browser, MutableCapabilities options) {
        if (RUN_MODE == null || RUN_MODE.equals(LOCAL_DOWNLOAD)) {
            return downloadAndGetLocalDriver(browser, options);
        }
        if (RUN_MODE.equals(LOCAL_BY_PATH)) {
            return getLocalDriverByPath(browser, options);
        }
        if (RUN_MODE.equals(REMOTE)) {
            return getRemoteDriver(browser, options);
        }
        if (RUN_MODE.equals(SELENOID)) {
            return getSelenoidRemote(browser, options);
        }
        return downloadAndGetLocalDriver(browser, options);
    }

    public static WebDriver chromeDriver() {
        ChromeOptions options = new ChromeOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.chrome.accept(options);
        WebDriver driver = getDriver(CHROME, options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver firefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.firefox.accept(options);
        WebDriver driver = getDriver(FIREFOX, options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver ieDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.ie.accept(options);
        WebDriver driver = getDriver(IE, options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver ieEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.ieEdge.accept(options);
        WebDriver driver = getDriver(IE_EDGE, options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver safariDriver() {
        SafariOptions options = new SafariOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.safari.accept(options);
        WebDriver driver = getDriver(SAFARI, options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver operaDriver() {
        OperaOptions options = new OperaOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.opera.accept(options);
        WebDriver driver = getDriver(OPERA, options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static void killDrivers() {
        try {
            getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignore) { }
    }

}
