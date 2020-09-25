package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.ButtonToggle;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

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

    @UI("#mat-button-toggle-group-font")
    public static ButtonToggle addButton;
    @JTable(root = "table-dynamic-columns-example > table")
    public static Table dynamicTable;
}
