package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.inputs.GroupCheckBoxAssert;

public class GroupCheckbox extends UIBaseElement<GroupCheckBoxAssert> implements HasClick {

    @JDIAction("Click on '{name}'")
    public void clickOnCheckBoxByIndex(int index) {
        core().finds(".MuiCheckbox-root").get(index).click();
    }

    @JDIAction("Get '{name}'")
    public boolean isCheckboxChecked(int index) {
        return core().finds(".MuiCheckbox-root").get(index).hasClass("Mui-checked");
    }

    @JDIAction("Get '{name}'")
    public boolean isCheckboxUnchecked(int index) {
        return !isCheckboxChecked(index);
    }

    @JDIAction("Is '{name}' disabled")
    public boolean isCheckBoxDisabled(int index) {
        return core().finds(".MuiCheckbox-root").get(index).hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    public boolean isCheckBoxEnabled(int index) {
        return core().finds(".MuiCheckbox-root").get(index).isEnabled();
    }

    @Override
    public GroupCheckBoxAssert is() {
        return new GroupCheckBoxAssert().set(this);
    }

}
