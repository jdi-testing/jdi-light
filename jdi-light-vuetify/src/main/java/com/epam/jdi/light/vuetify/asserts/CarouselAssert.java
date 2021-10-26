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

    @JDIAction("Assert that '{name}' has expected delimiters icons")
    public CarouselAssert delimiterIcons(String iconName) {
        jdiAssert(element().hasDelimitersIcons(iconName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected number of delimiters")
    public CarouselAssert numberOfDelimiters(int numberOfDelimiters) {
        jdiAssert(element().hasNumberOfDelimiters(), Matchers.equalTo(numberOfDelimiters));
        return this;
    }

    @JDIAction("Assert that '{name}' has hidden delimiters")
    public CarouselAssert hiddenDelimiters() {
        jdiAssert(element().hasHiddenDelimiters() ? "delimiters are hidden" : "delimiters are visible",
                Matchers.is("delimiters are hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' has visible 'next' button")
    public CarouselAssert visibleNextButton() {
        jdiAssert(element().hasVisibleNextButton() ? "button is displayed" : "button is not displayed",
                Matchers.is("button is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has visible 'previous' button")
    public CarouselAssert visiblePreviousButton() {
        jdiAssert(element().hasVisiblePreviousButton() ? "button is displayed" : "button is not displayed",
                Matchers.is("button is displayed"));
        return this;
    }

    @JDIAction("Assert that '{name}' has hidden 'next' button")
    public CarouselAssert hiddenNextButton() {
        jdiAssert(element().hasHiddenNextButton() ? "button is hidden" : "button is visible",
                Matchers.is("button is hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' has hidden 'previous' button")
    public CarouselAssert hiddenPreviousButton() {
        jdiAssert(element().hasHiddenPreviousButton() ? "button is hidden" : "button is visible",
                Matchers.is("button is hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' has no control buttons")
    public CarouselAssert noControlButtons() {
        jdiAssert(element().hasNoControlButtons() ? "has no control buttons" : "has control buttons",
                Matchers.is("has no control buttons"));
        return this;
    }

    @JDIAction("Assert that '{name}'s 'next' button has expected text")
    public CarouselAssert nextButtonText(String text) {
        jdiAssert(element().nextButtonText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}'s 'previous' button has expected text")
    public CarouselAssert previousButtonText(String text) {
        jdiAssert(element().previousButtonText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}'s 'next' button has expected color")
    public CarouselAssert nextButtonColor(String color) {
        jdiAssert(element().nextButtonColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that '{name}'s 'previous' button has expected color")
    public CarouselAssert previousButtonColor(String color) {
        jdiAssert(element().previousButtonColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that '{name}'s current slide has expected color")
    public CarouselAssert currentSlideColor(String color) {
        Timer.waitCondition(() -> element().currentSlideColor().equals(color));
        jdiAssert(element().currentSlideColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that '{name}'s current slide has expected text")
    public CarouselAssert currentSlideText(String text) {
        Timer.waitCondition(() -> element().currentSlideText().equals(text));
        jdiAssert(element().currentSlideText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}'s current slide has expected image")
    public CarouselAssert currentSlideBackgroundImage(String imageContent) {
        Timer.waitCondition(() -> element().currentSlideBackgroundImage().contains(imageContent));
        jdiAssert(element().currentSlideBackgroundImage(), Matchers.containsString(imageContent));
        return this;
    }

    @JDIAction("Assert that '{name}' has switch")
    public CarouselAssert switchElement() {
        jdiAssert(element().hasSwitch(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}'s switch is checked")
    public CarouselAssert checkedSwitch() {
        jdiAssert(element().hasCheckedSwitch(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}'s switch is unchecked")
    public CarouselAssert uncheckedSwitch() {
        jdiAssert(element().hasUncheckedSwitch(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected value in slide counter")
    public CarouselAssert slideCounter(String text) {
        jdiAssert(element().slideCounter(), Matchers.containsString(text));
        return this;
    }
}
