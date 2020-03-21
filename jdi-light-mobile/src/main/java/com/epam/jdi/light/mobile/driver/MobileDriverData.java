package com.epam.jdi.light.mobile.driver;

import com.epam.jdi.tools.func.JAction1;
import org.openqa.selenium.MutableCapabilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class MobileDriverData {
    public static Map<String,String> CAPABILITIES_FOR_ANDROID = new HashMap<>();
    public static Map<String,String> CAPABILITIES_FOR_IOS = new HashMap<>();

    public static void defaultAndroidOptions(MutableCapabilities cap) {
        // Capabilities from settings
        CAPABILITIES_FOR_ANDROID.forEach(cap::setCapability);
    }
    public static JAction1<MutableCapabilities> ANDROID_OPTIONS = MobileDriverData::defaultAndroidOptions;

    public static void defaultIOSOptions(MutableCapabilities cap) {
        // Capabilities from settings
        CAPABILITIES_FOR_IOS.forEach(cap::setCapability);
    }
    public static JAction1<MutableCapabilities> IOS_OPTIONS = MobileDriverData::defaultIOSOptions;
}
