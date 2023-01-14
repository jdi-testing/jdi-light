package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Switch;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Switch}
 */
public class SwitchAssert extends UIAssert<SwitchAssert, Switch> {

    /**
     * Checks that switch is checked.
     *
     * @return this {@link SwitchAssert} instance
     */
    @JDIAction("Assert that '{name}' is checked")
    public SwitchAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true), "Switch is not checked");
        return this;
    }

    /**
     * Checks that switch is unchecked.
     *
     * @return this {@link SwitchAssert} instance
     */
    @JDIAction("Assert that '{name}' is unchecked")
    public SwitchAssert unchecked() {
        jdiAssert(element().isUnchecked(), Matchers.is(true), "Switch is not unchecked");
        return this;
    }

    /**
     * Checks that switch has a label.
     *
     * @return this {@link SwitchAssert} instance
     */
    @JDIAction("Assert that '{name}' has a label")
    public SwitchAssert label() {
        jdiAssert(element().label().isDisplayed(), Matchers.is(true), "Switch label is not displayed");
        return this;
    }

    /**
     * Checks that switch has given label text.
     *
     * @param labelText expected label text
     * @return this {@link SwitchAssert} instance
     */
    @JDIAction("Assert that '{name}' label has text '{0}'")
    public SwitchAssert labelText(String labelText) {
        jdiAssert(element().labelText(), Matchers.is(labelText));
        return this;
    }
}


