package io.github.epam.tests.google;

import io.github.epam.GoogleInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.GoogleSite.homePage;
import static com.google.pages.HomePage.suggestion;
import static com.google.pages.SearchPage.jobs3;
import static org.testng.Assert.assertTrue;

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
        suggestion.typeAndSelect("jd", "jdi");
        assertTrue(jobs3.get(2).name.getText().toLowerCase().contains("jdi")
            || jobs3.get(2).description.getText().toLowerCase().contains("jdi"));
    }
}
