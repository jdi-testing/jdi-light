package io.github.com.pages.sections;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class TableDynamicSection {
    @UI("table-dynamic-columns-example > button:nth-child(2)")
    public static Button addButton;
    @UI("table-dynamic-columns-example > button:nth-child(3)")
    public static Button removeButton;
    @UI("table-dynamic-columns-example > button:nth-child(4)")
    public static Button shuffleButton;
    @JTable(root = "table-dynamic-columns-example > table")
    public static Table dynamicTable;
}
