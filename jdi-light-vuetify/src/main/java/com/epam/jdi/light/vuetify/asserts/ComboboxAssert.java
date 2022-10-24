package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Combobox;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ComboboxAssert extends UIAssert<ComboboxAssert, Combobox> {

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

    @JDIAction("Assert that '{name}' is clearable")
    public ComboboxAssert clearable() {
        jdiAssert(element().isClearable() ? "is clearable" : "is not clearable", Matchers.is("is clearable"));
        return this;
    }

    @JDIAction("Assert that '{name}' is multiple")
    public ComboboxAssert multiple() {
        jdiAssert(element().isMultiple() ? "is multiple" : "is not multiple", Matchers.is("is multiple"));
        return this;
    }

    @JDIAction("Assert that '{name}' is reversed")
    public ComboboxAssert reversed() {
        jdiAssert(element().isReverse() ? "is reversed" : "is not reversed", Matchers.is("is reversed"));
        return this;
    }

    @JDIAction("Assert that '{name}' is single line")
    public ComboboxAssert singleLine() {
        jdiAssert(element().isSingleLine() ? "is single line" : "is not single line", Matchers.is("is single line"));
        return this;
    }

    @JDIAction("Assert that '{name}' is filled")
    public ComboboxAssert filled() {
        jdiAssert(element().isFilled() ? "is filled" : "is not filled", Matchers.is("is filled"));
        return this;
    }

    @JDIAction("Assert that '{name}' has loading")
    public ComboboxAssert loading() {
        jdiAssert(element().hasLoading() ? "has loading" : "has no loading", Matchers.is("has loading"));
        return this;
    }
}
