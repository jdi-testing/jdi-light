package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.mobile.elements.interfaces.base.IBaseElement;

import static com.epam.jdi.mobile.settings.WebSettings.logger;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CompositeUtils {
    public static void checkInitializedElement(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        logger.info("Check: name=%s; locator=%s", expectedName, expectedLocator);
        assertNotNull(htmlElementToCheck);
        assertEquals(htmlElementToCheck.base().locator.toString(), expectedLocator);
        assertEquals(htmlElementToCheck.base().parent, expectedParent);
        assertEquals(htmlElementToCheck.base().name, expectedName);
    }
}
