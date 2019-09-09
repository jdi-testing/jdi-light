package io.github.epam.tests.google;

import io.github.epam.StaticTestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.Header.search;
import static io.github.com.pages.SearchPage.searchS;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class WaitDataListTests extends StaticTestsInit {
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
        } catch (Throwable ignored) { }
        searchS.is().notEmpty();
    }
    @Test
    public void sizeTest() {
        assertEquals(searchS.size(), 6);
        searchS.is().size(equalTo(8));
    }
    @Test
    public void sizeGreaterTest() {
        searchS.is().size(greaterThan(7));
    }

}
