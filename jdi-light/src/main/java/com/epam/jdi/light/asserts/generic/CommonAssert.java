package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.tools.func.JFunc1;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface CommonAssert<A> extends JAssert {
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
