package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.isWeather;
import static io.github.com.pages.HtmlElementsPage.weatherNoLocator;
import static io.github.epam.html.tests.elements.complex.enums.Weather.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class IsChecklistTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        isWeather.check(text);
    }
    String text = "Hot option";

    @Test
    public void getValueTest() {
        assertEquals(isWeather.getValue(), text);
    }

    @Test
    public void checkTest() {
        isWeather.check("Cold");
        assertEquals(isWeather.checked(), asList("Cold"));
    }
    @Test
    public void checkTwoTest() {
        isWeather.check("Cold", "Hot option");
        assertEquals(isWeather.checked(), asList("Hot option", "Cold"));
    }
    @Test
    public void uncheckTest() {
        isWeather.check("Rainy day", "Sunny");
        isWeather.uncheck("Rainy day");
        isWeather.is().checked(hasSize(3));
        isWeather.is().checked(hasItems("Hot option", "Cold", "Sunny"));
    }
    @Test
    public void uncheckTwoTest() {
        isWeather.check("Rainy day", "Sunny");
        isWeather.uncheck("Rainy day", "Sunny");
        isWeather.is().checked(hasSize(2));
        isWeather.is().checked(hasItems("Hot option", "Cold"));
    }
    @Test
    public void selectTest() {
        isWeather.select("Cold");
        assertEquals(isWeather.checked(), asList("Hot option", "Cold"));
    }
    @Test
    public void selectTwoTest() {
        isWeather.select("Cold", "Hot option");
        assertEquals(isWeather.checked(), asList("Cold"));
    }

    @Test
    public void checkEnumTest() {
        isWeather.check(Cold);
        assertEquals(isWeather.checked(), asList("Cold"));
    }
    @Test
    public void checkEnumTwoTest() {
        isWeather.check(Cold, Hot);
        assertEquals(isWeather.checked(), asList("Hot option", "Cold"));
    }
    @Test
    public void uncheckEnumTest() {
        isWeather.check("Rainy day", "Sunny");
        isWeather.uncheck(Rainy);
        isWeather.is().checked(hasSize(3));
        isWeather.is().checked(hasItems("Hot option", "Cold", "Sunny"));
    }
    @Test
    public void uncheckEnumTwoTest() {
        isWeather.check("Rainy day", "Sunny");
        isWeather.uncheck(Rainy, Sunny);
        isWeather.is().checked(hasSize(2));
        isWeather.is().checked(hasItems("Hot option", "Cold"));
    }
    @Test
    public void selectEnumTest() {
        isWeather.select(Cold);
        assertEquals(isWeather.checked(), asList("Hot option", "Cold"));
    }
    @Test
    public void selectEnumTwoTest() {
        isWeather.select(Cold, Hot);
        assertEquals(isWeather.checked(), asList("Cold"));
    }

    @Test
    public void checkNumTest() {
        isWeather.check(5);
        assertEquals(isWeather.checked(), asList("Sunny"));
    }
    @Test
    public void checkNumTwoTest() {
        isWeather.check(2, 5);
        assertEquals(isWeather.checked(), asList("Hot option", "Sunny"));
    }
    @Test
    public void uncheckNumTest() {
        isWeather.checkAll();
        isWeather.uncheck(2);
        isWeather.is().checked(hasSize(3));
        isWeather.is().checked(hasItems("Cold", "Rainy day", "Sunny"));
    }
    @Test
    public void uncheckNumTwoTest() {
        isWeather.checkAll();
        isWeather.uncheck(2, 5);
        isWeather.is().checked(hasSize(2));
        isWeather.is().checked(hasItems("Cold", "Rainy day"));
    }
    @Test
    public void selectNumTest() {
        isWeather.select(4);
        assertEquals(isWeather.checked(), asList("Hot option", "Sunny"));
    }
    @Test
    public void selectNumTwoTest() {
        isWeather.select(1, 4);
        assertEquals(isWeather.checked(), asList("Sunny"));
    }

    @Test
    public void selectedTest() {
        assertEquals(isWeather.selected(), text);
    }

    @Test
    public void disabledTest() {
        try {
            isWeather.select("Disabled");
            fail("Click on disabled element should throw exception");
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString("Can't perform click. Element is disabled"));
        }
        assertEquals(isWeather.selected(), text);
    }

    @Test
    public void isValidationTest() {
        isWeather.is().displayed().selected("Hot option");
        isWeather.is().selected(Hot);
        isWeather.assertThat().values(hasItem("Sunny"))
                .disabled(hasItem("Disabled"))
                .enabled(not(hasItem("Disabled")))
                .enabled(hasItems("Cold", "Sunny"));
    }

    @Test
    public void assertValidationTest() {
        isWeather.assertThat().values(containsInAnyOrder(
                "Hot option", "Cold", "Rainy day", "Sunny", "Disabled"));
        weatherNoLocator.assertThat().selected("Hot option");
    }

    @Test
    public void uncheckAllTest() {
        isWeather.check(Rainy, Sunny);
        isWeather.uncheckAll();
        isWeather.is().checked(hasSize(0));
    }
    @Test
    public void checkAllTest() {
        isWeather.checkAll();
        isWeather.is().checked(hasSize(4));
        isWeather.is().checked(hasItems("Hot option", "Cold", "Rainy day", "Sunny"));
    }
}
