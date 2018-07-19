package com.epam.jdi.light.elements.base;

import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IsAssert {
    UIElement element;
    public IsAssert(UIElement element) { this.element = element; }

    public void text(Matcher<? super String> condition) {
        assertThat(element.getText(), condition);
    }
    public void attr(String attrName, Matcher<? super String> condition) {
        assertThat(element.getAttribute(attrName), condition);
    }
    public void displayed() {
        assertThat(element.isDisplayed() ? "displayed" : "invisible", is("displayed"));
    }
    public void selected() {
        assertThat(element.isSelected() ? "selected" : "not selected", is("selected"));
    }
    public void enabled() {
        assertThat(element.isEnabled() ? "enabled" : "disabled", is("enabled"));
    }
}
