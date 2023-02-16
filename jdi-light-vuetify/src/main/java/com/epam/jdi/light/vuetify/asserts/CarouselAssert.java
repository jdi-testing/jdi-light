package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Carousel;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CarouselAssert extends UIAssert<CarouselAssert, Carousel> implements ColorAssert<CarouselAssert, Carousel>,
        ThemeAssert<CarouselAssert, Carousel>, LoadingAssert<CarouselAssert, Carousel>,
        MeasurementAssert<CarouselAssert, Carousel> {

    @JDIAction("Assert that '{name}' is displayed")
    public CarouselAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Element is not displayed");
        return this;
    }

    @JDIAction("Assert that '{name}' has text '{0}'")
    public CarouselAssert contentText(String text) {
        jdiAssert(element().getContentText().trim(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' shows arrows on hover")
    public CarouselAssert showArrowsOnHover() {
        jdiAssert(element().showArrowsOnHover(), Matchers.is(true), "Element doesn't show arrows on hover");
        return this;
    }

    @JDIAction("Assert that '{name}' doesn't show arrows on hover")
    public CarouselAssert notShowArrowsOnHover() {
        jdiAssert(element().showArrowsOnHover(), Matchers.is(false), "Element shows arrows on hover");
        return this;
    }

    @JDIAction("Assert that '{name}' hides delimiters")
    public CarouselAssert delimitersHidden() {
        jdiAssert(element().hideDelimiters(), Matchers.is(true), "Element doesn't hide delimiters");
        return this;
    }

    @JDIAction("Assert that '{name}' hides delimiters")
    public CarouselAssert notDelimitersHidden() {
        jdiAssert(element().hideDelimiters(), Matchers.is(false), "Element hides delimiters");
        return this;
    }

    @JDIAction("Assert that '{name}' has vertical delimiters")
    public CarouselAssert verticalDelimiters() {
        jdiAssert(element().hasVerticalDelimiters(), Matchers.is(true), "Element has horizontal delimiters");
        return this;
    }

    @JDIAction("Assert that '{name}' has horizontal delimiters")
    public CarouselAssert horizontalDelimiters() {
        jdiAssert(element().hasVerticalDelimiters(), Matchers.is(false), "Element has vertical delimiters");
        return this;
    }

    @JDIAction("Assert that '{name}' has loader height {0}")
    public CarouselAssert loaderHeightPx(int height) {
        int actualLoaderHeight = element().getLoaderHeight();
        jdiAssert(actualLoaderHeight, Matchers.equalTo(height), String.format("Actual element's loader height " +
                "'%s px' is not equal to expected '%s px'", actualLoaderHeight, height));
        return this;
    }
}
