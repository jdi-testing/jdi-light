package io.github.epam.bootstrap.tests.composite.section.pagination;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.paginationOverview;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 26.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class OverviewTests extends TestsInit {

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
    String pageTitle1 = "JDI · GitHub";
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
                {1, pageTitle1}, {2, pageTitle2}, {3, pageTitle3}, {4, pageTitle4}, {5, pageTitle5}
        };
    }

    @Test
    public void isValidationTests() {
        paginationOverview.paginationItems.is()
                .size(5);
        paginationOverview.is()
                .core()
                .hasClass("pagination");
    }

    @Test(dataProvider = "listData")
    public void linkTextTests(int index, String linkText) {
        paginationOverview.paginationItems.get(index).is()
                .displayed()
                .enabled()
                .css("font-size", is("14px"))
                .hasClass("page-item")
                .text(is(linkText));
    }

    @Test(dataProvider = "listPageTitles")
    public void linkClickableTests(int index, String pageTitle) {
        paginationOverview.paginationItems.get(index).hover();
        paginationOverview.paginationItems.get(index).highlight();
        paginationOverview.paginationItems.get(index).click();
        newWindowTitleCheck(pageTitle);
        paginationOverview.paginationItems.get(index).unhighlight();
    }

    public void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
