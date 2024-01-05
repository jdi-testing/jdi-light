package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.HideDetailsAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OrientationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SliderAssert extends UIAssert<SliderAssert, Slider> implements OrientationAssert<SliderAssert, Slider>,
        ReadOnlyAssert<SliderAssert, Slider>, MessagesAssert<SliderAssert, Slider>, ThemeAssert<SliderAssert, Slider>,
    DenseAssert<SliderAssert, Slider>, ColorAssert<SliderAssert, Slider>, MeasurementAssert<SliderAssert, Slider>,
    HideDetailsAssert<SliderAssert, Slider>, LoadingAssert<SliderAssert, Slider> {
    @JDIAction(value = "Assert that value {name} is {0}", isAssert = true)
    public SliderAssert value(double value) {
        jdiAssert(element().value(), Matchers.is(value));
        return this;
    }
    @JDIAction(value = "Assert that min value {name} is {0}", isAssert = true)
    public SliderAssert minValue(double value) {
        jdiAssert(element().minValue(), Matchers.is(value));
        return this;
    }
    @JDIAction(value = "Assert that max value {name} is {0}", isAssert = true)
    public SliderAssert maxValue(double value) {
        jdiAssert(element().maxValue(), Matchers.is(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has thumb label", isAssert = true)
    public SliderAssert thumbLabel() {
        jdiAssert(element().hasThumbLabel(), Matchers.is(true), "Slider's has no thumb label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no thumb label", isAssert = true)
    public SliderAssert noThumbLabel() {
        jdiAssert(element().hasThumbLabel(), Matchers.is(false), "Slider's has thumb label");
        return this;
    }

    @JDIAction(value = "Assert that {name} has ticks", isAssert = true)
    public SliderAssert ticks() {
        jdiAssert(element().ticks().isExist(), Matchers.is(true), "Slider has no ticks");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no ticks", isAssert = true)
    public SliderAssert noTicks() {
        jdiAssert(element().ticks().isExist(), Matchers.is(false), "Slider has ticks");
        return this;
    }
    @JDIAction(value = "Assert that tick {name} is always show", isAssert = true)
    public SliderAssert tickAlwaysShow() {
        jdiAssert(element().isAlwaysShow(), Matchers.is(true), "Slider's tick is not always shown");
        return this;
    }

    @JDIAction(value = "Assert that tick {name} size is {0}", isAssert = true)
    public SliderAssert ticksSize(int size) {
        jdiAssert(element().ticksSize(), Matchers.equalTo(size));
        return this;
    }

    @JDIAction(value = "Assert that tick {name} label is {0}", isAssert = true)
    public SliderAssert tickLabel(int index, String label) {
        jdiAssert(element().tickLabel(index), Matchers.is(label));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public SliderAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Slider has no label");
        return this;
    }
    @JDIAction(value = "Assert that '{name}' label is '{0}'", isAssert = true)
    public SliderAssert label(String text) {
        jdiAssert(element().label().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not label", isAssert = true)
    public SliderAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "Slider has label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has Inverse label", isAssert = true)
    public SliderAssert inverseLabel() {
        jdiAssert(element().hasInverseLabel(), Matchers.is(true), "Slider has inverse label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' track fill color is '{0}'", isAssert = true)
    public SliderAssert trackFillColor(String color) {
        jdiAssert(element().trackFillColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' track color is '{0}'", isAssert = true)
    public SliderAssert trackColor(String color) {
        jdiAssert(element().trackBackgroundColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' thumb color is '{0}'", isAssert = true)
    public SliderAssert thumbColor(String color) {
        jdiAssert(element().thumbColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' thumb color is '{0}'", isAssert = true)
    public SliderAssert thumbSize(int size) {
        jdiAssert(element().thumbSize(), Matchers.equalTo(size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is error", isAssert = true)
    public SliderAssert error() {
        jdiAssert(element().isError(), Matchers.is(true), "Slider is not error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not error", isAssert = true)
    public SliderAssert notError() {
        jdiAssert(element().isError(), Matchers.is(false), "Slider is error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is success", isAssert = true)
    public SliderAssert success() {
        jdiAssert(element().isSuccess(), Matchers.is(true), "Slider is not success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not success", isAssert = true)
    public SliderAssert notSuccess() {
        jdiAssert(element().isSuccess(), Matchers.is(false), "Slider is success");
        return this;
    }
}
