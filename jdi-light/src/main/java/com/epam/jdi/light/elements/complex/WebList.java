package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.ISetValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.getByLocator;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;

public class WebList extends JDIBase implements IList<WebElement>, ISetValue {
    private CacheValue<List<WebElement>> webElements = new CacheValue<>();
    public void select(String name) {
        if (getByLocator(getLocator()).contains("%s")) {
            get(name).click();
            return;
        }
        for(WebElement el : getAll())
            if (el.getText().equals(name)) {
                el.click();
                return;
            }
        throw exception("Can't select '%s'. No elements with this name found");
    }
    public void select(Enum name) {
        select(getEnumValue(name));
    }
    public void get(Enum name) {
        get(getEnumValue(name));
    }
    public void select(int index) {
        get(index).click();
    }
    public List<WebElement> elements() { return getAll(); }
    public List<String> values() {
        return LinqUtils.map(getAll(), WebElement::getText);
    }
    public void refresh() {
        webElements.clear();
    }

    public void clear() {
        webElements.get().clear();
    }

    public WebElement get(int index) {
        if (!webElements.hasValue())
            webElements.set(getAll());
        return webElements.get().get(index);
    }

    public void setValue(String value) {
        select(value);
    }

    public String getValue() {
        return print(values());
    }
    public boolean isDisplayed() {
        return getWebElements().get(0).isDisplayed();
    }
}