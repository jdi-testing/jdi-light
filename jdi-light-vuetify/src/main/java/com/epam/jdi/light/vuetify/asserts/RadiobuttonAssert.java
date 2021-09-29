package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Radiobutton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RadiobuttonAssert extends UIAssert<RadiobuttonAssert, Radiobutton> {

    @JDIAction("Assert that '{name}' is checked")
    public RadiobuttonAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public RadiobuttonAssert unchecked() {
        jdiAssert(element().isDisabled(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' input color is '{color}'")
    public RadiobuttonAssert color(String color) {
        jdiAssert(element().inputColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' label text is '{text}'")
    public RadiobuttonAssert labelText(String text) {
        jdiAssert(element().labelText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that group direction '{name}' is '{text}'")
    public RadiobuttonAssert groupDirection(String text) {
        jdiAssert(element().groupDirection(), Matchers.is(text));
        return this;
    }

}
