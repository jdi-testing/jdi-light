package io.github.epam.material.tests.displaydata;
import static org.hamcrest.Matchers.hasToString;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.ListPage;

public class ListsTests extends TestsInit{

    /*@Test
    public void simpleList() {
        dataDisplayListsSimpleListPage.open();

        listsFrame.firstListItem.is().enabled();
        listsFrame.firstListItem.is().text(hasToString("List item 1"));
        listsFrame.secondListItem.is().enabled();
        listsFrame.secondListItem.is().text(hasToString("List item 2"));
    }

    @Test
    public void checkboxList() {
        dataDisplayCheckboxListPage.open();

        listsFrame.lineItemFirst.is().enabled();
        listsFrame.lineItemFirst.is().text(hasToString("Line item 1"));
        listsFrame.checkboxLineItemFirst.is().checked();

        listsFrame.checkboxLineItemFirst.uncheck();
        listsFrame.checkboxLineItemFirst.is().unchecked();

        listsFrame.checkboxLineItemFirst.check();
        listsFrame.checkboxLineItemFirst.is().checked();
    }*/

    @Test
    public void pinnedSubHeaderList() {
        ListPage.open();

        ListPage.stickyZero.is().enabled();
        ListPage.stickyZero.is().text(hasToString("I'm sticky 0"));
        ListPage.stickyOne.is().enabled();
        ListPage.stickyOne.is().text(hasToString("I'm sticky 1"));
    }
}
