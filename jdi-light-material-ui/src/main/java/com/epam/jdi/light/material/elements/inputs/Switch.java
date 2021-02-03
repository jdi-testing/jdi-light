package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.SwitchAssert;
import org.openqa.selenium.By;

public class Switch extends UIBaseElement<SwitchAssert> {

    @JDIAction("Toggle '{name}'")
    public void toggle() {
        core().click();
    }

    @JDIAction("Is '{name}' checked")
    public Boolean isChecked() {
        return selector().hasClass("Mui-checked");
    }

    @JDIAction("Is '{name}' unchecked")
    public Boolean isUnchecked() {
        return !isChecked();
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isDisabled() {
        return selector().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name} enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    public UIElement selector() {
        return this.find(By.cssSelector("span[class*='MuiButtonBase-root']"));
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }

}
