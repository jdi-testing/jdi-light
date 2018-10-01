package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.ui.html.base.HtmlBaseSelector;
import com.epam.jdi.light.ui.html.complex.MultiSelect;
import org.hamcrest.Matcher;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BaseSelectAssert {

    HtmlBaseSelector mSelect;
    public BaseSelectAssert(HtmlBaseSelector mSelect) {
        this.mSelect = mSelect;
    }

    public void values(Matcher<Iterable<String>> condition) {
        assertThat(mSelect.values(), condition);
    }
    public void enabled(Matcher<Iterable<String>> condition) {
        assertThat(mSelect.enabled(), condition);
    }
    public void disabled(Matcher<Iterable<String>> condition) {
        assertThat(mSelect.disabled(), condition);
    }

    public void displayed() {
        assertThat(mSelect.isDisplayed() ? "displayed" : "hidden", is("displayed"));
    }
    public void hidden() {
        assertThat(mSelect.isDisplayed() ? "displayed" : "hidden", is("hidden"));
    }
    public void enabled() {
        assertThat(mSelect.isEnabled() ? "enabled" : "disabled", is("enabled"));
    }
    public void disabled() {
        assertThat(mSelect.isEnabled() ? "enabled" : "disabled", is("disabled"));
    }
}
