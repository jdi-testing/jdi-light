package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.InputAssert;
import com.epam.jdi.light.angular.elements.enums.InputsTypes;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import org.openqa.selenium.Keys;

public class Input extends UIBaseElement<InputAssert> implements IsInput, SetValue, HasLabel {

    private String focusClass = "mdc-line-ripple--active";

    @JDIAction("Press button '{0}' in '{name}'")
    public Input pressButton(Keys key) {
        core().sendKeys(key);
        return this;
    }

    @JDIAction(value = "Get if '{name}' has readonly attribute")
    public Boolean readonly() {
        return Boolean.valueOf(core().getAttribute("readonly"));
    }

    @JDIAction(value = "Get input type '{name}'")
    public InputsTypes inputType() {
        return InputsTypes.fromType(core().getAttribute("type"));
    }

    @JDIAction("Set text '{name}' as ‘{0}’")
    public void setValue(String value) {
        input(value);
    }

    @JDIAction(value = "Get '{name}' text")
    public String getValue() {
        return core().getAttribute("value");
    }

    @JDIAction
    public void focus() {
        core().click();
    }

    @JDIAction
    public boolean hasFocus() {
        return true;
    }

    @Override
    public InputAssert is() {
        return new InputAssert().set(this);
    }
}
