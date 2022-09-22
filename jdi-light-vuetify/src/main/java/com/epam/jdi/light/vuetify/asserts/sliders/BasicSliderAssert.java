package com.epam.jdi.light.vuetify.asserts.sliders;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.sliders.BasicSlider;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BasicSliderAssert<T extends BasicSlider<?, ?>, A extends BasicSliderAssert<?, ?>> extends UIAssert<A, T> {

    @JDIAction("Assert that {name} is append icon")
    public A appendIcon() {
        jdiAssert(element().isAppendIcon() ? "is append icon" : "is not append icon",
                Matchers.is("is append icon"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected color")
    public A color(String expectedColor) {
        jdiAssert(element().css("color"), Matchers.is(expectedColor));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected background color")
    public A backgroundColor(String expectedColor) {
        jdiAssert(element().css("background-color"), Matchers.is(expectedColor));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected theme")
    public A theme(String expectedTheme) {
        jdiAssert(element().theme(), Matchers.containsString(expectedTheme));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is dense")
    public A dense() {
        jdiAssert(element().isDense() ? "is dense" : "is not dense",
                Matchers.is("is dense"));
        return (A) this;
    }

    @JDIAction("Assert that {name} is disabled")
    public A disabled() {
        jdiAssert(element().isDisabled() ? "is disabled element" : "is not disabled element",
                Matchers.is("is disabled element"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has error message")
    public A error() {
        jdiAssert(element().hasError() ? "has error" : "does not has error",
                Matchers.is("has error"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected error message")
    public A errorMessage(String errorMessage) {
        jdiAssert(element().errorMessage(), Matchers.is(errorMessage));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected height")
    public A height(String height) {
        jdiAssert(element().height(), Matchers.is(height));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' hide details")
    public A hideDetails() {
        jdiAssert(element().isHideDetails() ? "is hide details" : "is not hide details",
                Matchers.is("is hide details"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' hide spin button")
    public A hideSpinButton() {
        jdiAssert(element().isHideSpinButton() ? "is hide spin button" : "is not hide spin button",
                Matchers.is("is hide spin button"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has inverse label")
    public A inverseLabel() {
        jdiAssert(element().hasInverseLabel() ? "has inverse label" : "does not has inverse label",
                Matchers.is("has inverse label"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected label")
    public A label(String label) {
        jdiAssert(element().labelText(), Matchers.equalToIgnoringCase(label));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected max value")
    public A max(String expectedMaxValue) {
        jdiAssert(element().max(), Matchers.is(expectedMaxValue));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected min value")
    public A min(String expectedMinValue) {
        jdiAssert(element().min(), Matchers.is(expectedMinValue));
        return (A) this;
    }

    @JDIAction("Assert that {name} is prepend icon")
    public A prependIcon() {
        jdiAssert(element().isPrependIcon() ? "is prepend icon" : "is not prepend icon",
                Matchers.is("is prepend icon"));
        return (A) this;
    }

    @JDIAction("Assert that {name} is readonly")
    public A readonly() {
        jdiAssert(element().isReadonly() ? "is read-only element" : "is not read-only element",
                Matchers.is("is read-only element"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected step")
    public A step(String expectedStep) {
        jdiAssert(element().step(), Matchers.is(expectedStep));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is success")
    public A success() {
        jdiAssert(element().isSuccess() ? "is success" : "is not success",
                Matchers.is("is success"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected success messages")
    public A successMessages(String successMessages) {
        jdiAssert(element().successMessages(), Matchers.is(successMessages));
        return (A) this;
    }

    @JDIAction("Assert that {name} is validate on blur")
    public A validateOnBlur() {
        jdiAssert(element().isValidateOnBlur() ? "is validate on blur" : "is not validate on blur",
                Matchers.is("is validate on blur"));
        return (A) this;
    }

    @JDIAction("Assert that {name} is vertical")
    public A vertical() {
        jdiAssert(element().isVertical() ? "is vertical element" : "is not vertical element",
                Matchers.is("is vertical element"));
        return (A) this;
    }

}
