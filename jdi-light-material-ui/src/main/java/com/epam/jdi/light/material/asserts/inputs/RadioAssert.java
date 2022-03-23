package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.RadioButtons;
import com.epam.jdi.light.material.elements.utils.enums.LabelPosition;

public class RadioAssert extends UISelectAssert<RadioAssert, RadioButtons> {

    @JDIAction("Assert that '{name}' radio button {0} label has position '{1}'")
    public RadioAssert labelPosition(int index, LabelPosition labelPosition) {
        element().labels().get(index).hasClass(labelPosition.getPosition());
        return this;
    }

    @JDIAction("Assert that '{name}' radio button '{0}' label has position '{1}'")
    public RadioAssert labelPosition(String value, LabelPosition labelPosition) {
        int index = element().values().indexOf(value);
        element().labels().get(index).hasClass(labelPosition.getPosition());
        return this;
    }
}

