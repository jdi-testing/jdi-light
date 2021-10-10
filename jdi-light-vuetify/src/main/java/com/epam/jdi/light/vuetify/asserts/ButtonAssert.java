package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Button;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ButtonAssert extends UIAssert<ButtonAssert, Button> {

    @JDIAction("Assert that '{name}' is loading")
    public ButtonAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public ButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }
}
