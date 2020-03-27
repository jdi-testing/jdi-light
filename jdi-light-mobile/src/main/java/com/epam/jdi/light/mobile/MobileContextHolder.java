package com.epam.jdi.light.mobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

import java.util.Set;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.exception;
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
                throw exception("Cannot switch the single context " + initialContext);
            }
        } else {
            throw exception("Cannot use this method. The driver needs to extend the AppiumDriver class");
        }
    }
    public static String getContext() {
        return executeDriverMethod(AppiumDriver.class, (Function<AppiumDriver, String>) AppiumDriver::getContext);
    }
    public static void setContext(String context) {
        if (!getContext().equalsIgnoreCase(context)) {
            executeDriverMethod(AppiumDriver.class, (AppiumDriver driver) -> driver.context(context));
        }
    }
    public static Set<String> getAvailableContexts() {
        return executeDriverMethod(AppiumDriver.class, (Function<AppiumDriver, Set<String>>) AppiumDriver::getContextHandles);
    }
}
