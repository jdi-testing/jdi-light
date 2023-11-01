package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.Chip;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {

    @JDIAction("Assert that '{name}' enabled")
    public ChipAssert selected() {
        jdiAssert(element().selected(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' ")
    public ChipAssert removable() {
        jdiAssert(element().removable(), Matchers.is(true));
        return this;
    }

}
