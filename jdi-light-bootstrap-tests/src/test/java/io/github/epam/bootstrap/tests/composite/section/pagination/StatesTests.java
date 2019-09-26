package io.github.epam.bootstrap.tests.composite.section.pagination;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.paginationStates;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

public class StatesTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String prev = "Previous";
    String one = "1";
    String two = "2";
    String three = "3";
    String next = "Next";
    String pageTitle2 = "JDI Testing tools · GitHub";
    String pageTitle3 = "Home Page";
    String pageTitle4 = "Bootstrap · The most popular HTML, CSS, and JS library in the world.";
    String pageTitle5 = "JDI Light Framework – API Reference";

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {1, prev}, {2, one}, {3, two}, {4, three}, {5, next}
        };
    }

    @DataProvider
    public Object[][] listPageTitles() {
        return new Object[][]{
                {2, pageTitle2}, {3, pageTitle3}, {4, pageTitle4}, {5, pageTitle5}
        };
    }

    @Test
    public void isValidationTests() {
        paginationStates.paginationItems.is().size(5);
        paginationStates.paginationItems.get(1).is()
                .hasClass("disabled");
        paginationStates.paginationItems.get(3).is()
                .hasClass("active");
    }

    @Test (dataProvider = "listData")
    public void linkTextTests(int index, String linkText) {
        paginationStates.paginationItems.get(index)
                .is().displayed().enabled()
                .css("font-size", is("14px"))
                .hasClass("page-item")
                .text(is(containsString(linkText)));
    }

    @Test (dataProvider = "listPageTitles")
    public void linkClickableTests(int index, String pageTitle) {
        paginationStates.paginationItems.get(index).hover();
        paginationStates.paginationItems.get(index).highlight();
        paginationStates.paginationItems.get(index).click();
        newWindowTitleCheck(pageTitle);
        paginationStates.paginationItems.get(index).unhighlight();
    }

    public void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
