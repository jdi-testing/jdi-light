package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.RangeSlider;
import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class RangeSliderAssert extends UIAssert<RangeSliderAssert, RangeSlider> {

    @Override
    @JDIAction("Assert that {name} is disabled")
    public RangeSliderAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is readonly")
    public RangeSliderAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is vertical")
    public RangeSliderAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that value {name} is {0}, {1}")
    public RangeSliderAssert value(int valueLeft, int valueRight) {
        jdiAssert(element().getValue(), Matchers.is(Arrays.asList(valueLeft, valueRight)));
        return this;
    }

    @JDIAction("Assert that fill color {name} is {0}")
    public RangeSliderAssert fillColor(String color) {
        jdiAssert(element().getFill().hasClass(color), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that backgrounds color {name} is {0}")
    public RangeSliderAssert backgroundColor(String color) {
        element().getBackground().foreach(background -> jdiAssert(background.hasClass(color), Matchers.is(true)));
        return this;
    }

    @JDIAction("Assert that thumbs color {name} is {0}")
    public RangeSliderAssert thumbColor(String color) {
        element().getThumb().foreach(thumb -> jdiAssert(thumb.hasClass(color), Matchers.is(true)));
        //jdiAssert(element().getThumb().hasClass(color), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that thumbs label color {name} is {0}")
    public RangeSliderAssert thumbLabelColor(String color) {
        element().getThumbLabel().foreach(thumb -> jdiAssert(thumb.hasClass(color), Matchers.is(true)));
        //jdiAssert(element().getThumbLabel().hasClass(color), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that thumb label value {name} is {0}, {1}")
    public RangeSliderAssert thumbLabelValue(List<Integer> value) {
        jdiAssert(element().getThumbLabelValue(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that thumb label value {name} is displayed")
    public RangeSliderAssert thumbLabelDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that thumb label value {name} is not displayed")
    public RangeSliderAssert thumbLabelNotDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that trick {name} is always show")
    public RangeSliderAssert trickAlwaysShow() {
        jdiAssert(element().isAlwaysShow(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that trick {name} is not always show")
    public RangeSliderAssert trickNotAlwaysShow() {
        jdiAssert(element().isAlwaysShow(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that trick {name} width is {0}, height is {1}")
    public RangeSliderAssert tricksSize(int width, int height) {
        element().getTicks().foreach(tick -> {
            jdiAssert(tick.getAttribute("style"), Matchers.containsString("width: " + width + "px"));
            jdiAssert(tick.getAttribute("style"), Matchers.containsString("width: " + height + "px"));
        });
        return this;
    }

    @JDIAction("Assert that trick {name} label is {0}")
    public RangeSliderAssert trickLabel(int index, String label) {
        jdiAssert(element().getTickLabel(index), Matchers.is(label));
        return this;
    }
}