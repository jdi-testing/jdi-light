package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Slider;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SliderAssert extends UIAssert<SliderAssert, Slider> {

    @Override
    @JDIAction("Assert that {name} is disabled")
    public SliderAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is readonly")
    public SliderAssert readonly() {
        jdiAssert(element().isReadonly(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is vertical")
    public SliderAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that value {name} is {0}")
    public SliderAssert value(int value) {
        jdiAssert(Integer.parseInt(element().getValue()), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that fill color {name} is {0}")
    public SliderAssert fillColor(String color) {
        jdiAssert(element().getFill().hasClass(color), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that background color {name} is {0}")
    public SliderAssert backgroundColor(String color) {
        jdiAssert(element().getBackground().hasClass(color), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that thumb color {name} is {0}")
    public SliderAssert thumbColor(String color) {
        jdiAssert(element().getThumb().hasClass(color), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that thumb label color {name} is {0}")
    public SliderAssert thumbLabelColor(String color) {
        jdiAssert(element().getThumbLabel().hasClass(color), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that thumb label value {name} is {0}")
    public SliderAssert thumbLabelValue(int value) {
        jdiAssert(Integer.parseInt(element().getThumbLabelValue()), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that thumb label value {name} is displayed")
    public SliderAssert thumbLabelDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that thumb label value {name} is not displayed")
    public SliderAssert thumbLabelNotDisplayed() {
        jdiAssert(element().isThumbLabelDisplayed(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that trick {name} is always show")
    public SliderAssert trickAlwaysShow() {
        jdiAssert(element().isAlwaysShow(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that trick {name} is not always show")
    public SliderAssert trickNotAlwaysShow() {
        jdiAssert(element().isAlwaysShow(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that trick {name} width is {0}, height is {1}")
    public SliderAssert tricksSize(int width, int height) {
        element().getTicks().foreach(tick -> {
            jdiAssert(tick.getAttribute("style"), Matchers.containsString("width: " + width + "px"));
            jdiAssert(tick.getAttribute("style"), Matchers.containsString("width: " + height + "px"));
        });
        return this;
    }

    @JDIAction("Assert that trick {name} label is {0}")
    public SliderAssert trickLabel(int index, String label) {
        jdiAssert(element().getTickLabel(index), Matchers.is(label));
        return this;
    }
}
