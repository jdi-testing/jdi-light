package io.github.epam.material.tests.displaydata;

import static org.hamcrest.Matchers.hasToString;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.ListPage;
import static org.testng.Assert.assertTrue;

public class ListsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        ListPage.open();
        ListPage.isOpened();
    }

    @Test
    public void simpleList() {
        ListPage.firstListItem.is().enabled();
        ListPage.firstListItem.is().text(hasToString("List item 1"));
        ListPage.secondListItem.is().enabled();
        ListPage.secondListItem.is().text(hasToString("List item 2"));
    }

    @Test
    public void checkboxList() {
        ListPage.lineItemFirst.is().enabled();
        ListPage.lineItemFirst.is().text(hasToString("Line item 1"));
        ListPage.checkboxLineItemFirst.is().checked();

        ListPage.checkboxLineItemFirst.uncheck();
        ListPage.checkboxLineItemFirst.is().unchecked();

        ListPage.checkboxLineItemFirst.check();
        ListPage.checkboxLineItemFirst.is().checked();
    }

    @Test
    public void pinnedSubHeaderList() {
        ListPage.stickyZero.is().enabled();
        ListPage.stickyZero.is().text(hasToString("I'm sticky 0"));
        ListPage.stickyOne.is().enabled();
        ListPage.stickyOne.is().text(hasToString("I'm sticky 1"));
    }

    @Test
    public void selectedList() {
        ListPage.inputSelectedListItem.is().enabled();
        ListPage.inputSelectedListItem.is().text((hasToString("Inbox")));
        ListPage.trashSelectedListItem.is().enabled();
        ListPage.trashSelectedListItem.is().text((hasToString("Trash")));
    }

    @Test
    public void secondaryTextList() {
        ListPage.enableSecondaryTextCheckbox.get(2).isNotChecked();
        ListPage.enableSecondaryTextCheckbox.get(2).check();
        ListPage.enableSecondaryTextCheckbox.get(2).isChecked();
        ListPage.secondaryLineListItems.get(1).is().text(hasToString("Secondary text"));
        ListPage.enableSecondaryTextCheckbox.get(2).uncheck();
        ListPage.secondaryLineListItems.get(1).is().notVisible();
    }

    @Test
    public void switchList() {
        assertTrue(ListPage.switchList.get(2).children().get(9).hasClass("MuiSwitch-switchBase"));
    }
}
