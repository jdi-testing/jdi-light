package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.SwitchAssert;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * To see example of Switches web element please visit https://vuetifyjs.com/en/components/switches/
 */

public class Switch extends UIBaseElement<SwitchAssert> implements HasClick, HasLabel {

    private UIElement input() {
        return $("input", this);
    }

    @Override
    public Label label() {
        Label label = new Label().setCore(Label.class, find("label"));
        if (label != null) {
            return label;
        }
        throw runtimeException("Can't find label for element %s", this);
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
            this.click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isChecked()) {
            this.click();
        }
    }

    @JDIAction("Is '{name}' enabled")
    @Override
    public boolean isEnabled() {
        return !hasClass("v-input--is-disabled");
    }

    @Override
    public SwitchAssert is() {
        return new SwitchAssert().set(this);
    }
}
