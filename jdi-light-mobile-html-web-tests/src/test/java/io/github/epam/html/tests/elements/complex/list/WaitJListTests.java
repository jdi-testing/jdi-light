package io.github.epam.html.tests.elements.complex.list;

import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.Header.search;
import static io.github.com.pages.SearchPage.jsearchTitle;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class WaitJListTests implements TestsInit {

    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
        shouldBeLoggedIn();
        search("jdi");
    }

    @Test
    public void notEmptyTest() {
        jsearchTitle.is().notEmpty();
    }

    @Test
    public void notEmpty2Test() {
        jsearchTitle.assertThat(not(empty()));
    }

    @Test
    public void emptyTest() {
        jsearchTitle.waitSec(2);
        try {
            jsearchTitle.is().empty();
            Assert.fail("List should not be empty");
        } catch (Throwable ignored) {
        } finally {
            jsearchTitle.waitSec(TIMEOUTS.element.get());
        }
    }

    @Test
    public void sizeTest() {
        assertEquals(jsearchTitle.size(), 6);
        // FLAKY
        jsearchTitle.is().size(equalTo(8));
    }

    @Test
    public void sizeNotEmptyTest() {
        // FLAKY
        jsearchTitle.is().size(greaterThan(7));
    }

}
