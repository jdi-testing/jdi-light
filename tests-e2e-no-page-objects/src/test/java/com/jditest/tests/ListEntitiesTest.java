package com.jditest.tests;

import com.epam.jdi.tools.DataClass;
import com.google.gson.JsonObject;
import com.jditest.TestInit;
import com.jditest.entities.SearchItem;
import com.jditest.entities.User;
import com.jditest.states.States;
import com.jditest.testng.TestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.PrintUtils.print;
import static com.jditest.JDI.$;
import static com.jditest.entities.User.Roman;
import static com.jditest.tests.TestData.SearchResults;
import static com.jditest.tests.TestData.SearchResultsJson;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestNGListener.class)
public class ListEntitiesTest implements TestInit {
    @BeforeMethod
    public void before() {
        States.logout();
        States.atHomePage();
        $("#user-icon").click();
        loginAs(Roman);
        $(".icon-search.active").click();
        $(".search-field input").input("jdi");
        $(".icon-search").click();
    }

    @Test
    public void jsonListTest() {
        List<JsonObject> results = $("#search-results li").getObjectList(
        "{ 'title': element.querySelector('h3').innerText, " +
                "'description': element.querySelector('p').innerText, " +
                "'link': element.querySelector('a').href " +
                "}");
        assertEquals(results.get(2).get("title").toString(), "\"JDI TEST SITE\"");
        assertEquals(print(results,
            jo -> "{ "+ jo.get("title") + jo.get("description") + jo.get("link") + " }"),
            SearchResultsJson);
    }

    @Test
    public void entitiesListTest() {
        List<SearchItem> results = $("#search-results li").getEntityList(SearchItem.class);
        assertEquals(results.get(2).title, "JDI TEST SITE");
        assertEquals(print(results, DataClass::toString), SearchResults);
    }

    private void loginAs(User user) {
        $("#name").input(user.name);
        $("#password").input(user.password);
        $(".fa-sign-in").click();
    }
}
