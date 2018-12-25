package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.base.BaseElement;
import com.epam.jdi.light.elements.base.UIElement;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IsAssert<T extends IsAssert> {
    protected UIElement element;
    public IsAssert(BaseElement element) { this.element = (UIElement) element; }

    public T text(Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getText(), condition));
        return (T) this;
    }
    public T attr(String attrName, Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getAttribute(attrName), condition));
        return (T) this;
    }
    public T css(String css, Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getCssValue(css), condition));
        return (T) this;
    }
    public T tag(Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getTagName(), condition));
        return (T) this;
    }
    public T cssClass(Matcher<String> condition) {
        waitAssert(() -> assertThat(element.getAttribute("class"), condition));
        return (T) this;
    }
    public T displayed() {
        waitAssert(() -> assertThat(element.isDisplayed() ? "displayed" : "hidden", is("displayed")));
        return (T) this;
    }
    public T hidden() {
        waitAssert(() -> assertThat(element.isDisplayed() ? "displayed" : "hidden", is("hidden")));
        return (T) this;
    }
    public T selected() {
        waitAssert(() -> assertThat(element.isSelected() ? "selected" : "not selected", is("selected")));
        return (T) this;
    }
    public T deselected() {
        waitAssert(() -> assertThat(element.isSelected() ? "selected" : "not selected", is("not selected")));
        return (T) this;
    }
    public T enabled() {
        waitAssert(() -> assertThat(element.isEnabled() ? "enabled" : "disabled", is("enabled")));
        return (T) this;
    }
    public T disabled() {
        waitAssert(() -> assertThat(element.isEnabled() ? "enabled" : "disabled", is("disabled")));
        return (T) this;
    }
}
