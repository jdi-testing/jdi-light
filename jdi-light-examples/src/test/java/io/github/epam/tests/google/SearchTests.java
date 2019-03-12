package io.github.epam.tests.google;

import com.google.custom.SearchResult;
import io.github.epam.GoogleInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.GoogleSite.homePage;
import static com.google.pages.HomePage.suggestion;
import static com.google.pages.SearchPage.search3;
import static org.testng.Assert.assertTrue;

/**
 * Created by Roman_Iovlev on 3/2/2018.
 */
public class SearchTests extends GoogleInit {
    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
    }

    @TestSkipp
    public void printResultListTest() {
        suggestion.typeAndSelect("jdi", "jdi");
        SearchResult jdi = search3.get(2);
        assertTrue(jdi.name.getText().toLowerCase().contains("jdi")
            || jdi.description.getText().toLowerCase().contains("jdi"));
    }
}
