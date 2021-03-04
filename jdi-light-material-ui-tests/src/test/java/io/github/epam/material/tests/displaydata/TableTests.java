package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static org.hamcrest.Matchers.hasToString;

public class TableTests extends TestsInit {
    @Test
    public void simpleTableTests() {
        displayDataSimpleTablePage.open();

        checkHeader();

        simpleCheck();
    }

    @Test
    public void denseTableTests(){
        displayDataDenseTablePage.open();

        checkHeader();

        simpleCheck();
    }

    @Test
    public void stickyHeaderTests(){
        displayDataStickyHeaderTablePage.open();

        checkHeader();

        simpleCheck();
    }

    @Test
    public void tableWithPaginationTests(){
        displayDataTableWithPaginationPage.open();

        checkHeader();

        simpleCheck();

        tableFrame.next.click();

        checkHeader();

        tableFrame.table.is().textRow(1,1,hasToString("Row 6"));
        tableFrame.table.is().textRow(1,4,hasToString("value " + tableFrame.table.getTextOfColumn1(1)));
        tableFrame.table.is().textRow(2,1,hasToString("Row 7"));
        tableFrame.table.is().textRow(2,3,hasToString("value 7"));

        tableFrame.pages.click();
        tableFrame.page10.click();

        checkHeader();

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

        checkHeader();

        simpleCheck();

        tableFrame.table.is().checkSubtotal(5);
    }

    private void checkHeader(){
        tableFrame.table.is().headerDisplayed(1);
        tableFrame.table.is().textHeader(1, hasToString("Sample Table"));
        tableFrame.table.is().headerDisplayed(2);
        tableFrame.table.is().textHeader(2, hasToString("Column 1"));
    }

    private void simpleCheck(){
        tableFrame.table.is().textRow(1,1,hasToString("Row 1"));
        tableFrame.table.is().textRow(1,4,hasToString("value " + tableFrame.table.getTextOfColumn1(1)));
        tableFrame.table.is().textRow(2,1,hasToString("Row 2"));
        tableFrame.table.is().textRow(2,3,hasToString("value 2"));
    }
}
