package com.epam.jdi.light.mobile.elements.common;

import io.appium.java_client.PullsFiles;
import io.appium.java_client.PushesFiles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class MobileFileManager {
    public static byte[] pullFile(String remotePath) {
        return executeDriverMethod(PullsFiles.class, (PullsFiles driver) -> driver.pullFile(remotePath));
    }
    public static byte[] pullFolder(String remotePath) {
        return executeDriverMethod(PullsFiles.class, (PullsFiles driver) -> driver.pullFolder(remotePath));
    }

    public static void pushFile(String remotePath, byte[] base64Data) {
        WebDriver driver = getDriver();
        if (driver instanceof PushesFiles) {
            ((PushesFiles) driver).pushFile(remotePath, base64Data);
        } else {
            throw runtimeException("Cannot use this method. The driver needs to extend/implement the PushesFiles interface");
        }
    }
    public static void pushFile(String remotePath, File file) throws IOException {
        WebDriver driver = getDriver();
        if (driver instanceof PushesFiles) {
            ((PushesFiles) driver).pushFile(remotePath, file);
        } else {
            throw runtimeException("Cannot use this method. The driver needs to extend/implement the PushesFiles interface");
        }
    }
}
