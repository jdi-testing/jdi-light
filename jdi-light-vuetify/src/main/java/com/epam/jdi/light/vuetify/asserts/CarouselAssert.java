package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Carousel;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CarouselAssert extends UIAssert<CarouselAssert, Carousel> {

    @JDIAction("Assert that '{name}' is displayed")
    public CarouselAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}'s current slide has expected text")
    public CarouselAssert currentSlideText(String text) {
        Timer.waitCondition(() -> element().getCurrentSlideText().equals(text));
        jdiAssert(element().getCurrentSlideText(), Matchers.containsString(text));
        return this;
    }
}
