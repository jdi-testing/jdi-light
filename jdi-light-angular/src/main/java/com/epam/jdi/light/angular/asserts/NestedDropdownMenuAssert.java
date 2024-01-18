package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.NestedDropdownMenu;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class NestedDropdownMenuAssert extends UIAssert<NestedDropdownMenuAssert, NestedDropdownMenu> {
    @JDIAction(value = "Assert that {name} is expanded", isAssert = true)
    public NestedDropdownMenuAssert isExpanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that {name} is closed", isAssert = true)
    public NestedDropdownMenuAssert isClosed() {
        jdiAssert(element().isClosed(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that {name} expected value '{0} and actual value '{1}' are equals", isAssert = true)
    public NestedDropdownMenuAssert checkValue(String expectedValue, String actualValue) {
        jdiAssert(element().checkValue(expectedValue, actualValue), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that {name} option '{0}' is disabled", isAssert = true)
    public NestedDropdownMenuAssert isDisabledMenuWithIconsOption(String value) {
        jdiAssert(element().isDisabledMenuWithIconsOption(value), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that {name} option '{0}' is disabled", isAssert = true)
    public NestedDropdownMenuAssert isDisabledNestedMenuOption(String... values) {
        jdiAssert(element().isDisabledNestedMenuOption(values), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }
}
