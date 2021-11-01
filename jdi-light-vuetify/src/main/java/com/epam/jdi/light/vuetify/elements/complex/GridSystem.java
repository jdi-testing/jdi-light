package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.GridSystemAssert;

import java.util.Arrays;
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
        return getRowByIndex(rowIndex).finds(".col");
    }

    @JDIAction("Get '{name}'s column by index")
    public UIElement getColumnByIndex(int rowIndex, int columnIndex) {
        return getColumnsByRowIndex(rowIndex).get(columnIndex);
    }

    @JDIAction("Get '{name}'s row's vertical alignment")
    private String getRowAlignment(int rowIndex, String alignment) {
        return Arrays.stream(getRowByIndex(rowIndex).attr("class")
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
        return Arrays.stream(getColumnByIndex(rowIndex, columnIndex).attr("class")
                .split("\\s"))
                .filter(s -> s.startsWith("align"))
                .collect(Collectors.joining());
    }

    public GridSystemAssert is() {
        return new GridSystemAssert().set(this);
    }

    public GridSystemAssert has() {
        return is();
    }

}
