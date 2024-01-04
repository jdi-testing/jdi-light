package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.RangeSlider;
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

import java.util.Arrays;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RangeSliderAssert extends UIAssert<RangeSliderAssert, RangeSlider> implements OrientationAssert<RangeSliderAssert, RangeSlider>,
    ReadOnlyAssert<RangeSliderAssert, RangeSlider>, MessagesAssert<RangeSliderAssert, RangeSlider>, ThemeAssert<RangeSliderAssert, RangeSlider>,
    DenseAssert<RangeSliderAssert, RangeSlider>, ColorAssert<RangeSliderAssert, RangeSlider>, MeasurementAssert<RangeSliderAssert, RangeSlider>,
    HideDetailsAssert<RangeSliderAssert, RangeSlider>, LoadingAssert<RangeSliderAssert, RangeSlider> {

    @JDIAction(value = "Assert that value {name} is {0}, {1}", isAssert = true)
    public RangeSliderAssert value(double valueLeft, double valueRight) {
        jdiAssert(element().value(), Matchers.is(Arrays.asList(valueLeft, valueRight)));
        return this;
    }

    @JDIAction(value = "Assert that left value {name} is {0}", isAssert = true)
    public RangeSliderAssert leftValue(double valueLeft) {
        jdiAssert(element().leftValue(), Matchers.is(valueLeft));
        return this;
    }

    @JDIAction(value = "Assert that right value {name} is {0}", isAssert = true)
    public RangeSliderAssert rightValue(double valueRight) {
        jdiAssert(element().rightValue(), Matchers.is(valueRight));
        return this;
    }

    @JDIAction(value = "Assert that min value {name} is {0}", isAssert = true)
    public RangeSliderAssert minValue(double value) {
        jdiAssert(element().minValue(), Matchers.is(value));
        return this;
    }

    @JDIAction(value = "Assert that max value {name} is {0}", isAssert = true)
    public RangeSliderAssert maxValue(double value) {
        jdiAssert(element().maxValue(), Matchers.is(value));
        return this;
    }

    @JDIAction(value = "Assert that thumb label value {name} is {0}, {1}", isAssert = true)
    public RangeSliderAssert thumbLabelValue(String leftValue, String rightValue) {
        assertSoft();
        jdiAssert(element().thumbLabelValue().get(0), Matchers.containsString(leftValue));
        jdiAssert(element().thumbLabelValue().get(1), Matchers.containsString(rightValue));
        return this;
    }

    @JDIAction(value = "Assert that thumb label {name} is displayed", isAssert = true)
    public RangeSliderAssert thumbLabelDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(true),
                "RangeSlider's thumb label is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that thumb label {name} is not displayed", isAssert = true)
    public RangeSliderAssert thumbLabelNotDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(false),
                "RangeSlider's thumb label is displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no thumb label", isAssert = true)
    public RangeSliderAssert noThumbLabels() {
        jdiAssert(element().hasThumbLabels(), Matchers.is(false), "RangeSlider has thumb label");
        return this;
    }

    @JDIAction(value = "Assert that {name} has ticks", isAssert = true)
    public RangeSliderAssert ticks() {
        jdiAssert(element().ticks().isExist(), Matchers.is(true), "RangeSlider has no ticks");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no ticks", isAssert = true)
    public RangeSliderAssert noTicks() {
        jdiAssert(element().ticks().isExist(), Matchers.is(false), "RangeSlider has ticks");
        return this;
    }

    @JDIAction(value = "Assert that {name} ticks is always show", isAssert = true)
    public RangeSliderAssert ticksAlwaysShow() {
        jdiAssert(element().isTicksAlwaysShow(), Matchers.is(true), "RangeSlider's tick is not always shown");
        return this;
    }

    @JDIAction(value = "Assert that {name} tick size is {0}", isAssert = true)
    public RangeSliderAssert ticksSize(int size) {
        jdiAssert(element().ticksSize(), Matchers.equalTo(size));
        return this;
    }

    @JDIAction(value = "Assert that {name} {0} tick label is {1}", isAssert = true)
    public RangeSliderAssert tickLabel(int index, String label) {
        jdiAssert(element().tickLabel(index), Matchers.is(label));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public RangeSliderAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "RangeSlider has no label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' label is '{0}'", isAssert = true)
    public RangeSliderAssert label(String text) {
        jdiAssert(element().label().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not label", isAssert = true)
    public RangeSliderAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "RangeSlider has label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has Inverse label", isAssert = true)
    public RangeSliderAssert inverseLabel() {
        jdiAssert(element().hasInverseLabel(), Matchers.is(true), "RangeSlider does not have inverse label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' track fill color is '{0}'", isAssert = true)
    public RangeSliderAssert trackFillColor(String color) {
        jdiAssert(element().trackFillColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' track background color is '{0}'", isAssert = true)
    public RangeSliderAssert trackColor(String color) {
        jdiAssert(element().trackBackgroundColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' thumb color is '{0}'", isAssert = true)
    public RangeSliderAssert thumbColor(String color) {
        jdiAssert(element().thumbColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' left thumb size is '{0}'", isAssert = true)
    public RangeSliderAssert thumbSize(int size) {
        jdiAssert(element().thumbSize(), Matchers.equalTo(size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is error", isAssert = true)
    public RangeSliderAssert error() {
        jdiAssert(element().isError(), Matchers.is(true), "RangeSlider is not error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not error", isAssert = true)
    public RangeSliderAssert notError() {
        jdiAssert(element().isError(), Matchers.is(false), "RangeSlider is error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is success", isAssert = true)
    public RangeSliderAssert success() {
        jdiAssert(element().isSuccess(), Matchers.is(true), "RangeSlider is not success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not success", isAssert = true)
    public RangeSliderAssert notSuccess() {
        jdiAssert(element().isSuccess(), Matchers.is(false), "RangeSlider is success");
        return this;
    }
}
