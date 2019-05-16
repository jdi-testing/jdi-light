package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;

import java.lang.reflect.Modifier;

import static org.testng.Assert.*;

public class CompositeUtils {
    public static void checkInitializedElement(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        assertNotNull(htmlElementToCheck);
        assertEquals(htmlElementToCheck.locator.toString(), expectedLocator);
        assertEquals(htmlElementToCheck.parent, expectedParent);
        assertEquals(htmlElementToCheck.name, expectedName);
    }
}
