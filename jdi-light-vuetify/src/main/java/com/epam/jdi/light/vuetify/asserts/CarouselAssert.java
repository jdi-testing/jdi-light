package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Carousel;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CarouselAssert extends UIAssert<CarouselAssert, Carousel> {

    @JDIAction("Assert that {name} is displayed")
    public CarouselAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        element().scrollIntoView();
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert delimiterIcons(String iconName) {
        jdiAssert(element().hasDelimitersIcons(iconName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert numberOfDelimiters(int numberOfDelimiters) {
        jdiAssert(element().hasNumberOfDelimiters(), Matchers.equalTo(numberOfDelimiters));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert nextButtonVisible() {
        jdiAssert(element().hasNextButtonVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert previousButtonVisible() {
        jdiAssert(element().hasPreviousButtonVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert nextButtonHidden() {
        jdiAssert(element().hasNextButtonHidden(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert previousButtonHidden() {
        jdiAssert(element().hasPreviousButtonHidden(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert currentSlideColor(String color) {
        Timer.waitCondition(() -> element().getCurrentSlideColor().equals(color));
        jdiAssert(element().getCurrentSlideColor(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert currentSlideText(String text) {
        Timer.waitCondition(() -> element().getCurrentSlideText().equals(text));
        jdiAssert(element().getCurrentSlideText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public CarouselAssert currentSlideImage(String imageContent) {
        Timer.waitCondition(() -> element().getCurrentBackgroundImage().contains(imageContent));
        jdiAssert(element().getCurrentBackgroundImage(), Matchers.containsString(imageContent));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is checked")
    public CarouselAssert toggle() {
        jdiAssert(element().hasToggle(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is checked")
    public CarouselAssert toggleChecked() {
        jdiAssert(element().hasToggleChecked(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is checked")
    public CarouselAssert toggleUnchecked() {
        jdiAssert(element().hasToggleUnchecked(), Matchers.is(true));
        return this;
    }

}
