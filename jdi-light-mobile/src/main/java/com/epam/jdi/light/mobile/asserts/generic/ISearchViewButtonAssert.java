package com.epam.jdi.light.mobile.asserts.generic;

import com.epam.jdi.light.common.JDIAction;

public interface ISearchViewButtonAssert<A> {

    @JDIAction("Assert that '{name}' is enabled")
    A enabled();
}
