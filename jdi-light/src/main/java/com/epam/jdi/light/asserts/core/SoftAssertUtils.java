package com.epam.jdi.light.asserts.core;

import com.epam.jdi.tools.Safe;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.hamcrest.MatcherAssert.assertThat;

public class SoftAssertUtils {
    private static Safe<List<String>> listOfErrors = new Safe<>(new ArrayList<>());
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
                addError(error);
            } else
                throw new AssertionError(error);
        }
    }
    public static <T> void jdiAssert(T actual, Matcher<? super T> matcher) {
        try {
            assertThat(actual, matcher);
            logger.debug(">>> " + actual);
        } catch (Throwable error) {
            if (IS_SOFT_ASSERT) {
                addError(error);
            } else
                throw new AssertionError(error);
        }
    }
    private static void addError(Throwable error) {
        listOfErrors.get().add(error.getMessage().replace("java.lang.AssertionError: ", ""));
    }
    public static List<String> getErrors() {
        List<String> errors = new ArrayList<>(listOfErrors.get());
        clearResults();
        return errors;
    }

    public static void assertResults() {
        List<String> errors = new ArrayList<>(listOfErrors.get());
        clearResults();
        if (!errors.isEmpty())
            throw new AssertionError(print(errors));
    }

    public static void clearResults(){
        listOfErrors.get().clear();
    }
}
