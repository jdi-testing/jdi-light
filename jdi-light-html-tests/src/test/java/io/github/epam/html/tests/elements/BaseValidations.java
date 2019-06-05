package io.github.epam.html.tests.elements;

import com.epam.jdi.light.elements.base.IBaseElement;
import com.epam.jdi.tools.func.JAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.Assert.*;

public class BaseValidations {

    public static void baseValidation(IBaseElement el) {
        // EXCLUDED el.hover();
        assertTrue(el.isEnabled());
        assertTrue(el.isDisplayed());
        assertFalse(el.isDisabled());
        assertFalse(el.isHidden());
        Point location = el.getLocation();
        assertTrue(location.x > 0 && location.y > 0, "Location: " + location);
        Dimension size = el.getSize();
        assertTrue(size.height > 0 && size.width > 0, "Size: " + location);
        //Rectangle rect = el.getRect();
        //assertTrue(rect.height > 0 && rect.width > 0 && rect.x > 0 && rect.y > 0, "Size: " + location);
        el.setAttribute("test-jdi", "test-value");
        assertEquals(el.getAttribute("test-jdi"), "test-value");
        el.highlight("blue");
        el.highlight();
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
