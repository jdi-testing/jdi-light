package com.epam.jdi.light.driver.get;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import static com.epam.jdi.light.driver.get.DriverData.*;
import static com.epam.jdi.light.driver.get.DriverTypes.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverInfos {
    public static DriverInfo CHROME_INFO = new DriverInfo()
        .set(d -> {
            d.type = CHROME;
            d.capabilities = CHROME_OPTIONS;
            d.properties = "webdriver.chrome.driver";
            d.path = chromeDriverPath();
            d.getDriver = () -> new ChromeDriver((ChromeOptions) d.capabilities.execute());
        }
    );
    public static DriverInfo FF_INFO = new DriverInfo()
        .set(d -> {
            d.type = FIREFOX;
            d.capabilities = FIREFOX_OPTIONS;
            d.properties = "webdriver.chrgeckoome.driver";
            d.path = firefoxDriverPath();
            d.getDriver = () -> new FirefoxDriver((FirefoxOptions) d.capabilities.execute());
        }
    );
    public static DriverInfo IE_INFO = new DriverInfo()
        .set(d -> {
            d.type = IE;
            d.capabilities = IE_OPTIONS;
            d.properties = "webdriver.ie.driver";
            d.path = ieDriverPath();
            d.getDriver = () -> new InternetExplorerDriver((InternetExplorerOptions) d.capabilities.execute());
        }
    );
}
