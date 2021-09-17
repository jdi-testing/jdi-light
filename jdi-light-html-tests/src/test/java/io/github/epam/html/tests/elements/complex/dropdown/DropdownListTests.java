package io.github.epam.html.tests.elements.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.TextTypes.INNER;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.jdiai.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.metalAndColorsPage;
import static io.github.com.pages.LogSidebar.lastLogEntry;
import static io.github.com.pages.MetalAndColorsPage.colorsList;
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

public class DropdownListTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        metalAndColorsPage.shouldBeOpened();
        colorsList.get("dropdown").select(text);
    }
    String text = "Colors";

    @Test
    public void getValueTest() {
        assertEquals(colorsList.get("dropdown").getValue(), text);
    }
    
    @Test
    public void selectStringTest() {
        colorsList.get("dropdown").select("Red");
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Red"));
    }

    @Test
    public void selectEnumTest() {
        colorsList.get("dropdown").select(Green);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Green"));
    }

    @Test
    public void selectIndexTest() {
        colorsList.get("dropdown").select(ELEMENT.startIndex + 3);
        lastLogEntry.assertThat()
            .text(containsString("Colors: value changed to Blue"));
    }

    @Test
    public void selectedTest() {
        colorsList.get("dropdown").select(Yellow);
        assertThat(colorsList.get("dropdown").getValue(), is("Yellow"));
        assertThat(colorsList.get("dropdown").selected(), is("Yellow"));
        assertThat(colorsList.get("dropdown").getText(), is("Yellow"));
    }

    @Test
    public void negativeDropdownTest() {
        try {
            colorsList.get("dropdown").base().waitSec(1);
            colorsList.get("dropdown").select("GreyBrownCrimson");
            fail("You have selected color that does not exist in dropdown - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Failed to get 'GreyBrownCrimson' in list 'Colors List[dropdown] list'. No elements with this name found"));
        }
    }

    @Test
    public void isValidationTest() {
        colorsList.get("dropdown").is().selected("Colors");
        colorsList.get("dropdown").is().values(INNER, hasItem("Yellow"));
    }

    @Test
    public void assertValidationTest() {
        colorsList.get("dropdown").assertThat().values(INNER, contains("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void innerValuesTest() {
        assertThat(colorsList.get("dropdown").values(INNER), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void expandTests() {
        assertThat(colorsList.get("dropdown").listEnabled(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
        assertThat(colorsList.get("dropdown").listDisabled(), empty());
        assertThat(colorsList.get("dropdown").values(), hasItems("Colors", "Red", "Green", "Blue", "Yellow"));
    }
    @Test
    public void baseValidationTest() {
        baseValidation(colorsList.get("dropdown").value());
    }
}

