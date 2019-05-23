package io.github.epam.html.tests.suspend;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.colorPicker;
import static io.github.com.pages.HtmlElementsPage.disabledPicker;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageColorPickerTest extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.open();
    }

    String color = "#ffd7a6";

    @Test
    public void isValidationTest() {
        disabledPicker.is().color(color);
        colorPicker.is().enabled();
        disabledPicker.is().disabled();
    }

    @Test
    public void labelTest() {
        assertEquals(colorPicker.label().getText(), "Select a color");
        colorPicker.label().is().text(containsString("a color"));
        colorPicker.label().is().text(equalToIgnoringCase("select a color"));
    }

    @Test
    public void assertValidationTest() {
        disabledPicker.assertThat().color(color);
    }

}
