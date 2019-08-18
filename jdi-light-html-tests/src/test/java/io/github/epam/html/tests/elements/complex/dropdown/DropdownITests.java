package io.github.epam.html.tests.elements.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledDropdown;
import static io.github.com.pages.HtmlElementsPage.dressCode3;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Casual;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Fancy;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DropdownITests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        dressCode3.select(text);
    }
    String text = "Casual";

    @Test
    public void getValueTest() {
        assertEquals(dressCode3.getValue(), text);
    }

    @Test
    public void selectTest() {
        dressCode3.select("Pirate");
        assertEquals(dressCode3.getValue(), "Pirate");
    }

    @Test
    public void selectEnumTest() {
        dressCode3.select(Fancy);
        assertEquals(dressCode3.getValue(), "Fancy");
    }
    @Test
    public void selectNumTest() {
        dressCode3.select(1);
        assertEquals(dressCode3.getValue(), "Fancy");
    }
    @Test
    public void selectedTest() {
        assertEquals(dressCode3.selected(), text);
    }

    @Test
    public void sizeTest() {
        assertEquals(dressCode3.size(), 4);
    }
    @Test
    public void disabledTest() {
        if (isFireFox()) return;
        disabledDropdown.select("Pirate");
        assertEquals(disabledDropdown.getValue(), "Disabled");
    }

    @Test
    public void labelTest() {
        assertEquals(dressCode3.label().getText(), "Dress code:");
        dressCode3.label().is().text(containsString("Dress"));
    }

    @Test
    public void isValidationTest() {
        dressCode3.is().selected("Casual");
        dressCode3.is().selected(Casual);
    }

    @Test
    public void valuesTest() {
        List<String> values = dressCode3.values();
        assertEquals(values, asList("Fancy", "Casual", "Disabled", "Pirate"));
    }

    @Test
    public void assertValuesTest() {
        dressCode3.assertThat().values(hasItem("Pirate"));
        dressCode3.assertThat().values(hasItems("Fancy", "Pirate", "Casual", "Disabled"));
        dressCode3.assertThat()
            .disabled(hasItem("Disabled"))
            .enabled(not(hasItem("Disabled")))
            .enabled(hasItems("Pirate", "Fancy"));
    }

    @Test
    public void listEnabledTest() {
        assertEquals(dressCode3.listEnabled(), asList("Fancy", "Casual", "Pirate"));
        dressCode3.is()
            .enabled(hasItems("Fancy", "Pirate", "Casual"))
            .enabled(not(hasItem("Disabled")));
    }

    @Test
    public void listDisabledTest() {
        assertEquals(dressCode3.listDisabled(), asList("Disabled"));
        dressCode3.is()
            .disabled(hasItems("Disabled"))
            .disabled(not(hasItems("Fancy", "Pirate", "Casual")));
    }
    @Test
    public void assertValidationTest() {
        dressCode3.assertThat().values(contains("Fancy", "Casual", "Disabled", "Pirate"));
        disabledDropdown.assertThat().selected("Disabled");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(dressCode3);
    }
}
