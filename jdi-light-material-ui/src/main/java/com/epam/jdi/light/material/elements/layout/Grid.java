package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.layout.GridAssert;

/**
 * Represents grid MUI component on GUI.
 * Grid creates visual consistency between layouts while allowing flexibility across a wide variety of designs.
 * Grid adapts to screen size and orientation, ensuring consistency across layouts.
 * There are two types of layout: containers and items.
 * Item widths are set in percentages, so they're always fluid and sized relative to their parent element.
 * Items have padding to create the spacing between individual items.
 *
 * @see <a href="https://mui.com/material-ui/react-grid/">Grid MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 *
 */
public class Grid extends UIListBase<GridAssert> {

    protected String itemLocator = ".MuiGrid-item";

    /**
     * Finds a list of grid items.
     *
     * @return list of items as {@link WebList}
     */
    public WebList items() {
        return core().finds(itemLocator)
                .setName(getName() + " webCells");
    }

    @Override
    public GridAssert is() {
        return new GridAssert().set(this);
    }
}
