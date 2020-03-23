package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class ColorPickerTests implements TestsInit {

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
        disabledPicker.setColor("#432376");
        assertEquals(disabledPicker.color(), "#432376");
    }

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

    @Test
    public void baseValidationTest() {
        baseValidation(colorPicker);
    }
}
