package com.jdiai.jswraper.driver;

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
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static com.jdiai.jswraper.driver.JDIDriver.RUN_MODE;
import static com.jdiai.jswraper.driver.OsTypes.*;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class GetDriverUtilities {
    public static OsTypes getOs() {
        if (RUN_MODE.downloadSettings.os != null)
            return RUN_MODE.downloadSettings.os;
        String osName = System.getProperty("os.name").toLowerCase();
        return Switch(osName).get(
                Case(os -> os.contains("mac"), MAC),
                Case(os -> os.contains("win") || os.contains("ms"), WIN),
                Default(LINUX)
        );
    }

    public static WebDriver getLocalDriver(DriverTypes browser, MutableCapabilities options) {
        try {
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
            throw new JDINovaException(ex, "Failed to run local driver '%s'", browser.name);
        }
    }

    public static boolean hasVersion(String version) {
        if (isBlank(version)) {
            return false;
        }
        char c = version.charAt(0);
        return c >= '0' && c <= '9';
    }
}
