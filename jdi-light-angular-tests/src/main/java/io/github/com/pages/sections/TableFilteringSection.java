package io.github.com.pages.sections;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class TableFilteringSection {
    @UI("#mat-input-84")
    public static TextField filter;

    @JTable(root = "table-filtering-example > table")
    public static Table filteringTable;
}
