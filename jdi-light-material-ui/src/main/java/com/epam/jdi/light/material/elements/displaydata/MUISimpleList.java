package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.MUISimpleListAssert;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.util.List;

/**
 * Represents List MUI component on GUI.
 *
 * @see IMUIList
 * @see <a href="https://v4.mui.com/components/lists/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_list">MUI test page</a>
 */
public class MUISimpleList extends UIBaseElement<MUISimpleListAssert> implements IMUIList<Button> {

    private static final String ITEM = ".MuiListItem-root";

    /**
     * Get list of items
     *
     * @return list of items as {@code List<UIElement>}
     */
    @Override
    public List<Button> items() {
        return core().finds(ITEM).map(el-> new Button().setCore(Button.class, el.base()));
    }

    @Override
    public MUISimpleListAssert is() {
        return new MUISimpleListAssert().set(this);
    }

}
