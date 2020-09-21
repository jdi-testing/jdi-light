package io.github.epam.angular.tests.elements;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.func.JAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.System.currentTimeMillis;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BaseValidationsUtils {
    public static final int ONE_SECOND_DURATION = 1000;
    public static final int HALF_SECOND_DURATION = 500;

    public static void baseValidation(final ICoreElement el) {
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
        logger.info("Check setAttribute");
        el.setAttribute("test-jdi", "test-value");
        assertEquals(el.attr("test-jdi"), "test-value");
        logger.info("Check highlight");
        el.highlight("blue");
        el.highlight();
        logger.info("Check show");
        el.show();
    }

    public static void duration(final int duration, final JAction action) {
        validateDuration(duration * ONE_SECOND_DURATION - HALF_SECOND_DURATION,
                         duration * ONE_SECOND_DURATION + HALF_SECOND_DURATION, action);
    }

    public static void duration(final int duration, final int alpha, final JAction action) {
        validateDuration(duration * ONE_SECOND_DURATION - alpha, duration * ONE_SECOND_DURATION + alpha, action);
    }

    private static void validateDuration(final long min, final long max, final JAction action) {
        long passedTime = getDuration(action);
        assertThat(passedTime, greaterThan(min));
        assertThat(passedTime, lessThan(max + HALF_SECOND_DURATION));
    }

    private static long getDuration(final JAction action) {
        long start = currentTimeMillis();
        action.execute();
        return currentTimeMillis() - start;
    }
}
