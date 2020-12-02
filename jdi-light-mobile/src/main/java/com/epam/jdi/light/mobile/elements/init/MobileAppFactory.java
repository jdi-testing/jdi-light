package com.epam.jdi.light.mobile.elements.init;

import com.epam.jdi.light.elements.init.UIFactory;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;

public class MobileAppFactory extends UIFactory {

    public static MobileAppUIElement element(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*]")
                ? new MobileAppUIElement().setName(locator)
                : element(defineLocator(locator));
    }
    public static MobileAppUIElement element(@MarkupLocator By byLocator) {
        return new MobileAppUIElement(byLocator);
    }
    public static MobileAppUIElement $(@MarkupLocator String locator) {
        return element(locator);
    }
    public static MobileAppUIElement $(@MarkupLocator String locator, Object parent) {
        return element(locator).setup(j->j.setParent(parent));
    }
    public static MobileAppUIElement $(@MarkupLocator By locator) {
        return element(locator);
    }
    public static MobileAppUIElement $(WebElement webElement) {
        return new MobileAppUIElement(webElement);
    }
    public static MobileAppUIElement $(@MarkupLocator By locator, Object parent) {
        return element(locator).setup(j->j.setParent(parent));
    }
}
