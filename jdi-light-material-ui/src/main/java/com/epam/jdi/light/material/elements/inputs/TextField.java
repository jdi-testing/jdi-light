package com.epam.jdi.light.material.elements.inputs;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.material.asserts.inputs.TextFieldAssert;
import com.epam.jdi.light.material.interfaces.inputs.CanBeFocused;
import com.epam.jdi.light.material.interfaces.inputs.HasAdornment;
import com.epam.jdi.light.material.interfaces.inputs.HasHelperText;
import com.epam.jdi.light.material.interfaces.inputs.HasPlaceholder;
import com.epam.jdi.light.material.interfaces.inputs.HasValidationError;
import org.openqa.selenium.Keys;

/**
 * To see examples of Text Field web elements please visit
 * https://mui.com/components/text-fields/
 */

public class TextField extends UIBaseElement<TextFieldAssert>
        implements IsInput, HasClick, HasAdornment, CanBeFocused,
        HasHelperText, HasValidationError, HasPlaceholder, HasLabel {

    protected IsInput inputField() {
        return find("input");
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return new Label().setCore(Label.class, find("label"));
    }

    @Override
    @JDIAction("Send text to '{name}' text area")
    public void sendKeys(CharSequence... text) {
        inputField().sendKeys(text);
    }

    @Override
    @JDIAction("Set text '{name}' text area as {0}")
    public void setText(String value) {
        inputField().setText(value);
    }

    @Override
    @JDIAction("Clear '{name}' text field")
    public void clear() {
        if (getOs().equals(OsTypes.MAC)) {
            inputField().sendKeys(Keys.chord(Keys.COMMAND, "a") + Keys.BACK_SPACE);
        } else {
            inputField().sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        }
    }

    @Override
    @JDIAction("Check that '{name}' text area is empty")
    public boolean isEmpty() {
        return getText().isEmpty();
    }

    @Override
    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return label().hasClass("Mui-disabled");
    }

    @Override
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Check that '{name}' is readonly")
    public boolean isReadonly() {
        return inputField().hasAttribute("readonly");
    }

    @Override
    @JDIAction("Check that '{name}' has placeholder")
    public boolean hasPlaceholder() {
        if (label().attr("data-shrink").equals("false")) {
            return true;
        } else {
            return inputField().hasAttribute("placeholder");
        }
    }

    @Override
    @JDIAction("Get '{name}' text area text")
    public String getText() {
        return inputField().getText();
    }

    @JDIAction("Get '{name}' type")
    public String type() {
        return inputField().attr("type");
    }

    @Override
    @JDIAction("Get '{name}' placeholder text")
    public String getPlaceHolderText() {
        String res = null;
        if (hasPlaceholder()) {
            if (label().attr("data-shrink").equals("false")) {
                res = label().getText();
            } else {
                res = inputField().attr("placeholder");
            }
        }
        return res;
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }
}
