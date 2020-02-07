package io.github.epam.html.tests.elements.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.mobile.common.Exceptions.safeException;
import static com.epam.jdi.mobile.common.TextTypes.INNER;
import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.com.pages.MetalAndColorsPage.colorsCustom;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Green;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Yellow;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DropdownCustomTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
        colorsCustom.select(text);
    }
    String text = "Colors";

    @Test
    public void getValueTest() {
        assertEquals(colorsCustom.getValue(), text);
    }
    @Test
    public void selectStringTest() {
        colorsCustom.select("Red");
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Red"));
    }

    @Test
    public void selectEnumTest() {
        colorsCustom.select(Green);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Green"));
    }

    @Test
    public void selectIndexTest() {
        colorsCustom.select(4);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Blue"));
    }

    @Test
    public void selectedTest() {
        colorsCustom.select(Yellow);
        assertThat(colorsCustom.getValue(), is("Yellow"));
        assertThat(colorsCustom.selected(), is("Yellow"));
        assertThat(colorsCustom.getText(), is("Yellow"));
    }

    @Test
    public void negativeDropdownTest() {
        try {
            colorsCustom.base().waitSec(1);
            colorsCustom.select("GreyBrownCrimson");
            fail("You have selected color that does not exist in dropdown - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Can't get 'GreyBrownCrimson'. No elements with this name found"));
        }
    }

    @Test
    public void isValidationTest() {
        colorsCustom.is().selected("Colors");
        colorsCustom.is().values(INNER, hasItem("Yellow"));
    }

    @Test
    public void assertValidationTest() {
        colorsCustom.assertThat().values(INNER, contains("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void innerValuesTest() {
        assertThat(colorsCustom.values(INNER), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void expandTests() {
        assertThat(colorsCustom.listEnabled(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
        assertThat(colorsCustom.listDisabled(), empty());
        assertThat(colorsCustom.values(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(colorsCustom);
    }
}

