package com.epam.jdi.mobile.driver.appium;

import com.epam.jdi.mobile.driver.sauce.SauceSettings;
import com.epam.jdi.tools.DataClass;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class AppiumSettings extends DataClass<AppiumSettings> {

    public static String platformName = "Android";
    public static String deviceName = "emulator-5554";
    public static String browserName = "Chrome";

    //TODO code duplication with SauseSettings. Fix it
    public static Map<String, String> appiumCapabilities() {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, Object> pair : new SauceSettings().getFieldsAsMap().entrySet()) {
            Object value = pair.getValue();
            if (value != null && isNotBlank(value.toString()))
                result.put(pair.getKey(), pair.getValue().toString());
        }
        return result;
    }
}
