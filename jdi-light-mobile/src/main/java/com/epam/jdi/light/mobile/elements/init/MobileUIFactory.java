package com.epam.jdi.light.mobile.elements.init;

import com.epam.jdi.light.elements.init.UIFactory;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;

public class MobileUIFactory extends UIFactory {

    public static MobileUIElement element(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*]")
                ? new MobileUIElement().setName(locator)
                : element(defineLocator(locator));
    }
    public static MobileUIElement element(@MarkupLocator By byLocator) {
        return new MobileUIElement(byLocator);
    }
    public static MobileUIElement $(@MarkupLocator String locator) {
        return element(locator);
    }
    public static MobileUIElement $(@MarkupLocator String locator, Object parent) {
        return element(locator).setup(j->j.setParent(parent));
    }
    public static MobileUIElement $(@MarkupLocator By locator) {
        return element(locator);
    }
    public static MobileUIElement $(WebElement webElement) {
        return new MobileUIElement(webElement);
    }
    public static MobileUIElement $(@MarkupLocator By locator, Object parent) {
        return element(locator).setup(j->j.setParent(parent));
    }
}
