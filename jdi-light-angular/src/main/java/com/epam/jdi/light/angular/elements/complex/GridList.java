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

    @JDIAction("Get '{name}' cell by index")
    public UIElement tileByIndex(int index) {
        return finds(".mat-grid-tile").get(index);
    }

    @JDIAction("Get '{name}' ")
    public String amountOfColumnsInTile(int index) {
        return tileByIndex(index).getAttribute("colspan");
    }

    @JDIAction("Get '{name}' ")
    public String amountOfRowsInTile(int index) {
        return tileByIndex(index).getAttribute("rowspan");
    }

    @JDIAction("Get '{name}' tile background color")
    public String tileBackgroundColor(int tileIndex) {
        return tileByIndex(tileIndex).getCssValue("background-color");
    }

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }
}
