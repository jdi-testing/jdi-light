package com.epam.jdi.light.material.elements.displaydata.list;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.displaydata.SimpleListAssert;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents List MUI component on GUI.
 *
 * @see IMUIList
 * @see <a href="https://v4.mui.com/components/lists/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_list">MUI test page</a>
 */
public class SimpleList extends UIBaseElement<SimpleListAssert> implements IMUIList<UIElement> {

    private static final String ITEM = ".MuiListItem-root";

    /**
     * Get list of items
     *
     * @return list of items as {@code List<UIElement>}
     */
    @Override
    public List<UIElement> items() {
        return core().finds(ITEM).stream().collect(Collectors.toList());
    }

    @Override
    public SimpleListAssert is() {
        return new SimpleListAssert().set(this);
    }

}
