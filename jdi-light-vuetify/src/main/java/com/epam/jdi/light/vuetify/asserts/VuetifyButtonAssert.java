package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import org.hamcrest.Matchers;

public class VuetifyButtonAssert extends TextAssert {

    @Override
    public VuetifyButton element() {
        return (VuetifyButton) super.element();
    }

    @JDIAction("Assert that '{name}' is loading")
    public VuetifyButtonAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true));
        return this;
    }

    public VuetifyButtonAssert iconType(String type) {
        jdiAssert(element().icon().hasType(), Matchers.is(type));
        return this;
    }

    @Override
    public VuetifyButtonAssert has() {
        return this;
    }

    @Override
    public VuetifyButtonAssert and() {
        return this;
    }

    @Override
    public VuetifyButtonAssert is() {
        return this;
    }
}
