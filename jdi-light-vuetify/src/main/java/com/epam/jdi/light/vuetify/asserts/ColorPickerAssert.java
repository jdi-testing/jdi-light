package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ColorPicker;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.Color;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ColorPickerAssert extends UIAssert<ColorPickerAssert, ColorPicker> {

    @JDIAction("Assert that '{name}' canvas has style")
    public ColorPickerAssert canvasStyle() {
        jdiAssert(element().getCanvasStyle(), Matchers.is(Matchers.notNullValue()));
        return this;
    }

    @JDIAction("Assert that '{name}' canvasDot has style")
    public ColorPickerAssert canvasDotStyle() {
        jdiAssert(element().getCanvasDotStyle(), Matchers.is(Matchers.notNullValue()));
        return this;
    }

    @JDIAction("Assert that '{name}' input model is '{0}'")
    public ColorPickerAssert inputModel(String inputModel) {
        jdiAssert(element().getInputModel(), Matchers.is(inputModel));
        return this;
    }

    @JDIAction("Assert that '{name}' is elevated")
    public ColorPickerAssert elevated() {
        jdiAssert((element().attr("class").contains("elevation")
                & !(element().attr("class").contains("flat"))), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not elevated")
    public ColorPickerAssert notElevated() {
        jdiAssert((element().attr("class").contains("flat")
                & !(element().attr("class").contains("elevation"))), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' hueSlider has value")
    public ColorPickerAssert hueSliderValue() {
        jdiAssert(element().hueSlider().getValue(), Matchers.is(Matchers.notNullValue()));
        return this;
    }

    @JDIAction("Assert that '{name}' alphaSlider has value")
    public ColorPickerAssert alphaSliderValue() {
        jdiAssert(element().alphaSlider().getValue(), Matchers.is(Matchers.notNullValue()));
        return this;
    }

    @JDIAction("Assert that '{name}' hueSlider value have changed")
    public ColorPickerAssert hueSliderValueHaveChanged(String initialValue) {
        jdiAssert(element().hueSlider().getValue(), Matchers.not(initialValue));
        return this;
    }

    @JDIAction("Assert that '{name}' alphaSlider value have changed")
    public ColorPickerAssert alphaSliderValueHaveChanged(String initialValue) {
        jdiAssert(element().alphaSlider().getValue(), Matchers.not(initialValue));
        return this;
    }

    @JDIAction("Assert that '{name}' has color '{0}'")
    public ColorPickerAssert color(String color) {
        jdiAssert(element().getColor(element().colorDot()), Matchers.is(Color.fromString(color)));
        return this;
    }

    @JDIAction("Assert that '{name}' hex input field length is '{0}'")
    public ColorPickerAssert hexInputFieldLength(int length) {
        jdiAssert(element().inputHEX().getText().length(), Matchers.is(length));
        return this;
    }

}
