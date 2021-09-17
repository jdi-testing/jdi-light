package com.epam.jdi.light.driver;

import com.jdiai.tools.func.JFunc2;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverFactory.noRunDrivers;
import static com.epam.jdi.light.settings.JDISettings.COMMON;
import static com.epam.jdi.light.settings.JDISettings.SCREEN;
import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.PathUtils.mergePath;
import static com.jdiai.tools.Timer.nowTime;
import static java.awt.Toolkit.getDefaultToolkit;
import static org.apache.commons.io.FileUtils.copyFile;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.openqa.selenium.OutputType.FILE;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ScreenshotMaker {
    public static String SCREEN_NAME = "screen";
    public static String DEFAULT_DATE = "yyyy-MM-dd-HH-mm-ss";
    public static JFunc2<String, String, String> FILE_NAME =
        (name, dateFormat) -> nowTime(dateFormat) + name;

    public static String takeScreen() {
        return new ScreenshotMaker().takeScreenshot();
    }
    public static String takeScreen(String name) {
        return new ScreenshotMaker().takeScreenshot(name);
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
        return takeScreenshot(isNotBlank(name) ? name : SCREEN_NAME, DEFAULT_DATE);
    }
    public String takeScreenshot(String value) {
        return takeScreenshot(value, DEFAULT_DATE);
    }
    public String takeScreenshot(String name, String dateFormat) {
        if (noRunDrivers())
            throw exception("Failed to do screenshot. No Drivers run");
        String screensFilePath = getFileName(mergePath(
            getPath(), FILE_NAME.execute(name, dateFormat)));
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

    private static String getFileName(String fileName) {
        int num = 1;
        String newName = fileName;
        while (new File(newName + SCREEN.fileSuffix).exists())
            newName = fileName + "_" + num++;
        return newName + "." + SCREEN.fileSuffix;
    }

    public static String takeRobotScreenshot() {
        String name = TEST_NAME.get();
        return takeRobotScreenshot(isNotBlank(name) ? name : SCREEN_NAME, DEFAULT_DATE);
    }
    public static String takeRobotScreenshot(String name) {
        return takeRobotScreenshot(name, DEFAULT_DATE);
    }
    public static String takeRobotScreenshot(String name, String dateFormat) {
        if (!SCREEN.allowRobot)
            return new ScreenshotMaker().takeScreenshot(name, dateFormat);
        String screensFilePath = getFileName(mergePath(getPath(), FILE_NAME.execute(name, dateFormat)));
        try {
            Rectangle rectangle = new Rectangle(getDefaultToolkit().getScreenSize());
            new File(screensFilePath).getParentFile().mkdirs();
            Robot robot = new Robot();
            BufferedImage img = robot.createScreenCapture(rectangle);
            ImageIO.write(img, "jpg", new File(screensFilePath));
        } catch (Exception ex) {
            throw exception(ex, "Failed to do screenshot with robot");
        }
        logger.info("Screenshot: " + screensFilePath);
        return screensFilePath;
    }
}