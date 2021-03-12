package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.material.elements.feedback.Backdrop;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BackdropAssert extends UIAssert<BackdropAssert, Backdrop> {

    @Override
    public BackdropAssert visible() {
        jdiAssert(element().isVisible(), Matchers.is(true));
        return this;
    }

}
