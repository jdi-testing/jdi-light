package io.github.epam.html.tests.elements;

import com.epam.jdi.light.elements.base.BaseElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BaseValidations {

    public static void baseValidation(BaseElement el) {
        el.hover();
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
        el.higlight("blue");
        el.higlight();
        el.show();
    }
}
