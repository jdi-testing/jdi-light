package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;
import org.openqa.selenium.By;

public class Checkbox extends UIBaseElement<CheckboxAssert> {

    @JDIAction("Click on '{name}'")
    public void clickOnCheckbox() {
        core().click();
    }

    @JDIAction("Is '{name}' selected")
    public boolean isSelectedCheckbox() {
        return core().hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' not selected")
    public boolean isNotSelectedCheckbox() {
        return !isSelectedCheckbox();
    }

    @JDIAction("Is '{name}' selected")
    public boolean isEnabledCheckbox() {
        return core().isEnabled();
    }

    @JDIAction("Check '{name}'")
    public boolean check() {
        if (isSelectedCheckbox()) {
            return true;
        } else
            return false;
    }

    @JDIAction("Do not check '{name}'")
    public boolean unCheck() {
        if(isNotSelectedCheckbox()) {
            return true;
        } else
            return false;
    }

    @JDIAction("Is '{name}' disabled")
    public boolean isDisabledCheckbox() {
        return core().hasClass("Mui-disabled");
    }

    @JDIAction("Is'{name}' displayed")
    public boolean isFormControlDisplayed() {
        return core().hasClass("MuiInputBase-formControl");
    }

    @JDIAction("Get '{name}' text")
    public String emailText() {
        return core().find(By.className("MuiInputLabel-animated")).getText();
    }

    @JDIAction("Get'{name}' text")
    public String helperText() {
        return core().find(By.id("my-helper-text")).getText();
    }

    @JDIAction("Is group '{name}' disabled")
    public boolean isGroupCheckboxDisplayed() {
        return core().find("Mui-disabled").isDisabled();
    }

    @JDIAction("Select group '{name}'")
    public boolean checkGroupSecondCheckbox() {
        return core().hasClass("MuiCheckbox-colorSecondary");
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }


}
