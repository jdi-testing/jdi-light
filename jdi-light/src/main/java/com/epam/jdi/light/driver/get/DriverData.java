package com.epam.jdi.light.driver.get;

import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.driver.get.OsTypes.*;
import static com.epam.jdi.light.driver.get.Platform.X32;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PathUtils.path;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.RegExUtils.matches;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;
import static org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT;
import static org.openqa.selenium.ie.InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR;
import static org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS;
import static org.openqa.selenium.remote.CapabilityType.SUPPORTS_JAVASCRIPT;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverData {
    public static final String PROJECT_PATH = path("");
    public static String SRC_PATH = mergePath(PROJECT_PATH,"src", "main");
    public static String TEST_PATH = mergePath(PROJECT_PATH, "src" ,"test");
    public static String LOGS_PATH = mergePath(TEST_PATH, ".logs");
    public static String DRIVERS_FOLDER;
    public static String getDriverFolder() {
        return isNotBlank(DRIVERS_FOLDER) && !DRIVERS_FOLDER.equalsIgnoreCase("default")
                ? DRIVERS_FOLDER : mergePath(TEST_PATH,"resources", "drivers");
    }
    public static String DOWNLOADS_DIR = mergePath(TEST_PATH, "resources", "downloads");
    public static PageLoadStrategy PAGE_LOAD_STRATEGY = NORMAL;
    public static String BROWSER_SIZE = "MAXIMIZE";
    public static final String DEFAULT_DRIVER = "chrome";
    public static String DRIVER_NAME = DEFAULT_DRIVER;

    public static Map<String,String> CAPABILITIES_FOR_IE = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_CHROME = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_FF = new HashMap<>();
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
    public static String phantomDriverPath() {
        return driverPath("phantomjs");
    }
    public static String firefoxDriverPath() {
        return driverPath("geckodriver");
    }
    private static String driverPath(String driverName) {
        return mergePath(getDriverFolder(), getOs() == WIN ? driverName + ".exe" : driverName);
    }
    public static String  LATEST_VERSION = "LATEST";
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
    public static JFunc1<WebDriver, WebDriver> DRIVER_SETTINGS = driver ->
        getOs().equals(MAC) ? maximizeScreen(driver) : driver;

    private static WebDriver maximizeScreen(WebDriver driver) {
        try {
            java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Point position = new Point(0, 0);
            driver.manage().window().setPosition(position);
            Dimension maximizedScreenSize =
                    new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
            driver.manage().window().setSize(maximizedScreenSize);
            return driver;
        } catch (Exception ex) {
            logger.error("Failed to Maximize screen: " + safeException(ex));
            throw ex;
        }
    }
    public static Capabilities getCapabilities(
        MutableCapabilities capabilities, JAction1<Object> defaultCapabilities) {
        try {
            setupErrors.clear();
            defaultCapabilities.execute(capabilities);
        } catch (Throwable ex) {
            logger.info("Failed to set Default Capabilities for Driver: " + safeException(ex));
            logger.info("Errors: " + print(setupErrors));
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
            setupErrors.add(name);
        }
    }

    public static JAction1<ChromeOptions> CHROME_OPTIONS = cap -> {
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
        setUp("Chrome: " + getBrowserSizeOption(),
            () -> cap.addArguments(getBrowserSizeOption()));
        setUp("Chrome: setExperimentalOption: prefs",
            () -> cap.setExperimentalOption("prefs", chromePrefs));
        // Capabilities from settings
        CAPABILITIES_FOR_CHROME.forEach(cap::setCapability);
    };

    public static JAction1<FirefoxOptions> FIREFOX_OPTIONS = cap -> {
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
        setUp("Firefox: BrowserSize:" + getBrowserSizeOption(),
            () -> cap.addArguments(getBrowserSizeOption()));
        setUp("Firefox: Firefox Profile",
            () -> cap.setProfile(firefoxProfile));
        // Capabilities from settings
        CAPABILITIES_FOR_FF.forEach(cap::setCapability);
    };

    public static JAction1<InternetExplorerOptions> IE_OPTIONS = cap -> {
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
    };

    private static String getBrowserSizeOption() {
        List<String> groups = matches(BROWSER_SIZE, "([0-9]+)[^0-9]*([0-9]+)");
        return groups.size() == 2
                ? "--window-size=" + groups.get(0) + ","+ groups.get(1)
                : "--start-maximized";
    }

}
