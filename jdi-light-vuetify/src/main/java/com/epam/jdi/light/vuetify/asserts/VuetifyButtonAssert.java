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

    @JDIAction("Assert that '{name}' color is '{0}'")
    public VuetifyButtonAssert color(String color) {
        jdiAssert(element().color(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has color '{0}'")
    public VuetifyButtonAssert backgroundColor(String color) {
        jdiAssert(element().backgroundColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has border color '{0}'")
    public VuetifyButtonAssert borderColor(String color) {
        jdiAssert(element().borderColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' is clickable")
    public VuetifyButtonAssert clickable() {
        jdiAssert(element().core().isClickable(), Matchers.is(true));
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
