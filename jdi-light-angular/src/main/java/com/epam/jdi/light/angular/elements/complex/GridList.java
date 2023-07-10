package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.GridListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

/**
 * To see an example of Grid web element please visit
 * <a href="https://material.angular.io/components/grid-list/overview">Angular Grid list Web Page</a>
 */
public class GridList extends UIBaseElement<GridListAssert> {

    @JDIAction("Get '{name}' number of columns")
    public String getNumberOfColumnsInGridList() {
        return core().getAttribute("cols");
    }

    @JDIAction("Get '{name}' row's height")
    public String getRowHeight() {
        return core().getAttribute("rowheight");
    }

    @JDIAction("Get '{name}' cell by index")
    public UIElement getCellByIndex(int index) {
        return finds(".mat-grid-tile").get(index);
    }

    @JDIAction("Get '{name}' cell number of columns ")
    public String getAmountOfColumnsInCell(int index) {
        return getCellByIndex(index).getAttribute("colspan");
    }

    @JDIAction("Get '{name}' cell number of rows")
    public String getAmountOfRowsInCell(int index) {
        return getCellByIndex(index).getAttribute("rowspan");
    }

    @JDIAction("Get '{name}' cell background color")
    public String getCellBackgroundColor(int index) {
        return getCellByIndex(index).getCssValue("background-color");
    }

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }
}
