package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;

import static com.epam.jdi.light.settings.WebSettings.*;
import static org.testng.Assert.*;

public class CompositeUtils {
    public static void checkInitializedElement(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        logger.info("Check: name=%s; locator=%s", expectedName, expectedLocator);
        assertNotNull(htmlElementToCheck);
        assertEquals(htmlElementToCheck.base().locator.printLocator(), expectedLocator);
        assertEquals(htmlElementToCheck.base().parent, expectedParent);
        assertEquals(htmlElementToCheck.base().name, expectedName);
    }
}
