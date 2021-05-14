package com.jditest.tests;

import com.jditest.DataList;
import com.jditest.TestInit;
import com.jditest.entities.LoginUser;
import com.jditest.entities.SearchItem;
import com.jditest.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.PrintUtils.print;
import static com.jditest.JDI.loginAs;
import static com.jditest.site.JDISite.homePage;
import static com.jditest.site.JDISite.searchPage;
import static com.jditest.states.States.atHomePage;
import static com.jditest.states.States.logout;
import static com.jditest.test.data.TestData.SearchResults;
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
