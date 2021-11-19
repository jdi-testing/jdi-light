package io.github.epam.vuetify.tests.complex;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.DONUT;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.ECLAIR;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.ECLAIR_CALORIES;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.FROZEN_YOGURT;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.HONEYCOMB;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.HONEYCOMB_CALORIES;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.ICE_CREAM_SANDWICH;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.JELLY_BEAN;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.KITKAT;
import static com.epam.jdi.light.vuetify.elements.enums.TableTestData.KITKAT_CALORIES;
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
        customFilter.assertThat().elementsValueInColumn(1, 6);
        customFilter.nextPage();
        customFilter.assertThat().elementsValueInColumn(1, 6);
    }

    @Test
    public static void denseTableTest() {
        denseTable.rowsPerPage(1);
        denseTable.assertThat().elementsValueInColumn(1, 5);
        denseTable.nextPage();
        denseTable.assertThat().elementsValueInColumn(1, 5);
        denseTable.previousPage();
        denseTable.rowsPerPage(2);
        denseTable.assertThat().elementsValueInColumn(1, 10);
    }

    @Test
    public static void filterableTableTest() {
        filterableTable.search(KITKAT_CALORIES.value());
        filterableTable.assertThat().elementName(1, KITKAT.value());
        filterableTable.clear();
        filterableTable.sortDescBy("Fat (g)");
    }

    @Test
    public static void footerPropsTableTest() {
        footerPropsTable.assertThat().elementName(2, ICE_CREAM_SANDWICH.value())
                .and().elementValue(2, "Ice cream");
        footerPropsTable.sortAscBy("Category");
        footerPropsTable.assertThat().elementName(1, JELLY_BEAN.value())
                .and().elementValue(2, "Candy");
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
        hideHeaderFooterTable.assertThat().firstColumnHasElement(2, ICE_CREAM_SANDWICH.value());
        hideHeaderFooterTable.assertThat().elementValue(6, 3, "7%");
        hideHeaderFooterTable.assertThat().firstColumnHasElement(8, HONEYCOMB.value());
        hideHeaderFooterTable.assertThat().secondColumnHasElement(8, HONEYCOMB_CALORIES.value());
    }

    @Test
    public static void loadingTableTest() {
        loadingTable.is().loading();
    }

    @Test
    public static void multiSortTableTest() {
        multiSortTable.sortOff("Calories");
        multiSortTable.sortDescBy("Protein");
        multiSortTable.has().firstColumnHasElement(1, KITKAT.value());
        multiSortTable.is().sortedBy("Protein").and().sortedBy("Fat");

        multiSortTable.sortOff("Protein");
        multiSortTable.sortOff("Fat");
        multiSortTable.has().firstColumnHasElement(1, FROZEN_YOGURT.value());
        multiSortTable.is().notSortedBy("Protein").and().notSortedBy("Fat");
    }

    @Test
    public static void rowSelectionTableTest() {
        rowSelectionTable.getColumn(1).select(1);
        rowSelectionTable.assertThat().elementSelected(1, 1).and().elementNotSelected(1, 2);

        rowSelectionTable.getColumn(1).select(3);
        rowSelectionTable.assertThat().elementSelected(1, 3);

        rowSelectionTable.singleSelectOn();
        rowSelectionTable.getColumn(1).select(1);
        rowSelectionTable.assertThat().elementNotSelected(1, 1).and().elementNotSelected(1, 2);

        verifyElements(2, 1);
        verifyElements(3, 2);
    }

    @Test
    public static void searchTableTest() {
        searchTable.search(DONUT.value());
        searchTable.has().firstColumnHasElement(1, DONUT.value());
        searchTable.clear();
        searchTable.search(ECLAIR_CALORIES.value());
        searchTable.has().firstColumnHasElement(1, ECLAIR.value());
    }

    @Test
    public static void slotsTableTest() {
        slotsTable.expand();
        slotsTable.selectOption(1);
        slotsTable.assertThat().elementValue(3, 2, "CONTENT");

        slotsTable.expand();
        slotsTable.selectOption(3);
        slotsTable.assertThat().elementName(1, "This is a prepended row");

        slotsTable.expand();
        slotsTable.selectOption(6);
        jdiAssert(slotsTable.header().get(0), Matchers.is("This is a header"));

        slotsTable.expand();
        slotsTable.selectOption(8);
        slotsTable.getColumn(1).select(1);
        slotsTable.getColumn(1).select(4);
        slotsTable.getColumn(1).select(7);
        slotsTable.assertThat().elementSelected(1, 1).and().elementSelected(1, 4)
                .and().elementSelected(1, 7);
    }

    @Test
    public static void headerTableTest() {
        headerTable.assertThat().header(1, "DESSERT (100G SERVING)")
                .and().header(3, "Fat (g)")
                .and().header(5, "Protein (g)");
    }

    @Test
    public static void itemTableTest() {
        itemTable.assertThat().elementIsGreen(2, 1)
                .and().elementIsOrange(2, 4)
                .and().elementIsRed(2, 10);
    }

    @Test
    public static void simpleCheckboxTableTest() {
        simpleCheckboxTable.assertThat().elementSelected(7, 1)
                .and().elementNotSelected(7, 2)
                .and().elementSelected(7, 5);
    }

    @Test
    public static void cRUDActionsTableTest() {
        cRUDActionsTable.createWithSave("Egg", "72", "4.8", "0.4", "6.3");
        cRUDActionsTable.assertThat().elementName(1, "Egg");

        cRUDActionsTable.createWithoutSave("Milk", "61", "3.3", "4.8", "3.2");
        jdiAssert(cRUDActionsTable.getColumn(1).get("Milk").isExist(), Matchers.is(false));
    }

    @Test
    public static void editDialogTableTest() {
        editDialogTable.editElement(3, "New Element");
        editDialogTable.confirm();
        editDialogTable.assertThat().elementName(3, "New Element");
        editDialogTable.editElement(6, "New Element2");
        editDialogTable.cancel();
        editDialogTable.assertThat().firstColumnHasElement(6, JELLY_BEAN.value());
    }

    @Test
    public static void expandableRowsTableTest() {
        expandableRowsTable.expand(1);
        expandableRowsTable.expand(2);
        expandableRowsTable.assertThat().elementExpanded(1).and().elementExpanded(2);

        expandableRowsTable.singleSelectOn();
        expandableRowsTable.expand(3);
        expandableRowsTable.assertThat().elementExpanded(3)
                .and().elementCollapsed(2).and().elementCollapsed(1);
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
        externalSortingTable.has().firstColumnHasElement(ECLAIR.value());
        externalSortingTable.sortNextColumn();
        externalSortingTable.has().firstColumnHasElement(JELLY_BEAN.value());
    }

    @Test
    public static void serverSideTableTest() {
        serverSideTable.sortDescBy("Calories");
        serverSideTable.waitFor().firstColumnHasElement(KITKAT.value());
    }

    //selects required element and verifies, that current element selected and previous element not selected
    public static void verifyElements(int reqEl, int prevEl) {
        rowSelectionTable.getColumn(1).select(reqEl);
        rowSelectionTable.assertThat().elementNotSelected(1, prevEl)
                .and().elementSelected(1, reqEl);
    }
}
