package com.epam.jdi.light.mobile.elements.common;

import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.PowerACState;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class EmulatorPower {

    public static void setPowerCapacity(int value) {
        executeDriverMethod(AndroidDriver.class, (AndroidDriver driver)
                -> driver.setPowerCapacity(value));
    }

    public static void setPowerAC(PowerACState powerACState) {
        executeDriverMethod(AndroidDriver.class, (AndroidDriver driver)
                -> driver.setPowerAC(powerACState));
    }


    public AndroidBatteryInfo.BatteryState getStatusChargingAndroid() {
        return ((AndroidDriver) getDriver()).getBatteryInfo().getState();
    }

}
