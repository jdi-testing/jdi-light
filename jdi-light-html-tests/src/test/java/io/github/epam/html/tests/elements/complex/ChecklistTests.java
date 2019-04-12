package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.weather;
import static io.github.com.pages.HtmlElementsPage.weatherNoLocator;
import static io.github.epam.html.tests.elements.complex.enums.Weather.*;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ChecklistTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        weather.check(text);
    }
    String text = "Hot option";

    @Test
    public void getValueTest() {
        assertEquals(weather.getValue(), text);
    }

    @Test
    public void selectTest() {
        weather.check("Cold", "Hot option");
        assertEquals(weather.checked(), asList("Hot option", "Cold"));
    }

    @Test
    public void selectEnumTest() {
        weather.check(Cold, Rainy);
        assertEquals(weather.checked(), asList("Cold", "Rainy day"));
    }
    @Test
    public void selectNumTest() {
        weather.check(1, 4);
        assertEquals(weather.checked(), asList("Hot option", "Sunny"));
    }
    @Test
    public void selectedTest() {
        assertEquals(weather.selected(), text);
    }

    @Test
    public void disabledTest() {
        weather.select("Disabled");
        assertEquals(weather.selected(), text);
    }

    @Test
    public void isValidationTest() {
        weather.is().selected("Hot option");
        weather.is().selected(Hot);
        weather.assertThat().values(hasItem("Sunny"));
        weather.assertThat().disabled(hasItem("Disabled"));
        weather.assertThat().enabled(not(hasItem("Disabled")));
        weather.assertThat().enabled(hasItems("Cold", "Sunny"));
    }

    @Test
    public void assertValidationTest() {
        weather.assertThat().values(containsInAnyOrder(
        "Hot option", "Cold", "Rainy day", "Sunny", "Disabled"));
        weatherNoLocator.assertThat().selected("Hot option");
    }

    @Test
    public void uncheckTest() {
        weather.check("Rainy Day", "Sunny");
        weather.uncheck(Rainy, Sunny);
        assertNotEquals(weather.checked(), asList("Rainy Day", "Sunny"));
    }

    @Test
    public void uncheckAllTest() {
        weather.check(Rainy, Sunny);
        weather.uncheckAll();

        assertNotEquals(weather.checked(),
                asList("Hot option", "Cold", "Rainy day", "Sunny", "Disabled"));
    }

}
