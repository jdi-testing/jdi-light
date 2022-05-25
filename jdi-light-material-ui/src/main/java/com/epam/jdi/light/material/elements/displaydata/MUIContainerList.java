package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.MUIContainerListAssert;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;

import java.util.List;

/**
 * Represents List MUI component on GUI.
 *
 * @see IMUIList
 * @see <a href="https://v4.mui.com/components/lists/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_list">MUI test page</a>
 */

public class MUIContainerList extends UIBaseElement<MUIContainerListAssert> implements IMUIList<MUIButton> {

    private static final String ITEM = ".MuiListItem-container";

    /**
     * Get list of items
     *
     * @return list of items as {@code List<MUIButton>}
     */
    @Override
    public List<MUIButton> items() {
        return core().finds(ITEM).map(el -> new MUIButton().setCore(MUIButton.class, el.base()));
    }

    @Override
    public MUIContainerListAssert is() {
        return new MUIContainerListAssert().set(this);
    }
}
