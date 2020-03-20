package com.epam.jdi.light.mobile.settings;

import static com.epam.jdi.light.driver.get.DriverInfos.*;
import static com.epam.jdi.light.mobile.driver.MobileDriverInfos.*;

/**
 * Created by Roman Iovlev on 20.03.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class MobileSettings {
    private static boolean initialized = false;
    public static synchronized void init() {
        // setup mobile specific
        initialized = true;
        DRIVER_TYPES.add("android", ANDROID_INFO);
        DRIVER_TYPES.add("ios", IOS_INFO);
    }
}
