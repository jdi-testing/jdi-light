package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Button;
import org.hamcrest.Matchers;

public class ButtonAssert extends TextAssert {

    @Override
    public Button element() {
        return (Button) super.element();
    }

    @JDIAction("Assert that '{name}' is loading")
    public ButtonAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true));
        return this;
    }

    public ButtonAssert iconType(String type) {
        jdiAssert(element().icon().hasType(), Matchers.is(type));
        return this;
    }

    @Override
    public ButtonAssert has() {
        return this;
    }

    @Override
    public ButtonAssert and() {
        return this;
    }

    @Override
    public ButtonAssert is() {
        return this;
    }
}
