package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popper;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

/**
 * Assertions for {@link Popper}
 */
public class PopperAssert extends UIAssert<PopperAssert, Popper> implements ITextAssert<PopperAssert> {

    /**
     * Checks that popper has given position.
     *
     * @return this {@link PopperAssert} instance
     */
    @JDIAction("Assert that '{name}' has position '{0}'")
    public PopperAssert position(Position position) {
        jdiAssert(element().position(), Matchers.is(position));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public PopperAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is not visible by user")
    public PopperAssert notVisible() {
        waitCondition(() -> element().isNotVisible());
        super.notVisible();
        return this;
    }
}
