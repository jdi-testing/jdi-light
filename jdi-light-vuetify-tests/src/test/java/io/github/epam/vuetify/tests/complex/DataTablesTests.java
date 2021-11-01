package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.vuetify.elements.enums.TableTestData;
import com.epam.jdi.tools.Timer;
import static io.github.com.StaticSite.dataTablesPage;
import static io.github.com.pages.DataTablesPage.cRUDActionsTable;
import static io.github.com.pages.DataTablesPage.customFilter;
import static io.github.com.pages.DataTablesPage.denseTable;
import static io.github.com.pages.DataTablesPage.editDialogTable;
import static io.github.com.pages.DataTablesPage.expandableRowsTable;
import static io.github.com.pages.DataTablesPage.externalPaginationTable;
import static io.github.com.pages.DataTablesPage.externalSortingTable;
import static io.github.com.pages.DataTablesPage.filterableTable;
import static io.github.com.pages.DataTablesPage.footerPropsTable;
import static io.github.com.pages.DataTablesPage.groupingTable;
import static io.github.com.pages.DataTablesPage.headerTable;
import static io.github.com.pages.DataTablesPage.hideHeaderFooterTable;
import static io.github.com.pages.DataTablesPage.itemTable;
import static io.github.com.pages.DataTablesPage.loadingTable;
import static io.github.com.pages.DataTablesPage.multiSortTable;
import static io.github.com.pages.DataTablesPage.rowSelectionTable;
import static io.github.com.pages.DataTablesPage.searchTable;
import static io.github.com.pages.DataTablesPage.serverSideTable;
import static io.github.com.pages.DataTablesPage.simpleCheckboxTable;
import static io.github.com.pages.DataTablesPage.slotsTable;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataTablesTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        dataTablesPage.open();
    }

    @Test
    public static void customFilterTableTest() {
        customFilter.rowsPerPage(1);
        jdiAssert(customFilter.elementsInColumn(1), Matchers.is(6));
        customFilter.nextPage();
        jdiAssert(customFilter.elementsInColumn(1), Matchers.is(6));
    }

    @Test
    public static void denseTableTest() {
        denseTable.rowsPerPage(1);
        jdiAssert(denseTable.elementsInColumn(1), Matchers.is(5));
        denseTable.nextPage();
        jdiAssert(denseTable.elementsInColumn(1), Matchers.is(5));
        denseTable.previousPage();
        denseTable.rowsPerPage(2);
        jdiAssert(denseTable.elementsInColumn(1), Matchers.is(10));
    }

    @Test
    public static void filterableTableTest() {
        filterableTable.search(TableTestData.KITKAT_CALORIES);
        jdiAssert(filterableTable.firstColumnElement(1), Matchers.is("KitKat"));
        filterableTable.clear();
        filterableTable.sortDescBy("Fat (g)");
    }

    @Test
    public static void footerPropsTableTest() {
        jdiAssert(footerPropsTable.firstColumnElement(2), Matchers.is("Ice cream sandwich"));
        jdiAssert(footerPropsTable.secondColumnElement(2), Matchers.is("Ice cream"));
        footerPropsTable.sortAscBy("Category");
        jdiAssert(footerPropsTable.firstColumnElement(1), Matchers.is("Jelly bean"));
        jdiAssert(footerPropsTable.secondColumnElement(2), Matchers.is("Candy"));
    }

    @Test
    public static void groupingTableTest() {
        groupingTable.collapseGroup("category: Cookie");
        groupingTable.expandGroup("category: Cookie");
        groupingTable.sortGroup("Diary");
        groupingTable.removeGroups();
        groupingTable.group();
        groupingTable.sortGroup("Category");
        jdiAssert(groupingTable.groups().get(1).text(), Matchers.is("dairy: No"));
    }

    @Test
    public static void hideHeaderFooterTableTest() {
        hideHeaderFooterTable.has().firstColumnHasElement(2, TableTestData.ICE_CREAM_SANDWICH);
        jdiAssert(hideHeaderFooterTable.columnElement(6, 3), Matchers.is("7%"));
        hideHeaderFooterTable.has().firstColumnHasElement(8, TableTestData.HONEYCOMB);
        hideHeaderFooterTable.has().secondColumnHasElement(8, TableTestData.HONEYCOMB_CALORIES);
    }

    @Test
    public static void loadingTableTest() {
        jdiAssert(loadingTable.isLoading(), Matchers.is(true));
    }

    @Test
    public static void multiSortTableTest() {
        multiSortTable.sortOff("Calories");
        multiSortTable.sortDescBy("Protein");
        multiSortTable.has().firstColumnHasElement(1, TableTestData.KITKAT);
        jdiAssert(multiSortTable.isSortedBy("Protein"), Matchers.is(true));
        jdiAssert(multiSortTable.isSortedBy("Fat"), Matchers.is(true));

        multiSortTable.sortOff("Protein");
        multiSortTable.sortOff("Fat");
        multiSortTable.has().firstColumnHasElement(1, TableTestData.FROZEN_YOGURT);
        jdiAssert(multiSortTable.isSortedBy("Protein"), Matchers.is(false));
        jdiAssert(multiSortTable.isSortedBy("Fat"), Matchers.is(false));
    }

    @Test
    public static void rowSelectionTableTest() {
        rowSelectionTable.getColumn(1).select(1);
        jdiAssert(rowSelectionTable.isSelected(1, 1), Matchers.is(true));
        jdiAssert(rowSelectionTable.isSelected(1, 2), Matchers.is(false));

        rowSelectionTable.getColumn(1).select(3);
        jdiAssert(rowSelectionTable.isSelected(1, 3), Matchers.is(true));

        rowSelectionTable.singleSelectOn();
        rowSelectionTable.getColumn(1).select(1);
        jdiAssert(rowSelectionTable.isSelected(1, 1), Matchers.is(false));
        jdiAssert(rowSelectionTable.isSelected(1, 2), Matchers.is(false));
        rowSelectionTable.getColumn(1).select(2);
        jdiAssert(rowSelectionTable.isSelected(1, 1), Matchers.is(false));
        jdiAssert(rowSelectionTable.isSelected(1, 2), Matchers.is(true));
        rowSelectionTable.getColumn(1).select(3);
        jdiAssert(rowSelectionTable.isSelected(1, 2), Matchers.is(false));
        jdiAssert(rowSelectionTable.isSelected(1, 3), Matchers.is(true));
    }

    @Test
    public static void searchTableTest() {
        searchTable.search(TableTestData.DONUT);
        searchTable.has().firstColumnHasElement(1, TableTestData.DONUT);
        searchTable.clear();
        searchTable.search(TableTestData.ECLAIR_CALORIES);
        searchTable.has().firstColumnHasElement(1, TableTestData.ECLAIR);
    }

    @Test
    public static void slotsTableTest() {
        slotsTable.expand();
        slotsTable.selectOption(1);
        jdiAssert(slotsTable.columnElement(3, 2), Matchers.is("CONTENT"));

        slotsTable.expand();
        slotsTable.selectOption(3);
        jdiAssert(slotsTable.firstColumnElement(1), Matchers.is("This is a prepended row"));

        slotsTable.expand();
        slotsTable.selectOption(6);
        jdiAssert(slotsTable.header().get(0), Matchers.is("This is a header"));

        slotsTable.expand();
        slotsTable.selectOption(8);
        slotsTable.getColumn(1).select(1);
        slotsTable.getColumn(1).select(4);
        slotsTable.getColumn(1).select(7);
        jdiAssert(slotsTable.isSelected(1, 1), Matchers.is(true));
        jdiAssert(slotsTable.isSelected(1, 4), Matchers.is(true));
        jdiAssert(slotsTable.isSelected(1, 7), Matchers.is(true));
    }

    @Test
    public static void headerTableTest() {
        jdiAssert(headerTable.headerUI().get(1).text(), Matchers.is("DESSERT (100G SERVING)"));
        jdiAssert(headerTable.headerUI().get(3).text(), Matchers.is("Fat (g)"));
        jdiAssert(headerTable.headerUI().get(5).text(), Matchers.is("Protein (g)"));
    }

    @Test
    public static void itemTableTest() {
        jdiAssert(itemTable.elIsGreen(2, 1), Matchers.is(true));
        jdiAssert(itemTable.elIsOrange(2, 4), Matchers.is(true));
        jdiAssert(itemTable.elIsRed(2, 10), Matchers.is(true));
    }

    @Test
    public static void simpleCheckboxTableTest() {
        jdiAssert(simpleCheckboxTable.isSelected(7, 1), Matchers.is(true));
        jdiAssert(simpleCheckboxTable.isSelected(7, 2), Matchers.is(false));
        jdiAssert(simpleCheckboxTable.isSelected(7, 5), Matchers.is(true));
    }

    @Test
    public static void cRUDActionsTableTest() {
        cRUDActionsTable.createWithSave("Egg", "72", "4.8", "0.4", "6.3");
        jdiAssert(cRUDActionsTable.columnElement(1, 1), Matchers.is("Egg"));

        cRUDActionsTable.createWithoutSave("Milk", "61", "3.3", "4.8", "3.2");
        jdiAssert(cRUDActionsTable.getColumn(1).get("Milk").isExist(), Matchers.is(false));
    }

    @Test
    public static void editDialogTableTest() {
        editDialogTable.editElement(3, "New Element");
        editDialogTable.confirm();
        jdiAssert(editDialogTable.firstColumnElement(3), Matchers.is("New Element"));
        editDialogTable.editElement(6, "New Element2");
        editDialogTable.cancel();
        editDialogTable.has().firstColumnHasElement(6, TableTestData.JELLY_BEAN);
    }

    @Test
    public static void expandableRowsTableTest() {
        expandableRowsTable.expand(1);
        jdiAssert(expandableRowsTable.isExpanded(1), Matchers.is(true));
        expandableRowsTable.expand(2);
        jdiAssert(expandableRowsTable.isExpanded(2), Matchers.is(true));
        expandableRowsTable.singleSelectOn();
        expandableRowsTable.expand(3);
        jdiAssert(expandableRowsTable.isExpanded(3), Matchers.is(true));
        jdiAssert(expandableRowsTable.isExpanded(2), Matchers.is(false));
        jdiAssert(expandableRowsTable.isExpanded(1), Matchers.is(false));
    }

    @Test
    public static void externalPaginationTableTest() {
        externalPaginationTable.itemsPerPage("7");
        externalPaginationTable.firstPage();
        externalPaginationTable.has().size(7);
        externalPaginationTable.secondPage();
        externalPaginationTable.has().size(3);
    }

    @Test
    public static void externalSortingTableTest() {
        externalSortingTable.sortWithButtonAsc(4);
        externalSortingTable.has().firstColumnHasElement(TableTestData.ECLAIR);
        externalSortingTable.sortNextColumn();
        externalSortingTable.has().firstColumnHasElement(TableTestData.JELLY_BEAN);
    }

    @Test
    public static void serverSideTableTest() {
        Timer timer = new Timer(2000L);
        serverSideTable.sortDescBy("Calories");
        timer.wait(() -> serverSideTable.has().firstColumnHasElement(TableTestData.KITKAT));
    }
}
