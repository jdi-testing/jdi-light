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
    @JDIAction(value = "Assert that value {name} is {0}")
    public SliderAssert value(double value) {
        double actualValue = element().value();
        jdiAssert(actualValue, Matchers.is(value), String.format("Element's actual value '%s' is not equal to " +
                "expected '%s'", actualValue, value));
        return this;
    }
    @JDIAction(value = "Assert that min value {name} is {0}")
    public SliderAssert minValue(double value) {
        double actualValue = element().minValue();
        jdiAssert(actualValue, Matchers.is(value), String.format("Element's actual min value '%s' is not equal to " +
            "expected '%s'", actualValue, value));
        return this;
    }
    @JDIAction(value = "Assert that min value {name} is {0}")
    public SliderAssert maxValue(double value) {
        double actualValue = element().maxValue();
        jdiAssert(actualValue, Matchers.is(value), String.format("Element's actual min value '%s' is not equal to " +
            "expected '%s'", actualValue, value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has thumb label")
    public SliderAssert thumbLabel() {
        jdiAssert(element().hasThumbLabel(), Matchers.is(true), "Element's has no thumb label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no thumb label")
    public SliderAssert noThumbLabel() {
        jdiAssert(element().hasThumbLabel(), Matchers.is(false), "Element's has thumb label");
        return this;
    }

    @JDIAction(value = "Assert that {name} has ticks")
    public SliderAssert ticks() {
        jdiAssert(element().ticks().isExist(), Matchers.is(true), "Element has no ticks");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no ticks")
    public SliderAssert noTicks() {
        jdiAssert(element().ticks().isExist(), Matchers.is(false), "Element has ticks");
        return this;
    }
    @JDIAction(value = "Assert that tick {name} is always show")
    public SliderAssert tickAlwaysShow() {
        jdiAssert(element().isAlwaysShow(), Matchers.is(true), "Element's tick is not always shown");
        return this;
    }

    @JDIAction(value = "Assert that tick {name} size is {0}")
    public SliderAssert ticksSize(int size) {
        Integer actualSize = element().ticksSize();
        jdiAssert(element().ticksSize(), Matchers.equalTo(size), String.format("Element's actual size '%s' is not equal to " +
                "expected '%s'", actualSize, size));
        return this;
    }

    @JDIAction(value = "Assert that tick {name} label is {0}")
    public SliderAssert tickLabel(int index, String label) {
        String actualTickLabel = element().tickLabel(index);
        jdiAssert(actualTickLabel, Matchers.is(label), String.format("Element's actual tick label '%s' is not equal " +
                "to expected '%s'", actualTickLabel, label));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label")
    public SliderAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element has no label");
        return this;
    }
    @JDIAction(value = "Assert that '{name}' label is '{0}'")
    public SliderAssert label(String text) {
        String actualLabelText = element().label().getText();
        jdiAssert(actualLabelText, Matchers.is(text), String.format("Actual label text '%s' is not equal to expected " +
            "'%s'", actualLabelText, text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not label")
    public SliderAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "Element has label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has Inverse label")
    public SliderAssert inverseLabel() {
        jdiAssert(element().hasInverseLabel(), Matchers.is(true), "Element has inverse label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' track fill color is '{0}'")
    public SliderAssert trackFillColor(String color) {
        String actualColor = element().trackFillColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual track color '%s' is not " +
                "equal to expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' track color is '{0}'")
    public SliderAssert trackColor(String color) {
        String actualColor = element().trackBackgroundColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual background track color '%s' " +
                "is not equal to expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' thumb color is '{0}'")
    public SliderAssert thumbColor(String color) {
        String actualColor = element().thumbColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual thumb color '%s' is not equal to " +
                "expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' thumb color is '{0}'")
    public SliderAssert thumbSize(int size) {
        int actualSize = element().thumbSize();
        jdiAssert(actualSize, Matchers.equalTo(size), String.format("Element's actual thumb size '%s' is not equal " +
                "to expected '%s'", actualSize, size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is error")
    public SliderAssert error() {
        jdiAssert(element().isError(), Matchers.is(true), "Element is not error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not error")
    public SliderAssert notError() {
        jdiAssert(element().isError(), Matchers.is(false), "Element is error");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is success")
    public SliderAssert success() {
        jdiAssert(element().isSuccess(), Matchers.is(true), "Element is not success");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not success")
    public SliderAssert notSuccess() {
        jdiAssert(element().isSuccess(), Matchers.is(false), "Element is success");
        return this;
    }
}
