package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.By;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;

/**
 * Created by Roman_Iovlev on 3/28/2018.
 */
public class UIFactory {
    public static UIElement element(String locator) {
        return element(defineLocator(locator));
    }
    public static UIElement element(By byLocator) {
        UIElement<UIElement> el =  new UIElement<>();
        el.setLocator(byLocator);
        return el;
    }
    public static UIElement $(String locator) {
        return element(locator);
    }
    public static UIElement $(String locator, Object parent) {
        return element(locator).setParent(parent);
    }
    public static UIElement $(By locator) {
        return element(locator);
    }
    public static UIElement $(By locator, Object parent) {
        return element(locator).setParent(parent);
    }

    public static WebList<UIElement> list(String locator) {
        return list(defineLocator(locator));
    }
    public static WebList<UIElement> list(By byLocator) {
        WebList list =  new WebList();
        list.setLocator(byLocator);
        return list;
    }
    public static WebList<UIElement> $$(String locator) {
        return list(locator);
    }
    public static WebList<UIElement> $$(String locator, Object parent) {
        return list(locator).setParent(parent);
    }
    public static WebList<UIElement> $$(By locator) {
        return list(locator);
    }
    public static WebList<UIElement> $$(By locator, Object parent) {
        return list(locator).setParent(parent);
    }

    public static Droplist dropdown(String locator) {
        Droplist el =  new Droplist();
        By byLocator = defineLocator(locator);
        el.setLocator(byLocator);
        return el;
    }
    public static Droplist $d(String locator) {
        return dropdown(locator);
    }
}
