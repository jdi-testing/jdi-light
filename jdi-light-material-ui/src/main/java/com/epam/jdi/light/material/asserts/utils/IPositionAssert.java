package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.common.JDIAction;

public interface IPositionAssert<A> {

    @JDIAction("Assert that '{name}' has position '{0}'")
    A position(String position);

}
