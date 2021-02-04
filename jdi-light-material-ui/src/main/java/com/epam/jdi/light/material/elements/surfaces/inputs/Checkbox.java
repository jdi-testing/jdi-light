package com.epam.jdi.light.material.elements.surfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.surfaces.inputs.CheckboxAssert;

public class Checkbox extends UIBaseElement<CheckboxAssert> {

//    @JDIAction("Get '{name}'")
//    public UIElement primaryCheckbox() {
//        return e.find(By.xpath("//span[contains(@class,'MuiButtonBase-root')]"));
//    }

    @JDIAction("Click on '{name}'")
    public void clickOnCheckbox() {
        core().click();
    }

    @JDIAction("Is '{name}' selected")
    public boolean isSelectedCheckbox() {
        return core().isDisplayed();
    }

    @JDIAction("Is '{name}' selected")
    public boolean isEnabledCheckbox() {
        return core().isEnabled();
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }


}
