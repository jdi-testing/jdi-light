package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.displaydata.MUISimpleListAssert;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;

import java.util.List;

/**
 * Represents simple List MUI component on GUI.
 * <p>Lists are a continuous group of text or images.
 * They are composed of items containing primary and supplemental actions,
 * which are represented by icons and text.</p>
 *
 * @see <a href="https://v4.mui.com/components/lists/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_list">MUI test page</a>
 */
public class MUISimpleList extends UIBaseElement<MUISimpleListAssert> implements IMUIList<UIElement> {

    private static final String item = ".MuiListItem-root";

//    public MUISimpleList(){}
//
//    public MUISimpleList(IBaseElement el) {
//        setCore(MUISimpleList.class, el.base());
//    }

    /**
     * Get list of items
     *
     * @return list of items as {@code List<UIElement>}
     */
    @Override
    public List<UIElement> items() {
        return core().finds(item);
    }

    @Override
    public MUISimpleListAssert is() {
        return new MUISimpleListAssert().set(this);
    }

}
