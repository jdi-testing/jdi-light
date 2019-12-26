package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.weather;
import static io.github.com.pages.HtmlElementsPage.weatherNoLocator;
import static io.github.epam.html.tests.elements.complex.enums.Weather.Cold;
import static io.github.epam.html.tests.elements.complex.enums.Weather.Rainy;
import static io.github.epam.html.tests.elements.complex.enums.Weather.Sunny;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class CheckListExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        weather.check("Hot option");
    }

    @Test
    public void checkTest() {
        weather.check("Rainy day", "Sunny");
        weather.is().checked(hasSize(2));
        weather.is().checked(hasItems("Rainy day", "Sunny"));
    }

    @Test
    public void uncheckTest() {
        weather.check("Rainy day", "Sunny");
        weather.uncheck("Rainy day");
        weather.is().checked(hasSize(3));
        weather.is().checked(hasItems("Hot option", "Cold", "Sunny"));
    }

    @Test
    public void checkAllTest() {
        weather.checkAll();
        weather.is().checked(hasItems("Hot option", "Cold", "Rainy day", "Sunny"));
    }

    @Test
    public void uncheckAllTest() {
        weather.check(Rainy, Sunny);
        weather.uncheckAll();
        weather.is().checked(hasSize(0));
    }

    @Test
    public void selectTest() {
        weather.select("Cold", "Hot option");
        weather.is().selected("Cold");
    }

    @Test
    public void checkNumTest() {
        weather.check(1, 4);
        weather.is().checked(hasItems("Hot option", "Sunny"));
    }

    @Test
    public void selectEnumTest() {
        weather.select(Cold, Rainy);
        weather.is().checked(hasItems("Cold", "Rainy day"));
    }

    @Test
    public void assertValidationTest() {
        weather.assertThat().values(containsInAnyOrder(
                "Hot option", "Cold", "Rainy day", "Sunny", "Disabled"));
        weatherNoLocator.assertThat().selected("Hot option");
    }
}
