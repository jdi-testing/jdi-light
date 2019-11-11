package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.composite.DropdownMenu;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Arrays;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class DropdownMenuAssert<A extends DropdownMenuAssert, E extends DropdownMenu> extends BootstrapDropdownAssert<A, E> {
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

    @JDIAction("Assert that '{name}' item is active")
    public A active(int itemIndex) {
        jdiAssert(element.list().get(itemIndex).core().getAttribute("class"), is("dropdown-item active"));
        return (A) this;
    }
}
