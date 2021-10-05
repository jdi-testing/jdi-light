package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.SwitchAssert;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * To see example of Switches web element please visit https://vuetifyjs.com/en/components/switches/
 */

public class Switch extends UIBaseElement<SwitchAssert> {

    private UIElement input() {
        return $("input", this);
    }

    private UIElement label() {
        return $("label", this);
    }

    @JDIAction("Is '{name}' selected")
    public boolean isChecked() {
        return input().attr("aria-checked").equalsIgnoreCase("true");
    }

    @JDIAction("Is '{name}' not selected")
    public boolean isNotChecked() {
        return !isChecked();
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (isNotChecked()) {
            this.core().click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isChecked()) {
            this.core().click();
        }
    }

    @JDIAction("Is '{name}' disabled")
    @Override
    public boolean isDisabled() {
        return this.core().hasClass("v-input--is-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Get '{name}' input color")
    public String getInputColor() {
        return core().find(".v-input--selection-controls__ripple").getCssValue("color");
    }

    private boolean hasLabel() {
        return label().isDisplayed();
    }

    @JDIAction("Get {name} label text")
    public String getLabelText() {
        if (!hasLabel()) {
            throw exception("Label doesn't exist", this);
        }
        return label().getText();
    }

    @JDIAction("Get {name} label HTML element")
    public UIElement getLabelHTML() {
        if (!hasLabel()) {
            throw exception("Label doesn't exist", this);
        }
        return label().find("div");
    }

    @JDIAction()
    public boolean hasInputProgressBar() {
        return core().find(".v-input--switch__thumb div[role = 'progressbar']").isDisplayed();
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
