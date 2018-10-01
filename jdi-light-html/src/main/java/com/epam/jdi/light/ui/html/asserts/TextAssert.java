package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.ui.html.base.HtmlElement;
import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TextAssert {
    HtmlElement element;
    public TextAssert(HtmlElement element) { this.element = element; }

    public void text(Matcher<String> condition) {
        assertThat(element.getText(), condition);
    }
    public void displayed() {
        assertThat(element.isDisplayed() ? "displayed" : "hidden", is("displayed"));
    }
    public void hidden() {
        assertThat(element.isDisplayed() ? "displayed" : "hidden", is("hidden"));
    }
    public void enabled() {
        assertThat(element.isEnabled() ? "enabled" : "disabled", is("enabled"));
    }
    public void disabled() {
        assertThat(element.isEnabled() ? "enabled" : "disabled", is("disabled"));
    }
}
