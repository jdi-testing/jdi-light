package com.epam.jdi.light.mobile.elements.common;

import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.appmanagement.ApplicationState;

import java.time.Duration;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class AppManager {
    // current app (AUT)
    public static void launchApp() {
        executeDriverMethod(InteractsWithApps.class, InteractsWithApps::launchApp);
    }
    public static void closeApp() {
        executeDriverMethod(InteractsWithApps.class, InteractsWithApps::closeApp);
    }
    public static void resetApp() {
        executeDriverMethod(InteractsWithApps.class, InteractsWithApps::resetApp);
    }
    public static void runAppInBackground(Duration duration) {
        executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.runAppInBackground(duration));
    }

    // some other app
    public static void activateApp(String bundleId) {
        executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.activateApp(bundleId));
    }
    public static boolean terminateApp(String bundleId) {
        return executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.terminateApp(bundleId));
    }
    public static ApplicationState queryAppState(String bundleId) {
        return executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.queryAppState(bundleId));
    }
    public static void installApp(String appPath) {
        executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.installApp(appPath));
    }
    public static boolean removeApp(String bundleId) {
        return executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.removeApp(bundleId));
    }
    public static boolean isAppInstalled(String bundleId) {
        return executeDriverMethod(InteractsWithApps.class, (InteractsWithApps driver) -> driver.isAppInstalled(bundleId));
    }
}
