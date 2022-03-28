package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.elements.complex.table.Table;
import io.github.com.custom.elements.complex.table.TableWithFilters;
import io.github.com.pages.utils.UserInfo;
import io.github.com.pages.utils.WesterosUser;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.custom.elements.complex.table.CollapsingTable;

import java.util.List;

public class TablePage extends WebPage {

    @JTable(
            root = "#basicTable",
            row = "//tbody/tr[%s]/*[contains(@class,'MuiTableCell-root')]",
            cell = "//tbody/tr[{1}]/td[{0}]",
            headers = ".MuiTableCell-head"
    )
    public static Table basicTable;

    @JTable(
            root = ".MuiDataGrid-main",
            headers = "//div[(@role='columnheader') and not (@data-field='__check__')]",
            row = "(//div[@class='rendering-zone']/div[@role='row'])[%s]/div[(@aria-colindex) and not (@data-field='__check__')]",
            cell = "//div[(@data-rowindex={1}) and (@aria-colindex={0}) and not (@data-field='__check__')]",
            column = "//div[@data-id]/div[not (@data-field='__check__')][%s]",
            footer = "//div[@class='MuiDataGrid-footer']"
    )
    public static TableWithFilters<WesterosUser, UserInfo> westerosTable;

    @JTable(
            root = "[aria-label='a dense table']",
            headers = "//thead/tr/th"
    )
    public static Table denseTable;

    @UI("(//table[contains(@class, 'MuiTable-root')])[3]")
    public static Table sortingSelectingTable;

    @UI("//div[contains(@class, 'MuiSelect-selectMenu')]")
    public static Button rowsPerPageButton;

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
            root = "//table[@aria-label='collapsible table']",
            headers = "//thead/tr/th[.//text()]",
            row = "//tbody/tr[%s]/*[not(button)]",
            cell = "//tbody/tr[{1}]/*[not(button)][{0}]"
    )
    public static CollapsingTable collapsibleTable;

    @UI("(//table[contains(@class, 'MuiTable-root')])[5]")
    public static Table spanningTable;

    @UI(".ReactVirtualized__Table__Grid div[role='row'] div[role='gridcell']")
    public static List<Text> virtualizedTable;
}
