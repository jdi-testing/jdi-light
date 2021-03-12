package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.RadioButton;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioButtonAssert extends UIAssert<RadioButtonAssert, RadioButton> {
    @JDIAction("Assert that '{name}' is checked")
    public RadioButtonAssert checked() {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked());
        jdiAssert(isChecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public RadioButtonAssert unchecked() {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isUnchecked());
        jdiAssert(isUnchecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public RadioButtonAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public RadioButtonAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public RadioButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }
}
