package com.epam.jdi.light.mobile.elements.common.network;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.SupportsNetworkStateManagement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.HasNetworkConnection;

import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

/**
 * Only for Android
 */
public class Toggle {

    public static void toggleWifi(){
        executeDriverMethod(AndroidDriver.class, SupportsNetworkStateManagement::toggleWifi);
    }

    /**
     * Work only on android version >= 7
     */
    public static void toggleAirplaneMode(){
        executeDriverMethod(AndroidDriver.class, SupportsNetworkStateManagement::toggleAirplaneMode);
    }

    public static void toggleData(){
        executeDriverMethod(AndroidDriver.class, SupportsNetworkStateManagement::toggleData);
    }

    public static ConnectionState getConnection(){
        return executeDriverMethod(AndroidDriver.class, HasNetworkConnection::getConnection);
    }
}