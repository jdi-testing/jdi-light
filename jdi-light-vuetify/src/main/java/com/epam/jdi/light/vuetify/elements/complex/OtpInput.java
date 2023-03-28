package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.OtpInputAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsReadOnly;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OtpInput extends UIBaseElement<OtpInputAssert> implements HasTheme, IsReadOnly, IsText, IsInput {

    @JDIAction("Get '{name}' inputs")
    public List<TextField> inputs() {
        return core().finds(".v-input").stream().map(el -> el.with(TextField.class)).collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' length")
    public int length() {
        return inputs().size();
    }

    @JDIAction("Get if '{name}' is plain")
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
        for (int i = 0; i < inputValues.size(); i++) {
            inputs().get(i).sendKeys(inputValues.get(i));
        }
    }

    @Override
    @JDIAction("Type values '{0}' to '{name}'")
    public void sendKeys(CharSequence... value) {
        this.typeValues(Arrays.stream(value).map(CharSequence::toString).collect(Collectors.toList()));
    }

    @JDIAction("Get value of '{name}'")
    public String getText() {
        return inputs().stream().map(TextField::getText).collect(Collectors.joining());
    }

    @Override
    @JDIAction("Clear all cells in '{name}'")
    public void clear() {
        inputs().stream().forEach(TextField::clear);
    }
    @Override
    @JDIAction("Focus on the first letter of '{name}'")
    public void focus() {
        inputs().get(0).focus();
    }

    @Override
    @JDIAction("Get if '{name}' is readonly")
    public boolean isReadOnly() {
        return inputs().stream()
                .allMatch(input -> input.hasClass("v-input--is-readonly"));
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return inputs().stream()
                .anyMatch(input -> !input.hasClass("v-input--is-disabled"));
    }

    @Override
    public OtpInputAssert is() {
        return new OtpInputAssert().set(this);
    }
}
