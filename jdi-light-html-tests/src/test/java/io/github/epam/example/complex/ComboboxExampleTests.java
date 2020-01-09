package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.iceCreamIs;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Strawberry;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Vanilla;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class ComboboxExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        iceCreamIs.select(text);
    }
    String text = "Coconut";

    @Test
    public void getTextTest() {
        iceCreamIs.is().text(text);
    }

    @Test
    public void inputTest() {
        iceCreamIs.input("New text");
        iceCreamIs.is().text("New text");
        iceCreamIs.clear();
        iceCreamIs.is().text("");
    }

    @Test
    public void placeholderTest() {
        iceCreamIs.placeholder().equals("Ice cream");
    }

    @Test
    public void selectTest() {
        iceCreamIs.select("Chocolate");
        iceCreamIs.is().text("Chocolate");
        iceCreamIs.select(Strawberry);
        iceCreamIs.is().text("Strawberry");
        iceCreamIs.clear();
        iceCreamIs.select(5);
        iceCreamIs.is().text("Vanilla");
    }

    @Test
    public void labelTest() {
        iceCreamIs.label().is().text("Choose your lovely icecream");
        iceCreamIs.label().is().text(containsString("lovely icecream"));
    }

    @Test
    public void isValidationTest() {
        iceCreamIs.listEnabled();
        iceCreamIs.assertThat().equals(asList("Chocolate", "Strawberry"));
        iceCreamIs.is().enabled();
        iceCreamIs.is().text(text);
        iceCreamIs.is().selected(text);
        iceCreamIs.is().selected(is(text));
        iceCreamIs.select(Vanilla);
        iceCreamIs.is().text(containsString("Van"));
    }

}
