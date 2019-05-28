package io.github.epam.html.tests.suspend.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.progress;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageProgressTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
    }

    @Test
    public void isValidationTest() {
        progress.assertThat().maxVolume(is(100));
        progress.is().volume(greaterThanOrEqualTo(10));
        progress.is().volume(lessThanOrEqualTo(100));
        progress.assertThat().volume(is(70));
        progress.is().enabled();
    }

    @Test
    public void labelTest() {
        assertEquals(progress.label().getText(), "File progress");
        progress.label().is().text(containsString("progress"));
        progress.label().assertThat().text(equalToIgnoringCase("file progress"));
    }

    @Test
    public void assertValidationTest() {
        progress.assertThat().volume(greaterThan(0));
        progress.assertThat().volume(lessThan(200));
        progress.assertThat().volume(is(70));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(progress);
    }
}
