package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Chips;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipsAssert extends UIAssert<ChipsAssert, Chips> {


    @JDIAction(value = "Assert that '{name}' enabled", isAssert = true)
    public ChipsAssert assertChipsIsEnabled() {
        jdiAssert(element().enabled(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has options", isAssert = true)
    public ChipsAssert assertChipsHasOptions(List<String> options) {
        jdiAssert(element().options(), Matchers.is(options));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder '{0}'", isAssert = true)
    public ChipsAssert assertChipsHasPlaceholder(String expected) {
        jdiAssert(element().getPlaceholderForChips(), Matchers.is(expected));
        return this;
    }
}
