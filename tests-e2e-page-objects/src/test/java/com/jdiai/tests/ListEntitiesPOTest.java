package com.jdiai.tests;

import com.jdiai.DataList;
import com.jdiai.JDI;
import com.jdiai.JS;
import com.jdiai.TestInit;
import com.jdiai.asserts.ConditionTypes;
import com.jdiai.entities.SearchItem;
import com.jdiai.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.PrintUtils.print;
import static com.jdiai.JDI.*;
import static com.jdiai.asserts.Conditions.size;
import static com.jdiai.entities.User.Roman;
import static com.jdiai.site.JDISite.homePage;
import static com.jdiai.site.JDISite.searchPage;
import static com.jdiai.states.States.atHomePage;
import static com.jdiai.states.States.logout;
import static com.jdiai.test.data.TestData.AllSearchResults;
import static com.jdiai.test.data.TestData.SearchResults;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestNGListener.class)
public class ListEntitiesPOTest implements TestInit {

    @BeforeMethod
    public void before() {
        logout();
        atHomePage();
        homePage.userIcon.click();
        homePage.loginForm.loginAs(Roman);
        homePage.searchIcon.click();
        homePage.searchField.input("jdi");
        JS e = homePage.searchIcon;
        e.setFilter(findConditions.isDisplayed).engine().multiSearch();
        e.click();
    }

    @Test
    public void entitiesListTest() {
        List<SearchItem> results = searchPage.searchResults;
        assertEquals(results.size(), 6);
        assertEquals(results.get(2).title, "JDI TEST SITE");
        assertEquals(print(results, SearchItem::toString), SearchResults);
    }

    @Test
    public void entitiesDataTest() {
        DataList<SearchItem> results = searchPage.searchData;
        assertEquals(results.size(), 6);
        assertEquals(results.get("JDI TEST SITE").link, "https://jdi-testing.github.io/jdi-light/");
        assertEquals(print(results, SearchItem::toString), SearchResults);
    }

    @Test
    public void waitForSizeDataTest() {
        DataList<SearchItem> results = searchPage.searchData;
        assertEquals(print(results, SearchItem::toString), SearchResults);
        results.waitFor(size(s -> s > 6));
        assertEquals(print(results, SearchItem::toString), AllSearchResults);
    }

    @Test
    public void waitByValueDataTest() {
        DataList<SearchItem> results = searchPage.searchData;
        assertEquals(results.get("JDI FACEBOOK GROUP").link, "https://www.facebook.com/groups/jdi.framework/");
        assertEquals(print(results, SearchItem::toString), AllSearchResults);
    }

    @Test
    public void waitByIndexDataTest() {
        DataList<SearchItem> results = searchPage.searchData;
        assertEquals(results.get(6).link, "https://www.facebook.com/groups/jdi.framework/");
        assertEquals(print(results, SearchItem::toString), AllSearchResults);
    }

}
