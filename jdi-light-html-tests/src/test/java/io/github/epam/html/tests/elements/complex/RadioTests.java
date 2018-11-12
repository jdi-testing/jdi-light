package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.colorsNoLocator;
import static io.github.com.pages.HtmlElementsPage.disabledDropdown;
import static io.github.com.pages.HtmlElementsPage.colors;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Blue;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Green;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Red;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Casual;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Fancy;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class RadioTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
        colors.select(text);
    }
    String text = "Blue";

    @Test
    public void getValueTest() {
        assertEquals(colors.getValue(), text);
    }

    @Test
    public void selectTest() {
        colors.select("Green");
        assertEquals(colors.getValue(), "Green");
        colorsNoLocator.select("Blue");
        colorsNoLocator.is().selected("Blue");
    }

    @Test
    public void selectEnumTest() {
        colors.select(Blue);
        assertEquals(colors.getValue(), "Blue");
        colorsNoLocator.select(Red);
        colorsNoLocator.is().selected(Red);
    }
    @Test
    public void selectNumTest() {
        colors.select(1);
        assertEquals(colors.getValue(), "Red");
    }
    @Test
    public void selectedTest() {
        assertEquals(colors.selected(), text);
    }
    @Test
    public void valuesTest() {
        assertEquals(colors.values(), asList("Red", "Green", "Blue", "Yellow"));
    }

    @Test
    public void isValidationTest() {
        colors.is().selected("Blue");
        colors.is().selected(Blue);
        colors.is().values(hasItem("Yellow"));
        colors.is().disabled(hasItem("Yellow"));
        colors.is().enabled(not(hasItem("Yellow")));
        colors.is().enabled(hasItems("Green", "Blue"));

        colorsNoLocator.is().selected("Blue");
        colorsNoLocator.is().selected(Blue);
    }

    @Test
    public void assertValidationTest() {
        colors.assertThat().values(contains("Red", "Green", "Blue", "Yellow"));
    }

}
