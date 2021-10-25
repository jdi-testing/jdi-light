package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

public class DataTablesPage extends VuetifyPage {

    @UI("#CustomFilterTable")
    public static DataTable customFilter;

    @UI("#DenseTable")
    public static DataTable denseTable;

    @UI("#FilterableTable")
    public static DataTable filterableTable;

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

    @UI("#SearchTable")
    public static DataTable searchTable;

    @UI("#SlotsTable")
    public static DataTable slotsTable;

    @UI("#HeaderTable")
    public static DataTable headerTable;

    @UI("#ItemTable")
    public static DataTable itemTable;

    @UI("#SimpleCheckboxTable")
    public static DataTable simpleCheckboxTable;

    @UI("#CRUDActionsTable")
    public static DataTable cRUDActionsTable;

    @UI("#EditDialogTable")
    public static DataTable editDialogTable;

    @UI("#ExpandableRowsTable")
    public static DataTable expandableRowsTable;

    @UI("#ExternalPaginationTable")
    public static DataTable externalPaginationTable;

    @UI("#ExternalSortingTable")
    public static DataTable externalSortingTable;

    @UI("#ServerSideTable")
    public static DataTable serverSideTable;
}
