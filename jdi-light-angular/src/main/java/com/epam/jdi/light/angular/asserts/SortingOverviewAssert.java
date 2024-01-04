package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.SortingOverview;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SortingOverviewAssert extends UIAssert<SortingOverviewAssert, SortingOverview> {

    @JDIAction("Assert that table is visible")
    public SortingOverviewAssert tableIsVisible() {
        jdiAssert(element().isHeadersDisplayed(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction("Assert arrow button clicked")
    public SortingOverviewAssert arrowButtonClicked() {
        jdiAssert(element().headerButtonIsClicked(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }
}
