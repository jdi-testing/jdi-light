package com.jdiai.utils;

import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.pairs.Pair;

import static com.epam.jdi.tools.pairs.Pair.$;
import static java.lang.System.currentTimeMillis;
import static org.testng.Assert.assertTrue;

public class TimeValidations {
    public static long RANGE = 1000L;
    public static void durationMoreThan(int duration, JAction action) {
        validateDuration(duration * 1000L - RANGE, duration * 1000L + 2 * RANGE, action);
    }
    public static void durationLessThan(int duration, JAction action) {
        validateDuration(duration * 1000L - 2 * RANGE, duration * 1000L + RANGE, action);
    }
    public static void duration(int duration, JAction action) {
        validateDuration(duration * 1000L - RANGE, duration * 1000L + RANGE, action);
    }
    public static void notMoreThan(int maxMs, JAction action) {
        validateDuration(0, maxMs + RANGE, action);
    }
    public static <T> T notMoreThan(int maxMs, JFunc<T> func) {
        return validateDuration(0, maxMs + RANGE, func);
    }
    public static void durationImmediately(JAction action) {
        durationMoreThan(0, action);
    }
    public static long getDuration(JAction action) {
        long start = currentTimeMillis();
        action.execute();
        return currentTimeMillis() - start;
    }
    private static <T> Pair<Long, T> getDuration(JFunc<T> action) {
        long start = currentTimeMillis();
        T result = action.execute();
        return $(currentTimeMillis() - start, result);
    }
    private static void validateDuration(long min, long max, JAction action) {
        long passedTime = getDuration(action);
        assertTrue(passedTime > min && passedTime < max, min + "<" + passedTime + "<" + max);
    }
    private static <T> T validateDuration(long min, long max, JFunc<T> func) {
        Pair<Long, T> result = getDuration(func);
        assertTrue(result.key > min && result.key < max, min + "<" + result.key + "<" + max);
        return result.value;
    }
}
