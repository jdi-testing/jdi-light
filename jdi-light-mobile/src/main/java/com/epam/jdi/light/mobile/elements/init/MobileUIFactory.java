package com.epam.jdi.light.mobile.elements.init;


import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import com.epam.jdi.light.mobile.elements.complex.MobileWebList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;

public class MobileUIFactory {

    public static MobileUIElement element(@MarkupLocator String locator) {
        return locator.matches("[A-Z].*]")
                ? new MobileUIElement().setName(locator)
                : element(defineLocator(locator));
    }

    public static MobileUIElement element(@MarkupLocator By byLocator) {
        return new MobileUIElement(byLocator);
    }

    //CHECKSTYLE:OFF
    public static MobileUIElement $(@MarkupLocator String locator) {
        //CHECKSTYLE:ON
        return element(locator);
    }

    //CHECKSTYLE:OFF
    public static MobileUIElement $(@MarkupLocator String locator, Object parent) {
        //CHECKSTYLE:ON
        return element(locator).setup(j -> j.setParent(parent));
    }

    //CHECKSTYLE:OFF
    public static MobileUIElement $(@MarkupLocator By locator) {
        //CHECKSTYLE:ON
        return element(locator);
    }

    //CHECKSTYLE:OFF
    public static MobileUIElement $(WebElement webElement) {
        //CHECKSTYLE:ON
        return new MobileUIElement(webElement);
    }

    //CHECKSTYLE:OFF
    public static MobileUIElement $(@MarkupLocator By locator, Object parent) {
        //CHECKSTYLE:ON
        return element(locator).setup(j -> j.setParent(parent));
    }

    //CHECKSTYLE:OFF
    public static MobileWebList $$(@MarkupLocator String locator) {
        //CHECKSTYLE:ON
        return MobileJDITalk.list(locator);
    }

    //CHECKSTYLE:OFF
    public static MobileWebList $$(@MarkupLocator String locator, Object parent) {
        //CHECKSTYLE:ON
        return MobileJDITalk.list(locator).setup(j -> j.setParent(parent));
    }

    //CHECKSTYLE:OFF
    public static MobileWebList $$(@MarkupLocator By locator) {
        //CHECKSTYLE:ON
        return MobileJDITalk.list(locator);
    }

    //CHECKSTYLE:OFF
    public static MobileWebList $$(@MarkupLocator By locator, Object parent) {
        //CHECKSTYLE:ON
        return MobileJDITalk.list(locator).setup(j -> j.setParent(parent));
    }

    //CHECKSTYLE:OFF
    public static MobileWebList $$(List<WebElement> els, String name) {
        //CHECKSTYLE:ON
        return MobileJDITalk.list(els, name);
    }
}
