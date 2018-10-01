package com.epam.jdi.light.elements.base;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.asserts.IsAssert;
import org.openqa.selenium.WebElement;

public class UIElement extends BaseUIElement {
    public UIElement() { }
    public UIElement(WebElement el) { webElement.setForce(el); }

    public IsAssert is() {
        return new IsAssert(this);
    }
    public IsAssert assertThat() {
        return is();
    }
}
