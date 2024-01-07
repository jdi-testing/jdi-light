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
        if (locator == null) {
            return null;
        }
        if (((AppiumDriver) WebDriverFactory.getDriver()).getCapabilities().getBrowserName().matches("Chrome|Firefox|Opera")) {
            return getBrowserLocator(locator);
        }
        return getAppLocator(locator);
    }

    private static By getBrowserLocator(MobileFindBy locator) {
        String cssLocator = "";
        if (!locator.id().isBlank()) {
            cssLocator = "#" + locator.id();
        } else if (!locator.name().isBlank()) {
            cssLocator = "[name='" + locator.name() + "']";
        } else if (!locator.className().isBlank()) {
            cssLocator = "." + locator.className();
        } else if (!locator.tagName().isBlank()) {
            cssLocator = locator.tagName();
        } else if (!locator.css().isBlank()) {
            cssLocator = locator.css();
        }
        if (!cssLocator.isBlank()) {
            return AppiumBy.cssSelector(cssLocator);
        }

        String xpathLocator = "";

        if (!locator.linkText().isBlank()) {
            xpathLocator = "//*[text()='" + locator.linkText() + "']";
        } else if (!locator.partialLinkText().isBlank()) {
            xpathLocator = "//*[contains(text(),'" + locator.partialLinkText() + "')]";
        } else if (!locator.xpath().isBlank()) {
            xpathLocator = locator.xpath();
        }
        if (!xpathLocator.isEmpty()) {
            return AppiumBy.xpath(xpathLocator);
        }

        By resultLocator = null;
        if (!"".equals(locator.accessibilityId())) {
            resultLocator = AppiumBy.accessibilityId(locator.accessibilityId());
        }

        return resultLocator;
    }

    //  native locators
    //CHECKSTYLE:OFF
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
@todo: Yet to be checked   (native app required)
        if (!"".equals(locator.androidViewTag()))
                return AppiumBy.androidViewTag(locator.androidViewTag());
        if (!"".equals(locator.image()))
                return AppiumBy.image(locator.image());
*/
        return null;
    }
    //CHECKSTYLE:ON

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
