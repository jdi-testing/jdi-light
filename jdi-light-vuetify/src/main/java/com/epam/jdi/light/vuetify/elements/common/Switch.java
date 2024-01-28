package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.SwitchAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasDetailsHidden;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see example of Switches web element please visit https://v2.vuetifyjs.com/en/components/switches/
 */

public class Switch extends UIBaseElement<SwitchAssert> implements HasClick, HasLabel, IsDense, HasTheme,
        HasDetailsHidden, HasColor {

    private UIElement input() {
        return core().find("input");
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        Label label = new Label().setCore(Label.class, core().find("label"));
        if (label != null) {
            return label;
        }
        throw runtimeException("Can't find label for element %s", this);
    }

    @JDIAction("Get if '{name}' is selected")
    public boolean isChecked() {
        return input().attr("aria-checked").equalsIgnoreCase("true");
    }

    @JDIAction("Get if '{name}' is not selected")
    public boolean isNotChecked() {
        return !isChecked();
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (isNotChecked()) {
            this.click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isChecked()) {
            this.click();
        }
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !core().hasClass("v-input--is-disabled");
    }

    @JDIAction("Get {name}'s slot background color")
    public String slotsBackgroundColor() {
        return core().find(".v-input__slot").css("background-color");
    }

    @JDIAction("Get if {name} has messages")
    public boolean hasMessages() {
        return core().finds(".v-messages__message").size() > 0;
    }

    @JDIAction("Get if {name} has error message")
    public boolean hasErrorMessage() {
        return core().hasClass("error--text");
    }

    @JDIAction("Get if {name} has success message")
    public boolean hasSuccessMessage() {
        return core().hasClass("success--text");
    }

    @JDIAction("Get {name}'s messages")
    public List<String> getMessages() {
        return core().finds(".v-messages__message")
                .stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @JDIAction("Get {name}'s error messages")
    public List<String> getErrorMessages() {
        return core().finds(".error--text .v-messages__message")
                .stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @JDIAction("Get the number of {name}'s error messages")
    public Integer getNumberErrorMessages() {
        return getErrorMessages().size();
    }

    @JDIAction("Get {name}'s success messages")
    public List<String> getSuccessMessages() {
        return core().finds(".success--text .v-messages__message")
                .stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @JDIAction("Get if {name} is flat")
    public boolean isFlat() {
        return core().hasClass("v-input--switch--flat");
    }

    @JDIAction("Get if {name} is inset")
    public boolean isInset() {
        return core().hasClass("v-input--switch--inset");
    }

    @JDIAction("Get if {name} has icon-append")
    public boolean hasIconAppend() {
        return core().finds(".v-input__icon--append").size() > 0;
    }

    @JDIAction("Get if {name} has icon-prepend")
    public boolean hasIconPrepend() {
        return core().finds(".v-input__icon--prepend").size() > 0;
    }

    @JDIAction("Get if {name} is readonly")
    public boolean isReadonly() {
        return core().hasClass("v-input--is-readonly");
    }

    @JDIAction("Get if {name} has ripple")
    public boolean hasRipple() {
        return core().finds(".v-input--selection-controls__ripple").size() > 0;
    }

    @JDIAction("Get {name}'s value")
    public String value() {
        return core().find(".v-input__control [role='switch']").getAttribute("value");
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
