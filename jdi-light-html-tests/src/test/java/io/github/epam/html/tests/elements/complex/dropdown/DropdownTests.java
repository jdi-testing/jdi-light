package io.github.epam.html.tests.elements.complex.dropdown;

import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.complex.DropdownExpand;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.map.MapArray;
import io.github.epam.TestsInit;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.common.TextTypes.INNER_TEXT;
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
            colors.base().setTimeout(1);
            colors.select("GreyBrownCrimson");
            //colors.base().waitAction(1, j -> j.select("GreyBrownCrimson"), DropdownExpand.class);
            fail("You have selected color that does not exist in droplist - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Can't get 'GreyBrownCrimson'. No elements with this name found"));
        }
    }

    @Test
    public void isValidationTest() {
        colors.is().selected("Colors");
        colors.is().values(INNER_TEXT, hasItem("Yellow"));
    }

    @Test
    public void assertValidationTest() {
        colors.assertThat().values(INNER_TEXT, contains("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void valuesTests() {
        colors.select(Blue);
        assertThat(colors.selected(), is("Blue"));
        assertThat(colors.getText(), is("Blue"));
        assertThat(colors.getValue(), is("Blue"));
    }
    @Test
    public void innerValuesTest() {
        assertThat(colors.values(INNER_TEXT), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
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

