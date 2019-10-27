package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Dropdown;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Arrays;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class DropdownAssert<A extends DropdownAssert, E extends Dropdown> extends UIAssert<A, E> {

    @JDIAction("Assert that dropdown '{name}' expanded")
    public A expanded() {
        jdiAssert(element.isExpanded(), is(true));
        return (A) this;
    }

    @JDIAction("Assert that dropdown '{name}' collapsed")
    public A collapsed() {
        jdiAssert(element.isCollapsed(), is(true));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' items values {0}")
    public A itemValues(Matcher<Iterable<String>> condition) {
        jdiAssert(element.itemValues(), condition);
        return (A) this;
    }

    @JDIAction("Assert that '{name}' items values are {0}")
    public A itemValues(String... values) {
        jdiAssert(element.itemValues(), is(Arrays.asList(values)));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' items values are {0}")
    public A hasItems(String... values) {
        itemValues(Matchers.hasItems(values));
        return (A) this;
    }


}
