package io.github.com.pages;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class PerformancePage extends WebPage {
    @UI("#users-table") public static Table users;
    @JTable(
            root = "#users-table",
            row = "//tr[%s]/td",
            column = "//tr/td[%s]",
            cell = "//tr[{1}]/td[{0}]",
            allCells = "td",
            headers = "th",
            header = {"Name", "Phone", "Email", "City"},
            rowHeader = "Name",
            size = 4
    ) public static Table usersSetup;
}
