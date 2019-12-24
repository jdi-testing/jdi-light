package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.iceCream;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class DataListExampleTests implements TestsInit {

    private String dataListText = "Coconut";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        iceCream.select(dataListText);
    }

    @Test
    public void selectTest() {
        iceCream.select("Chocolate");
        iceCream.is().text("Chocolate");
        iceCream.is().selected("Chocolate");
    }

    @Test
    public void selectNumTest() {
        iceCream.select(5);
        iceCream.is().selected("Vanilla");
    }

    @Test
    public void inputTest() {
        iceCream.input("New text");
        iceCream.is().text("New text");
    }

    @Test
    public void clearTest() {
        iceCream.clear();
        iceCream.is().text("");
    }

    @Test
    public void sendKeysTest() {
        iceCream.sendKeys("Test");
        iceCream.is().text("CoconutTest");
    }

    @Test
    public void placeholderTest() {
        assertEquals(iceCream.placeholder(), "Ice cream");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(iceCream);
    }
}
