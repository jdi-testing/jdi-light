package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;

/**
 * Created by Roman_Iovlev on 3/28/2018.
 */
public class UIFactory {
    public static UIElement element(String locator) {
        return locator.matches("[A-Z].*]")
            ? new UIElement().setName(locator)
            : element(defineLocator(locator));
    }
    public static UIElement element(By byLocator) {
        return new UIElement(byLocator);
    }
    public static UIElement $(String locator) {
        return element(locator);
    }
    public static UIElement $(String locator, Object parent) {
        return element(locator).setup(j->j.setParent(parent));
    }
    public static UIElement $(By locator) {
        return element(locator);
    }
    public static UIElement $(WebElement webElement) {
        return new UIElement(webElement);
    }
    public static UIElement $(By locator, Object parent) {
        return element(locator).setup(j->j.setParent(parent));
    }

    public static WebList list(String locator) {
        return locator.matches("[A-Z].*]")
                ? new WebList().setName(locator)
                : list(defineLocator(locator));
    }
    public static WebList list(By byLocator) {
        return new WebList(byLocator);
    }
    public static WebList list(List<WebElement> els, String name) {
        return new WebList(els).setup(e->e.setName(name));
    }
    public static WebList $$(String locator) {
        return list(locator);
    }
    public static WebList $$(String locator, Object parent) {
        return list(locator).setup(j->j.setParent(parent));
    }
    public static WebList $$(By locator) {
        return list(locator);
    }
    public static WebList $$(By locator, Object parent) {
        return list(locator).setup(j->j.setParent(parent));
    }
    public static WebList $$(List<WebElement> els, String name) {
        return list(els, name);
    }

    public static Selector selector(String locator) {
        return locator.matches("[A-Z].*]")
            ? new Selector().setup(Selector.class, b-> b.setName(locator))
            : new Selector().setup(Selector.class, b-> b.setLocator(defineLocator(locator)));
    }
    public static IsDropdown dropdown(String locator) {
        return locator.matches("[A-Z].*]")
                ? new Dropdown().setup(Dropdown.class, b-> b.setName(locator))
                : new Dropdown().setup(Dropdown.class, b-> b.setLocator(defineLocator(locator)));
    }
    public static IsDropdown dropdown(String root, String value, String list, String expand) {
        return new Dropdown().setup(root, value, list, expand);
    }

}
