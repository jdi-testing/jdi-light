package com.epam.jdi.light.driver.get;

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

import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverInfos {
    public static final DriverInfo CHROME_INFO = new DriverInfo()
        .set(d -> {
            d.downloadType = CHROME;
            d.initCapabilities = new ChromeOptions();
            d.capabilities = c -> getCapabilities(c, cap -> CHROME_OPTIONS.execute((ChromeOptions) cap));
            d.properties = "webdriver.chrome.driver";
            d.path = DriverData::chromeDriverPath;
            d.getDriver = c -> new ChromeDriver((ChromeOptions) c);
        }
    );
    public static final DriverInfo FIREFOX_INFO = new DriverInfo()
        .set(d -> {
            d.downloadType = FIREFOX;
            d.initCapabilities = new FirefoxOptions();
            d.capabilities = c -> getCapabilities(c, cap -> FIREFOX_OPTIONS.execute((FirefoxOptions) cap));
            d.properties = "webdriver.gecko.driver";
            d.path = DriverData::firefoxDriverPath;
            d.getDriver = c -> new FirefoxDriver((FirefoxOptions) c);
        }
    );
    public static final DriverInfo IE_INFO = new DriverInfo()
        .set(d -> {
            d.downloadType = IE;
            d.initCapabilities = new InternetExplorerOptions();
            d.capabilities = c -> getCapabilities(c, cap -> IE_OPTIONS.execute((InternetExplorerOptions) cap));
            d.properties = "webdriver.ie.driver";
            d.path = DriverData::ieDriverPath;
            d.getDriver = c -> new InternetExplorerDriver((InternetExplorerOptions) c);
        }
    );
    public static DriverInfo OPERA_INFO = new DriverInfo()
        .set(d -> {
            d.downloadType = OPERA;
            d.initCapabilities = new OperaOptions();
            d.capabilities = c -> getCapabilities(c, cap -> OPERA_OPTIONS.execute((OperaOptions) cap));
            d.properties = "webdriver.opera.driver";
            d.path = DriverData::operaDriverPath;
            d.getDriver = c -> new OperaDriver((OperaOptions) c);
        }
    );
    public static DriverInfo EDGE_INFO = new DriverInfo()
        .set(d -> {
            d.downloadType = EDGE;
            d.initCapabilities = new EdgeOptions();
            d.capabilities = c -> getCapabilities(c, cap -> EDGE_OPTIONS.execute((EdgeOptions) cap));
            d.properties = "webdriver.edge.driver";
            d.path = DriverData::edgeDriverPath;
            d.getDriver = c -> new EdgeDriver((EdgeOptions) c);
        }
    );
    public static DriverInfo SAFARI_INFO = new DriverInfo()
        .set(d -> {
            d.downloadType = SAFARI;
            d.initCapabilities = new SafariOptions();
            d.capabilities = c -> getCapabilities(c, cap -> SAFARI_OPTIONS.execute((SafariOptions) cap));
            d.properties = "webdriver.safari.driver";
            d.path = DriverData::safariDriverPath;
            d.getDriver = c -> new SafariDriver((SafariOptions) c);
        }
    );
}
