package io.github.epam.html.tests.elements.complex.list;

import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.Header.search;
import static io.github.com.pages.SearchPage.searchS;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.assertEquals;

import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class WaitDataListTests implements TestsInit {

    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
        shouldBeLoggedIn();
        search("jdi");
    }

    @Test
    public void notEmptyTest() {
        searchS.is().notEmpty();
    }

    @Test
    public void notEmpty2Test() {
        searchS.assertThat(not(empty()));
    }

    @Test
    public void emptyTest() {
        try {
            searchS.is().empty();
            Assert.fail("List should not be empty");
        } catch (Throwable ignored) {
        }
        searchS.is().notEmpty();
    }

    @Test
    public void sizeTest() {
        assertEquals(searchS.size(), 6);
        TIMEOUTS.element.setUp(10);
        try {
            searchS.is().size(equalTo(8));
        } catch (Throwable ignored) {
        } finally {
            TIMEOUTS.element.drop();
        }
    }

    @Test
    public void sizeGreaterTest() {
        TIMEOUTS.element.setUp(10);
        try {
            searchS.is().size(greaterThan(7));
        } catch (Throwable ignored) {
        } finally {
            TIMEOUTS.element.drop();
        }
    }

}
