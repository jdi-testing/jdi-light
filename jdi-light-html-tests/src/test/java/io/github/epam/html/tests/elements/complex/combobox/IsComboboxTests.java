package io.github.epam.html.tests.elements.complex.combobox;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.iceCreamIs;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Strawberry;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Vanilla;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class IsComboboxTests extends TestsInit {

    private String text = "Coconut";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        iceCreamIs.select(text);
    }

    @Test
    public void getValueTest() {
        assertEquals(iceCreamIs.getValue(), text);
    }

    @Test
    public void getTextTest() {
        assertEquals(iceCreamIs.getText(), text);
    }

    @Test
    public void inputTest() {
        iceCreamIs.input("New text");
        assertEquals(iceCreamIs.getText(), "New text");
    }

    @Test
    public void clearTest() {
        iceCreamIs.clear();
        assertEquals(iceCreamIs.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(iceCreamIs.placeholder(), "Ice cream");
    }

    @Test
    public void focusTest() {
        iceCreamIs.focus();
    }

    @Test
    public void sendKeysTest() {
        iceCreamIs.sendKeys("Test");
        assertEquals(iceCreamIs.getValue(), text+"Test");
    }
    @Test
    public void selectTest() {
        iceCreamIs.select("Chocolate");
        assertEquals(iceCreamIs.getValue(), "Chocolate");
    }

    @Test
    public void selectEnumTest() {
        iceCreamIs.select(Strawberry);
        assertEquals(iceCreamIs.getValue(), "Strawberry");
    }
    @Test
    public void selectNumTest() {
        iceCreamIs.clear();
        iceCreamIs.select(5);
        assertEquals(iceCreamIs.getValue(), "Vanilla");
    }
    @Test
    public void selectedTest() {
        assertEquals(iceCreamIs.selected(), text);
    }

    @Test
    public void labelTest() {
        assertEquals(iceCreamIs.label().getText(), "Choose your lovely icecream");
        iceCreamIs.label().is().text(containsString("lovely icecream"));
    }

    @Test
    public void isValidationTest() {
        iceCreamIs.is().enabled();
        iceCreamIs.is().text(is(text));
        iceCreamIs.is().text(text);
        iceCreamIs.is().selected(text);
        iceCreamIs.is().selected(is(text));
        iceCreamIs.select(Vanilla);
        iceCreamIs.is().text(containsString("Van"));
    }

    @Test
    public void assertValidationTest() {
        iceCreamIs.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(iceCreamIs);
    }
}
