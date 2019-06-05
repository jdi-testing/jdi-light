package com.epam.jdi.light.asserts;

import com.epam.jdi.tools.func.JFunc1;

public interface CommonAssert<A> {
    A displayed();
    A disappear();
    A hidden();
    A notAppear();
    A notAppear(int timeoutSec);
    A enabled();
    A disabled();

    default A and() { return (A) this; }
    default A condition(JFunc1<A, A> t) {
        return t.execute((A) this);
    }

    default void assertResults() {
        SoftAssert.assertResults();
    }
}
