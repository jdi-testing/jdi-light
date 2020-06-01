package io.github.epam.html.tests.elements.complex.list;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.Header.search;
import static io.github.com.pages.SearchPage.searchS;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

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
        searchS.is().notEmpty();
    }

    @Test
    public void sizeTest() {
        assertEquals(searchS.size(), 6);
        searchS.waitFor(10).size(equalTo(8));
    }

    @Test
    public void sizeGreaterTest() {
        searchS.waitFor(10).size(greaterThan(7));
    }

}
