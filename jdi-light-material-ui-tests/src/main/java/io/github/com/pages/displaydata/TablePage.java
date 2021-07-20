package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class TablePage extends WebPage {

    @UI("#basicTable")
    public static Table basicTable;

    @UI(".MuiDataGrid-main div[role='row'] div[tabindex]")
    public static List<Button> dataTableCells;

    @UI("(//table[contains(@class, 'MuiTable-root')])[2]")
    public static Table denseTable;

    @UI("(//table[contains(@class, 'MuiTable-root')])[3]")
    public static Table sortingSelectingTable;

    @UI("//div[contains(@class, 'MuiSelect-selectMenu')]")
    public static Button rowsPerPageBtn;

    @UI("//li[contains(@class, 'MuiTablePagination-menuItem')]")
    public static List<Button> rowsPerPageValues;

    @UI("//span[contains(@class, 'MuiSwitch-switchBase')]")
    public static Checkbox densePaddingSwitch;

    @UI("//div[contains(@class, 'MuiTypography-root')]")
    public static Text sortingSelectingTableTitle;

    @UI(".MuiDataGrid-selectedRowCount")
    public static Text selectedRowCounter;

    @UI("//div[contains(@class, 'MuiTablePagination-toolbar')]/div/button")
    public static List<Button> scrollButtons;

    @JTable(
            root = "(//table[contains(@class, 'MuiTable-root')])[4]",
            row = "(//tr[contains(@class, 'MuiTableRow-root') and contains(@class, 'jss')])[%s]/td",
            column = "//tr[contains(@class, 'MuiTableRow-root') and contains(@class, 'jss')]/td[%s]",
            cell = "(//tr[contains(@class, 'MuiTableRow-root') and contains(@class, 'jss')])[{1}]/td[{0}]",
            header = {"", "Calories", "Fat (g)", "Carbs (g)", "Protein (g)"},
            headers = "//th[contains(@class, MuiTableCell-head)]",
            size = 5
    )
    public static Table collapsibleTable;

    @UI("//table[contains(@aria-label, 'purchases')]")
    public static List<Table> purchaseTables;

    @UI("(//table[contains(@class, 'MuiTable-root')])[5]")
    public static Table spanningTable;

    @UI(".ReactVirtualized__Table__Grid div[role='row'] div[role='gridcell']")
    public static List<Text> virtualizedTable;
}