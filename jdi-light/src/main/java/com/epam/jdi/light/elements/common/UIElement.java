package com.epam.jdi.light.elements.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.BaseWebElement;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UIElement extends BaseWebElement<UIElement> {
    public UIElement() { setInitClass(UIElement.class); }
    public UIElement(WebElement el) { this(); webElement.setForce(el); }
    public UIElement(List<WebElement> els) { this(); webElements.setForce(els); }
    public UIElement(By locator) { this(); setLocator(locator); }

    public boolean wait(JFunc1<UIElement, Boolean> condition) {
        return waitCondition(condition, this);
    }
}
