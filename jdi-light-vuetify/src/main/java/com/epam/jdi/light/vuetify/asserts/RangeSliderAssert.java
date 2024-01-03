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
        double actualValue = element().minValue();
        jdiAssert(actualValue, Matchers.is(value), String.format("Element's actual min value '%s' is not equal to " +
            "expected '%s'", actualValue, value));
        return this;
    }

    @JDIAction(value = "Assert that max value {name} is {0}", isAssert = true)
    public RangeSliderAssert maxValue(double value) {
        double actualValue = element().maxValue();
        jdiAssert(actualValue, Matchers.is(value), String.format("Element's actual max value '%s' is not equal to " +
            "expected '%s'", actualValue, value));
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
        jdiAssert(element().hasThumbLabels(), Matchers.is(false), "Element has thumb label");
        return this;
    }

    @JDIAction(value = "Assert that {name} has ticks", isAssert = true)
    public RangeSliderAssert ticks() {
        jdiAssert(element().ticks().isExist(), Matchers.is(true), "Element has no ticks");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no ticks", isAssert = true)
    public RangeSliderAssert noTicks() {
        jdiAssert(element().ticks().isExist(), Matchers.is(false), "Element has ticks");
        return this;
    }

    @JDIAction(value = "Assert that {name} ticks is always show", isAssert = true)
    public RangeSliderAssert ticksAlwaysShow() {
        jdiAssert(element().isTicksAlwaysShow(), Matchers.is(true), "Element's tick is not always shown");
        return this;
    }

    @JDIAction(value = "Assert that {name} tick size is {0}", isAssert = true)
    public RangeSliderAssert ticksSize(int size) {
        Integer actualSize = element().ticksSize();
        jdiAssert(element().ticksSize(), Matchers.equalTo(size), String.format("Element's actual size '%s' is not equal to " +
            "expected '%s'", actualSize, size));
        return this;
    }

    @JDIAction(value = "Assert that {name} {0} tick label is {1}", isAssert = true)
    public RangeSliderAssert tickLabel(int index, String label) {
        String actualTickLabel = element().tickLabel(index);
        jdiAssert(actualTickLabel, Matchers.is(label), String.format("Element's actual tick label '%s' is not equal " +
            "to expected '%s'", actualTickLabel, label));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public RangeSliderAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element has no label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' label is '{0}'", isAssert = true)
    public RangeSliderAssert label(String text) {
        String actualLabelText = element().label().getText();
        jdiAssert(actualLabelText, Matchers.is(text), String.format("Actual label text '%s' is not equal to expected " +
            "'%s'", actualLabelText, text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not label", isAssert = true)
    public RangeSliderAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "Element has label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has Inverse label", isAssert = true)
    public RangeSliderAssert inverseLabel() {
        jdiAssert(element().hasInverseLabel(), Matchers.is(true), "Element does not have inverse label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' track fill color is '{0}'", isAssert = true)
    public RangeSliderAssert trackFillColor(String color) {
        String actualColor = element().trackFillColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual track fill color '%s' is not " +
            "equal to expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' track background color is '{0}'", isAssert = true)
    public RangeSliderAssert trackColor(String color) {
        String actualColor = element().trackBackgroundColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual track background color '%s' is not " +
            "equal expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' thumb color is '{0}'", isAssert = true)
    public RangeSliderAssert thumbColor(String color) {
        String actualColor = element().thumbColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual thumb color '%s' is not " +
            "equal to expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' left thumb size is '{0}'", isAssert = true)
    public RangeSliderAssert thumbSize(int size) {
        int actualSize = element().thumbSize();
        jdiAssert(actualSize, Matchers.equalTo(size), String.format("Element's actual thumb size '%s' is not equal to expected '%s'", actualSize, size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is error", isAssert = true)
    public RangeSliderAssert error() {
        jdiAssert(element().isError(), Matchers.is(true), "Element is not error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not error", isAssert = true)
    public RangeSliderAssert notError() {
        jdiAssert(element().isError(), Matchers.is(false), "Element is error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is success", isAssert = true)
    public RangeSliderAssert success() {
        jdiAssert(element().isSuccess(), Matchers.is(true), "Element is not success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not success", isAssert = true)
    public RangeSliderAssert notSuccess() {
        jdiAssert(element().isSuccess(), Matchers.is(false), "Element is success");
        return this;
    }
}
