package io.github.epam.html.tests.elements.complex.dropdown;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledDropdown;
import static io.github.com.pages.HtmlElementsPage.dressCode2;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Casual;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Fancy;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DropdownDressTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        dressCode2.select(text);
    }
    String text = "Casual";

    @Test
    public void getValueTest() {
        assertEquals(dressCode2.getValue(), text);
    }

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
        assertEquals(dressCode2.selected(), text);
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
        dressCode2.values();
        dressCode2.assertThat().values(hasItem("Pirate"));
        dressCode2.assertThat()
            .disabled(hasItem("Disabled"))
            .enabled(not(hasItem("Disabled")))
            .enabled(hasItems("Pirate", "Fancy"));
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
