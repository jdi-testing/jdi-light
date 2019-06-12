package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.com.pages.MetalAndColorsPage.colors;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Colors.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.fail;

/**
 * Skype: a.filichkin
 */

public class DropdownTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
        colors.select("Colors");
    }

    @Test
    public void selectStringTest() {
        colors.select("Red");
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Red"));
    }

    @Test
    public void selectEnumTest() {
        colors.select(Green);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Green"));
    }

    @Test
    public void selectIndexTest() {
        colors.select(4);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Blue"));
    }

    @Test
    public void selectedTest() {
        colors.select(Yellow);
        assertThat(colors.getValue(), is("Yellow"));
        assertThat(colors.selected(), is("Yellow"));
        assertThat(colors.getText(), is("Yellow"));
    }

    @Test
    public void negativeDroplistTest() {
        try {
            TIMEOUT.set(1);
            colors.select("GreyBrownCrimson");
            fail("You have selected color that does not exist in droplist - something went wrong");
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString("Can't select 'GreyBrownCrimson'. No elements with this name found"));
        }
    }

    @Test
    public void isValidationTest() {
        colors.is().selected("Colors");
        colors.is().innerValues(hasItem("Yellow"));
    }

    @Test
    public void assertValidationTest() {
        colors.assertThat().innerValues(contains("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void valuesTests() {
        colors.select(Blue);
        assertThat(colors.selected(), is("Blue"));
        assertThat(colors.getText(), is("Blue"));
        assertThat(colors.getValue(), is("Blue"));
        assertThat(colors.checked(), hasItem("Blue"));
    }
    @Test
    public void innerValuesTest() {
        assertThat(colors.innerValues(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void isDisplayedTest() {
        assertThat(colors.isDisplayed(), is(true));
    }
    @Test
    public void expandTests() {
        assertThat(colors.isExpanded(), is(false));
        colors.expand();
        assertThat(colors.isExpanded(), is(true));
        assertThat(colors.listEnabled(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
        assertThat(colors.values(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(colors);
    }
}

