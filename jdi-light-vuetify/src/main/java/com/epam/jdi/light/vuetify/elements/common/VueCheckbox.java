package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.VueCheckboxAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasMessages;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;

/**
 * To see an example of Checkbox web element please visit https://vuetifyjs.com/en/components/checkboxes/
 */

public class VueCheckbox extends UIBaseElement<VueCheckboxAssert> implements HasLabel, HasTheme, HasColor, IsDense,
        HasMessages, IsReadOnly {

    private static final String INPUT = "input[role='checkbox']";
    private static final String SLOT = "div .v-input__slot";

    private UIElement input() {
        return find(INPUT);
    }
    private UIElement slot() {
        return find(SLOT);
    }

    public VueCheckbox() {
        super();
    }

    public VueCheckbox(UIElement base) {
        super();
        setCore(VueCheckbox.class, base);
    }
    @Override
    public VueCheckboxAssert is() {
        return new VueCheckboxAssert().set(this);
    }

    @Override
    public VueCheckboxAssert has() {
        return is();
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (isUnchecked()) {
            this.core().click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isChecked()) {
            this.core().click();
        }
    }

    @JDIAction("Get if '{name}' is checked")
    public boolean isChecked() {
        return input().attr("aria-checked").equalsIgnoreCase("true");
    }

    @JDIAction("Get if '{name}' is not checked")
    public boolean isUnchecked() {
        return !isChecked();
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return core().getAttribute("class").contains("disabled");
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
      return core().find("input[type=checkbox]").label();
    }

    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
    }

    @JDIAction("Get if '{name}' is indeterminate")
    public boolean isIndeterminate() {
        return this.core().hasClass("v-input--indeterminate");
    }

    @JDIAction("Get if '{name}' is success")
    public boolean isSuccess() {
        return hasClass("success--text");
    }

    @JDIAction("Get if '{name}' is error")
    public boolean isError() {
        return hasClass("error--text");
    }

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return slot().css("background-color");
    }

    @JDIAction("Get '{name}' label color")
    public String labelColor() {
        return label().css("color");
    }
}
