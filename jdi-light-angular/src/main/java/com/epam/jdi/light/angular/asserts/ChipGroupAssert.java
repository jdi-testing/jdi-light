package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.ChipGroup;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipGroupAssert extends UIAssert<ChipGroupAssert, ChipGroup> {

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public ChipGroupAssert displayed() {
        jdiAssert(element().isDisplayed() ? "displayed" : "hidden", Matchers.is("displayed"));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is enabled")
    public ChipGroupAssert enabled() {
        jdiAssert(element().isEnabled() ? "enabled" : "disabled", Matchers.is("enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' aria-orientation is vertical")
    public ChipGroupAssert vertical() {
        jdiAssert(element().isVertical(), Matchers.is(true), "Element is not vertical");
        return this;
    }

    @JDIAction("Assert that '{name}' aria-orientation is not vertical")
    public ChipGroupAssert notVertical() {
        jdiAssert(element().isVertical(), Matchers.is(false), "Element is not vertical");
        return this;
    }

    @JDIAction("Assert that '{name}' has multiple select options")
    public ChipGroupAssert multiselectable() {
        jdiAssert(element().multiselectable(), Matchers.is("true"));
        return this;
    }

    @JDIAction("Assert that '{name}' has multiple select options")
    public ChipGroupAssert notMultiselectable() {
        jdiAssert(element().multiselectable(), Matchers.is("false"));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' element")
    public ChipGroupAssert hasElement(String expected) {
        jdiAssert(element().hasElement(expected), Matchers.is(true), "Element is has not " + expected + " element");
        return this;
    }

    @JDIAction("Assert that '{name}' has error state")
    public ChipGroupAssert errorState() {
        jdiAssert(element().errorState(), Matchers.is(true), "Element is has not error state");
        return this;
    }
}
