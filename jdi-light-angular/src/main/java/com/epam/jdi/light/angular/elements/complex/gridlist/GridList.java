package com.epam.jdi.light.angular.elements.complex.gridlist;

import com.epam.jdi.light.angular.asserts.gridlist.GridListAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * To see an example of Grid web element please visit
 * <a href="https://material.angular.io/components/grid-list/overview">Angular Grid list Web Page</a>
 */
public class GridList extends UIListBase<GridListAssert> {

    @JDIAction(value = "Get '{name}' number of columns")
    public int cols() {
        return Integer.parseInt(core().getAttribute("cols"));
    }

    @JDIAction(value = "Get '{name}' row's height")
    public String rowHeight() {
        return core().getAttribute("rowheight");
    }

    @JDIAction(value = "Get '{name}' gutter size in pixels")
    public String gutterSize() {
        return core().getAttribute("guttersize");
    }

    @JDIAction(value = "Get '{name}' tile by index '{0}' (1 based index)")
    public GridTile tileByIndex(int index) {
        return getTiles().collect(Collectors.toList()).get(index - 1);
    }

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }

    public Stream<GridTile> getTiles() {
        return core().finds(".mat-grid-tile").stream()
                .map(e -> new GridTile().setCore(GridTile.class, e));
    }
}
