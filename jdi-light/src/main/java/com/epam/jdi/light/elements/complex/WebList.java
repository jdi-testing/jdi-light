package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.interfaces.ISetValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.getByLocator;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;

public class WebList extends JDIBase implements IList<WebElement>, ISetValue {
    private CacheValue<List<WebElement>> webElements = new CacheValue<>();

    @JDIAction
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
    @JDIAction
    public void get(Enum name) {
        get(getEnumValue(name));
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
    public boolean isDisplayed() {
        return getWebElements().get(0).isDisplayed();
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
    public void is(Matcher<Collection<? extends String>> condition) {
        assertThat(values(), condition);
    }
    public void displayed() {
        assertThat(isDisplayed() ? "displayed" : "invisible", org.hamcrest.Matchers.is("displayed"));
    }
    //endregion
}