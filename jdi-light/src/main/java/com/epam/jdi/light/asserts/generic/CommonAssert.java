package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface CommonAssert<A> extends JAssert, HasAssert<A> {
    A displayed();
    A disappear();
    A hidden();
    A shown();
    A notAppear();
    A notAppear(int timeoutSec);
    A enabled();
    A disabled();
    A attr(String attrName, Matcher<String> condition);
    A attr(String attrName, String value);
    A css(String css, Matcher<String> condition);
    A css(String css, String value);
    A hasClass(String className);
    A hasAttribute(String className);
    A visible();

    default A and() { return (A) this; }
    default A condition(JFunc1<A, A> t) {
        return t.execute((A) this);
    }

    default void assertResults() {
        SoftAssert.assertResults();
    }
}
