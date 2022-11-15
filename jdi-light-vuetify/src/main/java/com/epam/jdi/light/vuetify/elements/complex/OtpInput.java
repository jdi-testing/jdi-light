package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.OtpInputAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;

import java.util.List;

public class OtpInput extends UIBaseElement<OtpInputAssert> implements HasTheme, IsReadOnly {

    @JDIAction("Get '{name}' inputs")
    public List<UIElement> inputs() {
        return core().finds(".v-input");
    }

    @JDIAction("Get '{name}' length")
    public int length() {
        return inputs().size();
    }

    @JDIAction("Check that '{name}' is plain")
    public boolean isPlain() {
        return inputs().stream()
                .allMatch(input -> input.hasClass("v-otp-input--plain"));
    }

    @JDIAction("Get '{name}' type")
    public String type() {
        return inputs().stream()
                .map(input -> input.find("input").attr("type"))
                .findFirst()
                .orElse("");
    }

    @JDIAction("Type values '{0}' to '{name}'")
    public void typeValues(List<String> inputValues) {
        for (int i = 1; i < inputValues.size() + 1; i++) {
            inputs().get(i).find("input").sendKeys(inputValues.get(i - 1));
        }
    }

    @Override
    @JDIAction("Check that '{name}' is readonly")
    public boolean isReadOnly() {
        return inputs().stream()
                .allMatch(input -> input.hasClass("v-input--is-readonly"));
    }

    @Override
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return inputs().stream()
                .anyMatch(input -> !input.hasClass("v-input--is-disabled"));
    }

    @Override
    public OtpInputAssert is() {
        return new OtpInputAssert().set(this);
    }
}
