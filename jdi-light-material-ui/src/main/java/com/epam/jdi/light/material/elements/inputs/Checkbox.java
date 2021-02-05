package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;

public class Checkbox extends UIBaseElement<CheckboxAssert> {

    @JDIAction("Is '{name}' disabled")
    public boolean isDisabledCheckbox() {
        return core().hasClass("Mui-disabled");
    }

}
