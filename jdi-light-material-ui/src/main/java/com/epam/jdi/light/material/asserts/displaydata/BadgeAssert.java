package com.epam.jdi.light.material.asserts.displaydata;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import org.hamcrest.Matchers;

public class BadgeAssert extends UIAssert<BadgeAssert, Badge> {

    @JDIAction("Assert that '{name}' has text {0}")
    public BadgeAssert text(String value) {
        jdiAssert(element().text(), Matchers.containsString(value));
        return this;
    }

    @JDIAction("Assert that '{name}' is a dot")
    public BadgeAssert dot() {
        jdiAssert(element().isDot() ? "is a dot" : "is not a dot", Matchers.is("is a dot"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected position")
    public BadgeAssert position(String position) {
        jdiAssert(element().getPosition(), Matchers.containsStringIgnoringCase(position));
        return this;
    }

}
