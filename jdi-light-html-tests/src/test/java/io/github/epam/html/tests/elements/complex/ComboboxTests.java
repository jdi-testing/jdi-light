package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.iceCream;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Strawberry;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Vanilla;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class ComboboxTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        iceCream.select(text);
    }
    String text = "Coconut";

    @Test
    public void getValueTest() {
        assertEquals(iceCream.getValue(), text);
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
