package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.Select;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;
import io.github.com.custom.cards.NewItemCard;
import io.github.com.custom.tables.ExternalPaginationTable;
import io.github.com.custom.tables.ItemDataTable;
import io.github.com.custom.tables.LoadingDataTable;
import io.github.com.custom.tables.RowSelectionDataTable;
import io.github.com.custom.tables.SimpleCheckboxDataTable;

public class DataTablesPage extends VuetifyPage {

    @UI("#CustomFilterTable .v-data-table")
    public static DataTable customFilterTable;

    @UI("#CustomFilterTable tbody .v-input__control")
    public static Input customFilterInputField;

    @UI("#DenseTable")
    public static DataTable denseTable;

    @UI("#FilterableTable .v-data-table")
    public static DataTable filterableTable;

    @UI("#FilterableTable .v-card__title .v-input")
    public static Input filterableTableSearchField;

    @UI("// p[contains(text(), 'Enabled pagination controls')] / .. / div[contains(@class, 'v-data-table')]")
    public static DataTable footerPropsTable;

    @UI("//p[contains(text(), 'Disabled pagination controls')] / .. / div[contains(@class, 'v-data-table')]")
    public static DataTable disabledPaginationTable;

    @UI("#DisabledSortTable .v-data-table")
    public static DataTable disabledSortTable;

    @UI("#MustSortTable .v-data-table")
    public static DataTable mustSortTable;

    @UI("#GroupingTable")
    public static DataTable groupingTable;

    @UI("#HideHeaderFooterTable")
    public static DataTable hideHeaderFooterTable;

    @UI("#LoadingTable")
    public static LoadingDataTable loadingTable;

    @UI("#MultiSortTable")
    public static DataTable multiSortTable;

    @UI("#RowSelectionTable")
    public static RowSelectionDataTable rowSelectionTable;

    @UI("#RowSelectionTable .v-input--switch")
    public static Switch rowSelectionTableSingleSelect;

    @UI("#SearchTable .v-data-table")
    public static DataTable searchTable;

    @UI("#SearchTable .v-card__title .v-input")
    public static Input searchTableField;

    @UI("#SlotsTable .v-data-table")
    public static DataTable slotsTable;

    @JDropdown(root = "#SlotsTable .v-select",
            value = ".v-select__selection--comma",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = ".mdi-menu-down")
    public static Select slotsSelect;

    @UI("#HeaderTable")
    public static DataTable headerTable;

    @UI("#ItemTable")
    public static ItemDataTable itemTable;

    @UI("#SimpleCheckboxTable .v-data-table")
    public static SimpleCheckboxDataTable simpleCheckboxTable;

    @UI("#CRUDActionsTable")
    public static DataTable crudActionsTable;

    @UI("#CRUDActionsTable header button")
    public static Button newItemButton;

    @UI(".v-dialog--active .v-card")
    public static NewItemCard newItemCard;

    @UI("#EditDialogTable")
    public static DataTable editDialogTable;

    @UI(".menuable__content__active .v-input")
    public static Input editDialogMenu;

    @UI("#ExpandableRowsTable")
    public static DataTable expandableRowsTable;

    @UI("#ExpandableRowsTable .v-input--switch")
    public static Switch expandableRowsTableSingleExpand;

    @UI("#ExternalPaginationTable")
    public static ExternalPaginationTable externalPaginationTable;

    @UI("#ExternalSortingTable .v-data-table")
    public static DataTable externalSortingTable;

    @UI("//div[@id='ExternalSortingTable']//button/span[contains(text(),'Toggle')] ")
    public static Button externalSortingToggle;

    @UI("//div[@id='ExternalSortingTable']//button/span[contains(text(),'next')]")
    public static Button externalSortingNextColumn;

    @UI("#ServerSideTable .v-data-table")
    public static DataTable serverSideTable;

    @UI("#DarkTable .v-data-table")
    public static DataTable darkTable;

    @UI("#FixedHeaderTable .v-data-table")
    public static DataTable fixedHeaderTable;
}
