package com.epam.jdi.light.mobile.elements.common;

import com.epam.jdi.light.common.JDIAction;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.appmanagement.ApplicationState;

import java.time.Duration;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class AppManager {
    // current app (AUT)
    @JDIAction("Launch the app under test")
    public static void launchApp() {
        executeDriverMethod(InteractsWithApps.class, InteractsWithApps::launchApp);
    }
    @JDIAction("Close the app under test")
    public static void closeApp() {
        executeDriverMethod(InteractsWithApps.class, InteractsWithApps::closeApp);
    }
    @JDIAction("Reset the app under test")
    public static void resetApp() {
        executeDriverMethod(InteractsWithApps.class, InteractsWithApps::resetApp);
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
