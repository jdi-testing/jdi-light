package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.vuetify.asserts.TextFieldAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import org.openqa.selenium.Keys;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

public class TextField extends UIBaseElement<TextFieldAssert>
        implements HasLabel, HasPlaceholder, IsInput {

    private final String LABEL = "label";
    private final String INPUT = "input";
    private final String TEXTAREA = "textarea";
    private final String SLOT = ".v-input__slot";
    private final String MESSAGE = ".v-messages__message";
    private final String COUNTER = ".v-counter";
    private final String PREPEND_OUTER = ".v-input__prepend-outer";
    private final String PREPEND_INNER = ".v-input__prepend-inner";
    private final String APPEND_OUTER = ".v-input__append-outer";
    private final String APPEND_INNER = ".v-input__append-inner";
    private final String PREFIX = ".v-text-field__prefix";
    private final String SUFFIX = ".v-text-field__suffix";

    @Override
    @JDIAction("Check if '{name}' disabled")
    public boolean isDisabled() {
        return core().hasClass("v-input--is-disabled");
    }

    @JDIAction("Check if '{name}' readonly")
    public boolean isReadonly() {
        return core().hasClass("v-input--is-readonly");
    }

    @JDIAction("Check if '{name}' focused")
    public boolean isFocused() {
        return core().hasClass("v-input--is-focused");
    }

    @JDIAction("Get '{name}' text input field")
    public UIElement textInputField() {
        UIElement textInputField = find(INPUT);
        if (textInputField.isNotExist())
            return find(TEXTAREA);
        return textInputField;
    }

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return textInputField().getText();
    }

    @Override
    @JDIAction("Get '{name}' set text")
    public void setText(String text) {
        textInputField().input(text);
    }

    @JDIAction("Get '{name}' text type")
    public String getTextType() {
        return textInputField().getAttribute("type");
    }

    @JDIAction("Get '{name}' slot")
    public UIElement getSlot() {
        return find(SLOT);
    }

    @JDIAction("Get '{name}' message")
    public String getMessage() {
        UIElement message = find(MESSAGE);
        return message.isNotExist() ? "" : message.getText();
    }

    @JDIAction("Get '{name}' counter")
    public String getCounter() {
        UIElement counter = find(COUNTER);
        return counter.isNotExist() ? "" : counter.getText();
    }

    @Override
    public String placeholder() {
        return textInputField().placeholder();
    }

    @JDIAction("Get '{name}' icon by locator")
    protected Icon getIconByLocator(String locator, int index) {
        WebList iconArea = finds(locator);
        if(iconArea.isEmpty())
            return null;
        JDIBase core = iconArea.get(index).find("button").isExist() ? iconArea.get(index).find("button") : iconArea.get(index).find("i");
        return iconArea.isEmpty() ? null : new Icon().setCore(Icon.class, core);
    }

    @JDIAction("Get '{name}' prepend outer icon")
    public Icon getPrependOuterIcon() {
        return getPrependOuterIcon(1);
    }

    @JDIAction("Get '{name}' prepend outer [{0}] icon")
    public Icon getPrependOuterIcon(int index) {
        return getIconByLocator(PREPEND_OUTER, index);
    }

    @JDIAction("Get '{name}' prepend inner icon")
    public Icon getPrependInnerIcon() {
        return getPrependInnerIcon(1);
    }

    @JDIAction("Get '{name}' prepend inner [{0}] icon")
    public Icon getPrependInnerIcon(int index) {
        return getIconByLocator(PREPEND_INNER, index);
    }

    @JDIAction("Get '{name}' append inner icon")
    public Icon getAppendInnerIcon() {
        return getAppendInnerIcon(1);
    }

    @JDIAction("Get '{name}' append inner [{0}] icon")
    public Icon getAppendInnerIcon(int index) {
        return getIconByLocator(APPEND_INNER, index);
    }

    @JDIAction("Get '{name}' append outer icon")
    public Icon getAppendOuterIcon() {
        return getAppendOuterIcon(1);
    }

    @JDIAction("Get '{name}' append outer [{0}] icon")
    public Icon getAppendOuterIcon(int index) {
        return getIconByLocator(APPEND_OUTER, index);
    }

    @JDIAction("Get '{name}' prefix")
    public String getPrefix() {
        return find(PREFIX).getText();
    }

    @JDIAction("Get '{name}' suffix")
    public String getSuffix() {
        return find(SUFFIX).getText();
    }

    @Override
    public String labelText() {
        UIElement label = find(LABEL);
        return label.isNotExist() ? "" : label.getText();
    }

    @Override
    public void clear() {
        if (getOs().equals(OsTypes.MAC)) {
            textInputField().sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        } else {
            textInputField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }

    @JDIAction("Clear '{name}' text field and set text")
    public void clearAndSetText(String text) {
        this.clear();
        setText(text);
    }

    @Override
    public void focus() {
        textInputField().focus();
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }
}
