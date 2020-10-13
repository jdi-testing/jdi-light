package com.epam.jdi.light.mobile.asserts.generic;

import com.epam.jdi.light.common.JDIAction;

import java.util.List;

public interface ISearchAssert<A> {

    @JDIAction("Assert that '{name}' is iconified")
    A iconifiedByDefault();

    @JDIAction("Assert that '{name}' is expanded")
    A expanded();

    @JDIAction("Assert that '{name}' is enabled")
    A enabled();

    @JDIAction("Assert that '{name}' has text")
    A text(String expected);
}
