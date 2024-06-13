package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ColorPicker;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.Color;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

// @todo #5310 Add more assertion with Matcher inside (like alphaSliderValue), we can not see all required
public class ColorPickerAssert extends UIAssert<ColorPickerAssert, ColorPicker> implements
        ElevationAssert<ColorPickerAssert, ColorPicker>, ThemeAssert<ColorPickerAssert, ColorPicker> {

    @JDIAction(value = "Assert that '{name}' input model is '{0}'", isAssert = true)
    public ColorPickerAssert inputModel(String inputModel) {
        jdiAssert(element().getInputModel(), Matchers.is(inputModel));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hueSlider matches {0}", isAssert = true)
    public ColorPickerAssert hueSliderValue(Matcher<Object> value) {
        jdiAssert(element().hueSlider().value(), value);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' alphaSlider matches {0}", isAssert = true)
    public ColorPickerAssert alphaSliderValue(Matcher<Object> value) {
        jdiAssert(element().alphaSlider().value(), value);
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
