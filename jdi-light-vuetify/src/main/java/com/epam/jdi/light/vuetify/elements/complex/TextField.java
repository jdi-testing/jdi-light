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
import org.openqa.selenium.Keys;

/**
 * To see an example of Text Field web element please visit
 * https://vuetifyjs.com/en/components/text-fields
 **/
public class TextField extends UIBaseElement<TextFieldAssert>
        implements HasLabel, HasPlaceholder, IsInput {
    private static final String INPUT = ".//input|.//textarea";
    private static final String SLOT = ".v-input__slot";
    private static final String MESSAGE = ".v-messages__message";
    private static final String COUNTER = ".v-counter";
    private static final String PREFIX = ".v-text-field__prefix";
    private static final String SUFFIX = ".v-text-field__suffix";
    private static final String ICON = ".v-icon";

    /** Get the text input field element inside the TextField.
     * @return text input field as {@link UIElement}
     */
    @JDIAction("Get '{name}' text input field")
    public UIElement textInputField() {
        return find(INPUT);
    }

    /** Get the icon element inside the TextField.
     * @return icon as {@link UIElement}
     */
    @JDIAction("Get '{name}' icon")
    public UIElement icon() {
        return find(ICON);
    }

    /** Get the slot of the TextField.
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' slot")
    public UIElement slot() {
        return find(SLOT);
    }

    /** Get the message element of the TextField.
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' message")
    public UIElement message() {
        return find(MESSAGE);
    }

    /** Get the counter of the TextField.
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' counter")
    public UIElement counter() {
        return find(COUNTER);
    }

    /** Get the prefix of the TextField.
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' prefix")
    public UIElement prefix() {
        return find(PREFIX);
    }

    /** Get the suffix of the TextField.
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' suffix")
    public UIElement suffix() {
        return find(SUFFIX);
    }


    /** Get the text of TextField.
     * @return message as {@link String}
     */
    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return textInputField().getText();
    }

    /** Get the text type of TextField. The type is the attribute 'type' of the input field inside the TextField.
     * @return message as {@link String}
     */
    @JDIAction("Get '{name}' text type")
    public String getTextType() {
        return textInputField().getAttribute("type");
    }

    /** Get the label of the TextField.
     * @return label as {@link Label}
     */
    @Override
    public Label label() {
        return textInputField().label();
    }

    /** Get the placeholder of the TextField.
     * @return placeholder as {@link String}
     */
    @Override
    @JDIAction("Get '{name}' placeholder")
    public String placeholder() {
        return textInputField().placeholder();
    }

    /** Clear and send keys the TextField.
     * @param value text to input
     */
    @Override
    @JDIAction("Set '{0}' in '{name}'")
    public void input(String value) {
        clear();
        textInputField().input(value);
    }

    /** Set text value for the TextField.
     * @param value text to input
     */
    @Override
    @JDIAction("Set '{0}' in '{name}'")
    public void setText(String value) {
        input(value);
    }

    /** Send keys into the TextField.
     * @param value text to send keys
     */
    @Override
    @JDIAction("Input '{0}' in '{name}'")
    public void sendKeys(CharSequence... value) {
        textInputField().sendKeys(value);
    }

    /** Focus on the TextField.
     */
    @Override
    @JDIAction("Focus on '{name}'")
    public void focus() {
        sendKeys("");
    }

    /** Clear the text of the TextField.
     */
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
