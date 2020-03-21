package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.elements.complex.enums.Ages.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class MultiDropdownTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        if (!isFireFox())
            multiDropdown.check(text);
    }
    String text = "Steam";

    @Test
    public void getValueTest() {
        assertEquals(multiDropdown.getValue(), text);
    }

    @Test
    public void selectTest() {
        if (isFireFox()) return;
        multiDropdown.check("Electro", "Metalic");
        assertEquals(multiDropdown.checked(), asList("Electro", "Metalic"));
    }

    @Test
    public void selectEnumTest() {
        if (isFireFox()) return;
        multiDropdown.check(Wood, Steam);
        assertEquals(multiDropdown.checked(), asList("Steam", "Wood"));
    }
    @Test
    public void selectNumTest() {
        if (isFireFox()) return;
        multiDropdown.check(1, 5);
        assertEquals(multiDropdown.checked(), asList("Electro", "Wood"));
    }
    @Test
    public void selectedTest() {
        assertEquals(multiDropdown.selected(), text);
    }

    @Test
    public void disabledTest() {
        if (isFireFox()) return;
        multiDropdown.select("Disabled");
        assertEquals(multiDropdown.selected(), "Steam");
    }

    @Test
    public void labelTest() {
        assertEquals(multiDropdown.label().getText(), "Multi dropdown:");
        multiDropdown.label().is().text(containsString("Multi"));
    }

    @Test
    public void isValidationTest() {
        multiDropdown.is().selected("Steam");
        multiDropdown.is().selected(Steam);
        multiDropdown.assertThat().values(hasItem("Wood"));
        multiDropdown.assertThat().disabled(hasItem("Disabled"))
            .enabled(not(hasItem("Disabled")))
            .enabled(hasItems("Electro", "Metalic"));
    }

    @Test
    public void assertValidationTest() {
        multiDropdown.assertThat()
            .values(containsInAnyOrder("Disabled", "Electro", "Metalic", "Wood", "Steam"))
            .selected(Steam);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(multiDropdown);
    }
}
