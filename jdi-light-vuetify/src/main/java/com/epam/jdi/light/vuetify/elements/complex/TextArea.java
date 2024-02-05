package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.vuetify.asserts.TextAreaAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasDetailsHidden;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsClearable;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsFilled;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import com.epam.jdi.light.vuetify.interfaces.IsFullWidth;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsSingleLine;
import com.epam.jdi.light.vuetify.interfaces.IsSolo;
import com.epam.jdi.light.vuetify.interfaces.IsVuetifyInput;

import java.util.List;

import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;
import static java.util.Arrays.asList;

/**
 * To see an example of TextArea web element please visit
 * https://v2.vuetifyjs.com/en/components/textareas/
 */
public class TextArea extends UIBaseElement<TextAreaAssert>
        implements HasLabel, HasPlaceholder, HasIcon, IsVuetifyInput, HasColor, HasMeasurement, HasMessages, HasRounded, HasTheme,
        IsClearable, IsDense, IsFilled, IsFlat, IsLoading, IsOutlined, IsReadOnly, IsShaped, IsSingleLine, IsSolo,
        IsFullWidth, HasDetailsHidden {
    private String textArea = ".v-input__slot textarea";
    private String details = ".v-text-field__details";
    private String counter = ".v-counter";

    private String prependOuterIcon = "div .v-input__prepend-outer .v-icon";
    private String prependInnerIcon = "div .v-input__prepend-inner .v-icon";
    private String appendOuterIcon = "div .v-input__append-outer .v-icon";
    private String appendInnerIcon = "div .v-input__append-inner .v-icon";
    private String loader = "div [role='progressbar']";

    private String hint = ".v-messages__message";

    @JDIAction("Get '{name}' slot")
    public UIElement slot() {
        return core().find(".v-input__slot");
    }

    @JDIAction("Get '{name}' textarea")
    public UIElement textArea() {
        return core().find(textArea);
    }

    @JDIAction("Get {name} loader")
    public ProgressLinear progress() {
        return new ProgressLinear().setCore(ProgressLinear.class, core().find(loader));
    }

    @JDIAction("Get {name} hint")
    public UIElement hint() {
        return core().find(hint);
    }

    @JDIAction("Get '{name}' details")
    private UIElement details() {
        return core().find(details);
    }

    @JDIAction("Get '{name}' prepend outer icon")
    public Icon prependOuterIcon() {
        return new Icon().setCore(Icon.class, core().find(prependOuterIcon));
    }

    @JDIAction("Get if '{name}' has prepend outer icon")
    public boolean hasPrependOuterIcon() {
        return prependOuterIcon().isExist();
    }

    @JDIAction("Get '{name}' prepend inner icon")
    public Icon prependInnerIcon() {
        return new Icon().setCore(Icon.class, core().find(prependInnerIcon));
    }

    @JDIAction("Get if '{name}' has prepend inner icon")
    public boolean hasPrependInnerIcon() {
        return prependInnerIcon().isExist();
    }

    @JDIAction("Get '{name}' append outer icon")
    public Icon appendOuterIcon() {
        return new Icon().setCore(Icon.class, core().find(appendOuterIcon));
    }

    @JDIAction("Get if '{name}' has append outer icon")
    public boolean hasAppendOuterIcon() {
        return appendOuterIcon().isExist();
    }

    @JDIAction("Get '{name}' append inner icon")
    public Icon appendInnerIcon() {
        return new Icon().setCore(Icon.class, core().find(appendInnerIcon));
    }

    @JDIAction("Get if '{name}' has append inner icon")
    public boolean hasAppendInnerIcon() {
        return appendInnerIcon().isExist();
    }

    @JDIAction("Get '{name}' counter")
    public UIElement counter() {
        return details().find(counter);
    }

    @JDIAction("Get '{name}' counter")
    public int counterValue() {
        return Integer.parseInt(details().find(counter).text());
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
        return new Label().setCore(Label.class, core().find("label"));
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

    @JDIAction("Get if '{name}' ia autofocus")
    public boolean isAutofocus() {
        String autofocusAttribute = textArea().getAttribute("autofocus");
        return "autofocus".equals(autofocusAttribute) || "true".equals(autofocusAttribute);
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
        textArea().focus();
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

    @JDIAction("Get if '{name}' is autogrow")
    public boolean isAutogrow() {
        return element().hasClass("v-textarea--auto-grow");
    }

    @JDIAction("Get if '{name}' is not resizable")
    public boolean isNotResizable() {
        return element().hasClass("v-textarea--no-resize");
    }

    @JDIAction("Get if '{name}' has suffix")
    public boolean hasSuffix() {
        return suffix().isExist();
    }

    @JDIAction("Get if '{name}' has prefix")
    public boolean hasPrefix() {
        return prefix().isExist();
    }

    @JDIAction("Get if '{name}' has placeholder")
    public boolean hasPlaceholder() {
        return core().hasClass("v-text-field--placeholder");
    }

    @JDIAction("Get if '{name}' is reversed")
    public boolean isReversed() {
        return core().hasClass("v-text-field--reverse");
    }

    @Override
    @JDIAction("Get if '{name}' is rounded")
    public boolean isRounded() {
        return core().hasClass("v-text-field--rounded");
    }

    @JDIAction("Get '{name}' loader height")
    public int getLoaderHeight() {
        return Integer.parseInt(core().find(loader).css("height").replace("px", ""));
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !core().hasClass("v-input--is-disabled");
    }

    @Override
    public TextAreaAssert is() {
        return new TextAreaAssert().set(this);
    }
}
