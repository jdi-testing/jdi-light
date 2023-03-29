package com.epam.jdi.light.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.util.Set;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

/**
 * This class helps to perform different interactions with mobile contexts: NATIVE_APP and WEBVIEW
 */
public class MobileContextHolder {
    public static String switchContext() {
        WebDriver driver = getDriver();
        if (driver instanceof AppiumDriver){
            Set<String> contexts = getAvailableContexts();
            String initialContext = getContext();
            contexts.remove(initialContext);
            if (!contexts.isEmpty()) {
                setContext(contexts.iterator().next());
                return getContext();
            } else {
                throw runtimeException("Cannot switch the single context " + initialContext);
            }
        } else {
            throw runtimeException("Cannot use this method. The driver needs to extend the AppiumDriver class");
        }
    }
    public static String getContext() {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            return executeDriverMethod(AndroidDriver.class, AndroidDriver::getContext);
        } else {
            return executeDriverMethod(IOSDriver.class, IOSDriver::getContext);
        }
    }
    public static void setContext(String context) {
        if (!getContext().equalsIgnoreCase(context)) {
            WebDriver d = getDriver();
            if (d instanceof AndroidDriver) {
                executeDriverMethod(AndroidDriver.class, (AndroidDriver driver) -> driver.context(context));
            } else {
                executeDriverMethod(IOSDriver.class, (IOSDriver driver) -> driver.context(context));
            }
        }
    }
    public static Set<String> getAvailableContexts() {
        WebDriver d = getDriver();
        if (d instanceof AndroidDriver) {
            return executeDriverMethod(AndroidDriver.class, AndroidDriver::getContextHandles);
        } else {
            return executeDriverMethod(IOSDriver.class, IOSDriver::getContextHandles);
        }
    }
}
