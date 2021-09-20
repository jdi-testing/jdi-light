package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is enabled")
    public CheckboxAssert enabled() {
        boolean isEnabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isEnabled());
        jdiAssert(isEnabled, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public CheckboxAssert disabled() {
        boolean isDisabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisabled());
        jdiAssert(isDisabled, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked());
        jdiAssert(isChecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not checked")
    public CheckboxAssert unchecked() {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isNotChecked());
        jdiAssert(isUnchecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{label}' label")
    public CheckboxAssert label(String label) {
        new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(element().labelText(), equalToIgnoringCase(label));
        return this;
    }

    @JDIAction("Assert that '{name}' label contains '{text}'")
    public CheckboxAssert labelContains(String text) {
        jdiAssert(element().labelText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public CheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public CheckboxAssert notIndeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{className}' class")
    public CheckboxAssert className(String className) {
        boolean hasClass = new Timer(1000L)
                .wait(() -> element().hasClass(className));
        jdiAssert(hasClass, Matchers.is(true));
        return this;
    }
}
