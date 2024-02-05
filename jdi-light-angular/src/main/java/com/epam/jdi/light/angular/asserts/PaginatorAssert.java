package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Paginator;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.StringUtils.format;

public class PaginatorAssert extends UIAssert<PaginatorAssert, Paginator> {
    @JDIAction(value = "Assert that '{name}' has '{0}' label", isAssert = true)
    public void label(String label) {
        jdiAssert(element().label(), Matchers.is(label));
    }

    @JDIAction(value = "Assert that '{0}' option selected for '{name}'", isAssert = true)
    public void itemsPerPageSelected(final int number) {
        jdiAssert(element().selected(), Matchers.is(number));
    }

    @JDIAction(value = "Assert that '{0}' options for '{name}'", isAssert = true)
    public void itemsPerPageList(final List<Integer> options) {
        jdiAssert(element().options(), Matchers.is(options));
    }

    @JDIAction(value = "Assert that range is '0' of '0' for '{name}'", isAssert = true)
    public void range() {
        jdiAssert(element().range(), Matchers.is("0 of 0"));
    }

    @JDIAction(value = "Assert that range is '{0}' – '{1}' of '{2}' for '{name}'", isAssert = true)
    public void range(final int from, final int to, final int total) {
        String expected = format("%d – %d of %d", from, to, total);
        jdiAssert(element().range(), Matchers.is(expected));
    }

    @JDIAction(value = "Assert that previous button enabled for '{name}'", isAssert = true)
    public void previousEnabled() {
        jdiAssert(element().isPreviousEnabled(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
    }

    @JDIAction(value = "Assert that previous button disabled for '{name}'", isAssert = true)
    public void previousDisabled() {
        jdiAssert(element().isPreviousEnabled(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
    }

    @JDIAction(value = "Assert that next button enabled for '{name}'", isAssert = true)
    public void nextEnabled() {
        jdiAssert(element().isNextEnabled(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
    }

    @JDIAction(value = "Assert that next button disabled for '{name}'", isAssert = true)
    public void nextDisabled() {
        jdiAssert(element().isNextEnabled(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
    }
}
