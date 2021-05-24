package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.displaydata.TablePage.*;
import static org.hamcrest.Matchers.*;

public class TableTests extends TestsInit {
    private Timer timer = new Timer(2000L);
    private Button getCell(int row, int coll) {
        return tableCells.get((row - 1) * 6 + coll);
    }

    @BeforeTest
    public void beforeTest() {
        tablePage.open();
        tablePage.isOpened();
    }

    @Test
    public void dataTableTest() {
        getCell( 1, 1).click();
        selectedRowCounter.has().text(containsString("9"));
        getCell(3, 1).click();
        getCell(5, 1).click();
        selectedRowCounter.has().text(containsString("7"));
        scrollButtons.get(2).click();
        getCell(2, 1).click();
        selectedRowCounter.has().text(containsString("6"));
        getCell(1, 5).click();
        timer.wait(() -> getCell(4, 5).has().text(containsString("150")));
    }
//    @Test
//    public void simpleTableTests() {
//        displayDataSimpleTablePage.open();
//
//        checkColumnHeaders();
//
//        simpleCheck();
//    }
//
//    @Test
//    public void denseTableTests(){
//        displayDataDenseTablePage.open();
//
//        checkColumnHeaders();
//
//        simpleCheck();
//    }
//
//    @Test
//    public void stickyHeaderTests(){
//        displayDataStickyHeaderTablePage.open();
//
//        checkColumnHeaders();
//
//        simpleCheck();
//    }
//
//    @Test
//    public void tableWithPaginationTests(){
//        displayDataTableWithPaginationPage.open();
//
//        checkColumnHeaders();
//
//        simpleCheck();
//
//        tablePage.next.click();
//
//        checkColumnHeaders();
//
//        tablePage.table.is().textRow(1,1,hasToString("Row 6"));
//        tablePage.table.is().textRow(1,4,hasToString("value " + tablePage.table.getTextOfColumn1(1)));
//        tablePage.table.is().textRow(2,1,hasToString("Row 7"));
//        tablePage.table.is().textRow(2,3,hasToString("value 7"));
//
//        tablePage.previous.click();
//
//        simpleCheck();
//
//        tablePage.pages.click();
//        tablePage.page10.click();
//
//        checkColumnHeaders();
//
//        simpleCheck();
//
//        tablePage.table.is().textRow(6,1,hasToString("Row 6"));
//        tablePage.table.is().textRow(6,4,hasToString("value " + tablePage.table.getTextOfColumn1(6)));
//        tablePage.table.is().textRow(7,1,hasToString("Row 7"));
//        tablePage.table.is().textRow(7,3,hasToString("value 7"));
//    }
//
//    @Test
//    public void sortingTableTest(){
//        displayDataSortingTablePage.open();
//
//        for (int i = 1; i < 9; i++){
//            tablePage.table.is().increaseValue(i);
//        }
//
//        tablePage.column2Sorting.click();
//
//        for (int i = 1; i < 9; i++){
//            tablePage.table.is().decreaseValue(i);
//        }
//    }
//
//    @Test
//    public void spanningTableTest(){
//        displayDataSpanningTablePage.open();
//
//        checkColumnHeaders();
//
//        simpleCheck();
//
//        tablePage.table.is().checkSubtotal(5);
//    }
//
//    private void checkColumnHeaders(){
//        tablePage.table.is().headerDisplayed(1);
//        tablePage.table.is().textHeader(1, hasToString("Sample Table"));
//        tablePage.table.is().headerDisplayed(2);
//        tablePage.table.is().textHeader(2, hasToString("Column 1"));
//        tablePage.table.is().headerDisplayed(3);
//        tablePage.table.is().textHeader(3, hasToString("Column 2"));
//        tablePage.table.is().headerDisplayed(4);
//        tablePage.table.is().textHeader(4, hasToString("Column 3"));
//    }
//
//    private void simpleCheck(){
//        tablePage.table.is().textRow(1,1,hasToString("Row 1"));
//        tablePage.table.is().textRow(1,4,hasToString("value " + tablePage.table.getTextOfColumn1(1)));
//        tablePage.table.is().textRow(2,1,hasToString("Row 2"));
//        tablePage.table.is().textRow(2,3,hasToString("value 2"));
//    }
}
