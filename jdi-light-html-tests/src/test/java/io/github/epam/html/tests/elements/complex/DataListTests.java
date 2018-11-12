package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.iceCreamDataList;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.*;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DataListTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
        iceCreamDataList.select(text);
    }
    String text = "Coconut";

    @Test
    public void getValueTest() {
        assertEquals(iceCreamDataList.getValue(), text);
    }

    @Test
    public void selectTest() {
        iceCreamDataList.select("Chocolate");
        assertEquals(iceCreamDataList.getValue(), "Chocolate");
    }

    @Test
    public void selectEnumTest() {
        iceCreamDataList.select(Strawberry);
        assertEquals(iceCreamDataList.getValue(), "Strawberry");
    }
    @Test
    public void selectNumTest() {
        iceCreamDataList.select(5);
        assertEquals(iceCreamDataList.getValue(), "Vanilla");
    }
    @Test
    public void selectedTest() {
        assertEquals(iceCreamDataList.selected(), text);
    }

    @Test
    public void labelTest() {
        assertEquals(iceCreamDataList.label().getText(), "Choose your lovely icecream");
        iceCreamDataList.label().is().text(containsString("lovely icecream"));
    }

    @Test
    public void isValidationTest() {
        iceCreamDataList.is().text(is(text));
        iceCreamDataList.select(Vanilla);
        iceCreamDataList.is().text(containsString("Van"));
    }

    @Test
    public void assertValidationTest() {
        iceCreamDataList.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(iceCreamDataList);
    }
}
