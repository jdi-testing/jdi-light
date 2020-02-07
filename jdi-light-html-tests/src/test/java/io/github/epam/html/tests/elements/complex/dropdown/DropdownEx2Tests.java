package io.github.epam.html.tests.elements.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.mobile.common.Exceptions.safeException;
import static com.epam.jdi.mobile.common.TextTypes.INNER;
import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.com.pages.MetalAndColorsPage.colors2;
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

public class DropdownEx2Tests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
        colors2.select(text);
    }
    String text = "Colors";

    @Test
    public void getValueTest() {
        assertEquals(colors2.getValue(), text);
    }
    @Test
    public void selectStringTest() {
        colors2.select("Red");
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Red"));
    }

    @Test
    public void selectEnumTest() {
        colors2.select(Green);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Green"));
    }

    @Test
    public void selectIndexTest() {
        colors2.select(4);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Blue"));
    }

    @Test
    public void selectedTest() {
        colors2.select(Yellow);
        assertThat(colors2.getValue(), is("Yellow"));
        assertThat(colors2.selected(), is("Yellow"));
        assertThat(colors2.getText(), is("Yellow"));
    }

    @Test
    public void negativeDropdownTest() {
        try {
            colors2.base().waitSec(1);
            colors2.select("GreyBrownCrimson");
            fail("You have selected color that does not exist in dropdown - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Can't get 'GreyBrownCrimson'. No elements with this name found"));
        }
    }

    @Test
    public void isValidationTest() {
        colors2.is().selected("Colors");
        colors2.is().values(INNER, hasItem("Yellow"));
    }

    @Test
    public void assertValidationTest() {
        colors2.assertThat().values(INNER, contains("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void innerValuesTest() {
        assertThat(colors2.values(INNER), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void expandTests() {
        assertThat(colors2.isExpanded(), is(false));
        colors2.expand();
        assertThat(colors2.isExpanded(), is(true));
        assertThat(colors2.listEnabled(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
        assertThat(colors2.listDisabled(), empty());
        assertThat(colors2.values(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(colors2);
    }
}

