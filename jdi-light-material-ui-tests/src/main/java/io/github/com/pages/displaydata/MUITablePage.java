package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JMUITable;
import com.epam.jdi.light.material.annotations.JMUITableFooter;
import com.epam.jdi.light.material.annotations.JMUITableHeader;
import com.epam.jdi.light.material.elements.displaydata.table.MUITable;
import com.epam.jdi.light.material.elements.inputs.Checkbox;

public class MUITablePage extends WebPage {

    @JMUITable(root = "#basicTable")
    public static MUITable basicTable;

    @JMUITable(root = "//h2[text()='Data table']/following-sibling::div[1]//div[@class='MuiDataGrid-main']",
            headerRow = "./div[1]/div",
            columnHeaders = "./div[@role='columnheader']",
            row = "./div[2]//div[@role='row']",
            cell = "./div[@role='cell']",
            footer = @JMUITableFooter(root = "./..//div[@class='MuiDataGrid-footer']")
    )
    public static MUITable dataTable;

    @JMUITable(root = "//h2[text()='Dense table']/following-sibling::div[1]/table")
    public static MUITable denseTable;

    @JMUITable(root = "//h2[text()='Sorting and selecting table']/following-sibling::div[1]//table",
            header = @JMUITableHeader(root = "./../preceding-sibling::div"),
            footer = @JMUITableFooter(root = "./../following-sibling::div[@class='MuiTablePagination-root']")
    )
    public static MUITable sortingSelectingTable;

    @UI("//h2[text()='Sorting and selecting table']/following-sibling::div//span[contains(@class, 'MuiSwitch-switchBase')]")
    public static Checkbox densePaddingSwitch;

    @JMUITable(root = "//h2[text()='Collapsible table']/following-sibling::div[1]/table", row = ".//tbody/tr[position() mod 2 != 0]")
    public static MUITable collapsibleTable;

    @JMUITable(root = "//table[contains(@aria-label, 'purchases')]")
    public static MUITable purchaseTable;

    @JMUITable(root = "//h2[text()='Spanning Table']/following-sibling::div[1]/table",
            headerRow = ".//thead/tr[2]",
            cell = ".//td[not(@rowspan)]"
    )
    public static MUITable spanningTable;

    @JMUITable(root = "//h2[text()='Virtualized table']/following-sibling::div[1]",
            headerRow = "./div/div/div[@role='row']",
            columnHeaders = "./div[@role='columnheader']",
            row = "./div/div/div[@role='rowgroup']//div[@role='row']",
            cell = "./div[@role='gridcell']",
            scrollableElementLocator = ".//div[@class = 'ReactVirtualized__Grid ReactVirtualized__Table__Grid']"
    )
    public static MUITable virtualizedTable;

}

