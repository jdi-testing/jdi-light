package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Link;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class LinkAssert extends UIAssert<LinkAssert, Link> {
    @JDIAction("Assert that '{name}' is color primary")
    public LinkAssert colorPrimary() {
        jdiAssert(element().isColorPrimary(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is color secondary")
    public LinkAssert colorSecondary() {
        jdiAssert(element().isColorSecondary(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is color text primary")
    public LinkAssert colorTextPrimary() {
        jdiAssert(element().isColorTextPrimary(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is color text secondary")
    public LinkAssert colorTextSecondary() {
        jdiAssert(element().isColorTextSecondary(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is color error")
    public LinkAssert colorError() {
        jdiAssert(element().isColorError(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is underline always")
    public LinkAssert underlineAlways() {
        jdiAssert(element().isUnderlineAlways(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is underline hover")
    public LinkAssert underlineHover() {
        jdiAssert(element().isUnderlineHover(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public LinkAssert text(Matcher<String> condition) {
        jdiAssert(element().getLinkText(), condition);
        return this;
    }
}
