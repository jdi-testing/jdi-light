package com.jdiai.jswraper.driver;

import com.jdiai.jsdriver.JSException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.function.Consumer;

import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static com.jdiai.jswraper.driver.DownloadDriverManager.DOWNLOAD_DRIVER_FUNC;
import static com.jdiai.jswraper.driver.DriverTypes.*;
import static com.jdiai.jswraper.driver.OsTypes.*;
import static com.jdiai.jswraper.driver.Platform.X32;
import static com.jdiai.jswraper.driver.Platform.X64;
import static java.lang.Runtime.getRuntime;
import static java.lang.System.getProperty;

public class DriverManager {
    static DriverTypes USE_DRIVER = CHROME;

    public static Consumer<WebDriver> DRIVER_SETUP = driver -> driver.manage().window().maximize();

    public static DriverOptions DRIVER_OPTIONS = new DriverOptions();

    public static DownloadDriverSettings DOWNLOAD_SETTINGS = new DownloadDriverSettings();

    public static void useDriver(DriverTypes driver) {
        USE_DRIVER = driver;
    }

    public static WebDriver getDriver() {
        return getDriver(USE_DRIVER);
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

    public static WebDriver chromeDriver() {
        DOWNLOAD_DRIVER_FUNC.execute(CHROME, getDriverPlatform(), DOWNLOAD_SETTINGS.version);
        ChromeOptions options = new ChromeOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.chrome.accept(options);
        WebDriver driver = new ChromeDriver(options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver firefoxDriver() {
        DOWNLOAD_DRIVER_FUNC.execute(FIREFOX, getDriverPlatform(), DOWNLOAD_SETTINGS.version);
        FirefoxOptions options = new FirefoxOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.firefox.accept(options);
        WebDriver driver = new FirefoxDriver(options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver ieDriver() {
        DOWNLOAD_DRIVER_FUNC.execute(IE, getDriverPlatform(), DOWNLOAD_SETTINGS.version);
        InternetExplorerOptions options = new InternetExplorerOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.ie.accept(options);
        WebDriver driver = new InternetExplorerDriver(options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver ieEdgeDriver() {
        DOWNLOAD_DRIVER_FUNC.execute(IE_EDGE, getDriverPlatform(), DOWNLOAD_SETTINGS.version);
        EdgeOptions options = new EdgeOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.ieEdge.accept(options);
        WebDriver driver = new EdgeDriver(options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver safariDriver() {
        DOWNLOAD_DRIVER_FUNC.execute(SAFARI, getDriverPlatform(), DOWNLOAD_SETTINGS.version);
        SafariOptions options = new SafariOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.safari.accept(options);
        WebDriver driver = new SafariDriver(options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static WebDriver operaDriver() {
        DOWNLOAD_DRIVER_FUNC.execute(OPERA, getDriverPlatform(), DOWNLOAD_SETTINGS.version);
        OperaOptions options = new OperaOptions();
        DRIVER_OPTIONS.common.accept(options);
        DRIVER_OPTIONS.opera.accept(options);
        WebDriver driver = new OperaDriver(options);
        DRIVER_SETUP.accept(driver);
        return driver;
    }

    public static void killDrivers() {
        try {
            getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignore) { }
    }

    private static Platform getDriverPlatform() {
        if (DOWNLOAD_SETTINGS.platform != null)
            return DOWNLOAD_SETTINGS.platform;
        if (getOs() == WIN || getProperty("os.arch").contains("32"))
            return X32;
        if (getProperty("os.arch").contains("64"))
            return X64;
        throw new JSException("Unknown driver platform: %s. Only X32 or X64 allowed. Please specify exact platform in JDISettings.DRIVER.platform", getProperty("os.arch"));
    }

    private static OsTypes getOs() {
        if (DOWNLOAD_SETTINGS.os != null)
            return DOWNLOAD_SETTINGS.os;
        String osName = System.getProperty("os.name").toLowerCase();
        return Switch(osName).get(
                Case(os -> os.contains("mac"), MAC),
                Case(os -> os.contains("win") || os.contains("ms"), WIN),
                Default(LINUX)
        );
    }

}
