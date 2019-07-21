package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.interfaces.IBaseElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CompositeUtils {
    public static void checkInitializedElement(IBaseElement htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        assertNotNull(htmlElementToCheck);
        assertEquals(htmlElementToCheck.core().locator.toString(), expectedLocator);
        assertEquals(htmlElementToCheck.core().parent, expectedParent);
        assertEquals(htmlElementToCheck.core().name, expectedName);
    }
}
