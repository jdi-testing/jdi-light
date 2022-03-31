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
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.inputs.CanBeFocused;
import com.epam.jdi.light.material.interfaces.inputs.HasAdornment;
import com.epam.jdi.light.material.interfaces.inputs.HasHelperText;
import com.epam.jdi.light.material.interfaces.inputs.HasPlaceholder;
import com.epam.jdi.light.material.interfaces.inputs.HasValidationError;
import org.openqa.selenium.Keys;

/**
 * Represents text field MUI component on GUI.
 * The TextField wrapper component is a complete form control that can contain
 * a label, input, helper text, placeholder and adornment.
 *
 * @see <a href="https://mui.com/components/text-fields/">Text Field MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class TextField extends UIBaseElement<TextFieldAssert>
        implements IsInput, HasClick, HasAdornment, CanBeFocused,
        HasHelperText, HasValidationError, HasPlaceholder, HasLabel, CanBeDisabled {

    /**
     * Gets the input field of the text field.
     *
     * @return input field as {@link IsInput}
     */
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

    /**
     * Checks if the input field is readonly or not (i.e. can be edited or not).
     *
     * @return {@code true} if the input field is readonly, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is readonly")
    public boolean isReadonly() {
        return inputField().hasAttribute("readonly");
    }

    @Override
    @JDIAction("Get '{name}' text area text")
    public String getText() {
        return inputField().getText();
    }

    /**
     * Gets the type of the input field (e.g. password, text, number, search).
     *
     * @return the type of the input field as {@link String}
     */
    @JDIAction("Get '{name}' type")
    public String type() {
        return inputField().attr("type");
    }

    @Override
    @JDIAction("Get '{name}' placeholder text")
    public String placeHolderText() {
        String res = null;
        if (label().attr("data-shrink").equals("false")) {
            res = label().getText();
        } else if (inputField().hasAttribute("placeholder")) {
            res = inputField().attr("placeholder");
        }
        return res;
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }
}
