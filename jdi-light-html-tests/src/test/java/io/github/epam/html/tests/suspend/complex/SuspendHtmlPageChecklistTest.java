package io.github.epam.html.tests.suspend.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.weather;
import static io.github.com.pages.HtmlElementsPage.weatherNoLocator;
import static io.github.epam.html.tests.elements.complex.enums.Weather.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;

public class SuspendHtmlPageChecklistTest extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.open();
    }

    @Test
    public void isValidationTest() {
        weather.is().selected("Hot option");
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
    public void uncheckTest() {
        weather.check("Rainy day", "Sunny");
        weather.uncheck(Rainy, Sunny);
        weather.is().selected(hasSize(2));
        weather.is().selected(hasItems("Hot option", "Cold"));
    }

    @Test
    public void selectTest() {
        weather.select(Cold);
        weather.is().selected(hasSize(2));
        weather.is().selected(hasItems("Hot option", "Cold"));
    }

    // мне кажется, нужнов getAll добавить ожидание элементов
    @Test(enabled = false)
    public void uncheckAllTest() {
        weather.check(Rainy, Sunny);
        weather.uncheckAll();
        weather.is().selected(hasSize(0));
    }

    // мне кажется, нужнов getAll добавить ожидание элементов
    @Test(enabled = false)
    public void checkAllTest() {
        weather.checkAll();
        weather.is().selected(hasSize(4));
        weather.is().selected(hasItems("Hot option", "Cold", "Rainy day", "Sunny"));
    }
}
