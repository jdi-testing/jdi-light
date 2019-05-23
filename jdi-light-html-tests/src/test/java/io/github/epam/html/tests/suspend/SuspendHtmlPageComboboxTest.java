package io.github.epam.html.tests.suspend;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.iceCream;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Vanilla;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class SuspendHtmlPageComboboxTest extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.open();
    }

    String text = "Coconut";

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

}
