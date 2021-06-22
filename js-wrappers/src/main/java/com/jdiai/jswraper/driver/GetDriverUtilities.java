package com.jdiai.jswraper.driver;

import com.jdiai.jsdriver.JSException;
import com.jdiai.jswraper.exceptions.JDINovaException;
import org.openqa.selenium.MutableCapabilities;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.URI;

import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PathUtils.path;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static com.jdiai.jswraper.driver.DownloadDriverManager.DOWNLOAD_DRIVER_FUNC;
import static com.jdiai.jswraper.driver.DownloadDriverManager.hasVersion;
import static com.jdiai.jswraper.driver.DriverManager.*;
import static com.jdiai.jswraper.driver.DriverTypes.CHROME;
import static com.jdiai.jswraper.driver.OsTypes.*;
import static com.jdiai.jswraper.driver.Platform.X32;
import static com.jdiai.jswraper.driver.Platform.X64;
import static java.lang.System.getProperty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class GetDriverUtilities {
    public static WebDriver downloadAndGetLocalDriver(DriverTypes browser, MutableCapabilities options) {
        try {
            downloadDriver(browser);

            switch (browser) {
                case FIREFOX:
                    return new FirefoxDriver((FirefoxOptions) options);
                case IE:
                    return new InternetExplorerDriver((InternetExplorerOptions) options);
                case IE_EDGE:
                    return new EdgeDriver((EdgeOptions) options);
                case SAFARI:
                    return new SafariDriver((SafariOptions) options);
                case OPERA:
                    return new OperaDriver((OperaOptions) options);
                default:
                    return new ChromeDriver((ChromeOptions) options);
            }
        } catch (Exception ex) {
            throw new JDINovaException(ex, "Failed to run local driver '%s'", BROWSER);
        }
    }

    public static void downloadDriver(DriverTypes browser) {
        if (DOWNLOAD_DRIVER_FUNC == null) {
            DOWNLOAD_DRIVER_FUNC = DownloadDriverManager::downloadDriver;
        }
        if (browser == null) {
            browser = CHROME;
        }
        if (DOWNLOAD_SETTINGS == null) {
            DOWNLOAD_SETTINGS = new DownloadDriverSettings();
        }
        DOWNLOAD_DRIVER_FUNC.execute(browser, getDriverPlatform());
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

    public static WebDriver getLocalDriverByPath(DriverTypes browser, MutableCapabilities options) {
        try {
            switch (browser) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", firefoxDriverPath());
                    return new FirefoxDriver((FirefoxOptions) options);
                case IE:
                    System.setProperty("webdriver.ie.driver", ieDriverPath());
                    return new InternetExplorerDriver((InternetExplorerOptions) options);
                case IE_EDGE:
                    System.setProperty("webdriver.edge.driver", edgeDriverPath());
                    return new EdgeDriver((EdgeOptions) options);
                case SAFARI:
                    System.setProperty("webdriver.safari.driver", safariDriverPath());
                    return new SafariDriver((SafariOptions) options);
                case OPERA:
                    System.setProperty("webdriver.opera.driver", operaDriverPath());
                    return new OperaDriver((OperaOptions) options);
                default:
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath());
                    return new ChromeDriver((ChromeOptions) options);
            }
        } catch (Exception ex) {
            throw new JDINovaException(ex, "Failed to run local driver '%s'", BROWSER);
        }
    }

    private static String chromeDriverPath() {
        return mergePath(getDriverFolder(), getOs() == WIN ? "chromedriver.exe" : "chromedriver");
    }
    private static String ieDriverPath() {
        return mergePath(getDriverFolder(),"IEDriverServer.exe");
    }
    private static String edgeDriverPath() {
        return mergePath(getDriverFolder(),"MicrosoftWebDriver.exe");
    }
    private static String operaDriverPath() {
        return driverPath("operadriver");
    }
    private static String safariDriverPath() {
        return driverPath("safaridriver");
    }
    private static String firefoxDriverPath() {
        return driverPath("geckodriver");
    }
    private static String driverPath(String name) {
        return mergePath(getDriverFolder(), getOs() == WIN ? name + ".exe" : name);
    }
    private static String getDriverFolder() {
        return isNotBlank(DRIVER_PATH) && !DRIVER_PATH.equalsIgnoreCase("default")
            ? DRIVER_PATH : mergePath(mergePath(path(""), "src", "test", "resources", "drivers"), "resources", "drivers");
    }

    public static WebDriver getRemoteDriver(DriverTypes browser, MutableCapabilities options) {
        try {
            ((DesiredCapabilities) options).setBrowserName(browser.name);
            String version = REMOTE_DRIVER_VERSIONS.get(browser);
            if (hasVersion(version)) {
                ((DesiredCapabilities) options).setVersion(version);
            }
            if (REMOTE_RUN_SETTINGS != null) {
                setupRemoteSettings(options, REMOTE_RUN_SETTINGS);
            }

            return new RemoteWebDriver(URI.create(REMOTE_RUN_SETTINGS.url).toURL(), options);
        } catch (Exception ex) {
            throw new JDINovaException(ex, "Failed to run local driver '%s'", BROWSER);
        }
    }
    public static void setupRemoteSettings(MutableCapabilities options, RemoteRunSettings settings) {
        if (settings.name != null) {
            options.setCapability("name", settings.name);
        }
        if (settings.build != null) {
            options.setCapability("build", settings.build);
        }
        if (settings.platform != null) {
            options.setCapability("platform", settings.platform);
        }
        options.setCapability("network", settings.network);
        options.setCapability("console", settings.console);
        options.setCapability("visual", settings.visual);
        options.setCapability("video", settings.video);
    }

    public static WebDriver getSelenoidRemote(DriverTypes browser, MutableCapabilities options) {
        options.setCapability("selenoid:options", SELENOID_SETTINGS.getSelenoidOptions());
        return getRemoteDriver(browser, options);
    }
}
