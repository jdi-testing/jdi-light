package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.vuetify.asserts.TextAreaAssert;
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
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsSingleLine;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;
import static java.util.Arrays.asList;

/**
 * To see an example of TextArea web element please visit
 * https://vuetifyjs.com/en/components/textareas/
 */
public class TextArea extends UIBaseElement<TextAreaAssert>
        implements HasLabel, HasPlaceholder, HasIcon, IsInput, HasColor, HasMeasurement, HasMessages, HasRounded, HasTheme,
        IsClearable, IsDense, IsFilled, IsFlat, IsLoading, IsOutlined, IsReadOnly, IsShaped, IsSingleLine {

    private String slot = ".v-input__slot";
    private String textArea = ".v-input__slot textarea";
    private String details = ".v-text-field__details";
    private String message = ".v-messages__message";
    private String counter = ".v-counter";

    private String prependOuterIcon = "div .v-input__prepend-outer .v-icon";
    private String prependInnerIcon = "div .v-input__prepend-inner .v-icon";
    private String appendOuterIcon = "div .v-input__append-outer .v-icon";
    private String appendInnerIcon = "div .v-input__append-inner .v-icon";

    private String loader = "div [role='progressbar']";

    @JDIAction("Get '{name}' slot")
    public UIElement slot() {
        return find(slot);
    }

    @JDIAction("Get '{name}' textarea")
    public UIElement textArea() {
        return find(textArea);
    }

    @JDIAction("Get '{name}' details")
    public UIElement details() {
        return find(details);
    }

    @JDIAction("Check that '{name}' has prepend outer icon")
    public boolean hasPrependOuterIcon() {
        return finds(prependOuterIcon).size() > 0;
    }

    @JDIAction("Check that '{name}' has prepend inner icon")
    public boolean hasPrependInnerIcon() {
        return finds(prependInnerIcon).size() > 0;
    }

    @JDIAction("Check that '{name}' has append outer icon")
    public boolean hasAppendOuterIcon() {
        return finds(appendOuterIcon).size() > 0;
    }

    @JDIAction("Check that '{name}' has append inner icon")
    public boolean hasAppendInnerIcon() {
        return finds(appendInnerIcon).size() > 0;
    }

    @JDIAction("Get '{name}' message")
    public UIElement message() {
        return details().find(message);
    }

    @JDIAction("Get '{name}' counter")
    public UIElement counter() {
        return details().find(counter);
    }

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return textArea().getText();
    }

    @JDIAction("Get '{name}' lines")
    public List<String> getLines() {
        return asList(getText().split("\\n"));
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return textArea().label();
    }

    @Override
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
    }

    @Override
    @JDIAction("Get '{name}' placeholder text")
    public String placeholder() {
        return textArea().getAttribute("placeholder");
    }

    @JDIAction("Get '{name}' placeholder text")
    public boolean isAutofocus() {
        String autofocusAttribute = textArea().getAttribute("autofocus");
        return autofocusAttribute.equals("autofocus") || autofocusAttribute.equals("true");
    }

    @Override
    @JDIAction("Set '{name}' text '{0}'")
    public void input(String value) {
        clear();
        textArea().input(value);
    }

    @JDIAction("Get '{name}' suffix")
    public UIElement suffix() {
        return slot().find(".v-text-field__suffix");
    }

    @JDIAction("Get '{name}' prefix")
    public UIElement prefix() {
        return slot().find(".v-text-field__prefix");
    }

    @JDIAction("Set '{name}' lines '{0}'")
    public void setLines(String... lines) {
        sendKeys(String.join("\n", lines));
    }

    public void setLines(List<String> lines) {
        setLines(lines.toArray(new String[0]));
    }

    @Override
    @JDIAction("Set '{name}' text '{0}'")
    public void setText(String value) {
        input(value);
    }

    @Override
    @JDIAction("Add '{name}' text '{0}'")
    public void sendKeys(CharSequence... value) {
        textArea().sendKeys(value);
    }

    @Override
    @JDIAction("Focus on '{name}'")
    public void focus() {
        sendKeys("");
    }

    @JDIAction("Add '{name}' new line '{0}'")
    public void addNewLine(String line) {
        String newLine = line;
        if (isNotEmpty()) {
            newLine = "\n" + line;
        }
        sendKeys(newLine);
    }

    @Override
    @JDIAction("Clear '{name}' textarea")
    public void clear() {
        if (getOs().equals(OsTypes.MAC)) {
            textArea().sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        } else {
            textArea().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        }
    }

    @Override
    @JDIAction("Get '{name}' color")
    public String color() {
        return slot().css("color");
    }

    @Override
    @JDIAction("Get '{name}' background-color")
    public String backgroundColor() {
        return slot().css("background-color");
    }

    @JDIAction("Get '{name}' height")
    public int height() {
        return textArea().getSize().height;
    }

    @JDIAction("Get '{name}' rows attr")
    public int rows() {
        return getInt("rows", textArea());
    }

    @JDIAction("Check that '{name}' is autogrow")
    public boolean isAutogrow() {
        return element().hasClass("v-textarea--auto-grow");
    }

    @JDIAction("Check that '{name}' is not resizable")
    public boolean isNotResizable() {
        return element().hasClass("v-textarea--no-resize");
    }

    @JDIAction("Check that '{name}' has suffix")
    public boolean hasSuffix() {
        return slot().finds(".v-text-field__suffix").size() > 0;
    }

    @JDIAction("Get '{name}' suffix text")
    public String getSuffixText() {
        return suffix().getText();
    }

    @JDIAction("Check that '{name}' has prefix")
    public boolean hasPrefix() {
        return slot().finds(".v-text-field__prefix").size() > 0;
    }

    @JDIAction("Get '{name}' prefix text")
    public String getPrefixText() {
        return prefix().getText();
    }

    @JDIAction("Check that '{name}' has placeholder")
    public boolean hasPlaceholder() {
        return hasClass("v-text-field--placeholder");
    }

    @JDIAction("Check that '{name}' is reversed")
    public boolean isReversed() {
        return hasClass("v-text-field--reverse");
    }

    @Override
    @JDIAction("Check that '{name}' is rounded")
    public boolean isRounded() {
        return hasClass("v-text-field--rounded");
    }

    @JDIAction("Check that '{name}' is solo")
    public boolean isSolo() {
        return hasClass("v-text-field--solo");
    }

    @JDIAction("Check that '{name}' is solo inverted")
    public boolean isSoloInverted() {
        return hasClass("v-text-field--solo-inverted");
    }

    @JDIAction("Check that '{name}' is full-width")
    public boolean isFullWidth() {
        return hasClass("v-text-field--full-width");
    }

    @JDIAction("Check that '{name}' has details hidden")
    public boolean hasDetailsHidden() {
        return hasClass("v-input--hide-details");
    }

    @JDIAction("Get '{name}' loader height")
    public int getLoaderHeight() {
        return Integer.parseInt(find(loader).css("height").replace("px", ""));
    }

    @JDIAction("Check that '{name}' is disabled")
    public boolean isDisabled() {
        return hasClass("v-input--is-disabled");
    }

    @Override
    public TextAreaAssert is() {
        return new TextAreaAssert().set(this);
    }
}
