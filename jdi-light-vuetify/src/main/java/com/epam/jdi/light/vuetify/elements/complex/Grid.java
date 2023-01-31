package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.GridAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Grid web element please visit https://vuetifyjs.com/en/components/grids/
 */

public class Grid extends UIBaseElement<GridAssert> {

    @JDIAction("Get '{name}' row by index")
    private UIElement getRowByIndex(int rowIndex) {
        return finds(".row").get(rowIndex);
    }

    @JDIAction("Get '{name}' cell in row {0}")
    private WebList getCellsInRow(int rowIndex) {
        return getRowByIndex(rowIndex).finds(".//div[contains(@class, 'col')]");
    }

    @JDIAction("Get '{name}' cell by index in row {0}")
    public UIElement getCellByIndex(int rowIndex, int columnIndex) {
        return getCellsInRow(rowIndex).get(columnIndex);
    }

    @JDIAction("Get '{name}' row's status")
    private String getCellsFromRowWithStatus(int rowIndex, String status) {
        return Arrays.stream(getClassAttr(getRowByIndex(rowIndex))
                .split("\\s"))
                .filter(s -> s.startsWith(status))
                .collect(Collectors.joining());
    }

    @JDIAction("Get '{name}' cell status")
    public String getCellWithStatus(int rowIndex, int columnIndex, String status) {
        return Arrays.stream(getClassAttr(getCellByIndex(rowIndex, columnIndex))
                        .split("\\s"))
                .filter(s -> s.startsWith(status))
                .collect(Collectors.joining());
    }

    @JDIAction("Get '{name}' row vertical alignment")
    public String getRowVerticalAlignment(int rowIndex) {
        return getCellsFromRowWithStatus(rowIndex, "align");
    }

    @JDIAction("Get '{name}' row horizontal alignment")
    public String getRowHorizontalAlignment(int rowIndex) {
        return getCellsFromRowWithStatus(rowIndex, "justify");
    }

    @JDIAction("Get '{name}' cell's alignment in row {0}")
    public String getCellVerticalAlignment(int rowIndex, int columnIndex) {
        return getCellWithStatus(rowIndex, columnIndex, "align");
    }

    @JDIAction("Get '{name}' cell's order in row {0}")
    public String getCellOrder(int rowIndex, int columnIndex) {
        return getCellWithStatus(rowIndex, columnIndex, "order");
    }

    @JDIAction("Get if '{name}' cell in row {0} has an offset")
    public boolean hasCellOffset(int rowIndex, int columnIndex) {
        return getClassAttr(getCellByIndex(rowIndex, columnIndex)).contains("offset");
    }

    @JDIAction("Get if '{name}' row {0} has sells with equal widths")
    public boolean hasCellsWithEqualWidthInRow(int rowIndex) {
        String width = getCellByIndex(rowIndex, 1).getCssValue("width");
        return getCellsInRow(rowIndex).stream().map(column -> column.getCssValue("width"))
                .allMatch(e ->e.equals(width));
    }

    @JDIAction("Get if '{name}' cell in row {0} has custom width")
    public String hasCellWithCustomWidth(int rowIndex, int columnIndex) {
        return getCellWithStatus(rowIndex, columnIndex, "col-");
    }

    @JDIAction("Get if '{name}' cell in row {0} has custom margin")
    public boolean hasMargin(int rowIndex, int columnIndex) {
        List<String> margins = Arrays.asList("md", "ml", "mr");
        return margins.stream().anyMatch(getClassAttr(getCellByIndex(rowIndex, columnIndex))::contains);
    }

    @JDIAction("Get '{name}' cell in row '{0}' column '{1}' background color")
    public String getCellBackgroundColor(int rowIndex, int columnIndex) {
        return getCellByIndex(rowIndex, columnIndex).firstChild().getCssValue("background-color");
    }

    @JDIAction("Get '{name}' cell in row '{0}' column '{1}' font color")
    public String getCellFontColor(int rowIndex, int columnIndex) {
        return getCellByIndex(rowIndex, columnIndex).firstChild().getCssValue("color");
    }

    @JDIAction("Get if '{name}' has row {0} with spacers")
    public boolean hasRowWithSpacers(int rowIndex) {
        return getRowByIndex(rowIndex).find(".spacer").isExist();
    }

    @JDIAction("Get if '{name}' cell in row {0} has auto-width")
    public boolean hasCellWithAutoWidth(int rowIndex, int columnIndex) {
        return getCellWithStatus(rowIndex, columnIndex, "col-md-").equals("col-md-auto");
    }

    @JDIAction("Check that '{name}' is fluid")
    public boolean isFluid() {
        return hasClass("container--fluid");
    }

    @JDIAction("Check that '{name}' has no-gutters")
    public boolean hasNoGuttersRow(int rowIndex) {
        return getRowByIndex(rowIndex).hasClass("no-gutters");
    }

    @JDIAction("Check that '{name}' is fluid")
    public boolean isDense(int rowIndex) {
        return getRowByIndex(rowIndex).hasClass("row--dense");
    }

    private String getClassAttr(UIElement element) {
        return element.attr("class");
    }

    public GridAssert is() {
        return new GridAssert().set(this);
    }
}
