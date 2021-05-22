package com.jdiai;

import com.jdiai.locators.ByFrame;
import org.openqa.selenium.By;

import static org.apache.logging.log4j.util.Strings.isBlank;

public class LocatorUtils {
    public static By defineLocator(String locator) {
        if (isBlank(locator)) {
            return By.cssSelector("");
        }
        if (locator.length() == 1) {
            return By.cssSelector(locator);
        }
        if (locator.contains("//")) {
            return By.xpath(locator);
        }
        if (locator.contains("frame:#")) {
            return ByFrame.id(locator.substring(7));
        }
        if (locator.contains("frame:")) {
            return ByFrame.css(locator.substring(6));
        }
        return locator.contains("//")
            ? By.xpath(locator)
            : By.cssSelector(locator);
    }
}
