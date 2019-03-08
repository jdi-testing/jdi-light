package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.base.BaseUIElement;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class IsAssert<T extends IsAssert> extends BaseAssert implements CommonAssert<T> {
    public IsAssert(BaseElement element) {
        super(element);
    }
    private BaseUIElement toBaseUIElement(String action) {
        if (!isClass(element.getClass(), BaseUIElement.class))
            throw exception("%s not a BaseUIElement. %s assert allowed only for elements that extends BaseUIElement",
                    element.getName(), action);
        return (BaseUIElement) element;
    }

    @JDIAction("Assert that '{name}' text {0}")
    public T text(Matcher<String> condition) {
        assertThat(toBaseUIElement("text").getText(), condition);
        return (T) this;
    }
    @JDIAction("Assert that '{name}' attribute '{0}' {1}")
    public T attr(String attrName, Matcher<String> condition) {
        assertThat(element.getAttribute(attrName), condition);
        return (T) this;
    }
    @JDIAction("Assert that '{name}' css '{0}' {1}")
    public T css(String css, Matcher<String> condition) {
        assertThat(element.getCssValue(css), condition);
        return (T) this;
    }
    @JDIAction("Assert that '{name}' tag {0}")
    public T tag(Matcher<String> condition) {
        assertThat(element.getTagName(), condition);
        return (T) this;
    }

    @JDIAction("Assert that '{name}' has css class {0}")
    public T hasClass(String className) {
        return cssClass(containsString(className));
    }
    @JDIAction("Assert that '{name}' css class {0}")
    public T cssClass(Matcher<String> condition) {
        assertThat(element.getAttribute("class"), condition);
        return (T) this;
    }
    @JDIAction("Assert that '{name}' is displayed")
    public T displayed() {
        assertThat(element.displayed() ? "displayed" : "hidden", is("displayed"));
        return (T) this;
    }
    @JDIAction("Assert that '{name}' is disappear")
    public T disappear() {
        assertThat(element.displayed() ? "displayed" : "disappear", is("disappear"));
        return (T) this;
    }
    @JDIAction("Assert that '{name}' is selected")
    public T selected() {
        assertThat(toBaseUIElement("selected").isSelected() ? "selected" : "not selected", is("selected"));
        return (T) this;
    }
    @JDIAction("Assert that '{name}' is deselected")
    public T deselected() {
        assertThat(toBaseUIElement("deselected").isSelected() ? "selected" : "not selected", is("not selected"));
        return (T) this;
    }
    @JDIAction("Assert that '{name}' is enabled")
    public T enabled() {
        assertThat(element.isEnabled() ? "enabled" : "disabled", is("enabled"));
        return (T) this;
    }
    @JDIAction("Assert that '{name}' is disabled")
    public T disabled() {
        assertThat(element.isEnabled() ? "enabled" : "disabled", is("disabled"));
        return (T) this;
    }
}
