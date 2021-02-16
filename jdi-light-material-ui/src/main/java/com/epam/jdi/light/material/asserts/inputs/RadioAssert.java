package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Radio;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadioAssert extends UIAssert<RadioAssert, Radio> {
    @JDIAction("Assert that '{name}' is checked")
    public RadioAssert checked() {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked());
        jdiAssert(isChecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public RadioAssert unchecked() {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isUnchecked());
        jdiAssert(isUnchecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public RadioAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }


    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public RadioAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public RadioAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }
}
