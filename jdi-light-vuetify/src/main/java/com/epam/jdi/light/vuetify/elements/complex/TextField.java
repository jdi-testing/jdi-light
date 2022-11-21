package com.epam.jdi.light.vuetify.elements.complex;

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
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsClearable;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsFilled;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import com.epam.jdi.light.vuetify.interfaces.IsReverse;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsSingleLine;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

/**
 * To see an example of Text Field web element please visit
 * https://vuetifyjs.com/en/components/text-fields
 **/
public class TextField extends UIBaseElement<TextFieldAssert>
        implements HasLabel, HasPlaceholder, IsInput, HasClick, HasColor, HasIcon, HasMeasurement, HasMessages,
        HasRounded, HasTheme, IsClearable, IsDense, IsFilled, IsFlat, IsLoading, IsOutlined, IsReadOnly, IsReverse,
        IsShaped, IsSingleLine {
    private static final String DISABLED_CLASS = "v-input--is-disabled";
    private static final String READ_ONLY_CLASS = "v-input--is-readonly";
    private static final String FOCUSED_CLASS = "v-input--is-focused";
    private static final String FILLED_CLASS = "v-text-field--filled";
    private static final String OUTLINED_CLASS = "v-text-field--outlined";
    private static final String SHAPED_CLASS = "v-text-field--shaped";
    private static final String SOLO_CLASS = "v-text-field--solo";
    private static final String SOLO_INVERTED_CLASS = "v-text-field--solo-inverted";
    private static final String FULL_WIDTH_CLASS = "v-text-field--full-width";

    private String inputLocator = "div input";
    private String slotLocator = ".v-input__slot";
    private String counterLocator = ".v-counter";
    private String prependOuterLocator = ".v-input__prepend-outer";
    private String prependInnerLocator = ".v-input__prepend-inner";
    private String appendOuterLocator = ".v-input__append-outer";
    private String appendInnerLocator = ".v-input__append-inner";
    private String prefixLocator = ".v-text-field__prefix";
    private String suffixLocator = ".v-text-field__suffix";
    private String detailsLocator = ".v-text-field__details";
    private String messageLocator = ".v-messages__message";
    private String loaderLocator = "div [role='progressbar']";

    @Override
    @JDIAction("Get that '{name}' is enabled")
    public boolean isEnabled() {
        return !core().hasClass(DISABLED_CLASS);
    }

    @JDIAction("Get that '{name}' is focused")
    public boolean isFocused() {
        return core().hasClass(FOCUSED_CLASS);
    }

    @JDIAction("Get if '{name}' is solo")
    public boolean isSolo() {
        return core().hasClass(SOLO_CLASS);
    }

    @JDIAction("Get if '{name}' is solo")
    public boolean isSoloInverted() {
        return core().hasClass(SOLO_INVERTED_CLASS);
    }

    @JDIAction("Get if '{name}' is full width")
    public boolean isFullWidth() {
        return core().hasClass(FULL_WIDTH_CLASS);
    }

    @JDIAction("Get '{name}' text input field")
    public UIElement textInputField() {
        return find(inputLocator);
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

    /** Get the message element of the TextField.
     *
     * @return message as {@link UIElement}
     */
    @Override
    @JDIAction("Get '{name}' message")
    public List<UIElement> messages() {
        return details().finds(messageLocator);
    }

    @Override
    @JDIAction("Get '{name}' messages text by locator '{0}'")
    public List<String> messagesText(String locator) {
        return details().finds(locator)
                .stream().map(UIElement::getText).collect(Collectors.toList());
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

    @JDIAction("Get '{name}' icon by locator '{0}'")
    protected List<Icon> getIconsByLocator(String locator) {
        return finds(locator)
                .stream()
                .map(icon -> icon.find(".v-icon"))
                .map(icon -> new Icon().setCore(Icon.class, icon))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' prepend outer icons")
    public List<Icon> prependOuterIcons() {
        return getIconsByLocator(prependOuterLocator);
    }

    @JDIAction("Get '{name}' prepend inner icons")
    public List<Icon> prependInnerIcons() {
        return getIconsByLocator(prependInnerLocator);
    }

    @JDIAction("Get '{name}' append inner icons")
    public List<Icon> appendInnerIcons() {
        return getIconsByLocator(appendInnerLocator);
    }

    @JDIAction("Get '{name}' append outer icons")
    public List<Icon> appendOuterIcons() {
        return getIconsByLocator(appendOuterLocator);
    }

    @JDIAction("Check that '{name}' has prepend outer icon")
    public boolean hasPrependOuterIcon() {
        return !prependOuterIcons().isEmpty();
    }

    @JDIAction("Check that '{name}' has prepend inner icons")
    public boolean hasPrependInnerIcon() {
        return !prependInnerIcons().isEmpty();
    }

    @JDIAction("Check that '{name}' has append inner icons")
    public boolean hasAppendInnerIcon() {
        return !appendInnerIcons().isEmpty();
    }

    @JDIAction("Check that '{name}' has append outer icons")
    public boolean hasAppendOuterIcon() {
        return !appendOuterIcons().isEmpty();
    }

    @JDIAction("Get '{name}' prepend outer icons")
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

    @JDIAction("Check that '{name}' has placeholder")
    public boolean hasPlaceholder() {
        return hasClass("v-text-field--placeholder");
    }

    @Override
    @JDIAction("Check that '{name}' is rounded")
    public boolean isRounded() {
        return hasClass("v-text-field--rounded");
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
        if (isClearable())
            find(clearButtonLocator()).click();
        else {
            if (getOs().equals(OsTypes.MAC)) {
                textInputField().sendKeys(Keys.chord(Keys.COMMAND, "a") + Keys.BACK_SPACE);
            } else {
                textInputField().sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
            }
        }
    }

    @JDIAction("Check that '{name}' is autofocus")
    public boolean isAutofocus() {
        return textInputField().hasAttribute("autofocus")
                && textInputField().getAttribute("autofocus").equals("true")
                || textInputField().getAttribute("autofocus").equals("autofocus");
    }

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return slot().css("background-color");
    }

    @JDIAction("Check that '{name}' details is hidden")
    public boolean hasDetailsHidden() {
        return hasClass("v-input--hide-details");
    }

    @JDIAction("Get '{name}' loader height")
    public int getLoaderHeight() {
        return Integer.parseInt(find(loaderLocator).css("height").replace("px", ""));
    }

    @Override
    public TextFieldAssert is() {
        return new TextFieldAssert().set(this);
    }
}
