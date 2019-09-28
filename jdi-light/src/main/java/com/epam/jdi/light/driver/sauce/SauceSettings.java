package com.epam.jdi.light.driver.sauce;

import com.epam.jdi.tools.DataClass;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class SauceSettings extends DataClass<SauceSettings> {
    public String username = getenv("SAUCE_USERNAME");
    public String accessKey = getenv("SAUCE_ACCESS_KEY");
    public String seleniumVersion = "";
    public String name = "Jdi test";
    public String maxDuration = "3600";
    public String commandTimeout = "600";
    public String idleTimeout = "1000";
    public String build = "Build of test run for JDI";
    public String browserName = "";
    public String browserVersion = "";
    public String platformName = "";
    public String screenResolution = "";
    public String timeZone = "";
    public boolean recordVideo = false;
    public boolean videoUploadOnPass = false;
    public boolean recordScreenshots = false;
    public boolean recordLogs = false;
    public int priority = 0;
    public boolean extendedDebugging = false;
    public boolean capturePerformance = false;

    public Map<String, String> asCapabilities() {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, Object> pair : getFieldsAsMap().entrySet())
            if (isNotBlank(pair.getValue().toString()))
                result.put(pair.getKey(), pair.getValue().toString());
        return result;
    }
}
