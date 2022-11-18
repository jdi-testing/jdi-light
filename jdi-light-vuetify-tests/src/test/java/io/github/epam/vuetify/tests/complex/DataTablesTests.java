package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.common.Chip;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.dataTablesPage;
import static io.github.com.enums.TableTestData.CUPCAKE;
import static io.github.com.enums.TableTestData.DONUT;
import static io.github.com.enums.TableTestData.ECLAIR;
import static io.github.com.enums.TableTestData.ECLAIR_CALORIES;
import static io.github.com.enums.TableTestData.FROZEN_YOGURT;
import static io.github.com.enums.TableTestData.HONEYCOMB;
import static io.github.com.enums.TableTestData.HONEYCOMB_CALORIES;
import static io.github.com.enums.TableTestData.ICE_CREAM_SANDWICH;
import static io.github.com.enums.TableTestData.JELLY_BEAN;
import static io.github.com.enums.TableTestData.KITKAT;
import static io.github.com.enums.TableTestData.KITKAT_CALORIES;
import static io.github.com.enums.TableTestData.LOLLIPOP;
import static io.github.com.pages.DataTablesPage.cRUDActionsTable;
import static io.github.com.pages.DataTablesPage.customFilter;
import static io.github.com.pages.DataTablesPage.denseTable;
import static io.github.com.pages.DataTablesPage.editDialogMenu;
import static io.github.com.pages.DataTablesPage.editDialogTable;
import static io.github.com.pages.DataTablesPage.expandableRowsTable;
import static io.github.com.pages.DataTablesPage.expandableRowsTableSingleExpand;
import static io.github.com.pages.DataTablesPage.externalPaginationTable;
import static io.github.com.pages.DataTablesPage.externalSortingNextColumn;
import static io.github.com.pages.DataTablesPage.externalSortingTable;
import static io.github.com.pages.DataTablesPage.externalSortingToggle;
import static io.github.com.pages.DataTablesPage.filterableTable;
import static io.github.com.pages.DataTablesPage.filterableTableSearchField;
import static io.github.com.pages.DataTablesPage.footerPropsTable;
import static io.github.com.pages.DataTablesPage.groupingTable;
import static io.github.com.pages.DataTablesPage.headerTable;
import static io.github.com.pages.DataTablesPage.hideHeaderFooterTable;
import static io.github.com.pages.DataTablesPage.itemTable;
import static io.github.com.pages.DataTablesPage.loadingTable;
import static io.github.com.pages.DataTablesPage.multiSortTable;
import static io.github.com.pages.DataTablesPage.newItemButton;
import static io.github.com.pages.DataTablesPage.newItemCard;
import static io.github.com.pages.DataTablesPage.rowSelectionTable;
import static io.github.com.pages.DataTablesPage.rowSelectionTableSingleSelect;
import static io.github.com.pages.DataTablesPage.searchTable;
import static io.github.com.pages.DataTablesPage.searchTableField;
import static io.github.com.pages.DataTablesPage.serverSideTable;
import static io.github.com.pages.DataTablesPage.simpleCheckboxTable;
import static io.github.com.pages.DataTablesPage.slotsSelect;
import static io.github.com.pages.DataTablesPage.slotsTable;


public class DataTablesTests extends TestsInit {
    @BeforeClass
    public static void setup() {
        dataTablesPage.open();
        waitCondition(() -> dataTablesPage.isOpened());
        dataTablesPage.checkOpened();
    }

    @Test
    public static void customFilterTableTest() {
        customFilter.show();
        customFilter.rowsPerPage("5");
        customFilter.assertThat().size(6);
        customFilter.nextPage();
        customFilter.assertThat().size(6);
    }

    @Test
    public static void denseTableTest() {
        denseTable.show();
        denseTable.rowsPerPage("5");
        denseTable.assertThat().size(5);
        denseTable.nextPage();
        denseTable.assertThat().size(5);
        denseTable.previousPage();
        denseTable.rowsPerPage("10");
        denseTable.assertThat().size(10);
    }

    @Test
    public static void filterableTableTest() {
        filterableTableSearchField.show();
        filterableTableSearchField.clearAndTypeText(KITKAT_CALORIES.value());
        filterableTable.assertThat().elementHasName(1, KITKAT.value());
        filterableTable.clear();
        filterableTable.sortDescBy("Fat (g)");
    }

