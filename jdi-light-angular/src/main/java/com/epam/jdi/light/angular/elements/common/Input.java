package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.InputAssert;
import com.epam.jdi.light.angular.elements.enums.InputsTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Input extends UIBaseElement<InputAssert> implements IsInput, SetValue, HasLabel {

    private static final String FORM_FIELD_LOCATOR = "//ancestor::mat-form-field";
    private static final String FOCUS_CLASS = "mat-focused";

    @JDIAction("Press button '{0}' in '{name}'")
    public Input pressButton(Keys key) {
        core().sendKeys(key);
        return this;
    }

    @JDIAction("Check that '{name}' is readonly")
    public Boolean isReadonly() {
        return Boolean.valueOf(core().getAttribute("readonly"));
    }

    @JDIAction("Get input type '{name}'")
    public InputsTypes inputType() {
        return InputsTypes.fromType(core().getAttribute("type"));
    }

    @JDIAction("Set text '{name}' as ‘{0}’")
    public void setValue(String value) {
        input(value);
    }

    @JDIAction("Get '{name}' text")
    public String getValue() {
        return core().getAttribute("value");
    }

    @JDIAction("Focus on '{name}'")
    public void focus() {
        core().click();
    }

    @JDIAction("Check that '{name}' is focused")
    public boolean isFocused() {
        return core().find(By.xpath(FORM_FIELD_LOCATOR)).hasClass(FOCUS_CLASS);
    }

    @JDIAction("Check that '{name}' has aria-label '{0}'")
    public boolean hasAriaLabel(String ariaLabel) {
        return core().attr("aria-label").contains(ariaLabel);
    }

    @Override
    public InputAssert is() {
        return new InputAssert().set(this);
    }
}
