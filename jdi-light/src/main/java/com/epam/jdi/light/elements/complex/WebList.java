package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.ListAssert;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.interfaces.ISetValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.getByLocator;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;

public class WebList extends JDIBase implements IList<WebElement>, ISetValue {
    private CacheValue<List<WebElement>> webElements = new CacheValue<>();

    @JDIAction
    public void select(String name) {
        get(name).click();
    }
    public void select(Enum name) {
        select(getEnumValue(name));
    }

    @JDIAction
    public UIElement get(String name) {
        if (getByLocator(getLocator()).contains("%s"))
            return getUI(name);
        UIElement el = LinqUtils.first(allUI(), e -> e.getText().equals(name));
        if (el == null)
            throw exception("Can't select '%s'. No elements with this name found", name);
        return el;
    }
    @JDIAction
    public UIElement get(Enum name) {
        return get(getEnumValue(name));
    }
    @JDIAction
    public void select(int index) {
        get(index).click();
    }
    public List<WebElement> elements() { return getAll(); }
    public List<String> values() {
        return LinqUtils.map(getAll(), WebElement::getText);
    }
    @JDIAction(level = DEBUG)
    public void refresh() {
        webElements.clear();
    }

    @JDIAction(level = DEBUG)
    public void clear() {
        webElements.clear();
    }

    @JDIAction(level = DEBUG)
    public UIElement get(int index) {
        if (!webElements.hasValue())
            webElements.set(getAll());
        UIElement element = new UIElement();
        element.name = format("%s[%s]", getName(), index);
        element.setWebElement(webElements.get().get(index));
        return element;
    }

    public void setValue(String value) {
        select(value);
    }

    public String getValue() {
        return print(values());
    }
    @JDIAction
    public void showAll() {
        int size;
        do {
            size = size();
            ((UIElement) new UIElement().setWebElement(get(size-1))).show();
            clear();
        } while (size < size());
    }

    //region matchers
    public ListAssert is() {
        return new ListAssert(this);
    }
    public ListAssert assertThat() {
        return is();
    }
    //endregion
}