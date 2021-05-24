package io.github.com.pages.displaydata;


import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class TablePage extends WebPage {
    @JTable(
            root = ".MuiDataGrid-main",
            cell = ".MuiDataGrid-main div[role='row'] div[tabindex]",
            headers = ".MuiDataGrid-colCellWrapper [tabindex='-1']",
            row = ".MuiDataGrid-main div[role='row']")
    public static Table table;

    @UI(".MuiDataGrid-main div[role='row'] div[tabindex]")
    public static List<Button> tableCells;

    @UI(".MuiDataGrid-selectedRowCount")
    public static Text selectedRowCounter;

    @UI(".MuiTablePagination-actions button")
    public static List<Button> scrollButtons;
}
