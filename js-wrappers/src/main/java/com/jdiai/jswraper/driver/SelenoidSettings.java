package com.jdiai.jswraper.driver;

// https://github.com/aerokube/selenoid/blob/master/docs/special-capabilities.adoc

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelenoidSettings {
    public Map<String, Object> customSettings;

    public boolean enableVNC;
    public String screenResolution;

    public boolean enableVideo;
    public String videoName;
    public String videoScreenSize;
    public String videoFrameRate;

    public String videoCodec;
    public boolean enableLog;
    public String logName;

    public String name;
    public String sessionTimeout;
    public String timeZone;
    public List<String> env;
    public List<String> applicationContainers;
    public List<String> hostsEntries;
    public List<String> dnsServers;
    public List<String> additionalNetworks;
    public List<String> labels;
    public String skin;
    public String s3KeyPattern;

    public Map<String, Object> getSelenoidOptions() {
        if (customSettings != null) {
            return customSettings;
        }

        Map<String, Object> options = new HashMap<>();
        options.put("enableVNC", enableVNC);
        if (screenResolution != null) {
            options.put("screenResolution", screenResolution);
        }

        options.put("enableVideo", enableVideo);
        if (videoName != null) {
            options.put("videoName", videoName);
        }
        if (videoScreenSize != null) {
            options.put("videoScreenSize", videoScreenSize);
        }
        if (videoFrameRate != null) {
            options.put("videoFrameRate", videoFrameRate);
        }
        if (videoCodec != null) {
            options.put("videoCodec", videoCodec);
        }

        options.put("enableLog", enableLog);
        if (logName != null) {
            options.put("logName", logName);
        }

        if (name != null) {
            options.put("name", name);
        }
        if (sessionTimeout != null) {
            options.put("sessionTimeout", sessionTimeout);
        }
        if (timeZone != null) {
            options.put("timeZone", timeZone);
        }
        // options.put("env", env);
        // options.put("applicationContainers", applicationContainers);
        // options.put("hostsEntries", hostsEntries);
        // options.put("dnsServers", dnsServers);
        // options.put("additionalNetworks", additionalNetworks);
        // options.put("labels", labels);
        options.put("skin", skin);
        options.put("s3KeyPattern", s3KeyPattern);
        return options;
    }
}
