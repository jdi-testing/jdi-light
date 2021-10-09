package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.RadioButtonAssert;

/**
 * To see example of Radio buttons web element please visit https://vuetifyjs.com/en/components/radio-buttons/
 */

public class RadioButton extends UIBaseElement<RadioButtonAssert> implements HasLabel {

    @JDIAction("Is '{name}' selected")
    public boolean isChecked() {
        return core().find("div input").attr("aria-checked").equalsIgnoreCase("true");
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

    @Override
    public String labelText() {
        UIElement label = core().find("label");
        WebList list = label.finds("div");
        if (list.size() != 0) {
            return list.first().getText();
        }
        return label.getText();
    }

    @JDIAction("Get '{name}' input color")
    public String inputColor() {
        return core().find("div .v-input--selection-controls__ripple").getCssValue("color");
    }

    @JDIAction("Get '{name}' group direction")
    public String groupDirection() {
        return core().find("..").getCssValue("flex-direction");
    }

    @Override
    public RadioButtonAssert is() {
        return new RadioButtonAssert().set(this);
    }
}
