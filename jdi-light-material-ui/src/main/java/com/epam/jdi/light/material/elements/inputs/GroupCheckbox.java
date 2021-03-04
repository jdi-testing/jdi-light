package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.inputs.GroupCheckBoxAssert;

public class GroupCheckbox extends UIBaseElement<GroupCheckBoxAssert> implements HasClick {

    @JDIAction("Click on '{name}'")
    public void clickUncheckedCheckBox() {
        core().find("#root > div > span:nth-child(1)").click();
    }

    @JDIAction("Click on '{name}'")
    public void clickCheckedCheckBox() {
        core().find("#root > div > span:nth-child(2)").click();
    }

    @JDIAction("Is '{name}' disabled")
    public boolean isCheckBoxDisabled() {
        return core().find("#root > div > span:nth-child(3)").isDisabled();
    }

    @JDIAction("Is '{name}' disabled")
    public boolean isCheckBoxEnabled() {
        return core().find("MuiIconButton-root").isEnabled();
    }

    @JDIAction("Is '{name}' checked")
    public boolean isCheckBoxChecked() {
        return core().find("Mui-checked").isDisplayed();
    }

    @JDIAction("Is '{name}' unchecked")
    public boolean isCheckBoxUnchecked() {
        return !isCheckBoxChecked();
    }

}
