package com.epam.jdi.light.elements.asserts;

import com.epam.jdi.light.elements.base.UIElement;
import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IsAssert {
    UIElement element;
    public IsAssert(UIElement element) { this.element = element; }

    public void text(Matcher<String> condition) {
        assertThat(element.getText(), condition);
    }
    public void attr(String attrName, Matcher<? super String> condition) {
        assertThat(element.getAttribute(attrName), condition);
    }
    public void css(String css, Matcher<String> condition) {
        assertThat(element.getCssValue(css), condition);
    }
    public void tag(Matcher<String> condition) {
        assertThat(element.getTagName(), condition);
    }
    public void cssClass(Matcher<String> condition) {
        assertThat(element.getAttribute("class"), condition);
    }
    public void displayed() {
        assertThat(element.isDisplayed() ? "displayed" : "hidden", is("displayed"));
    }

    public void hidden() {
        assertThat(element.isDisplayed() ? "displayed" : "hidden", is("hidden"));
    }
    public void selected() {
        assertThat(element.isSelected() ? "selected" : "not selected", is("selected"));
    }
    public void notSelected() {
        assertThat(element.isSelected() ? "selected" : "not selected", is("not selected"));
    }
    public void enabled() {
        assertThat(element.isEnabled() ? "enabled" : "disabled", is("enabled"));
    }
    public void disabled() {
        assertThat(element.isEnabled() ? "enabled" : "disabled", is("disabled"));
    }
}
