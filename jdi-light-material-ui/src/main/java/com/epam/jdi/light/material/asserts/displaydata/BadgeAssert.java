package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.utils.PositionAssert;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Badge}
 */
public class BadgeAssert extends PositionAssert<BadgeAssert, Badge> implements ITextAssert<BadgeAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public BadgeAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    /**
     * Checks that badge is a dot type.
     *
     * @return this {@link BadgeAssert} instance
     */
    @JDIAction("Assert that '{name}' has a dot")
    public BadgeAssert dot() {
        jdiAssert(element().hasDot() ? "is a dot" : "is not a dot", Matchers.is("is a dot"));
        return this;
    }

    @JDIAction("Assert that '{name}' is without a dot")
    public BadgeAssert noDot() {
        jdiAssert(element().hasDot() ? "is a dot" : "is not a dot", Matchers.is("is not a dot"));
        return this;
    }

}
