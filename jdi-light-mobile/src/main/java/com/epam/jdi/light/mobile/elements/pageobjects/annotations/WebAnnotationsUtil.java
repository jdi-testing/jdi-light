package com.epam.jdi.light.mobile.elements.pageobjects.annotations;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WebAnnotationsUtil {

    public static By mobileFindByToBy(MobileFindBy locator) {
        if (locator == null) return null;
        if (((AndroidDriver) WebDriverFactory.getDriver()).getCapabilities().getBrowserName().matches("Chrome|Firefox|Opera")) {
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
            //TODO: Yet to be checked   (native app needed)
/*            if (!"".equals(locator.androidDataMatcher()))
                return MobileBy.androidDataMatcher(locator.androidDataMatcher());
            if (!"".equals(locator.androidViewTag()))
                return MobileBy.AndroidViewTag(locator.androidViewTag());
            if (!"".equals(locator.image()))
                return MobileBy.image(locator.image());*/
        }
        return null;
    }
}