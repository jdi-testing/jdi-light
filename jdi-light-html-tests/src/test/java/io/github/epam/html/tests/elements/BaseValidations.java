package io.github.epam.html.tests.elements;

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

@SuppressWarnings("PMD.ClassNamingConventions")
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
        validateDuration(duration, duration+1, action);
    }
    public static void durationLessThan(int duration, JAction action) {
        validateDuration(duration-1, duration, action);
    }
    public static void durationImmediately(JAction action) {
        durationMoreThan(0, action);
    }
    public static void validateDuration(int min, int max, JAction action) {
        long start = currentTimeMillis();
        try {
            action.execute();
        } finally {
            long passedTime = currentTimeMillis()-start;
            assertThat(passedTime, greaterThan(min*1000L-500));
            assertThat(passedTime, lessThan(max*1000L+500));
        }
    }
}
