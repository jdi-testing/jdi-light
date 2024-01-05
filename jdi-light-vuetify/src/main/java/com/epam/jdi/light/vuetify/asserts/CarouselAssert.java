package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Carousel;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CarouselAssert extends UIAssert<CarouselAssert, Carousel> implements ColorAssert<CarouselAssert, Carousel>,
        ThemeAssert<CarouselAssert, Carousel>, LoadingAssert<CarouselAssert, Carousel>,
        MeasurementAssert<CarouselAssert, Carousel> {

    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    public CarouselAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Carousel is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public CarouselAssert contentText(String text) {
        jdiAssert(element().getContentText().trim(), Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' shows arrows on hover", isAssert = true)
    public CarouselAssert showArrowsOnHover() {
        jdiAssert(element().showArrowsOnHover(), Matchers.is(true), "Carousel doesn't show arrows on hover");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' doesn't show arrows on hover", isAssert = true)
    public CarouselAssert notShowArrowsOnHover() {
        jdiAssert(element().showArrowsOnHover(), Matchers.is(false), "Carousel shows arrows on hover");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hides delimiters", isAssert = true)
    public CarouselAssert delimitersHidden() {
        jdiAssert(element().hideDelimiters(), Matchers.is(true), "Carousel doesn't hide delimiters");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hides delimiters", isAssert = true)
    public CarouselAssert notDelimitersHidden() {
        jdiAssert(element().hideDelimiters(), Matchers.is(false), "Carousel hides delimiters");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has vertical delimiters", isAssert = true)
    public CarouselAssert verticalDelimiters() {
        jdiAssert(element().hasVerticalDelimiters(), Matchers.is(true), "Carousel has horizontal delimiters");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has horizontal delimiters", isAssert = true)
    public CarouselAssert horizontalDelimiters() {
        jdiAssert(element().hasVerticalDelimiters(), Matchers.is(false), "Carousel has vertical delimiters");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has loader height {0}", isAssert = true)
    public CarouselAssert loaderHeightPx(int height) {
        int actualLoaderHeight = element().getLoaderHeight();
        jdiAssert(element().getLoaderHeight(), Matchers.equalTo(height));
        return this;
    }
}
