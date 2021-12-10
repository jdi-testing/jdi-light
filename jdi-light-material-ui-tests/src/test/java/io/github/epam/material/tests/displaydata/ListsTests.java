package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.listPage;
import static org.hamcrest.Matchers.hasToString;
import static org.testng.Assert.assertTrue;

public class ListsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        listPage.open();
        listPage.isOpened();
    }

    @Test
    public void simpleList() {
        listPage.firstListItem.is().enabled();
        listPage.firstListItem.is().text(hasToString("List item 1"));
        listPage.secondListItem.is().enabled();
        listPage.secondListItem.is().text(hasToString("List item 2"));
    }

    @Test
    public void checkboxList() {
        listPage.lineItemFirst.is().enabled();
        listPage.lineItemFirst.is().text(hasToString("Line item 1"));
        listPage.checkboxLineItemFirst.is().checked();

        listPage.checkboxLineItemFirst.uncheck();
        listPage.checkboxLineItemFirst.is().unchecked();

        listPage.checkboxLineItemFirst.check();
        listPage.checkboxLineItemFirst.is().checked();
    }

    @Test
    public void pinnedSubHeaderList() {
        listPage.stickyZero.is().enabled();
        listPage.stickyZero.is().text(hasToString("I'm sticky 0"));
        listPage.stickyOne.is().enabled();
        listPage.stickyOne.is().text(hasToString("I'm sticky 1"));
    }

    @Test
    public void selectedList() {
        listPage.inputSelectedListItem.is().enabled();
        listPage.inputSelectedListItem.is().text((hasToString("Inbox")));
        listPage.trashSelectedListItem.is().enabled();
        listPage.trashSelectedListItem.is().text((hasToString("Trash")));
    }

    @Test
    public void secondaryTextList() {
        listPage.enableSecondaryTextCheckbox.get(2).is().unchecked();
        listPage.enableSecondaryTextCheckbox.get(2).check();
        listPage.enableSecondaryTextCheckbox.get(2).is().checked();
        listPage.secondaryLineListItems.get(1).is().text(hasToString("Secondary text"));
        listPage.enableSecondaryTextCheckbox.get(2).uncheck();
        listPage.secondaryLineListItems.get(1).is().notVisible();
    }

    @Test
    public void switchList() {
        assertTrue(listPage.switchList.get(2).children().get(9).hasClass("MuiSwitch-switchBase"));
    }
}
