package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popper;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

/**
 * Assertions for {@link Popper}
 */
public class PopperAssert extends PositionAssert<PopperAssert, Popper> implements ITextAssert<PopperAssert> {

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
