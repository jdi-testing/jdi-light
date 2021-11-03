package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.GridSystemAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GridSystem extends UIBaseElement<GridSystemAssert> {

    @JDIAction("Get '{name}'s rows")
    public WebList getRows() {
        return finds(".row");
    }

    @JDIAction("Get '{name}'s row by index")
    public UIElement getRowByIndex(int rowIndex) {
        return getRows().get(rowIndex);
    }

    @JDIAction("Get '{name}'s columns in a row on index {0}")
    public WebList getColumnsByRowIndex(int rowIndex) {
        return getRowByIndex(rowIndex).finds("//div[contains(@class, 'col')]");
    }

    @JDIAction("Get '{name}'s column by index")
    public UIElement getColumnByIndex(int rowIndex, int columnIndex) {
        return getColumnsByRowIndex(rowIndex).get(columnIndex);
    }

    @JDIAction("Get '{name}'s row's vertical alignment")
    private String getRowAlignment(int rowIndex, String alignment) {
        return Arrays.stream(getClassAttr(getRowByIndex(rowIndex))
                .split("\\s"))
                .filter(s -> s.startsWith(alignment))
                .collect(Collectors.joining());
    }
    @JDIAction("Get '{name}'s row's vertical alignment")
    public String getRowVerticalAlignment(int rowIndex) {
        return getRowAlignment(rowIndex, "align");
    }

    @JDIAction("Get '{name}'s row's horizontal alignment")
    public String getRowHorizontalAlignment(int rowIndex) {
        return getRowAlignment(rowIndex, "justify");
    }

    @JDIAction("Get '{name}'s column's alignment")
    public String getColumnVerticalAlignment(int rowIndex, int columnIndex) {
        return getColumnStatus(rowIndex, columnIndex, "align");
    }

    @JDIAction("Get '{name}'s column's alignment")
    public String getColumnOrder(int rowIndex, int columnIndex) {
        return getColumnStatus(rowIndex, columnIndex, "order");
    }

    @JDIAction("Get '{name}'s column's alignment")
    public String getColumnStatus(int rowIndex, int columnIndex, String status) {
        return Arrays.stream(getClassAttr(getColumnByIndex(rowIndex, columnIndex))
                .split("\\s"))
                .filter(s -> s.startsWith(status))
                .collect(Collectors.joining());
    }

    @JDIAction("Get '{name}'s column by index")
    public boolean hasColumnOffset(int rowIndex, int columnIndex) {
        return getClassAttr(getColumnByIndex(rowIndex, columnIndex)).contains("offset");
    }

    @JDIAction("Get '{name}'s column by index")
    public boolean hasColumnsWithEqualWidthInRow(int rowIndex) {
        String width = getColumnByIndex(rowIndex, 1).getCssValue("width");
        return getColumnsByRowIndex(rowIndex).stream().map(column -> column.getCssValue("width"))
                .allMatch(e ->e.equals(width));
    }

    @JDIAction("Get '{name}'s column by index")
    public String hasColumnsWithCustomWidth(int rowIndex, int columnIndex) {
        return getColumnStatus(rowIndex, columnIndex, "col-");
    }

    @JDIAction("Get '{name}'s column by index")
    public boolean hasMargin(int rowIndex, int columnIndex) {
        List<String> margins = Arrays.asList("md", "ml", "mr");
        return margins.stream().anyMatch(getClassAttr(getColumnByIndex(rowIndex, columnIndex))::contains);
    }

    @JDIAction("Get '{name}'s column by index")
    public String hasBackgroundColor(int rowIndex, int columnIndex) {
        return getColumnByIndex(rowIndex, columnIndex).firstChild().getCssValue("background-color");
    }

    @JDIAction("Get '{name}'s column by index")
    public boolean hasRowWithSpacers(int rowIndex) {
        return getRowByIndex(rowIndex).find(".spacer").isExist();
    }

    private String getClassAttr(UIElement element) {
        return element.attr("class");
    }

    public GridSystemAssert is() {
        return new GridSystemAssert().set(this);
    }

    public GridSystemAssert has() {
        return is();
    }

}
