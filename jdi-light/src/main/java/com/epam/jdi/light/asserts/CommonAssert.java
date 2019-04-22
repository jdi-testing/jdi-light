package com.epam.jdi.light.asserts;

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
    //void soft(JFunc<T> isAssert);
}
