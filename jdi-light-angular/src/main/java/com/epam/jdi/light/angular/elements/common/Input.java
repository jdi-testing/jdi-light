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

    @JDIAction(value = "Get if '{name}' has auto-size attribute")
    public boolean hasAutoSize() {
        return attrs().has("cdktextareaautosize");
    }

    @JDIAction("Set text '{name}' as ‘{0}’")
    public void setValue(String value) {
        input(value);
    }

    @JDIAction(value = "Get '{name}' text")
    public String getValue() {
        return core().getAttribute("value");
    }

    @Override
    public String labelText() {
        return core().getAttribute("aria-label");
    }

    @Override
    public InputAssert is() {
        return new InputAssert().set(this);
    }
}
