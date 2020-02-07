package com.epam.jdi.mobile.driver;

import com.epam.jdi.mobile.logger.AllureLoggerHelper.AttachmentStrategy;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.mobile.driver.WebDriverFactory.hasRunDrivers;
import static com.epam.jdi.mobile.driver.get.DriverData.LOGS_PATH;
import static com.epam.jdi.mobile.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.mobile.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.mobile.settings.WebSettings.logger;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static com.epam.jdi.tools.Timer.nowTime;
import static org.apache.commons.io.FileUtils.copyFile;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.openqa.selenium.OutputType.FILE;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ScreenshotMaker {
    public static String SCREEN_PATH = LOGS_PATH + "\\screens";
    public static String SCREEN_NAME = "screen";
    public static String SCREEN_FILE_SUFFIX = ".jpg";
    public static AttachmentStrategy SCREENSHOT_STRATEGY = AttachmentStrategy.ON_FAIL;
    public static String takeScreenOnFailure() {
        return SCREENSHOT_STRATEGY == AttachmentStrategy.ON_FAIL
            ? takeScreen()
            : null;
    }

    public static String takeScreen() {
        return new ScreenshotMaker().takeScreenshot();
    }

    public static String getPath() {
        if (isBlank((SCREEN_PATH))) return "";
        String result = SCREEN_PATH.replace("/", "\\");
        return result.contains(":")
            ? SCREEN_PATH
            : PROJECT_PATH + SCREEN_PATH;
    }
    public String takeScreenshot() {
        String name = TEST_NAME.get();
        return takeScreenshot(isNotBlank(name) ? name : SCREEN_NAME, "yyyy-MM-dd-HH-mm-ss");
    }
    public String takeScreenshot(String value) {
        return takeScreenshot(value, "yyyy-MM-dd-HH-mm-ss");
    }
    public String takeScreenshot(String name, String dateFormat) {
        if (!hasRunDrivers())
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
        while (new File(newName + SCREEN_FILE_SUFFIX).exists())
            newName = fileName + "_" + num++;
        return newName + SCREEN_FILE_SUFFIX;
    }
}