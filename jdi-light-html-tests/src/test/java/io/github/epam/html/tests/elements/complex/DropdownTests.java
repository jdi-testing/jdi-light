package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.disabledDropdown;
import static io.github.com.pages.HtmlElementsPage.dressCode;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Casual;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Fancy;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DropdownTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
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
        assertEquals(dressCode.selected(), "Casual");
    }

    @Test
    public void disabledTest() {
        try {
            disabledDropdown.select("Pirate");
        } catch (Exception ignore) {}
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
        dressCode.is().values(hasItem("Pirate"));
        dressCode.is().disabled(hasItem("Disabled"));
        dressCode.is().enabled(not(hasItem("Disabled")));
        dressCode.is().enabled(hasItems("Pirate", "Fancy"));
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
