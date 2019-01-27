package io.github.epam.tests.google;

import io.github.epam.GoogleInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.GoogleSite.homePage;
import static com.google.GoogleSite.searchPage;
import static org.testng.Assert.assertFalse;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class SearchTests extends GoogleInit {
    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
    }

    @Test
    public void printResultListTest() {
        homePage.search("jdi");
        assertFalse(searchPage.jobs3.get(2).name.getText().isEmpty());
    }
}
