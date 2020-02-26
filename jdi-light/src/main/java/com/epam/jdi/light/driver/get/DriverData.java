package com.epam.jdi.light.driver.get;

import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.driver.WebDriverFactory.isRemote;
import static com.epam.jdi.light.driver.get.OsTypes.*;
import static com.epam.jdi.light.driver.get.Platform.X32;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PathUtils.path;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.stringToPrimitive;
import static com.epam.jdi.tools.RegExUtils.matches;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.awt.Toolkit.getDefaultToolkit;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;
import static org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT;
import static org.openqa.selenium.ie.InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR;
import static org.openqa.selenium.logging.LogType.PERFORMANCE;
import static org.openqa.selenium.remote.CapabilityType.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverData {
    public static final String PROJECT_PATH = path("");
    public static String SRC_PATH = mergePath(PROJECT_PATH, "src", "main");
    public static String TEST_PATH = mergePath(PROJECT_PATH, "src", "test");
    public static String LOGS_PATH = mergePath("target", ".logs");
    public static String DRIVERS_FOLDER;
    public static String getDriverFolder() {
        return isNotBlank(DRIVERS_FOLDER) && !DRIVERS_FOLDER.equalsIgnoreCase("default")
            ? DRIVERS_FOLDER : mergePath(TEST_PATH, "resources", "drivers");
    }
    public static String DOWNLOADS_DIR = mergePath(TEST_PATH, "resources", "downloads");
    public static PageLoadStrategy PAGE_LOAD_STRATEGY = NORMAL;
    public static String BROWSER_SIZE = "MAXIMIZE";
    public static final String DEFAULT_DRIVER = "chrome";
    public static String DRIVER_NAME = DEFAULT_DRIVER;
    public static String ARGUMENTS_PROPERTY = "arguments";

    public static Map<String,String> CAPABILITIES_FOR_IE = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_CHROME = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_FF = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_EDGE = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_OPERA = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_SAFARI = new HashMap<>();
    public static Map<String,String> COMMON_CAPABILITIES = new HashMap<>();

    public static String chromeDriverPath() {
        return mergePath(getDriverFolder(),getOs() == WIN ? "chromedriver.exe" : "chromedriver");
    }
    public static String ieDriverPath() {
        return mergePath(getDriverFolder(),"IEDriverServer.exe");
    }
    public static String edgeDriverPath() {
        return mergePath(getDriverFolder(),"MicrosoftWebDriver.exe");
    }
    public static String operaDriverPath() {
        return driverPath("operadriver");
    }
    public static String safariDriverPath() {
        return driverPath("safaridriver");
    }
    public static String firefoxDriverPath() {
        return driverPath("geckodriver");
    }
    private static String driverPath(String driverName) {
        return mergePath(getDriverFolder(), getOs() == WIN ? driverName + ".exe" : driverName);
    }
    public static String LATEST_VERSION = "LATEST";
    public static String DRIVER_VERSION = LATEST_VERSION;
    public static String PRELATEST_VERSION = "PRELATEST";
    public static Platform PLATFORM = X32;

    public static OsTypes getOs() {
        String osName = System.getProperty("os.name").toLowerCase();
        return Switch(osName).get(
            Case(os -> os.contains("mac"), MAC),
            Case(os -> os.contains("win") || os.contains("ms"), WIN),
            Default(LINUX)
        );
    }

    // GET DRIVER
    public static JFunc1<WebDriver, WebDriver> DRIVER_SETTINGS = driver -> {
        List<String> groups = matches(BROWSER_SIZE, "([0-9]+)[^0-9]*([0-9]+)");
        if (groups.size() == 2)
            driver.manage().window().setSize(new Dimension(parseInt(groups.get(0)), parseInt(groups.get(1))));
        else {
            if(!isRemote()) {
                if (getOs().equals(MAC))
                    maximizeScreen(driver);
                else
                    driver.manage().window().maximize();
            }
        }
        return driver;
    };

    private static WebDriver setBrowserSizeForMac(WebDriver driver, int width, int height) {
        try {
            Point position = new Point(0, 0);
            driver.manage().window().setPosition(position);
            driver.manage().window().setSize(new Dimension(width, height));
            return driver;
        } catch (Exception ex) {
            logger.error("Failed to Set resolution (%s, %s): %s", width, height, safeException(ex));
            throw ex;
        }
    }
    public static Capabilities getCapabilities(
            MutableCapabilities capabilities, JAction1<Object> defaultCapabilities) {
        try {
            setupErrors.clear();
            defaultCapabilities.execute(capabilities);
        } catch (Throwable ex) {
            setupErrors.add("Setup capabilities exception: " + safeException(ex));
        }
        if (isNotEmpty(setupErrors)) {
            logger.info("Failed to set Default Capabilities for Driver:");
            logger.info("Errors: " + print(setupErrors, LINE_BREAK));
            setupErrors.clear();
        }
        try {
            COMMON_CAPABILITIES.forEach(capabilities::setCapability);
        } catch (Throwable ex) {
            logger.info("Failed to set COMMON_CAPABILITIES Capabilities for Driver: " + safeException(ex));
        }
        return capabilities;
    }
    public static List<String> setupErrors = new ArrayList<>();
    public static void setUp(String name, JAction action) {
        try {
            action.invoke();
        } catch (Throwable ex) {
            setupErrors.add(format("%s: %s", name, safeException(ex)));
        }
    }
    public static void defaultChromeOptions(ChromeOptions cap) {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        setUp("Set Chrome Prefs", () -> {
            chromePrefs.put("credentials_enable_service", false);
            new File(DOWNLOADS_DIR).mkdirs();
            chromePrefs.put("download.default_directory", DOWNLOADS_DIR);
            chromePrefs.put("profile.default_content_setting_values.notifications", 0);
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("profile.password_manager_enabled", false);
        });
        setUp("Chrome: '--disable-web-security', '--disable-extensions', 'test-type'",
            () -> cap.addArguments("--disable-web-security", "--disable-extensions", "test-type"));
        setUp("Chrome: PageLoadStrategy:" + PAGE_LOAD_STRATEGY,
            () -> cap.setPageLoadStrategy(PAGE_LOAD_STRATEGY));
        setUp("Chrome: ACCEPT_SSL_CERTS:true",
            () -> cap.setCapability(ACCEPT_SSL_CERTS, true));
        setUp("Chrome: " + UNEXPECTED_ALERT_BEHAVIOR + "=" + ACCEPT,
            () -> cap.setCapability(UNEXPECTED_ALERT_BEHAVIOR, ACCEPT));
        setUp("Chrome: setExperimentalOption: prefs",
            () -> cap.setExperimentalOption("prefs", chromePrefs));
        setUp("Chrome: setExperimentalOption: prefs",
            () -> {
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(PERFORMANCE, Level.ALL);
                cap.setCapability(LOGGING_PREFS, logPrefs);
            });
        // Capabilities from settings
        CAPABILITIES_FOR_CHROME.forEach((property, value) -> setupCapability(cap, property, value));
    }
    public static JAction1<ChromeOptions> CHROME_OPTIONS = DriverData::defaultChromeOptions;

    public static void setupCapability(ChromeOptions cap, String property, String value){
        if(!property.equals(ARGUMENTS_PROPERTY)){
            cap.setCapability(property, stringToPrimitive(value));
        } else {
            cap.addArguments(value.split(" "));
        }
    }

    public static void defaultFirefoxOptions(FirefoxOptions cap) {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        setUp("Set FirefoxProfile", () -> {
            firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
            firefoxProfile.setPreference("browser.download.folderList", 2);
            firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
            firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
            firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/xls;text/csv;text/plain");
            firefoxProfile.setPreference("browser.download.dir", DOWNLOADS_DIR);
            firefoxProfile.setPreference("print.always_print_silent", "true");
            firefoxProfile.setPreference("print.show_print_progress", "false");
            firefoxProfile.setPreference("browser.startup.homepage", "about:blank");
            firefoxProfile.setPreference("startup.homepage_welcome_url", "about:blank");
            firefoxProfile.setPreference("startup.homepage_welcome_url.additional", "about:blank");
            firefoxProfile.setPreference("network.http.phishy-userpass-length", 255);
        });
        setUp("Firefox: PageLoadStrategy:" + PAGE_LOAD_STRATEGY,
            () -> cap.setPageLoadStrategy(PAGE_LOAD_STRATEGY));
        setUp("Firefox: ACCEPT_SSL_CERTS: true",
            () -> cap.setCapability(ACCEPT_SSL_CERTS, true));
        setUp("Firefox: UNEXPECTED_ALERT_BEHAVIOR, ACCEPT",
            () -> cap.setCapability(UNEXPECTED_ALERT_BEHAVIOR, ACCEPT));
        setUp("Firefox: Firefox Profile",
            () -> cap.setProfile(firefoxProfile));
        // Capabilities from settings
        CAPABILITIES_FOR_FF.forEach(cap::setCapability);
    }
    public static JAction1<FirefoxOptions> FIREFOX_OPTIONS = DriverData::defaultFirefoxOptions;

    public static void defaultIEOptions(InternetExplorerOptions cap) {
        setUp("IE: introduceFlakinessByIgnoringSecurityDomains",
            cap::introduceFlakinessByIgnoringSecurityDomains);
        setUp("ignoreZoomSettings",
            cap::ignoreZoomSettings);
        setUp("IE: requireWindowFocus:true",
            () -> cap.setCapability("requireWindowFocus", true));
        setUp("IE: PageLoadStrategy:" + PAGE_LOAD_STRATEGY,
            () -> cap.setPageLoadStrategy(PAGE_LOAD_STRATEGY));
        setUp("IE: takeFullPageScreenshot",
            cap::takeFullPageScreenshot);
        setUp("IE: ACCEPT_SSL_CERTS: true",
            () -> cap.setCapability(ACCEPT_SSL_CERTS, true));
        setUp("IE: destructivelyEnsureCleanSession",
            cap::destructivelyEnsureCleanSession);
        setUp("IE: UNEXPECTED_ALERT_BEHAVIOR: ACCEPT)",
            () -> cap.setCapability(UNEXPECTED_ALERT_BEHAVIOR, ACCEPT));
        setUp("IE: SUPPORTS_JAVASCRIPT",
            () -> cap.is(SUPPORTS_JAVASCRIPT));
        setUp("IE: ACCEPT_SSL_CERTS: true",
            () -> cap.setCapability(ACCEPT_SSL_CERTS, true));
        // Capabilities from settings
        CAPABILITIES_FOR_IE.forEach(cap::setCapability);
    }
    public static JAction1<InternetExplorerOptions> IE_OPTIONS = DriverData::defaultIEOptions;

    public static void defaultEdgeOptions(EdgeOptions cap) { }
    public static JAction1<EdgeOptions> EDGE_OPTIONS = DriverData::defaultEdgeOptions;

    public static void defaultOperaOptions(OperaOptions cap) { }
    public static JAction1<OperaOptions> OPERA_OPTIONS = DriverData::defaultOperaOptions;

    public static void defaultSafariOptions(SafariOptions cap) { }
    public static JAction1<SafariOptions> SAFARI_OPTIONS = DriverData::defaultSafariOptions;

    private static WebDriver maximizeScreen(WebDriver driver) {
        try {
            switch (getOs()) {
                case WIN:
                    driver.manage().window().maximize();
                case MAC:
                    java.awt.Dimension screenSize = getDefaultToolkit().getScreenSize();
                    setBrowserSizeForMac(driver, (int) screenSize.getWidth(), (int) screenSize.getHeight());
            }
            return driver;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to maximize window: ", ex);
        }
    }

    private static String getBrowserSizeOption() {
        List<String> groups = matches(BROWSER_SIZE, "([0-9]+)[^0-9]*([0-9]+)");
        return groups.size() == 2
                ? "--window-size=" + groups.get(0) + "," + groups.get(1)
                : "--start-maximized";
    }
}
