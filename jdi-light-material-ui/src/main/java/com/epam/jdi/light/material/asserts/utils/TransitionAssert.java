package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Transition;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TransitionAssert extends UIAssert<TransitionAssert, Transition> {

    @JDIAction("Assert that '{name}' is hidden")
    public TransitionAssert hidden() {
        jdiAssert(element().isHidden(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is visible")
    public TransitionAssert visible() {
        jdiAssert(element().isVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' content is '{0}'")
    public TransitionAssert content(Matcher<String> condition) {
        jdiAssert(element().getContent(), condition);
        return this;
    }

    public TransitionAssert content(String text) {
        return content(Matchers.is(text));
    }


}
