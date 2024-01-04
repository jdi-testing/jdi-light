package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ColorPicker;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.Color;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ColorPickerAssert extends UIAssert<ColorPickerAssert, ColorPicker> implements
        ElevationAssert<ColorPickerAssert, ColorPicker>, ThemeAssert<ColorPickerAssert, ColorPicker> {

    @JDIAction(value = "Assert that '{name}' canvas has style", isAssert = true)
    public ColorPickerAssert canvasStyle() {
        jdiAssert(element().getCanvasStyle(), Matchers.is(Matchers.notNullValue()),
                "ColorPicker has not canvas style");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' canvasDot has style", isAssert = true)
    public ColorPickerAssert canvasDotStyle() {
        jdiAssert(element().getCanvasDotStyle(), Matchers.is(Matchers.notNullValue()),
                "ColorPicker has not dot style");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' input model is '{0}'", isAssert = true)
    public ColorPickerAssert inputModel(String inputModel) {
        String actualInputModel = element().getInputModel();
        jdiAssert(actualInputModel, Matchers.is(inputModel));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hueSlider has value", isAssert = true)
    public ColorPickerAssert hueSliderValue() {
        jdiAssert(element().hueSlider().value(), Matchers.is(Matchers.notNullValue()),
                "ColorPicker has not slider value");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' alphaSlider has value", isAssert = true)
    public ColorPickerAssert alphaSliderValue() {
        jdiAssert(element().alphaSlider().value(), Matchers.is(Matchers.notNullValue()),
                "ColorPicker has not slider value");
        return this;
    }

    //TODO: Check this method
    @JDIAction(value = "Assert that '{name}' hueSlider value have changed", isAssert = true)
    public ColorPickerAssert hueSliderValueHaveChanged(double initialValue) {
        jdiAssert(element().hueSlider().value(), Matchers.not(initialValue), "Hue slider value wasn't changed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' alphaSlider value have changed", isAssert = true)
    public ColorPickerAssert alphaSliderValueHaveChanged(double initialValue) {
        jdiAssert(element().alphaSlider().value(), Matchers.not(initialValue),
                "Alpha slider value wasn't changed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' dots has color '{0}'", isAssert = true)
    public ColorPickerAssert dotColor(String color) {
        return dotColor(Color.fromString(color));
    }

    @JDIAction(value = "Assert that '{name}' dots has color '{0}'", isAssert = true)
    public ColorPickerAssert dotColor(Color color) {
        jdiAssert(element().getColor(element().colorDot()), Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hex input field length is '{0}'", isAssert = true)
    public ColorPickerAssert hexInputFieldLength(int length) {
        jdiAssert(element().inputHEX().getText().length(), Matchers.is(length));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hex input field color string value is '{0}'", isAssert = true)
    public ColorPickerAssert hexInputFieldStringColorValue(String color) {
        jdiAssert(element().inputHEX().getText(), Matchers.is(color));
        return this;
    }
}
