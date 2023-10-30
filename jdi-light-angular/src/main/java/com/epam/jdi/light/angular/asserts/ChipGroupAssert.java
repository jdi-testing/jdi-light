package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.ChipGroup;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipGroupAssert extends UIAssert<ChipGroupAssert, ChipGroup> {

    @JDIAction("")
    public ChipGroupAssert vertical(){
        jdiAssert(element().getOrientation(), Matchers.is("vertical"));
        return this;
    }

    @JDIAction("Assert that '{name}' has placeholder '{0}'")
    public ChipGroupAssert assertChipsHasPlaceholder(String expected) {
        jdiAssert(element().getPlaceholderForChips(), Matchers.is(expected));
        return this;
    }

    @JDIAction("Assert that '{name}' has options")
    public ChipGroupAssert assertChipsHasOptions(List<String> options) {
        jdiAssert(element().options(), Matchers.is(options));
        return this;
    }

    public ChipGroupAssert multiselectable() {
        jdiAssert(element().isMultiselectable(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public ChipGroupAssert displayed() {
        jdiAssert(element().isDisplayed() ? "displayed" : "hidden", Matchers.is("displayed"));
        return this;
    }


}
