package io.github.epam.tests.google;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void notEmptyAssertThatTest() {
        searchS.assertThat(not(empty()));
    }

    @Test
    public void sizeTest() {
        assertEquals(searchS.size(), 6);
        searchS.has().size(equalTo(8));
    }

    @Test
    public void sizeGreaterTest() {
        searchS.has().size(greaterThan(7));
    }

}
