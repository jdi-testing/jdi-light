package com.epam.jdi.light.mobile.settings;

import com.epam.jdi.light.settings.JDISettings;
import com.epam.jdi.light.settings.WebSettings;

import static com.epam.jdi.light.driver.get.RemoteDriver.appium;
import static com.epam.jdi.light.mobile.driver.MobileDriverData.CAPABILITIES_FOR_ANDROID;
import static com.epam.jdi.light.mobile.driver.MobileDriverData.CAPABILITIES_FOR_IOS;
import static com.epam.jdi.light.mobile.driver.MobileDriverInfos.ANDROID_INFO;
import static com.epam.jdi.light.mobile.driver.MobileDriverInfos.IOS_INFO;
import static com.epam.jdi.light.settings.JDISettings.getJDISettings;
import static com.epam.jdi.light.settings.WebSettings.getWebSettings;
import static com.epam.jdi.tools.PropertyReader.fillAction;

/**
 * Created by Roman Iovlev on 20.03.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class MobileSettings {
    private static final WebSettings webSettings = getWebSettings();
    private static final JDISettings jdiSettings = getJDISettings();

    public static synchronized void init() {
        if (webSettings.initialized) return;
        webSettings.init();
        jdiSettings.DRIVER.types.add("android", ANDROID_INFO);
        jdiSettings.DRIVER.types.add("ios", IOS_INFO);
        fillAction(p -> jdiSettings.DRIVER.remoteUrl = getRemoteUrl(p), "remote.type");
        webSettings.loadCapabilities("android.capabilities.path", "android.properties",
                p -> p.forEach((key, value) -> CAPABILITIES_FOR_ANDROID.put(key.toString(), value.toString())));
        webSettings.loadCapabilities("ios.capabilities.path", "ios.properties",
                p -> p.forEach((key, value) -> CAPABILITIES_FOR_IOS.put(key.toString(), value.toString())));
        webSettings.initialized = true;
    }
    private static String getRemoteUrl(String prop) {
        String trimProp = prop.toLowerCase().replaceAll(" ", "");
        return trimProp.equals("appium") ? appium() : "";
    }
}
