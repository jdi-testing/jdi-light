package io.github.epam.html.tests.elements.composite;

import com.epam.jdi.light.elements.base.JDIBase;

import java.lang.reflect.Modifier;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CompositeUtils {
    public static void checkInitializedElement(JDIBase htmlElementToCheck, String expectedLocator, Object expectedParent, String expectedName) {
        assertNotNull(htmlElementToCheck);
        assertEquals(htmlElementToCheck.locator.toString(), expectedLocator);

        Class c =  htmlElementToCheck.getClass();
        int mods = c.getModifiers();
        if (Modifier.isStatic(mods))
            assertEquals(htmlElementToCheck.parent, expectedParent);
        else assertEquals(htmlElementToCheck.parent.getClass().getName(), expectedParent.getClass().getName());

        assertEquals(htmlElementToCheck.name, expectedName);


    }
}
