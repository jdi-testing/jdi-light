package io.github.epam.html.tests.suspend.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.disabledRange;
import static io.github.com.pages.HtmlElementsPage.volume;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageRangeTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
        volume.setVolume(90);
    }

    @Test
    public void isValidationTest() {
        volume.is().enabled();
        volume.assertThat().minVolume(is(10));
        volume.assertThat().maxVolume(is(100));
        volume.assertThat().step(is(5));
        volume.is().volume(greaterThanOrEqualTo(10));
        volume.is().volume(lessThanOrEqualTo(100));
        volume.is().volume(is(90));
    }

    @Test
    public void labelTest() {
        assertEquals(volume.label().getText(), "Volume");
        volume.label().is().text(containsString("lume"));
        volume.label().assertThat().text(equalToIgnoringCase("volume"));
    }

    @Test
    public void assertValidationTest() {
        volume.assertThat().volume(greaterThan(0));
        volume.assertThat().volume(lessThan(200));
        disabledRange.assertThat().volume(is(50));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(volume);
    }
}
