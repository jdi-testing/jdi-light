package com.epam.jdi.light.mobile.asserts.generic;

import com.epam.jdi.light.common.JDIAction;

public interface ISearchAssert<A> {

    @JDIAction("Assert that '{name}' is iconified")
    A iconifiedByDefault();

    @JDIAction("Assert that '{name}' is expanded")
    A searchViewExpanded();

    @JDIAction("Assert that '{name}' is enabled")
    A searchViewEnabled();

    @JDIAction("Assert that '{name}' has Text")
    A searchViewText(String expected);
}
