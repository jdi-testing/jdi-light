package com.epam.jdi.mobile.driver.sauce;

import com.epam.jdi.tools.DataClass;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.getenv;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class SauceSettings extends DataClass<SauceSettings> {
    public static String username = getenv("SAUCE_USERNAME");
    public static String accessKey = getenv("SAUCE_ACCESS_KEY");
    public static String seleniumVersion;
    public static String name = "Jdi tests";
    public static String maxDuration = "3600";
    public static String commandTimeout = "600";
    public static String idleTimeout = "1000";
    public static String build = "JDI uild";
    public static String browserName;
    public static String browserVersion;
    public static String platformName;
    public static String screenResolution;
    public static String timeZone;
    public static boolean recordVideo;
    public static boolean videoUploadOnPass;
    public static boolean recordScreenshots;
    public static boolean recordLogs ;
    public static int priority;
    public static boolean extendedDebugging;
    public static boolean capturePerformance;

    public static Map<String, String> sauceCapabilities() {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, Object> pair : new SauceSettings().getFieldsAsMap().entrySet()) {
            Object value = pair.getValue();
            if (value != null && isNotBlank(value.toString()))
                result.put(pair.getKey(), pair.getValue().toString());
        }
        return result;
    }
}