    @Test
    public static void footerPropsTableTest() {
        footerPropsTable.show();
        footerPropsTable.assertThat().elementHasName(2, ICE_CREAM_SANDWICH.value())
                .and().elementValue(2, 2, "Ice cream");
        footerPropsTable.sortAscBy("Category");
        footerPropsTable.assertThat().elementHasName(1, JELLY_BEAN.value())
                .and().elementValue(2, 2, "Candy");
    }

    @Test
    public static void groupingTableItemTest() {
        groupingTable.show();
        String groupName = "Category: Cookie";
        groupingTable.collapseGroup(groupName);
        groupingTable.assertThat().groupCollapsed(groupName);
        groupingTable.expandGroup(groupName);
        groupingTable.assertThat().groupExpanded(groupName);
    }

    @Test
    public static void groupingTableGroupingTest() {
        groupingTable.group("dairy");
        groupingTable.assertThat().hasGroup("Dairy: No");
        groupingTable.removeGroups();
        jdiAssert(groupingTable.groups().size(), Matchers.is(0));
        groupingTable.group("Category");
        groupingTable.assertThat().hasGroup("Category: Cookie");
    }

    @Test
    public static void hideHeaderFooterTableTest() {
        hideHeaderFooterTable.show();
        hideHeaderFooterTable.assertThat().elementHasName(2, ICE_CREAM_SANDWICH.value());
        hideHeaderFooterTable.assertThat().elementValue(6, 3, "7%");
        hideHeaderFooterTable.assertThat().elementHasName(8, HONEYCOMB.value());
        hideHeaderFooterTable.assertThat().elementValue(2, 8, HONEYCOMB_CALORIES.value());
    }

    @Test
    public static void loadingTableTest() {
        loadingTable.show();
        loadingTable.is().loading();
    }

    @Test
    public static void multiSortTableTest() {
        multiSortTable.show();
        multiSortTable.sortOff("Calories");
        multiSortTable.sortDescBy("Protein");
        multiSortTable.has().cellHasValue(1, 1, KITKAT.value());
        multiSortTable.is().sortedBy("Protein").and().sortedBy("Fat");

        multiSortTable.sortOff("Protein");
        multiSortTable.sortOff("Fat");
        multiSortTable.has().cellHasValue(1, 1, FROZEN_YOGURT.value());
        multiSortTable.is().notSortedBy("Protein").and().notSortedBy("Fat");
    }

    @Test
    public static void rowSelectionTableTest() {
        rowSelectionTable.show();
        rowSelectionTable.getColumn(1).select(1);
        rowSelectionTable.assertThat().cellSelected(1, 1).and().cellNotSelected(1, 2);

        rowSelectionTable.getColumn(1).select(3);
        rowSelectionTable.assertThat().cellSelected(1, 3);

        rowSelectionTableSingleSelect.check();
        rowSelectionTable.getColumn(1).select(1);
        rowSelectionTable.assertThat().cellNotSelected(1, 1).and().cellNotSelected(1, 2);

        verifyElements(2, 1);
        verifyElements(3, 2);
    }

    @Test
    public static void searchTableTest() {
        searchTableField.show();
        searchTableField.clearAndTypeText(DONUT.value());
        searchTable.has().cellHasValue(1, 1, DONUT.value());
        searchTable.clear();
        searchTableField.clearAndTypeText(ECLAIR_CALORIES.value());
        searchTable.has().cellHasValue(1, 1, ECLAIR.value());
    }

    @Test
    public static void slotsTableTest() {
        slotsTable.show();
        slotsSelect.close();
        slotsSelect.select("body");
        slotsTable.assertThat().elementValue(3, 2, "CONTENT");

        slotsSelect.close();
        slotsSelect.select("body.prepend");
        slotsTable.assertThat().elementHasName(1, "This is a prepended row");

        slotsSelect.close();
        slotsSelect.select("header");
        jdiAssert(slotsTable.header().get(0), Matchers.is("This is a header"));

        slotsSelect.close();
        slotsSelect.select("item.data-table-select");
        slotsTable.getColumn(1).select(1);
        slotsTable.getColumn(1).select(4);
        slotsTable.getColumn(1).select(7);
        slotsTable.assertThat().cellSelected(1, 1).and().cellSelected(1, 4)
                .and().cellSelected(1, 7);
    }

