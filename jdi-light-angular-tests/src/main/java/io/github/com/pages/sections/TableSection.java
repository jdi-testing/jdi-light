package io.github.com.pages.sections;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;

public class TableSection {

    @JTable(root ="table-basic-example > table")
    public static Table basicTable;

    @JTable(root ="table-basic-flex-example > mat-table",
            headers = "mat-header-row > mat-header-cell",
            row = "//mat-row[%s]/mat-cell",
            column = "//mat-row/mat-cell[%s]",
            cell = "//mat-row[{1}]/mat-cell[{0}]",
            allCells = "mat-cell")
    public static Table flexTable;

    public static TableDynamicSection dynamicSection;

    @JTable(root = "table-expandable-rows-example > table")
    public static Table expandableRowsTable;

    public static TableFilteringSection filteringSection;

    @JTable(root = "table-footer-row-example > table")
    public static Table tableWithFooter;

    public static TableOverviewSection overviewSection;
}
