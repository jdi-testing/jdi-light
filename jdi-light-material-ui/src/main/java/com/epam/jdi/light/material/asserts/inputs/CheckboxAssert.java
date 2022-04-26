package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Checkbox}
 */
public class CheckboxAssert extends UIAssert<CheckboxAssert, Checkbox> implements IColorAssert<CheckboxAssert> {

    /**
     * Checks that checkbox is checked.
     *
     * @return this {@link CheckboxAssert} instance
     */
    @JDIAction("Assert that '{name}' is checked")
    public CheckboxAssert checked() {
        jdiAssert(element().isChecked() ? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    /**
     * Checks that checkbox is unchecked.
     *
     * @return this {@link CheckboxAssert} instance
     */
    @JDIAction("Assert that '{name}' is unchecked")
    public CheckboxAssert unchecked() {
        jdiAssert(element().isUnchecked() ? "is unchecked" : "is checked", Matchers.is("is unchecked"));
        return this;
    }

    /**
     * Checks that checkbox is indeterminate.
     *
     * @return this {@link CheckboxAssert} instance
     */
    @JDIAction("Assert that '{name}' is indeterminate")
    public CheckboxAssert indeterminate() {
        jdiAssert(element().isIndeterminate() ? "is indeterminate" : "isn't indeterminate", Matchers.is("is indeterminate"));
        return this;
    }

    /**
     * Checks that checkbox has given color.
     *
     * @param condition expected color in form like "rgba(120, 1, 60, 0.52)"
     * @return this {@link CheckboxAssert} instance
     */
    @JDIAction("Assert that '{name}' color {0}")
    public CheckboxAssert color(Matcher<String> condition) {
        jdiAssert(element().color(), condition);
        return this;
    }

    /**
     * Checks that checkbox has given position.
     *
     * @param position expected position of the label relative to the checkbox
     * @return this {@link CheckboxAssert} instance
     */
    @JDIAction("Assert that '{name}' label has position '{0}'")
    public CheckboxAssert labelPosition(Position position) {
        jdiAssert(element().labelPosition(), Matchers.is(position));
        return this;
    }
}
