package com.epam.jdi.light.ui.html;

import com.epam.jdi.light.elements.complex.Dropdown;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.base.HtmlList;
import org.openqa.selenium.By;

/**
 * Created by Roman_Iovlev on 3/28/2018.
 */
public class HtmlFactory {
    public static HtmlElement element(String locator) {
        return element(getLocator(locator));
    }
    public static HtmlElement element(By byLocator) {
        HtmlElement el =  new HtmlElement();
        el.setLocator(byLocator);
        return el;
    }
    private static By getLocator(String locator) {
        return locator.substring(0,2).contains("/")
                ? By.xpath(locator)
                : By.cssSelector(locator);
    }
    public static HtmlElement $(String locator) {
        return element(locator);
    }
    public static HtmlElement $(By locator) {
        return element(locator);
    }
    public static HtmlElement $(By locator, Object parent) {
        return element(locator).setParent(parent);
    }

    public static HtmlList list(String locator) {
        return list(getLocator(locator));
    }
    public static HtmlList list(By byLocator) {
        HtmlList list =  new HtmlList();
        list.setLocator(byLocator);
        return list;
    }
    public static HtmlList $$(String locator) {
        return list(locator);
    }
    public static HtmlList $$(By locator) {
        return list(locator);
    }
    public static HtmlList $$(By locator, Object parent) {
        return list(locator).setParent(parent);
    }

    public static Dropdown dropdown(String locator) {
        Dropdown el =  new Dropdown();
        By byLocator = getLocator(locator);
        el.setLocator(byLocator);
        return el;
    }
    public static Dropdown $d(String locator) {
        return dropdown(locator);
    }
}
