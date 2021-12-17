package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.List;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ListAssert extends UIAssert<ListAssert, List> {

    @JDIAction("Assert that '{name}' is dense")
    public ListAssert dense() {
        jdiAssert(element().isDense() ? "is dense" : "is not dense", Matchers.is("is dense"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not dense")
    public ListAssert notDense() {
        jdiAssert(!element().isDense() ? "is not dense" : "is dense", Matchers.is("is not dense"));
        return this;
    }

    @JDIAction("Assert that '{name}' has size '{0}'")
    public ListAssert size(int expectedSize) {
        jdiAssert(element().size(), Matchers.is(expectedSize));
        return this;
    }

    @JDIAction("Assert that 'name' is empty")
    public ListAssert empty() {
        jdiAssert(element().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction("Assert that 'name' is empty")
    public ListAssert notEmpty() {
        jdiAssert(!element().isEmpty() ? "is not empty" : "is empty", Matchers.is("is not empty"));
        return this;
    }

    @JDIAction("Assert that '{name}' has subheader text '{0}'")
    public ListAssert subheaderText(String expectedText) {
        jdiAssert(element().subheaderText(), Matchers.is(expectedText));
        return this;
    }
}
