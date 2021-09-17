package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Paginator;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PaginatorAssert extends UIAssert<PaginatorAssert, Paginator> {
    @JDIAction("Assert that '{name}' has '{0}' label")
    public void label(String label) {
        jdiAssert(element().label(), Matchers.is(label));
    }

    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public void itemsPerPageSelected(final int number) {
        jdiAssert(element().selected(), Matchers.is(number));
    }

    @JDIAction("Assert that '{0}' options for '{name}'")
    public void itemsPerPageList(final List<Integer> options) {
        jdiAssert(element().options(), Matchers.is(options));
    }

    @JDIAction("Assert that range is '0' of '0' for '{name}'")
    public void range() {
        jdiAssert(element().range(), Matchers.is("0 of 0"));
    }

    @JDIAction("Assert that range is '{0}' – '{1}' of '{2}' for '{name}'")
    public void range(final int from, final int to, final int total) {
        String expected = format("%d – %d of %d", from, to, total);
        jdiAssert(element().range(), Matchers.is(expected));
    }

    @JDIAction("Assert that previous button enabled for '{name}'")
    public void previousEnabled() {
        jdiAssert(element().isPreviousEnabled(), Matchers.is(true));
    }

    @JDIAction("Assert that previous button disabled for '{name}'")
    public void previousDisabled() {
        jdiAssert(element().isPreviousEnabled(), Matchers.is(false));
    }

    @JDIAction("Assert that next button enabled for '{name}'")
    public void nextEnabled() {
        jdiAssert(element().isNextEnabled(), Matchers.is(true));
    }

    @JDIAction("Assert that next button disabled for '{name}'")
    public void nextDisabled() {
        jdiAssert(element().isNextEnabled(), Matchers.is(false));
    }
}
