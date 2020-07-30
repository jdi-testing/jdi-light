package io.github.epam.angular.tests.elements;

import com.epam.jdi.tools.func.JAction;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class BaseValidationsUtils {

    public static void duration(int duration, JAction action) {
        validateDuration(duration * 1000 - 500, duration * 1000 + 500, action);
    }

    public static void duration(int duration, int alpha, JAction action) {
        validateDuration(duration * 1000 - alpha, duration * 1000 + alpha, action);
    }

    private static void validateDuration(long min, long max, JAction action) {
        long passedTime = getDuration(action);
        assertThat(passedTime, greaterThan(min));
        assertThat(passedTime, lessThan(max + 500));
    }

    public static long getDuration(JAction action) {
        long start = currentTimeMillis();
        action.execute();
        return currentTimeMillis() - start;
    }
}
