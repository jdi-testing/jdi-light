package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.com.pages.MetalAndColorsPage.colors;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Green;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Yellow;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Skype: a.filichkin
 */

public class DroplistTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
        colors.select("Colors");
    }

    @Test
    public void selectStringTest() {
        colors.select("Red");
        lastLogEntry.assertThat().text(containsString("Colors: value changed to Red"));
    }

    @Test
    public void selectEnumTest() {
        colors.select(Green);
        lastLogEntry.assertThat().text(containsString("Colors: value changed to Green"));
    }

    // Fails, wait until interface + jdi-light-html class implementation
    @Test (enabled = false)
    public void selectIndexTest() {
        colors.select(4);
        lastLogEntry.assertThat().text(containsString("Colors: value changed to Blue"));
    }

    @Test
    public void selectedTest() {
        colors.select(Yellow);
        assertEquals(colors.getValue(), "Yellow");
        assertEquals(colors.getSelected(), "Yellow"); // May not be presented on interface implementation
        assertEquals(colors.getText(), "Yellow"); // May not be presented on interface implementation
    }

    @Test
    public void negativeDroplistTest() {
        try {
            colors.select("GreyBrownCrimson");
            fail("You have selected color that does not exist in droplist - something went wrong");
        } catch (Exception ex) { }
    }

    // Fails, wait until interface + jdi-light-html class implementation
    @Test (enabled = false)
    public void isValidationTest() {
        colors.expand(); // Has to be handled by dropdown
        colors.is().values(hasItem("Yellow"));
        colors.is().selected("Color"); //here it falls
    }

    @Test
    public void assertValidationTest() {
        colors.expand(); // Has to be handled by dropdown
        colors.assertThat().values(contains("Colors", "Red", "Green", "Blue", "Yellow"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(colors);
    }
}

