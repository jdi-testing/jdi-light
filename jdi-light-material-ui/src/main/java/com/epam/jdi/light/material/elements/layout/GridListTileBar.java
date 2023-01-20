package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.layout.GridListTileBarAssert;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.material.interfaces.HasPosition;

public class GridListTileBar extends UIBaseElement<GridListTileBarAssert> implements HasPosition {

    /**
     * Returns the position of the tile bar.
     *
     * @return position of this badge as {@link Position}
     */

    @JDIAction("Get '{name}' title")
    public UIElement title() {
        return core().find(".MuiGridListTileBar-title");
    }

    @JDIAction("Get '{name}' subtitle")
    public UIElement subtitle() {
        return core().find(".MuiGridListTileBar-subtitle");
    }

    @JDIAction("Get '{name}' actionIcon")
    public UIElement actionIcon() {
        return core().find(".MuiGridListTileBar-actionIcon");
    }

    @Override
    @JDIAction("Get '{name}' position")
    public Position position() {
        return Position.fromClasses(core().classes(), "MuiGridListTileBar-titlePosition", "");
    }

    public MUIButton actionButton() {
        return new MUIButton().setCore(MUIButton.class, actionIcon().find("button"));
    }

    @Override
    public GridListTileBarAssert is() {
        return new GridListTileBarAssert().set(this);
    }
}
