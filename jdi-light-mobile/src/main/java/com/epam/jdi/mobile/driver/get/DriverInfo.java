package com.epam.jdi.mobile.driver.get;

import com.epam.jdi.mobile.logger.ILogger;
import com.epam.jdi.tools.DataClass;
import com.epam.jdi.tools.func.JFunc1;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.common.Exceptions.safeException;
import static com.epam.jdi.mobile.driver.WebDriverFactory.isMobile;
import static com.epam.jdi.mobile.driver.get.DownloadDriverManager.downloadDriver;
import static com.epam.jdi.mobile.driver.get.DownloadDriverManager.wdm;
import static com.epam.jdi.mobile.driver.get.DriverData.DRIVERS_FOLDER;
import static com.epam.jdi.mobile.driver.get.DriverData.DRIVER_VERSION;
import static com.epam.jdi.mobile.driver.get.DriverData.LATEST_VERSION;
import static com.epam.jdi.mobile.driver.get.DriverData.PLATFORM;
import static java.lang.Integer.parseInt;
import static java.lang.System.setProperty;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import com.epam.jdi.mobile.logger.ILogger;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DriverInfo extends DataClass<DriverInfo> {
    public DriverTypes type;
    public MutableCapabilities initCapabilities;
    public JFunc1<MutableCapabilities, Object> capabilities;
    public String properties, path;
    public JFunc1<Object, WebDriver> getDriver;
    private ILogger logger;


    public WebDriver getDriver() {
        if (isMobile()) {
            return setupMobile();
        } else {
            return setupWebDriver();
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

    private WebDriver setupWebDriver() {
        try {
            if (isNotBlank(DRIVERS_FOLDER)) {
                setProperty(properties, path);
                logger.info("Get local driver: " + path);
            }
            else {
                downloadDriver(type, PLATFORM, DRIVER_VERSION);
            }
            return getDriver.execute(capabilities.execute(initCapabilities));
        } catch (Exception ex) {
            try {
                if (isBlank(DRIVERS_FOLDER) && DRIVER_VERSION.equals(LATEST_VERSION)) {
                    logger.info("Failed to download driver (%s %s) of latest version:" +
                            "TRY TO GET DRIVER PREVIOUS VERSION", type, DRIVER_VERSION);
                    try {
                        downloadDriver(type, PLATFORM, getBelowVersion());
                        return getDriver.execute(capabilities.execute(initCapabilities));
                    } catch (Exception ex2) { throw exception(ex2, "Failed to download driver"); }
                }
                throw exception(safeException(ex));
            } catch (Exception ex2) {
                throw exception(ex2, "Failed to setup local driver");
            }
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
