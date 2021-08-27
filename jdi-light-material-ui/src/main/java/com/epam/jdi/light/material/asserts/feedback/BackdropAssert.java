package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Backdrop;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BackdropAssert extends UIAssert<BackdropAssert, Backdrop> {

    @JDIAction("Assert that '{name}' text is visible")
    public BackdropAssert visible() {
        jdiAssert(element().isVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is hidden")
    public BackdropAssert hidden() {
        jdiAssert(element().isHidden(), Matchers.is(true));
        return this;
    }
}
