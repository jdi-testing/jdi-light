package io.github.epam.html.tests.elements.composite;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static pseudo.site.pages.Header.*;

public class FormTests extends TestsInit {

    @Test
    public void formInitializationTest() {
        assertNotNull(pseudoLoginFormLight);
        assertNotNull(pseudoLoginForm);
        assertNotNull(pseudoLoginFormSmart);
    }
}
