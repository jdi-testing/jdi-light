package io.github.com.pages.displaydata;


import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class TablePage extends WebPage {
    @UI(".MuiDataGrid-main div[role='row'] div[tabindex]")
    public static List<Button> tableCells;

    @UI(".MuiDataGrid-selectedRowCount")
    public static Text selectedRowCounter;

    @UI(".MuiTablePagination-actions button")
    public static List<Button> scrollButtons;
}
