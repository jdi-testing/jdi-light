package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.asserts.ListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.JDIElement;
import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.LinqUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.getByLocator;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;

public class WebList extends JDIBase implements IList<UIElement>, SetValue, JDIElement {
    protected CacheValue<List<WebElement>> webElements = new CacheValue<>();

    public WebList() {}
    public WebList(List<WebElement> elements) {
        this.webElements.setForce(elements);
    }

    @JDIAction(level = DEBUG)
    public List<UIElement> elements() {
        if (webElements.hasValue())
            return LinqUtils.map(webElements.get(), UIElement::new);
        List<WebElement> result = getAll();
        if (result.size() > 0)
            webElements.set(result);
        return LinqUtils.map(result, UIElement::new);
    }

    @JDIAction
    public void select(String... names) {
        for (String name : names)
            get(name).click();
    }
    public <TEnum extends Enum> void select(TEnum name) {
        select(getEnumValue(name));
    }

    @JDIAction
    public UIElement get(String name) {
        if (getByLocator(getLocator()).contains("%s"))
            return getUI(name);
        clear();
        UIElement el = LinqUtils.first(elements(), e -> e.getText().trim().toLowerCase().equals(name.trim().toLowerCase()));
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
    public List<String> values() {
        return LinqUtils.map(elements(), UIElement::getText);
    }
    @JDIAction(level = DEBUG)
    public void refresh() {
        webElements.clear();
    }
    @JDIAction(level = DEBUG)
    public String isSelected() {
        UIElement first = logger.logOff(() ->
            LinqUtils.first(elements(), UIElement::isSelected) );
        return first != null ? first.getText() : "";
    }

    @JDIAction(level = DEBUG)
    public void clear() {
        webElements.clear();
    }

    @JDIAction(level = DEBUG)
    public UIElement get(int index) {
        UIElement element = new UIElement(elements().get(index));
        element.name = format("%s[%s]", getName(), index);
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
            new UIElement(get(size-1)).show();
            clear();
        } while (size < size());
    }

    //region matchers
    public ListAssert is() {
        return new ListAssert<>(this);
    }
    public ListAssert assertThat() {
        return is();
    }
    //endregion
}