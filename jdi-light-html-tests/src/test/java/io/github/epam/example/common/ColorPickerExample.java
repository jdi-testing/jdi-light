package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.colorPicker;
import static io.github.com.pages.HtmlElementsPage.disabledPicker;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ColorPickerExample implements TestsInit {
    final private static String COLOR = "#3fd7a6";
    final private static String DISABLED_COLOR = "#ffd7a6";
    final private static String SETTING_COLOR = "#432376";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void checkColorFieldEnabledTest() {
        colorPicker.is()
                .displayed()
                .enabled();
    }

    @Test
    public void checkColorFieldDisabledTest() {
        disabledPicker.assertThat()
                .displayed()
                .disabled();
    }

    @Test
    public void checkColorTest() {
        colorPicker.assertThat().color(COLOR);
        disabledPicker.is().color(DISABLED_COLOR);
    }

    @Test
    public void setColorTest() {
        colorPicker.setColor(SETTING_COLOR);
        colorPicker.is().color(SETTING_COLOR);
    }

    @Test
    public void labelTest() {
        colorPicker.label().is().text("Select a color");
        colorPicker.label().is().text(containsString("a color"));
        colorPicker.label().is().text(equalToIgnoringCase("select a color"));
    }
}
