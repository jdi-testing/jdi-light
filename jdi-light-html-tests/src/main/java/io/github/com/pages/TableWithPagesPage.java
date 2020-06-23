package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;

public class TableWithPagesPage extends WebPage {

    @Css("#table-with-pages")
    @JTable(
            filter = "th[class^='sorting']",
            cell = "//tbody/tr[{1}]/td[{1}]",
            firstColumnIndex = 0,
            rowHeader = "Type", size = 3,
            header = {"Type", "Now", "Plans"}

    )
    public Table withPagesTable;

    @UI("input[type='search']")
    public static WebElement searchBy;

    public UIElement filterByColumn(String filterName) {
        UIElement elem = withPagesTable.filterBy(filterName);
        System.out.println("elem::" + elem);
        elem.click();
        return elem;
    }
}
