package com.epam.jdi.light.driver.sauce;

import com.epam.jdi.tools.DataClass;

import java.util.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;

public class SauceSettings extends DataClass<SauceSettings> {
    public static String username = getenv("SAUCE_USERNAME"),
        accessKey = getenv("SAUCE_ACCESS_KEY"),
        seleniumVersion, name = "Jdi tests",
        maxDuration = "3600",
        commandTimeout = "600",
        idleTimeout = "1000",
        build = "JDI uild",
        browserName, browserVersion, platformName, screenResolution, timeZone;
    public static boolean recordVideo, videoUploadOnPass, recordScreenshots, recordLogs, extendedDebugging, capturePerformance;

    public static int priority;

    public static Map<String, String> sauceCapabilities() {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, Object> pair : new SauceSettings().fieldsAsMap().entrySet()) {
            Object value = pair.getValue();
            if (value != null && isNotBlank(value.toString()))
                result.put(pair.getKey(), pair.getValue().toString());
        }
        return result;
    }
}
