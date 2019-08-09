package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledDropdown;
import static io.github.com.pages.HtmlElementsPage.dressCode;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Casual;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Fancy;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DropdownSelectTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        dressCode.select(text);
    }
    String text = "Casual";

    @Test
    public void getValueTest() {
        assertEquals(dressCode.getValue(), text);
    }

    @Test
    public void selectTest() {
        dressCode.select("Pirate");
        assertEquals(dressCode.getValue(), "Pirate");
    }

    @Test
    public void selectEnumTest() {
        dressCode.select(Fancy);
        assertEquals(dressCode.getValue(), "Fancy");
    }
    @Test
    public void selectNumTest() {
        dressCode.select(1);
        assertEquals(dressCode.getValue(), "Fancy");
    }
    @Test
    public void selectedTest() {
        assertEquals(dressCode.selected(), text);
    }

    @Test
    public void disabledTest() {
        if (isFireFox()) return;
        disabledDropdown.select("Pirate");
        assertEquals(disabledDropdown.getValue(), "Disabled");
    }

    @Test
    public void labelTest() {
        assertEquals(dressCode.label().getText(), "Dress code:");
        dressCode.label().is().text(containsString("Dress"));
    }

    @Test
    public void isValidationTest() {
        dressCode.is().selected("Casual");
        dressCode.is().selected(Casual);
        dressCode.assertThat().values(hasItem("Pirate"));
        dressCode.assertThat()
            .disabled(hasItem("Disabled"))
            .enabled(not(hasItem("Disabled")))
            .enabled(hasItems("Pirate", "Fancy"));
    }

    @Test
    public void assertValidationTest() {
        dressCode.assertThat().values(contains("Fancy", "Casual", "Disabled", "Pirate"));
        disabledDropdown.assertThat().selected("Disabled");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(dressCode);
    }
}
