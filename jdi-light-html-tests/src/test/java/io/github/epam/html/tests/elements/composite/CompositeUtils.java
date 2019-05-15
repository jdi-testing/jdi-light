package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CompositeUtils {
    public static void checkInitializedElement(JDIBase htmlElementToCheck, String expectedLocator, JDIBase expectedParent, String expectedName) {
        assertNotNull(htmlElementToCheck);
        assertEquals(htmlElementToCheck.locator.toString(), expectedLocator);
        assertEquals(htmlElementToCheck.parent, expectedParent);
        assertEquals(htmlElementToCheck.name, expectedName);
    }
}
