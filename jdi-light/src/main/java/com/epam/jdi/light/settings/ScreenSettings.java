package com.epam.jdi.light.settings;

import com.epam.jdi.tools.func.JFunc1;

import java.io.File;

import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.tools.PathUtils.*;
import static com.epam.jdi.tools.Timer.*;
import static java.lang.String.*;
import static org.apache.commons.lang3.StringUtils.*;

public class ScreenSettings {
    public String path = mergePath(COMMON.logsPath, "screens");
    public String fileSuffix = "jpg";

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
