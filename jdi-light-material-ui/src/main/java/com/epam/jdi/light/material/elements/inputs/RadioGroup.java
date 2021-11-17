package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.material.asserts.inputs.RadioAssert;

public class RadioGroup extends UIListBase<RadioAssert>
        implements IClickable, HasLabel, CanBeSelected {

    @JDIAction("Check that '{name}' is enabled")
    @Override
    public boolean isEnabled() {
        "MuiFormGroup-root";
        return !core().hasClass("Mui-disabled") && super.isEnabled();
    }

    @Override
    public RadioAssert is() {
        return new RadioAssert().set(this);
    }

    @Override
    public Label label() {
        Label l = new Label().setCore(Label.class, find("../*[contains(@class, 'MuiFormControlLabel-label')]"));
        l.setName("aa");
        return l;
    }

    @Override
    public void click() {
        core().click();
    }
}
