package io.github.epam.material.tests.datadisplay;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dataDisplayListsSimpleListPage;
import static io.github.com.StaticSite.dataDisplayCheckboxListPage;
import static io.github.com.StaticSite.dataPinnedSubheaderListPage;
import static io.github.com.StaticSite.listsFrame;

public class ListsTests extends TestsInit{

    @Test
    public void simpleList() {
        dataDisplayListsSimpleListPage.open();

        listsFrame.firstListItem.is().enabled();
        listsFrame.secondListItem.is().enabled();
    }

    @Test
    public void checkboxList() {
        dataDisplayCheckboxListPage.open();

        listsFrame.lineItemFirst.is().enabled();
        listsFrame.checkboxLineItemFirst.is().checked();

        listsFrame.checkboxLineItemFirst.uncheck();
        listsFrame.checkboxLineItemFirst.is().unchecked();

        listsFrame.checkboxLineItemFirst.check();
        listsFrame.checkboxLineItemFirst.is().checked();
    }

    @Test
    public void pinnedSubheaderList() {
        dataPinnedSubheaderListPage.open();

        listsFrame.stickyZero.is().enabled();
        listsFrame.stickyOne.is().enabled();
    }

}
