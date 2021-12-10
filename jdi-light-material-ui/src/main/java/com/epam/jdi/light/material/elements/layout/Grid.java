package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.layout.GridAssert;

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