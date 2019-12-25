package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.weather;
import static io.github.epam.html.tests.elements.complex.enums.Weather.Cold;
import static io.github.epam.html.tests.elements.complex.enums.Weather.Hot;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class CheckListExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        //weather.uncheckAll();
        weather.check("Hot option");
    }

    @Test
    public void checkTest() {
        weather.check("Rainy day", "Sunny");
        weather.is().checked(hasSize(2));
        weather.uncheck("Rainy day");
        weather.is().checked(hasItems("Rainy day", "Sunny"));
    }

    @Test
    public void uncheckTest() {
        weather.check("Cold", "Rainy day", "Sunny");
        weather.uncheck("Rainy day");
        weather.uncheck( "Sunny");
        weather.is().checked(hasSize(1));
        weather.is().checked(hasItems("Hot option"));
    }

    @Test
    public void checkAllTest() {
        weather.checkAll();
        weather.is().checked(hasItems("Hot option", "Cold", "Rainy day", "Sunny"));
    }

    @Test
    public void selectTest() {
        weather.select("Cold", "Hot option");
        weather.select("Cold");
        weather.is().checked(hasSize(1));
        weather.is().selected("Hot option");
    }

    @Test
    public void checkEnumTest() {
        weather.check(Cold, Hot);
        weather.is().checked(hasItems("Cold", "Hot option"));
        weather.uncheck(Cold);
        weather.is().checked(hasSize(1));
        weather.is().checked(hasItems("Hot option"));
    }
}
