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

    @JDIAction(value = "Assert that '{name}' has {0} alternate image text", isAssert = true)
    public ImageAssert altText(String expectedText) {
        jdiAssert(element().alternateText(), Matchers.equalTo(expectedText));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is contain", isAssert = true)
    public ImageAssert contain() {
        jdiAssert(element().isContain(), Matchers.is(true), "Image is not contain");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not contain", isAssert = true)
    public ImageAssert notContain() {
        jdiAssert(element().isContain(), Matchers.is(false), "Image is contain");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    public ImageAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Image is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected {0} source path", isAssert = true)
    public ImageAssert sourcePath(String expectedSourcePath) {
        jdiAssert(element().getSourcePath(), Matchers.containsString(expectedSourcePath));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has gradient", isAssert = true)
    public ImageAssert gradient() {
        jdiAssert(element().hasGradient(), Matchers.is(true), "Image doesn't have gradient");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not gradient", isAssert = true)
    public ImageAssert noGradient() {
        jdiAssert(element().hasGradient(), Matchers.is(false), "Image has gradient");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder", isAssert = true)
    public ImageAssert placeholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(true), "Image has not placeholder");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not placeholder", isAssert = true)
    public ImageAssert noPlaceholder() {
        jdiAssert(element().hasPlaceholder(), Matchers.is(false), "Image has placeholder");
        return this;
    }
}
