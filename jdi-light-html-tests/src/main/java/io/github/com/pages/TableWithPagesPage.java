package io.github.com.pages;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class TableWithPagesPage extends WebPage {

    @UI("#table-with-pages")
    @JTable
    public static Table withPagesTable;

}
