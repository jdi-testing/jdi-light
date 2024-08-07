package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.asserts.HasImageAssert;
import com.epam.jdi.light.vuetify.elements.composite.Parallax;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ParallaxAssert extends UIAssert<ParallaxAssert, Parallax> implements HasImageAssert<ParallaxAssert, Parallax> {

    @JDIAction(value = "Assert that '{name}' container height is '{0} px'", isAssert = true)
    public ParallaxAssert height(int height) {
        jdiAssert(element().height(), Matchers.equalTo(height));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has elements in content section", isAssert = true)
    public ParallaxAssert content() {
        jdiAssert(element().hasContent(), Matchers.is(true), "Parallax has no content");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no elements in content section", isAssert = true)
    public ParallaxAssert noContent() {
        jdiAssert(element().hasContent(), Matchers.is(false), "Parallax has content");
        return this;
    }
}
