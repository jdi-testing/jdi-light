package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.SwitchAssert;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see example of Switches web element please visit https://vuetifyjs.com/en/components/switches/
 */

public class Switch extends UIBaseElement<SwitchAssert> implements HasClick, HasLabel {

    private UIElement input() {
        return core().find("input");
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        Label label = new Label().setCore(Label.class, find("label"));
        if (label != null) {
            return label;
        }
        throw runtimeException("Can't find label for element %s", this);
    }

    @JDIAction("Get {name}'s label text")
    public String getLabelText() {
        return label().getText();
    }

    @JDIAction("Check if '{name}' is selected")
    public boolean isChecked() {
        return input().attr("aria-checked").equalsIgnoreCase("true");
    }

    @JDIAction("Check if '{name}' is not selected")
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
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return !hasClass("v-input--is-disabled");
    }

    @JDIAction("Get {name}'s color")
    public String hasColor() {
        return css("color");
    }

    @JDIAction("Get {name}'s background color")
    public String hasBackgroundColor() {
        return css("background-color");
    }

    @JDIAction("Get {name}'s slot background color")
    public String hasSlotsBackgroundColor() {
        return core().find(".v-input__slot").css("background-color");
    }

    @JDIAction("Check that {name} has light theme")
    public Boolean hasLightTheme() {
        return hasClass("theme--light");
    }

    @JDIAction("Check that {name} is dense")
    public Boolean isDense() {
        return hasClass("v-input--dense");
    }

    @JDIAction("Check that {name} has messages")
    public Boolean hasMessages() {
        return core().finds(".v-messages__message").size() > 0;
    }

    @JDIAction("Check that {name} has error message")
    public Boolean hasErrorMessage() {
        return hasClass("error--text");
    }

    @JDIAction("Check that {name} has success message")
    public Boolean hasSuccessMessage() {
        return hasClass("success--text");
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

    @JDIAction("Check that {name} is flat")
    public Boolean isFlat() {
        return hasClass("v-input--switch--flat");
    }

    @JDIAction("Check that {name} is inset")
    public Boolean isInset() {
        return hasClass("v-input--switch--inset");
    }

    @JDIAction("Check that {name} has icon-append")
    public Boolean hasIconAppend() {
        return core().finds(".v-input__icon--append").size() > 0;
    }

    @JDIAction("Check that {name} has icon-prepend")
    public Boolean hasIconPrepend() {
        return core().finds(".v-input__icon--prepend").size() > 0;
    }

    @JDIAction("Check that {name} has details hidden")
    public Boolean hasDetailsHidden() {
        return hasClass("v-input--hide-details");
    }

    @JDIAction("Check that {name} is readonly")
    public Boolean isReadonly() {
        return hasClass("v-input--is-readonly");
    }

    @JDIAction("Check that {name} has ripple")
    public Boolean hasRipple() {
        return core().finds(".v-input--selection-controls__ripple").size() > 0;
    }

    @JDIAction("Get {name}'s value")
    public String getValue() {
        return core().find(".v-input__control [role='switch']").getAttribute("value");
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
