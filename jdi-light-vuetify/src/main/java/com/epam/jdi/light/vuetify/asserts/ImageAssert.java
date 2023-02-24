package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ImageAssert extends UIAssert<ImageAssert, Image> implements MeasurementAssert<ImageAssert, Image>,
        ThemeAssert<ImageAssert, Image> {

    @JDIAction("Assert that '{name}' has {0} alternate image text")
    public ImageAssert altText(String expectedText) {
        jdiAssert(element().alternateText(), Matchers.equalTo(expectedText));
        return this;
    }

    @JDIAction("Assert that '{name}' is contain")
    public ImageAssert contain() {
        jdiAssert(element().isContain(), Matchers.is(true), "Image is not contain");
        return this;
    }

    @JDIAction("Assert that '{name}' is not contain")
    public ImageAssert notContain() {
        jdiAssert(element().isContain(), Matchers.is(false), "Image is contain");
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public ImageAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Image is not displayed");
        return this;
    }

    @JDIAction("Assert that '{name}' has expected {0} source path")
    public ImageAssert sourcePath(String expectedSourcePath) {
        jdiAssert(element().sourcePath(), Matchers.is(expectedSourcePath));
        return this;
    }

    @JDIAction("Assert that '{name}' has gradient")
    public ImageAssert gradient() {
        jdiAssert(element().hasGradient(), Matchers.is(true), "Image doesn't have gradient");
        return this;
    }

    @JDIAction("Assert that '{name}' has not gradient")
    public ImageAssert noGradient() {
        jdiAssert(element().hasGradient(), Matchers.is(false), "Image has gradient");
        return this;
    }

    @JDIAction("Assert that '{name}' has placeholder")
    public ImageAssert placeholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(true), "Image has no placeholder");
        return this;
    }

    @JDIAction("Assert that '{name}' has not placeholder")
    public ImageAssert noPlaceholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(false), "Image has placeholder");
        return this;
    }

    @JDIAction("Assert that '{name}' is loaded")
    public ImageAssert loaded() {
        jdiAssert(element().isLoaded(), Matchers.is(true), "Image is loaded");
        return this;
    }

    @JDIAction("Assert that '{name}' is not loaded")
    public ImageAssert notLoaded() {
        jdiAssert(element().isLoaded(), Matchers.is(false), "Image is loaded");
        return this;
    }
}
