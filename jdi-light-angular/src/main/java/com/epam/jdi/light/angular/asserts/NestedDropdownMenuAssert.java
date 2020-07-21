package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.NestedDropdownMenu;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class NestedDropdownMenuAssert extends UIAssert<NestedDropdownMenuAssert, NestedDropdownMenu> {
    @JDIAction("Assert that {name} is expanded")
    public NestedDropdownMenuAssert isExpanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is closed")
    public NestedDropdownMenuAssert isClosed() {
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} option values are correct")
    public NestedDropdownMenuAssert checkValue(String expectedValue, String actualValue) {
        jdiAssert(element().checkValue(expectedValue, actualValue), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} option is disabled")
    public NestedDropdownMenuAssert isDisabledMenuWithIconsOption(String value) {
        jdiAssert(element().isDisabledMenuWithIconsOption(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} option is disabled")
    public NestedDropdownMenuAssert isDisabledNestedMenuOption(String... values) {
        jdiAssert(element().isDisabledNestedMenuOption(values), Matchers.is(true));
        return this;
   }
}
