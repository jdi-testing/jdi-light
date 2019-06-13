package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebList extends JList<UIElement> {
    public WebList() {}
    public WebList(By locator) { super(locator);}
    public WebList(List<WebElement> elements) {
        this.webElements.setForce(elements);
    }

}