package com.epam.jdi.light.mobile.elements.init;


import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.mobile.elements.base.mobileUIElement;
import com.epam.jdi.light.mobile.elements.complex.MobileWebList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;

public class MobileUIFactory {

    public static mobileUIElement element(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*]")
                ? new mobileUIElement().setName(locator)
                : element(defineLocator(locator));
    }

    public static mobileUIElement element(@MarkupLocator By byLocator) {
        return new mobileUIElement(byLocator);
    }

    public static mobileUIElement $(@MarkupLocator String locator) {
        return element(locator);
    }

    public static mobileUIElement $(@MarkupLocator String locator, Object parent) {
        return element(locator).setup(j -> j.setParent(parent));
    }

    public static mobileUIElement $(@MarkupLocator By locator) {
        return element(locator);
    }

    public static mobileUIElement $(WebElement webElement) {
        return new mobileUIElement(webElement);
    }

    public static mobileUIElement $(@MarkupLocator By locator, Object parent) {
        return element(locator).setup(j -> j.setParent(parent));
    }

    public static MobileWebList $$(@MarkupLocator String locator) {
        return MobileJDITalk.list(locator);
    }

    public static MobileWebList $$(@MarkupLocator String locator, Object parent) {
        return MobileJDITalk.list(locator).setup(j -> j.setParent(parent));
    }

    public static MobileWebList $$(@MarkupLocator By locator) {
        return MobileJDITalk.list(locator);
    }

    public static MobileWebList $$(@MarkupLocator By locator, Object parent) {
        return MobileJDITalk.list(locator).setup(j -> j.setParent(parent));
    }

    public static MobileWebList $$(List<WebElement> els, String name) {
        return MobileJDITalk.list(els, name);
    }
}
