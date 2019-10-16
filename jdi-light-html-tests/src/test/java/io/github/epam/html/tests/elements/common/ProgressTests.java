package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.progress;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class ProgressTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(progress.labelText(), "File progress");
    }

    @Test
    public void getValueTest() {
        assertEquals(progress.value(), "70");
    }
    @Test
    public void maxTest() {
        assertEquals(progress.max(), "100");
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
