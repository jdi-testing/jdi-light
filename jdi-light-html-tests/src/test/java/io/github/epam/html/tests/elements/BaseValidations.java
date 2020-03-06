package io.github.epam.html.tests.elements;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.pairs.Pair.$;
import static java.lang.System.currentTimeMillis;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BaseValidations {

    public static void baseValidation(ICoreElement el) {
        // EXCLUDED el.hover();
        logger.info("Check enabled");
        assertTrue(el.isEnabled());
        logger.info("Check displayed");
        assertTrue(el.isDisplayed());
        logger.info("Check disabled");
        assertFalse(el.isDisabled());
        logger.info("Check hidden");
        assertFalse(el.isHidden());
        logger.info("Check getLocation");
        Point location = el.core().getLocation();
        assertTrue(location.x > 0 && location.y > 0, "Location: " + location);
        logger.info("Check getSize");
        Dimension size = el.core().getSize();
        assertTrue(size.height > 0 && size.width > 0, "Size: " + location);
        //Rectangle rect = el.getRect();
        //assertTrue(rect.height > 0 && rect.width > 0 && rect.x > 0 && rect.y > 0, "Size: " + location);
        logger.info("Check setAttribute");
        el.core().setAttribute("test-jdi", "test-value");
        assertEquals(el.attr("test-jdi"), "test-value");
        logger.info("Check highlight");
        el.highlight("blue");
        el.highlight();
        logger.info("Check show");
        el.show();
    }

    public static void durationMoreThan(int duration, JAction action) {
        validateDuration(duration*1000-500, duration*1000+1000, action);
    }
    public static void durationLessThan(int duration, JAction action) {
        validateDuration(duration*1000-1000, duration*1000+500, action);
    }
    public static void duration(int duration, JAction action) {
        validateDuration(duration*1000-500, duration*1000+500, action);
    }
    public static void notMoreThan(int maxMs, JAction action) {
        validateDuration(0, maxMs, action);
    }
    public static <T> T notMoreThan(int maxMs, JFunc<T> func) {
        return validateDuration(0, maxMs, func);
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
        assertThat(passedTime, greaterThan(min));
        assertThat(passedTime, lessThan(max));
    }
    private static <T> T validateDuration(long min, long max, JFunc<T> func) {
        Pair<Long, T> result = getDuration(func);
        assertThat(result.key, greaterThan(min));
        assertThat(result.key, lessThan(max));
        return result.value;
    }
}
