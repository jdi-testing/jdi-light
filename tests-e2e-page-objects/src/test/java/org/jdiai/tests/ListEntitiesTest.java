package org.jdiai.tests;

import org.jdiai.DataList;
import org.jdiai.TestInit;
import org.jdiai.entities.LoginUser;
import org.jdiai.entities.SearchItem;
import org.jdiai.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.PrintUtils.print;
import static org.jdiai.JDI.loginAs;
import static org.jdiai.site.JDISite.homePage;
import static org.jdiai.site.JDISite.searchPage;
import static org.jdiai.states.States.atHomePage;
import static org.jdiai.states.States.logout;
import static org.jdiai.test.data.TestData.SearchResults;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestNGListener.class)
public class ListEntitiesTest implements TestInit {

    @BeforeMethod
    public void before() {
        logout();
        atHomePage();
        homePage.userIcon.click();
        loginAs(LoginUser.Roman);
        homePage.searchIcon.click();
        homePage.searchField.input("jdi");
        homePage.searchIcon.click();
    }

    @Test
    public void entitiesListTest() {
        List<SearchItem> results = searchPage.searchResults;
        assertEquals(results.get(2).title, "JDI TEST SITE");
        assertEquals(print(results, SearchItem::toString), SearchResults);
    }
    @Test
    public void entitiesDataTest() {
        DataList<SearchItem> results = searchPage.searchData;
        assertEquals(results.get("JDI TEST SITE").link, "https://jdi-testing.github.io/jdi-light/");
        assertEquals(print(results, SearchItem::toString), SearchResults);
    }
}
