package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.InputAssert;
import com.epam.jdi.tools.Timer;
import org.openqa.selenium.Keys;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

/**
 * To see an example of Input web element please visit https://vuetifyjs.com/en/components/inputs/
 */

public class Input extends UIBaseElement<InputAssert> {

    private final String LABEL = "div label";
    private final String INPUT = "div input";
    private final String SLOT = "div .v-input__slot";
    private final String MESSAGE = "div .v-messages__message";
    private final String PREPEND_OUTER = ".v-input__prepend-outer";
    private final String PREPEND_INNER = "div .v-input__prepend-inner";
    private final String APPEND_OUTER = ".v-input__append-outer";
    private final String APPEND_INNER = "div .v-input__append-inner";
    private final String SWITCH_SELECTION_CONTROL = "div .v-input--selection-controls__ripple";

    private UIElement input() {
        return this.find(INPUT);
    }

    private UIElement label() {
        return this.find(LABEL);
    }

    private UIElement message() {
        return this.find(MESSAGE);
    }

    private UIElement prependOuter() {
        return this.find(PREPEND_OUTER);
    }

    private UIElement prependInner() {
        return this.find(PREPEND_INNER);
    }

    private UIElement appendOuter() {
        return this.find(APPEND_OUTER);
    }

    private UIElement appendInner() {
        return this.find(APPEND_INNER);
    }

    private UIElement switchSelectionControl() {
        return this.find(SWITCH_SELECTION_CONTROL);
    }

    @Override
    public InputAssert is() {
        return new InputAssert().set(this);
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return this.hasClass("v-input--is-disabled");
    }

    @JDIAction("Check that '{name}' has text field")
    public boolean hasTextField() {
        return this.input().attr("type").equals("text");
    }

    @JDIAction("Type text to {name}'s input field")
    public void typeText(String text) {
        input().sendKeys(text + Keys.ENTER);
    }

    @JDIAction("Clear {name}'s text field and type text to it")
    public void clearAndTypeText(String text) {
        this.clearTextField();
        input().sendKeys(text + Keys.ENTER);
    }

    @JDIAction("Check that '{name}' has typed text in the text field")
    public boolean hasTypedText() {
        return !input().getText().isEmpty();
    }

    @JDIAction("Get {name}'s typed text")
    public String getTypedText() {
        return input().getText();
    }

    @JDIAction("Get text from disabled '{name}'")
    public boolean hasTextInSlot() {
        return !this.find(SLOT).getText().isEmpty();
    }

    @JDIAction("Get text from disabled '{name}'")
    public String getTextInSlot() {
        return this.find(SLOT).getText();
    }

    @JDIAction("Clear {name}'s input field")
    public void clearTextField() {
        if (getOs().equals(OsTypes.MAC)) {
            input().sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        } else {
            input().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
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

    @JDIAction("Check that '{name}' has error message")
    public boolean hasErrorMessage() {
        return this.hasClass("error--text");
    }

    @JDIAction("Get {name}'s message")
    public String getMessage() {
        return this.find(MESSAGE).getText();
    }

    @JDIAction("Check that '{name}' is loading")
    public boolean isLoading() {
        return this.hasClass("v-input--is-loading");
    }

    @JDIAction("Check that '{name}' has prepend outer")
    public boolean hasPrependOuter() {
        return new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.prependOuter().isExist());
    }

    @JDIAction("Click on {name}'s prepend outer")
    public void clickOnPrependOuter() {
        this.prependOuter().click();
    }

    @JDIAction("Check that '{name}' has prepend inner")
    public boolean hasPrependInner() {
        return new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.prependInner().isExist());
    }

    @JDIAction("Click on {name}'s prepend inner")
    public void clickOnPrependInner() {
        this.prependInner().click();
    }

    @JDIAction("Check that '{name}' has append outer")
    public boolean hasAppendOuter() {
        return new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.appendOuter().isExist());
    }

    @JDIAction("Click on {name}'s prepend outer")
    public void clickOnAppendOuter() {
        this.appendOuter().click();
    }

    @JDIAction("Check that '{name}' has append inner")
    public boolean hasAppendInner() {
        return new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.appendInner().isExist());
    }

    @JDIAction("Click on {name}'s prepend inner")
    public void clickOnAppendInner() {
        this.appendInner().click();
    }

    @JDIAction("Check that {name}'s switch is checked")
    public boolean hasSwitch() {
        return this.input().attr("role").equals("switch");
    }

    @JDIAction("Check that {name}'s switch is checked")
    public boolean switchIsChecked() {
        return this.input().attr("aria-checked").equals("true");
    }

    @JDIAction("Check {name}'s switch")
    public void checkSwitch() {
        if (!switchIsChecked()) {
            this.switchSelectionControl().click();
        }
    }

    @JDIAction("Check {name}'s switch")
    public void uncheckSwitch() {
        if (switchIsChecked()) {
            this.switchSelectionControl().click();
        }
    }

    @JDIAction("Check that '{name}' has class '{0}'")
    public boolean hasClass(String className) {
        return this.core().hasClass(className);
    }
}