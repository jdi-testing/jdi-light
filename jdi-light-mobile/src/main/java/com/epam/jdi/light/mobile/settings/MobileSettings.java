package com.epam.jdi.light.mobile.settings;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.settings.WebSettings;

import static com.epam.jdi.light.driver.get.RemoteDriver.*;
import static com.epam.jdi.light.mobile.driver.MobileDriverData.*;
import static com.epam.jdi.light.mobile.driver.MobileDriverInfos.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.PropertyReader.*;

/**
 * Created by Roman Iovlev on 20.03.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class MobileSettings {
    public static synchronized void init() {
        if (initialized) return;
        WebSettings.init();
        DRIVER.types.add("android", ANDROID_INFO);
        DRIVER.types.add("ios", IOS_INFO);
        ELEMENT.beforeSearch = el -> {};
        ELEMENT.clickType = ElementArea.CENTER;
        fillAction(p -> DRIVER.remoteUrl = getRemoteUrl(p), "remote.type");
        loadCapabilities("android.capabilities.path","android.properties",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_ANDROID.put(key.toString(), value.toString())));
        loadCapabilities("ios.capabilities.path","ios.properties",
            p -> p.forEach((key,value) -> CAPABILITIES_FOR_IOS.put(key.toString(), value.toString())));
        initialized = true;
    }
    private static String getRemoteUrl(String prop) {
        String trimProp = prop.toLowerCase().replaceAll(" ", "");
        return trimProp.equals("appium") ? appium() : "";
    }
}
