package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.CommonAssertMaterialUi;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends CommonAssertMaterialUi<SwitchAssert, Switch> {

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public SwitchAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public SwitchAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public SwitchAssert checked() {
        boolean isChecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isChecked());
        jdiAssert(isChecked, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public SwitchAssert unchecked() {
        boolean isUnchecked = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isUnchecked());
        jdiAssert(isUnchecked, Matchers.is(true));
        return this;
    }
}
