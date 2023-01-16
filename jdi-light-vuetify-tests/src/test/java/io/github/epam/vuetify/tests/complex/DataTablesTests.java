package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.common.Chip;
import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.dataTablesPage;
import static io.github.com.enums.TableTestData.CUPCAKE;
import static io.github.com.enums.TableTestData.CUPCAKE_PROTEIN;
import static io.github.com.enums.TableTestData.DONUT;
import static io.github.com.enums.TableTestData.ECLAIR;
import static io.github.com.enums.TableTestData.ECLAIR_CALORIES;
import static io.github.com.enums.TableTestData.FROZEN_YOGURT;
import static io.github.com.enums.TableTestData.FROZEN_YOGURT_IRON;
import static io.github.com.enums.TableTestData.GINGERBREAD;
import static io.github.com.enums.TableTestData.ICE_CREAM_SANDWICH;
import static io.github.com.enums.TableTestData.JELLY_BEAN;
import static io.github.com.enums.TableTestData.KITKAT;
import static io.github.com.enums.TableTestData.LOLLIPOP;
import static io.github.com.pages.DataTablesPage.crudActionsTable;
import static io.github.com.pages.DataTablesPage.customFilter;
import static io.github.com.pages.DataTablesPage.customFilterInputField;
import static io.github.com.pages.DataTablesPage.customFilterSearchField;
import static io.github.com.pages.DataTablesPage.darkTable;
import static io.github.com.pages.DataTablesPage.denseTable;
import static io.github.com.pages.DataTablesPage.disabledPaginationTable;
import static io.github.com.pages.DataTablesPage.disabledSortTable;
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
import static io.github.com.pages.DataTablesPage.fixedHeaderTable;
import static io.github.com.pages.DataTablesPage.footerPropsTable;
import static io.github.com.pages.DataTablesPage.groupingTable;
import static io.github.com.pages.DataTablesPage.headerTable;
import static io.github.com.pages.DataTablesPage.hideHeaderFooterTable;
import static io.github.com.pages.DataTablesPage.itemTable;
import static io.github.com.pages.DataTablesPage.loadingTable;
import static io.github.com.pages.DataTablesPage.multiSortTable;
import static io.github.com.pages.DataTablesPage.mustSortTable;
import static io.github.com.pages.DataTablesPage.newItemButton;
import static io.github.com.pages.DataTablesPage.newItemCard;
import static io.github.com.pages.DataTablesPage.rowSelectionTable;
import static io.github.com.pages.DataTablesPage.rowSelectionTableSingleSelect;
import static io.github.com.pages.DataTablesPage.searchTable;
import static io.github.com.pages.DataTablesPage.searchTableField;
import static io.github.com.pages.DataTablesPage.simpleCheckboxTable;

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

        customFilterSearchField.clearTextField();
        customFilterSearchField.typeText("G");

        customFilter.sortDescBy("Calories");
        customFilter.has()
            .elementValue(1, 1, GINGERBREAD.value())
            .elementValue(1, 2, FROZEN_YOGURT.value());

        customFilterInputField.clearTextField();
        customFilterInputField.typeText("300");

        customFilter.has()
                    .size(2)
                    .elementValue(1, 1, FROZEN_YOGURT.value());
    }

    @Test
    public static void denseTableTest() {
        denseTable.is().dense();
    }

    @Test(description = "Test filtering and sorting combined")
    public static void filterableTableTest() {
        filterableTableSearchField.show();
        filterableTableSearchField.clearAndTypeText(CUPCAKE_PROTEIN.value());

        filterableTable.clear();
        filterableTable.sortDescBy("Fat (g)");

        filterableTable.has()
                       .elementName(1, ICE_CREAM_SANDWICH.value())
                       .elementName(2, CUPCAKE.value());
    }

    @Test(description = "Test table is empty when filtering by the first column")
    public void cannotFilterByTheFirstColumnTest() {
        filterableTableSearchField.show();
        filterableTableSearchField.clearAndTypeText(ICE_CREAM_SANDWICH.value());

        filterableTable.clear();
        filterableTable.has().elementName(1, "No matching records found");
    }

    @Test(description = "Test footer buttons are enabled")
    public static void footerPropsTableTest() {
        footerPropsTable.show();

        footerPropsTable.has()
                        .currentPage(1)
                        .numberOfRowsPerPageInput(true)
                        .nextPageButton(true)
                        .lastPageButton(true);

        footerPropsTable.nextPage();
        footerPropsTable.has()
                        .currentPage(2)
                        .firstPageButton(true)
                        .previousPageButton(true);

        footerPropsTable.selectNumberOfRowsPerPage("All");
        footerPropsTable.has()
                       .firstPageButton(false)
                       .previousPageButton(false)
                       .numberOfRowsPerPageInput(true)
                       .nextPageButton(false)
                       .lastPageButton(false);
    }

    @Test(description = "Test last/first page buttons are enabled")
    public void footerPropsTableFirstLastPageTest() {
        footerPropsTable.show();

        footerPropsTable.lastPage();
        footerPropsTable.has()
                        .elementName(1, JELLY_BEAN.value());

        footerPropsTable.firstPage();
        footerPropsTable.has()
                        .elementName(1, FROZEN_YOGURT.value());
    }

    @Test(description = "Test footer buttons are disabled")
    public void disabledPaginationFooterTest() {
        disabledPaginationTable.show();

        disabledPaginationTable.has()
                               .firstPageButton(false)
                               .previousPageButton(false)
                               .numberOfRowsPerPageInput(false)
                               .nextPageButton(false)
                               .lastPageButton(false);
    }

    @Test(description = "Test expand/collapse group")
    public static void groupingTableItemTest() {
        groupingTable.show();
        String groupName = "Category: Cookie";

        groupingTable.collapseGroup(groupName);
        groupingTable.has().groupCollapsed(groupName);

        groupingTable.expandGroup(groupName);
        groupingTable.has().groupExpanded(groupName);
    }

    @Test(description = "Test switching groups")
    public static void groupingTableGroupingTest() {
        groupingTable.groupBy("dairy");
        groupingTable.has()
                     .group("Dairy: No")
                     .groupSize("Dairy: No", 4);

        groupingTable.removeGroups();
        groupingTable.has()
                     .groupSize("Dairy: No", 0);

        groupingTable.groupBy("Category");
        groupingTable.has()
                     .group("Category: Cookie")
                     .groupSize("Category: Cookie", 2);
    }

    @Test
    public static void hideHeaderFooterTableTest() {
        hideHeaderFooterTable.show();
        hideHeaderFooterTable.has()
                             .footer(false)
                             .header(false);
    }

    @Test
    public static void loadingTableTest() {
        loadingTable.show();
        loadingTable.is().loading()
                    .has().elementName(1,"Loading... Please wait");
    }

    @Test
    public static void multiSortTableTest() {
        multiSortTable.show();
        multiSortTable.sortOff("Calories");
        multiSortTable.sortDescBy("Protein");
        multiSortTable.has().cellValue(1, 1, KITKAT.value());
        multiSortTable.is().sortedBy("Protein").and().sortedBy("Fat");

        multiSortTable.sortOff("Protein");
        multiSortTable.sortOff("Fat");
        multiSortTable.has().cellValue(1, 1, FROZEN_YOGURT.value());
        multiSortTable.is().notSortedBy("Protein").and().notSortedBy("Fat");
    }

    @Test
    public static void rowSelectionTableTest() {
        rowSelectionTable.show();
        rowSelectionTable.getColumn(1).select(1);
        rowSelectionTable.has().cellSelected(1, 1)
                         .and().cellNotSelected(1, 2);

        rowSelectionTable.getColumn(1).select(3);
        rowSelectionTable.has().cellSelected(1, 3);

        rowSelectionTableSingleSelect.check();
        rowSelectionTable.getColumn(1).select(1);
        rowSelectionTable.has().cellNotSelected(1, 1)
                         .and().cellNotSelected(1, 2);

        verifyElements(2, 1);
        verifyElements(3, 2);
    }

    @Test
    public static void headerCheckboxTest() {
        rowSelectionTable.show();
        rowSelectionTable.clickOnHeaderCheckbox();
        rowSelectionTable.has().greyHeaderCheckbox();
        rowSelectionTable.has().areAllCheckboxesChecked(1,true);

        rowSelectionTable.clickOnHeaderCheckbox();
        rowSelectionTable.has().areAllCheckboxesChecked(1,false);
        rowSelectionTable.has().blankHeaderCheckbox();
    }

    @Test
    public static void searchTableTest() {
        searchTableField.show();
        searchTableField.clearAndTypeText(DONUT.value());
        searchTable.has().cellValue(1, 1, DONUT.value());
        searchTable.clear();
        searchTableField.clearAndTypeText(ECLAIR_CALORIES.value());
        searchTable.has().cellValue(1, 1, ECLAIR.value());
    }

    @Test
    public static void headerTableTest() {
        headerTable.show();
        headerTable.has()
                   .header(1, "DESSERT (100G SERVING)")
                   .header(2, "Calories")
                   .header(3, "Fat (g)")
                   .header(4, "Carbs (g)")
                   .header(5, "Protein (g)")
                   .header(6, "Iron (%)");
    }

    @Test
    public static void itemTableTest() {
        itemTable.show();
        for (Chip chip : itemTable.getChips()) {
            chip.has().backgroundColor(itemTable.getColor(Integer.parseInt(chip.getText())));
        }
    }

    @Test
    public static void simpleCheckboxTableTest() {
        simpleCheckboxTable.show();
        simpleCheckboxTable.has().cellSelected(7, 1)
                           .and().cellNotSelected(7, 2)
                           .and().cellSelected(7, 5);
    }

    @Test
    public static void checkboxColorTableTest() {
        simpleCheckboxTable.show();
        simpleCheckboxTable.has().greyCheckbox(7, 1)
                           .and().blankCheckbox(7,2);
    }

    @Test
    public static void crudActionsTableSaveTest() {
        newItemButton.show();

        String[] values = {"Egg", "72", "4.8", "0.4", "6.3"};
        newItemButton.click();
        newItemCard.fill(values);
        newItemCard.save();

        crudActionsTable.has()
                        .rowWithValues(1, values);
    }

    @Test
    public static void crudActionsTableCancelTest() {
        newItemButton.show();
        newItemButton.click();
        newItemCard.fill("Milk", "61", "3.3", "4.8", "3.2");
        newItemCard.cancel();

        crudActionsTable.has().hasNoRow(1, "Milk");
    }

    @Test(description = "Test updated data is saved when ENTER is pressed")
    public static void editDialogTableSaveTest() {
        editDialogTable.show();

        editDialogTable.getColumn(1).select(3);
        waitCondition(() -> editDialogMenu.isDisplayed());
        editDialogMenu.clearTextField();
        editDialogMenu.find("input").sendKeys("New Element");
        editDialogMenu.press(Keys.ENTER);

        editDialogTable.getColumn(6).select(1);
        waitCondition(() -> editDialogMenu.isDisplayed());
        editDialogMenu.clearTextField();
        editDialogMenu.find("input").sendKeys("146%");
        editDialogMenu.press(Keys.ENTER);

        editDialogTable.has()
                       .elementName(3, "New Element")
                       .elementValue(6, 1, "146%");
    }

    @Test(description = "Test updated data is not saved when ESCAPE is pressed")
    public static void editDialogTableCancelTest() {
        editDialogTable.show();

        editDialogTable.getColumn(1).select(6);
        editDialogMenu.clearTextField();
        editDialogMenu.find("input").sendKeys("New Element 2");
        editDialogMenu.press(Keys.ESCAPE);

        editDialogTable.getColumn(6).select(1);
        waitCondition(() -> editDialogMenu.isDisplayed());
        editDialogMenu.clearTextField();
        editDialogMenu.find("input").sendKeys("146%");
        editDialogMenu.press(Keys.ESCAPE);

        editDialogTable.has()
                       .cellValue(1, 6, JELLY_BEAN.value())
                       .cellValue(6, 1, FROZEN_YOGURT_IRON.value());
    }

    @Test
    public static void multipleRowsExpandTest() {
        expandableRowsTable.show();
        if (expandableRowsTableSingleExpand.isChecked()) {
            expandableRowsTableSingleExpand.check();
        }
        expandableRowsTable.expandRow(1);
        expandableRowsTable.expandRow(2);

        expandableRowsTable.has().rowExpanded(1)
                           .and().rowExpanded(2);

        // after
        expandableRowsTable.collapseRow(1);
        expandableRowsTable.collapseRow(2);
    }

    @Test
    public void singleRowExpandTest() {
        expandableRowsTable.show();
        if (expandableRowsTableSingleExpand.isNotChecked()) {
            expandableRowsTableSingleExpand.check();
        }
        expandableRowsTable.expandRow(1);
        expandableRowsTable.expandRow(2);
        expandableRowsTable.expandRow(3);

        expandableRowsTable.has().rowCollapsed(1)
                           .and().rowCollapsed(2)
                           .and().rowExpanded(3);
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
        externalSortingTable.has().elementName(1, CUPCAKE.value());
        externalSortingToggle.click();
        externalSortingTable.is().sortedBy("Dessert");

        externalSortingTable.has().elementName(1, LOLLIPOP.value());
        externalSortingNextColumn.click();
        externalSortingTable.is().sortedBy("Calories");
        externalSortingTable.has().elementName(1, KITKAT.value());

        externalSortingToggle.click();
        externalSortingTable.is().sortedBy("Calories");
        externalSortingTable.has().elementName(1, FROZEN_YOGURT.value());
    }

    @Test
    public void themeTest() {
        filterableTable.has()
                       .lightTheme();

        darkTable.has()
                 .darkTheme();
    }

    @Test
    public void disabledSortTest() {
        disabledSortTable.has()
                         .sortEnabled("Dessert", false)
                         .sortEnabled("Calories", false)
                         .sortEnabled("Fat", false)
                         .sortEnabled("Carbs", false)
                         .sortEnabled("Protein", false)
                         .sortEnabled("Iron", false);
    }

    @Test
    public void mustSortTest() {
        mustSortTable.has().sortRequired(true);
    }

    @Test
    public void fixedHeaderTableTest() {
        fixedHeaderTable.has().fixedHeader(true);
    }

    //selects required element and verifies, that current element selected and previous element not selected
    public static void verifyElements(int reqEl, int prevEl) {
        rowSelectionTable.getColumn(1).select(reqEl);
        rowSelectionTable.has().cellNotSelected(1, prevEl)
                         .and().cellSelected(1, reqEl);
    }
}
