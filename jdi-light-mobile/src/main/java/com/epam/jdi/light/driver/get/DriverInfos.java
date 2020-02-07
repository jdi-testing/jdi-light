package com.epam.jdi.light.driver.get;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.epam.jdi.light.driver.get.DriverData.MOBILE_OPTIONS;
import static com.epam.jdi.light.driver.get.DriverData.getCapabilities;
import static com.epam.jdi.light.driver.get.DriverTypes.APPIUM;

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
}
