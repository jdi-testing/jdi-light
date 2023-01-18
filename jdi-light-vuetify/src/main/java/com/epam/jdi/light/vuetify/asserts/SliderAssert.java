package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OrientationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SliderAssert extends UIAssert<SliderAssert, Slider> implements OrientationAssert<SliderAssert, Slider>,
        ReadOnlyAssert<SliderAssert, Slider>, MessagesAssert<SliderAssert, Slider> {
    @JDIAction("Assert that value {name} is {0}")
    public SliderAssert value(double value) {
        double actualValue = element().value();
        jdiAssert(actualValue, Matchers.is(value), String.format("Element's actual value '%s' is not equal to " +
                "expected '%s'", actualValue, value));
        return this;
    }

    @JDIAction("Assert that thumb label value {name} is {0}")
    public SliderAssert thumbLabelValue(double value) {
        double actualThumbLabelValue = element().thumbLabelValue();
        jdiAssert(actualThumbLabelValue, Matchers.is(value), String.format("Element's actual thumb label value '%s' " +
                "is not equal to expected '%s'", actualThumbLabelValue, value));
        return this;
    }

    @JDIAction("Assert that '{name}' has thumb label")
    public SliderAssert thumbLabel() {
        jdiAssert(element().hasThumbLabel(), Matchers.is(true), "Element's has no thumb label");
        return this;
    }

    @JDIAction("Assert that '{name}' has no thumb label")
    public SliderAssert noThumbLabel() {
        jdiAssert(element().hasThumbLabel(), Matchers.is(false), "Element's has thumb label");
        return this;
    }

    @JDIAction("Assert that thumb label {name} is displayed")
    public SliderAssert thumbLabelDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(true), "Element's thumb label is not " +
                "displayed");
        return this;
    }

    @JDIAction("Assert that thumb label {name} is not displayed")
    public SliderAssert thumbLabelNotDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(false), "Element's thumb label is " +
                "displayed");
        return this;
    }

    @JDIAction("Assert that tick {name} is always show")
    public SliderAssert tickAlwaysShow() {
        jdiAssert(element().isAlwaysShow(), Matchers.is(true), "Element's tick is not always shown");
        return this;
    }

    @JDIAction("Assert that tick {name} width is {0}, height is {1}")
    public SliderAssert ticksSize(int width, int height) {
        int actualWidth = element().ticksWidth();
        int actualHeight = element().ticksHeight();
        jdiAssert(actualWidth, Matchers.equalTo(width), String.format("Element's actual width '%s' is not equal to " +
                "expected '%s'", actualWidth, width));
        jdiAssert(actualHeight, Matchers.equalTo(height), String.format("Element's actual height '%s' is not equal " +
                "to expected '%s'", actualHeight, height));
        return this;
    }

    @JDIAction("Assert that tick {name} label is {0}")
    public SliderAssert tickLabel(int index, String label) {
        String actualTickLabel = element().tickLabel(index);
        jdiAssert(actualTickLabel, Matchers.is(label), String.format("Element's actual tick label '%s' is not equal " +
                "to expected '%s'", actualTickLabel, label));
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public SliderAssert label() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element has no label");
        return this;
    }

    @JDIAction("Assert that '{name}' has not label")
    public SliderAssert noLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "Element has label");
        return this;
    }

    @JDIAction("Assert that '{name}' background track color is '{0}'")
    public SliderAssert trackColor(String color) {
        String actualColor = element().trackColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual track color '%s' is not " +
                "equal to expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' background track color is '{0}'")
    public SliderAssert backgroundTrackColor(String color) {
        String actualColor = element().backgroundTrackColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual background track color '%s' " +
                "is not equal to expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' thumb color is '{0}'")
    public SliderAssert thumbColor(String color) {
        String actualColor = element().thumbColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual thumb color '%s' is not equal to " +
                "expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' thumb color is '{0}'")
    public SliderAssert thumbSize(int size) {
        int actualSize = element().thumbSize();
        jdiAssert(actualSize, Matchers.equalTo(size), String.format("Element's actual thumb size '%s' is not equal " +
                "to expected '%s'", actualSize, size));
        return this;
    }
}
