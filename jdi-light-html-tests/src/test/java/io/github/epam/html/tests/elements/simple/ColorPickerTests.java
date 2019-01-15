package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.colorPicker;
import static io.github.com.pages.HtmlElementsPage.disabledPicker;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.testng.Assert.assertEquals;

public class ColorPickerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    String color = "#ffd7a6";

    @Test
    public void getLabelTextTest() {
        assertEquals(colorPicker.labelText(), "Select a color");
    }

    @Test
    public void getColorTest() {
        assertEquals(disabledPicker.color(), color);
    }
    @Test
    public void setColorTest() {
        colorPicker.setColor("#432376");
        assertEquals(colorPicker.color(), "#432376");
        try { disabledPicker.setColor("#432376");
        } catch (Exception ignore) {}
        assertEquals(disabledPicker.color(), color);
    }

    @Test
    public void isValidationTest() {
        disabledPicker.is().color(color);
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

    @Test
    public void baseValidationTest() {
        baseValidation(colorPicker);
    }
}
