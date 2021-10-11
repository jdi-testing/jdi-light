package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.RangeSlider;
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
}