package io.github.epam.html.tests.elements.complex.combobox;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.iceCream;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Strawberry;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Vanilla;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DataListTests extends TestsInit {

    private String text = "Coconut";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        iceCream.select(text);
    }

    @Test
    public void getValueTest() {
        assertEquals(iceCream.getValue(), text);
    }

    @Test
    public void getTextTest() {
        assertEquals(iceCream.getText(), text);
    }

    @Test
    public void inputTest() {
        iceCream.input("New text");
        assertEquals(iceCream.getText(), "New text");
    }

    @Test
    public void clearTest() {
        iceCream.clear();
        assertEquals(iceCream.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(iceCream.placeholder(), "Ice cream");
    }

    @Test
    public void focusTest() {
        iceCream.focus();
    }

    @Test
    public void sendKeysTest() {
        iceCream.sendKeys("Test");
        assertEquals(iceCream.getValue(), text+"Test");
    }
    @Test
    public void selectTest() {
        iceCream.select("Chocolate");
        assertEquals(iceCream.getValue(), "Chocolate");
    }

    @Test
    public void selectEnumTest() {
        iceCream.select(Strawberry);
        assertEquals(iceCream.getValue(), "Strawberry");
    }
    @Test
    public void selectNumTest() {
        iceCream.clear();
        iceCream.select(5);
        assertEquals(iceCream.getValue(), "Vanilla");
    }
    @Test
    public void selectedTest() {
        assertEquals(iceCream.selected(), text);
    }

    @Test
    public void labelTest() {
        assertEquals(iceCream.label().getText(), "Choose your lovely icecream");
        iceCream.label().is().text(containsString("lovely icecream"));
    }

    @Test
    public void isValidationTest() {
        iceCream.is().enabled();
        iceCream.is().text(is(text));
        iceCream.select(Vanilla);
        iceCream.is().text(containsString("Van"));
    }

    @Test
    public void assertValidationTest() {
        iceCream.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(iceCream);
    }
}