    @Test
    public static void headerTableTest() {
        headerTable.show();
        headerTable.assertThat().header(1, "DESSERT (100G SERVING)")
                .and().header(3, "Fat (g)")
                .and().header(5, "Protein (g)");
    }

    @Test
    public static void itemTableTest() {
        itemTable.show();
        for (Chip chip : itemTable.getChips()) {
            jdiAssert(itemTable.getColor(Integer.parseInt(chip.getText())), Matchers.is(chip.backgroundColor()));
        }
    }

    @Test
    public static void simpleCheckboxTableTest() {
        simpleCheckboxTable.show();
        simpleCheckboxTable.assertThat().cellSelected(7, 1)
                .and().cellNotSelected(7, 2)
                .and().cellSelected(7, 5);
    }

    @Test
    public static void cRUDActionsTableSaveTest() {
        newItemButton.show();
        newItemButton.click();
        newItemCard.fill("Egg", "72", "4.8", "0.4", "6.3");
        newItemCard.save();
        cRUDActionsTable.assertThat().elementHasName(1, "Egg");
    }

    @Test
    public static void cRUDActionsTableCancelTest() {
        newItemButton.show();
        newItemButton.click();
        newItemCard.fill("Milk", "61", "3.3", "4.8", "3.2");
        newItemCard.cancel();
        jdiAssert(cRUDActionsTable.getColumn(1).get("Milk").isExist(), Matchers.is(false));
    }

    @Test
    public static void editDialogTableSaveTest() {
        editDialogTable.show();
        editDialogTable.getColumn(1).select(3);
        waitCondition(() -> editDialogMenu.isDisplayed());
        editDialogMenu.clearTextField();
        editDialogMenu.find("input").sendKeys("New Element");
        editDialogMenu.press(Keys.ENTER);
        editDialogTable.assertThat().elementHasName(3, "New Element");
    }

    @Test
    public static void editDialogTableCancelTest() {
        editDialogTable.show();
        editDialogTable.getColumn(1).select(6);
        editDialogMenu.clearTextField();
        editDialogMenu.find("input").sendKeys("New Element 2");
        editDialogMenu.press(Keys.ESCAPE);
        editDialogTable.assertThat().cellHasValue(1, 6, JELLY_BEAN.value());
    }

    @Test
    public static void expandableRowsTableTest() {
        expandableRowsTable.show();
        expandableRowsTable.expandRow(1);
        expandableRowsTable.expandRow(2);
        expandableRowsTable.assertThat().rowExpanded(1).and().rowExpanded(2);

        expandableRowsTableSingleExpand.check();
        expandableRowsTable.expandRow(3);
        expandableRowsTable.assertThat().rowExpanded(3)
                .and().rowCollapsed(2).and().rowCollapsed(1);
    }

    @Test
    public static void externalPaginationTableTest() {
        externalPaginationTable.show();
        externalPaginationTable.itemsPerPage("7");
        externalPaginationTable.goToPage(1);
        externalPaginationTable.has().size(7);
        externalPaginationTable.nextPage();
        externalPaginationTable.has().size(3);
    }

    @Test
    public static void externalSortingTableTest() {
        externalSortingTable.show();
        while (!externalSortingTable.isSortedBy("Dessert (100g serving)")) {
            externalSortingNextColumn.click();
        }
        externalSortingTable.assertThat().elementHasName(1, CUPCAKE.value());
        externalSortingToggle.click();
        externalSortingTable.assertThat().elementHasName(1, LOLLIPOP.value());
        externalSortingNextColumn.click();
        externalSortingTable.assertThat().sortedBy("Calories");
        externalSortingTable.assertThat().elementHasName(1, KITKAT.value());
        externalSortingToggle.click();
        externalSortingTable.assertThat().elementHasName(1, FROZEN_YOGURT.value());
    }

    @Test
    public static void serverSideTableTest() {
        serverSideTable.show();
        serverSideTable.sortDescBy("Calories");
        serverSideTable.waitFor().columnHasValue(1, KITKAT.value());
    }

    //selects required element and verifies, that current element selected and previous element not selected
    public static void verifyElements(int reqEl, int prevEl) {
        rowSelectionTable.getColumn(1).select(reqEl);
        rowSelectionTable.assertThat().cellNotSelected(1, prevEl)
                .and().cellSelected(1, reqEl);
    }
}
