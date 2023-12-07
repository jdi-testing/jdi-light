package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.InputAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasDetailsHidden;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import com.jdiai.tools.Timer;
import org.openqa.selenium.Keys;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

/**
 * To see an example of Input web element please visit https://vuetifyjs.com/en/components/inputs/
 */

public class Input extends UIBaseElement<InputAssert> implements HasLabel, IsReadOnly, HasMessages, IsLoading,
        HasColor, HasTheme, HasMeasurement, IsDense, HasDetailsHidden, HasClick {

    private static final String LABEL = "div label";
    private static final String INPUT = "div input";
    private static final String SLOT = ".v-input__slot";
    private static final String PREPEND_OUTER = ".v-input__prepend-outer";
    private static final String PREPEND_INNER = "div .v-input__prepend-inner";
    private static final String APPEND_OUTER = ".v-input__append-outer";
    private static final String APPEND_INNER = "div .v-input__append-inner";
    private static final String SWITCH_SELECTION_CONTROL = "div .v-input--selection-controls__ripple";

    @Override
    public InputAssert is() {
        return new InputAssert().set(this);
    }

    private UIElement input() {
        return this.find(INPUT);
    }

    private UIElement labelUIElement() {
        return this.find(LABEL);
    }

    public Label labelCore() {
        return new Label().setCore(Label.class, labelUIElement());
    }

    private UIElement slot() {
        return this.find(SLOT);
    }

    private UIElement prependOuterIcon() {
        return this.find(PREPEND_OUTER);
    }

    private UIElement prependInnerIcon() {
        return this.find(PREPEND_INNER);
    }

    private UIElement appendOuterIcon() {
        return this.find(APPEND_OUTER);
    }

    private UIElement appendInnerIcon() {
        return this.find(APPEND_INNER);
    }

    private UIElement switchSelectionControl() {
        return this.find(SWITCH_SELECTION_CONTROL);
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return hasClass("v-input--is-disabled");
    }

    @JDIAction("Get if '{name}' has text field")
    public boolean hasTextField() {
        if (input().isExist()) {
            return input().attr("type").equals("text");
        } else {
            return false;
        }
    }

    @JDIAction("Type text to '{name}' input field")
    public void typeText(String text) {
        input().sendKeys(text);
    }

    @JDIAction("Clear '{name}' text field and type text to it")
    public void clearAndTypeText(String text) {
        this.clear();
        this.typeText(text);
    }

    @JDIAction("Get if '{name}' has typed text in the text field")
    public boolean hasTypedText() {
        return !input().getText().isEmpty();
    }

    @JDIAction("Get {name}' typed text")
    public String getTypedText() {
        return input().getText();
    }

    @JDIAction("Get if '{name}' has text in slot")
    public boolean hasTextInSlot() {
        return !slot().getText().isEmpty();
    }

    @JDIAction("Get '{name}' text from slot")
    public String getTextInSlot() {
        return slot().getText();
    }

    @JDIAction("Clear '{name}' input field")
    public void clear() {
        if (getOs().equals(OsTypes.MAC)) {
            input().sendKeys(Keys.chord(Keys.COMMAND, Keys.ARROW_RIGHT));
            input().sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
        } else {
            input().sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
            input().sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.HOME));
        }
        input().sendKeys(Keys.DELETE);
    }

    @Override
    @JDIAction("Get if '{name}' has label")
    public Boolean hasLabel() {
        return labelCore().isExist() & labelCore().isDisplayed();

    }

    @JDIAction("Get '{name}' label")
    public String getLabel() {
        return labelUIElement().getText();
    }

    @JDIAction("Get if '{name}' is focused")
    public boolean isFocused() {
        return attr("class").contains("is-focused");
    }

    @JDIAction("Get if '{name}' has prepend outer icon")
    public boolean hasPrependOuterIcon() {
        return new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.prependOuterIcon().isExist());
    }

    @JDIAction("Click on '{name}' prepend outer icon")
    public void clickOnPrependOuterIcon() {
        this.prependOuterIcon().click();
    }

    @JDIAction("Get if '{name}' has prepend inner icon")
    public boolean hasPrependInnerIcon() {
        return new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.prependInnerIcon().isExist());
    }

    @JDIAction("Click on {name}'s prepend inner icon")
    public void clickOnPrependInnerIcon() {
        this.prependInnerIcon().click();
    }

    @JDIAction("Get if '{name}' has append outer icon")
    public boolean hasAppendOuterIcon() {
        return new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.appendOuterIcon().isExist());
    }

    @JDIAction("Click on '{name}' prepend outer icon")
    public void clickOnAppendOuterIcon() {
        this.appendOuterIcon().click();
    }

    @JDIAction("Get if '{name}' has append inner icon")
    public boolean hasAppendInnerIcon() {
        return new Timer(base().getTimeout() * 1000L)
                .wait(() -> this.appendInnerIcon().isExist());
    }

    @JDIAction("Click on '{name}' prepend inner icon")
    public void clickOnAppendInnerIcon() {
        this.appendInnerIcon().click();
    }

    @JDIAction("Get if '{name}' has switch")
    public boolean hasSwitch() {
        return this.input().attr("role").equals("switch");
    }

    @JDIAction("Get if '{name}' switch is checked")
    public boolean switchIsChecked() {
        return this.input().attr("aria-checked").equals("true");
    }

    @JDIAction("Check '{name}' switch")
    public void checkSwitch() {
        if (!switchIsChecked()) {
            this.switchSelectionControl().click();
        }
    }

    @JDIAction("Uncheck '{name}' switch")
    public void uncheckSwitch() {
        if (switchIsChecked()) {
            this.switchSelectionControl().click();
        }
    }

    @JDIAction("Get if '{name}' has class '{0}'")
    public boolean hasClass(String className) {
        return this.core().hasClass(className);
    }

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return slot().css("background-color");
    }
}
