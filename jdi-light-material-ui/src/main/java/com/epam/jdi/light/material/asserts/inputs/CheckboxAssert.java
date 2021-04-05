package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    @JDIAction("Assert that '{name}' is enabled")
    public CheckboxAssert enabled(String section, int index) {
        boolean isEnabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isEnabled(section,index));
        jdiAssert(isEnabled, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public CheckboxAssert disabled(String section, int indexRow) {
        boolean isDisabled = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisabled(section,indexRow));
        jdiAssert(isDisabled, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked(String section, int index) {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked(section,index));
        jdiAssert(isChecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not checked")
    public CheckboxAssert unChecked(String section, int index) {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isNotChecked(section,index));
        jdiAssert(isUnchecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' label is not empty string")
    public CheckboxAssert checkText(String section, int index) {
        jdiAssert(!element().getText(section, index).equals(""), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that there is no error in group form")
    public CheckboxAssert hasNoError() {
        boolean noError = new Timer(base().getTimeout() * 1000L)
                .wait(() -> !element().hasError());
        jdiAssert(noError, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that there is error in group form")
    public CheckboxAssert hasError() {
        boolean hasError = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().hasError());
        jdiAssert(hasError, Matchers.is(true));
        return this;
    }
}
