package com.jdiai;

import com.jdiai.locators.ByFrame;
import org.openqa.selenium.By;

public class LocatorUtils {
    public static By defineLocator(String locator) {
        if (locator.contains("//"))
            return By.xpath(locator);
        if (locator.contains("frame:#"))
            return ByFrame.id(locator.substring(7));
        if (locator.contains("frame:"))
            return ByFrame.css(locator.substring(6));
        return locator.contains("//")
                ? By.xpath(locator)
                : By.cssSelector(locator);
    }
}
