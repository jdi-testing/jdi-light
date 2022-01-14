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

    @JDIAction("Assert that '{name}' has primary color")
    public BadgeAssert primaryColor() {
        jdiAssert(element().hasPrimaryColor() ? "has primary color" : "does not have primary color",
                Matchers.is("has primary color"));
        return this;
    }

    @JDIAction("Assert that '{name}' has secondary color")
    public BadgeAssert secondaryColor() {
        jdiAssert(element().hasSecondaryColor() ? "has secondary color" : "does not have secondary color",
                Matchers.is("has secondary color"));
        return this;
    }

    @JDIAction("Assert that '{name}' has error color")
    public BadgeAssert errorColor() {
        jdiAssert(element().hasErrorColor() ? "has error color" : "does not have error color",
                Matchers.is("has error color"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected position")
    public BadgeAssert position(String position) {
        jdiAssert(element().getPosition(), Matchers.containsString(position));
        return this;
    }

}
