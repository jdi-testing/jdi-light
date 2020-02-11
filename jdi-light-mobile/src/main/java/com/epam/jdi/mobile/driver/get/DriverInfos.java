package com.epam.jdi.mobile.driver.get;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.epam.jdi.mobile.driver.get.DriverData.CHROME_OPTIONS;
import static com.epam.jdi.mobile.driver.get.DriverData.MOBILE_OPTIONS;
import static com.epam.jdi.mobile.driver.get.DriverData.chromeDriverPath;
import static com.epam.jdi.mobile.driver.get.DriverData.getCapabilities;
import static com.epam.jdi.mobile.driver.get.DriverTypes.APPIUM;
import static com.epam.jdi.mobile.driver.get.DriverTypes.CHROME;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverInfos {
    public static DriverInfo MOBILE_INFO = new DriverInfo()
            .set(d -> {
                        d.type = APPIUM;
                        d.initCapabilities = new DesiredCapabilities();
                        d.capabilities = c -> getCapabilities(c, cap -> MOBILE_OPTIONS.execute((DesiredCapabilities) cap));
                        d.getDriver = c -> new AppiumDriver((DesiredCapabilities) c);
                    }
            );
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
}
