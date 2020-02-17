package com.epam.jdi.mobile.driver.get;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
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

import static com.epam.jdi.mobile.driver.get.DriverData.*;
import static com.epam.jdi.mobile.driver.get.DriverTypes.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverInfos {
    public static DriverInfo CHROME_INFO = new DriverInfo()
        .set(d -> {
            d.type = CHROME;
            d.initCapabilities = new ChromeOptions();
            d.capabilities = c -> getCapabilities(c, cap -> CHROME_OPTIONS.execute((ChromeOptions) cap));
            d.properties = "webdriver.chrome.driver";
            d.path = chromeDriverPath();
            d.getDriver = c -> new ChromeDriver((ChromeOptions) c);
        }
    );
    public static DriverInfo APPIUM_INFO = new DriverInfo()
        .set(d -> {
            d.type = APPIUM;
            //TODO Remove hardcode in creating capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            d.initCapabilities = capabilities;
            d.getDriver = c -> new AppiumDriver<>(capabilities);
                    }
            );
    public static DriverInfo FF_INFO = new DriverInfo()
        .set(d -> {
            d.type = FIREFOX;
            d.initCapabilities = new FirefoxOptions();
            d.capabilities = c -> getCapabilities(c, cap -> FIREFOX_OPTIONS.execute((FirefoxOptions) cap));
            d.properties = "webdriver.gecko.driver";
            d.path = firefoxDriverPath();
            d.getDriver = c -> new FirefoxDriver((FirefoxOptions) c);
        }
    );
    public static DriverInfo IE_INFO = new DriverInfo()
        .set(d -> {
            d.type = IE;
            d.initCapabilities = new InternetExplorerOptions();
            d.capabilities = c -> getCapabilities(c, cap -> IE_OPTIONS.execute((InternetExplorerOptions) cap));
            d.properties = "webdriver.ie.driver";
            d.path = ieDriverPath();
            d.getDriver = c -> new InternetExplorerDriver((InternetExplorerOptions) c);
        }
    );
    public static DriverInfo OPERA_INFO = new DriverInfo()
        .set(d -> {
            d.type = OPERA;
            d.initCapabilities = new OperaOptions();
            d.capabilities = c -> getCapabilities(c, cap -> OPERA_OPTIONS.execute((OperaOptions) cap));
            d.properties = "webdriver.opera.driver";
            d.path = operaDriverPath();
            d.getDriver = c -> new OperaDriver((OperaOptions) c);
        }
    );
    public static DriverInfo EDGE_INFO = new DriverInfo()
        .set(d -> {
            d.type = EDGE;
            d.initCapabilities = new EdgeOptions();
            d.capabilities = c -> getCapabilities(c, cap -> EDGE_OPTIONS.execute((EdgeOptions) cap));
            d.properties = "webdriver.edge.driver";
            d.path = operaDriverPath();
            d.getDriver = c -> new EdgeDriver((EdgeOptions) c);
        }
    );
}
