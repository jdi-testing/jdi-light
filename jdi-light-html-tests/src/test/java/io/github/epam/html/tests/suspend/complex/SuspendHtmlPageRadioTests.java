package io.github.epam.html.tests.suspend.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.colors;
import static io.github.com.pages.HtmlElementsPage.colorsNoLocator;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Blue;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Red;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageRadioTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
        colors.select(text);
    }
    String text = "Blue";

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
