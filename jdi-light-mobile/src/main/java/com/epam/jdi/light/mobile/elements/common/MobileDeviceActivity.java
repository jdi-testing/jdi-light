package com.epam.jdi.light.mobile.elements.common;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class MobileDeviceActivity {

    public static void startActivity(String pack, String activityName) {
        executeDriverMethod(AndroidDriver.class,
                (AndroidDriver driver) -> driver.startActivity(new Activity(pack, activityName)));
    }

    public static String currentActivity() {
        return executeDriverMethod(AndroidDriver.class,
                (AndroidDriver driver)->driver.currentActivity());
    }

    public static String currentPackage() {
        return executeDriverMethod(AndroidDriver.class,
                (AndroidDriver driver) -> driver.getCurrentPackage());
    }
}
