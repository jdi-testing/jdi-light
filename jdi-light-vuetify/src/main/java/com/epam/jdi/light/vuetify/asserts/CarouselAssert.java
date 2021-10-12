package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Carousel;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CarouselAssert extends UIAssert<CarouselAssert, Carousel> {

    @JDIAction("Assert that '{name}' is displayed")
    public CarouselAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has proper delimiters icons")
    public CarouselAssert delimiterIcons(String iconName) {
        jdiAssert(element().hasDelimitersIcons(iconName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has proper number of delimiters")
    public CarouselAssert numberOfDelimiters(int numberOfDelimiters) {
        jdiAssert(element().hasNumberOfDelimiters(), Matchers.equalTo(numberOfDelimiters));
        return this;
    }

    @JDIAction("Assert that '{name}' has hidden delimiters")
    public CarouselAssert delimitersHidden() {
        jdiAssert(element().hasDelimitersHidden(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'next' button visible")
    public CarouselAssert nextButtonVisible() {
        jdiAssert(element().hasNextButtonVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'previous' button visible")
    public CarouselAssert previousButtonVisible() {
        jdiAssert(element().hasPreviousButtonVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'next' button hidden")
    public CarouselAssert nextButtonHidden() {
        jdiAssert(element().hasNextButtonHidden(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'previous' button hidden")
    public CarouselAssert previousButtonHidden() {
        jdiAssert(element().hasPreviousButtonHidden(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' 'next' button has proper text")
    public CarouselAssert nextButtonText(String text) {
        jdiAssert(element().nextButtonText(), Matchers.containsString(text));
        return this;
    }


    @JDIAction("Assert that '{name}' 'previous' button has proper text")
    public CarouselAssert previousButtonText(String text) {
        jdiAssert(element().previousButtonText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' 'next' button has proper color")
    public CarouselAssert nextButtonColor(String color) {
        jdiAssert(element().nextButtonColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that '{name}' 'previous' button has proper color")
    public CarouselAssert previousButtonColor(String color) {
        jdiAssert(element().previousButtonColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that '{name}' current slide has proper color")
    public CarouselAssert currentSlideColor(String color) {
        Timer.waitCondition(() -> element().currentSlideColor().equals(color));
        jdiAssert(element().currentSlideColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that '{name}' current slide has proper text")
    public CarouselAssert currentSlideText(String text) {
        Timer.waitCondition(() -> element().currentSlideText().equals(text));
        jdiAssert(element().currentSlideText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' current slide has proper image")
    public CarouselAssert currentSlideBackgroundImage(String imageContent) {
        Timer.waitCondition(() -> element().currentSlideBackgroundImage().contains(imageContent));
        jdiAssert(element().currentSlideBackgroundImage(), Matchers.containsString(imageContent));
        return this;
    }

    @JDIAction("Assert that '{name}' has toggle button")
    public CarouselAssert toggle() {
        jdiAssert(element().hasToggle(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' toggle button is checked")
    public CarouselAssert toggleChecked() {
        jdiAssert(element().hasToggleChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' toggle button is unchecked")
    public CarouselAssert toggleUnchecked() {
        jdiAssert(element().hasToggleUnchecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has slide counter")
    public CarouselAssert slideCounter(String text) {
        jdiAssert(element().slideCounter(), Matchers.containsString(text));
        return this;
    }
}
