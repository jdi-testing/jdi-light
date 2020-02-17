package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.colors;
import static io.github.com.pages.HtmlElementsPage.colorsNoLocator;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Green;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;

public class RadioButtonsExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void selectTest() {
        colors.select("Green");
        colors.is().selected(Green);
        colors.is().text("Green");
        colorsNoLocator.select("Blue");
        colorsNoLocator.is().selected("Blue");
        colors.is().value("Blue");
    }

    @Test
    public void valuesTest() {
        colors.is().values(hasItems("Red", "Green", "Blue", "Yellow"));
    }

    @Test
    public void isValidationTest() {
        colors.is().values(hasItem("Yellow"));
        colors.is().disabled(hasItem("Yellow"));
        colors.is().enabled(not(hasItem("Yellow")));
        colors.is().enabled(hasItems("Green", "Blue"));
    }

    @Test
    public void assertValidationTest() {
        colors.assertThat().values(contains("Red", "Green", "Blue", "Yellow"));
    }
}
