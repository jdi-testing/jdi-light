package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {
    @JDIAction("Assert that '{name}' is selected")
    public CheckboxAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public CheckboxAssert deselected() {
        jdiAssert(element().isSelected(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is indeterminate")
    public CheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public CheckboxAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public CheckboxAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }
}
