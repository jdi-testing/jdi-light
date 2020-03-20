package com.epam.jdi.light.mobile.elements.pageobjects.annotations;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class WebAnnotationsUtilMobile {

    public static By mobileFindByToBy(MobileFindBy locator) {
        if (locator == null) return null;
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
        if(!"".equals(locator.css()))
            return MobileBy.cssSelector(locator.css());
        if(!"".equals(locator.xpath()))
            return MobileBy.xpath(locator.xpath());
        return null;
    }
}