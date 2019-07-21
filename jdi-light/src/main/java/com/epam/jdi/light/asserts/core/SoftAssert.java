package com.epam.jdi.light.asserts.core;

import com.epam.jdi.tools.Safe;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.MatcherAssert.assertThat;

public class SoftAssert {
    private static Safe<List<Throwable>> listOfErrors = new Safe<>(new ArrayList<>());
    private static boolean IS_SOFT_ASSERT = false;

    public static void setAssertType(String type) {
        IS_SOFT_ASSERT = type.equalsIgnoreCase("soft");
        clearResults();
    }
    public static void assertSoft() {
        setAssertType("soft");
    }
    public static void assertStrict() {
        setAssertType("strict");
    }
    public static <T> void jdiAssert(List<T> actual, Matcher<? super List<T>> matcher) {
        try {
            assertThat(actual, matcher);
        } catch (Throwable error) {
            if (IS_SOFT_ASSERT) {
                listOfErrors.get().add(error);
            } else
                throw new AssertionError(error);
        }
    }
    public static <T> void jdiAssert(T actual, Matcher<? super T> matcher) {
        try {
            assertThat(actual, matcher);
        } catch (Throwable error) {
            if (IS_SOFT_ASSERT) {
                listOfErrors.get().add(error);
            } else
                throw new AssertionError(error);
        }
    }
    public static List<String> getErrors() {
        List<Throwable> errors = new ArrayList<>(listOfErrors.get());
        clearResults();
        return map(errors, Throwable::getMessage);
    }

    public static void assertResults() {
        List<Throwable> errors = new ArrayList<>(listOfErrors.get());
        clearResults();
        if (!errors.isEmpty())
            throw new AssertionError(errors);
    }

    public static void clearResults(){
        listOfErrors.get().clear();
    }
}
