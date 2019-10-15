package io.github.epam.html.tests.elements.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.common.TextTypes.INNER;
import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.com.pages.MetalAndColorsPage.colors3;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Green;
import static io.github.epam.html.tests.elements.complex.enums.Colors.Yellow;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DropdownEx3Tests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
        colors3.select(text);
    }
    String text = "Colors";

    @Test
    public void getValueTest() {
        assertEquals(colors3.getValue(), text);
    }
    @Test
    public void selectStringTest() {
        colors3.select("Red");
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Red"));
    }

    @Test
    public void selectEnumTest() {
        colors3.select(Green);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Green"));
    }

    @Test
    public void selectIndexTest() {
        colors3.select(4);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Blue"));
    }

    @Test
    public void selectedTest() {
        colors3.select(Yellow);
        assertThat(colors3.getValue(), is("Yellow"));
        assertThat(colors3.selected(), is("Yellow"));
        assertThat(colors3.getText(), is("Yellow"));
    }

    @Test
    public void negativeDropdownTest() {
        try {
            colors3.base().waitSec(1);
            colors3.select("GreyBrownCrimson");
            fail("You have selected color that does not exist in dropdown - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Can't get 'GreyBrownCrimson'. No elements with this name found"));
        }
    }

    @Test
    public void isValidationTest() {
        colors3.is().selected("Colors");
        colors3.is().values(INNER, hasItem("Yellow"));
    }

    @Test
    public void assertValidationTest() {
        colors3.assertThat().values(INNER, contains("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void innerValuesTest() {
        assertThat(colors3.values(INNER), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void expandTests() {
        assertThat(colors3.listEnabled(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
        assertThat(colors3.listDisabled(), empty());
        assertThat(colors3.values(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(colors3);
    }
}

