package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.tableFrame;
import static io.github.com.StaticSite.displayDataSimpleTablePage;
import static io.github.com.StaticSite.displayDataDenseTablePage;
import static io.github.com.StaticSite.displayDataStickyHeaderTablePage;
import static io.github.com.StaticSite.displayDataTableWithPaginationPage;
import static io.github.com.StaticSite.displayDataSortingTablePage;
import static io.github.com.StaticSite.displayDataSpanningTablePage;
import static org.hamcrest.Matchers.hasToString;

public class TableTests extends TestsInit {
    @Test
    public void simpleTableTests() {
        displayDataSimpleTablePage.open();

        checkColumnHeaders();

        simpleCheck();
    }

    @Test
    public void denseTableTests(){
        displayDataDenseTablePage.open();

        checkColumnHeaders();

        simpleCheck();
    }

    @Test
    public void stickyHeaderTests(){
        displayDataStickyHeaderTablePage.open();

        checkColumnHeaders();

        simpleCheck();
    }

    @Test
    public void tableWithPaginationTests(){
        displayDataTableWithPaginationPage.open();

        checkColumnHeaders();

        simpleCheck();

        tableFrame.next.click();

        checkColumnHeaders();

        tableFrame.table.is().textRow(1,1,hasToString("Row 6"));
        tableFrame.table.is().textRow(1,4,hasToString("value " + tableFrame.table.getTextOfColumn1(1)));
        tableFrame.table.is().textRow(2,1,hasToString("Row 7"));
        tableFrame.table.is().textRow(2,3,hasToString("value 7"));

        tableFrame.previous.click();

        simpleCheck();

        tableFrame.pages.click();
        tableFrame.page10.click();

        checkColumnHeaders();

        simpleCheck();

        tableFrame.table.is().textRow(6,1,hasToString("Row 6"));
        tableFrame.table.is().textRow(6,4,hasToString("value " + tableFrame.table.getTextOfColumn1(6)));
        tableFrame.table.is().textRow(7,1,hasToString("Row 7"));
        tableFrame.table.is().textRow(7,3,hasToString("value 7"));
    }

    @Test
    public void sortingTableTest(){
        displayDataSortingTablePage.open();

        for (int i = 1; i < 9; i++){
            tableFrame.table.is().increaseValue(i);
        }

        tableFrame.column2Sorting.click();

        for (int i = 1; i < 9; i++){
            tableFrame.table.is().decreaseValue(i);
        }
    }

    @Test
    public void spanningTableTest(){
        displayDataSpanningTablePage.open();

        checkColumnHeaders();

        simpleCheck();

        tableFrame.table.is().checkSubtotal(5);
    }

    private void checkColumnHeaders(){
        tableFrame.table.is().headerDisplayed(1);
        tableFrame.table.is().textHeader(1, hasToString("Sample Table"));
        tableFrame.table.is().headerDisplayed(2);
        tableFrame.table.is().textHeader(2, hasToString("Column 1"));
        tableFrame.table.is().headerDisplayed(3);
        tableFrame.table.is().textHeader(3, hasToString("Column 2"));
        tableFrame.table.is().headerDisplayed(4);
        tableFrame.table.is().textHeader(4, hasToString("Column 3"));
    }

    private void simpleCheck(){
        tableFrame.table.is().textRow(1,1,hasToString("Row 1"));
        tableFrame.table.is().textRow(1,4,hasToString("value " + tableFrame.table.getTextOfColumn1(1)));
        tableFrame.table.is().textRow(2,1,hasToString("Row 2"));
        tableFrame.table.is().textRow(2,3,hasToString("value 2"));
    }
}
