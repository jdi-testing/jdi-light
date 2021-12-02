package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.Parallax;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ParallaxAssert extends UIAssert<ParallaxAssert, Parallax> {

    @JDIAction("Assert that '{name}' parallax container height is {0} pixels")
    public ParallaxAssert height(int expectedHeight) {
        int elemHeight = Integer.parseInt(element().height().replace("px", ""));
        jdiAssert(elemHeight, Matchers.equalTo(expectedHeight));
        return this;
    }

    @JDIAction("Assert that there are elements in '{name}' content section")
    public ParallaxAssert content() {
        jdiAssert(element().hasContent() ? "has content" : "has no content", Matchers.is("has content"));
//        jdiAssert(element().hasContent(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that there are no elements in '{name}' content section")
    public ParallaxAssert noContent() {
        jdiAssert(element().hasContent() ? "has content" : "has no content", Matchers.is("has no content"));
//        jdiAssert(element().hasContent(), Matchers.is(false));
        return this;
    }
}
