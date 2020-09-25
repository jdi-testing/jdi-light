package io.github.com.pages;

import com.epam.jdi.light.elements.complex.table.DataGrid;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.complex.table.Grid;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.entities.Furniture;

public class SimpleTablePage extends WebPage {

    public static Grid simpleTable;
    public static DataTable<?, Furniture> productsTable;

    @JTable(
        root = "#furniture",
        rowHeader = "Name",
        column = "//tbody/tr/td[%s]",
        row = "//tbody/tr[%s]/td",
        cell = "//tbody/tr[{1}]/td[{0}]",
        allCells = "//tbody//td")
    public static DataTable<?, Furniture> furnitureTable;

    public static Grid products;

    @JTable(root = "#products-2",
            headers = "thead td",
            column = "//tbody/tr/td[%s]",
            row = "//tbody/tr[%s]/td",
            cell = "//tbody/tr[{1}]/td[{0}]",
            allCells = "tbody td")
    public static Grid productsJTable;
    @UI("#products")
    public static DataGrid<?, Furniture> dataGridProducts;

    public static Grid furniture;
    @UI("#furniture")
    public static DataGrid<?, Furniture> dataGridFurniture;

    public static Grid furnitureSharp;
    @JTable(root = "#furniture-sharp", header = {"Name", "Type", "Cost", "Weight"})
    public static Grid furnitureSharpHeader;
    @UI("#furniture-sharp")
    public static DataGrid<?, Furniture> dataGridFurnitureSharp;

    public static Grid furnitureHidden;
    @UI("#furniture-hidden")
    public static DataGrid<?, Furniture> dataGridFurnitureHidden;

    public static Grid furnitureDoubleHidden;
    @UI("#furniture-double-hidden")
    public static DataGrid<?, Furniture> dataGridFurnitureDoubleHidden;
}