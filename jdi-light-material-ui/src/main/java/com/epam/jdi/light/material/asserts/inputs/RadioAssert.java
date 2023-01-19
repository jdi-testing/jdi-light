package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.RadioButtons;
import com.epam.jdi.light.material.elements.utils.enums.Position;

/**
 * Assertion for {@link RadioButtons}
 */
public class RadioAssert extends UISelectAssert<RadioAssert, RadioButtons> {

    /**
     * Checks that {@link RadioButtons} has position meets the given condition.
     *
     * @param index         expected index condition of Radio button in the list of Radio buttons' label
     * @param labelPosition expected position label condition (e.g. "top", "start", topCenter")
     * @return this {@link RadioAssert} instance
     */
    @JDIAction("Assert that '{name}' radio button '{0}' label has position '{1}'")
    public RadioAssert position(int index, Position labelPosition) {
        element().labels().get(index).hasClass(labelPosition.toString());
        return this;
    }

    /**
     * Checks that {@link RadioButtons} has position meets the given condition.
     *
     * @param label         expected label condition of Radio button in the list of Radio buttons' label
     * @param labelPosition expected position label condition (e.g. "top", "start", topCenter")
     * @return this {@link RadioAssert} instance
     */
    @JDIAction("Assert that '{name}' radio button '{0}' label has position '{1}'")
    public RadioAssert position(String label, Position labelPosition) {
        int index = element().values().indexOf(label);
        element().labels().get(index).hasClass(labelPosition.toString());
        return this;
    }
}

