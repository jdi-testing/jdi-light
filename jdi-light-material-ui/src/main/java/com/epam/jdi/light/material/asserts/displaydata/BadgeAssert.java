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
    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    public BadgeAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    /**
     * Checks that badge is a dot type.
     *
     * @return this {@link BadgeAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has a dot", isAssert = true)
    public BadgeAssert dot() {
        jdiAssert(element().hasDot(), Matchers.is(true), "Badge has not dot");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is without a dot", isAssert = true)
    public BadgeAssert noDot() {
        jdiAssert(element().hasDot(), Matchers.is(false), "Badge has dot");
        return this;
    }

}
