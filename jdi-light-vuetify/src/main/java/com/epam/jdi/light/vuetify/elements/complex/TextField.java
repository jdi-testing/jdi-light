package com.epam.jdi.light.vuetify.elements.complex;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.vuetify.asserts.TextFieldAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.Keys;

/**
 * To see an example of Text Field web element please visit
 * https://vuetifyjs.com/en/components/text-fields
 **/
public class TextField extends UIBaseElement<TextFieldAssert>
        implements HasLabel, HasPlaceholder, IsInput {
    private String input = ".//input|.//textarea";
    private String slot = ".v-input__slot";
    private String message = ".v-messages__message";
    private String counter = ".v-counter";
    private String prefix = ".v-text-field__prefix";
    private String suffix = ".v-text-field__suffix";
    private String icon = ".v-icon";

    @JDIAction("Get '{name}' text input field")
    public UIElement textInputField() {
        return find(input);
    }

    @JDIAction("Get '{name}' icon")
    public UIElement icon() {
        return find(icon);
    }

    @JDIAction("Get '{name}' slot")
    public UIElement slot() {
        return find(slot);
    }

    @JDIAction("Get '{name}' message")
    public UIElement message() {
        return find(message);
    }

    @JDIAction("Get '{name}' counter")
    public UIElement counter() {
        return find(counter);
    }

    @JDIAction("Get '{name}' prefix")
    public UIElement prefix() {
        return find(prefix);
    }

    @JDIAction("Get '{name}' suffix")
    public UIElement suffix() {
        return find(suffix);
    }

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return textInputField().getText();
    }

    @JDIAction("Get '{name}' text type")
    public String getTextType() {
        return textInputField().getAttribute("type");
    }

    @Override
    public Label label() {
        return textInputField().label();
    }

    @Override
    @JDIAction("Get '{name}' placeholder")
    public String placeholder() {
        return textInputField().placeholder();
    }

    @Override
    @JDIAction("Set '{0}' in '{name}'")
    public void input(String value) {
        clear();
        textInputField().input(value);
    }

    @Override
    @JDIAction("Set '{0}' in '{name}'")
    public void setText(String value) {
        input(value);
    }

    @Override
    @JDIAction("Input '{0}' in '{name}'")
    public void sendKeys(CharSequence... value) {
        textInputField().sendKeys(value);
    }

    @Override
    @JDIAction("Focus on '{name}'")
    public void focus() {
        sendKeys("");
    }

    @Override
    @JDIAction("Clear '{name}' text field")
    public void clear() {
        if (getOs().equals(OsTypes.MAC)) {
            textInputField().sendKeys(Keys.chord(Keys.COMMAND, "a") + Keys.BACK_SPACE);
        } else {
            textInputField().sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        }
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }
}
