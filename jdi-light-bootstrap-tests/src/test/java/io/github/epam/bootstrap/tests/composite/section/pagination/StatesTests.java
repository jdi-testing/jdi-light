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

/**
 * Created by Dmitrii Pavlov on 26.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

@SuppressWarnings("PMD.ClassNamingConventions")
public class StatesTests extends TestsInit {

    private String prev = "Previous";
    private String one = "1";
    private String two = "2";
    private String three = "3";
    private String next = "Next";
    private String pageTitle2 = "JDI Testing tools · GitHub";
    private String pageTitle3 = "Home Page";
    private String pageTitle4 = "Bootstrap · The most popular HTML, CSS, and JS library in the world.";
    private String pageTitle5 = "API Reference";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {2, one}, {3, two}, {4, three}, {5, next}
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
        paginationStates.paginationItems.is()
                .size(5);
        paginationStates.is()
                .core()
                .hasClass("pagination");
        paginationStates.paginationItems.get(1).is()
                .core()
                .hasClass("disabled");
        paginationStates.paginationItems.get(3).is()
                .core()
                .hasClass("active");
    }

    @Test(dataProvider = "listData")
    public void linkTextTests(int index, String linkText) {
        paginationStates.paginationItems.get(index).is()
                .displayed()
                .enabled()
                .css("font-size", is("14px"))
                .hasClass("page-item")
                .text(is(containsString(linkText)));
    }

    @Test
    public void linkDisabledTests() {
        paginationStates.paginationItems.get(1).is()
                .displayed()
                .disabled()
                .css("font-size", is("14px"))
                .hasClass("page-item")
                .text(is(containsString(prev)));
    }

    @Test(dataProvider = "listPageTitles")
    public void linkClickableTests(int index, String pageTitle) {
        paginationStates.paginationItems.get(index).hover();
        paginationStates.paginationItems.get(index).highlight();
        paginationStates.paginationItems.get(index).click();
        newWindowTitleCheck(pageTitle);
        //paginationStates.paginationItems.get(index).unhighlight();
    }

    private void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
