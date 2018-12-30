package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.asserts.ListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.ui.html.complex.Menu;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.EnumUtils;
import com.epam.jdi.tools.LinqUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.EnumUtils.getEnumValue;
import static com.epam.jdi.tools.LinqUtils.toStringArray;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;

public class HtmlList extends JDIBase implements IList<HtmlElement>, Menu {
    protected CacheValue<List<WebElement>> webElements = new CacheValue<>();

    public HtmlList() {}
    public HtmlList(List<WebElement> elements) {
        this.webElements.setForce(elements);
    }

    @JDIAction(level = DEBUG)
    public List<HtmlElement> elements() {
        return LinqUtils.map(webElements.hasValue()
                ? webElements.get()
                : webElements.set(getAll()), HtmlElement::new);
    }

    @JDIAction
    public void select(String... names) {
        for (String name : names)
            get(name).click();
    }
    @JDIAction
    public <TEnum extends Enum> void select(TEnum... names) {
        select(toStringArray(LinqUtils.map(names, EnumUtils::getEnumValue)));
    }

    @JDIAction(level = DEBUG)
    public HtmlElement get(String name) {
        if (getLocator().toString().contains("%s"))
            return new HtmlElement(super.get(name));
        List<WebElement> elements = getAll();
        if (elements.size() == 1) {
            String tagName = elements.get(0).getTagName();
            WebElement element = elements.get(0);
            switch (tagName) {
                case "ul" : elements = element.findElements(By.tagName("li")); break;
                case "select" : elements = element.findElements(By.tagName("option")); break;
            }
        }
        List<HtmlElement> htmlElements = LinqUtils.map(elements, HtmlElement::new);
        HtmlElement el = LinqUtils.first(htmlElements, e -> e.getText().equals(name));
        if (el == null) {
            //el = LinqUtils.first(uiElements, e -> verifyLabel(e, name));
            //if (el == null)
            throw exception("Can't select '%s'. No elements with this name found");
        }
        return el;
    }
    @JDIAction(level = DEBUG)
    public HtmlElement get(Enum name) {
        return get(getEnumValue(name));
    }

    @JDIAction
    public void select(int index) {
        get(index).click();
    }
    public List<String> values() {
        return LinqUtils.map(elements(), HtmlElement::getText);
    }
    @JDIAction(level = DEBUG)
    public void refresh() {
        webElements.clear();
    }
    @JDIAction(level = DEBUG)
    public String selected() {
        HtmlElement first = logger.logOff(() ->
                LinqUtils.first(elements(), HtmlElement::isSelected) );
        return first != null ? first.getText() : "";
    }

    @JDIAction(level = DEBUG)
    public void clear() {
        webElements.clear();
    }

    @JDIAction(level = DEBUG)
    public HtmlElement get(int index) {
        HtmlElement element = new HtmlElement(elements().get(index));
        element.name = format("%s[%s]", getName(), index);
        return element;
    }
    public void setValue(String value) {
        select(value);
    }

    public String getValue() {
        return print(values());
    }
    @JDIAction(level = DEBUG)
    public void showAll() {
        int size;
        do {
            size = size();
            new HtmlElement(get(size-1)).show();
            clear();
        } while (size < size());
    }

    //region matchers
    public ListAssert<HtmlElement> is() {
        return new ListAssert<>(this);
    }
    public ListAssert<HtmlElement> assertThat() {
        return is();
    }
    //endregion
}
