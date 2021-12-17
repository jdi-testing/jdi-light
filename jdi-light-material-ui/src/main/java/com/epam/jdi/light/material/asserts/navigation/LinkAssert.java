package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.displaydata.TypographyAssert;
import com.epam.jdi.light.material.elements.navigation.Link;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class LinkAssert extends TypographyAssert {

    @Override
    public Link element() {
        return (Link) super.element();
    }

    @JDIAction("Assert that '{name}' is underlined")
    public LinkAssert underlined() {
        jdiAssert(element().isUnderlined() ? "is underlined" : "is not underlined",
                Matchers.is("is underlined"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not underlined")
    public LinkAssert notUnderlined() {
        jdiAssert(element().isNotUnderlined() ? "is not underlined" : "is underlined",
                Matchers.is("is not underlined"));
        return this;
    }

    @JDIAction("Assert that '{name}' is color {0}")
    public LinkAssert color(String rgbaColor) {
        jdiAssert(element().getColor(), Matchers.is(rgbaColor));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public LinkAssert text(String text) {
        jdiAssert(element().linkText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' text '{0}'")
    public LinkAssert text(Matcher<String> condition) {
        jdiAssert(element().linkText(), condition);
        return this;
    }

    @Override
    public LinkAssert and() {
        return this;
    }
}
