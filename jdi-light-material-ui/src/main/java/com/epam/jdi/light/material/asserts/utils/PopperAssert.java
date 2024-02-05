package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popper;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Popper}
 */
public class PopperAssert extends PositionAssert<PopperAssert, Popper> implements ITextAssert<PopperAssert> {

    @Override
    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    public PopperAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is not visible by user", isAssert = true)
    public PopperAssert notVisible() {
        super.notVisible();
        return this;
    }
}
