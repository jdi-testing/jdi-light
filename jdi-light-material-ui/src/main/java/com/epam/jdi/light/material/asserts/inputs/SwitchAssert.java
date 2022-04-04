package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Switch;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SwitchAssert extends UIAssert<SwitchAssert, Switch> {

    /**
     * Checks that switch is checked.
     *
     * @return this {@link SwitchAssert} instance
     */
    @JDIAction("Assert that '{name}' is checked")
    public SwitchAssert checked() {
        jdiAssert(element().isChecked() ? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    /**
     * Checks that switch is unchecked.
     *
     * @return this {@link SwitchAssert} instance
     */
    @JDIAction("Assert that '{name}' is unchecked")
    public SwitchAssert unchecked() {
        jdiAssert(element().isUnchecked() ? "is unchecked" : "is checked", Matchers.is("is unchecked"));
        return this;
    }

    /**
     * Checks that switch has a label.
     *
     * @return this {@link SwitchAssert} instance
     */
    @JDIAction("Assert that '{name}' has label")
    public SwitchAssert label() {
        jdiAssert(element().label().isDisplayed() ? "has label" : "does not have label",
            Matchers.is("has label"));
        return this;
    }

    /**
     * Checks that switch has given text label.
     *
     * @param labelText expected text label
     * @return this {@link SwitchAssert} instance
     */
    @JDIAction("Assert that '{name}' label has text '{0}'")
    public SwitchAssert labelText(String labelText) {
        jdiAssert(element().labelText(), Matchers.is(labelText));
        return this;
    }
}


