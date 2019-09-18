package io.github.epam.html.tests.elements.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledDropdown;
import static io.github.com.pages.HtmlElementsPage.dressCode2;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Dress.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class DropdownDressTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        dressCode2.select(text);
    }
    String text = "Casual";

    @Test
    public void selectTest() {
        dressCode2.select("Pirate");
        assertEquals(dressCode2.getValue(), "Pirate");
    }

    @Test
    public void selectEnumTest() {
        dressCode2.select(Fancy);
        assertEquals(dressCode2.getValue(), "Fancy");
    }
    @Test
    public void selectNumTest() {
        dressCode2.select(1);
        assertEquals(dressCode2.getValue(), "Fancy");
    }
    @Test
    public void selectedTest() {
        dressCode2.select(Pirate);
        assertEquals(dressCode2.selected(), "Pirate");
        assertEquals(dressCode2.getValue(), "Pirate");
        assertEquals(dressCode2.getText(), "Pirate");
    }

    @Test
    public void negativeDropdownTest() {
        try {
            dressCode2.base().waitSec(1);
            dressCode2.select("Unknown");
            fail("You have selected dressCode that does not exist in dropdown - something went wrong");
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("Cannot locate option with text: Unknown"));
        }
    }

    @Test
    public void sizeTest() {
        assertEquals(dressCode2.size(), 4);
    }
    @Test
    public void disabledTest() {
        if (isFireFox()) return;
        disabledDropdown.select("Pirate");
        assertEquals(disabledDropdown.getValue(), "Disabled");
    }

    @Test
    public void labelTest() {
        assertEquals(dressCode2.label().getText(), "Dress code:");
        dressCode2.label().is().text(containsString("Dress"));
    }

    @Test
    public void isValidationTest() {
        dressCode2.is().selected("Casual");
        dressCode2.is().selected(Casual);
    }

    @Test
    public void valuesTest() {
        List<String> values = dressCode2.values();
        assertEquals(values, asList("Fancy", "Casual", "Disabled", "Pirate"));
    }

    @Test
    public void assertValuesTest() {
        dressCode2.assertThat().values(hasItem("Pirate"));
        dressCode2.assertThat().values(hasItems("Fancy", "Pirate", "Casual", "Disabled"));
        dressCode2.assertThat()
            .disabled(hasItem("Disabled"))
            .enabled(not(hasItem("Disabled")))
            .enabled(hasItems("Pirate", "Fancy"));
    }

    @Test
    public void listEnabledTest() {
        assertEquals(dressCode2.listEnabled(), asList("Fancy", "Casual", "Pirate"));
        dressCode2.is()
            .enabled(hasItems("Fancy", "Pirate", "Casual"))
            .enabled(not(hasItem("Disabled")));
    }

    @Test
    public void listDisabledTest() {
        assertEquals(dressCode2.listDisabled(), asList("Disabled"));
        dressCode2.is()
            .disabled(hasItems("Disabled"))
            .disabled(not(hasItems("Fancy", "Pirate", "Casual")));
    }
    @Test
    public void assertValidationTest() {
        dressCode2.assertThat().values(contains("Fancy", "Casual", "Disabled", "Pirate"));
        disabledDropdown.assertThat().selected("Disabled");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(dressCode2);
    }
}
