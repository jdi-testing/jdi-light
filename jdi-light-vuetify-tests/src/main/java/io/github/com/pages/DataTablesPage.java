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

public class DataTablesPage extends VuetifyPage {

    @UI("#CustomFilterTable")
    public static DataTable customFilter;

    @UI("#CustomFilterTable .v-input__control")
    public static Input customFilterSearchField;

    @UI("#CustomFilterTable tbody .v-input__control")
    public static Input customFilterInputField;

    @UI("#DenseTable")
    public static DataTable denseTable;

    @UI("#FilterableTable")
    public static DataTable filterableTable;

    @UI("#FilterableTable .v-card__title .v-input")
    public static Input filterableTableSearchField;

    @UI("#FooterPropsTable")
    public static DataTable footerPropsTable;

    @UI("#GroupingTable")
    public static DataTable groupingTable;

    @UI("#HideHeaderFooterTable")
    public static DataTable hideHeaderFooterTable;

    @UI("#LoadingTable")
    public static DataTable loadingTable;

    @UI("#MultiSortTable")
    public static DataTable multiSortTable;

    @UI("#RowSelectionTable")
    public static DataTable rowSelectionTable;

    @UI("#RowSelectionTable .v-input--selection-controls")
    public static Switch rowSelectionTableSingleSelect;

    @UI("#SearchTable")
    public static DataTable searchTable;

    @UI("#SearchTable .v-card__title .v-input")
    public static Input searchTableField;

    @UI("#SlotsTable")
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

    @UI("#SimpleCheckboxTable")
    public static DataTable simpleCheckboxTable;

    @UI("#CRUDActionsTable")
    public static DataTable crudActionsTable;

    @UI("#CRUDActionsTable header button")
    public static Button newItemButton;

    @UI(".v-dialog--active .v-card")
    public static NewItemCard newItemCard;

    @UI("#EditDialogTable")
    public static DataTable editDialogTable;

    @UI(".v-menu__content .v-input")
    public static Input editDialogMenu;

    @UI("#ExpandableRowsTable")
    public static DataTable expandableRowsTable;

    @UI("#ExpandableRowsTable .v-input--selection-controls")
    public static Switch expandableRowsTableSingleExpand;

    @UI("#ExternalPaginationTable")
    public static ExternalPaginationTable externalPaginationTable;

    @UI("#ExternalSortingTable")
    public static DataTable externalSortingTable;

    @UI("//div[@id='ExternalSortingTable']//button/span[contains(text(),'Toggle')] ")
    public static Button externalSortingToggle;

    @UI("//div[@id='ExternalSortingTable']//button/span[contains(text(),'next')]")
    public static Button externalSortingNextColumn;

    @UI("#ServerSideTable")
    public static DataTable serverSideTable;
}
