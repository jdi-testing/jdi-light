package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.ButtonToggle;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

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

    @UI("table-dynamic-columns-example > button:nth-child(2)")
    public static Button addButton;
    @UI("table-dynamic-columns-example > button:nth-child(3)")
    public static Button removeButton;
    @UI("table-dynamic-columns-example > button:nth-child(4)")
    public static Button shuffleButton;

    @JTable(root = "table-dynamic-columns-example > table")
    public static Table dynamicTable;

    @JTable(root = "table-expandable-rows-example > table")
    public static Table expandableRowsTable;

    @JTable(root = "table-filtering-example > table")
    public static Table filteringTable;

    @JTable(root = "table-footer-row-example > table")
    public static Table tableWithFooter;
}
