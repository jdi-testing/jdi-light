package com.epam.jdi.mobile.driver.get;

import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.func.JFunc1;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.driver.WebDriverFactory.isMobile;
import static com.epam.jdi.mobile.driver.get.DownloadDriverManager.wdm;
import static java.lang.Integer.parseInt;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverInfo extends DataClass<DriverInfo> {
    public DriverTypes type;
    public DesiredCapabilities initCapabilities;
    public JFunc1<DesiredCapabilities, Capabilities> capabilities;
    public JFunc1<Object, AppiumDriver> getDriver;

    public AppiumDriver getDriver() {
        if (isMobile()) {
            return setupMobile();
        } else {
            return null;
        }
    }

    private AppiumDriver setupMobile() {
        try {
            return new AppiumDriver(new URL(MobileDriver.DRIVER_MOBILE_URL), getCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browserName = "Chrome";

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileDriver.DEVICE_ID); // default Android emulator​

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileDriver.PLATFORM);        // Setup type of application: mobile, web (or hybrid)​
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileDriver.PLATFORM_VERSION);
//        capabilities.setCapability(MobileCapabilityType.UDID, MobileDriver.UDID);
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, MobileDriver.AUTOMATION_NAME);
        return capabilities;
    }

    public static String getBelowVersion() {
        String currentMajor = wdm.getDownloadedVersion().split("\\.")[0];
        List<String> allVersions = wdm.getVersions();
        for (int i = allVersions.size() - 1; i >= 0; i--)
            if (parseInt(currentMajor) > parseInt(allVersions.get(i).split("\\.")[0]))
                return allVersions.get(i);
        throw exception("Can't find version below current(" + wdm.getDownloadedVersion() + ")");
    }
}
