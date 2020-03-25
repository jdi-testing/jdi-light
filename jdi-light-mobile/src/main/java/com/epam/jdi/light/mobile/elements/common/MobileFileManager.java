package com.epam.jdi.light.mobile.elements.common;

import io.appium.java_client.InteractsWithFiles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class MobileFileManager {
    public static byte[] pullFile(String remotePath) {
        return executeDriverMethod(InteractsWithFiles.class, (InteractsWithFiles driver) -> driver.pullFile(remotePath));
    }
    public static byte[] pullFolder(String remotePath) {
        return executeDriverMethod(InteractsWithFiles.class, (InteractsWithFiles driver) -> driver.pullFolder(remotePath));
    }

    public static void pushFile(String remotePath, byte[] base64Data) {
        WebDriver driver = getDriver();
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).pushFile(remotePath, base64Data);
        } else if (driver instanceof IOSDriver) {
            ((IOSDriver) driver).pushFile(remotePath, base64Data);
        } else {
            throw exception("Cannot use this method. The driver needs to extend/implement the PushesFiles interface");
        }
    }
    public static void pushFile(String remotePath, File file) throws IOException {
        WebDriver driver = getDriver();
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).pushFile(remotePath, file);
        } else if (driver instanceof IOSDriver) {
            ((IOSDriver) driver).pushFile(remotePath, file);
        } else {
            throw exception("Cannot use this method. The driver needs to extend/implement the PushesFiles interface");
        }
    }
}
