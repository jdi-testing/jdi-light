package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Dropdown;
import com.epam.jdi.light.elements.complex.UIList;
import org.openqa.selenium.By;

/**
 * Created by Roman_Iovlev on 3/28/2018.
 */
public class UIFactory {
    public static UIElement element(String locator) {
        UIElement el =  new UIElement();
        By byLocator = locator.charAt(1) == '/'
                ? By.cssSelector(locator)
                : By.xpath(locator);
        el.setLocator(byLocator);
        return el;
    }
    public static UIElement $(String locator) {
        return element(locator);
    }
    public static UIElement $x(String locator) {
        UIElement el =  new UIElement();
        el.setLocator(By.xpath(locator));
        return el;
    }
    public static UIList list(String locator) {
        UIList list =  new UIList();
        By byLocator = locator.charAt(1) == '/'
                ? By.cssSelector(locator)
                : By.xpath(locator);
        list.setLocator(byLocator);
        return list;
    }
    public static UIList $$(String locator) {
        return list(locator);
    }
    public static UIList $$x(String locator) {
        UIList list =  new UIList();
        list.setLocator(By.xpath(locator));
        return list;
    }
    public static Dropdown dropdown(String locator) {
        Dropdown el =  new Dropdown();
        By byLocator = locator.charAt(1) == '/'
                ? By.cssSelector(locator)
                : By.xpath(locator);
        el.setLocator(byLocator);
        return el;
    }
    public static Dropdown $d(String locator) {
        return dropdown(locator);
    }
}
