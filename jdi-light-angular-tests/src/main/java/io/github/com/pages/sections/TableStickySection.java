package io.github.com.pages.sections;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;

public class TableStickySection {

    @JTable(root = "table-sticky-header-example")
    public static Table stickyHeaderTable;

    @JTable(root = "table-sticky-columns-example")
    public static Table stickyColumnsTable;

    @JTable(root = "table-sticky-footer-example")
    public static Table stickyFooterTable;
}
