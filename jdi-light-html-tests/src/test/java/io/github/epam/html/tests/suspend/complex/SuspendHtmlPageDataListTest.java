package io.github.epam.html.tests.suspend.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.iceCreamDataList;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Vanilla;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class SuspendHtmlPageDataListTest extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.open();
        iceCreamDataList.select(text);
    }

    String text = "Coconut";

    @Test
    public void isValidationTest() {
        iceCreamDataList.is().enabled();
        iceCreamDataList.is().text(is(text));
        iceCreamDataList.select(Vanilla);
        iceCreamDataList.is().text(containsString("Van"));
    }

    @Test
    public void assertValidationTest() {
        iceCreamDataList.assertThat().text(is(text));
    }

}
