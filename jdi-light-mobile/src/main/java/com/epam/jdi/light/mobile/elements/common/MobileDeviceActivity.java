package com.epam.jdi.light.mobile.elements.common;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class MobileDeviceActivity {

    // @todo Current implementation have a lot of parameters for start activity
    // https://github.com/appium/appium-uiautomator2-driver#mobile-startactivity
    public static void startActivity(String pack, String activityName) {
        executeDriverMethod(AppiumDriver.class,
                (AppiumDriver driver) -> driver.executeScript("mobile: startActivity",
                       ImmutableMap.of("intent", pack + activityName)));
    }

    public static String currentActivity() {
        return executeDriverMethod(AndroidDriver.class,
                StartsActivity::currentActivity);
    }

    public static String currentPackage() {
        return executeDriverMethod(AndroidDriver.class,
                StartsActivity::getCurrentPackage);
    }
}
