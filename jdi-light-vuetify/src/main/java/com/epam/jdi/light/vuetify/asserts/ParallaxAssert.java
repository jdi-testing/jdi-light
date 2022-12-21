package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.Parallax;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ParallaxAssert extends UIAssert<ParallaxAssert, Parallax> {

    @JDIAction("Assert that '{name}' container height is '{0} px'")
    public ParallaxAssert heightPx(int height) {
        int actualHeight = element().heightPx();
        jdiAssert(actualHeight, Matchers.equalTo(height), String.format("Actual element's height '%s px' is not " +
                "equal to expected '%s px'", actualHeight, height));
        return this;
    }

    @JDIAction("Assert that '{name}' has elements in content section")
    public ParallaxAssert content() {
        jdiAssert(element().hasContent(), Matchers.is(true), "Element has no content");
        return this;
    }

    @JDIAction("Assert that '{name}' has no elements in content section")
    public ParallaxAssert noContent() {
        jdiAssert(element().hasContent(), Matchers.is(false), "Element has content");
        return this;
    }
}
