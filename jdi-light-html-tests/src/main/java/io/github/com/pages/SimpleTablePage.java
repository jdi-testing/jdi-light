package io.github.com.pages;

import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.complex.table.Grid;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.entities.Furniture;
import io.github.com.sections.FurnLine;

public class SimpleTablePage extends WebPage {

    public static Grid simpleTable;

    @JTable(
        root = "#furniture",
        rowHeader = "Name",
        column = "//tbody/tr/td[%s]",
        row = "//tbody/tr[%s]/td",
        cell = "//tbody/tr[{1}]/td[{0}]",
        allCells = "//tbody//td")
    public static DataTable<?, Furniture> furnitureJ;
    public static DataTable<FurnLine, Furniture> products;

}