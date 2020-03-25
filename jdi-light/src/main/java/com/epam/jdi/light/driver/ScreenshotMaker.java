package com.epam.jdi.light.driver;

import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.driver.WebDriverFactory.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.PathUtils.*;
import static com.epam.jdi.tools.Timer.*;
import static org.apache.commons.io.FileUtils.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.openqa.selenium.OutputType.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ScreenshotMaker {
    public static String SCREEN_NAME = "screen";

    public static String takeScreen() {
        return new ScreenshotMaker().takeScreenshot();
    }

    public static String getPath() {
        if (isBlank((SCREEN.path))) return "";
        String result = SCREEN.path.replace("/", "\\");
        return result.contains(":")
            ? SCREEN.path
            : mergePath(COMMON.projectPath, SCREEN.path);
    }
    public String takeScreenshot() {
        String name = TEST_NAME.get();
        return takeScreenshot(isNotBlank(name) ? name : SCREEN_NAME, "yyyy-MM-dd-HH-mm-ss");
    }
    public String takeScreenshot(String value) {
        return takeScreenshot(value, "yyyy-MM-dd-HH-mm-ss");
    }
    public String takeScreenshot(String name, String dateFormat) {
        if (noRunDrivers())
            throw exception("Failed to do screenshot. No Drivers run");
        String screensFilePath = getFileName(mergePath(
            getPath(), name + nowTime(dateFormat)));
        new File(screensFilePath).getParentFile().mkdirs();
        File screensFile = ((TakesScreenshot) getDriver()).getScreenshotAs(FILE);
        try {
            copyFile(screensFile, new File(screensFilePath));
        } catch (Exception ex) {
            throw exception(ex, "Failed to do screenshot");
        }
        logger.info("Screenshot: " + screensFilePath);
        return screensFilePath;
    }

    private String getFileName(String fileName) {
        int num = 1;
        String newName = fileName;
        while (new File(newName + SCREEN.fileSuffix).exists())
            newName = fileName + "_" + num++;
        return newName + SCREEN.fileSuffix;
    }
}