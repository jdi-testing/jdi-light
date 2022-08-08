package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Lazy;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class LazyAssert extends UIAssert<LazyAssert, Lazy> {

    @Override
    @JDIAction("Assert that {name} element is displayed")
    public LazyAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }
    @JDIAction("Assert that {name} element content is exist")
    public LazyAssert existContent() {
        jdiAssert(element().isExistContent(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} element content is not exist")
    public LazyAssert notExistContent() {
        jdiAssert(element().isExistContent(), Matchers.is(false));
        return this;
    }

}

