package io.github.epam.html.tests.elements.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.common.TextTypes.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.LogSidebar.*;
import static io.github.com.pages.MetalAndColorsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.elements.complex.enums.Colors.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DropdownEx5Tests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
        colors5.select(text);
    }
    String text = "Colors";

    @Test
    public void getValueTest() {
        assertEquals(colors5.getValue(), text);
    }
    @Test
    public void selectStringTest() {
        colors5.select("Red");
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Red"));
    }

    @Test
    public void selectEnumTest() {
        colors5.select(Green);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Green"));
    }

    @Test
    public void selectIndexTest() {
        colors5.select(4);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Blue"));
    }

    @Test
    public void selectedTest() {
        colors5.select(Yellow);
        assertThat(colors5.getValue(), is("Yellow"));
        assertThat(colors5.selected(), is("Yellow"));
        assertThat(colors5.getText(), is("Yellow"));
    }

    @Test
    public void negativeDropdownTest() {
        try {
            colors5.base().waitSec(1);
            colors5.select("GreyBrownCrimson");
            fail("You have selected color that does not exist in dropdown - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Can't get 'GreyBrownCrimson'. No elements with this name found"));
        }
    }

    @Test
    public void isValidationTest() {
        colors5.is().selected("Colors");
        colors5.is().values(INNER, hasItem("Yellow"));
    }

    @Test
    public void assertValidationTest() {
        colors5.assertThat().values(INNER, contains("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void innerValuesTest() {
        assertThat(colors5.values(INNER), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void expandTests() {
        assertThat(colors5.listEnabled(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
        assertThat(colors5.listDisabled(), empty());
        assertThat(colors5.values(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(colors5);
    }
}

