package com.epam.jdi.light.asserts.core;

import org.hamcrest.Matcher;

import java.util.List;

public interface JComparisonList<T>{
    void is(List<T> actual, Matcher<? super List<T>> matcher);
}
