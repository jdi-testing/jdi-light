package com.epam.jdi.light.vuetify.elements.complex;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
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
        implements HasLabel, HasPlaceholder, IsInput, HasClick {

    private static final String DISABLED_CLASS = "v-input--is-disabled";
    private static final String READ_ONLY_CLASS = "v-input--is-readonly";
    private static final String FOCUSED_CLASS = "v-input--is-focused";
    private static final String FILLED_CLASS = "v-text-field--filled";
    private static final String OUTLINED_CLASS = "v-text-field--outlined";
    private static final String SHAPED_CLASS = "v-text-field--shaped";
    private static final String SOLO_CLASS = "v-text-field--solo";
    private static final String FULL_WIDTH_CLASS = "v-text-field--full-width";
    private static final String ERROR_CLASS = "error--text";

    private String inputLocator = ".//input|.//textarea";
    private String slotLocator = ".v-input__slot";
    private String hintLocator = ".v-messages__message";
    private String counterLocator = ".v-counter";
    private String prependOuterLocator = ".v-input__prepend-outer";
    private String prependInnerLocator = ".v-input__prepend-inner";
    private String appendOuterLocator = ".v-input__append-outer";
    private String appendInnerLocator = ".v-input__append-inner";
    private String prefixLocator = ".v-text-field__prefix";
    private String suffixLocator = ".v-text-field__suffix";

    private String detailsLocator = ".v-text-field__details";
    private String errorLocator = ".error--text";

    @Override
    @JDIAction("Get that '{name}' is enabled")
    public boolean isEnabled() {
        return !core().hasClass(DISABLED_CLASS);
    }

    @JDIAction("Get that '{name}' is readonly")
    public boolean isReadonly() {
        return core().hasClass(READ_ONLY_CLASS);
    }

    @JDIAction("Get that '{name}' is focused")
    public boolean isFocused() {
        return core().hasClass(FOCUSED_CLASS);
    }

    @JDIAction("Get if '{name}' is filled")
    public boolean isFilled() {
        return core().hasClass(FILLED_CLASS);
    }

    @JDIAction("Get if '{name}' is outlined")
    public boolean isOutlined() {
        return core().hasClass(OUTLINED_CLASS);
    }

    @JDIAction("Get if '{name}' is shaped")
    public boolean isShaped() {
        return core().hasClass(SHAPED_CLASS);
    }

    @JDIAction("Get if '{name}' is solo")
    public boolean isSolo() {
        return core().hasClass(SOLO_CLASS);
    }

    @JDIAction("Get if '{name}' is full width")
    public boolean isFullWidth() {
        return core().hasClass(FULL_WIDTH_CLASS);
    }

    @JDIAction("Get '{name}' text input field")
    public UIElement textInputField() {
        return find(inputLocator);
    }

    @JDIAction("Get if '{name}' has error in input data")
    public boolean isErrorInput() {
        return core().hasClass(ERROR_CLASS);
    }

    @JDIAction("Get '{name}' error for input field")
    public UIElement errorMessage() {
        return details().find(errorLocator);
    }

    @JDIAction("Get '{name}' error text for input field")
    public String errorText() {
        return errorMessage().text();
    }
    @JDIAction("Get '{name}' details")
    public UIElement details() {
        return find(detailsLocator);
    }

    /** Get the slot of the TextField.
     *
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' slot")
    public UIElement slot() {
        return find(slotLocator);
    }

    /** Get the hint element of the TextField.
     *
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' message")
    public UIElement hint() {
        return details().find(hintLocator);
    }

    /** Get the counter of the TextField.
     *
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' counter")
    public UIElement counter() {
        return details().find(counterLocator);
    }

    /** Get the prefix of the TextField.
     *
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' prefix")
    public UIElement prefix() {
        return find(prefixLocator);
    }

    /** Get the suffix of the TextField.
     *
     * @return message as {@link UIElement}
     */
    @JDIAction("Get '{name}' suffix")
    public UIElement suffix() {
        return find(suffixLocator);
    }

    protected List<Icon> getIconByLocator(String locator) {
        return finds(locator)
                .stream()
                .map(icon -> icon.find(".v-icon"))
                .map(icon -> new Icon().setCore(Icon.class, icon))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' prepend outer icons")
    public List<Icon> prependOuterIcons() {
        return getIconByLocator(prependOuterLocator);
    }

    @JDIAction("Get '{name}' prepend inner icons")
    public List<Icon> prependInnerIcons() {
        return getIconByLocator(prependInnerLocator);
    }

    @JDIAction("Get '{name}' append inner icons")
    public List<Icon> appendInnerIcons() {
        return getIconByLocator(appendInnerLocator);
    }

    @JDIAction("Get '{name}' append outer icons")
    public List<Icon> appendOuterIcons() {
        return getIconByLocator(appendOuterLocator);
    }

    @JDIAction("Get '{name}' prepend outer icon")
    public Icon getPrependOuterIcon() {
        return prependOuterIcons().get(0);
    }

    @JDIAction("Get '{name}' prepend inner icons")
    public Icon getPrependInnerIcon() {
        return prependInnerIcons().get(0);
    }

    @JDIAction("Get '{name}' append inner icons")
    public Icon getAppendInnerIcon() {
        return appendInnerIcons().get(0);
    }

    @JDIAction("Get '{name}' append outer icons")
    public Icon getAppendOuterIcon() {
        return appendOuterIcons().get(0);
    }

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return textInputField().getText();
    }

    /** Get the text type of TextField. The type is the attribute 'type' of the input field inside the TextField.
     *
     * @return message as {@link String}
     */
    @JDIAction("Get '{name}' text type")
    public String getTextType() {
        return textInputField().getAttribute("type");
    }

    @Override
    public Label label() {
        return textInputField().label();
    }

    @Override
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
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

    // TODO: Check if sendKeys is really required for focus
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
