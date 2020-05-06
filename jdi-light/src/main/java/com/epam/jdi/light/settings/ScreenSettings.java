package com.epam.jdi.light.settings;

import com.epam.jdi.tools.func.JFunc1;

import java.io.File;

import static com.epam.jdi.light.settings.CommonSettings.getCommonSettings;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.PathUtils.path;
import static com.epam.jdi.tools.Timer.nowTime;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class ScreenSettings {

    public ScreenSettings() {
        path = mergePath(getCommonSettings().logsPath, "screens");
        fileSuffix = "jpg";
    }

    public String path;
    public String fileSuffix;

    public JFunc1<String, String> getScreenName = screenName -> {
        String fileName = mergePath(getPath(), screenName + nowTime("yyyy-MM-dd-HH-mm-ss"));
        int num = 2;
        String newName;
        do {
            newName = format("%s_%s.%s", fileName, num++, fileSuffix);
        } while (new File(newName).exists());
        return newName;
    };
    private String getPath() {
        if (isBlank((path))) return "";
        String result = path.replace("/", "\\");
        return result.contains(":")
            ? path
            : mergePath(path(""), path);
    }
}
