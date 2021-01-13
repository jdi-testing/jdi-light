package com.epam.jdi.light.mobile.elements.pageobjects.annotations;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import static com.epam.jdi.light.mobile.driver.MobileDriverData.CAPABILITIES_FOR_ANDROID;
import static com.epam.jdi.light.mobile.driver.MobileDriverData.CAPABILITIES_FOR_IOS;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class WebAnnotationsUtil {

    public static By mobileFindByToBy(MobileFindBy locator) {
        if (locator == null) return null;
        if (((AppiumDriver) WebDriverFactory.getDriver()).getCapabilities().getBrowserName().matches("Chrome|Firefox|Opera")) {
            //  web locators
            if (!"".equals(locator.id()))
                return MobileBy.cssSelector("#" + locator.id());
            if (!"".equals(locator.name()))
                return MobileBy.cssSelector("[name='" + locator.name() + "']");
            if (!"".equals(locator.className()))
                return MobileBy.cssSelector("." + locator.className());
            if (!"".equals(locator.tagName()))
                return MobileBy.cssSelector(locator.tagName());
            if (!"".equals(locator.linkText()))
                return MobileBy.xpath("//*[text()='" + locator.linkText() + "']");
            if (!"".equals(locator.partialLinkText()))
                return MobileBy.xpath("//*[contains(text(),'" + locator.partialLinkText() + "')]");
            if (!"".equals(locator.accessibilityId()))
                return MobileBy.AccessibilityId(locator.accessibilityId());
            if (!"".equals(locator.css()))
                return MobileBy.cssSelector(locator.css());
            if (!"".equals(locator.xpath()))
                return MobileBy.xpath(locator.xpath());
        } else {
            //  native locators
            if (!"".equals(locator.id()))
                return MobileBy.id(locator.id());
            if (!"".equals(locator.xpath()))
                return MobileBy.xpath(locator.xpath());
            if (!"".equals(locator.accessibilityId()))
                return MobileBy.AccessibilityId(locator.accessibilityId());
            if (!"".equals(locator.className()))
                return MobileBy.className(locator.className());
            if (!"".equals(locator.name()))
                return MobileBy.name(locator.name());
            if (!"".equals(locator.androidUIAutomator()))
                return MobileBy.AndroidUIAutomator(locator.androidUIAutomator());
            if (!"".equals(locator.androidDataMatcher()))
                return MobileBy.androidDataMatcher(locator.androidDataMatcher());
            //TODO: Yet to be checked   (native app needed)
/*            if (!"".equals(locator.androidViewTag()))
                return MobileBy.AndroidViewTag(locator.androidViewTag());
            if (!"".equals(locator.image()))
                return MobileBy.image(locator.image());*/
        }
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