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

    @JDIAction(value = "Get '{name}' number of columns")
    public int numberOfColumns() {
        return Integer.parseInt(core().getAttribute("cols"));
    }

    @JDIAction(value = "Get '{name}' row's height")
    public String rowHeight() {
        return core().getAttribute("rowheight");
    }

    @JDIAction(value = "Get '{name}' gutter size")
    public String gutterSize() {
        return core().getAttribute("guttersize");
    }

    @JDIAction(value = "Get '{name}' cell by index '{0}'")
    public UIElement cellByIndex(int index) {
        return finds(".mat-grid-tile").get(index);
    }

    @JDIAction(value = "Get '{name}' cell's number of columns by index '{0}'")
    public int numberOfColumnsInCellByIndex(int index) {
        return Integer.parseInt(cellByIndex(index).getAttribute("colspan"));
    }

    @JDIAction(value = "Get '{name}' cell's number of rows by index '{0}'")
    public int numberOfRowsInCellByIndex(int index) {
        return Integer.parseInt(cellByIndex(index).getAttribute("rowspan"));
    }

    @JDIAction(value = "Get '{name}' cell's background color by index '{0}'")
    public String cellBackgroundColorByIndex(int index) {
        return cellByIndex(index).getCssValue("background-color");
    }

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }
}
