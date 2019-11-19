package com.epam.jdi.light.elements.complex;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import com.epam.jdi.light.elements.SeleniumWebList;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.common.TextTypes.INDEX;

public class WebList extends SeleniumWebList implements ISelector, HasUIList, HasAssert<UISelectAssert<UISelectAssert, WebList>> {
    public WebList() { super(); jdiIndex = 1; }
    public WebList(By locator) { super((locator)); jdiIndex = 1; }
    public WebList(List<WebElement> elements) {
        super(elements);
    }
    public WebList(JDIBase base) {
        super(base);
        jdiIndex = 1;
    }
    public WebList(JDIBase base, String locator, String name, Object parent) {
        super(base, locator, name, parent);
        jdiIndex = 1;
    }
    @Override
    public WebList list() { return this; }
    @Override
    public WebList setName(String name) {
        super.setName(name);
        return this;
    }
    @Override
    public WebList setup(JAction1<JDIBase> setup) {
        return setup(WebList.class, setup);
    }
    @Override
    public WebList noValidation() {
        super.noValidation();
        return this;
    }
    @Override
    public WebList setUIElementName(JFunc1<UIElement, String> func) {
        UIELEMENT_NAME = func;
        return this;
    }
    @Override
    public WebList setUIElementName(TextTypes type) {
        if (type.equals(INDEX)) {
            nameIndex = true;
            return this;
        }
        setTextType(type);
        return setUIElementName(type.func);
    }
    @Override
    public UISelectAssert<UISelectAssert, WebList> is() {
        refresh();
        return new UISelectAssert<>().set(this);
    }
    @JDIAction("Assert that {name} list meet condition")
    public UISelectAssert<UISelectAssert, WebList> is(Matcher<? super List<UIElement>> condition) {
        MatcherAssert.assertThat(this, condition);
        return is();
    }
    public UISelectAssert<UISelectAssert, WebList> assertThat(Matcher<? super List<UIElement>> condition) {
        return is(condition);
    }
}