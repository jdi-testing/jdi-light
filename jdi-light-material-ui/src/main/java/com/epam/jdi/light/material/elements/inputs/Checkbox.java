package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasClick, HasCheck,
    HasAssert<CheckboxAssert> {

    @JDIAction("Is '{name}' selected")
    public boolean isSelected() {
        return core().hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' not selected")
    public boolean isNotSelected() {
        return !isSelected();
    }

    @JDIAction("Check '{name}'")
    @Override
    public void check() {
        if (isNotSelected()) {
            click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    @Override
    public void uncheck() {
        if(isSelected()) {
            click();
        }
    }

    @JDIAction("Is '{name}' disabled")
    @Override
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    @Override
    public boolean isEnabled() {
        return core().isEnabled() && !isDisabled();
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
