package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Combobox;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ClearableAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReverseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MultipleAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FilledAssert;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ComboboxAssert extends UIAssert<ComboboxAssert, Combobox> implements LoadingAssert<ComboboxAssert, Combobox>,
        ClearableAssert<ComboboxAssert, Combobox>, SingleLineAssert<ComboboxAssert, Combobox>,
        ReverseAssert<ComboboxAssert, Combobox>, MultipleAssert<ComboboxAssert, Combobox>,
        FilledAssert<ComboboxAssert, Combobox> {

    @JDIAction("Assert that '{name}' is expanded")
    public ComboboxAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is closed")
    public ComboboxAssert closed() {
        jdiAssert(element().isExpanded(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public ComboboxAssert selected(String value) {
        jdiAssert(element().isSelected(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public ComboboxAssert selected(List<String> values) {
        jdiAssert(element().isSelected(values), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public ComboboxAssert notSelected(String value) {
        jdiAssert(element().isSelected(value), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public ComboboxAssert notSelected(List<String> values) {
        jdiAssert(element().isSelected(values), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public ComboboxAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public ComboboxAssert active() {
        jdiAssert(element().isDisabled(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' label is '{0}'")
    public ComboboxAssert label(String value) {
        jdiAssert(element().label().getText(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that '{name}' message is '{0}'")
    public ComboboxAssert message(String value) {
        jdiAssert(element().message().getText(), Matchers.is(value));
        return this;
    }
}
