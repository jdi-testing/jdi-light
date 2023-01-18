package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Checkbox}.
 */
public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> {

    /**
     * Checks that checkbox is checked.
     *
     * @return this {@link CheckboxAssert} instance
     */
    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        jdiAssert(element().isChecked(), Matchers.is(true), "Checkbox is not checked");
        return this;
    }

    /**
     * Checks that checkbox is unchecked.
     *
     * @return this {@link CheckboxAssert} instance
     */
    @JDIAction("Assert that '{name}' is unchecked")
    public CheckboxAssert unchecked() {
        jdiAssert(element().isUnchecked(), Matchers.is(true), "Checkbox is not unchecked");
        return this;
    }

    /**
     * Checks that checkbox is indeterminate.
     *
     * @return this {@link CheckboxAssert} instance
     */
    @JDIAction("Assert that '{name}' is indeterminate")
    public CheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true), "Checkbox is not indeterminate");
        return this;
    }

    /**
     * Checks that checkbox has given position.
     *
     * @param position expected position of the label relative to the checkbox
     * @return this {@link CheckboxAssert} instance
     */
    @JDIAction("Assert that '{name}' label has position '{0}'")
    public CheckboxAssert labelPosition(String position) {
        jdiAssert(element().labelPosition().toString(), Matchers.is(position));
        return this;
    }
}
