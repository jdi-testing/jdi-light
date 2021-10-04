package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, Switch> {

    @JDIAction("Is '{name}' checked")
    public SwitchAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Is '{name}' unchecked")
    public SwitchAssert unchecked() {
        jdiAssert(element().isNotChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Is '{name}' enabled")
    public SwitchAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Is '{name}' disabled")
    public SwitchAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("'{name}' input color is '{color}'")
    public SwitchAssert inputColor(String color) {
        jdiAssert(element().getInputColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("'{name}' input color is '{text}'")
    public SwitchAssert labelText(String text) {
        jdiAssert(element().getLabelText(), Matchers.is(text));
        return this;
    }

    @JDIAction("'{name}' label contains '{text}'")
    public SwitchAssert labelContains(String text) {
        jdiAssert(element().getLabelText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("'{name}' has label HTML element")
    public SwitchAssert labelHTML() {
        jdiAssert(element().getLabelHTML().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("'{name}' has input progress bar")
    public SwitchAssert inputProgressBar() {
        jdiAssert(element().hasInputProgressBar(), Matchers.is(true));
        return this;
    }
}
