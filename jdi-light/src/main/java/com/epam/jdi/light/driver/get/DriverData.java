package com.epam.jdi.light.driver.get;

import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JAction1;
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
import java.util.*;
import java.util.logging.Level;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.driver.get.OsTypes.*;
import static com.epam.jdi.light.driver.get.Platform.*;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.PathUtils.*;
import static com.epam.jdi.tools.PrintUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.awt.Toolkit.*;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.*;
import static org.openqa.selenium.PageLoadStrategy.*;
import static org.openqa.selenium.UnexpectedAlertBehaviour.*;
import static org.openqa.selenium.ie.InternetExplorerDriver.*;
import static org.openqa.selenium.logging.LogType.*;
import static org.openqa.selenium.remote.CapabilityType.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverData {
    public static final String PROJECT_PATH = path("");
    public static String TEST_PATH = mergePath(PROJECT_PATH, "src", "test");
    public static String getDriverFolder() {
        return isNotBlank(DRIVER.path) && !DRIVER.path.equalsIgnoreCase("default")
            ? DRIVER.path : mergePath(TEST_PATH, "resources", "drivers");
    }
    public static String DOWNLOADS_DIR = mergePath(TEST_PATH, "resources", "downloads");
    public static final String DEFAULT_DRIVER = "chrome";
    public static String ARGUMENTS_PROPERTY = "arguments";

    public static Map<String,String> CAPABILITIES_FOR_IE = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_CHROME = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_FF = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_EDGE = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_OPERA = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_SAFARI = new HashMap<>();
    public static Map<String,String> COMMON_CAPABILITIES = new HashMap<>();

    public static String chromeDriverPath() {
        return mergePath(getDriverFolder(), getOs() == WIN ? "chromedriver.exe" : "chromedriver");
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
    public static WebDriver driverSettings(WebDriver driver) {
        if (DRIVER.screenSize.maximize){
            if (getOs().equals(MAC))
                maximizeScreen(driver);
            else
                driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(DRIVER.screenSize.asDimension());
        }
        return driver;
    }
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

    public static MutableCapabilities getCapabilities(
            MutableCapabilities capabilities, JAction1<MutableCapabilities> defaultCapabilities) {
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
        setUp("Chrome: PageLoadStrategy:" + DRIVER.pageLoadStrategy,
            () -> cap.setPageLoadStrategy(DRIVER.pageLoadStrategy));
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
        setUp("Firefox: PageLoadStrategy:" + DRIVER.pageLoadStrategy,
            () -> cap.setPageLoadStrategy(DRIVER.pageLoadStrategy));
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
        setUp("IE: PageLoadStrategy:" + DRIVER.pageLoadStrategy,
            () -> cap.setPageLoadStrategy(DRIVER.pageLoadStrategy));
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
                case LINUX:
                    driver.manage().window().maximize();
                    break;
                case MAC:
                    java.awt.Dimension screenSize = getDefaultToolkit().getScreenSize();
                    setBrowserSizeForMac(driver, (int) screenSize.getWidth(), (int) screenSize.getHeight());
                    break;
            }
            return driver;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to maximize window: ", ex);
        }
    }

    private static String getBrowserSizeOption() {
        return DRIVER.screenSize.maximize
            ? "--start-maximized"
            : "--window-size=" + DRIVER.screenSize.width + "," + DRIVER.screenSize.height;
    }
}
