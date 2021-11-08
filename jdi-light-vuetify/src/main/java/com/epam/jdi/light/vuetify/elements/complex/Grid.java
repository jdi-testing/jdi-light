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

    @JDIAction("Get '{name}'s row by index")
    private UIElement getRowByIndex(int rowIndex) {
        return finds(".row").get(rowIndex);
    }

    @JDIAction("Get '{name}'s columns in row {0}")
    private WebList getColumnsInRow(int rowIndex) {
        return getRowByIndex(rowIndex).finds("//div[contains(@class, 'col')]");
    }

    @JDIAction("Get '{name}'s column by index in row {0}")
    public UIElement getColumnByIndex(int rowIndex, int columnIndex) {
        return getColumnsInRow(rowIndex).get(columnIndex);
    }

    @JDIAction("Get '{name}'s row's status")
    private String getRowStatus(int rowIndex, String status) {
        return Arrays.stream(getClassAttr(getRowByIndex(rowIndex))
                .split("\\s"))
                .filter(s -> s.startsWith(status))
                .collect(Collectors.joining());
    }

    @JDIAction("Get '{name}'s column's status")
    public String getColumnStatus(int rowIndex, int columnIndex, String status) {
        return Arrays.stream(getClassAttr(getColumnByIndex(rowIndex, columnIndex))
                        .split("\\s"))
                .filter(s -> s.startsWith(status))
                .collect(Collectors.joining());
    }

    @JDIAction("Get '{name}'s row vertical alignment")
    public String getRowVerticalAlignment(int rowIndex) {
        return getRowStatus(rowIndex, "align");
    }

    @JDIAction("Get '{name}'s row horizontal alignment")
    public String getRowHorizontalAlignment(int rowIndex) {
        return getRowStatus(rowIndex, "justify");
    }

    @JDIAction("Get '{name}'s column's alignment in row {0}")
    public String getColumnVerticalAlignment(int rowIndex, int columnIndex) {
        return getColumnStatus(rowIndex, columnIndex, "align");
    }

    @JDIAction("Get '{name}'s column's order in row {0}")
    public String getColumnOrder(int rowIndex, int columnIndex) {
        return getColumnStatus(rowIndex, columnIndex, "order");
    }

    @JDIAction("'{name}'s column in row {0} has an offset")
    public boolean hasColumnOffset(int rowIndex, int columnIndex) {
        return getClassAttr(getColumnByIndex(rowIndex, columnIndex)).contains("offset");
    }

    @JDIAction("'{name}'s row {0} has columns with equal widths")
    public boolean hasColumnsWithEqualWidthInRow(int rowIndex) {
        String width = getColumnByIndex(rowIndex, 1).getCssValue("width");
        return getColumnsInRow(rowIndex).stream().map(column -> column.getCssValue("width"))
                .allMatch(e ->e.equals(width));
    }

    @JDIAction("'{name}'s column in row {0} has custom width")
    public String hasColumnsWithCustomWidth(int rowIndex, int columnIndex) {
        return getColumnStatus(rowIndex, columnIndex, "col-");
    }

    @JDIAction("'{name}'s column in row {0} has custom margin")
    public boolean hasMargin(int rowIndex, int columnIndex) {
        List<String> margins = Arrays.asList("md", "ml", "mr");
        return margins.stream().anyMatch(getClassAttr(getColumnByIndex(rowIndex, columnIndex))::contains);
    }

    @JDIAction("Get '{name}'s column in row {0} background color")
    public String getColumnBackgroundColor(int rowIndex, int columnIndex) {
        return getColumnByIndex(rowIndex, columnIndex).firstChild().getCssValue("background-color");
    }

    @JDIAction("'{name}'s row {0} has spacers")
    public boolean hasRowWithSpacers(int rowIndex) {
        return getRowByIndex(rowIndex).find(".spacer").isExist();
    }

    @JDIAction("'{name}'s column in row {0} has variable width")
    public boolean hasColumnWithVariableWidth(int rowIndex, int columnIndex) {
        return getColumnStatus(rowIndex, columnIndex, "col-md-").equals("col-md-auto");
    }

    private String getClassAttr(UIElement element) {
        return element.attr("class");
    }

    public GridAssert is() {
        return new GridAssert().set(this);
    }

    public GridAssert has() {
        return is();
    }

}
