package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.displaydata.MUIContainerListAssert;
import com.epam.jdi.light.material.interfaces.displaydata.IMUIList;

import java.util.List;

public class MUIContainerList extends UIBaseElement<MUIContainerListAssert> implements IMUIList<UIElement> {

    private static final String ITEM = ".MuiListItem-container";

    @Override
    public List<UIElement> items() {
        return core().finds(ITEM);
    }

    @Override
    public MUIContainerListAssert is() {
        return new MUIContainerListAssert().set(this);
    }
}
