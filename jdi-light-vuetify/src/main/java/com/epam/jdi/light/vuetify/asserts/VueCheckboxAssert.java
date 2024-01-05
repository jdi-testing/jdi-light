package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class VueCheckboxAssert extends UIAssert<VueCheckboxAssert, VueCheckbox> implements ThemeAssert<VueCheckboxAssert, VueCheckbox>,
        ColorAssert<VueCheckboxAssert, VueCheckbox>, DenseAssert<VueCheckboxAssert, VueCheckbox>,
        MessagesAssert<VueCheckboxAssert, VueCheckbox>, ReadOnlyAssert<VueCheckboxAssert, VueCheckbox> {

    @JDIAction(value = "Assert that '{name}' is enabled", isAssert = true)
    public VueCheckboxAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "Checkbox is disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public VueCheckboxAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Checkbox is enabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is checked", isAssert = true)
    public VueCheckboxAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true), "Checkbox is unchecked");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not checked", isAssert = true)
    public VueCheckboxAssert unchecked() {
        jdiAssert(element().isChecked(), Matchers.is(false), "Checkbox is checked");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' label", isAssert = true)
    public VueCheckboxAssert label(String text) {
        jdiAssert(element().labelText(), equalToIgnoringCase(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' label contains '{text}'", isAssert = true)
    public VueCheckboxAssert labelContains(String text) {
        jdiAssert(element().labelText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is indeterminate", isAssert = true)
    public VueCheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true), "Checkbox is not indeterminate");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not indeterminate", isAssert = true)
    public VueCheckboxAssert notIndeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(false), "Checkbox is indeterminate");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not label", isAssert = true)
    public VueCheckboxAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "Checkbox has label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public VueCheckboxAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Checkbox has no label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is success", isAssert = true)
    public VueCheckboxAssert success() {
        jdiAssert(element().isSuccess(), Matchers.is(true), "Checkbox is not success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not success", isAssert = true)
    public VueCheckboxAssert notSuccess() {
        jdiAssert(element().isSuccess(), Matchers.is(false), "Checkbox is success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is error", isAssert = true)
    public VueCheckboxAssert error() {
        jdiAssert(element().isError(), Matchers.is(true), "Checkbox is not in errorstate ");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not error", isAssert = true)
    public VueCheckboxAssert notError() {
        jdiAssert(element().isError(), Matchers.is(false), "Checkbox is in error state");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label color '{0}'", isAssert = true)
    public VueCheckboxAssert labelColor(String color) {
        jdiAssert(element().labelColor(), Matchers.equalTo(color));
        return this;
    }
}
