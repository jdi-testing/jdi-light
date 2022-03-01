package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, Switch> {

    @JDIAction("Is '{name}' checked")
    public SwitchAssert checked() {
        jdiAssert(element().isChecked() ? "is checked" :
                "isn't checked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Is '{name}' unchecked")
    public SwitchAssert unchecked() {
        jdiAssert(element().isNotChecked() ? "is unchecked" :
                "isn't unchecked", Matchers.is("is unchecked"));
        return this;
    }

    @JDIAction("Is '{name}' enabled")
    public SwitchAssert enabled() {
        jdiAssert(element().isEnabled() ? "is enabled" :
                "isn't enabled", Matchers.is("is enabled"));
        return this;
    }

    @JDIAction("Is '{name}' disabled")
    public SwitchAssert disabled() {
        jdiAssert(element().isDisabled() ? "is disabled" :
                "isn't disabled", Matchers.is("is disabled"));
        return this;
    }

    @JDIAction("'{name}' input color is '{color}'")
    public SwitchAssert inputColor(String color) {
        jdiAssert(element().find(".v-input--selection-controls__ripple").getCssValue("color"), Matchers.is(color));
        return this;
    }

    @JDIAction("'{name}' input color is '{text}'")
    public SwitchAssert labelText(String text) {
        jdiAssert(element().label(), Matchers.is(text));
        return this;
    }

    @JDIAction("'{name}' label contains '{text}'")
    public SwitchAssert labelContains(String text) {
        jdiAssert(element().label().getText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("'{name}' has label HTML element")
    public SwitchAssert labelHTML() {
        jdiAssert(element().label().find("div").isDisplayed() ? "has label HTML element" :
                "hasn't label HTML element", Matchers.is("has label HTML element"));
        return this;
    }
}
