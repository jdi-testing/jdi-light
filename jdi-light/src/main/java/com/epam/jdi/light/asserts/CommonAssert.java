package com.epam.jdi.light.asserts;

import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;

public interface CommonAssert<T> {
    T attr(String attrName, Matcher<String> condition);
    T css(String css, Matcher<String> condition);
    T tag(Matcher<String> condition);
    T hasClass(String className);
    T cssClass(Matcher<String> condition);
    T displayed();
    T disappear();
    T hidden();
    T notAppear();
    T notAppear(int timeoutSec);
    T selected();
    T deselected();
    T enabled();
    T disabled();

    default T and() { return (T) this; }
    default T condition(JFunc1<T, T> t) {
        return t.execute((T) this);
    }

    default void assertResults() {
        SoftAssert.assertResults();
    }
}
