package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.weather;
import static io.github.com.pages.HtmlElementsPage.weatherNoLocator;
import static io.github.epam.html.tests.elements.complex.enums.Weather.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ChecklistTests extends TestsInit {

    private String text = "Hot option";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        weather.check(text);
    }

    @Test
    public void getValueTest() {
        assertEquals(weather.getValue(), text);
    }

    @Test
    public void checkTest() {
        weather.check("Cold");
        assertEquals(weather.checked(), asList("Cold"));
    }

    @Test
    public void checkTwoTest() {
        weather.check("Cold", "Hot option");
        assertEquals(weather.checked(), asList("Hot option", "Cold"));
    }

    @Test
    public void uncheckTest() {
        weather.check("Rainy day", "Sunny");
        weather.uncheck("Rainy day");
        weather.is().checked(hasSize(3));
        weather.is().checked(hasItems("Hot option", "Cold", "Sunny"));
    }

    @Test
    public void uncheckTwoTest() {
        weather.check("Rainy day", "Sunny");
        weather.uncheck("Rainy day", "Sunny");
        weather.is().checked(hasSize(2));
        weather.is().checked(hasItems("Hot option", "Cold"));
    }

    @Test
    public void selectTest() {
        weather.select("Cold");
        assertEquals(weather.checked(), asList("Hot option", "Cold"));
    }

    @Test
    public void selectTwoTest() {
        weather.select("Cold", "Hot option");
        assertEquals(weather.checked(), asList("Cold"));
    }

    @Test
    public void checkEnumTest() {
        weather.check(Cold);
        assertEquals(weather.checked(), asList("Cold"));
    }

    @Test
    public void checkEnumTwoTest() {
        weather.check(Cold, Hot);
        assertEquals(weather.checked(), asList("Hot option", "Cold"));
    }

    @Test
    public void uncheckEnumTest() {
        weather.check("Rainy day", "Sunny");
        weather.uncheck(Rainy);
        weather.is().checked(hasSize(3));
        weather.is().checked(hasItems("Hot option", "Cold", "Sunny"));
    }

    @Test
    public void uncheckEnumTwoTest() {
        weather.check("Rainy day", "Sunny");
        weather.uncheck(Rainy, Sunny);
        weather.is().checked(hasSize(2));
        weather.is().checked(hasItems("Hot option", "Cold"));
    }

    @Test
    public void selectEnumTest() {
        weather.select(Cold);
        assertEquals(weather.checked(), asList("Hot option", "Cold"));
    }

    @Test
    public void selectEnumTwoTest() {
        weather.select(Cold, Hot);
        assertEquals(weather.checked(), asList("Cold"));
    }

    @Test
    public void checkNumTest() {
        weather.check(5);
        assertEquals(weather.checked(), asList("Sunny"));
    }

    @Test
    public void checkNumTwoTest() {
        weather.check(2, 5);
        assertEquals(weather.checked(), asList("Hot option", "Sunny"));
    }

    @Test
    public void uncheckNumTest() {
        weather.checkAll();
        weather.uncheck(2);
        weather.is().checked(hasSize(3));
        weather.is().checked(hasItems("Cold", "Rainy day", "Sunny"));
    }

    @Test
    public void uncheckNumTwoTest() {
        weather.checkAll();
        weather.uncheck(2, 5);
        weather.is().checked(hasSize(2));
        weather.is().checked(hasItems("Cold", "Rainy day"));
    }

    @Test
    public void selectNumTest() {
        weather.select(4);
        assertEquals(weather.checked(), asList("Hot option", "Sunny"));
    }

    @Test
    public void selectNumTwoTest() {
        weather.select(1, 4);
        assertEquals(weather.checked(), asList("Sunny"));
    }

    @Test
    public void selectedTest() {
        assertEquals(weather.selected(), text);
    }

    @Test
    public void disabledTest() {
        try {
            weather.select("Disabled");
            fail("Click on disabled element should throw exception");
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString("Can't perform click. Element is disabled"));
        }
        assertEquals(weather.selected(), text);
    }

    @Test
    public void isValidationTest() {
        weather.is().displayed().selected("Hot option");
        weather.is().selected(Hot);
        weather.assertThat().values(hasItem("Sunny"))
                .disabled(hasItem("Disabled"))
                .enabled(not(hasItem("Disabled")))
                .enabled(hasItems("Cold", "Sunny"));
    }

    @Test
    public void assertValidationTest() {
        weather.assertThat().values(containsInAnyOrder(
                "Hot option", "Cold", "Rainy day", "Sunny", "Disabled"));
        weatherNoLocator.assertThat().selected("Hot option");
    }

    @Test
    public void uncheckAllTest() {
        weather.check(Rainy, Sunny);
        weather.uncheckAll();
        weather.is().checked(hasSize(0));
    }

    @Test
    public void checkAllTest() {
        weather.checkAll();
        weather.is().checked(hasSize(4));
        weather.is().checked(hasItems("Hot option", "Cold", "Rainy day", "Sunny"));
    }
}
