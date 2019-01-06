package com.epam.jdi.light.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverFactory.hasRunDrivers;
import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.Timer.nowDate;
import static org.apache.commons.io.FileUtils.copyFile;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.openqa.selenium.OutputType.FILE;

public class ScreenshotMaker {
    public static String screensPath = "src/test/java/.logs/images/";
    public String pathSuffix = screensPath;

    public ScreenshotMaker() { }

    /**
     * Creates ScreenShotMaker with pathSuffix
     * @param pathSuffix - path for images store
     */
    public ScreenshotMaker(String pathSuffix) {
        this.pathSuffix = pathSuffix;
    }

    /**
     * Makes screenshot
     * @return String - screenshot path
     * @throws IOException
     */
    public static String takeScreen() {
        return new ScreenshotMaker().takeScreenshot();
    }

    /**
     * Returns correct path
     * @param logPath - path for logs
     * @return String - correct path for logs
     */
    public static String getValidUrl(String logPath) {
        if (isBlank((logPath)))
            return "";
        String result = logPath.replace("/", "\\");
        if (result.charAt(1) != ':')
            if (result.substring(0, 3).equals("..\\"))
                result = result.substring(2);
        if (result.charAt(0) != '\\')
            result = "\\" + result;
        return (result.charAt(result.length() - 1) == '\\')
                ? result
                : result + "\\";
    }

    /**
     * Checks if screenshot was created success
     * @return String - message with screenshot creation result
     */
    public static String doScreenshotGetMessage() {
        String screenshotPath;
        screenshotPath = takeScreen();
        return screenshotPath.equals("")
                ? "Failed to do Screenshot"
                : LINE_BREAK + "Add screenshot to: " + screenshotPath;
    }

    /**
     * Creates screenshot
     * @return String - path to screenshot
     * @throws IOException
     */
    public String takeScreenshot() {
        try {
            if (!hasRunDrivers())
                return "Can't do Screenshot. No Drivers run";
            String path = new File(".").getCanonicalPath() + getValidUrl(pathSuffix);
            String screensFilePath = getFileName(path + (TEST_NAME != null ? TEST_NAME : "screen") + nowDate().replace(":", "-"));
            new File(screensFilePath).getParentFile().mkdirs();
            File screensFile = ((TakesScreenshot) getDriver()).getScreenshotAs(FILE);
            copyFile(screensFile, new File(screensFilePath));
            return screensFilePath;
        } catch (Exception ex) {
            throw exception("Take screenshot failed");
        }
    }

    /**
     * Increments file name if it needs
     * @param fileName - file name for screenshot
     * @return String - file name with increment
     */
    private String getFileName(String fileName) {
        int num = 1;
        String newName = fileName;
        while (new File(newName + ".jpg").exists())
            newName = fileName + "_" + num++;
        return newName + ".jpg";
    }
}