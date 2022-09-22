package com.epam.jdi.light.vuetify.asserts.sliders;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.sliders.Slider;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SliderAssert extends BasicSliderAssert<Slider, SliderAssert> {

    @JDIAction("Assert that {name} is horizontal")
    public SliderAssert horizontal() {
        jdiAssert(element().isHorizontal() ? "is horizontal element" : "is not horizontal element",
                Matchers.is("is horizontal element"));
        return this;
    }
    @JDIAction("Assert that value {name} is {0}")
    public SliderAssert value(String value) {
        jdiAssert(element().value(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that thumb label value {name} is {0}")
    public SliderAssert thumbLabelValue(String value) {
        jdiAssert(element().thumbLabelValue(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that thumb label {name} is displayed")
    public SliderAssert thumbLabelDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed() ? "is displayed element" : "is not displayed element",
                Matchers.is("is displayed element"));
        return this;
    }

    @JDIAction("Assert that thumb label {name} is not displayed")
    public SliderAssert thumbLabelNotDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed() ? "is displayed element" : "is not displayed element",
                Matchers.is("is not displayed element"));
        return this;
    }

    @JDIAction("Assert that tick {name} is always show")
    public SliderAssert tickAlwaysShow() {
        jdiAssert(element().isAlwaysShow() ? "is always show element" : "is not always show element",
                Matchers.is("is always show element"));
        return this;
    }

    @JDIAction("Assert that tick {name} width is {0}, height is {1}")
    public SliderAssert ticksSize(int width, int height) {
        element().ticks().foreach(tick -> {
            jdiAssert(tick.getAttribute("style"), Matchers.containsString("width: " + width + "px"));
            jdiAssert(tick.getAttribute("style"), Matchers.containsString("width: " + height + "px"));
        });
        return this;
    }

    @JDIAction("Assert that tick {name} label is {0}")
    public SliderAssert tickLabel(int index, String label) {
        jdiAssert(element().tickLabel(index), Matchers.is(label));
        return this;
    }

    @JDIAction("Assert that hint {name} label is {0}")
    public SliderAssert hintLabel(String label) {
        jdiAssert(element().hintLabel(), Matchers.is(label));
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public SliderAssert hasLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "There is no label for element");
        return this;
    }
    @JDIAction("Assert that '{name}' has not label")
    public SliderAssert hasNoLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(false), "There is a label for element");
        return this;
    }
}
