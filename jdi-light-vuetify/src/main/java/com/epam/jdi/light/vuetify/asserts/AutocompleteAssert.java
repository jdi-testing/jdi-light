package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Autocomplete;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AutocompleteAssert extends UIAssert<AutocompleteAssert, Autocomplete> {

    @JDIAction("Assert that '{name}' is expanded")
    public AutocompleteAssert expanded() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().listItems().isDisplayed());
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is closed")
    public AutocompleteAssert closed() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().combobox().isDisplayed());
        jdiAssert(element().isExpanded(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public AutocompleteAssert selected(String value) {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().value().isDisplayed());
        jdiAssert(element().isSelected(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public AutocompleteAssert selected(List<String> values) {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().value().isDisplayed());
        jdiAssert(element().isSelected(values), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public AutocompleteAssert notSelected(String value) {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(element().isSelected(value), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public AutocompleteAssert notSelected(List<String> values) {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(element().isSelected(values), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public AutocompleteAssert disabled() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public AutocompleteAssert active() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(element().isDisabled(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public AutocompleteAssert empty() {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(element().value().text(), Matchers.is(""));
        return this;
    }
}
