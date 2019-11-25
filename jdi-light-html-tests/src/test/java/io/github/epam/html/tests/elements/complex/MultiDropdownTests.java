package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.multiDropdown;
import static io.github.epam.html.tests.elements.BaseValidationsUtils.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Ages.Steam;
import static io.github.epam.html.tests.elements.complex.enums.Ages.Wood;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.assertEquals;

public class MultiDropdownTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        if (!isFireFox())
            multiDropdown.check(text);
    }
    private String text = "Steam";

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
