package io.github.com.pages;

import com.epam.jdi.light.elements.complex.table.DataGrid;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.complex.table.Grid;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.entities.Furniture;
import io.github.com.sections.FurnLine;

public class SimpleTablePage extends WebPage {
    @UI("#simple-table")
    public static Grid simpleTable;
    public static DataTable<?, Furniture> productsTable;

    @JTable(
        root = "#furniture",
        rowHeader = "Name",
        column = "//tbody/tr/td[%s]",
        row = "//tbody/tr[%s]/td",
        cell = "//tbody/tr[{1}]/td[{0}]",
        allCells = "//tbody//td")
    public static DataTable<?, Furniture> furnitureJ;

    public static Grid products;
    @UI("#products")
    public static DataGrid<FurnLine, Furniture> dataProducts;

    @UI("#products-2")
    public static Grid productsJTable;
    @UI("#products-2")
    public static DataGrid<?, Furniture> dataProductsJTable;

    public static Grid furniture;
    @UI("#furniture")
    public static DataGrid<?, Furniture> dataFurniture;

    public static Grid furnitureSharp;
    @JTable(root = "#furniture-sharp", header = {"Name", "Type", "Cost", "Weight"})
    public static Grid furnitureSharpHeader;
    @UI("#furniture-sharp")
    public static DataGrid<?, Furniture> dataFurnitureSharp;

    // @JTable(columnsMapping = {1, 2, 3, 5})
    public static Grid furnitureHidden;
    @UI("#furniture-hidden")
    public static DataGrid<?, Furniture> dataFurnitureHidden;

    // @JTable(columnsMapping = {2, 3, 4, 6})
    public static Grid furnitureDoubleHidden;
    @UI("#furniture-double-hidden")
    public static DataGrid<?, Furniture> dataFurnitureDoubleHidden;
}