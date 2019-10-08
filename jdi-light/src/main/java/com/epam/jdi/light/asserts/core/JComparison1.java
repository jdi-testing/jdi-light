package com.epam.jdi.light.asserts.core;

import org.hamcrest.Matcher;

public interface JComparison1<T>{
    void is(T actual, Matcher<? super T> matcher);
}
