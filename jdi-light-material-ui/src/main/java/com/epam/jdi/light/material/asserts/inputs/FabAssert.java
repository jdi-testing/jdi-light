package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Fab;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class FabAssert extends UIAssert<FabAssert, Fab> {

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public FabAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public FabAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

}
