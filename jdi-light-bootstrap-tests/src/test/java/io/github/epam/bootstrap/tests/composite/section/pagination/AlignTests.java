package io.github.epam.bootstrap.tests.composite.section.pagination;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.paginationAlignCenter;
import static io.github.com.pages.BootstrapPage.paginationAlignEnd;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

public class AlignTests extends TestsInit {

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
        paginationAlignCenter.paginationItems.is().size(5);
        paginationAlignCenter.is().core().hasClass("pagination justify-content-center");
        paginationAlignCenter.paginationItems.get(1)
                .is()
                .core()
                .hasClass("disabled");
        paginationAlignEnd.paginationItems.is().size(5);
        paginationAlignEnd.is().core().hasClass("pagination justify-content-end");
        paginationAlignEnd.paginationItems.get(1)
                .is()
                .core()
                .hasClass("disabled");
    }

    @Test(dataProvider = "listData")
    public void linkTextTests(int index, String linkText) {
        paginationAlignCenter.paginationItems.get(index)
                .is().displayed().enabled()
                .css("font-size", is("14px"))
                .hasClass("page-item")
                .text(is(containsString(linkText)));
        paginationAlignEnd.paginationItems.get(index)
                .is().displayed().enabled()
                .css("font-size", is("14px"))
                .hasClass("page-item")
                .text(is(containsString(linkText)));
    }

    @Test (dataProvider = "listPageTitles")
    public void linkClickableCenterTests(int index, String pageTitle) {
        paginationAlignCenter.paginationItems.get(index).hover();
        paginationAlignCenter.paginationItems.get(index).highlight();
        paginationAlignCenter.paginationItems.get(index).click();
        newWindowTitleCheck(pageTitle);
        paginationAlignCenter.paginationItems.get(index).unhighlight();
    }

    @Test (dataProvider = "listPageTitles")
    public void linkClickableEndTests(int index, String pageTitle) {
        paginationAlignEnd.paginationItems.get(index).hover();
        paginationAlignEnd.paginationItems.get(index).highlight();
        paginationAlignEnd.paginationItems.get(index).click();
        newWindowTitleCheck(pageTitle);
        paginationAlignEnd.paginationItems.get(index).unhighlight();
    }

    public void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }

}
