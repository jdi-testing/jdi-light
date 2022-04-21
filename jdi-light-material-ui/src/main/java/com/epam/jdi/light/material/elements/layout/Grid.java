package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.layout.GridAssert;

/**
 * Represents grid MUI component on GUI.
 *
 *
 * @see <a href="https://mui.com/material-ui/react-grid/">Grid MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 *
 */
public class Grid extends UIBaseElement<GridAssert> {
    protected String itemLocator = ".MuiGrid-item";

    public WebList items() {
        return core().finds(itemLocator)
                .setName(getName() + " webCells");
    }

    @Override
    public GridAssert is() {
        return new GridAssert().set(this);
    }
}
