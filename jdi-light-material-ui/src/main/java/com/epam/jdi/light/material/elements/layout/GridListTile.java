package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.layout.GridListTileAssert;
import com.epam.jdi.light.ui.html.interfaces.HasImage;


public class GridListTile extends UIBaseElement<GridListTileAssert> implements HasImage {

    @JDIAction("Get '{name}' bar")
    public GridListTileBar tileBar() {
        return new GridListTileBar().setCore(GridListTileBar.class, core().find(".MuiGridListTileBar-root"));
    }

    @JDIAction("Get '{name}' subheader")
    public UIElement subheader() {
        return core().find(".MuiListSubheader-root");
    }

    @Override
    public GridListTileAssert is() {
        return new GridListTileAssert().set(this);
    }
}
