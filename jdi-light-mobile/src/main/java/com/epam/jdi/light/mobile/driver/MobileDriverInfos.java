package com.epam.jdi.light.mobile.driver;

import com.epam.jdi.light.driver.get.DriverInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static com.epam.jdi.light.driver.get.DriverData.getCapabilities;
import static com.epam.jdi.light.driver.get.RemoteDriver.getRemoteURL;
import static com.epam.jdi.light.mobile.driver.MobileDriverData.ANDROID_OPTIONS;
import static com.epam.jdi.light.mobile.driver.MobileDriverData.IOS_OPTIONS;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class MobileDriverInfos {
    public static DriverInfo ANDROID_INFO = new DriverInfo()
        .set(d -> {
            d.initCapabilities = new DesiredCapabilities();
            d.capabilities = c -> getCapabilities(c, ANDROID_OPTIONS::execute);
            d.getRemoteDriver = c -> new AndroidDriver<>(new URL(getRemoteURL()), c);
        }
    );
public static DriverInfo IOS_INFO = new DriverInfo()
        .set(d -> {
            d.initCapabilities = new DesiredCapabilities();
            d.capabilities = c -> getCapabilities(c, IOS_OPTIONS::execute);
            d.getRemoteDriver = c -> new IOSDriver<>(new URL(getRemoteURL()), c);
        }
    );
}
