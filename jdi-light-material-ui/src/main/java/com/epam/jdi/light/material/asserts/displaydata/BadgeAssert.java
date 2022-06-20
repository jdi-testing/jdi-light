package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.utils.IPositionAssert;
import com.epam.jdi.light.material.elements.displaydata.Badge;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Badge}
 */
public class BadgeAssert extends UIAssert<BadgeAssert, Badge> implements ITextAssert<BadgeAssert>, IPositionAssert<BadgeAssert> {

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
    @JDIAction("Assert that '{name}' is a dot")
    public BadgeAssert dot() {
        jdiAssert(element().isDot() ? "is a dot" : "is not a dot", Matchers.is("is a dot"));
        return this;
    }

    /**
     * Checks that badge has given position.
     *
     * @param position expected badge position
     * @return this {@link BadgeAssert} instance
     */
    @Override
    @JDIAction("Assert that '{name}' has position '{0}'")
    public BadgeAssert position(String position) {
        jdiAssert(element().position(), Matchers.is(Position.fromString(position)));
        return this;
    }

}
