package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.material.asserts.layout.GridListAssert;

/**
 * Represents Grid List MUI component on GUI.
 * <p>
 * Grid lists display a collection of images in an organized grid.
 * </p>
 *
 * @see <a href="https://v3.mui.com/demos/grid-list/#grid-list">Grid List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class GridList extends UIListBase<GridListAssert> {

    public GridListTile tile(int index) {
        return new GridListTile().setCore(GridListTile.class,
                core().find(String.format(".MuiGridListTile-root:nth-child(%d)", index)));
    }

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }
}
