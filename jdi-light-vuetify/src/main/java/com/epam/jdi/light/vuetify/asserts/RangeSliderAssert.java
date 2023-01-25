package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.RangeSlider;
import org.hamcrest.Matchers;

import java.util.Arrays;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RangeSliderAssert extends UIAssert<RangeSliderAssert, RangeSlider> {

    @Override
    @JDIAction("Assert that {name} is disabled")
    public RangeSliderAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that value {name} is {0}, {1}")
    public RangeSliderAssert value(int valueLeft, int valueRight) {
        jdiAssert(element().getValue(), Matchers.is(Arrays.asList(valueLeft, valueRight)));
        return this;
    }

    @JDIAction("Assert that thumb label value {name} is {0}, {1}")
    public RangeSliderAssert thumbLabelValue(String imageNameLeft, String imageNameRight) {
        jdiAssert(element().getThumbLabelValue().get(0), Matchers.stringContainsInOrder(imageNameLeft));
        jdiAssert(element().getThumbLabelValue().get(1), Matchers.containsString(imageNameRight));
        return this;
    }

    @JDIAction("Assert that thumb label {name} is displayed")
    public RangeSliderAssert thumbLabelDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that thumb label {name} is not displayed")
    public RangeSliderAssert thumbLabelNotDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has no thumb label")
    public RangeSliderAssert noThumbLabels() {
        jdiAssert(element().hasThumbLabels(), Matchers.is(true), "Element has thumb label");
        return this;
    }

    @JDIAction("Assert that trick {name} is always show")
    public RangeSliderAssert trickAlwaysShow() {
        jdiAssert(element().isAlwaysShow(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that trick {name} label is {0}")
    public RangeSliderAssert trickLabel(int index, String label) {
        jdiAssert(element().getTickLabel(index), Matchers.is(label));
        return this;
    }

    @JDIAction("Assert that '{name}' background track color is '{0}'")
    public RangeSliderAssert trackColor(String color) {
        String actualColor = element().trackColor();
        jdiAssert(actualColor, Matchers.equalTo(color), String.format("Element's actual track color '%s' is not equal to expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' left thumb size is '{0}'")
    public RangeSliderAssert leftThumbSize(int size) {
        int actualSize = element().getLeftThumbSize();
        jdiAssert(actualSize, Matchers.equalTo(size), String.format("Element's actual thumb size '%s' is not equal to expected '%s'", actualSize, size));
        return this;
    }

    @JDIAction("Assert that '{name}' right thumb size is '{0}'")
    public RangeSliderAssert rightThumbSize(int size) {
        int actualSize = element().getRightThumbSize();
        jdiAssert(actualSize, Matchers.equalTo(size), String.format("Element's actual thumb size '%s' is not equal to expected '%s'", actualSize, size));
        return this;
    }

    @JDIAction("Assert that left value {name} is {0}")
    public RangeSliderAssert leftValue(int valueLeft) {
        jdiAssert(element().getLeftValue(), Matchers.is(valueLeft));
        return this;
    }

    @JDIAction("Assert that right value {name} is {0}")
    public RangeSliderAssert rightValue(int valueRight) {
        jdiAssert(element().getRightValue(), Matchers.is(valueRight));
        return this;
    }
}
