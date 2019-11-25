package com.epam.jdi.light.driver.get;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.awt.Toolkit;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.driver.get.OsTypes.LINUX;
import static com.epam.jdi.light.driver.get.OsTypes.MAC;
import static com.epam.jdi.light.driver.get.OsTypes.WIN;
import static com.epam.jdi.light.driver.get.Platform.X32;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PathUtils.path;
import static com.epam.jdi.tools.RegExUtils.matches;
import static com.epam.jdi.tools.switcher.SwitchActions.Case;
import static com.epam.jdi.tools.switcher.SwitchActions.Default;
import static com.epam.jdi.tools.switcher.SwitchActions.Switch;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;
import static org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT;
import static org.openqa.selenium.ie.InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR;
import static org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS;
import static org.openqa.selenium.remote.CapabilityType.SUPPORTS_JAVASCRIPT;

public class DriverData {
    public static final String PROJECT_PATH = path("");
    public static String SRC_PATH = mergePath(PROJECT_PATH,"src", "main");
    public static String TEST_PATH = mergePath(PROJECT_PATH, "src" ,"test");
    public static String LOGS_PATH = mergePath(TEST_PATH, ".logs");
    public static String DRIVERS_FOLDER;

    public static String DOWNLOADS_DIR = mergePath(TEST_PATH, "resources", "downloads");
    public static PageLoadStrategy PAGE_LOAD_STRATEGY = NORMAL;
    public static String BROWSER_SIZE = "MAXIMIZE";
    public static final String DEFAULT_DRIVER = "chrome";
    public static String DRIVER_NAME = DEFAULT_DRIVER;

    public static Map<String,String> CAPABILITIES_FOR_IE = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_CHROME = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_FF = new HashMap<>();

    public static String  LATEST_VERSION = "LATEST";
    public static String DRIVER_VERSION = LATEST_VERSION;
    public static String PRELATEST_VERSION = "PRELATEST";
    public static Platform PLATFORM = X32;
    public static JFunc<Capabilities> CHROME_OPTIONS = () -> {
        try {
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            new File(DOWNLOADS_DIR).mkdirs();
            chromePrefs.put("download.default_directory", DOWNLOADS_DIR);
            chromePrefs.put("profile.default_content_setting_values.notifications", 0);
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("profile.password_manager_enabled", false);
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--disable-web-security", "--disable-extensions", "test-type");
            cap.setPageLoadStrategy(PAGE_LOAD_STRATEGY);
            cap.setCapability(ACCEPT_SSL_CERTS, true);
            cap.setCapability(UNEXPECTED_ALERT_BEHAVIOR, ACCEPT);
            cap.addArguments(getBrowserSizeOption());
            cap.setExperimentalOption("prefs", chromePrefs);
            // Capabilities from settings
            CAPABILITIES_FOR_CHROME.forEach(cap::setCapability);
            return cap;
        } catch (Exception ex) {
            throw exception("Failed Init Chrome Driver settings: " + safeException(ex));
        }
    };

    public static JFunc<Capabilities> FIREFOX_OPTIONS = () -> {
        try {
            FirefoxProfile firefoxProfile = new FirefoxProfile();
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
            FirefoxOptions cap = new FirefoxOptions();
            cap.setPageLoadStrategy(PAGE_LOAD_STRATEGY);
            cap.setCapability(ACCEPT_SSL_CERTS, true);
            cap.setCapability(UNEXPECTED_ALERT_BEHAVIOR, ACCEPT);
            cap.addArguments(getBrowserSizeOption());
            cap.setProfile(firefoxProfile);
            // Capabilities from settings
            CAPABILITIES_FOR_FF.forEach(cap::setCapability);
            return cap;
        } catch (Exception ex) {
            throw exception("Failed Init Firefox Driver settings: " + safeException(ex));
        }
    };

    public static JFunc<Capabilities> IE_OPTIONS = () -> {
        try {
            InternetExplorerOptions cap = new InternetExplorerOptions();
            //cap.introduceFlakinessByIgnoringSecurityDomains();
            cap.ignoreZoomSettings();
            //cap.setCapability("requireWindowFocus", true);
            cap.setPageLoadStrategy(PAGE_LOAD_STRATEGY);
            cap.takeFullPageScreenshot();
            cap.setCapability(ACCEPT_SSL_CERTS, true);
            cap.destructivelyEnsureCleanSession();
            cap.setCapability(UNEXPECTED_ALERT_BEHAVIOR, ACCEPT);
            cap.is(SUPPORTS_JAVASCRIPT);
            cap.setCapability(ACCEPT_SSL_CERTS, true);
            // Capabilities from settings
            CAPABILITIES_FOR_IE.forEach(cap::setCapability);
            //        cap.setCapability("project", WebSettings.DRIVER_REMOTE_PROJECT_NAME);
            //        cap.setCapability("apm_id", WebSettings.DRIVER_REMOTE_APM_ID);
            //        cap.setCapability("user", WebSettings.DRIVER_REMOTE_USER_NAME);
            //        cap.setCapability("password", WebSettings.DRIVER_REMOTE_USER_PASSWORD);
            return cap;
        } catch (Exception ex) {
            throw exception("Failed Init Internet Explorer Driver settings: " + safeException(ex));
        }
    };
    // GET DRIVER
    public static JFunc1<WebDriver, WebDriver> DRIVER_SETTINGS = driver ->
            getOs().equals(MAC) ? maximizeScreen(driver) : driver;

    public static String getDriverFolder() {
        return isNotBlank(DRIVERS_FOLDER) && !DRIVERS_FOLDER.equalsIgnoreCase("default")
                ? DRIVERS_FOLDER : mergePath(TEST_PATH,"resources", "drivers");
    }

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

    public static OsTypes getOs() {
        String osName = System.getProperty("os.name").toLowerCase();
        return Switch(osName).get(
            Case(os -> os.contains("mac"), MAC),
            Case(os -> os.contains("win") || os.contains("ms"), WIN),
            Default(LINUX)
        );
    }

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
    private static String getBrowserSizeOption() {
        List<String> groups = matches(BROWSER_SIZE, "([0-9]+)[^0-9]*([0-9]+)");
        return groups.size() == 2
                ? "--window-size=" + groups.get(0) + ","+ groups.get(1)
                : "--start-maximized";
    }

}
