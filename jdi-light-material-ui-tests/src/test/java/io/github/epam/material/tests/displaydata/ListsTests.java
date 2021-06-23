package io.github.epam.material.tests.displaydata;
import static org.hamcrest.Matchers.hasToString;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dataDisplayListPage;

public class ListsTests extends TestsInit{

    @Test
    public void simpleList() {
        dataDisplayListPage.open();

        dataDisplayListPage.firstListItem.is().enabled();
        dataDisplayListPage.firstListItem.is().text(hasToString("List item 1"));
        dataDisplayListPage.secondListItem.is().enabled();
        dataDisplayListPage.secondListItem.is().text(hasToString("List item 2"));

    }

    @Test
    public void checkboxList() {
        dataDisplayListPage.open();

        dataDisplayListPage.lineItemFirst.is().enabled();
        dataDisplayListPage.lineItemFirst.is().text(hasToString("Line item 1"));
        dataDisplayListPage.checkboxLineItemFirst.is().checked();

        dataDisplayListPage.checkboxLineItemFirst.uncheck();
        dataDisplayListPage.checkboxLineItemFirst.is().unchecked();

        dataDisplayListPage.checkboxLineItemFirst.check();
        dataDisplayListPage.checkboxLineItemFirst.is().checked();
    }

    @Test
    public void pinnedSubheaderList() {
        dataDisplayListPage.open();

        dataDisplayListPage.stickyZero.is().enabled();
        dataDisplayListPage.stickyZero.is().text(hasToString("I'm sticky 0"));
        dataDisplayListPage.stickyOne.is().enabled();
        dataDisplayListPage.stickyOne.is().text(hasToString("I'm sticky 1"));
    }

}
