package com.epam.jdi.light.asserts.core;

import com.epam.jdi.tools.Safe;
import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.Timer.nowTimeShort;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class SoftAssert {
    private static Safe<List<String>> listOfErrors = new Safe<>(new ArrayList<>());
    private static Safe<Boolean> IS_SOFT_ASSERT = new Safe<>(() -> false);

    public static void setAssertType(String type) {
        IS_SOFT_ASSERT.set(type.equalsIgnoreCase("soft"));
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
            if (IS_SOFT_ASSERT.get()) {
                addError(error);
            } else
                throw new AssertionError(error);
        }
    }
    public static <T> void jdiAssert(T actual, Matcher<? super T> matcher, String errorMsg) {
        try {
            assertThat(actual, matcher);
            logger.debug(">>> " + actual);
        } catch (Throwable error) {
            String errorMessage = nowTimeShort() + " " + getErrorMsg(errorMsg, error);
            AssertionError failError = new AssertionError(errorMessage);
            if (IS_SOFT_ASSERT.get()) {
                addError(failError);
            } else
                throw failError;
        }
    }
    private static String getErrorMsg(String errorMsg, Throwable error) {
        return errorMsg != null ? errorMsg : error.getMessage();
    }
    public static <T> void jdiAssert(T actual, Matcher<? super T> matcher) {
        jdiAssert(actual, matcher, null);
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
        if (!errors.isEmpty()) {
            throw new AssertionError(print(errors));
        }
    }

    public static void clearResults() {
        listOfErrors.get().clear();
    }
}
