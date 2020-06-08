package io.github.epam.tests.google;

import io.github.epam.StaticTestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.*;
import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.Header.search;
import static io.github.com.pages.SearchPage.jsearchTitle;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class WaitJListTests extends StaticTestsInit {

    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
        shouldBeLoggedIn();
        search("jdi");
    }

    @Test
    public void isNotEmptyTest() {
        jsearchTitle.is().notEmpty();
    }

    @Test
    public void notEmptyAssertThatTest() {
        jsearchTitle.assertThat(not(empty()));
    }

    @Test
    public void emptyTest() {
        jsearchTitle.waitSec(2);
        try {
            jsearchTitle.is().empty();
            Assert.fail("List should not be empty");
        } catch (Throwable ignored) { }
        finally {
            jsearchTitle.waitSec(TIMEOUTS.element.get());
        }
    }

    @Test
    public void sizeTest() {
        assertEquals(jsearchTitle.size(), 6);
        jsearchTitle.has().size(equalTo(8));
    }

    @Test
    public void sizeNotEmptyTest() {
        jsearchTitle.has().size(greaterThan(7));
    }

}
