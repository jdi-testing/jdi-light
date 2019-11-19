package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.ages;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Ages.Steam;
import static io.github.epam.html.tests.elements.complex.enums.Ages.Wood;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class MultiSelectorTests extends TestsInit {

    private String text = "Steam";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        ages.check(text);
    }

    @Test
    public void getValueTest() {
        assertEquals(ages.getValue(), text);
    }

    @Test
    public void selectTest() {
        ages.check("Electro", "Metalic");
        assertEquals(ages.checked(), asList("Electro", "Metalic"));
    }

    @Test
    public void selectEnumTest() {
        ages.check(Wood, Steam);
        assertEquals(ages.checked(), asList("Steam", "Wood"));
    }

    @Test
    public void selectNumTest() {
        ages.check(1, 5);
        assertEquals(ages.checked(), asList("Electro", "Wood"));
    }

    @Test
    public void selectedTest() {
        assertEquals(ages.checked(), asList(text));
    }

    @Test
    public void disabledTest() {
        try {
            ages.select("Disabled");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Can't perform click. Element is disabled"));
        }
        assertEquals(ages.selected(), text);
    }

    @Test
    public void labelTest() {
        assertEquals(ages.label().getText(), "Age status:");
        ages.label().is().text(containsString("Age"));
    }

    @Test
    public void isValidationTest() {
        ages.is().selected("Steam");
        ages.is().selected(Steam);
        ages.is().values(hasItem("Wood"));
        ages.is().disabled(hasItem("Disabled"));
        ages.is().enabled(not(hasItem("Disabled")));
        ages.is().enabled(hasItems("Electro", "Metalic"));
    }

    @Test
    public void assertValidationTest() {
        ages.assertThat().values(containsInAnyOrder("Disabled", "Electro", "Metalic", "Wood", "Steam"));
        ages.assertThat().selected(Steam);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(ages);
    }
}
