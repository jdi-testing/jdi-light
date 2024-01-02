package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.asserts.HasImageAssert;
import com.epam.jdi.light.vuetify.elements.composite.Parallax;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ParallaxAssert extends UIAssert<ParallaxAssert, Parallax> implements HasImageAssert<ParallaxAssert, Parallax> {

    @JDIAction(value = "Assert that '{name}' container height is '{0} px'")
    public ParallaxAssert height(int height) {
        int actualHeight = element().height();
        jdiAssert(actualHeight, Matchers.equalTo(height));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has elements in content section")
    public ParallaxAssert content() {
        jdiAssert(element().hasContent(), Matchers.is(true), "Element has no content");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no elements in content section")
    public ParallaxAssert noContent() {
        jdiAssert(element().hasContent(), Matchers.is(false), "Element has content");
        return this;
    }
}
