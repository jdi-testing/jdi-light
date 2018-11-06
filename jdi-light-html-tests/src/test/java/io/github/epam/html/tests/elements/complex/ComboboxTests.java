package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.disabledDropdown;
import static io.github.com.pages.HtmlElementsPage.iceCream;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Casual;
import static io.github.epam.html.tests.elements.complex.enums.Dress.Fancy;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class ComboboxTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
        iceCream.select(text);
    }
    String text = "Casual";

    @Test
    public void getValueTest() {
        assertEquals(iceCream.getValue(), text);
    }

    @Test
    public void selectTest() {
        iceCream.select("Pirate");
        assertEquals(iceCream.getValue(), "Pirate");
    }

    @Test
    public void selectEnumTest() {
        iceCream.select(Fancy);
        assertEquals(iceCream.getValue(), "Fancy");
    }
    @Test
    public void selectNumTest() {
        iceCream.select(1);
        assertEquals(iceCream.getValue(), "Fancy");
    }
    @Test
    public void selectedTest() {
        assertEquals(iceCream.selected(), "Casual");
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
        assertEquals(iceCream.label().getText(), "Dress code:");
        iceCream.label().is().text(containsString("Dress"));
    }

    @Test
    public void isValidationTest() {
        iceCream.is().selected("Casual");
        iceCream.is().selected(Casual);
        iceCream.is().values(hasItem("Pirate"));
        iceCream.is().disabled(hasItem("Disabled"));
        iceCream.is().enabled(not(hasItem("Disabled")));
        iceCream.is().enabled(hasItems("Pirate", "Fancy"));
    }

    @Test
    public void assertValidationTest() {
        iceCream.assertThat().values(contains("Fancy", "Casual", "Disabled", "Pirate"));
        disabledDropdown.assertThat().selected("Disabled");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(iceCream);
    }
}
