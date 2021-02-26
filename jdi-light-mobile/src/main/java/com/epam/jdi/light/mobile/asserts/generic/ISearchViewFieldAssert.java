package com.epam.jdi.light.mobile.asserts.generic;

import com.epam.jdi.light.common.JDIAction;

public interface ISearchViewFieldAssert<A> {

    @JDIAction("Assert that '{name}' is expanded")
    A expanded();

    @JDIAction("Assert that '{name}' is enabled")
    A enabled();

    @JDIAction("Assert that '{name}' has text")
    A text(String expected);
}
