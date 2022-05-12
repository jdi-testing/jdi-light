package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.Popover;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Popover}
 */
public class PopoverAssert extends UIAssert<PopoverAssert, Popover> implements ITextAssert<PopoverAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public PopoverAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }
}
