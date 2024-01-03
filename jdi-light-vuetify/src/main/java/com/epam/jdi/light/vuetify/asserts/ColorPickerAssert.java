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
        jdiAssert(element().getCanvasStyle(), Matchers.is(Matchers.notNullValue()), "Element has not canvas " +
                "style");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' canvasDot has style", isAssert = true)
    public ColorPickerAssert canvasDotStyle() {
        jdiAssert(element().getCanvasDotStyle(), Matchers.is(Matchers.notNullValue()), "Element has not dot " +
                "style");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' input model is '{0}'", isAssert = true)
    public ColorPickerAssert inputModel(String inputModel) {
        String actualInputModel = element().getInputModel();
        jdiAssert(actualInputModel, Matchers.is(inputModel), String.format("Actual input model '%s' is not equal to " +
                "expected '%s'", actualInputModel, inputModel));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hueSlider has value", isAssert = true)
    public ColorPickerAssert hueSliderValue() {
        jdiAssert(element().hueSlider().value(), Matchers.is(Matchers.notNullValue()), "Element has not " +
                "slider value");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' alphaSlider has value", isAssert = true)
    public ColorPickerAssert alphaSliderValue() {
        jdiAssert(element().alphaSlider().value(), Matchers.is(Matchers.notNullValue()), "Element has not " +
                "slider value");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hueSlider value have changed", isAssert = true)
    public ColorPickerAssert hueSliderValueHaveChanged(double initialValue) {
        jdiAssert(element().hueSlider().value(), Matchers.not(initialValue), "Hue slider value wasn't changed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' alphaSlider value have changed", isAssert = true)
    public ColorPickerAssert alphaSliderValueHaveChanged(double initialValue) {
        jdiAssert(element().alphaSlider().value(), Matchers.not(initialValue), "Alpha slider value wasn't " +
                "changed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has color '{0}'", isAssert = true)
    public ColorPickerAssert color(String color) {
        Color actualColor = element().getColor(element().colorDot());
        Color expectedColor = Color.fromString(color);
        jdiAssert(actualColor, Matchers.is(expectedColor), String.format("Actual element color '%s' is not equal to " +
                "expected '%s'", actualColor, expectedColor));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hex input field length is '{0}'", isAssert = true)
    public ColorPickerAssert hexInputFieldLength(int length) {
        int actualLength = element().inputHEX().getText().length();
        jdiAssert(actualLength, Matchers.is(length), String.format("Actual input field length '%s' is not equal to " +
                "expected '%s'", actualLength, length));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hex input field color string value is '{0}'", isAssert = true)
    public ColorPickerAssert hexInputFieldStringColorValue(String color) {
        String actualColor = element().inputHEX().getText();
        jdiAssert(actualColor, Matchers.is(color), String.format("Actual HEX input field color value '%s' is not " +
                "equal to expected '%s'", actualColor, color));
        return this;
    }

}
