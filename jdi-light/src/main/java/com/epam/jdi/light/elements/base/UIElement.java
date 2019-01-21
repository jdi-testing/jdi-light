package com.epam.jdi.light.elements.base;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UIElement extends BaseUIElement<UIElement> {
    public UIElement() { setInitClass(UIElement.class); }
    public UIElement(WebElement el) { webElement.setForce(el); }
    public UIElement(List<WebElement> els) { webElements.setForce(els); }
    public UIElement(By locator) { setLocator(locator); }

}
