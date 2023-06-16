package com.epam.jdi.light.mobile.elements.common;

import com.epam.jdi.light.common.JDIAction;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class AppManager {
    // current app (AUT)
    @JDIAction("Launch the app under test")
    public static void launchApp() {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            executeDriverMethod(AndroidDriver.class, AndroidDriver::launchApp);
        } else {
            executeDriverMethod(IOSDriver.class, IOSDriver::launchApp);
        }
    }
    @JDIAction("Close the app under test")
    public static void closeApp() {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            executeDriverMethod(AndroidDriver.class, AndroidDriver::closeApp);
        } else {
            executeDriverMethod(IOSDriver.class, IOSDriver::closeApp);
        }
    }
    @JDIAction("Reset the app under test")
    public static void resetApp() {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            executeDriverMethod(AndroidDriver.class, AndroidDriver::resetApp);
        } else {
            executeDriverMethod(IOSDriver.class, IOSDriver::resetApp);
        }
    }
    @JDIAction("Run the app under test in background")
    public static void runAppInBackground(Duration duration) {
        executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.runAppInBackground(duration));
    }

    // some other app
    @JDIAction("Activate the '{0}' app")
    public static void activateApp(String bundleId) {
        executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.activateApp(bundleId));
    }
    @JDIAction("Terminate the '{0}' app")
    public static boolean terminateApp(String bundleId) {
        return executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.terminateApp(bundleId));
    }
    @JDIAction("Query the state of the '{0}' app")
    public static ApplicationState queryAppState(String bundleId) {
        return executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.queryAppState(bundleId));
    }
    @JDIAction("Install the '{0}' app")
    public static void installApp(String appPath) {
        executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.installApp(appPath));
    }
    @JDIAction("Remove the '{0}' app")
    public static boolean removeApp(String bundleId) {
        return executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.removeApp(bundleId));
    }
    @JDIAction("Check whether the '{0}' app is installed")
    public static boolean isAppInstalled(String bundleId) {
        return executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.isAppInstalled(bundleId));
    }
}
