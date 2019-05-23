package io.github.epam.html.tests.suspend;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.acceptConditions;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageCheckboxTest extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.open();
    }

    @Test
    public void isValidationTest() {
        acceptConditions.is().selected();
        acceptConditions.click();
        acceptConditions.is().deselected();
        acceptConditions.is().enabled();
        acceptConditions.is().displayed();
    }

    @Test
    public void labelTest() {
        assertEquals(acceptConditions.label().getText(),
                "Accept terms and conditions");
        acceptConditions.label().is().text(containsString("terms and conditions"));
        acceptConditions.label().is().text(equalToIgnoringCase("accept terms and conditions"));
    }
    @Test
    public void assertValidationTest() {
        acceptConditions.assertThat().selected();
    }

}
