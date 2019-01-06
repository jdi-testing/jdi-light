package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.base.UIElement;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IsAssert<T extends IsAssert> {
    protected UIElement element;
    protected String name;
    public IsAssert(BaseElement element) { 
        this.element = (UIElement) element; 
        this.name = ((UIElement) element).toError(); 
    }

    public T text(Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getText(), condition), name);
        return (T) this;
    }
    public T attr(String attrName, Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getAttribute(attrName), condition), name);
        return (T) this;
    }
    public T css(String css, Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getCssValue(css), condition), name);
        return (T) this;
    }
    public T tag(Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getTagName(), condition), name);
        return (T) this;
    }
    public T cssClass(Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getAttribute("class"), condition), name);
        return (T) this;
    }
    public T displayed() {
        waitAssert(() -> assertThat(element.isDisplayed() ? "displayed" : "hidden", is("displayed")), name);
        return (T) this;
    }
    public T disappear() {
        waitAssert(() -> assertThat(element.isDisplayed() ? "displayed" : "disappear", is("disappear")), name);
        return (T) this;
    }
    public T selected() {
        waitAssert(() -> assertThat(element.isSelected() ? "selected" : "not selected", is("selected")), name);
        return (T) this;
    }
    public T deselected() {
        waitAssert(() -> assertThat(element.isSelected() ? "selected" : "not selected", is("not selected")), name);
        return (T) this;
    }
    public T enabled() {
        waitAssert(() -> assertThat(element.isEnabled() ? "enabled" : "disabled", is("enabled")), name);
        return (T) this;
    }
    public T disabled() {
        waitAssert(() -> assertThat(element.isEnabled() ? "enabled" : "disabled", is("disabled")), name);
        return (T) this;
    }
}
