package io.github.epam.html.tests.suspend.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.jdiTitle;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;

public class SuspendHtmlPageLabelTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
    }
    String text = "JDI TESTING PLATFORM";

    @Test
    public void isValidationTest() {
        jdiTitle.is().enabled();
        jdiTitle.is().text(is(text));
        jdiTitle.is().text(equalTo(text));
        jdiTitle.is().text(equalToIgnoringCase("jdi TESTING platform"));
    }

    @Test
    public void assertValidationTest() {
        jdiTitle.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(jdiTitle);
    }
}
