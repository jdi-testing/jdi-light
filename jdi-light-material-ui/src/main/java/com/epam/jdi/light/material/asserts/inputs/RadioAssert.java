package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.RadioButtons;
import com.epam.jdi.light.material.elements.utils.enums.Position;

public class RadioAssert extends UISelectAssert<RadioAssert, RadioButtons> {

    @JDIAction("Assert that radio '{0}' in '{name}' on '{1}' position")
    public RadioAssert position(int index, Position labelPosition) {
        element().labels().get(index).hasClass(labelPosition.getPosition());
        return this;
    }

    @JDIAction("Assert that radio '{0}' in '{name}' on '{1}' position")
    public RadioAssert position(String value, Position labelPosition) {
        int index = element().values().indexOf(value);
        element().labels().get(index).hasClass(labelPosition.getPosition());
        return this;
    }
}

