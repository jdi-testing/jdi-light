package com.epam.jdi.light.mobile.elements.pageobjects.annotations;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.epam.jdi.light.mobile.driver.MobileDriverData.CAPABILITIES_FOR_ANDROID;
import static com.epam.jdi.light.mobile.driver.MobileDriverData.CAPABILITIES_FOR_IOS;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class WebAnnotationsUtil {

    public static By mobileFindByToBy(MobileFindBy locator) {
        if (locator == null)
            return null;
        if (((AppiumDriver) WebDriverFactory.getDriver()).getCapabilities().getBrowserName().matches("Chrome|Firefox|Opera")) {
            return getBrowserLocator(locator);
        } else {
            return getAppLocator(locator);
        }
    }

    private static By getBrowserLocator(MobileFindBy locator) {
        if (!"".equals(locator.id()))
            return AppiumBy.cssSelector("#" + locator.id());
        if (!"".equals(locator.name()))
            return AppiumBy.cssSelector("[name='" + locator.name() + "']");
        if (!"".equals(locator.className()))
            return AppiumBy.cssSelector("." + locator.className());
        if (!"".equals(locator.tagName()))
            return AppiumBy.cssSelector(locator.tagName());
        if (!"".equals(locator.linkText()))
            return AppiumBy.xpath("//*[text()='" + locator.linkText() + "']");
        if (!"".equals(locator.partialLinkText()))
            return AppiumBy.xpath("//*[contains(text(),'" + locator.partialLinkText() + "')]");
        if (!"".equals(locator.accessibilityId()))
            return AppiumBy.accessibilityId(locator.accessibilityId());
        if (!"".equals(locator.css()))
            return AppiumBy.cssSelector(locator.css());
        if (!"".equals(locator.xpath()))
            return AppiumBy.xpath(locator.xpath());
        return null;
    }

    //  native locators
    private static By getAppLocator(MobileFindBy locator) {
        if (!"".equals(locator.id()))
            return AppiumBy.id(locator.id());
        if (!"".equals(locator.xpath()))
            return AppiumBy.xpath(locator.xpath());
        if (!"".equals(locator.accessibilityId()))
            return AppiumBy.accessibilityId(locator.accessibilityId());
        if (!"".equals(locator.className()))
            return AppiumBy.className(locator.className());
        if (!"".equals(locator.name()))
            return AppiumBy.name(locator.name());
        if (!"".equals(locator.androidUIAutomator()))
            return AppiumBy.androidUIAutomator(locator.androidUIAutomator());
        if (!"".equals(locator.androidDataMatcher()))
            return AppiumBy.androidDataMatcher(locator.androidDataMatcher());
        /*
TODO: Yet to be checked   (native app required)
        if (!"".equals(locator.androidViewTag()))
                return AppiumBy.androidViewTag(locator.androidViewTag());
        if (!"".equals(locator.image()))
                return AppiumBy.image(locator.image());
*/
        return null;
    }

    public static void setApp(Class<?> app) {
        if (app.isAnnotationPresent(JApp.class)) {
            String appCapability = app.getAnnotation(JApp.class).app();
            String appPackage = app.getAnnotation(JApp.class).appPackage();
            String appActivity = app.getAnnotation(JApp.class).appActivity();
            if (!isBlank(appCapability)) {
                CAPABILITIES_FOR_IOS.put("app", appCapability);
                CAPABILITIES_FOR_ANDROID.put("app", appCapability);
            }
            if (!isBlank(appPackage) || !isBlank(appActivity)) {
                CAPABILITIES_FOR_ANDROID.put("appPackage", appPackage);
                CAPABILITIES_FOR_ANDROID.put("appActivity", appActivity);
            }
        }
    }
}