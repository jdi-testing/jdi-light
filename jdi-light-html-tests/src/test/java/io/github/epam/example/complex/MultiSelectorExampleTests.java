package io.github.epam.example.complex;

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
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertEquals;

public class MultiSelectorExampleTests implements TestsInit {

    private String text = "Steam";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        ages.check(text);
    }

    @Test
    public void getValueTest() {
        ages.is().value(text);
    }

    @Test
    public void selectTest() {
        ages.check("Electro", "Metalic");
        ages.is().enabled(hasItems("Electro", "Metalic"));
    }

    @Test
    public void selectEnumTest() {
        ages.check(Wood, Steam);
        ages.is().enabled(hasItems("Wood", "Steam"));
    }

    @Test
    public void selectNumTest() {
        ages.check(1, 5);
        ages.is().enabled(hasItems("Electro", "Wood"));
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
        ages.is().selected(text);
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
