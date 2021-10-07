package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.InputAssert;
import org.openqa.selenium.Keys;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

public class Input extends UIBaseElement<InputAssert> {

    private final String INPUT_FIELD = "div input[type='text']";
    private final String TEXT_FROM_DISABLED = "div .v-input__slot";
    private final String LABEL = "div label";
    private final String MESSAGE = "div .v-messages__message";

    private UIElement inputField() {
        return this.find(INPUT_FIELD);
    }

    private UIElement label() {
        return this.find(LABEL);
    }

    private UIElement message() {
        return this.find(MESSAGE);
    }

    @Override
    public InputAssert is() {
        return new InputAssert().set(this);
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return this.hasAttribute("v-input--is-disabled");
    }

    @JDIAction("Type text to {name}'s input field")
    public void typeText(String text) {
        inputField().sendKeys(text);
    }

    @JDIAction("Check that '{name}' has typed text in the text field")
    public boolean hasTypedText() {
        return !inputField().getText().isEmpty();
    }

    @JDIAction("Get {name}'s typed text")
    public String getTypedText() {
        return inputField().getText();
    }

    @JDIAction("Get text from disabled '{name}'")
    public String getTextFromDisabled() {
        return this.find(TEXT_FROM_DISABLED).getText();
    }

    @JDIAction("Clear {name}'s input field")
    public void clearTextField() {
        if (getOs().equals(OsTypes.MAC)) {
            inputField().sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        } else {
            inputField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }

    @JDIAction("Check that '{name}' has label")
    public boolean hasLabel() {
        return label().isExist();
    }

    @JDIAction("Get {name}'s label")
    public String getLabel() {
        return label().getText();
    }

    @JDIAction("Check that '{name}' has message")
    public boolean hasMessage() {
        return message().isExist();
    }

    @JDIAction("Get {name}'s message")
    public String getMessage() {
        return this.find(MESSAGE).getText();
    }

    @JDIAction("Check that '{name}' is loading")
    public boolean isLoading() {
        return this.hasAttribute("v-input--is-loading");
    }
}