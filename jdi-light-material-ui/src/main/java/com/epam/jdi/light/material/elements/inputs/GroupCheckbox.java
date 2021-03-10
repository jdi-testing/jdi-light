package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.inputs.GroupCheckBoxAssert;

public class GroupCheckbox extends UIBaseElement<GroupCheckBoxAssert> implements HasClick {

    private UIElement getCheckBoxByIndex(int index) {
        return core().finds(".MuiCheckbox-root").get(index);
    }


    @JDIAction("Click on '{name}'")
    public void clickOnCheckBoxByIndex(int index) {
        getCheckBoxByIndex(index).click();
    }

    @JDIAction("Is '{name}' checked")
    public boolean isCheckboxChecked(int index) {
        return getCheckBoxByIndex(index).hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' unchecked")
    public boolean isCheckboxUnchecked(int index) {
        return !isCheckboxChecked(index);
    }

    @JDIAction("Is '{name}' disabled")
    public boolean isCheckBoxDisabled(int index) {
        return getCheckBoxByIndex(index).hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    public boolean isCheckBoxEnabled(int index) {
        return getCheckBoxByIndex(index).isEnabled();
    }

    @Override
    public GroupCheckBoxAssert is() {
        return new GroupCheckBoxAssert().set(this);
    }

}
